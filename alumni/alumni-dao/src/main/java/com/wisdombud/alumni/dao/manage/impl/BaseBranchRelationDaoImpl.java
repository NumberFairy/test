package com.wisdombud.alumni.dao.manage.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseBranchRelationDao;
import com.wisdombud.alumni.pojo.manage.BaseBranchRelation;
import com.wisdombud.alumni.vo.Param;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 分会信息关联表 DaoImpl. <br/>
 *
 * @author Administrator
 *
 */
@Repository(value = "baseBranchRelationDao")
public class BaseBranchRelationDaoImpl extends SimpleHibernateDao<BaseBranchRelation, String> implements BaseBranchRelationDao {

	private static final Logger LOGGER = Logger.getLogger(BaseBranchRelationDaoImpl.class);

	@Override
	public void pageByHql(PageEntity<BaseBranchRelation> pageMenber, Map<String, Param> params, List<Order> orders) {
		StringBuffer hql = new StringBuffer("FROM BaseBranchRelation where 1=1 ");
		buildParams(hql, params);
		bulidOrders(hql, orders);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		for (Entry<String, Param> entry : params.entrySet()) {
			paramsMap.put(entry.getKey(), entry.getValue().getVal());
		}
		pageByHql(hql.toString(), pageMenber, paramsMap);
	}

	private void bulidOrders(StringBuffer hql, List<Order> orders) {
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

	private void buildParams(StringBuffer hql, Map<String, Param> params) {
		if (MapUtils.isEmpty(params)) {
			return;
		}
		for (Entry<String, Param> entry : params.entrySet()) {
			hql.append(" AND " + entry.getKey() + " " + entry.getValue().getOper() + " :" + entry.getKey());
		}
	}
}
