package com.wisdombud.alumni.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.BaseAlumniLiaisonSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniLiaison;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友联络员表Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "baseAlumniLiaisonSrv")
public class BaseAlumniLiaisonSrvImpl extends BaseSrvImpl<BaseAlumniLiaison> implements BaseAlumniLiaisonSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseAlumniLiaisonSrvImpl.class);

	public BaseAlumniLiaisonSrvImpl() {
	}

	@Autowired
	public BaseAlumniLiaisonSrvImpl(
			@Qualifier(value = "baseAlumniLiaisonDao") CommonDao<BaseAlumniLiaison, String> commonDao) {
		super(commonDao);
	}

}
