package com.wisdombud.alumni.system;

import java.util.List;
import java.util.Map;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.system.SecOper;
import com.wisdombud.alumni.vo.MenuVo;
import com.wisdombud.alumni.vo.ZTreeVo;

public interface SecOperSrv extends IBaseSrv<SecOper> {

	/**
	 * 功能：根据用户ID查出可操作的菜单. <br/>
	 *
	 * @author zxguan
	 *
	 */
	List<SecOper> findOperListByUserId(String userId);

	void updateconfigureAuthority(final String roleId, final String operIdList);

	Map<SecOper, List<SecOper>> transform2OperMap(List<SecOper> operList);

	List<MenuVo> transform2MenuVo(Map<SecOper, List<SecOper>> operList);

	/**
	 * @DES:构造菜单树
	 * @autor:xiefei<br/>
	 */
	List<ZTreeVo> buildOperTree(List<SecOper> alllOper,List<SecOper> userOper);
}