package com.wisdombud.alumni.actions.manage;

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
import com.wisdombud.alumni.manage.BaseActivitySignUpSrv;
import com.wisdombud.alumni.manage.BaseAlumniActivityApplySrv;
import com.wisdombud.alumni.pojo.manage.BaseActivitySignUp;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivityApply;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 报名情况表<br/>
 * date: 2017-3-28 19:28:27 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("baseactivitysignup")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/library-tube/storehouse-management/create-storehouse-management.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/library-tube/storehouse-management/storehouse-management-detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/longtime-borrow-return/list.jsp"),
		   @Result(name = "enrollmentSituation", location = "/WEB-INF/jsp/portal/alumni-login/launch-event/enrollment-situation.jsp")})
public class ActivitySignUpAction extends AbstractCrudAction<BaseActivitySignUp> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BaseActivitySignUpSrv		baseActivitySignUpSrv;
	@Autowired
	private BaseAlumniActivityApplySrv		baseAlumniActivityApplySrv;
	private String 						activityId;
	private String						activityName;
	public ActivitySignUpAction(@Qualifier(value = "baseActivitySignUpSrv") IBaseSrv<BaseActivitySignUp> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String,Param> params=new HashMap<String,Param>();
		params.put("activityId", Param.eq(this.id));
		return params;
	}
	
	public String hrefAlumniActivityPage(){
		if(StringUtils.isNotBlank(this.activityId)){
    		BaseAlumniActivityApply baseAlumniActivityApply=this.baseAlumniActivityApplySrv.find(this.activityId);
    		if(baseAlumniActivityApply!=null&&baseAlumniActivityApply.getTitle()!=null){
    			this.activityName=baseAlumniActivityApply.getTitle();
    		}
		}
		return "enrollmentSituation";
	}
	
	public void alumniActivityPage(){
		if(StringUtils.isNotBlank(this.id)){
			this.buildParams();
			super.page();
		}
	}
	
	public void findMyActivities(){
		if(StringUtils.isNotEmpty(this.id)){
			List<BaseAlumniActivity> alumniActivities=baseActivitySignUpSrv.findMyActivities(this.id);
		}
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

}
