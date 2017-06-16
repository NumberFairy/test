package com.wisdombud.alumni.dao.manage.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseAlumniImportDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友信息表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseAlumniImportDao")
public class BaseAlumniImportDaoImpl extends SimpleHibernateDao<BaseAlumniImport, String>
		implements BaseAlumniImportDao {
	private static final Logger LOGGER = Logger.getLogger(BaseAlumniImportDaoImpl.class);

	@Override
	public void deleteAll() {
		createHqlQuery("delete from BaseAlumniImport", new HashMap<String, Object>()).executeUpdate();
	}
}
