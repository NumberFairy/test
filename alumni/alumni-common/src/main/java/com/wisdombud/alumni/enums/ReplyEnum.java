package com.wisdombud.alumni.enums;

public enum ReplyEnum {
	REPLY(1, "已回复"), NOTREPLY(0, "未回复");
	int value;
	String name;

	private ReplyEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 根据index获取enum对象
	public static ReplyEnum valueByIndex(int index) {
		for (ReplyEnum reportType : ReplyEnum.values()) {
			if (reportType.getValue() == index) {
				return reportType;
			}
		}
		return null;
	}

	// 根据name获取enum对象
	public static ReplyEnum valueByName(String name) {
		for (ReplyEnum reportType : ReplyEnum.values()) {
			if (reportType.getName().equals(name)) {
				return reportType;
			}
		}
		return null;
	}
}
