/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.common;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;

/**
 * 功能: 公共的service接口，主要完成CRUD操作.<br/>
 * date: 2015年3月10日 上午9:50:02 <br/>
 *
 * @author lizhao@wisdombud.com
 * @version
 * @since JDK 1.7
 */
public interface IBaseSrv<T> {

	/**
	 * 功能: 根据mongo id 查找对象.<br/>
	 * date: 2015年3月10日 上午11:56:31 <br/>
	 *
	 * @author lizhao@wisdombud.com
	 * @param id
	 * @return
	 */
	public T find(String id);

	/**
	 * 功能: 得到所有的实体对象集合.<br/>
	 * date: 2015年3月10日 上午11:57:34 <br/>
	 *
	 * @author lizhao@wisdombud.com
	 * @return
	 */
	public List<T> findAll();

	String save(T entity);

	void update(T entity);

	/**
	 * 功能: 保存或者更新实体对象.<br/>
	 * date: 2015年3月10日 上午11:56:54 <br/>
	 *
	 * @author lizhao@wisdombud.com
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 功能: 根据条件查询满足条件的对象集合.<br/>
	 * date: 2015年3月10日 上午11:57:52 <br/>
	 *
	 * @author lizhao@wisdombud.com
	 * @param paramMap
	 * @param orderList
	 * @return
	 */
	public List<T> findBy(Map<String, Param> params, List<Order> orderList);

	/**
	 * 根据排序字段降序查找. <br/>
	 *
	 * @author guohuilin
	 * @param paramMap
	 * @param orderPropertyList
	 * @return
	 */
	public List<T> findByDesc(Map<String, Object> paramMap, List<String> orderPropertyList);

	/**
	 * 根据排序字段升序查找. <br/>
	 *
	 * @author guohuilin
	 * @param paramMap
	 * @param orderPropertyList
	 * @return
	 */
	public List<T> findByAsc(Map<String, Object> paramMap, List<String> orderPropertyList);

	/**
	 * 功能: 根据条件查询满足条件的对象.<br/>
	 * date: 2015年3月10日 上午11:57:52 <br/>
	 *
	 * @author lizhao@wisdombud.com
	 * @param paramMap
	 * @param orderList
	 * @return
	 */
	public T findUniqueBy(Map<String, Object> paramMap, List<Order> orderList);

	/**
	 * 功能: 根据条件查询满足条件的对象.<br/>
	 * date: 2015年4月7日 下午3:23:32 <br/>
	 *
	 * @author joseph
	 * @param key
	 * @param value
	 * @return
	 */
	public T findUniqueBy(String key, Object value);

	/**
	 *
	 * 功能: 查询表中第一条数据.<br/>
	 * date: 2017年2月17日 上午10:23:06 <br/>
	 *
	 * @author xushuai
	 * @return
	 */
	public T findFirst();

	/**
	 * 功能: 根据条件查询满足条件的所有对象.<br/>
	 * date: 2015年4月8日08:32:11 <br/>
	 *
	 * @author joseph
	 * @param key
	 * @param value
	 * @return
	 */
	public List<T> findBy(String key, Object value);

	/**
	 * 这里用一句话描述这个方法的作用. <br/>
	 *
	 * @author guohuilin
	 * @param params
	 * @return
	 */
	public List<T> findBy(Map<String, Object> params);

	/**
	 *
	 * 功能: 分页方法.<br/>
	 * date: 2017年2月23日 下午5:30:35 <br/>
	 *
	 * @author zlliu
	 * @param pageEntity
	 * @param params
	 * @param orders
	 */
	public void page(PageEntity<T> pageEntity, Map<String, Param> params, List<Order> orders);

	/**
	 * 功能: 根据id 删除对象.<br/>
	 * date: 2015年3月10日 上午11:58:55 <br/>
	 *
	 * @author lizhao@wisdombud.com
	 * @param id
	 */
	public void deleteById(String id);

	/**
	 *
	 * 功能: 根据ids 删除多个对象.<br/>
	 * date: 2017年2月17日 上午10:21:51 <br/>
	 *
	 * @author xushuai
	 * @param ids
	 */
	public void deleteByIds(String ids);

	/**
	 *
	 * 功能: 根据条件删除.<br/>
	 * date: 2017年3月3日 上午9:19:21 <br/>
	 *
	 * @author xushuai
	 */
	public void deleteBy(String key, Object value);

}
