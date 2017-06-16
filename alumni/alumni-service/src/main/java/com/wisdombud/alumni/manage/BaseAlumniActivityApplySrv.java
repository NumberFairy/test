package com.wisdombud.alumni.manage;

import java.util.List;
import java.util.Map;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniActivityApply;

/**
 * 校友活动申请表 ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseAlumniActivityApplySrv extends IBaseSrv<BaseAlumniActivityApply> {

	List<BaseAlumniActivityApply> findAllByDesc(Map<String, String> parms, List<String> orderPropertyList);

	void updateAudit(String id, Integer auditStatus, String auditPerson);

}