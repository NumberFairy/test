package com.wisdombud.alumni.dao.manage;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;
import com.wisdombud.alumni.vo.Param;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

	/**
     * 身份信息关联表’ Dao. <br/>
     * @author Administrator

     */
public interface BaseIdentityRelationDao extends CommonDao<BaseIdentityRelation, String> {

	public void page(PageEntity<BaseIdentityRelation> pageEntity, Map<String, Param> params, List<Order> orders);
}