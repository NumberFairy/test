package com.wisdombud.alumni.manage.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.manage.BaseAlumniEnrollSrv;
import com.wisdombud.alumni.pojo.dic.DicRegister;
import com.wisdombud.alumni.pojo.manage.BaseAlumniEnroll;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友登记表Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "baseAlumniEnrollSrv")
public class BaseAlumniEnrollSrvImpl extends BaseSrvImpl<BaseAlumniEnroll> implements BaseAlumniEnrollSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseAlumniEnrollSrvImpl.class);
	@Autowired
	public DicCommonSrv	dicCommonSrv;

	public BaseAlumniEnrollSrvImpl() {
	}

	@Autowired
	public BaseAlumniEnrollSrvImpl(
			@Qualifier(value = "baseAlumniEnrollDao") CommonDao<BaseAlumniEnroll, String> commonDao) {
		super(commonDao);
	}

	private void fillName(List<BaseAlumniEnroll> list) {
		for (BaseAlumniEnroll inst : list) {
			fillName(inst);
		}
	}

	private void fillName(BaseAlumniEnroll entity) {
		if(StringUtils.isNotBlank(entity.getEnrollType()) && StringUtils.isNumeric(entity.getEnrollType())){
			entity.setEnrollTypeName(dicCommonSrv.findById(DicRegister.class, new Integer(entity.getEnrollType())).getValue());
		}
	}

	@Override
	public void page(PageEntity<BaseAlumniEnroll> pageEntity, Map<String, Param> params, List<Order> orders) {
		super.page(pageEntity, params, orders);
		List<BaseAlumniEnroll> list = pageEntity.getResults();
		this.fillName(list);
	}

	@Override
	public BaseAlumniEnroll find(String id) {
		BaseAlumniEnroll entity = super.find(id);
		this.fillName(entity);
		return entity;
	}
}
