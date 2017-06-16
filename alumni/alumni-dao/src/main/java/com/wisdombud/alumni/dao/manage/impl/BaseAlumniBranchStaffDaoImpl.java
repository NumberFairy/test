package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchStaff;
import com.wisdombud.alumni.dao.manage.BaseAlumniBranchStaffDao;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;
	/**
	 * 校友分会人员职务表 DaoImpl. <br/>
     * @author Administrator
     
     */
@Repository(value="baseAlumniBranchStaffDao")
	public class BaseAlumniBranchStaffDaoImpl extends SimpleHibernateDao<BaseAlumniBranchStaff, String> implements BaseAlumniBranchStaffDao {
	private static final Logger LOGGER = Logger.getLogger(BaseAlumniBranchStaffDaoImpl.class);
}
