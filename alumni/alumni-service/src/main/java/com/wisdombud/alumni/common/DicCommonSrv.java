package com.wisdombud.alumni.common;

import java.util.List;

import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.vo.DistrictVo;

public interface DicCommonSrv {

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
	
	List<DistrictVo> findAllDistricts();

	List<DistrictVo> findAllCNDistricts();

}
