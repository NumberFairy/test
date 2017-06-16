package com.wisdombud.alumni.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.HomeFriendshipLinkSrv;
import com.wisdombud.alumni.pojo.manage.HomeFriendshipLink;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 友情链接信息管理Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "homeFriendshipLinkSrv")
public class HomeFriendshipLinkSrvImpl extends BaseSrvImpl<HomeFriendshipLink> implements HomeFriendshipLinkSrv {

	private static final Logger LOGGER = Logger.getLogger(HomeFriendshipLinkSrvImpl.class);

	public HomeFriendshipLinkSrvImpl() {
	}

	@Autowired
	public HomeFriendshipLinkSrvImpl(
			@Qualifier(value = "homeFriendshipLinkDao") CommonDao<HomeFriendshipLink, String> commonDao) {
		super(commonDao);
	}
}
