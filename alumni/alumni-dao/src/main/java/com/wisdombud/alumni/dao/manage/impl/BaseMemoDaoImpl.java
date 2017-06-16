package com.wisdombud.alumni.dao.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseMemoDao;
import com.wisdombud.alumni.pojo.manage.BaseMemo;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 备忘录 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseMemoDao")
public class BaseMemoDaoImpl extends SimpleHibernateDao<BaseMemo, String> implements BaseMemoDao {
	private static final Logger LOGGER = Logger.getLogger(BaseMemoDaoImpl.class);
}
