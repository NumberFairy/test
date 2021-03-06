package com.wisdombud.alumni.actions.information;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseActivitySignUpSrv;
import com.wisdombud.alumni.manage.BaseAlumniActivitySrv;
import com.wisdombud.alumni.manage.BaseMessageBoardSrv;
import com.wisdombud.alumni.manage.HomeFriendshipLinkSrv;
import com.wisdombud.alumni.manage.HomeInformationReleaseSrv;
import com.wisdombud.alumni.manage.HomeNewsPicSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;
import com.wisdombud.alumni.pojo.manage.HomeFriendshipLink;
import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;
import com.wisdombud.alumni.pojo.manage.HomeNewsPic;
import com.wisdombud.alumni.pojo.system.HomeMenu;
import com.wisdombud.alumni.system.HomeMenuSrv;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;

/**
 * @author xiefei
 *         门户，微信，使用的接口
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({})
public class HomeApiAction extends AbstractCrudAction<HomeInformationRelease> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private HomeInformationReleaseSrv homeInformationReleaseSrv;
	@Autowired
	private BaseMessageBoardSrv		  baseMessageBoardSrv;
	@Autowired
	private HomeNewsPicSrv			  picSrv;
	@Autowired
	private BaseAlumniActivitySrv	  activitySrv;
	@Autowired
	private HomeMenuSrv				  srv;
	@Autowired
	private BaseActivitySignUpSrv	  baseActivitySignUpSrv;
	@Autowired
	private HomeFriendshipLinkSrv	  homeFriendshipLinkSrv;

	private Integer	menuId;
	private String	isPc;

	public HomeApiAction(@Qualifier(value = "homeInformationReleaseSrv") IBaseSrv<HomeInformationRelease> baseSrv) {
		super(baseSrv);
	}

	/**
	 * 新闻类
	 *
	 * @author xiefei
	 */
	public void pageHomeInfo() {
		PageEntity<HomeInformationRelease> pageEntity = getPage();
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("isTop"));
		orders.add(Order.desc("createTime"));
		homeInformationReleaseSrv.page(pageEntity, buildParams(), orders);
		sendResponseMsg(pageEntity);
	}

	/**
	 * @DES:活动列表
	 * @autor:xiefei<br/>
	 */
	public void pageActiveInfo() {
		PageEntity<HomeInformationRelease> pageEntity = getPage();
		activitySrv.pageHomeActive(pageEntity, menuId + "");
		sendResponseMsg(pageEntity);
	}

	/**
	 * 轮播图
	 *
	 * @author xiefei
	 */
	public void slider() {
		Map<String, Param> parm = new HashMap<>();
		parm.put("isPc", Param.eq(isPc));
		parm.put("picState", Param.eq(HomeNewsPic.PICSTATE_YES));

		List<Order> oList = new ArrayList<>();
		oList.add(Order.asc("sortFlag"));

		List<HomeNewsPic> list = picSrv.findBy(parm, oList);
		sendResponseMsg(list);
	}

	/**
	 * 友情链接
	 * 
	 * @author xiefei
	 */
	public void homeFriendshipLink() {
		Map<String, Param> parm = new HashMap<>();
		parm.put("isEnable", Param.eq(Constants.YES));
		List<Order> orderList = Lists.newArrayList();
		orderList.add(Order.asc("sortFlag"));
		List<HomeFriendshipLink> list = homeFriendshipLinkSrv.findBy(parm, orderList);
		sendResponseMsg(list);
	}

	/**
	 * 留言板
	 *
	 * @author xiefei
	 */
	public void pageMessageBoard() {
		PageEntity<BaseMessageBoard> pageEntity = getPage();
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("createTime"));
		Map<String, Param> parm = new HashMap<String, Param>();
		parm.put("status", Param.eq(Constants.AUDIT_RESULT_PASS));
		baseMessageBoardSrv.page(pageEntity, parm, orders);
		sendResponseMsg(pageEntity);
	}

	/**
	 * 详情
	 *
	 * @author xiefei
	 */
	public void detail() {
		if (menuId == null) {
			sendFailMsg("", "");
			return;
		}
		if (StringUtils.isBlank(id)) {
			Map<String, Param> map = new HashMap<>();
			map.put("isEnable", Param.eq(Constants.YES));
			map.put("typestr", Param.like(menuId));
			List<Order> o = new ArrayList<>();
			o.add(Order.desc("createTime"));
			List<HomeInformationRelease> list = homeInformationReleaseSrv.findBy(map, o);
			sendResponseMsg(CollectionUtils.isNotEmpty(list) ? list.get(0) : new HomeInformationRelease());
			return;
		}

		HomeInformationRelease h = homeInformationReleaseSrv.find(id);
		List<HomeMenu> menus = srv.findChildrenMenu(40);
		if (h == null && CollectionUtils.isNotEmpty(menus) && menuId.equals(menus.get(0).getMenuId())) {
			BaseAlumniActivity v = activitySrv.find(id);
			if (v != null) {
				v.setIsSignUp(activitySrv.isApply(v));
				sendResponseMsg(v);
				return;
			}
		}
		sendResponseMsg(h);
	}

	/**
	 * @DES:报名
	 * @autor:xiefei<br/>
	 */
	public void baoming() {
		final UserSession u = (UserSession) session.get("UserSession");
		if (u != null && StringUtils.isNotBlank(id)) {
			baseActivitySignUpSrv.updateBaoming(u.getId(), id);
		}
		sendSuccessMsg();
	}

	private <R> PageEntity<R> getPage() {
		this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
		return new PageEntity<>(start, limit);
	}

	public void messageDetail() {
		if (StringUtils.isBlank(id)) {
			List<String> orders = new ArrayList<>();
			orders.add("createTime");
			Map<String, Object> map = new HashMap<>();
			map.put("isShow", Constants.YES);
			baseMessageBoardSrv.findBy(map);
			sendResponseMsg(baseMessageBoardSrv.find(id));
			return;
		}
		sendResponseMsg(baseMessageBoardSrv.find(id));
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> parm = new HashMap<String, Param>();
		parm.put("typestr", Param.like(menuId + ""));
		parm.put("isEnable", Param.eq(Constants.YES));
		return parm;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getIsPc() {
		return isPc;
	}

	public void setIsPc(String isPc) {
		this.isPc = isPc;
	}
}
