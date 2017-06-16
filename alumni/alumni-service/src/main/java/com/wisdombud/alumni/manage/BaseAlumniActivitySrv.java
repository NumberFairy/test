package com.wisdombud.alumni.manage;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivity;
import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;

import common.toolkit.java.entity.PageEntity;

/**
 * 校友活动表 ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseAlumniActivitySrv extends IBaseSrv<BaseAlumniActivity> {
	/**
	 * 功能:通过signUpId找alumniId,再通过alumniId找BaseAlumni对应数据.<br/>
	 * date: 2017年4月1日 下午6:05:18 <br/>
	 *
	 * @author czjia
	 * @param signUpId
	 * @return
	 */
	BaseAlumni findAlumni(String signUpId);

	/**
	 *@DES:首页活动
	 *@autor:xiefei<br/>
	 */
	void pageHomeActive(PageEntity<HomeInformationRelease> pageEntity, String menuId);
	
	/**
	 *@DES:是否允许报名
	 *@autor:xiefei<br/>
	 */

	/**
	 * @DES:判断是否允许报名
	 * @autor:xiefei<br/>
	 */
	int isApply(BaseAlumniActivity v) ;

}