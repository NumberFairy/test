package com.wisdombud.alumni.manage;

import com.wisdombud.alumni.pojo.manage.BaseNotice;
import com.wisdombud.alumni.common.IBaseSrv;
	/**
     * 校友通知表 ISrv. <br/>
     * @author Administrator
     
     */
public interface BaseNoticeSrv extends IBaseSrv<BaseNotice>{

	/**
	 * 功能: 操作状态：启用/停用.<br/>
	 * date: 2017年3月31日 下午5:00:11 <br/>
	 *
	 * @author czjia
	 * @param id
	 */
	void saveChangeStatus(String id);
}