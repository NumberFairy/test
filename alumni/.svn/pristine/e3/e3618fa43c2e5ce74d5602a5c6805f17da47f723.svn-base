package com.wisdombud.alumni.actions.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseRegisterSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseRegister;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.threadlocal.UserThreadLocal;
import com.wisdombud.alumni.vo.Param;

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
@Results({ @Result(name = "toPage", location = "/WEB-INF/jsp/flow-audit/alumni-register-audit/page.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/flow-audit/alumni-register-audit/detail.jsp"), })
public class AlumniRegisterAction extends AbstractCrudAction<BaseRegister> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BaseRegisterSrv	  srv;
	@Autowired
	private BaseAlumniSrv	  alumniSrv;
	private String			  alumnid;
	private String			  key;
	private Integer			  status;
	private BaseAlumni		  alumni;

	public AlumniRegisterAction(@Qualifier(value = "baseRegisterSrv") IBaseSrv<BaseRegister> baseSrv) {
		super(baseSrv);
	}

	@Override
	public void initConf() {
		if (entity != null && StringUtils.isNotBlank(entity.getAlumnid())) {
			alumni = alumniSrv.find(entity.getAlumnid());
		}
	}

	/**
	 * @DES:校友注册审核
	 * @autor:xiefei<br/>
	 */
	public void aduit() {
		if (StringUtils.isBlank(id) || status == null) {
			sendFailMsg("", "");
			return;
		}
		UserSession session = UserThreadLocal.getUserSession();
		BaseRegister v = baseSrv.find(id);
		v.setStatus(status);
		v.setAuditor(session != null ? session.getId() : "1");
		UserSession sessiom = UserThreadLocal.getUserSession();
		if (sessiom != null) {
			v.setAuditor(sessiom.getId());
		}
		baseSrv.update(v);
		if (status == Constants.PASS_TYPE) {
			if (StringUtils.isNotBlank(alumnid)) {
				v.setAlumnid(alumnid);
			}
			srv.addOrUpdateAlumni(v);
		}
		sendSuccessMsg();
	}

	@Override
	protected List<Order> buildOrder() {
		List<Order> list = new ArrayList<>();
		list.add(Order.asc("status"));
		list.add(Order.desc("createTime"));
		return list;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> map = new HashMap<>();
		if (StringUtils.isNotBlank(key)) {
			map.put("name", Param.like(key));
		}
		return map;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BaseAlumni getAlumni() {
		return alumni;
	}

	public void setAlumni(BaseAlumni alumni) {
		this.alumni = alumni;
	}

	public String getAlumnid() {
		return alumnid;
	}

	public void setAlumnid(String alumnid) {
		this.alumnid = alumnid;
	}

}
