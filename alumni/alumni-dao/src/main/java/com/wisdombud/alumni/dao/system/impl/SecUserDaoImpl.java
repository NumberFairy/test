package com.wisdombud.alumni.dao.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.system.SecUserDao;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

@Repository(value = "secUserDao")
public class SecUserDaoImpl extends SimpleHibernateDao<SecUser, String> implements SecUserDao {

	@Override
	public void page(PageEntity<SecUser> pageEntity, Map<String, Param> params, List<Order> orders) {

		Map<String, Object> values = new HashMap<>();
		StringBuffer hql = new StringBuffer("select i FROM SecUser i, PublicUser a  WHERE i.id = a.id ");

		Param p1 = params.get("name");
		if (p1!=null) {
			hql.append(" and i.name " + p1.getOper() + " :name");
			values.put("name", p1.getVal());
		}
		Param p2 = params.get("loginName");
		if (p2!=null) {
			hql.append(" and a.loginName " + p2.getOper() + " :loginName");
			values.put("loginName", p2.getVal());
		}
		
		
		hql.append(" ORDER BY ");
		for (int i = 0; i < orders.size(); i++) {
			if (i == orders.size() - 1) {
				hql.append("i." + orders.get(i).toString());
				continue;
			}
			hql.append("i." + orders.get(i).toString() + ",");

		}
		pageByHql(hql.toString(), pageEntity, values);
	
		
	}

}
