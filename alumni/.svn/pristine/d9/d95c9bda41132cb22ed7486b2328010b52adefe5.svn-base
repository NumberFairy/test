package com.wisdombud.alumni.dao.system;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

public interface SecUserDao extends CommonDao<SecUser, String> {
	public void page(PageEntity<SecUser> pageEntity, Map<String, Param> params, List<Order> orders);
}