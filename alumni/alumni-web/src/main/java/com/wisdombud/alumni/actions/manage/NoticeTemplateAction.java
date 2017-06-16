package com.wisdombud.alumni.actions.manage;

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

import com.opensymphony.xwork2.ActionContext;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseNoticeTemplate;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 模板管理<br/>
 * date: 2017-3-31 10:37:00 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/alumni-server-manage/alumni-notice-template/template-create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/alumni-server-manage/alumni-notice-template/template-detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-server-manage/alumni-notice-template/template.jsp") })
public class NoticeTemplateAction extends AbstractCrudAction<BaseNoticeTemplate> {
	private static final long serialVersionUID = 1L;

	public NoticeTemplateAction(@Qualifier(value = "baseNoticeTemplateSrv") IBaseSrv<BaseNoticeTemplate> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

	@Override
	protected Map<String, Param> buildParams() {
		return super.buildParams();
	}
	@Override
	public String hrefAddOrUpdate() {
		if (StringUtils.isNotBlank(this.id)) {
			this.entity = this.baseSrv.find(this.id);
		}
		return super.hrefAddOrUpdate();
	}

	@Override
	protected void add() {
		final UserSession userSession = (UserSession) ActionContext.getContext().getSession().get("UserSession");
		String  userName=userSession.getId();
		 entity.setPerson(userName);
		super.add();
	}

}
