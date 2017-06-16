package com.wisdombud.alumni.enums;

public enum GenderEnum {
	MAN(0,"男"),
	WOMEN(1,"女");

    int    value;
    String name;

    private GenderEnum(int value, String name) {
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
    public static GenderEnum valueByIndex(int index) {
        for (GenderEnum reportType : GenderEnum.values()) {
            if (reportType.getValue() == index) {
                return reportType;
            }
        }
        return null;
    }

    // 根据name获取enum对象
    public static GenderEnum valueByName(String name) {
        for (GenderEnum reportType : GenderEnum.values()) {
            if (reportType.getName().equals(name)) {
                return reportType;
            }
        }
        return null;
    }
}

