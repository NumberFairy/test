package com.wisdombud.alumni.dao.manage;

import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.vo.RemindVo;
import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 提醒事件 Dao. <br/>
 * 
 * @author xiefei
 */
public interface BaseRemindDao extends CommonDao<BaseAlumni, String> {

	/**
	 * @DES:提醒事件
	 * @param:beforeDay 提前提醒的天数，默认两天
	 * @autor:xiefei<br/>
	 */
	void page(PageEntity<RemindVo> page, Integer beforeDay,String key);

}