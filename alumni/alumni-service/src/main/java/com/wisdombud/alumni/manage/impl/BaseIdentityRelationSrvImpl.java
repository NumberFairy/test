package com.wisdombud.alumni.manage.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.dao.manage.BaseIdentityRelationDao;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseIdentityRelationSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 身份信息关联表’Srv. <br/>
 *
 * @author Administrator
 *
 */
@Service(value = "baseIdentityRelationSrv")
public class BaseIdentityRelationSrvImpl extends BaseSrvImpl<BaseIdentityRelation> implements BaseIdentityRelationSrv {

	@Autowired
	private BaseAlumniSrv alumniSrv;

	private BaseIdentityRelationDao identityDao;

	public BaseIdentityRelationSrvImpl() {
	}

	@Autowired
	public BaseIdentityRelationSrvImpl(
			@Qualifier(value = "baseIdentityRelationDao") CommonDao<BaseIdentityRelation, String> commonDao) {
		super(commonDao);
		identityDao = (BaseIdentityRelationDao) commonDao;
	}

	@Override
	public void page(PageEntity<BaseIdentityRelation> pageEntity, Map<String, Param> params, List<Order> orders) {
		identityDao.page(pageEntity, params, orders);
		List<BaseIdentityRelation> list = pageEntity.getResults();
		for (BaseIdentityRelation inst : list) {
			if (StringUtils.isNotBlank(inst.getAlumniId())) {
				BaseAlumni entity = alumniSrv.find(inst.getAlumniId());
				inst.setAlumni(entity);
			}
		}

	}

	@Override
	public BaseIdentityRelation find(String id) {
		BaseIdentityRelation relation = super.find(id);
		if (relation != null && StringUtils.isNotBlank(relation.getAlumniId())) {
			relation.setAlumni(alumniSrv.find(relation.getAlumniId()));
		}
		return relation;
	}

	@Override
	public String getSelectedEmail(String ids) {
		String strEmail = "";
		if (StringUtils.isNotBlank(ids)) {
			for (String str : ids.split(",")) {
				if (StringUtils.isNotBlank(str)) {
					BaseIdentityRelation entity = this.find(str);
					if (entity != null && StringUtils.isNotBlank(entity.getAlumniId())) {
						BaseAlumni alumniEntity = alumniSrv.find(entity.getAlumniId());
						if (alumniEntity != null && StringUtils.isNotBlank(alumniEntity.getEmail()))
							strEmail += alumniEntity.getEmail() + ";";
					}
				}
			}
		}
		return strEmail;
	}

	@Override
	public List<String> string2List(String strs) {
		List<String> strList = Lists.newArrayList();
		if (StringUtils.isNotBlank(strs)) {
			for (String str : strs.split(";")) {
				if (StringUtils.isNotBlank(str)) {
					strList.add(str);
				}
			}
		}
		return strList;
	}

	@Override
	public void updateALumniIdentity(String id, int alumniIdentityId) {
		if (StringUtils.isNotBlank(id)) {
			BaseIdentityRelation relation = super.find(id);
			if (relation != null && StringUtils.isNotBlank(relation.getAlumniIdentityId())) {
				String iden = relation.getAlumniIdentityId();
				List<String> list = new ArrayList<>();
				for (String v : iden.replace(" ", "").split(",")) {
					list.add(v);
				}
				if (list.contains(alumniIdentityId + "")) {
					list.remove(alumniIdentityId + "");
				}
				String val = null;
				if(CollectionUtils.isNotEmpty(list)){
					val=	StringUtils.join(list.toArray(), ",");
				}
				relation.setAlumniIdentityId(val);
			}
		}
	}
}
