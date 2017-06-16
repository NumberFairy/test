package com.wisdombud.alumni.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.dao.system.HomeMenuDao;
import com.wisdombud.alumni.pojo.system.HomeMenu;
import com.wisdombud.alumni.system.HomeMenuSrv;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.vo.HomeMenuTreeVo;

import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 门户菜单Srv. <br/>
 * 
 * @author xiefei
 */
@Service(value = "homeMenuSrv")
public class HomeMenuSrvImpl extends BaseSrvImpl<HomeMenu> implements HomeMenuSrv {

	@Autowired
	private HomeMenuDao menuDao;

	// 留言板菜单,只允许修改操作
	public final int LIU_YAN_BAN = 80;
	// 活动第一个字菜单修改url
	public final int ACTIVE = 40;
	public final String LIST_URL = "/home-api!pageHomeInfo";
	public final String DETAIL_URL = "/home-api!detail";
	public final String ACTIVE_URL = "/home-api!pageActiveInfo";

	public HomeMenuSrvImpl() {
	}

	@Autowired
	public HomeMenuSrvImpl(@Qualifier(value = "homeMenuDao") CommonDao<HomeMenu, String> commonDao) {
		super(commonDao);
	}

	@Override
	public List<HomeMenuTreeVo> buildTree() {
		List<HomeMenu> menus = menuDao.findBy(new HashMap<>());
		return build(menus);
	}

	public List<HomeMenu> buildInfoTree() {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", HomeMenu.ROOT);
		map.put("toUse", HomeMenu.TO_USE_YES);
		List<HomeMenu> menus = menuDao.findBy(map);
		List<HomeMenu> list = new ArrayList<>();
		for (HomeMenu v : menus) {
			if (v.getMenuId() != LIU_YAN_BAN) {
				map.put("parentId", v.getMenuId());
				map.put("buildIn", HomeMenu.BUILD_IN_NO);
				List<HomeMenu> child = menuDao.findBy(map);
				v.setChildren(child);
				list.add(v);
			}
		}
		return menus;
	}

	private List<HomeMenuTreeVo> build(List<HomeMenu> menus) {
		List<HomeMenuTreeVo> nodeList = new ArrayList<>();
		for (HomeMenu v : menus) {
			if (v.getParentId() == HomeMenu.ROOT) {
				HomeMenuTreeVo node = new HomeMenuTreeVo();
				node.setBuildIn(v.getBuildIn());
				node.setId(v.getMenuId());
				node.setName(v.getName());
				node.setOpen(true);
				node.setParent(true);
				if (v.getMenuId() == LIU_YAN_BAN) {
					node.setParent(false);
				}
				node.setType(v.getType());
				node.setSort(v.getSort());
				node.setpId(v.getParentId());
				node.setRight(true);
				node.setToUse(v.getToUse());
				node.setUploadFile(v.getUploadFile());
				node.setUploadImg(v.getUploadImg());
				node.setUploadVideo(v.getUploadVideo());
				node.setChildren(buildChildNode(menus, v.getMenuId()));
				nodeList.add(node);
			}
		}
		return nodeList;
	}

	private List<HomeMenuTreeVo> buildChildNode(List<HomeMenu> menus, Integer pid) {
		List<HomeMenuTreeVo> nodeList = new ArrayList<>();
		for (HomeMenu v : menus) {
			if (v.getParentId() == pid) {
				HomeMenuTreeVo node = new HomeMenuTreeVo();
				node.setBuildIn(v.getBuildIn());
				node.setId(v.getMenuId());
				node.setName(v.getName());
				node.setOpen(true);
				node.setParent(false);
				node.setpId(v.getParentId());
				node.setRight(true);
				node.setType(v.getType());
				node.setSort(v.getSort());
				node.setToUse(v.getToUse());
				node.setUploadFile(v.getUploadFile());
				node.setUploadImg(v.getUploadImg());
				node.setUploadVideo(v.getUploadVideo());
				nodeList.add(node);
			}
		}
		return nodeList;
	}

	@Override
	public void saveOrUpdate(HomeMenu entity) {
		if (entity.getMenuId() != null) {
			HomeMenu home = findUniqueBy("menuId", entity.getMenuId());
			BeanUtils.copyProperties(entity, home);
		} else {
			entity.setCreateTime(new Date());
			entity.setBuildIn(HomeMenu.BUILD_IN_NO);
			entity.setLastUpdate(new Date());
			entity.setMenuId(getMenuId(entity.getParentId()));
			if (entity.getType() == HomeMenu.TYPE_LIST) {
				entity.setUrl(LIST_URL);
			} else {
				entity.setUrl(DETAIL_URL);
			}
			save(entity);
		}
	}

	public int getMenuId(Integer pid) {
		List<HomeMenu> menus = findBy("parentId", pid);
		return pid * 100 + 1 + menus.size();
	}

	@Override
	public List<HomeMenu> updatebuildHomeTree() {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", HomeMenu.ROOT);
		map.put("toUse", HomeMenu.TO_USE_YES);
		List<HomeMenu> menus = menuDao.findBy(map);
		List<HomeMenu> list = new ArrayList<>();
		for (HomeMenu v : menus) {
			map.put("parentId", v.getMenuId());
			map.put("buildIn", HomeMenu.BUILD_IN_NO);
			List<HomeMenu> child = menuDao.findBy(map);
			if (v.getMenuId() == ACTIVE && CollectionUtils.isNotEmpty(child)) {
				HomeMenu act = child.get(0);
				act.setUrl(ACTIVE_URL);
				update(act);
			}
			v.setChildren(child);
			list.add(v);
		}
		return menus;
	}

	@Override
	public List<HomeMenu> findLeftMenu(Integer menuId) {
		HomeMenu menu = menuDao.findUniqueBy("menuId", menuId);
		Map<String, Object> map = new HashMap<>();
		map.put("toUse", HomeMenu.TO_USE_YES);
		if (menu.getParentId() == HomeMenu.ROOT) {
			map.put("parentId", menuId);
			List<HomeMenu> list = menuDao.findBy(map);
			if (CollectionUtils.isEmpty(list)) {
				list = new ArrayList<>();
				list.add(menu);
			}
			return list;
		} else {
			map.put("parentId", menu.getParentId());
			return menuDao.findBy(map);
		}
	}

	@Override
	public List<HomeMenu> findChildrenMenu(Integer menuId) {
		HomeMenu menu = menuDao.findUniqueBy("menuId", menuId);
		if (menu.getParentId() == HomeMenu.ROOT) {
			Map<String, Object> map = new HashMap<>();
			map.put("toUse", HomeMenu.TO_USE_YES);
			map.put("parentId", menuId);
			return menuDao.findBy(map);
		}
		return new ArrayList<>();
	}
}
