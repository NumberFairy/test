package com.wisdombud.alumni.actions.manage;

import java.util.List;

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
import com.wisdombud.alumni.manage.BaseAlumniClubApplySrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchApply;

/**
 * 功能: 校友入会申请表<br/>
 * date: 2017-3-28 19:28:27 <br/>
 *
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("basealumniclubapply")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toPage", location = "/WEB-INF/jsp/flow-audit/alumni-club/page.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/flow-audit/alumni-club/detail.jsp") })
public class AlumniClubApplyAction extends AbstractCrudAction<BaseAlumniBranchApply> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BaseAlumniClubApplySrv srv;

	public AlumniClubApplyAction(@Qualifier(value = "baseAlumniClubApplySrv") IBaseSrv<BaseAlumniBranchApply> baseSrv) {
		super(baseSrv);
	}



	public void passFlow() {
		if (isAjaxRequest()) {
			srv.savePassFlowStatus(this.id);
			sendSuccessMsg();
		}
	}

	public void unPassFlow() {
		if (isAjaxRequest()) {
			srv.saveUnpassFlowStatus(this.id);
			sendSuccessMsg();
		}
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

}
