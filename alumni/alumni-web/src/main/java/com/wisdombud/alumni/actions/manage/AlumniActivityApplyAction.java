package com.wisdombud.alumni.actions.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseAlumniActivityApplySrv;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivityApply;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;

/**
 * 功能: 校友活动申请表<br/>
 * date: 2017-3-28 19:28:27 <br/>
 *
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("basealumniactivityapply")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/library-tube/storehouse-management/create-storehouse-management.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/flow-audit/activity-audit/detail.jsp"),
		   @Result(name = "toActivityAudit", location = "/WEB-INF/jsp/flow-audit/activity-audit/page.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/portal/alumni-login/launch-event/list.jsp") })
public class AlumniActivityApplyAction extends AbstractCrudAction<BaseAlumniActivityApply> {
	private static final long		   serialVersionUID	= 1L;

	@Autowired
	private BaseAlumniActivityApplySrv baseAlumniActivityApplySrv;
	@Autowired
	private BaseAlumniSrv alumniSrv;

	private Integer					   auditStatus;

	
	public AlumniActivityApplyAction(
			@Qualifier(value = "baseAlumniActivityApplySrv") IBaseSrv<BaseAlumniActivityApply> baseSrv) {
		super(baseSrv);
	}
 
	public void myApplyActivity(){
		if(StringUtils.isNotBlank(id)){
			List<BaseAlumniActivityApply> baseAlumniActivityApplyLists = baseAlumniActivityApplySrv.findBy("person", this.id);
			sendResponseMsg(baseAlumniActivityApplyLists);
		}
	}
	@Override
	protected List<Order> buildOrder() {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(Order.desc("createTime"));
		return orderList;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> parms = new HashMap<String, Param>();
		parms.put("person", Param.eq(this.id));
		return parms;
	}

	@Override
	public void page() {
		if (StringUtils.isNotBlank(this.id)) {
			super.page();
		}
	}

	public Map<String, Param> buildActivityAuditParms() {
		Map<String, Param> parms = new HashMap<String, Param>();
		if (this.entity != null && this.entity.getTitle() != null) {
			parms.put("title", Param.like(this.entity.getTitle()));
		}
		return parms;
	}

	public List<Order> buildAcivityAuditOrder() {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(Order.desc("createTime"));
		orderList.add(Order.desc("auditTime"));
		return orderList;
	}

	/**
	 * @DES:校友活动审核
	 */
	public void activityAuditPage() {
		this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
		pageEntity = new PageEntity<>(start, limit);
		this.baseSrv.page(pageEntity, this.buildActivityAuditParms(), this.buildAcivityAuditOrder());
		this.sendResponseMsg(pageEntity);
	}

	public String doAudit() {
		final UserSession userSession = (UserSession) ActionContext.getContext().getSession().get("UserSession");
		if (StringUtils.isNotBlank(this.id) && userSession != null) {
			String uerId = userSession.getId();
			if (StringUtils.isNotBlank(uerId))
			this.baseAlumniActivityApplySrv.updateAudit(this.id, auditStatus, uerId);
		}
		return "toActivityAudit";
	}

	public String hrefActvityAudit() {
		return "toActivityAudit";
	}

	public String hrefActivityAuditDetail() {
		if (StringUtils.isNotBlank(this.id)) {
			this.entity = this.baseSrv.find(this.id);
			this.entity.setPerson(this.alumniSrv.find(entity.getPerson()).getName());
		}
		return "toDetail";
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

}
