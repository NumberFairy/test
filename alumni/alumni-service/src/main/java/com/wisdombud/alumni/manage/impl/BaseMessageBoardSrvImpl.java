package com.wisdombud.alumni.manage.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.common.EmailSrv;
import com.wisdombud.alumni.dao.manage.BaseMessageBoardDao;
import com.wisdombud.alumni.enums.AuditEnum;
import com.wisdombud.alumni.enums.ReplyEnum;
import com.wisdombud.alumni.manage.BaseMessageBoardSrv;
import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 留言表Srv. <br/>
 * 
 * @author cczhao
 * 
 */
@Service(value = "baseMessageBoardSrv")
public class BaseMessageBoardSrvImpl extends BaseSrvImpl<BaseMessageBoard> implements BaseMessageBoardSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseMessageBoardSrvImpl.class);
	@Autowired
	private EmailSrv emailSrv;
	@Autowired
	private BaseMessageBoardDao dao;

	public BaseMessageBoardSrvImpl() {
	}

	@Autowired
	public BaseMessageBoardSrvImpl(
			@Qualifier(value = "baseMessageBoardDao") CommonDao<BaseMessageBoard, String> commonDao) {
		super(commonDao);
	}

	public boolean sendEmail(String email, String replyContent) {
		if (StringUtils.isNotEmpty(email)) {
			List<String> users = new ArrayList<>();
			users.add(email);
			emailSrv.sendMail("", users, replyContent);
			return true;
		}
		return false;
	}

	public boolean updateReplyMessage(String id, String replyContent, String isShow) {
		if (StringUtils.isNotEmpty(id)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = dateFormat.format(new Date());
			BaseMessageBoard baseMessageBoard = this.find(id);
			baseMessageBoard.setReplyContent(replyContent);
			baseMessageBoard.setIsReply(1);
			baseMessageBoard.setReplyTime(date);
			try {
				baseMessageBoard.setIsShow(Integer.parseInt(isShow));
			} catch (Exception e) {
				LOGGER.info("是否在门户展示----数据类型转换失败");
			}
			this.update(baseMessageBoard);
			return true;
		}
		return false;
	}

	public void audit(String id, String flag) {
		if (StringUtils.isNotEmpty(id)) {
			BaseMessageBoard baseMessageBoard = this.find(id);
			if (flag.equals("0")) {
				baseMessageBoard.setStatus(0);
				baseMessageBoard.setOperation(1);
				this.update(baseMessageBoard);
			} else if (flag.equals("1")) {
				baseMessageBoard.setStatus(1);
				baseMessageBoard.setOperation(1);
				this.update(baseMessageBoard);
			} else {
				LOGGER.info("flag值没有获取到");
			}
		}
	}

	@Override
	public void page(PageEntity<BaseMessageBoard> pageEntity, Map<String, Param> params, List<Order> orders) {
		orders.add(Order.desc("createTime"));
		dao.page(pageEntity, params, orders);
		for (BaseMessageBoard baseMessageBoard : pageEntity.getResults()) {
			baseMessageBoard.setStatusName(AuditEnum.valueByIndex(baseMessageBoard.getStatus()).getName());
			baseMessageBoard.setIsReplyName(ReplyEnum.valueByIndex(baseMessageBoard.getIsReply()).getName());
		}
	}

}
