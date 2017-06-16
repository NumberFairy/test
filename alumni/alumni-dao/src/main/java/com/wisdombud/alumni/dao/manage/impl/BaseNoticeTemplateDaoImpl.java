package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
import com.wisdombud.alumni.pojo.manage.BaseNoticeTemplate;
import com.wisdombud.alumni.dao.manage.BaseNoticeTemplateDao;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;
	/**
	 * 通知类型 DaoImpl. <br/>
     * @author Administrator
     
     */
@Repository(value="baseNoticeTemplateDao")
	public class BaseNoticeTemplateDaoImpl extends SimpleHibernateDao<BaseNoticeTemplate, String> implements BaseNoticeTemplateDao {
	private static final Logger LOGGER = Logger.getLogger(BaseNoticeTemplateDaoImpl.class);
}
