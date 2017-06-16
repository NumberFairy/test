package com.wisdombud.alumni.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.wisdombud.alumni.dao.common.DicCommonDao;
import com.wisdombud.alumni.pojo.dic.DicCountryDistrict;
import com.wisdombud.alumni.pojo.dic.DicDegree;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.vo.DistrictVo;

@Service
public class DicCommonSrvImpl implements DicCommonSrv {
	@Autowired
	private DicCommonDao dicDao;
	private Map<Integer, String> degrees;

	@Override
	public <T> T findById(Class<T> clazz, int id) {
		return dicDao.findById(clazz, id);
	}

	@Override
	public <T> T findById(Class<T> clazz, String id) {
		return dicDao.findById(clazz, id);
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		return dicDao.findAll(clazz);
	}

	@Override
	public <T> String findValueById(Class<T> clazz, int id) {
		return this.dicDao.findValueById(clazz, id);
	}

	@Override
	public <T> String findValueById(Class<T> clazz, String id) {
		return this.dicDao.findValueById(clazz, id);
	}

	@Override
	public List<DicSpecialty> findAllSpecialty() {
		return dicDao.findAllSpecialty();
	}

	@Override
	public List<DicSpecialty> findAllCollegeSpecialty(Integer collegeId) {
		degrees = this.getDegreeMap();
		List<DicSpecialty> list = dicDao.findAllCollegeSpecialty(collegeId);
		for (DicSpecialty v : list) {
			String degree = degrees.get(v.getDegreeId());
			v.setCnName(v.getCnName() + (StringUtils.isNotBlank(degree) ? ("(" + degree + ")") : ""));
		}
		return list;
	}

	public Map<Integer, String> getDegreeMap() {
		List<DicDegree> list = findAll(DicDegree.class);
		Map<Integer, String> map = Maps.newHashMap();
		for (DicDegree inst : list) {
			if (inst.getId() != null && !map.containsKey(inst.getId())) {
				map.put(inst.getId(), inst.getCnName());
			}
		}
		return map;
	}

	@Override
	public List<DistrictVo> findAllDistricts() {
		List<DistrictVo> voList = new ArrayList<>();
		List<DicCountryDistrict> dList = dicDao.findAllDistrict();
		DistrictVo vo = null;
		for (DicCountryDistrict d : dList) {
			if ("0".equals(d.getPcode())) {
				vo = new DistrictVo(d.getCode(), d.getCode() + "-" + d.getName(), d.getPcode());
			} else {
				vo = new DistrictVo(d.getCode(), d.getName(), d.getPcode());
			}
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public List<DistrictVo> findAllCNDistricts() {
		List<DistrictVo> voList = new ArrayList<>();
		List<DicCountryDistrict> dList = dicDao.findAllCNDistrict();
		DistrictVo vo = null;
		for (DicCountryDistrict d : dList) {
			d.setPcode("CN".equals(d.getPcode()) ? "0" : d.getPcode());
			vo = new DistrictVo(d.getCode(), d.getName(), d.getPcode());
			voList.add(vo);
		}
		return voList;
	}

}
