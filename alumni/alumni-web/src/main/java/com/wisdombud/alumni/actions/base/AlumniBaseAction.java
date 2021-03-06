/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.actions.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Order;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.pojo.base.UUIDAlumniPo;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.util.IdKit;
import com.wisdombud.alumni.vo.CommonResult;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.DateFormat;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 抽象的增删改查action.<br/>
 * date: 2017年2月23日 下午4:44:14 <br/>
 *
 * @author zlliu
 * @version
 * @since JDK 1.7
 */
public class AlumniBaseAction<T extends UUIDAlumniPo> extends AbstractCommonAction implements Serializable {

	private static final long serialVersionUID = 6530892829632852898L;

	protected T				  entity;

	protected IBaseSrv<T>	  baseSrv;

	protected String		  id;

	protected PageEntity<T>	  pageEntity;

	protected String		  jsonListEntity;

	public AlumniBaseAction(IBaseSrv<T> baseSrv) {
		this.baseSrv = baseSrv;
	}

	public void initConf() {
	}

	public String hrefPage() {
		this.initConf();
		return "toPage";
	}

	public String hrefAddOrUpdate() {
		this.initConf();
		if (entity != null && StringUtils.isNotBlank(entity.getId())) {
			entity = baseSrv.find(entity.getId());
		}
		return "toAddOrUpdate";
	}

	public String hrefList() {
		this.initConf();
		return "toList";
	}

	public String hrefDetail() {
		this.initConf();
		entity = this.baseSrv.find(id);
		return "toDetail";
	}

	public void page() {
		if (this.isAjaxRequest()) {
			this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
			pageEntity = new PageEntity<>(start, limit);
			final Map<String, Param> params = this.buildParams();
			final List<Order> orderList = this.buildOrder();
			this.baseSrv.page(pageEntity, params, orderList);
			this.sendResponseMsg(pageEntity);
		}
	}

	public void list() {
		if (this.isAjaxRequest()) {
			final Map<String, Param> params = this.buildParams();
			final List<Order> orders = this.buildOrder();
			List<T> list = this.baseSrv.findBy(params, orders);
			this.sendResponseMsg(list);
		}
	}

	public void addOrUpdate() {
		if (this.isAjaxRequest()) {
			if (entity == null) {
				CommonResult result = new CommonResult(CommonResult.FAIL, "entity == null");
				this.sendResponseMsg(result);
			} else {
				if (StringUtils.isEmpty(entity.getId())) {
					this.add();
				} else {
					this.update();
				}
			}

		}
	}

	public void delete() {
		if (this.isAjaxRequest()) {
			this.baseSrv.deleteByIds(id);
			CommonResult result = new CommonResult(CommonResult.SUCCESS);
			this.sendResponseMsg(result);
		}
	}

	public void detail() {
		entity = this.baseSrv.find(id);
		if (this.isAjaxRequest()) {
			this.sendResponseMsg(entity);
		}
	}

	protected void add() {
		entity.setId(IdKit.uuid());
		entity.setCreateTime(new Date());
		entity.setLastUpdate(new Date());
		this.baseSrv.save(entity);
		CommonResult result = new CommonResult(CommonResult.SUCCESS);
		this.sendResponseMsg(result);
	}

	protected void update() {
		entity.setLastUpdate(new Date());
		CommonResult result = new CommonResult(CommonResult.FAIL);
		T oldEntity = this.baseSrv.find(entity.getId());
		if (oldEntity == null) {
			result.setInfo("所更新的对象不存在");
		} else {
			BeanUtils.copyProperties(entity, oldEntity, "id", "createTime");
			this.baseSrv.update(oldEntity);
			result.setInfo(CommonResult.SUCCESS_INFO);
			result.setSuccess(CommonResult.SUCCESS);
		}
		this.sendResponseMsg(result);
	}

	/**
	 * 功能：当出现“No result defined for action”错误时对代码进行调试
	 *
	 * @see com.opensymphony.xwork2.ActionSupport#addActionError(java.lang.String)
	 */
	@Override
	public void addActionError(String anErrorMessage) {
		String s = anErrorMessage;
		System.out.println(s);
	}

	@Override
	public void addActionMessage(String aMessage) {
		String s = aMessage;
		System.out.println(s);

	}

	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		String s = errorMessage;
		String f = fieldName;
		System.out.println(s);
		System.out.println(f);

	}

	/**
	 * 功能: 构建排序 list .<br/>
	 * date: 2015年3月11日 上午8:50:54 <br/>
	 *
	 * @author zlliu@wisdombud.com
	 * @return
	 */
	protected List<Order> buildOrder() {
		return new ArrayList<Order>();
	}

	/**
	 * 功能: 构建查询参数map.<br/>
	 * date: 2015年3月11日 上午8:48:40 <br/>
	 *
	 * @author zlliu@wisdombud.com
	 * @return
	 */
	protected Map<String, Param> buildParams() {
		return new HashMap<String, Param>();
	}

	protected void sendResponseMsg(Object src) {
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(src));
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PageEntity<T> getPageEntity() {
		return pageEntity;
	}

	public void setPageEntity(PageEntity<T> pageEntity) {
		this.pageEntity = pageEntity;
	}

	/**
	 * 功能: get 前台list传来字符串.<br/>
	 * date: 2017年2月28日 上午10:04:32 <br/>
	 * sample： [{"category":"123","serialCode":"1"}]
	 *
	 * @author xushuai
	 * @return
	 */
	public String getJsonListEntity() {
		return jsonListEntity;
	}

	/**
	 * 功能: set 前台list传来字符串.<br/>
	 * date: 2017年2月28日 上午10:04:27 <br/>
	 *
	 * @author xushuai
	 * @param jsonListEntity
	 */
	public void setJsonListEntity(String jsonListEntity) {
		this.jsonListEntity = jsonListEntity;
	}

	protected UserSession getUserSession() {
		return (UserSession) session.get("UserSession");
	}
}
