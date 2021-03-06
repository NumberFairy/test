package com.wisdombud.alumni.system.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.dao.system.SecRoleDao;
import com.wisdombud.alumni.pojo.system.SecOper;
import com.wisdombud.alumni.pojo.system.SecRole;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.system.SecOperSrv;
import com.wisdombud.alumni.system.SecRoleSrv;
import com.wisdombud.alumni.system.SecUserSrv;
import com.wisdombud.alumni.vo.MenuVo;
import com.wisdombud.alumni.vo.ZTreeVo;

import common.toolkit.java.orm.hibernate.CommonDao;

@Service(value = "secOperSrv")
public class SecOperSrvImpl extends BaseSrvImpl<SecOper> implements SecOperSrv {

	@Autowired
	private SecRoleDao roleDao;
	@Autowired
	private SecRoleSrv roleSrv;
	@Autowired
	private SecUserSrv userSrv;

	public SecOperSrvImpl() {
	}

	@Autowired
	public SecOperSrvImpl(@Qualifier(value = "secOperDao") CommonDao<SecOper, String> commonDao) {
		super(commonDao);
	}

	public void updateconfigureAuthority(final String roleId, final String operIdList) {
		final SecRole role = roleDao.get(roleId);
		final List<String> idList = new ArrayList<>();
		final String[] arr = operIdList.split(",");
		for (String id : arr) {
			idList.add(id);
		}
		final List<SecOper> opers = roleDao.findByOperIds(idList);
		final Set<SecOper> roleOpers = new HashSet<>();
		roleOpers.addAll(opers);
		role.setSecOpers(roleOpers);
		roleDao.update(role);
	}

	@Override
	public List<SecOper> findOperListByUserId(String userId) {
		List<SecOper> operList = Lists.newArrayList();
		SecUser user = userSrv.find(userId);
		List<SecRole> roles = user.getSecRoles();
		SecRole role = new SecRole();
		if (CollectionUtils.isNotEmpty(roles)) {
			role = roles.get(0);
		}
		operList.addAll(role.getSecOpers());
		return operList;
	}

	@Override
	public Map<SecOper, List<SecOper>> transform2OperMap(List<SecOper> operList) {
		Map<SecOper, List<SecOper>> map = Maps.newTreeMap();
		SecOper parentOper = null;
		List<SecOper> children = Lists.newArrayList();
		for (SecOper oper : operList) {
			if ("0".equals(oper.getParentId())) {
				if (null != parentOper) {
					List<SecOper> objChildren = Lists.newArrayList();
					objChildren.addAll(children);
					map.put(parentOper, objChildren);
					children.clear();
				}
				parentOper = oper;
			} else {
				children.add(oper);
			}
		}
		map.put(parentOper, children);
		return map;
	}

	@Override
	public List<MenuVo> transform2MenuVo(Map<SecOper, List<SecOper>> menuList) {
		List<MenuVo> parent = Lists.newLinkedList();
		for (Map.Entry<SecOper, List<SecOper>> entry : menuList.entrySet()) {
			List<MenuVo> children = Lists.newLinkedList();
			MenuVo parentVo = this.copyVal2Vo(entry.getKey());
			for (SecOper oper : entry.getValue()) {
				children.add(this.copyVal2Vo(oper));
			}
			parentVo.setChildren(children);
			parent.add(parentVo);
		}
		return parent;
	}

	private MenuVo copyVal2Vo(SecOper oper) {
		MenuVo vo = new MenuVo();
		vo.setId(oper.getId());
		vo.setParentId(oper.getParentId());
		vo.setDesc(oper.getDesc());
		vo.setName(oper.getName());
		vo.setSortFlag(oper.getSortFlag());
		vo.setUrl(oper.getUrl());
		vo.setIcon(oper.getIcon());
		return vo;
	}

	@Override
	public List<ZTreeVo> buildOperTree(List<SecOper> alllOper, List<SecOper> userOper) {
		List<ZTreeVo> result = new ArrayList<>();
		for (SecOper v : alllOper) {
			ZTreeVo vo = new ZTreeVo();
			vo.setId(new Integer(v.getId()));
			vo.setpId(new Integer(v.getParentId()));
			vo.setName(v.getName());
			vo.setOpen(true);
			if (userOper.contains(v)) {
				vo.setChecked(true);
			}
			result.add(vo);
		}
		return result;
	}
}
