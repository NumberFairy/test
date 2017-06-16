package com.wisdombud.alumni.manage;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchApply;

/**
 * 校友入会申请表 ISrv. <br/>
 *
 * @author Administrator
 *
 */
public interface BaseAlumniClubApplySrv extends IBaseSrv<BaseAlumniBranchApply> {

	void savePassFlowStatus(String id);

	void saveUnpassFlowStatus(String id);

}