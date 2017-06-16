package com.wisdombud.alumni.manage;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchStaff;
import com.wisdombud.alumni.vo.Param;
import com.wisdombud.alumni.common.IBaseSrv;
	/**
     * 校友分会人员职务表 ISrv. <br/>
     * @author Administrator

     */
public interface BaseAlumniBranchStaffSrv extends IBaseSrv<BaseAlumniBranchStaff>{

		List<BaseAlumniBranchStaff> findLeaders(Map<String, Param> buildParams, List<Order> buildOrder);

}