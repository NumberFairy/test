package com.wisdombud.alumni.manage;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranch;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchStaff;
import com.wisdombud.alumni.pojo.manage.BaseBranchRelation;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.vo.AlumniBranchVo;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;

/**
 * 校友分会表 ISrv. <br/>
 *
 * @author Administrator
 *
 */
public interface BaseAlumniClubSrv extends IBaseSrv<BaseAlumniBranch> {

	String fillTypeStr(String type);

	void pageVo(PageEntity<AlumniBranchVo> pageBranchVo, Map<String, Param> buildParams, List<Order> buildOrders);

	void findMemberByBranch(PageEntity<BaseBranchRelation> pageMenber, Map<String, Param> params);

	void addOrUpdate(BaseAlumniBranch entity, List<BaseAlumniBranchStaff> list, String type);

	void deleteAllById(String id);

	String getSelectedEmail(String id);

	void sendEmails(String title, String email, String replyContent);

	void importExcel(File file, String extention);

	void pageMyBranchVo(PageEntity<AlumniBranchVo> pageBranchVo, UserSession session);

	List<BaseAlumniBranch> findIdListNotJoinBy(Map<String, Param> buildParams, UserSession userSession);

}