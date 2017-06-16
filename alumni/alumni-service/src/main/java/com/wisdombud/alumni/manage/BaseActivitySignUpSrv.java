package com.wisdombud.alumni.manage;

import java.util.List;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseActivitySignUp;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;

/**
 * 报名情况表 ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseActivitySignUpSrv extends IBaseSrv<BaseActivitySignUp> {
	List<BaseAlumniActivity> findMyActivities(String id);
	/**
	 *@DES:报名
	 *@autor:xiefei<br/>
	 */
	void updateBaoming(String userId,String actId);
}