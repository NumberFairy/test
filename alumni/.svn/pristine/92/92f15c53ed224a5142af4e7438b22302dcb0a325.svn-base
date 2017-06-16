package com.wisdombud.alumni.manage.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.manage.BaseAlumniActivityApplySrv;
import com.wisdombud.alumni.manage.BaseAlumniActivitySrv;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivityApply;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.system.SecUserSrv;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.vo.Param;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;
import common.toolkit.java.orm.hibernate.GeneralQuery;

/**
 * 校友活动申请表Srv. <br/>
 *
 * @author Administrator
 *
 */
@Service(value = "baseAlumniActivityApplySrv")
public class BaseAlumniActivityApplySrvImpl extends BaseSrvImpl<BaseAlumniActivityApply>
		implements BaseAlumniActivityApplySrv {

	@Autowired
	private BaseAlumniActivitySrv baseAlumniActivitySrv;
	@Autowired
	private SecUserSrv userSrv;
	@Autowired
	private BaseAlumniSrv alumniSrv;

	@Autowired
	public BaseAlumniActivityApplySrvImpl(
			@Qualifier(value = "baseAlumniActivityApplyDao") CommonDao<BaseAlumniActivityApply, String> commonDao) {
		super(commonDao);
	}

	@Override
	public void page(PageEntity<BaseAlumniActivityApply> pageEntity, Map<String, Param> params, List<Order> orders) {
		super.page(pageEntity, params, orders);
		for (BaseAlumniActivityApply v : pageEntity.getResults()) {
			String auditor = v.getAuditor();
			String publisher = v.getPerson();
			if (StringUtils.isNotBlank(auditor)) {
				SecUser user = userSrv.find(auditor);
				v.setAuditor(user != null ? user.getName() : "");
			}
			if (StringUtils.isNotBlank(publisher)) {
				BaseAlumni alumni = alumniSrv.find(publisher);
				v.setPerson(alumni != null ? alumni.getName() : "");
			}
		}
	}

	public List<BaseAlumniActivityApply> findAllByDesc(Map<String, String> parms, List<String> orderPropertyList) {
		GeneralQuery<BaseAlumniActivityApply> gq = commonDao.createGeneralQuery();
		for (String key : parms.keySet()) {
			gq.eq(key, parms.get(key));
		}
		for (String os : orderPropertyList) {
			gq.desc(os);
		}
		return gq.list();
	}

	@Override
	public void updateAudit(String id, Integer auditStatus, String auditPerson) {
		BaseAlumniActivityApply baseAlumniActivityApply = this.find(id);
		BaseAlumniActivity baseAlumniActivity = new BaseAlumniActivity();
		if (baseAlumniActivityApply != null) {
			baseAlumniActivityApply.setStatus(auditStatus);
			baseAlumniActivityApply.setAuditor(auditPerson);
			baseAlumniActivityApply.setAuditTime(new Date());
			super.saveOrUpdate(baseAlumniActivityApply);
			BeanUtils.copyProperties(baseAlumniActivityApply, baseAlumniActivity, "id");
			baseAlumniActivity.setApplicyPerson(baseAlumniActivityApply.getPerson());
			baseAlumniActivity.setCreateTime(new Date());
			baseAlumniActivity.setLastUpdate(new Date());
			baseAlumniActivity.setIsQiYong(1);
			baseAlumniActivity.setIsTop(0);
			baseAlumniActivity.setIsSignUp(1);
			baseAlumniActivity.setPerson(baseAlumniActivityApply.getPerson());
			this.baseAlumniActivitySrv.saveOrUpdate(baseAlumniActivity);
		}
	}

	public BaseAlumniActivityApplySrvImpl() {
	}

}
