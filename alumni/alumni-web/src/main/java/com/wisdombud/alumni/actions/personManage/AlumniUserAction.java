package com.wisdombud.alumni.actions.personManage;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseAlumniClubSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranch;
import com.wisdombud.alumni.vo.AlumniBranchVo;
import common.toolkit.java.entity.PageEntity;

/**
 * 功能：校友操作界面<br>
 *
 * @author zxguan
 */
@Scope("prototype")
@ParentPackage(value = "struts-default-authority")
@Namespace(value = "/")
@Results({@Result(name = "alumni", location = "/WEB-INF/jsp/portal/alumni-login/person-home.jsp"),
		  @Result(name = "opticalAxis", location = "/WEB-INF/jsp/portal/alumni-login/optical-axis.jsp"),
		  @Result(name = "myAlumniAssociation", location = "/WEB-INF/jsp/portal/alumni-login/my-alumni-association/list.jsp")})
public class AlumniUserAction extends AbstractCrudAction<BaseAlumniBranch> {

	private static final long serialVersionUID = 1L;

	public AlumniUserAction(@Qualifier(value = "baseAlumniClubSrv") IBaseSrv<BaseAlumniBranch> baseSrv) {
		super(baseSrv);
	}

	@Autowired
	private BaseAlumniClubSrv 				srv;

	private PageEntity<AlumniBranchVo> 		pageBranchVo;

	@Override
	public String execute() throws Exception {
		return "alumni";
	}
	
	public String myAlumniAssociation() {
		return "myAlumniAssociation";
	}

	public void pageMyBranch() {
		if (this.isAjaxRequest()) {
			this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
			pageBranchVo = new PageEntity<>(start, limit);
    		srv.pageMyBranchVo(pageBranchVo, getUserSession());
    		sendResponseMsg(pageBranchVo);
		}
	}
	public String opticalAxis() {
		return "opticalAxis";
	}
}
