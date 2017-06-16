package com.wisdombud.alumni.actions.system;

import java.util.ArrayList;
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
import com.wisdombud.alumni.pojo.system.SecRole;
import com.wisdombud.alumni.system.SecOperSrv;
import com.wisdombud.alumni.system.SecRoleSrv;

import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 权限角色关联<br/>
 * 
 * @author cczhao
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toPage", location = "/WEB-INF/jsp/system/user-manage/page.jsp"), })
public class SecOperAction extends AbstractCommonAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private SecOperSrv		  operSrv;
	@Autowired
	private SecRoleSrv roleSrv;
	private String			  userId;
	private String			  roleId;
	private String			  operIdArray;

	// 角色菜单表数据更新
	public void saveRoleOper() {
		operSrv.updateconfigureAuthority(roleId, operIdArray);
		this.sendSuccessMsg();
	}

	/**
	 * @DES:查找所有菜单
	 * @autor:xiefei<br/>
	 */
	public void findAllMenus() {
		List<SecOper> operList = operSrv.findAll();
		List<SecOper> userOper = new ArrayList<>();
		//查询当前角色的菜单
		SecRole role=	roleSrv.find(userId);
		if (role != null) {
			userOper.addAll(role.getSecOpers());
		}
		final Gson g = new GsonBuilder().create();
		this.sendResponseMsg(g.toJson(operSrv.buildOperTree(operList, userOper)));
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOperIdArray() {
		return operIdArray;
	}

	public void setOperIdArray(String operIdArray) {
		this.operIdArray = operIdArray;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
