/**
 * Copyright (c) 2017, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.base;

/**
 * 功能: TODO.<br/>
 * date: 2017年2月16日 上午11:04:40 <br/>
 *
 * @author pfhu
 * @version
 * @since JDK 1.7
 */
public class CommonValues {
	public static final int RESERVE_STRING_NUM = 20;
	public static final int RESERVE_OTHER_NUM = 5;

	public static final String[] exceptVarCharShuZu = { "RE_INT_", "RE_DOUBLE_", "RE_DATE_", "RE_DATETIME_",
			"RE_LONGTEXT_" };
	public static final String[] exceptVarChar2LowerShuZu = { "reInt", "reDouble", "reDate", "reDateTime",
			"reLongText" };

	public static final String[] exceptVarCharUpperShuZu = { "ReInt", "ReDouble", "ReDate", "ReDateTime",
			"ReLongText" };

	public static final String[] shuXing = { "INT", "DOUBLE(8,2)", "DATE", "DATETIME", "LONGTEXT" };

}
