package com.wisdombud.alumni.dao.manage;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

	/**
     * 校友信息表 Dao. <br/>
     * @author Administrator
     
     */
public interface BaseAlumniDao extends CommonDao<BaseAlumni, String> {
	 void page(PageEntity<BaseAlumni> pageEntity, Map<String, Param> params, List<Order> orders);
	List<BaseAlumni> findBy(Map<String, Param> params, List<Order> orders);
}