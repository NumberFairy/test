package com.wisdombud.alumni.actions.manage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.enums.YesOrNoEnum;
import com.wisdombud.alumni.pojo.manage.BaseTimeline;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.vo.CommonResult;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友成长时光轴<br/>
 * date: 2017-3-28 19:28:27 <br/>
 *
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("basetimeline")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toTimeline", location = "/WEB-INF/jsp/alumni-manage-center/alumni-info-note/timeline.jsp") })
public class TimelineAction extends AbstractCrudAction<BaseTimeline> {
	private static final long  serialVersionUID	= 1L;

	private BaseTimeline	   timelineEntity;
	private List<BaseTimeline> timelineList;
	private String alumniId;

	

	public TimelineAction(@Qualifier(value = "baseTimelineSrv") IBaseSrv<BaseTimeline> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		List<Order> list = Lists.newArrayList();
		list.add(Order.desc("lastUpdate"));
		return list;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params = Maps.newHashMap();
		params.put("alumniId", Param.eq(id));
		return params;
	}

	@Override
	public void addOrUpdate() {
		if (this.isAjaxRequest()) {
			if (timelineEntity == null) {
				CommonResult result = new CommonResult(CommonResult.FAIL, "entity == null");
				this.sendResponseMsg(result);
			} else {
				if (StringUtils.isEmpty(timelineEntity.getId())) {
					this.add();
				} else {
					this.update();
				}
			}

		}
	}

	@Override
	protected void add() {
		timelineEntity.setStatus(YesOrNoEnum.YES.getValue());
		timelineEntity.setId(null);
		timelineEntity.setCreateTime(new Date());
		timelineEntity.setLastUpdate(new Date());
		this.baseSrv.save(timelineEntity);
		CommonResult result = new CommonResult(CommonResult.SUCCESS);
		this.sendResponseMsg(result);
	}

	@Override
	protected void update() {
		timelineEntity.setLastUpdate(new Date());
		CommonResult result = new CommonResult(CommonResult.FAIL);
		BaseTimeline oldEntity = this.baseSrv.find(timelineEntity.getId());
		if (oldEntity == null) {
			result.setInfo("所更新的对象不存在");
		} else {
			BeanUtils.copyProperties(timelineEntity, oldEntity, "id", "createTime");
			this.baseSrv.update(oldEntity);
			result.setInfo(CommonResult.SUCCESS_INFO);
			result.setSuccess(CommonResult.SUCCESS);
		}
		this.sendResponseMsg(result);
	}

	public String hrefDisplayTimeline() {
		return "toTimeline";
	}

	public void findTimelineData() {
		timelineList = Lists.newArrayList();
		final Map<String, Param> param = this.buildParams();
		final List<Order> orders = this.buildOrder();
		timelineList = baseSrv.findBy(param, orders);
		sendResponseMsg(timelineList);
	}

	public BaseTimeline getTimelineEntity() {
		return timelineEntity;
	}

	public void setTimelineEntity(BaseTimeline timelineEntity) {
		this.timelineEntity = timelineEntity;
	}

	public List<BaseTimeline> getTimelineList() {
		return timelineList;
	}

	public void setTimelineList(List<BaseTimeline> timelineList) {
		this.timelineList = timelineList;
	}
	
	public String getAlumniId() {
		return alumniId;
	}

	public void setAlumniId(String alumniId) {
		this.alumniId = alumniId;
	}

}
