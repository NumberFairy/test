package com.wisdombud.alumni.dao.manage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseAlumniBranch;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.orm.hibernate.CommonDao;

	/**
     * 校友分会表 Dao. <br/>
     * @author Administrator

     */
public interface BaseAlumniClubDao extends CommonDao<BaseAlumniBranch, String> {

		List<String> findNotJoinBy(Map<String, Param> buildParams, ArrayList<Order> arrayList, String id);

}