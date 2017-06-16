package com.wisdombud.alumni.dao.system.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.system.SecRoleDao;
import com.wisdombud.alumni.pojo.system.SecOper;
import com.wisdombud.alumni.pojo.system.SecRole;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

@Repository(value = "secRoleDao")
public class SecRoleDaoImpl extends SimpleHibernateDao<SecRole, String> implements SecRoleDao {

	@Override
	public List<SecRole> findBy(List<String> roleIds) {

		if (CollectionUtils.isEmpty(roleIds)) {
			return new ArrayList<>();
		}
		String hql = " From SecRole where id in (:roleIds) ";
		Map<String, Object> params = new HashMap<>();
		params.put("roleIds", roleIds);
		return createQuery(hql, true, params).list();
	}

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
	
	@Override
	public boolean checkRoleIsExistByName(String roleName, String roleId) {
		final StringBuilder hql = new StringBuilder(" FROM SecRole WHERE name = :roleName and id != :roleId");
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleName", roleName);
		params.put("roleId", roleId);

		final List<SecRole> roleList = super.createQuery(hql.toString(), true, params).list();
		if (roleList.isEmpty()) {
			return false;
		}
		return true;
	}
}
