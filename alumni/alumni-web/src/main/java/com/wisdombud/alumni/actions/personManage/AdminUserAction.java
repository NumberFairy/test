package com.wisdombud.alumni.actions.personManage;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.pojo.system.SecOper;
import com.wisdombud.alumni.system.SecOperSrv;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.vo.MenuVo;

import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能：管理员操作菜单<br>
 *
 * @author zxguan
 */
@Scope("prototype")
@ParentPackage(value = "struts-default-authority")
@Namespace(value = "/")
@Results({ @Result(name = "admin", location = "/WEB-INF/jsp/admin.jsp") })
public class AdminUserAction extends AbstractCommonAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private SecOperSrv		  operSrv;

	@Override
	public String execute() throws Exception {
		return "admin";
	}

	public void findUserMenus() {
		if (isAjaxRequest()) {
			UserSession userSession = (UserSession) session.get("UserSession");
			List<SecOper> operList = operSrv.findOperListByUserId(userSession.getId());
			Gson gson = new GsonBuilder().create();
			List<MenuVo> menuVoList = operSrv.transform2MenuVo(operSrv.transform2OperMap(operList));
			sendResponseMsg(gson.toJson(menuVoList));
		}
	}
}
