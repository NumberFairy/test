package com.wisdombud.alumni.manage;

import java.util.List;

import com.wisdombud.alumni.common.IBaseSrv;

import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;

/**
 * 身份信息关联表’ ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseIdentityRelationSrv extends IBaseSrv<BaseIdentityRelation> {
	/**
	 * 功能: 获得选中的所有email邮箱.<br/>
	 * date: 2017年4月10日 上午10:01:39 <br/>
	 *
	 * @author czjia
	 * @param ids
	 * @return
	 */
	String getSelectedEmail(String ids);

	List<String> string2List(String strs);
	
	/**
	 * 功能: 移除相应校友身份.<br/>
	 * date: 2017年4月13日 上午10:40:47 <br/>
	 *
	 * @author czjia
	 * @param id
	 */
	void updateALumniIdentity(String id,int alumniIdentityId);
	
}