package com.wisdombud.alumni.dao.manage;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;

import common.toolkit.java.orm.hibernate.CommonDao;

	/**
     * 校友信息表 Dao. <br/>
     * @author Administrator
     
     */
public interface BaseAlumniImportDao extends CommonDao<BaseAlumniImport, String> {

	void deleteAll();
}