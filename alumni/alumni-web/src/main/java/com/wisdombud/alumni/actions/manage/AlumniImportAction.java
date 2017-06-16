package com.wisdombud.alumni.actions.manage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
import com.wisdombud.alumni.manage.BaseAlumniImportSrv;
import com.wisdombud.alumni.manage.ExcelXiaoYouService;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友信息表<br/>
 * date: 2017-3-28 19:28:27 <br/>
 *
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace(value = "/")
@Results({ @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-manage-center/alumni-info-note/import-page.jsp") })
public class AlumniImportAction extends AbstractCrudAction<BaseAlumniImport> {

	private static final Logger	LOGGER			 = Logger.getLogger(AlumniImportAction.class);

	private static final long	serialVersionUID = 1L;
	@Autowired
	private MongoGridFsDao		gridFsDao;
	@Autowired
	private ExcelXiaoYouService	excelXYSrv;
	@Autowired
	private BaseAlumniImportSrv	baseAlumniImportSrv;

	private String				f_id;

	public AlumniImportAction(@Qualifier(value = "baseAlumniImportSrv") IBaseSrv<BaseAlumniImport> baseSrv) {
		super(baseSrv);
		this.limit = 100;
	}

	@Override
	protected List<Order> buildOrder() {
		return super.buildOrder();
	}

	@Override
	protected Map<String, Param> buildParams() {
		return super.buildParams();
	}

	public void importExcel() {
		try {
			baseAlumniImportSrv.deleteAll();
			File file = gridFsDao.readFile(f_id);
			int count = excelXYSrv.importExcel(file);
			file.delete();
			sendSuccessMsg(count, "上传成功" + count + "条数据");
		} catch (IOException e) {
			LOGGER.error(e);
			sendFailMsg(null, "上传失败");
		}
	}

	public void saveReal() {
		try {
			int count = excelXYSrv.saveReal();
			sendSuccessMsg(count, "导入成功" + count + "条数据");
		} catch (Exception e) {
			LOGGER.error(e);
			sendFailMsg(null, "导入失败");
		}
	}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}

}
