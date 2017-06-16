package com.wisdombud.alumni.actions.system;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.pojo.system.SecRole;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.system.SecRoleSrv;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.vo.CommonResult;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 角色管理<br/>
 * date: 2017-3-28 19:28:27 <br/>
 * 
 * @author zhangyan
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toPage", location = "/WEB-INF/jsp/system/role-manage/page.jsp"),
		   @Result(name = "permission", location = "/WEB-INF/jsp/system/role-manage/permission.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/system/user-manage/detail.jsp") })
public class RoleManageAction extends AbstractCommonAction {

	private static final long	  serialVersionUID = 1L;

	@Autowired
	private SecRoleSrv			  secRoleSrv;

	protected SecRole			  entity;

	protected String			  id;

	protected PageEntity<SecRole> pageEntity;

	public String hrefPage() {
		return "toPage";
	}

	public String hrefPermission() {
		return "permission";
	}

	public String hrefAddOrUpdate() {
		if (entity != null && StringUtils.isNotBlank(entity.getId())) {
			entity = secRoleSrv.find(entity.getId());
		}
		return "toAddOrUpdate";
	}

	public String hrefDetail() {
		entity = this.secRoleSrv.find(id);
		return "toDetail";
	}

	public void page() {
		if (this.isAjaxRequest()) {
			this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
			pageEntity = new PageEntity<>(start, limit);
			final Map<String, Param> params = this.buildParams();
			final List<Order> orderList = this.buildOrder();
			this.secRoleSrv.page(pageEntity, params, orderList);
			final Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			this.sendResponseMsg(g.toJson(pageEntity));
		}
	}

	public void addOrUpdate() {
		if (this.isAjaxRequest()) {
			if (entity == null) {
				CommonResult result = new CommonResult(CommonResult.FAIL, "entity == null");
				this.sendResponseMsg(result);
			} else {
				SecRole roles = secRoleSrv.findUniqueBy("name", entity.getName());
				if (roles != null) {
					CommonResult result = new CommonResult(CommonResult.FAIL, "角色名已存在");
					sendResponseMsg(result);
					return;
				}
				if (StringUtils.isEmpty(entity.getId())) {
					entity.setIsAdmin(0);
					this.add();
				} else {
					this.update();
				}
				sendSuccessMsg();
			}

		}
	}

	public void nameIsExist() {
		if (this.isAjaxRequest()) {
			String name = request.getParameter("name");
			if (StringUtils.isNotEmpty(name)) {
				entity = secRoleSrv.findUniqueBy("name", name);
				if (entity != null) {
					sendSuccessMsg();
				}
			}
		}
	}

	public void delete() {
		if (this.isAjaxRequest()) {
			String id = request.getParameter("id");
			this.secRoleSrv.deleteByIds(id);
			CommonResult result = new CommonResult(CommonResult.SUCCESS);
			this.sendResponseMsg(result);
		}
	}

	public void detail() {
		String id = request.getParameter("id");
		entity = this.secRoleSrv.find(id);
		if (this.isAjaxRequest()) {
			this.sendResponseMsg(entity);
		}
	}

	protected void add() {
		CommonResult result = new CommonResult(CommonResult.SUCCESS);
		SecRole roleName = secRoleSrv.findUniqueBy("name", entity.getName());
		if (roleName != null) {
			result = new CommonResult(CommonResult.FAIL, "角色名已存在");
			this.sendResponseMsg(result);
			return;
		}
		// entity.setId(null);
		entity.setCreateTime(new Date());
		entity.setLastUpdate(new Date());
		this.secRoleSrv.save(entity);
		this.sendResponseMsg(result);
	}

	protected void update() {
		entity.setLastUpdate(new Date());
		CommonResult result = new CommonResult(CommonResult.FAIL);
		SecRole oldEntity = this.secRoleSrv.find(entity.getId());
		if (oldEntity == null) {
			result.setInfo("所更新的对象不存在");
		} else {
			BeanUtils.copyProperties(entity, oldEntity, "id", "createTime");
			this.secRoleSrv.update(oldEntity);
			result.setInfo(CommonResult.SUCCESS_INFO);
			result.setSuccess(CommonResult.SUCCESS);
		}
		this.sendResponseMsg(result);
	}

	protected List<Order> buildOrder() {
		List<Order> orders = new ArrayList<>();
		orders.add(Order.desc("createTime"));
		return orders;
	}

	protected Map<String, Param> buildParams() {
		Map<String, Param> params = new HashMap<>();
		if (entity != null) {
			if (StringUtils.isNotBlank(entity.getName())) {
				params.put("name", Param.like(entity.getName()));
			}
			if (StringUtils.isNotBlank(this.entity.getDescription())) {
				params.put("description", Param.like(this.entity.getDescription()));
			}
		}
		params.put("isAdmin", Param.put(Param.NEQ, SecUser.IS_ADMINISTRATOR_YES));
		return params;
	}

	protected void sendResponseMsg(Object src) {
		final Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		this.sendResponseMsg(g.toJson(src));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SecRoleSrv getSecRoleSrv() {
		return secRoleSrv;
	}

	public void setSecRoleSrv(SecRoleSrv secRoleSrv) {
		this.secRoleSrv = secRoleSrv;
	}

	public PageEntity<SecRole> getPageEntity() {
		return pageEntity;
	}

	public void setPageEntity(PageEntity<SecRole> pageEntity) {
		this.pageEntity = pageEntity;
	}

	public SecRole getEntity() {
		return entity;
	}

	public void setEntity(SecRole entity) {
		this.entity = entity;
	}

}
