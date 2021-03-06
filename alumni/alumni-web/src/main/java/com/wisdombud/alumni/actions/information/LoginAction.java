package com.wisdombud.alumni.actions.information;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Maps;
import com.opensymphony.xwork2.ActionContext;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseRegisterSrv;
import com.wisdombud.alumni.pojo.dic.DicNational;
import com.wisdombud.alumni.pojo.dic.DicPoliticalStatus;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseRegister;
import com.wisdombud.alumni.pojo.system.PublicUser;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.system.PublicUserSrv;
import com.wisdombud.alumni.system.SecUserSrv;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.threadlocal.UserThreadLocal;

import common.toolkit.java.constant.ResultConstant;
import common.toolkit.java.struts2.AbstractCommonAction;
import common.toolkit.java.util.StringUtil;

/**
 * 功能: 登陆<br/>
 * date: 2017-4-11 9:17:00 <br/>
 *
 * @author zxguan
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace("/")
@Results({ @Result(name = "register", location = "/WEB-INF/jsp/portal/alumni-login/register.jsp") })
public class LoginAction extends AbstractCommonAction {

	private static final long		 serialVersionUID = 1L;
	private static final String		 ADMIN_LOGIN_URL  = "/admin-user";
	private static final String		 ALUMNI_lOGIN_URL = "/alumni-user";

	@Autowired
	private PublicUserSrv			 pSrv;
	@Autowired
	private BaseRegisterSrv			 registerSrv;
	@Autowired
	private SecUserSrv				 sSrv;
	@Autowired
	public DicCommonSrv				 dicCommonSrv;

	private String					 loginName;
	private String					 password;
	private String					 type;
	private String					 id;
	private String					 alumnid;
	private BaseRegister			 register;
	private List<DicNational>		 dicNationalList;
	private List<DicPoliticalStatus> dicPoliticalStatusList;

	@Override
	public String execute() throws Exception {
		return ResultConstant.TO_HOME;
	}

	/**
	 * @DES:查询帐号存在否
	 * @autor:xiefei<br/>
	 */
	public void findEmailIsUse() {
		List<PublicUser> user = pSrv.findBy("loginName", loginName);
		if (CollectionUtils.isNotEmpty(user)) {
			sendSuccessMsg("", "帐号已存在");
		} else {
			sendFailMsg("", "'");
		}
	}

	/**
	 * @DES:登录
	 */
	public void login() {
		if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password)) {
			sendFailMsg("", "用户名或密码为空");
			return;
		}
		PublicUser user = pSrv.findUniqueBy(this.buildParamMap(), new ArrayList<Order>());
		List<BaseRegister> registerList = registerSrv.findBy(this.buildRegisterParam());
		if (null == user && registerList.size() == 0) {
			sendFailMsg("", "用户名不存在");
			return;
		}
		if (null == user && registerList.size() > 0) {
			sendFailMsg("", "账号审核中");
			return;
		}
		if (!user.getPwdHash().equals(StringUtil.encrypt(this.password.trim() + user.getSalt()))) {
			sendFailMsg("", "密码错误");
			return;
		}
		String url = this.type.equals(String.valueOf(Constants.ADMIN_LOGIN_URL)) ? ADMIN_LOGIN_URL : ALUMNI_lOGIN_URL;
		addSession(user);
		addCookie();
		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("url", url);
		result.put("success", "success");
		sendSuccessMsg(result, "");
	}

	/**
	 * @DES:注册
	 * @autor:xiefei<br/>
	 */
	@Action(value = "/user-register")
	public String toRegister() {
		return "register";
	}

	/**
	 * @DES:注册
	 * @autor:xiefei<br/>
	 */
	public void saveRegister() {
		if (register == null) {
			sendFailMsg("", "");
			return;
		}
		register.setLoginName(register.getEmail());
		register.setCreateTime(new Date());
		register.setStatus(Constants.FLOW_START);
		registerSrv.save(register);
		List<BaseAlumni> list = registerSrv.matchingAlumni(register.getName(), register.getEnrollYear());
		sendSuccessMsg(list, register.getId());
	}

	public void updateRegister() {
		if (org.apache.commons.lang3.StringUtils.isBlank(id) || org.apache.commons.lang3.StringUtils.isBlank(alumnid)) {
			sendFailMsg("", "");
			return;
		}
		BaseRegister re = registerSrv.find(id);
		re.setAlumnid(alumnid);
		registerSrv.update(re);
		sendSuccessMsg();
	}

	private Map<String, Object> buildParamMap() {
		Map<String, Object> params = Maps.newHashMap();
		if (StringUtils.isNotBlank(loginName)) {
			params.put("loginName", loginName.trim());
		}
		if (StringUtils.isNotBlank(type)) {
			params.put("designation", Integer.valueOf(type));
		}
		return params;
	}

	private Map<String, Object> buildRegisterParam() {
		Map<String, Object> params = Maps.newHashMap();
		if (StringUtils.isNotBlank(loginName)) {
			params.put("loginName", loginName.trim());
		}
		return params;
	}

	private void addSession(final PublicUser pUser) {
		ActionContext.getContext().getSession().put("loginName", pUser.getLoginName());
		final UserSession userSession = new UserSession();
		SecUser sUser = sSrv.find(pUser.getId());
		userSession.setId(pUser.getId());
		userSession.setLoginName(pUser.getLoginName());
		userSession.setUserName((null != sUser && null != sUser.getName()) ? sUser.getName() : pUser.getLoginName());
		userSession.setSessionId(ServletActionContext.getRequest().getSession().getId());
		userSession.setDesignation(pUser.getDesignation());
		userSession.setIsAdmin(null == sUser ? 0 : sUser.getIsAdmin());
		ActionContext.getContext().getSession().put("UserSession", userSession);
		UserThreadLocal.setUserSession(userSession);
	}

	private void addCookie() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Cookie loginNameCookie = new Cookie("loginName", null == this.loginName ? "" : this.loginName);
		Cookie passwordCookie = new Cookie("password", null == this.password ? "" : password);
		// if (rememberme.equals(Constants.REMENBER_ME)) {
		// passwordcookie.setMaxAge(60 * 60 * 24 * 7);
		// userNamecookie.setMaxAge(60 * 60 * 24 * 7);
		// } else {
		// userNamecookie.setMaxAge(0);
		// passwordcookie.setMaxAge(0);
		// }
		ServletActionContext.getResponse().addCookie(loginNameCookie);
		ServletActionContext.getResponse().addCookie(passwordCookie);
		response.addCookie(loginNameCookie);
		response.addCookie(passwordCookie);
	}

	public String userExit() {
		final HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginName");
		session.removeAttribute("UserSession");
		session.invalidate();
		UserThreadLocal.setUserSession(null);
		return ResultConstant.TO_HOME;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BaseRegister getRegister() {
		return register;
	}

	public void setRegister(BaseRegister register) {
		this.register = register;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlumnid() {
		return alumnid;
	}

	public void setAlumnid(String alumnid) {
		this.alumnid = alumnid;
	}

	public List<DicNational> getDicNationalList() {
		return dicNationalList;
	}

	public void setDicNationalList(List<DicNational> dicNationalList) {
		this.dicNationalList = dicNationalList;
	}

	public List<DicPoliticalStatus> getDicPoliticalStatusList() {
		return dicPoliticalStatusList;
	}

	public void setDicPoliticalStatusList(List<DicPoliticalStatus> dicPoliticalStatusList) {
		this.dicPoliticalStatusList = dicPoliticalStatusList;
	}

}
