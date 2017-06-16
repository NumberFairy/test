package com.wisdombud.alumni.dao.manage.impl;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;

import com.wisdombud.alumni.dao.manage.BaseMessageBoardDao;
import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 留言表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseMessageBoardDao")
public class BaseMessageBoardDaoImpl extends SimpleHibernateDao<BaseMessageBoard, String>
		implements BaseMessageBoardDao {
	private static final Logger LOGGER = Logger.getLogger(BaseMessageBoardDaoImpl.class);

	@Override
	public void page(PageEntity<BaseMessageBoard> pageEntity, Map<String, Param> params, List<Order> orders) {
		StringBuffer hql = new StringBuffer("FROM BaseMessageBoard WHERE 1=1");
		Map<String, Object> parm = new HashMap<>();
		buildParams(hql, params);
		bulidOrders(hql, orders);
		for (Entry<String, Param> entry : params.entrySet()) {
			parm.put(entry.getKey(), entry.getValue().getVal());
		}

		pageByHql(hql.toString(), pageEntity, parm);

	}

	protected void buildParams(StringBuffer hql, Map<String, Param> params) {
		if (MapUtils.isEmpty(params)) {
			return;
		}
		if (params.containsKey("createTime")) {
			hql.append(" AND createTime > :createTime");
			hql.append(" AND createTime < :createTimeEnd");
		}

		for (Entry<String, Param> entry : params.entrySet()) {
			if (entry.getKey() != "createTime" && entry.getKey() != "createTimeEnd") {
				hql.append(" AND " + entry.getKey() + " " + entry.getValue().getOper() + " :" + entry.getKey());
			}
		}
	}

	protected void bulidOrders(StringBuffer hql, List<Order> orders) {
		if (CollectionUtils.isEmpty(orders)) {
			return;
		}
		hql.append(" ORDER BY ");
		for (int i = 0; i < orders.size(); i++) {
			if (i == orders.size() - 1) {
				hql.append(orders.get(i).toString());
				continue;
			}
			hql.append(orders.get(i).toString() + ",");

		}
	}
}
