package com.wisdombud.alumni.codegen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.wisdombud.alumni.utils.Toolkit;

public class DaoMaker extends BaseMaker {
	public static void main(String[] args) throws Exception {

		String csvPaht = "D:/Projects/TanWei_ERP/radiosky-erp/erp-tool/src/main/resources/sql-csv";
		List<String> filePathList = Toolkit.findAllCsv(csvPaht);
		String sqlContent = "";
		for (String filePath : filePathList) {
			DaoMaker daoMaker = new DaoMaker();
			daoMaker.makeSingle(filePath);
			System.out.println(sqlContent);
		}

		// IDao
		for (String filePath : filePathList) {
			IDaoMaker iDaoMaker = new IDaoMaker();
			iDaoMaker.makeSingle(filePath);
			System.out.println(sqlContent);
		}

		// Isrv
		for (String filePath : filePathList) {
			ISrvMaker iSrvMaker = new ISrvMaker();
			iSrvMaker.makeSingle(filePath);
			System.out.println(sqlContent);
		}

		// Srv
		for (String filePath : filePathList) {
			SrvMaker srvMaker = new SrvMaker();
			srvMaker.makeSingle(filePath);
			System.out.println(sqlContent);
		}

		// pojo
		for (String filePath : filePathList) {
			PojoMaker pojoMaker = new PojoMaker();
			pojoMaker.makeSingle(filePath);
			System.out.println(sqlContent);
		}

		//// 读取.csv 写入sql
		// GenSqlTool genSqlTool = new GenSqlTool();
		// String fileSqlPath = "C:/Users/wisdombud/Desktop/ERP.sql";
		// genSqlTool.write2Sql(csvPaht, fileSqlPath);
	}

	@Override
	protected void setRealTemplate(String abc) throws IOException {
		super.template = cfg.getTemplate("Dao.ftl");

	}

	@Override
	protected String fillRoot() throws IOException {
		return new File("").getCanonicalPath() + "\\target\\output\\erp\\dao\\";
	}

	@Override
	protected String fillSuffix() throws IOException {
		return "DaoImpl";
	}

	@Override
	protected void fillInput() {
		input.put("entityName", entityName);
		input.put("comment", getComment(super.filePath).replace("'", ""));
		input.put("lowerEntityName", lowerEntityName);
	}
}
