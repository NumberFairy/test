package com.wisdombud.alumni.dao.system.impl;

import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.system.PublicUserDao;
import com.wisdombud.alumni.pojo.system.PublicUser;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

@Repository(value = "publicUserDao")
public class PublicUserDaoImpl extends SimpleHibernateDao<PublicUser, String> implements PublicUserDao {


}
