package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
import com.wisdombud.alumni.pojo.manage.HomeFriendshipLink;
import com.wisdombud.alumni.dao.manage.HomeFriendshipLinkDao;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;
	/**
	 * 友情链接信息管理 DaoImpl. <br/>
     * @author Administrator
     
     */
@Repository(value="homeFriendshipLinkDao")
	public class HomeFriendshipLinkDaoImpl extends SimpleHibernateDao<HomeFriendshipLink, String> implements HomeFriendshipLinkDao {
	private static final Logger LOGGER = Logger.getLogger(HomeFriendshipLinkDaoImpl.class);
}
