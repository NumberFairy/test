package com.wisdombud.alumni.vo;

import java.util.Date;

/**
 * @DES 办工桌提醒事件
 * @author xiefei
 */
public class RemindVo {

	public static final Integer ALUMNI_BIRTH = 0;
	public static final Integer ALUMNI_ACTIVE = 1;

	private String id;
	private Date time; // 时间
	private String title; // 标题
	private Integer type; // 类型

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
