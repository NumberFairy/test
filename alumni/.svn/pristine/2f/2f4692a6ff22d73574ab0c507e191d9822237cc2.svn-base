package com.wisdombud.alumni.manage.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.enums.YesOrNoEnum;
import com.wisdombud.alumni.manage.HomeInformationReleaseSrv;
import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.vo.Param;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;
import common.toolkit.java.util.StringUtil;

/**
 * 信息发布管理Srv. <br/>
 * 
 * @author Administrator
 * 
 */
@Service(value = "homeInformationReleaseSrv")
public class HomeInformationReleaseSrvImpl extends BaseSrvImpl<HomeInformationRelease>
		implements HomeInformationReleaseSrv {

	private static final Logger LOGGER = Logger.getLogger(HomeInformationReleaseSrvImpl.class);

	public HomeInformationReleaseSrvImpl() {
	}

	@Autowired
	public HomeInformationReleaseSrvImpl(
			@Qualifier(value = "homeInformationReleaseDao") CommonDao<HomeInformationRelease, String> commonDao) {
		super(commonDao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void page(PageEntity<HomeInformationRelease> pageEntity, Map<String, Param> params, List<Order> orders) {
		StringBuffer hql = new StringBuffer("FROM " + this.getEntityName() + " WHERE 1=1");
		if (params.containsKey("type")) {
			hql.append(" AND FIND_IN_SET(").append(params.get("type").getVal()).append(", TYPESTR) > 0");
			params.remove("type");
		}
		super.buildParams(hql, params);
		super.bulidOrders(hql, orders);

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		for (Entry<String, Param> entry : params.entrySet()) {
			paramsMap.put(entry.getKey(), entry.getValue().getVal());
		}
		Query countQuery, query;
		checkArgument(!StringUtil.isEmpty(hql.toString()), "hql can not be empty");
		countQuery = this.createQuery(generateCountHql(hql.toString()), true, paramsMap);
		query = this.createQuery(hql.toString(), true, paramsMap);

		Number count = (Number) countQuery.uniqueResult();
		pageEntity.setTotalResults(count == null ? 0 : count.longValue()); // 总记录数
		query.setFirstResult(pageEntity.getStart());
		query.setMaxResults(pageEntity.getPageSize());
		List<HomeInformationRelease> results = query.list();
		this.fillStr(results);
		pageEntity.setCurrentPageLength(results.size());// 当前页面记录数
		pageEntity.setTotalPages(); // 总页数
		pageEntity.setResults(results); // 分页数据
	}

	private void fillStr(List<HomeInformationRelease> results) {
		try {
			for (HomeInformationRelease result : results) {
				String isEnableStr = YesOrNoEnum.valueByIndex(Integer.valueOf(result.getIsEnable())).getName();
				String isTopStr = YesOrNoEnum.valueByIndex(Integer.valueOf(result.getIsTop())).getName();
				result.setIsEnableStr(isEnableStr);
				result.setIsTopStr(isTopStr);
			}
		} catch (Exception e) {
			LOGGER.error("表HOME_INFORMATION_RELEASE中isEnable或isTop枚举值为空！");
		}
	}

	@Override
	public void addOrUpdate(HomeInformationRelease entity) {
		if (null != entity) {
			if (StringUtils.isBlank(entity.getId())) {
				if (null == entity.getViewCount()) {
					entity.setViewCount(0);
				}
				if (entity.getCreateTime() == null) {
					entity.setCreateTime(new Date());
				}
				this.save(entity);
			} else {
				entity.setLastUpdate(new Date());
				HomeInformationRelease oldEntity = this.find(entity.id);
				BeanUtils.copyProperties(entity, oldEntity, "id", "createTime");
			}
		}
	}
}
