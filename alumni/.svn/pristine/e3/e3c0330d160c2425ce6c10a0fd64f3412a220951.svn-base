package com.wisdombud.alumni.enums;

public enum AuditEnum {
	NOTAUDIT(-1, "未审核"), ACCEPT(1, "通过"), NOTACCEPT(0, "不通过");
	int value;
	String name;

	private AuditEnum(int value, String name) {
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
	public static AuditEnum valueByIndex(int index) {
		for (AuditEnum reportType : AuditEnum.values()) {
			if (reportType.getValue() == index) {
				return reportType;
			}
		}
		return null;
	}

	// 根据name获取enum对象
	public static AuditEnum valueByName(String name) {
		for (AuditEnum reportType : AuditEnum.values()) {
			if (reportType.getName().equals(name)) {
				return reportType;
			}
		}
		return null;
	}
}
