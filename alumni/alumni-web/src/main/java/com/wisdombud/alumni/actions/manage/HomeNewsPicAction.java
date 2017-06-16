package com.wisdombud.alumni.actions.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.dao.common.MongoGridFsDao;
import com.wisdombud.alumni.pojo.manage.HomeNewsPic;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 微信轮播图片管理<br/>
 * date: 2017-4-14 17:59:39 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/gateway-menu-manage/cycle-pic/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/library-tube/storehouse-management/storehouse-management-detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/gateway-menu-manage/cycle-pic/page.jsp") })
public class HomeNewsPicAction extends AbstractCrudAction<HomeNewsPic> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MongoGridFsDao gridFsDao;

	public HomeNewsPicAction(@Qualifier(value = "homeNewsPicSrv") IBaseSrv<HomeNewsPic> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		List<Order> oList = new ArrayList<>();
		oList.add(Order.asc("sortFlag"));
		return oList;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> map = new HashMap<String, Param>();
		if (this.entity != null && this.entity.getTitle() != null) {
			map.put("title", Param.like(this.entity.getTitle()));
		}
		return map;
	}

	@Override
	public void delete() {
		if (StringUtils.isNotBlank(this.id)) {
			String[] ids = this.id.split(",");
			for (String f_id : ids) {
				gridFsDao.deleteFile(f_id);
			}
		}
		super.delete();
	}
}
