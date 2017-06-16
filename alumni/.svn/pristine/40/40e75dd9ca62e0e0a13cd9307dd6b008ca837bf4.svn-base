package com.wisdombud.alumni.enums;

public enum FlowAuditEnum {
	NOTACCEPT(2,"不通过"),ACCEPT(1, "通过"), NOTAUDIT(0, "未审核");
	int value;
	String name;

	private FlowAuditEnum(int value, String name) {
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

	public static FlowAuditEnum valueByIndex(int index) {
		for (FlowAuditEnum reportType : FlowAuditEnum.values()) {
			if (reportType.getValue() == index) {
				return reportType;
			}
		}
		return null;
	}

	public static FlowAuditEnum valueByName(String name) {
		for (FlowAuditEnum reportType : FlowAuditEnum.values()) {
			if (reportType.getName().equals(name)) {
				return reportType;
			}
		}
		return null;
	}
}
