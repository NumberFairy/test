package com.wisdombud.alumni.actions.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseEventSrv;
import com.wisdombud.alumni.manage.BaseMemoSrv;
import com.wisdombud.alumni.pojo.manage.BaseEvent;
import com.wisdombud.alumni.pojo.manage.BaseMemo;
import com.wisdombud.alumni.vo.Param;
import com.wisdombud.alumni.vo.RemindVo;

import common.toolkit.java.entity.DateFormat;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 首页我的办公桌<br/>
 * date: 2017-3-28 19:28:27 <br/>
 * 
 * @author zhangyan
 * @version
 * @since JDK 1.8
 */

@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/library-tube/storehouse-management/create-storehouse-management.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/library-tube/storehouse-management/storehouse-management-detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/my-desk/my_desk.jsp"),
		   @Result(name = "toRemind", location = "/WEB-INF/jsp/remind/page.jsp") })
public class MyDeskAction extends AbstractCommonAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BaseEventSrv	  eventSrv;
	@Autowired
	private BaseMemoSrv		  memoSrv;
	@Autowired
	private BaseAlumniSrv	  alumniSrv;
	
	private String			  key;

	private List<BaseEvent>	  eventList;
	private List<BaseMemo>	  memoList;

	public String toRemind() {
		return "toRemind";
	}

	public String hrefPage() {
		return "toPage";
	}

	/**
	 * @DES:我的办工桌提醒事件
	 * @param :beforeDay
	 *            提前提醒时间默认2天
	 * @autor:xiefei<br/>
	 */
	public void pageRemind() {
		this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
		PageEntity<RemindVo> page = new PageEntity<>(start, limit);
		alumniSrv.pageRemind(page, null,key);
		sendResponseMsg(page);
	}

	public void findAllData() {
		memoList = new ArrayList<BaseMemo>();
		final Map<String, Param> param = this.buildParams();
		final List<Order> orders = this.buildMemoOrder("memoTime");
		memoList = memoSrv.findBy(param, orders);
		// eventList = eventSrv.findAll();
		sendResponseMsg(memoList);
	}

	public void findEventData() {
		eventList = new ArrayList<>();
		final Map<String, Param> param = this.buildParams();
		final List<Order> orders = this.buildMemoOrder("eventTime");
		eventList = eventSrv.findBy(param, orders);
		sendResponseMsg(eventList);
	}

	protected void sendResponseMsg(Object src) {
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(src));
	}

	protected List<Order> buildMemoOrder(String typeTime) {
		ArrayList<Order> orders = new ArrayList<>();
		orders.add(Order.desc(typeTime));
		return orders;
	}

	protected Map<String, Param> buildParams() {
		Map<String, Param> param = new HashMap<>();
		return param;
	}

	/**
	 * eventList.
	 * 
	 * @return the eventList
	 * @since JDK 1.7
	 */
	public List<BaseEvent> getEventList() {
		return eventList;
	}

	/**
	 * eventList.
	 * 
	 * @param eventList the eventList to set
	 * @since JDK 1.7
	 */
	public void setEventList(List<BaseEvent> eventList) {
		this.eventList = eventList;
	}

	/**
	 * memoList.
	 * 
	 * @return the memoList
	 * @since JDK 1.7
	 */
	public List<BaseMemo> getMemoList() {
		return memoList;
	}

	/**
	 * memoList.
	 * 
	 * @param memoList the memoList to set
	 * @since JDK 1.7
	 */
	public void setMemoList(List<BaseMemo> memoList) {
		this.memoList = memoList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
