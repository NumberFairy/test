package com.wisdombud.alumni.manage.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.enums.GenderEnum;
import com.wisdombud.alumni.enums.IdentityEnum;
import com.wisdombud.alumni.enums.UserDesignationEnum;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseRegisterSrv;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.dic.DicDegree;
import com.wisdombud.alumni.pojo.dic.DicIndustry;
import com.wisdombud.alumni.pojo.dic.DicNational;
import com.wisdombud.alumni.pojo.dic.DicPoliticalStatus;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseRegister;
import com.wisdombud.alumni.pojo.system.PublicUser;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.system.PublicUserSrv;
import com.wisdombud.alumni.system.SecUserSrv;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.util.IdKit;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友注册表Srv. <br/>
 *
 * @author Administrator
 *
 */
@Service(value = "baseRegisterSrv")
public class BaseRegisterSrvImpl extends BaseSrvImpl<BaseRegister> implements BaseRegisterSrv {
	private static final Logger LOGGER = Logger.getLogger(BaseRegisterSrvImpl.class);
	@Autowired
	private BaseAlumniSrv alumniSrv;
	@Autowired
	private PublicUserSrv userSrv;
	@Autowired
	private SecUserSrv secUserSrv;
	@Autowired
	public DicCommonSrv dicCommonSrv;

	private Map<Integer, String> political;

	public BaseRegisterSrvImpl() {
	}

	@Autowired
	public BaseRegisterSrvImpl(@Qualifier(value = "baseRegisterDao") CommonDao<BaseRegister, String> commonDao) {
		super(commonDao);
	}

	public BaseRegister find(String id) {
		BaseRegister entity = super.find(id);
		this.fillName(entity);
		return entity;
	}

	@Override
	public List<BaseAlumni> matchingAlumni(String name, Integer enrollYear) {
		Map<String, Param> map = new HashMap<>();
		map.put("name", Param.like(name));
		map.put("enrollYear", Param.eq(enrollYear));
		List<BaseAlumni> list = alumniSrv.findBy(map, new ArrayList<>());
		alumniSrv.fillName(list);
		return list;
	}

	@Override
	public void page(PageEntity<BaseRegister> pageEntity, Map<String, Param> params, List<Order> orders) {
		super.page(pageEntity, params, orders);
		for (BaseRegister v : pageEntity.getResults()) {
			fillName(v);
		}
	}

	public void fillName(BaseRegister entity) {
		initDic();
		if (StringUtils.isNotBlank(entity.getAuditor())) {
			SecUser user = secUserSrv.find(entity.getAuditor());
			entity.setAuditor(user != null ? user.getName() : "");
		}
		if (entity.getCollege() != null) {
			entity.setCollegeName(dicCommonSrv.findById(DicCollege.class, entity.getCollege()).getCnName());
		}
		if (entity.getIdentity() != null) {
			entity.setIdentityName(IdentityEnum.valueByIndex(entity.getIdentity()).getName());
		}
		if (entity.getGender() != null) {
			entity.setGenderName(GenderEnum.valueByIndex(entity.getGender()).getName());
		}
		if (entity.getPoliticalStatus() != null) {
			entity.setPoliticalStatusName(political.get(entity.getPoliticalStatus()));
		}
		if (entity.getMajor() != null) {
			DicSpecialty dic = dicCommonSrv.findById(DicSpecialty.class, entity.getMajor());
			entity.setMagorName(dic.getCnName());
		}
		if (entity.getHighestEducation() != null) {
			entity.setHighestEducationName(
					dicCommonSrv.findById(DicDegree.class, entity.getHighestEducation()).getCnName());
		}
		if (entity.getIndustry() != null) {
			entity.setIndustryName(dicCommonSrv.findById(DicIndustry.class, entity.getIndustry()).getValue());
		}

		if (StringUtils.isNotBlank(entity.getReVarchar0())) {
			entity.setNationalName(
					dicCommonSrv.findById(DicNational.class, new Integer(entity.getReVarchar0())).getValue());
		}
	}

	private void initDic() {
		List<DicPoliticalStatus> list = dicCommonSrv.findAll(DicPoliticalStatus.class);
		political = new HashMap<>();
		for (DicPoliticalStatus d : list) {
			political.put(d.getId(), d.getValue());
		}
	}

	@Override
	public void addOrUpdateAlumni(BaseRegister v) {
		// 存在已知校友，覆盖
		BaseAlumni alumi = new BaseAlumni();
		if (StringUtils.isNotBlank(v.getAlumnid())) {
			alumi = alumniSrv.find(v.getAlumnid());
			if (alumi != null) {
				addTimeLine(v, alumi);
				BeanUtils.copyProperties(v, alumi, "createTime", "id");
				PublicUser u = userSrv.find(alumi.getId());
				if (u == null) {
					userSrv.addUser(alumi.getId(), v.getLoginName(), v.getPassword(),
							UserDesignationEnum.ALUMNI.getValue());
				}
			}
		} else {
			BeanUtils.copyProperties(v, alumi, "id");
			// 增加用户
			PublicUser user = userSrv.addUser(IdKit.uuid(), v.getLoginName(), v.getPassword(),
					UserDesignationEnum.ALUMNI.getValue());
			if (user == null) {
				LOGGER.error(v.getLoginName() + " 该登录账号已存在，但未找到关联学生信息！");
			}
			// 未找到已知校友-新增
			alumi.setId(user.getId());
			alumniSrv.save(alumi);
		}
	}

	/**
	 * @DES:添加时光轴
	 * @autor:xiefei<br/>
	 */
	private void addTimeLine(BaseRegister news, BaseAlumni alumi) {
		BaseAlumni s = new BaseAlumni();
		BeanUtils.copyProperties(news, s);
		alumniSrv.saveTimeLine(s, alumi);
	}
}
