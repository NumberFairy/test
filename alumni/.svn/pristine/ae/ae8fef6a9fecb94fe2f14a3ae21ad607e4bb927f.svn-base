package com.wisdombud.alumni.dao.manage;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 留言表 Dao. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseMessageBoardDao extends CommonDao<BaseMessageBoard, String> {

	void page(PageEntity<BaseMessageBoard> pageEntity, Map<String, Param> params, List<Order> orders);
}