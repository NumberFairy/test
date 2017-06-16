package com.wisdombud.alumni.enums;

/**
 * 通知模版定义的标签
 * 
 * @author xiefei
 */
public enum TplTagEnum {
	NAME("{[姓名]}","name"),
	TIME_DEFAULT("{[时间]}","yyyy-MM-dd"),
	TIME_DATE("{[时间 yyyy-MM-dd]}","yyyy-MM-dd"),
	TIME_DATE_TIME("{[时间 yyyy-MM-dd HH:mm:ss]}","yyyy-MM-dd HH:mm:ss"),
	TIME_YEAR("{[时间 yyyy]}","yyyy"),
	AUTOR("{[发送者]}","adminName"),
	BIRTHDAY("{[生日]}","birthDate");
	
	private String tag;
	private String fild;
	private TplTagEnum(String tag,String fild) {
		this.tag=tag;
		this.fild=fild;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getFild() {
		return fild;
	}
	public void setFild(String fild) {
		this.fild = fild;
	}

	
}
