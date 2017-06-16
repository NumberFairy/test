package com.wisdombud.alumni.dao.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseRegisterDao;
import com.wisdombud.alumni.pojo.manage.BaseRegister;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友注册表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseRegisterDao")
public class BaseRegisterDaoImpl extends SimpleHibernateDao<BaseRegister, String> implements BaseRegisterDao {
	private static final Logger LOGGER = Logger.getLogger(BaseRegisterDaoImpl.class);
}
