package com.wisdombud.alumni.actions.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.manage.BaseEventSrv;
import com.wisdombud.alumni.pojo.manage.BaseEvent;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友工作大事记<br/>
 * date: 2017-3-29 10:13:56 <br/>
 * 
 * @author zhangyan
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/event/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/event/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/event/page.jsp") })
public class EventAction extends AbstractCrudAction<BaseEvent> {
	private static final long serialVersionUID = 1L;
	@Autowired
	private BaseEventSrv	  eventSrv;

	private BaseEvent		  eventEntity;

	public EventAction(@Qualifier(value = "baseEventSrv") IBaseSrv<BaseEvent> baseSrv) {
		super(baseSrv);
	}

	public void changeStatus() {
		String ids = request.getParameter("ids");
		String[] idArray = ids.split(",");
		for (String id : idArray) {
			eventEntity = eventSrv.find(id);
			eventEntity.setStatus("1");
			eventSrv.update(eventEntity);;
		}
		sendSuccessMsg();
	}

	public void deleteByIds() {
		String ids = request.getParameter("ids");
		eventSrv.deleteByIds(ids);
		sendSuccessMsg();
	}

	@Override
	public void addOrUpdate() {
		entity.setStatus("0");
		super.addOrUpdate();
		sendSuccessMsg();
	}

	@Override
	protected List<Order> buildOrder() {
		ArrayList<Order> orders = new ArrayList<>();
		orders.add(Order.desc("eventTime"));
		return orders;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> param = new HashMap<>();
		if (this.entity == null) {
			return new HashMap<>();
		}

		if (StringUtils.isNotEmpty(this.entity.getEventTitle())) {
			param.put("eventTitle", Param.like(this.entity.getEventTitle()));
		}

		if (StringUtils.isNotEmpty(this.entity.getEventContent())) {
			param.put("eventContent", Param.like(this.entity.getEventContent()));
		}

		if (this.entity.getEventTime() != null) {
			param.put("eventTime", Param.eq(this.entity.getEventTime()));
		}
		return param;
	}
	
	/**
	 * 功能：
	 * @author jfzhai@wisdombud.com
	 * 2017年5月2日
	 */
	public void exportEvents() {
		List<BaseEvent> eList=Lists.newArrayList();
		eList = eventSrv.findBy(this.buildParams(), this.buildOrder());
		eventSrv.createExcelWorkBookInfo(response, eList);
	}
	

	/**
	 * eventEntity.
	 * 
	 * @return the eventEntity
	 * @since JDK 1.7
	 */
	public BaseEvent getEventEntity() {
		return eventEntity;
	}

	/**
	 * eventEntity.
	 * 
	 * @param eventEntity the eventEntity to set
	 * @since JDK 1.7
	 */
	public void setEventEntity(BaseEvent eventEntity) {
		this.eventEntity = eventEntity;
	}

}
