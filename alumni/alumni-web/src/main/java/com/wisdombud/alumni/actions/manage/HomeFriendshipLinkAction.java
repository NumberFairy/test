package com.wisdombud.alumni.actions.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.HomeFriendshipLink;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 友情链接信息管理<br/>
 * date: 2017-4-14 17:59:39 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/gateway-menu-manage/friendship-link-information/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/library-tube/storehouse-management/storehouse-management-detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/gateway-menu-manage/friendship-link-information/page.jsp") })
public class HomeFriendshipLinkAction extends AbstractCrudAction<HomeFriendshipLink> {
	private static final long serialVersionUID = 1L;

	public HomeFriendshipLinkAction(@Qualifier(value = "homeFriendshipLinkSrv") IBaseSrv<HomeFriendshipLink> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		List<Order> orderList=Lists.newArrayList();
		orderList.add(Order.asc("sortFlag"));
		return orderList;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params=new HashMap<String,Param>();
		if(this.entity!=null&&this.entity.getName()!=null){
			params.put("name", Param.like(this.entity.getName()));
		}
		return params;
	}

}
