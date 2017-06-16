package com.wisdombud.alumni.sqlgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.wisdombud.alumni.base.CommonValues;
import com.wisdombud.alumni.utils.Toolkit;

import common.toolkit.java.util.StringUtil;

public class GenSqlTool {

	public static void main(String[] args) {

		String path = System.getProperty("user.dir");
		path += "/src/main/resources/sql-csv";
		List<String> filePathList = Toolkit.findAllCsv(path);

		GenSqlTool genSqlTool = new GenSqlTool();
		path = System.getProperty("user.dir");
		path += "/target/output/erp/";

		for (String filePath : filePathList) {
			if (filePath.endsWith("BASE_INVENTORY.csv") || filePath.endsWith("BASE_INVENTORY_CONF.csv")) {

				genSqlTool.writeSingleSql(filePath, genSqlTool.genSqlPath(filePath, path));
			}
		}
	}

	private String genSqlPath(String csvPath, String sqlFolder) {
		File file = new File(csvPath);
		String parent = file.getParent();
		String str = csvPath.replace(parent + "\\", "").replace("csv", "sql");
		return sqlFolder + str;
	}

	private final String startStr = "DROP TABLE IF EXISTS";

	public void write2Sql(List<String> filePathList, String sqlFilePath, String csvName) {
		File file = new File(sqlFilePath);
		if (!file.exists()) {
			File file2 = new File(file.getParent());
			file2.mkdirs();
		}

		String sqlContent = " ";
		for (String filePath : filePathList) {
			if (filePath.toLowerCase().contains(csvName.toLowerCase())) {
				String genOneSql = null;
				if (filePath.toLowerCase().contains("_conf")) {
					genOneSql = genSingleSql(filePath, true);
					System.out.println(genOneSql);
					String genOneInsertSql = genSingleInsertSql(filePath);
					sqlContent += genOneSql + "\r\n\r\n";
					sqlContent += genOneInsertSql + "\r\n\r\n";
				} else {
					genOneSql = genSingleSql(filePath, false);
					sqlContent += genOneSql + "\r\n\r\n";
				}

				System.out.println(sqlContent);
			}
		}
		writeFile(sqlFilePath, sqlContent);
	}

	public void writeSingleSql(String filePath, String sqlFilePath) {
		File file = new File(sqlFilePath);
		if (!file.exists()) {
			File file2 = new File(file.getParent());
			file2.mkdirs();
		}

		String sqlContent = " ";

		String genOneSql = null;
		if (filePath.toLowerCase().contains("_conf")) {
			genOneSql = genSingleSql(filePath, true);
			System.out.println(genOneSql);
			String genOneInsertSql = genSingleInsertSql(filePath);
			sqlContent += genOneSql + "\r\n\r\n";
			sqlContent += genOneInsertSql + "\r\n\r\n";
		} else {
			genOneSql = genSingleSql(filePath, false);
			sqlContent += genOneSql + "\r\n\r\n";
		}

		writeFile(sqlFilePath, sqlContent);
	}

	/**
	 * 功能: 读csvFilepath 里的sql 写入到sqlFilePath<br/>
	 * date: 2017年2月9日 上午11:54:07 <br/>
	 *
	 * @author pfhu
	 * @param csvFilepath
	 *            .scv文件夹路径
	 * @param sqlFilePath
	 *            sql路径
	 * 
	 */

	public void write2Sql(List<String> filePathList, String sqlFilePath) {
		File file = new File(sqlFilePath);
		if (!file.exists()) {
			File file2 = new File(file.getParent());
			file2.mkdirs();
		}

		String sqlContent = " ";
		for (String filePath : filePathList) {
			if (filePath.contains("BASE_USE_APPLY_CONF.csv")) {
				// continue;
			}
			String genOneSql = null;
			if (filePath.toLowerCase().contains("_conf")) {
				genOneSql = genSingleSql(filePath, true);
				System.out.println(genOneSql);
				String genOneInsertSql = genSingleInsertSql(filePath);
				sqlContent += genOneSql + "\r\n\r\n";
				sqlContent += genOneInsertSql + "\r\n\r\n";
			} else {
				genOneSql = genSingleSql(filePath, false);
				sqlContent += genOneSql + "\r\n\r\n";
			}
		}
		writeFile(sqlFilePath, sqlContent);
	}

	/**
	 * 功能: 把content 写入到sqlFilePath文件中<br/>
	 * date: 2017年2月9日 上午11:54:07 <br/>
	 *
	 * @author pfhu
	 * @param sqlFilePath
	 *            sql路径
	 * @param content
	 *            写入的内容
	 * 
	 */
	private void writeFile(String sqlFilePath, String content) {
		try {
			File file = new File(sqlFilePath);
			FileOutputStream out = new FileOutputStream(file);
			byte[] bt = new byte[content.length() * 2];
			bt = content.getBytes();
			out.write(bt);
			out.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	private String genSingleSql(String csvFilepath, boolean isConf) {
		StringBuilder sb = new StringBuilder();

		boolean isStart = false;
		boolean isDic = false;
		File file = new File(csvFilepath);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.startsWith(startStr)) {
					isStart = true;
				}
				if (tempString.toLowerCase().contains("dic_")) {
					isDic = true;
				}
				if (isStart) {
					if (!tempString.toLowerCase().contains("engine=innodb")) {
						sb.append("\r\n");
					}

					if (tempString.toLowerCase().contains("insert")) {
						String[] tempList = tempString.split("\"");
						sb.append(tempList[1]);
						sb.append(" \r\n");
					} else {

						tempString = tempString.toUpperCase();
						String[] array = tempString.split(",");
						if (array.length >= 9) {
							if (!StringUtil.isBlank(array[8])) {
								String zhongWenStr = array[8].replace("'", "");
								array[8] = "'" + zhongWenStr + "'";
							}
						}
						int count = 0;
						int index = 0;
						boolean isTableName = false;
						for (String s : array) {
							if (s.equals("\"")) {
								s = ",";
								count++;
								if (count > 1) {
									continue;
								}
							}
							if (s.toLowerCase().contains("double(")) {
								s = s.substring(1, s.length()) + ",";
							}
							if (index != 0 && array[index - 1].toLowerCase().contains("double") && s.contains(")")) {
								s = s.substring(0, s.length() - 1);
							}
							if (isTableName) {
								String tableNameStr = s.replace("'", "");
								s = "'" + tableNameStr + "'";
								isTableName = false;
							}
							if (s.toLowerCase().contains("engine=innodb")) {
								this.addReserve(sb, isDic, s, isConf);
								isTableName = true;
							}
							sb.append(s);
							sb.append(" ");
							index++;
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
		if (isConf) {
			return convertConfSql(sb.toString());
		}
		return convertChinese2English(sb.toString());
	}

	private String convertChinese2English(String str) {
		return str.replace("（", "(").replace("） ", ")");
	}

	private String convertConfSql(String str) {
		String varchar = " VARCHAR(64) ";
		str = convertChinese2English(str);
		return str.replace(" int(1) ", varchar).replace(" int(11) ", varchar).replace(" DOUBLE ", varchar)
				.replace(" datetime ", varchar);
	}

	/**
	 * 功能: 添加冗余.<br/>
	 * date: 2017年2月16日 上午11:08:17 <br/>
	 *
	 * @author pfhu
	 * @param sb
	 * @param isDic
	 * @param s
	 */
	private void addReserve(StringBuilder sb, boolean isDic, String s, boolean isConf) {

		if (!isDic) {
			sb.append(" \r\n " + "CREATE_TIME  DATETIME COMMENT '创建时间',");
			sb.append(" \r\n " + "LAST_UPDATE  DATETIME COMMENT '更新时间',");
			for (int i = 0; i < CommonValues.RESERVE_STRING_NUM; i++) {
				sb.append(" \r\n " + "RE_VARCHAR_" + i + "  VARCHAR(255) COMMENT '" + "RE_VARCHAR_" + i + "',");
			}
			for (int i = 0; i < CommonValues.RESERVE_OTHER_NUM; i++) {
				for (int j = 0; j < CommonValues.exceptVarCharShuZu.length; j++) {
					// String tmp = isConf ? " VARCHAR(255) " :
					// CommonValues.shuXing[j];
					sb.append("\r\n " + CommonValues.exceptVarCharShuZu[j] + i + "    VARCHAR(255)  COMMENT '"
							+ CommonValues.exceptVarCharShuZu[j] + i + "', ");
				}
			}
		}
		sb.deleteCharAt(sb.length() - 2);
		sb.append("\r\n");
	}

	/**
	 * 
	 * 功能: return insert into abc(zidu) vlues('字段'); <br/>
	 * date: 2017年2月10日 下午2:41:35 <br/>
	 *
	 * @author pfhu
	 * @param csvFilepath
	 * @return sqlStr
	 */
	private String genSingleInsertSql(String csvFilepath) {
		List<String> yingWenList = new ArrayList<String>();
		List<String> zhongWenList = new ArrayList<String>();
		StringBuilder yingWenStr = new StringBuilder();
		StringBuilder zhongWenStr = new StringBuilder();

		yingWenStr.append("INSERT INTO");
		yingWenStr.append(" \r\n");
		zhongWenStr.append("VALUES \r\n(");
		zhongWenStr.append(" ");
		boolean isStart = false;
		String sqlStr = null;
		File file = new File(csvFilepath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.startsWith(startStr)) {
					isStart = true;
				}
				if (isStart) {
					String[] array = tempString.split(",");
					int count = 0;
					int index = 0;
					for (String s : array) {
						if (s.equals("\"")) {
							s = ",";
							count++;
							if (count > 1) {
								continue;
							}
						}
						if (index == 0 && tempString.toLowerCase().contains("default")
								&& !tempString.toLowerCase().contains("engine=innodb")) {
							yingWenList.add("'" + array[1] + "'");
							zhongWenList.add(array[6]);
						}
						if (array[index].toLowerCase().contains("create table")) {
							yingWenStr.append(array[index + 1] + " (\r\n");
							yingWenStr.append(" ");
						}
						index++;
					}
				}
			}
			sqlStr = pinXieInsertSQL(yingWenList, zhongWenList, yingWenStr, zhongWenStr);
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
		if (yingWenList.size() == 0) {
			return "";
		}
		return sqlStr.toString();
	}

	/**
	 * 功能: 返回sql 插入语句 return yingWenStr = yingWenStr(yingWenList) zhongWenStr
	 * zhongWenList) ; <br/>
	 * date: 2017年2月9日 上午11:54:07 <br/>
	 *
	 * @author pfhu
	 * @param yingWenList
	 *            英文字段
	 * @param zhongWenList
	 *            中文名
	 * @param yingWenSb
	 * @param zhongWenStr
	 */
	private String pinXieInsertSQL(List<String> yingWenList, List<String> zhongWenList, StringBuilder yingWenSb,
			StringBuilder zhongWenStr) {
		int secondIndex = 0;
		for (String str : yingWenList) {

			str = str.replace("'", " ");
			yingWenSb.append(str);
			yingWenSb.append(",\r\n");
		}
		yingWenSb = yingWenSb.delete(yingWenSb.length() - 3, yingWenSb.length() - 1);
		for (int i = 0; i < CommonValues.RESERVE_STRING_NUM; i++) {
			yingWenSb.append(", \r\n " + "RE_VARCHAR_" + i + " ");
		}
		for (int i = 0; i < CommonValues.RESERVE_OTHER_NUM; i++) {
			for (int j = 0; j < CommonValues.exceptVarCharShuZu.length; j++) {
				yingWenSb.append(", \r\n " + CommonValues.exceptVarCharShuZu[j] + i + " ");
			}
		}
		yingWenSb.append(" \r\n) ");

		// yingWenSb = new
		// StringBuilder(StringUtils.trim(yingWenSb.toString()));

		for (String str : zhongWenList) {
			if (secondIndex == zhongWenList.size() - 1) {
				zhongWenStr.append("\r\n" + str);

				for (int i = 0; i < CommonValues.RESERVE_STRING_NUM; i++) {
					zhongWenStr.append(", \r\n '' ");
				}
				for (int i = 0; i < CommonValues.RESERVE_OTHER_NUM; i++) {
					for (int j = 0; j < CommonValues.exceptVarCharShuZu.length; j++) {

						zhongWenStr.append(", \r\n'' ");
					}
				}
				zhongWenStr.append("\r\n); ");
			} else {
				if (secondIndex == 0) {
					zhongWenStr.append("\r\n'1', ");
				} else {
					zhongWenStr.append("\r\n" + str + ", ");
				}
			}
			secondIndex++;
		}
		yingWenSb.append(" " + zhongWenStr);
		return yingWenSb.toString();
	}

}
