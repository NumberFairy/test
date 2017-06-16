package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

import com.wisdombud.alumni.dao.manage.BaseAlumniEnrollDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumniEnroll;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友登记表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseAlumniEnrollDao")
public class BaseAlumniEnrollDaoImpl extends SimpleHibernateDao<BaseAlumniEnroll, String>
		implements BaseAlumniEnrollDao {
	private static final Logger LOGGER = Logger.getLogger(BaseAlumniEnrollDaoImpl.class);
}
