package com.wisdombud.alumni.codegen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.wisdombud.alumni.base.CommonValues;
import com.wisdombud.alumni.utils.Toolkit;

public class PojoMaker extends BaseMaker {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		path += "/src/main/resources/sql-csv/生产";
		List<String> filePathList = Toolkit.findAllCsv(path);

		PojoMaker pojoMaker = new PojoMaker();
		for (String filePath : filePathList) {
			if (filePath.contains("BASE_KEYBOARD_FUNCTION_TEST")) {
				pojoMaker.makeSingle(filePath);
			}

		}

	}

	private List<PojoValueObject> genSinglePoValue(String filePath) {
		List<PojoValueObject> voList = new ArrayList<PojoValueObject>();
		boolean isStart = false;
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			String tempString = null;

			while ((tempString = reader.readLine()) != null) {
				if (tempString.startsWith("DROP TABLE IF EXISTS")) {
					isStart = true;
				}
				if (tempString.contains("CREATE_TIME") || tempString.contains("LAST_UPDATE")) {
					continue;
				}
				if (isStart) {
					tempString = tempString.toUpperCase();
					if (tempString.toLowerCase().contains("engine=innodb")) {
						isStart = false;
						// this.addReserveCode(filePath, voList);

					}
					String[] array = tempString.split(",");
					if (this.isContinue(array)) {
						continue;
					}
					String entityName = "";
					String dbName = array[1];
					String getSetEntityName = "";
					String[] tempEntityName = array[1].split("_");
					for (int i = 0; i < tempEntityName.length; i++) {
						tempEntityName[i] = tempEntityName[i].toLowerCase();
						if (i != 0) {
							tempEntityName[i] = Toolkit.toUpperCaseFirstOne(tempEntityName[i]);
						}
						getSetEntityName += Toolkit.toUpperCaseFirstOne(tempEntityName[i]);
						entityName += tempEntityName[i];
					}
					String type = array[2];
					String comment = "";
					if (array.length >= 8) {
						for (int i = 0; i < array.length; i++) {
							if (array[i].toLowerCase().contains("comment")) {
								comment = array[i + 1];
								break;
							}
						}

					}
					if (type != null) {
						PojoValueObject vo = new PojoValueObject(dbName, entityName, getSetEntityName, comment, type,
								null);
						if (vo.getType() != null) {
							voList.add(vo);
						}
					}
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
		if (filePath.endsWith("CONF.csv")) {
			this.handleConfString(voList);
		}
		return voList;
	}

	private boolean isContinue(String[] array) {
		return array.length == 0 || array[1].equals("ID") || array[1].equals("") || array[2].equals(";")
				|| array[2].equals(",") || array[2].equals("");
	}

	/**
	 * 功能: 添加预留的代码.<br/>
	 * date: 2017年3月6日 下午6:08:20 <br/>
	 *
	 * @author chzhao
	 * @param filePath
	 * @param voList
	 */
	private void addReserveCode(String filePath, List<PojoValueObject> voList) {
		if (filePath.toLowerCase().contains("_conf")) {
			handleConf(voList);
		} else {
			handlePo(voList);
		}
	}

	/**
	 * 功能: TODO.<br/>
	 * date: 2017年3月6日 下午4:30:21 <br/>
	 *
	 * @author chzhao
	 * @param voList
	 */
	private void handlePo(List<PojoValueObject> voList) {
		String getSetEntityName;
		String comment;
		String type;
		String columnName;
		String fieldName;

		for (int i = 0; i < CommonValues.RESERVE_STRING_NUM; i++) {
			getSetEntityName = "ReVarchar" + i;
			comment = "RE_VARCHAR_" + i;
			type = "VARCHAR(255)";
			fieldName = "reVarchar" + i;
			columnName = comment;
			PojoValueObject vo = new PojoValueObject(columnName, fieldName, getSetEntityName, comment, type, null);
			voList.add(vo);
		}
		for (int i = 0; i < CommonValues.RESERVE_OTHER_NUM; i++) {
			for (int j = 0; j < CommonValues.exceptVarCharShuZu.length; j++) {
				getSetEntityName = CommonValues.exceptVarCharUpperShuZu[j] + i;
				comment = CommonValues.exceptVarCharShuZu[j] + i;
				type = CommonValues.shuXing[j];
				fieldName = CommonValues.exceptVarChar2LowerShuZu[j] + i;
				columnName = CommonValues.exceptVarCharShuZu[j] + i;
				PojoValueObject vo = new PojoValueObject(columnName, fieldName, getSetEntityName, comment, type, null);
				voList.add(vo);
			}
		}
	}

	/**
	 * 功能: 没有看清楚逻辑，不得已把所有属性都设置为String<br/>
	 * date: 2017年3月6日 下午4:32:17 <br/>
	 *
	 * @author chzhao
	 * @param voList
	 */
	private void handleConfString(List<PojoValueObject> voList) {
		for (PojoValueObject inst : voList) {
			inst.setType("String");
		}
	}

	/**
	 * 功能: TODO.<br/>
	 * date: 2017年3月6日 下午4:30:07 <br/>
	 *
	 * @author chzhao
	 * @param voList
	 */
	private void handleConf(List<PojoValueObject> voList) {
		String getSetEntityName;
		String comment;
		String type;
		String columnName;
		String fieldName;

		for (int i = 0; i < CommonValues.RESERVE_STRING_NUM; i++) {
			getSetEntityName = "ReVarchar" + i;
			comment = "RE_VARCHAR_" + i;
			type = "varchar";
			fieldName = "reVarchar" + i;
			columnName = "RE_VARCHAR_" + i;
			PojoValueObject vo = new PojoValueObject(columnName, fieldName, getSetEntityName, comment, type, null);
			voList.add(vo);
		}
		for (int i = 0; i < CommonValues.RESERVE_OTHER_NUM; i++) {
			for (int j = 0; j < CommonValues.exceptVarCharShuZu.length; j++) {
				getSetEntityName = CommonValues.exceptVarCharUpperShuZu[j] + i;
				comment = CommonValues.exceptVarCharShuZu[j] + i;
				type = "varchar";
				fieldName = CommonValues.exceptVarChar2LowerShuZu[j] + i;
				columnName = comment;
				PojoValueObject vo = new PojoValueObject(columnName, fieldName, getSetEntityName, comment, type, null);
				voList.add(vo);
			}
		}
	}

	@Override
	protected void setRealTemplate(String abc) throws IOException {
		if (abc.toLowerCase().contains("conf")) {
			super.template = super.cfg.getTemplate("PojoConf.ftl");
		} else {
			super.template = super.cfg.getTemplate("Pojo.ftl");
		}

	}

	@Override
	protected String fillRoot() throws IOException {
		return new File("").getCanonicalPath() + "\\target\\output\\erp\\pojo\\";
	}

	@Override
	protected String fillSuffix() throws IOException {
		return "";
	}

	@Override
	protected void fillInput() {
		List<PojoValueObject> pojoValueObjects = this.genSinglePoValue(super.filePath);
		super.input.put("ValueObject", new PojoValueObject(dbName, entityName, null, null, null, null));

		super.input.put("systems", pojoValueObjects);
	}

}
