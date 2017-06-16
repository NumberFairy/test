package com.wisdombud.alumni.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.dao.manage.BaseAlumniImportDao;
import com.wisdombud.alumni.manage.BaseAlumniImportSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友信息表Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "baseAlumniImportSrv")
public class BaseAlumniImportSrvImpl extends BaseSrvImpl<BaseAlumniImport> implements BaseAlumniImportSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseAlumniImportSrvImpl.class);
	
	private BaseAlumniImportDao baseAlumniImportDao;

	public BaseAlumniImportSrvImpl() {
	}

	@Autowired
	public BaseAlumniImportSrvImpl(
			@Qualifier(value = "baseAlumniImportDao") CommonDao<BaseAlumniImport, String> commonDao) {
		super(commonDao);
		baseAlumniImportDao = (BaseAlumniImportDao) commonDao;
	}

	@Override
	public void deleteAll() {
		baseAlumniImportDao.deleteAll();
	}
}
