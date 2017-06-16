package com.wisdombud.alumni.dao.manage;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友活动表 Dao. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseAlumniActivityDao extends CommonDao<BaseAlumniActivity, String> {
	void pageHomeActive(PageEntity<HomeInformationRelease> pageEntity, String menuId);

	public void page(PageEntity<BaseAlumniActivity> pageEntity, Map<String, Param> params, List<Order> orders);
}