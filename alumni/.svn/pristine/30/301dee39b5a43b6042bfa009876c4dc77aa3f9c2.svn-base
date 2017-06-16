package com.wisdombud.alumni.codegen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.Maps;
import com.wisdombud.alumni.utils.Toolkit;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * 功能: TODO.<br/>
 * date: 2017年2月8日 下午3:46:54 <br/>
 *
 * @author zlliu
 * @version
 * @since JDK 1.7
 */
public abstract class BaseMaker {
	protected Map<String, Object> input;
	protected Template template;
	protected Configuration cfg = new Configuration();
	protected String filePath;
	protected String entityName;
	protected String dbName;
	protected String fileName;
	protected String lowerEntityName;
	protected String lowerAlldbName;
	protected String actionName;

	protected abstract void setRealTemplate(String abc) throws IOException;

	public void makeSingle(String path) {

		this.filePath = path;
		this.input = Maps.newHashMap();
		this.fillInput();

		cfg.setClassForTemplateLoading(this.getClass(), "templates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.CHINA);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		this.fileName = Toolkit.getFileName(path).toUpperCase();
		this.dbName = this.fileName.replace(".CSV", "");
		this.entityName = Toolkit.convertUpper2Camel(this.dbName);
		this.actionName=this.entityName.replace("Base", "");
		this.lowerAlldbName = entityName.toLowerCase();
		this.lowerEntityName = Toolkit.toLowerCaseFirstOne(this.entityName);
		this.fillInput();
		try {

			this.setRealTemplate(entityName);
			Writer consoleWriter = new OutputStreamWriter(System.out);
			try {
				template.process(input, consoleWriter);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			String root = this.fillRoot();
			File file=new File(root);
			String className=file.getName().toLowerCase().contains("action")?this.actionName:this.entityName;
			String outFile = root + className + this.fillSuffix() + ".java";
			this.makeParentFolder(outFile);
			Writer fileWriter = new FileWriter(new File(outFile));
			try {
				template.process(input, fileWriter);
			} catch (TemplateException e) {
				e.printStackTrace();
			} finally {
				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void makeParentFolder(String pathname) {
		File file = new File(pathname);
		String parent = file.getParent();
		File pFile = new File(parent);
		if (!pFile.exists()) {
			pFile.mkdirs();
		}
	}

	protected void fillInput() {
		input.put("entityName", entityName);
		input.put("comment", getComment(this.filePath).replace("'", ""));
	}

	protected abstract String fillRoot() throws IOException;

	protected abstract String fillSuffix() throws IOException;

	/**
	 * 功能: 得到注释.<br/>
	 * date: 2017年2月8日 下午3:46:57 <br/>
	 *
	 * @author
	 * @param path
	 * @return
	 */
	public String getComment(String path) {
		String comment = "";
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			String tempString = null;

			while ((tempString = reader.readLine()) != null) {
				if (tempString.startsWith(")ENGINE=InnoDB DEFAULT")) {
					String[] array = tempString.split(",");
					comment = array[1];
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return comment;
	}

}
