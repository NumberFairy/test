package com.wisdombud.alumni.codegen;

import java.io.File;
import java.io.IOException;

public class SrvMaker extends BaseMaker {
	@Override
	protected void setRealTemplate(String abc) throws IOException {
		super.template = cfg.getTemplate("Srv.ftl");

	}

	@Override
	protected String fillRoot() throws IOException {
		return new File("").getCanonicalPath()+"\\target\\output\\erp\\srv\\";
	}

	@Override
	protected String fillSuffix() throws IOException {
		return "SrvImpl";
	}

	@Override
	protected void fillInput() {
		input.put("entityName", entityName);
		input.put("comment", getComment(super.filePath).replace("'", ""));
		input.put("lowerEntityName", lowerEntityName);
	}
}
