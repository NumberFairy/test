package com.wisdombud.alumni.manage;

import com.wisdombud.alumni.common.IBaseSrv;

import com.wisdombud.alumni.pojo.manage.BaseTimeline;

/**
 * 校友成长时光轴 ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseTimelineSrv extends IBaseSrv<BaseTimeline> {
	void saveOrUpdate(String content,String alumniId);
}