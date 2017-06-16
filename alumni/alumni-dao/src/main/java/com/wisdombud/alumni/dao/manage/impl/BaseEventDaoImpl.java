package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

import com.wisdombud.alumni.dao.manage.BaseEventDao;
import com.wisdombud.alumni.pojo.manage.BaseEvent;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友工作大事记 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseEventDao")
public class BaseEventDaoImpl extends SimpleHibernateDao<BaseEvent, String> implements BaseEventDao {
	private static final Logger LOGGER = Logger.getLogger(BaseEventDaoImpl.class);
}
