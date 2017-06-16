package com.wisdombud.alumni.actions.manage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Maps;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.enums.AuditEnum;
import com.wisdombud.alumni.enums.ReplyEnum;
import com.wisdombud.alumni.manage.BaseMessageBoardSrv;
import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 留言表<br/>
 * date: 2017-3-29 10:13:56 <br/>
 * 
 * @author cczhao
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toDetail", location = "/WEB-INF/jsp/message-board/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/message-board/page.jsp") })
public class MessageBoardAction extends AbstractCrudAction<BaseMessageBoard> {
	private static final long	serialVersionUID = 1L;
	private static final Logger	LOGGER			 = Logger.getLogger(BaseMessageBoard.class);

	@Autowired
	private BaseMessageBoardSrv	baseMessageBoardSrv;
	private String				replyContent;
	private String				flag;
	private String				email;
	private String				isShow;

	public MessageBoardAction(@Qualifier(value = "baseMessageBoardSrv") IBaseSrv<BaseMessageBoard> baseSrv) {
		super(baseSrv);
	}

	public void sendEmail() {
		if (baseMessageBoardSrv.sendEmail(email, replyContent)) {
			this.sendSuccessMsg("", "发送成功");
		} else {
			this.sendFailMsg("", "发送失败");
		}
	}

	public void forEmail() {
		if (StringUtils.isNotEmpty(id)) {
			entity = this.baseSrv.find(id);
			this.sendSuccessMsg(null, entity.getEmail());
		}
	}

	public String audit() {
		baseMessageBoardSrv.audit(id, flag);
		return "toPage";
	}

	public void replyMessage() {
		if (baseMessageBoardSrv.updateReplyMessage(id, replyContent, isShow)) {
			this.sendSuccessMsg();
		} else {
			LOG.info("回复信息存储到数据库失败");
		}
	}

	@Override
	public String hrefDetail() {
		this.initConf();
		entity = this.baseSrv.find(id);		
		entity.setStatusName(AuditEnum.valueByIndex(entity.getStatus()).getName());
		entity.setIsReplyName(ReplyEnum.valueByIndex(entity.getIsReply()).getName());
		return "toDetail";
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params = Maps.newHashMap();
		if (entity == null) {
			return new HashMap<>();
		}
		if (StringUtils.isNotEmpty(this.entity.getTitle())) {
			params.put("title", Param.like(this.entity.getTitle()));
		}
		if (StringUtils.isNotEmpty(this.entity.getName())) {
			params.put("name", Param.like(this.entity.getName()));
		}
		if (StringUtils.isNotEmpty(this.entity.getMessage())) {
			params.put("message", Param.like(this.entity.getMessage()));
		}
		if (this.entity.getCreateTime() != null) {
			params.put("createTime", Param.put(Param.GT, this.entity.getCreateTime()));
			Date now = this.entity.getCreateTime();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(now);
			calendar.add(calendar.DATE, 1);
			params.put("createTimeEnd", Param.put(Param.LT, calendar.getTime()));
		}
		if (StringUtils.isNotEmpty(this.entity.getStatusName())) {
			params.put("status", Param.eq(Integer.parseInt(this.entity.getStatusName())));
		}
		if (StringUtils.isNotEmpty(this.entity.getIsReplyName())) {
			params.put("isReply", Param.eq(Integer.parseInt(this.entity.getIsReplyName())));
		}
		if (StringUtils.isNotEmpty(this.entity.getReplyTime().toString())) {
			try {
				params.put("replyTime", Param.like(this.entity.getReplyTime().toString()));
			} catch (Exception e) {
				LOGGER.info(e + ":字符串转换时间类型失败");
			}

		}

		return params;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
}
