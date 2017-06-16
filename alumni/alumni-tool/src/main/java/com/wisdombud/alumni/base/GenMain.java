package com.wisdombud.alumni.base;

import java.util.List;

import com.wisdombud.alumni.codegen.ActionMaker;
import com.wisdombud.alumni.codegen.DaoMaker;
import com.wisdombud.alumni.codegen.IDaoMaker;
import com.wisdombud.alumni.codegen.ISrvMaker;
import com.wisdombud.alumni.codegen.PojoMaker;
import com.wisdombud.alumni.codegen.SrvMaker;
import com.wisdombud.alumni.sqlgen.GenSqlTool;
import com.wisdombud.alumni.utils.Toolkit;

public class GenMain {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		path += "/src/main/resources/sql-csv/1/";
		System.out.println(path);
		List<String> filePathList = Toolkit.findAllCsv(path);
		// String csvName = "BASE_DEPOT_TYPE";
		genPo(filePathList);
		//genDao(filePathList);
		//genIDao(filePathList);
		//genSrv(filePathList);
		//genISrv(filePathList);
		// genSingleSql(filePathList, csvName);
		 genSql(filePathList);
		 //genAction(filePathList);
	}

	private static void genAction(List<String> filePathList) {

		ActionMaker pojoMaker = new ActionMaker();
		for (String filePath : filePathList) {
			if (!filePath.toLowerCase().contains("_conf")) {
				// if (filePath.contains("BASE_DEPORT_IN_LIST_CONF.csv")) {
				pojoMaker.makeSingle(filePath);
				// }
			}
		}
	}

	private static void genSingleSql(List<String> filePathList, String csvName) {

		GenSqlTool genSqlTool = new GenSqlTool();
		String path = System.getProperty("user.dir");
		path += "/target/output/erp/erp.sql";

		genSqlTool.write2Sql(filePathList, path, csvName);
	}

	private static void genSql(List<String> filePathList) {

		GenSqlTool genSqlTool = new GenSqlTool();
		String path = System.getProperty("user.dir");
		path += "/target/output/erp/erp.sql";

		genSqlTool.write2Sql(filePathList, path);
	}

	private static void genPo(List<String> filePathList) {
		PojoMaker pojoMaker = new PojoMaker();
		for (String filePath : filePathList) {
			pojoMaker.makeSingle(filePath);
		}

	}

	private static void genDao(List<String> filePathList) {
		DaoMaker daoMaker = new DaoMaker();
		for (String filePath : filePathList) {
			daoMaker.makeSingle(filePath);
		}
	}

	private static void genIDao(List<String> filePathList) {
		IDaoMaker idaoMaker = new IDaoMaker();
		for (String filePath : filePathList) {
			idaoMaker.makeSingle(filePath);
		}
	}

	private static void genSrv(List<String> filePathList) {
		SrvMaker srvMaker = new SrvMaker();
		for (String filePath : filePathList) {
			srvMaker.makeSingle(filePath);
		}
	}

	private static void genISrv(List<String> filePathList) {
		ISrvMaker iSrvMaker = new ISrvMaker();
		for (String filePath : filePathList) {
			iSrvMaker.makeSingle(filePath);
		}
	}
}
