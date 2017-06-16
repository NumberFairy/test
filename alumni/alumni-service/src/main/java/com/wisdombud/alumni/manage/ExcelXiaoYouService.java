package com.wisdombud.alumni.manage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;

import jxl.write.WritableWorkbook;

/**
 * 生成校友通讯录校友
 */
public interface ExcelXiaoYouService {

	public int importExcel(File excelFile) throws IOException;

	void export(List<BaseAlumni> results, String filds, HSSFWorkbook wb);
	<T> void  export(List<T> results, Map<String, String> fildsMap, HSSFWorkbook wb);

	void export(String ids, String filds, WritableWorkbook wb);
	void saveIdentityRelation(BaseAlumniImport inst);
	int saveReal();
}
