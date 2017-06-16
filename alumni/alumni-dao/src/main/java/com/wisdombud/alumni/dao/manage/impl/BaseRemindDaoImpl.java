package com.wisdombud.alumni.dao.manage.impl;

import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseRemindDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.vo.RemindVo;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.QueryExtension;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 办公桌提醒事件 <br/>
 * 
 * @author xiefei
 */
@Repository(value = "baseRemindDao")
public class BaseRemindDaoImpl extends SimpleHibernateDao<BaseAlumni, String> implements BaseRemindDao {

	@Override
	public void page(PageEntity<RemindVo> page, Integer beforeDay, String key) {
		StringBuffer sb = new StringBuffer(" SELECT s.*  FROM (");
		sb.append(" SELECT a.ID id,a.BIRTH_DATE time,a.NAME title, 0 type FROM BASE_ALUMNI a");
		sb.append(" UNION ALL SELECT b.ID id,b.START_TIME time,b.TITLE title, 1 type");
		sb.append(" FROM BASE_ALUMNI_ACTIVITY b ) s");
		sb.append(" where 1=1 AND s.time>'" + now(null) + "'");
		sb.append(" AND s.time<'" + now(beforeDay == null ? 2 : beforeDay) + "'");
		if (StringUtils.isNotBlank(key)) {
			sb.append(" AND title like '%" + key + "%'");
		}
		sb.append(" ORDER BY s.time DESC");
		pageBySql(sb.toString(), page, queryExtension(), new HashMap<>());
	}

	private QueryExtension<RemindVo> queryExtension() {
		QueryExtension<RemindVo> q = new QueryExtension<RemindVo>() {
			@Override
			public void doExtend(SQLQuery sq) {
				sq.addScalar("id");
				sq.addScalar("time");
				sq.addScalar("title");
				sq.addScalar("type", StandardBasicTypes.INTEGER);
				sq.setResultTransformer(Transformers.aliasToBean(RemindVo.class));
			}
		};
		return q;
	}

	private String now(Integer beforeDay) {
		Calendar ca = Calendar.getInstance();
		if (beforeDay != null && beforeDay > 0) {
			ca.add(Calendar.DAY_OF_MONTH, +beforeDay + 1);
		}
		return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE);
	}
}
