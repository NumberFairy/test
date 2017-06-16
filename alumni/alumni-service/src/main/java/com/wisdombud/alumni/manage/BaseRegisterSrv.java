package com.wisdombud.alumni.manage;

import java.util.List;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseRegister;

/**
 * 校友注册表 ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseRegisterSrv extends IBaseSrv<BaseRegister> {

	/**
	 * @DES:匹配已有校友 name姓名 enrollYear入学年份
	 * @autor:xiefei<br/>
	 */
	List<BaseAlumni> matchingAlumni(String name,Integer enrollYear);

	/**
	 * @DES;审核通过
	 * @autor:xiefei<br/>
	 */
	void addOrUpdateAlumni(BaseRegister v);
}