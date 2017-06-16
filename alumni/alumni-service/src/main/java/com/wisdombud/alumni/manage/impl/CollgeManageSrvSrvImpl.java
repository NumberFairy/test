package com.wisdombud.alumni.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.dao.dic.DicCollegeDao;
import com.wisdombud.alumni.dao.dic.DicSpecialtyDao;
import com.wisdombud.alumni.manage.CollgeManageSrv;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.vo.ZTreeVo;

@Service
public class CollgeManageSrvSrvImpl implements CollgeManageSrv {
	@Autowired
	private DicCommonSrv srv;
	@Autowired
	private DicCollegeDao collegeDao;
	@Autowired
	private DicSpecialtyDao specialtyDao;

	private final int root = 0;

	@Override
	public List<ZTreeVo> buildCollegeTree() {
		List<DicCollege> colleges = srv.findAll(DicCollege.class);
		List<ZTreeVo> list = new ArrayList<>();
		for (DicCollege v : colleges) {
			ZTreeVo vo = new ZTreeVo();
			vo.setId(v.getId());
			vo.setpId(root);
			vo.setRight(true);
			vo.setParent(true);
			vo.setOpen(false);
			vo.setName(v.getCnName());
			vo.setEnName(v.getEnName());
			list.add(vo);
			list.addAll(buildChildren(v.getId()));
		}
		return list;
	}

	private List<ZTreeVo> buildChildren(Integer collegeId) {
		List<DicSpecialty> specialtys = srv.findAllCollegeSpecialty(collegeId);
		List<ZTreeVo> list = new ArrayList<>();
		for (DicSpecialty v : specialtys) {
			ZTreeVo vo = new ZTreeVo();
			vo.setId(v.getId());
			vo.setpId(collegeId);
			vo.setRight(true);
			vo.setDegreeId(v.getDegreeId());
			vo.setName(v.getCnName());
			list.add(vo);
		}
		return list;
	}

	@Override
	public void saveOrUpdate(DicCollege college) {
		if (college.getId() != null) {
			collegeDao.update(college);
		} else {
			collegeDao.save(college);
		}
	}

	@Override
	public void saveOrUpdate(DicSpecialty specialty) {
		String name = specialty.getCnName();
		if (StringUtils.isNotBlank(name)) {
			specialty.setCnName(name.replace("(本科)", "").replace("(硕士)", "").replace("(博士)", "").replace("博士后", ""));
		}

		if (specialty.getId() != null) {
			specialtyDao.update(specialty);
		} else {
			specialtyDao.save(specialty);
		}
	}

	@Override
	public void delete(Integer id, Integer pid) {
		if (pid == null) {
			collegeDao.deleteById(id);
		} else {
			specialtyDao.deleteById(id);
		}
	}
}
