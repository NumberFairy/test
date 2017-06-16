package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
import com.wisdombud.alumni.pojo.manage.BaseNotice;
import com.wisdombud.alumni.dao.manage.BaseNoticeDao;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;
	/**
	 * 校友通知表 DaoImpl. <br/>
     * @author Administrator
     
     */
@Repository(value="baseNoticeDao")
	public class BaseNoticeDaoImpl extends SimpleHibernateDao<BaseNotice, String> implements BaseNoticeDao {
	private static final Logger LOGGER = Logger.getLogger(BaseNoticeDaoImpl.class);
}
