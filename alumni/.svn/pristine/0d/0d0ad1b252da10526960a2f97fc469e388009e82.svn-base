package com.wisdombud.alumni.actions.manage;

import java.util.ArrayList;
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

import com.google.common.collect.Maps;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.HomeInformationReleaseSrv;
import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;
import com.wisdombud.alumni.pojo.system.HomeMenu;
import com.wisdombud.alumni.system.HomeMenuSrv;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;

/**
 * 功能: 信息发布管理<br/>
 * date: 2017-4-8 11:50:08 <br/>
 *
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/gateway-menu-manage/home-information-release/create.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/gateway-menu-manage/home-information-release/page.jsp") })
public class HomeInformationReleaseAction extends AbstractCrudAction<HomeInformationRelease> {
	private static final long		  serialVersionUID = 1L;

	@Autowired
	private HomeInformationReleaseSrv srv;
	@Autowired
	private HomeMenuSrv				  menuSrv;

	private List<HomeMenu>			  menus;

	public HomeInformationReleaseAction(
			@Qualifier(value = "homeInformationReleaseSrv") IBaseSrv<HomeInformationRelease> baseSrv) {
		super(baseSrv);
	}

	@Override
	public void page() {
		if (this.isAjaxRequest()) {
			this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
			pageEntity = new PageEntity<>(start, limit);
			srv.page(pageEntity, this.buildParams(), buildOrder());
			sendResponseMsg(pageEntity);
		}
	}

	@Override
	public String hrefAddOrUpdate() {
		if (StringUtils.isNotBlank(id)) {
			entity = srv.find(id);
		}
		return super.hrefAddOrUpdate();
	}

	public void findAllMenus() {
		if (isAjaxRequest()) {
			menus = menuSrv.buildInfoTree();
			for (HomeMenu pMenu : menus) {
				pMenu.setChildren(menuSrv.findChildrenMenu(pMenu.getMenuId()));
			}
			sendResponseMsg(menus);
		}
	}

	@Override
	public void addOrUpdate() {
		srv.addOrUpdate(entity);
		sendSuccessMsg();
	}

	@Override
	protected List<Order> buildOrder() {
		List<Order> orders = new ArrayList<>();
		orders.add(Order.desc("isEnable"));
		orders.add(Order.desc("isTop"));
		orders.add(Order.desc("createTime"));
		return orders;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params = Maps.newHashMap();
		if (this.entity != null) {
			if (StringUtils.isNotEmpty(this.entity.getTitle())) {
				params.put("title", Param.like(this.entity.getTitle()));
			}
			if (StringUtils.isNotEmpty(this.entity.getPublisher())) {
				params.put("publisher", Param.like(this.entity.getPublisher()));
			}
			if (this.entity.getIsEnable() != -1) {
				params.put("isEnable", Param.eq(this.entity.getIsEnable()));
			}
		}
		return params;
	}

	public List<HomeMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<HomeMenu> menus) {
		this.menus = menus;
	}

}
