package com.wisdombud.alumni.dao.manage.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseAlumniActivityDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.QueryExtension;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友活动表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseAlumniActivityDao")
public class BaseAlumniActivityDaoImpl extends SimpleHibernateDao<BaseAlumniActivity, String>
		implements BaseAlumniActivityDao {

	@Override
	public void pageHomeActive(PageEntity<HomeInformationRelease> pageEntity, String menuId) {
		Map<String, Object> map = new HashMap<>();
		map.put("menuId", menuId);
		StringBuffer sb = new StringBuffer(" SELECT c.* FROM (");
		sb.append(" SELECT h.ID id,h.TITLE title,h.CREATE_TIME createTime,");
		sb.append(" h.summary,h.IS_TOP isTop,0 isSignUp FROM HOME_INFORMATION_RELEASE h");
		sb.append(" WHERE h.IS_ENABLE=1 AND FIND_IN_SET(:menuId, h.TYPESTR)");
		sb.append(" UNION all SELECT b.ID id,b.TITLE title,b.CREATE_TIME createTime,");
		sb.append(" b.PLACE summary,b.IS_TOP isTop,b.IS_SIGN_UP isSignUp");
		sb.append(" FROM BASE_ALUMNI_ACTIVITY b WHERE b.IS_QIYONG =1");
		sb.append(" ) c where 1=1");
		sb.append(" ORDER BY c.isTop DESC ,createTime DESC");
		super.pageBySql(sb.toString(), pageEntity, queryExtension(), map);
	}

	private QueryExtension<HomeInformationRelease> queryExtension() {
		QueryExtension<HomeInformationRelease> q = new QueryExtension<HomeInformationRelease>() {
			@Override
			public void doExtend(SQLQuery sq) {
				sq.addScalar("id");
				sq.addScalar("title");
				sq.addScalar("createTime");

				sq.addScalar("summary");
				sq.addScalar("isTop");
				sq.addScalar("isSignUp", StandardBasicTypes.INTEGER);
				sq.setResultTransformer(Transformers.aliasToBean(HomeInformationRelease.class));
			}
		};
		return q;
	}

	@Override
	public void page(PageEntity<BaseAlumniActivity> pageEntity, Map<String, Param> params, List<Order> orders) {
		Map<String, Object> values = new HashMap<>();
		StringBuffer hql = new StringBuffer(
				"select aa FROM BaseAlumniActivity aa , PublicUser  pu  WHERE  aa.person = pu.id");

		Param p1 = params.get("title");
		if (p1 != null) {
			hql.append(" and aa.title " + p1.getOper() + " :title");
			values.put("title", p1.getVal());
		}

		Param p2 = params.get("loginName");
		if (p2 != null) {
			hql.append(" and pu.loginName " + p2.getOper() + " :loginName");
			values.put("loginName", p2.getVal());
		}

		Param p3 = params.get("isQiYong");
		if (p3 != null) {
			hql.append(" and aa.isQiYong " + p3.getOper() + " :isQiYong");
			values.put("isQiYong", p3.getVal());
		}

		hql.append(" ORDER BY ");
		for (int i = 0; i < orders.size(); i++) {
			if (i == orders.size() - 1) {
				hql.append("aa." + orders.get(i).toString());
				continue;
			}
			hql.append("aa." + orders.get(i).toString() + ",");

		}
		pageByHql(hql.toString(), pageEntity, values);

	}
}
