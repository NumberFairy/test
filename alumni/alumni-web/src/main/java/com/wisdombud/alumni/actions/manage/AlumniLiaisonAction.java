package com.wisdombud.alumni.actions.manage;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniLiaison;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友联络员表<br/>
 * date: 2017-3-29 15:36:11 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/alumni-manage-center/liaison-manage/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/alumni-manage-center/liaison-manage/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-manage-center/liaison-manage/page.jsp") })
public class AlumniLiaisonAction extends AbstractCrudAction<BaseAlumniLiaison> {
	private static final long		serialVersionUID = 1L;


	public AlumniLiaisonAction(@Qualifier(value = "baseAlumniLiaisonSrv") IBaseSrv<BaseAlumniLiaison> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

	@Override
	protected Map<String, Param> buildParams() {
		return super.buildParams();
	}

}
