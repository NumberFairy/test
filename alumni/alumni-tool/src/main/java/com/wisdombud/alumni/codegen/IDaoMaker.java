package com.wisdombud.alumni.codegen;

import java.io.File;
import java.io.IOException;

public class IDaoMaker extends BaseMaker {
	@Override
	protected void setRealTemplate(String abc) throws IOException {
		super.template = cfg.getTemplate("IDao.ftl");

	}

	@Override
	protected String fillRoot() throws IOException {
		return new File("").getCanonicalPath() + "\\target\\output\\erp\\idao\\";
	}

	@Override
	protected String fillSuffix() throws IOException {
		return "Dao";
	}
	
	@Override
	protected void fillInput() {
		input.put("entityName", entityName);
		input.put("comment", getComment(super.filePath).replace("'", ""));
		
	}
	 

}
