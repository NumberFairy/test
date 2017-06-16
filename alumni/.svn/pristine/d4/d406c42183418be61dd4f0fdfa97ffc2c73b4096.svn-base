package com.wisdombud.alumni.dao.common;

import java.util.List;

import com.wisdombud.alumni.pojo.dic.DicCountryDistrict;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * Function: 字典表查询dao <br/>
 */
public interface DicCommonDao extends CommonDao<Object, String> {

	<T> T findById(Class<T> clazz, int id);

	<T> T findById(Class<T> clazz, String id);

	<T> List<T> findAll(Class<T> clazz);

	<T> String findValueById(Class<T> clazz, int id);

	<T> String findValueById(Class<T> clazz, String id);
	
	/**
	 * @DES:专业
	 * @autor:xiefei<br/>
	 */
	List<DicSpecialty> findAllSpecialty();

	List<DicSpecialty> findAllCollegeSpecialty(Integer collegeId);

	List<DicCountryDistrict> findAllDistrict();

	List<DicCountryDistrict> findAllCNDistrict();
	
}
