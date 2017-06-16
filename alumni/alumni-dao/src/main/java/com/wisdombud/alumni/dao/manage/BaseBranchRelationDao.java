package com.wisdombud.alumni.dao.manage;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseBranchRelation;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

	/**
     * 分会信息关联表 Dao. <br/>
     * @author Administrator

     */
public interface BaseBranchRelationDao extends CommonDao<BaseBranchRelation, String> {

	void pageByHql(PageEntity<BaseBranchRelation> pageMenber, Map<String, Param> params, List<Order> buildOrder);

}