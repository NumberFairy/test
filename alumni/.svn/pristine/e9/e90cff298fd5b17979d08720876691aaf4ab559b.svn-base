package com.wisdombud.alumni.actions.gateway;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.pojo.system.HomeMenu;
import com.wisdombud.alumni.system.HomeMenuSrv;

import common.toolkit.java.entity.DateFormat;
import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 门户菜单管理<br/>
 * date: 2017-3-28 19:28:27 <br/>
 * 
 * @author xiefei
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "tree", location = "/WEB-INF/jsp/gateway-menu-manage/home-menu.jsp") })
public class HomeMenuManageAction extends AbstractCommonAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HomeMenuSrv		  srv;

	private HomeMenu		  entity;
	private Integer			  menuId;

	@Override
	public String execute() throws Exception {
		return "tree";
	}

	public void saveOrUpdate() {
		if (entity == null || entity.getParentId() == null) {
			sendFailMsg("", "");
			return;
		}
		srv.saveOrUpdate(entity);
		sendSuccessMsg();
	}

	public void del() {
		if (menuId == null) {
			sendFailMsg("", "");
			return;
		}
		srv.deleteBy("menuId", menuId);
		sendSuccessMsg();
	}

	public void tree() {
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(srv.buildTree()));
	}

	public HomeMenu getEntity() {
		return entity;
	}

	public void setEntity(HomeMenu entity) {
		this.entity = entity;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
