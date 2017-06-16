package com.wisdombud.alumni.manage.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.manage.BaseAlumniBranchStaffSrv;
import com.wisdombud.alumni.pojo.dic.DicAlumniBranchIdentity;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchStaff;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.orm.hibernate.CommonDao;

	/**
     * 校友分会人员职务表Srv. <br/>
     * @author Administrator

     */
@Service(value= "baseAlumniBranchStaffSrv")
public class BaseAlumniBranchStaffSrvImpl extends BaseSrvImpl<BaseAlumniBranchStaff> implements BaseAlumniBranchStaffSrv {

    @Autowired
    private DicCommonSrv dicSrv;


    public BaseAlumniBranchStaffSrvImpl(){}

	@Autowired
	public BaseAlumniBranchStaffSrvImpl(@Qualifier(value = "baseAlumniBranchStaffDao") CommonDao<BaseAlumniBranchStaff, String> commonDao) {
		super(commonDao);
	}

	@Override
	public List<BaseAlumniBranchStaff> findLeaders(Map<String, Param> params, List<Order> orders) {
		List<BaseAlumniBranchStaff> list = this.findBy(params, orders);
		for (BaseAlumniBranchStaff staff: list) {
			staff.setStaffStr(this.fillStaffStr(staff.getStaff()));
		}
		return list;
	}

	private String fillStaffStr(String key){
		List<DicAlumniBranchIdentity> list = dicSrv.findAll(DicAlumniBranchIdentity.class);
		for (DicAlumniBranchIdentity inst : list) {
			if (key.equals(inst.getId())) {
				return inst.getValue();
			}
		}
		return null;
	}
}
