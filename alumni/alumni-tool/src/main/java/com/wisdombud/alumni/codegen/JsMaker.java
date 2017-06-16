package com.wisdombud.alumni.codegen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.wisdombud.alumni.utils.Toolkit;

public class JsMaker extends BaseMaker {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		path += "/src/main/resources/sql-csv";
		System.out.println(path);
		List<String> filePathList = Toolkit.findAllCsv(path);
		JsMaker maker = new JsMaker();
		for (String filePath : filePathList) {
			if (!filePath.toLowerCase().contains("_conf")) {
				maker.makeSingle(filePath);
			}
		}
	}

	@Override
	protected void setRealTemplate(String abc) throws IOException {
		super.template = cfg.getTemplate("createjs.ftl");

	}

	@Override
	protected String fillRoot() throws IOException {
		return new File("").getCanonicalPath() + "\\target\\output\\erp\\action\\";
	}

	@Override
	protected String fillSuffix() throws IOException {
		return "Action";
	}

	@Override
	protected void fillInput() {
		input.put("entityName", entityName);
		input.put("lowerAlldbName", lowerAlldbName);
		input.put("lowerEntityName", lowerEntityName);
		input.put("comment", getComment(super.filePath).replace("'", ""));

	}

}
