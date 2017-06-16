package com.wisdombud.alumni.actions.system;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.wisdombud.alumni.actions.base.AlumniBaseAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.system.PublicUser;
import com.wisdombud.alumni.system.PublicUserSrv;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.threadlocal.UserThreadLocal;

import common.toolkit.java.util.StringUtil;

/**
 * 系统修改密码<br>
 * 
 * @author myzhai
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toHome", location = "/WEB-INF/jsp/portal/index2.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/system/modify-password/page.jsp"), })
public class SystemModifyPasswordAction extends AlumniBaseAction<PublicUser> {
	public SystemModifyPasswordAction(@Qualifier(value = "publicUserSrv") IBaseSrv<PublicUser> baseSrv) {
		super(baseSrv);
	}
	private static final long serialVersionUID = 1L;

	@Autowired
	private PublicUserSrv	  publicUserSrv;

	private String			  oldPwd;
	private String			  newPwd;
	private String			  loginName;

	public void changePwd() {
		UserSession userSesson = getUserSession();
		loginName = userSesson.getLoginName();
		if (loginName != null) {
			PublicUser user = publicUserSrv.findUniqueBy("loginName", loginName);
			String encryptOldPwd = StringUtil.encrypt(this.oldPwd.trim() + user.getSalt());
			if (encryptOldPwd.equals(user.getPwdHash())) {
				user.setPwdHash(StringUtil.encrypt(this.newPwd.trim() + user.getSalt()));
				user.setCreateTime(new Date());
				publicUserSrv.save(user);
				this.sendSuccessMsg("", "密码修改成功");
			} else {
				this.sendFailMsg("", "原密码错误");
			}
		}
	}

	public void userExit() {
		final HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginName");
		session.removeAttribute("UserSession");
		session.invalidate();
		UserThreadLocal.setUserSession(null);
		sendSuccessMsg();
	}
	
	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
