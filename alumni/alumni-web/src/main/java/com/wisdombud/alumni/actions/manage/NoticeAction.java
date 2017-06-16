package com.wisdombud.alumni.actions.manage;

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

import com.google.common.collect.Maps;
import com.opensymphony.xwork2.ActionContext;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.enums.AlumniNoticeEnum;
import com.wisdombud.alumni.manage.BaseNoticeSrv;
import com.wisdombud.alumni.manage.BaseNoticeTemplateSrv;
import com.wisdombud.alumni.pojo.dic.DicNoticePattern;
import com.wisdombud.alumni.pojo.dic.DicNoticeType;
import com.wisdombud.alumni.pojo.manage.BaseNotice;
import com.wisdombud.alumni.pojo.manage.BaseNoticeTemplate;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友通知表<br/>
 * date: 2017-3-31 10:37:00 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/alumni-server-manage/alumni-notice-manage/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/alumni-server-manage/alumni-notice-manage/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-server-manage/alumni-notice-manage/page.jsp") })
public class NoticeAction extends AbstractCrudAction<BaseNotice> {
	private static final long		 serialVersionUID = 1L;
	@Autowired
	public DicCommonSrv				 dicCommonSrv;
	@Autowired
	private BaseNoticeTemplateSrv	 noticeTemplateSrv;
	@Autowired
	private BaseNoticeSrv			 Srv;

	private BaseNotice				 notice;
	private List<DicNoticePattern>	 noticePatternList;
	private List<DicNoticeType>		 noticeTypeList;
	private List<BaseNoticeTemplate> noticeTemplateList;

	public NoticeAction(@Qualifier(value = "baseNoticeSrv") IBaseSrv<BaseNotice> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params = Maps.newHashMap();
		if (this.notice != null) {
			if (StringUtils.isNotEmpty(this.notice.getNoticeTitle())) {
				params.put("noticeTitle", Param.like(this.notice.getNoticeTitle()));
			}
			if (this.notice.getStatus()!=-1) {
				params.put("status", Param.eq( this.notice.getStatus()));
			}
		}
		return params;
	}


	@Override
	protected void add() {
		// TODO:创建人为登录用户
		final UserSession userSession = (UserSession) ActionContext.getContext().getSession().get("UserSession");
		String  userName=userSession.getId();
		 entity.setPerson(userName);
		entity.setStatus(AlumniNoticeEnum.ENABLE.getValue());
		super.add();
	}

	@Override
	public String hrefAddOrUpdate() {
		this.initData();
		if (StringUtils.isNotBlank(this.id)) {
			this.entity = this.baseSrv.find(this.id);
		}
		return super.hrefAddOrUpdate();
	}

	public void oper() {

		if (StringUtils.isNotBlank(this.id)) {
			Srv.saveChangeStatus(id);
			sendSuccessMsg(id, "oper success!");
		}

	}

	private void initData() {
		this.noticePatternList = dicCommonSrv.findAll(DicNoticePattern.class);
		this.noticeTypeList = dicCommonSrv.findAll(DicNoticeType.class);
		this.noticeTemplateList = noticeTemplateSrv.findAll();
	}

	public List<DicNoticePattern> getNoticePatternList() {
		return noticePatternList;
	}

	public void setNoticePatternList(List<DicNoticePattern> noticePatternList) {
		this.noticePatternList = noticePatternList;
	}

	public List<DicNoticeType> getNoticeTypeList() {
		return noticeTypeList;
	}

	public void setNoticeTypeList(List<DicNoticeType> noticeTypeList) {
		this.noticeTypeList = noticeTypeList;
	}

	public List<BaseNoticeTemplate> getNoticeTemplateList() {
		return noticeTemplateList;
	}

	public void setNoticeTemplateList(List<BaseNoticeTemplate> noticeTemplateList) {
		this.noticeTemplateList = noticeTemplateList;
	}

	public BaseNotice getNotice() {
		return notice;
	}

	public void setNotice(BaseNotice notice) {
		this.notice = notice;
	}

}
