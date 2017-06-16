package com.wisdombud.alumni.dao.system.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.system.HomeMenuDao;
import com.wisdombud.alumni.pojo.system.HomeMenu;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 门户菜单 . <br/>
 * 
 * @author xiefei
 */
@SuppressWarnings("unchecked")
@Repository(value = "homeMenuDao")
public class HomeMenuDaoImpl extends SimpleHibernateDao<HomeMenu, String> implements HomeMenuDao {

	@Override
	public List<HomeMenu> findBy(Map<String, Object> paramsMap) {
		StringBuffer sb = new StringBuffer(" FROM HomeMenu WHERE 1=1");
		for (String key : paramsMap.keySet()) {
			sb.append(" AND " + key + " =:" + key);
		}
		sb.append(" ORDER BY sort ASC,createTime DESC");
		Query q = createHqlQuery(sb.toString(), paramsMap);
		return q.list();
	}

}
