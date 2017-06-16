package com.wisdombud.alumni.codegen;

import java.io.File;
import java.io.IOException;

public class ISrvMaker extends BaseMaker {
	@Override
	protected void setRealTemplate(String abc) throws IOException {
		super.template = cfg.getTemplate("ISrv.ftl");

	}

	@Override
	protected String fillRoot() throws IOException {
		return new File("").getCanonicalPath() + "\\target\\output\\erp\\isrv\\";
	}

	@Override
	protected String fillSuffix() throws IOException {
		return "Srv";
	}

}
