package com.wisdombud.alumni.dao.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseAlumniActivityApplyDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivityApply;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友活动申请表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseAlumniActivityApplyDao")
public class BaseAlumniActivityApplyDaoImpl extends SimpleHibernateDao<BaseAlumniActivityApply, String>
		implements BaseAlumniActivityApplyDao {
	private static final Logger LOGGER = Logger.getLogger(BaseAlumniActivityApplyDaoImpl.class);
}
