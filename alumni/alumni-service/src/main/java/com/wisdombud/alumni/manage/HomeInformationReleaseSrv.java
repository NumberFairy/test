package com.wisdombud.alumni.manage;

import com.wisdombud.alumni.pojo.manage.HomeInformationRelease;
import com.wisdombud.alumni.common.IBaseSrv;
	/**
     * 信息发布管理 ISrv. <br/>
     * @author Administrator

     */
public interface HomeInformationReleaseSrv extends IBaseSrv<HomeInformationRelease>{

		void addOrUpdate(HomeInformationRelease entity);

}