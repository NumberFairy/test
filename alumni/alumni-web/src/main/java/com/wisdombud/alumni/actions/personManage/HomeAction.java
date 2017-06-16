package com.wisdombud.alumni.actions.personManage;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.enums.AuditEnum;
import com.wisdombud.alumni.enums.ReplyEnum;
import com.wisdombud.alumni.manage.BaseActivitySignUpSrv;
import com.wisdombud.alumni.manage.BaseMessageBoardSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;
import com.wisdombud.alumni.pojo.system.HomeMenu;
import com.wisdombud.alumni.system.HomeMenuSrv;

import common.toolkit.java.entity.DateFormat;
import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 门户菜单<br>
 * 门户菜单均根据menuId获取数据<br>
 * 菜单数据通过HomeMenu.url<br>
 * ROOT菜单默认获取其第一个子菜单数据<br>
 *
 * @author xiefei
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "home", location = "/WEB-INF/jsp/portal/index2.jsp"),
		   @Result(name = "list", location = "/WEB-INF/jsp/portal/list.jsp"),
		   @Result(name = "detail", location = "/WEB-INF/jsp/portal/detail.jsp"),
		   @Result(name = "changePassword", location = "/WEB-INF/jsp/portal/alumni-login/change-password.jsp"),
		   @Result(name = "launchEvent", location = "/WEB-INF/jsp/portal/alumni-login/launch-event/list.jsp"),
		   @Result(name = "mylaunchEvent", location = "/WEB-INF/jsp/portal/alumni-login/launch-event/launch-event.jsp"),
		   @Result(name = "enrollmentSituation", location = "/WEB-INF/jsp/portal/alumni-login/launch-event/enrollment-situation.jsp"),
		   @Result(name = "myActivity", location = "/WEB-INF/jsp/portal/alumni-login/my-activity.jsp"),
		   @Result(name = "myAlumniAssociation", location = "/WEB-INF/jsp/portal/alumni-login/my-alumni-association/list.jsp"),
		   @Result(name = "myAlumniCreate", location = "/WEB-INF/jsp/portal/alumni-login/my-alumni-association/create.jsp"), })
public class HomeAction extends AbstractCommonAction {
	private static final long	  serialVersionUID = 1L;

	@Autowired
	private HomeMenuSrv			  srv;
	@Autowired
	private BaseActivitySignUpSrv baseActivitySignUpSrv;
	@Autowired
	private BaseMessageBoardSrv	  baseMessageBoardSrv;

	private Integer				  menuId;
	private HomeMenu			  menu;
	private String				  id;
	private BaseMessageBoard	  msg;

	@Override
	public String execute() throws Exception {
		return "home";
	}

	/**
	 * @DES:导航栏菜单
	 * @autor:xiefei<br/>
	 */
	public void homeMenus() {
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(srv.updatebuildHomeTree()));
	}

	/**
	 * @DES:左侧菜单
	 * @autor:xiefei<br/>
	 */
	public void leftMenus() {
		if (menuId == null) {
			sendFailMsg("", "");
			return;
		}
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(srv.findLeftMenu(menuId)));
	}

	/**
	 * @DES:保存留言
	 * @autor:xiefei<br/>
	 */
	public void saveMessageBoard() {
		if (msg == null) {
			sendFailMsg("", "");
			return;
		}
		msg.setStatus(AuditEnum.NOTAUDIT.getValue());
		msg.setCreateTime(new Date());
		msg.setOperation(0);
		msg.setIsReply(ReplyEnum.NOTREPLY.getValue());
		baseMessageBoardSrv.save(msg);
		sendSuccessMsg();
	}

	/**
	 * @DES:判断是列表还是详情
	 * @autor:xiefei<br/>
	 */
	public String load() {
		if (menuId == null) {
			return "home";
		}
		menu = srv.findUniqueBy("menuId", menuId);
		if (StringUtils.isNotBlank(id)) {
			return "detail";
		}
		if (menu == null) {
			return "home";
		}
		// 根节点菜单，选中子节点的第一个节点
		if (menu.getParentId() == HomeMenu.ROOT) {
			List<HomeMenu> menus = srv.findChildrenMenu(menuId);
			if (CollectionUtils.isNotEmpty(menus)) {
				menu = menus.get(0);
				if (menu != null) {
					menuId = menus.get(0).getMenuId();
				}
			}
		}
		if (menu.getType() == HomeMenu.TYPE_LIST) {
			return "list";
		}
		if (menu.getType() == HomeMenu.TYPE_DETAIL) {
			return "detail";
		}
		return "home";
	}

	public String list() {
		return "list";
	}

	public String changePassword() {
		return "changePassword";
	}

	public String launchEvent() {
		return "launchEvent";
	}

	public String mylaunchEvent() {
		return "mylaunchEvent";
	}

	public String enrollmentSituation() {
		return "enrollmentSituation";
	}

	public void myActivity() {
		if (StringUtils.isNotEmpty(this.id)) {
			List<BaseAlumniActivity> alumniActivities = this.baseActivitySignUpSrv.findMyActivities(this.id);
			final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
			this.sendResponseMsg(g.toJson(alumniActivities));
		}
	}

	public String hrefMyActivity() {
		return "myActivity";
	}

	public String myAlumniAssociation() {
		return "myAlumniAssociation";
	}

	public String myAlumniCreate() {
		return "myAlumniCreate";
	}

	//
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public HomeMenu getMenu() {
		return menu;
	}

	public void setMenu(HomeMenu menu) {
		this.menu = menu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseMessageBoard getMsg() {
		return msg;
	}

	public void setMsg(BaseMessageBoard msg) {
		this.msg = msg;
	}

}
