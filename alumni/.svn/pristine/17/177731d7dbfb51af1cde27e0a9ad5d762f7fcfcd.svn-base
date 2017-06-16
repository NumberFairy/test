package com.wisdombud.alumni.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.BaseMemoSrv;
import com.wisdombud.alumni.pojo.manage.BaseMemo;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 备忘录Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "baseMemoSrv")
public class BaseMemoSrvImpl extends BaseSrvImpl<BaseMemo> implements BaseMemoSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseMemoSrvImpl.class);

	public BaseMemoSrvImpl() {
	}

	@Autowired
	public BaseMemoSrvImpl(@Qualifier(value = "baseMemoDao") CommonDao<BaseMemo, String> commonDao) {
		super(commonDao);
	}
}
