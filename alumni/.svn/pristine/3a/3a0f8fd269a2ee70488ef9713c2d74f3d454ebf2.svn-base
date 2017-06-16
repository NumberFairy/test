package com.wisdombud.alumni.dao.system.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.system.SecOperDao;
import com.wisdombud.alumni.pojo.system.SecOper;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

@Repository(value = "secOperDao")
public class SecOperDaoImpl extends SimpleHibernateDao<SecOper, String> implements SecOperDao {

	// 找到菜单的对象集合
	@Override
	public List<SecOper> findByOperIds(List<String> operIdList) {
		if (CollectionUtils.isEmpty(operIdList)) {
			return new ArrayList<>();
		}
		String hql = " From SecOper where id in (:operIds) ";
		Map<String, Object> params = new HashMap<>();
		params.put("operIds", operIdList);
		return createQuery(hql, true, params).list();
	}

}
