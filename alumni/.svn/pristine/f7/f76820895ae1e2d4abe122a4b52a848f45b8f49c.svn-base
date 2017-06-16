package com.wisdombud.alumni.dao.manage.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseAlumniClubDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranch;
import com.wisdombud.alumni.vo.Param;
import common.toolkit.java.entity.DateFormat;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;
import common.toolkit.java.util.StringUtil;

/**
 * 校友分会表 DaoImpl. <br/>
 *
 * @author Administrator
 *
 */
@Repository(value = "baseAlumniClubDao")
public class BaseAlumniClubDaoImpl extends SimpleHibernateDao<BaseAlumniBranch, String> implements BaseAlumniClubDao {
	private static final Logger LOGGER = Logger.getLogger(BaseAlumniClubDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findNotJoinBy(Map<String, Param> params, ArrayList<Order> orders, String id) {
		StringBuffer sql = new StringBuffer("SELECT b.id as id FROM BASE_ALUMNI_BRANCH b WHERE b.id not in (");
		sql.append("SELECT BRANCH_ID FROM BASE_BRANCH_RELATION WHERE ALUMNI_ID ='").append(id).append("' UNION ALL ");
		sql.append("SELECT BRANCH_ID FROM BASE_ALUMNI_BRANCH_APPLY WHERE ALUMNI_ID ='").append(id).append("' AND STATUS != 0)");
		sql.append(" AND TYPE = ").append(params.get("type").getVal());

		checkArgument(!StringUtil.isEmpty(sql.toString()), "sql can not be empty");
		Query query = this.createQuery(sql.toString(), false, new HashMap<String, Object>());
		return query.list();
	}

	protected void buildParams(StringBuffer hql, Map<String, Param> params) {
		if (MapUtils.isEmpty(params)) {
			return;
		}
		//20170413兼容列表页面日期查询
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.Date.getFormat());
		for (Entry<String, Param> entry : params.entrySet()) {
			if (entry.getValue().getVal() instanceof Date) {
				hql.append(" AND date_format(" + entry.getKey() + ",'%Y-%m-%d')" + " " + entry.getValue().getOper() + " '" + sdf.format(entry.getValue().getVal()) + "'");
				params.remove(entry.getKey());
			} else {
				hql.append(" AND " + entry.getKey() + " " + entry.getValue().getOper() + " :" + entry.getKey());
			}
		}
	}

	protected void bulidOrders(StringBuffer hql, List<Order> orders) {
		if (CollectionUtils.isEmpty(orders)) {
			return;
		}
		hql.append(" ORDER BY ");
		for (int i = 0; i < orders.size(); i++) {
			if (i == orders.size() - 1) {
				hql.append(orders.get(i).toString());
				continue;
			}
			hql.append(orders.get(i).toString() + ",");

		}
	}
}
