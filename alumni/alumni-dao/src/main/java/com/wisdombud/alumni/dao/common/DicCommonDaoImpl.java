package com.wisdombud.alumni.dao.common;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.pojo.dic.DicCountryDistrict;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;

import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

@SuppressWarnings("unchecked")
@Repository
public class DicCommonDaoImpl extends SimpleHibernateDao<Object, String> implements DicCommonDao {

	@Override
	public <T> T findById(Class<T> clazz, int id) {
		String hql = "from " + clazz.getName() + " where id = ?";
		return (T) createHqlQuery(hql, id).uniqueResult();
	}

	@Override
	public <T> T findById(Class<T> clazz, String id) {
		String hql = "from " + clazz.getName() + " where id = ?";
		return (T) createHqlQuery(hql, id).uniqueResult();
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		String hql = "from " + clazz.getName();
		return super.createHqlQuery(hql).list();
	}

	@Override
	public <T> String findValueById(Class<T> clazz, int id) {
		String hql = "select value from " + clazz.getName() + " where id = ?";
		return (String) createHqlQuery(hql, id).uniqueResult();
	}

	@Override
	public <T> String findValueById(Class<T> clazz, String id) {
		String hql = "select value from " + clazz.getName() + " where id = ?";
		return (String) createHqlQuery(hql, id).uniqueResult();
	}
	

	@Override
	public List<DicSpecialty> findAllSpecialty() {
		String hql = "from DicSpecialty";
		Query query = super.getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<DicSpecialty> findAllCollegeSpecialty(Integer collegeId) {
		String hql = "from DicSpecialty where collegeId = ?";
		Query query = super.getSession().createQuery(hql);
		query.setInteger(0, collegeId);
		return query.list();
	}

	@Override
	public List<DicCountryDistrict> findAllDistrict() {
		String hql = "SELECT d FROM DicCountryDistrict d order by id asc";
		Query query = super.getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<DicCountryDistrict> findAllCNDistrict() {
		String hql = "SELECT d FROM DicCountryDistrict d where pcode !='0' order by id asc";
		Query query = super.getSession().createQuery(hql);
		return query.list();
	}

}