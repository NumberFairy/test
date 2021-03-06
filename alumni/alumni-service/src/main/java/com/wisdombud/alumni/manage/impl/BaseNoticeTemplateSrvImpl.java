package com.wisdombud.alumni.manage.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.BaseNoticeTemplateSrv;
import com.wisdombud.alumni.pojo.manage.BaseNoticeTemplate;
import com.wisdombud.alumni.pojo.system.PublicUser;
import com.wisdombud.alumni.system.PublicUserSrv;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 通知类型Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "baseNoticeTemplateSrv")
public class BaseNoticeTemplateSrvImpl extends BaseSrvImpl<BaseNoticeTemplate> implements BaseNoticeTemplateSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseNoticeTemplateSrvImpl.class);
	@Autowired
	private PublicUserSrv userSrv;

	public BaseNoticeTemplateSrvImpl() {
	}

	@Autowired
	public BaseNoticeTemplateSrvImpl(
			@Qualifier(value = "baseNoticeTemplateDao") CommonDao<BaseNoticeTemplate, String> commonDao) {
		super(commonDao);
	}

	private void fillName(List<BaseNoticeTemplate> list) {
		for (BaseNoticeTemplate inst : list) {
			fillName(inst);
		}
	}

	private void fillName(BaseNoticeTemplate entity) {
		if (entity.getPerson() != null) {
			PublicUser user = userSrv.find(entity.getPerson());
			entity.setPersonName(user.getLoginName());
		}
	}

	@Override
	public void page(PageEntity<BaseNoticeTemplate> pageEntity, Map<String, Param> params, List<Order> orders) {
		super.page(pageEntity, params, orders);
		List<BaseNoticeTemplate> list = pageEntity.getResults();
		this.fillName(list);
	}
}
