package com.wisdombud.alumni.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.HomeNewsPicSrv;
import com.wisdombud.alumni.pojo.manage.HomeNewsPic;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 微信轮播图片管理Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "homeNewsPicSrv")
public class HomeNewsPicSrvImpl extends BaseSrvImpl<HomeNewsPic> implements HomeNewsPicSrv {

	private static final Logger LOGGER = Logger.getLogger(HomeNewsPicSrvImpl.class);

	public HomeNewsPicSrvImpl() {
	}

	@Autowired
	public HomeNewsPicSrvImpl(@Qualifier(value = "homeNewsPicDao") CommonDao<HomeNewsPic, String> commonDao) {
		super(commonDao);
	}
}
