package com.wisdombud.alumni.enums;

public enum IdentityEnum {
    STUDENT(0, "在校生"),
    ALUMNI(1, "校友"),
    STAFF(2, "教职工");

    int    value;
    String name;

    private IdentityEnum(int value, String name) {
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
    public static IdentityEnum valueByIndex(int index) {
        for (IdentityEnum reportType : IdentityEnum.values()) {
            if (reportType.getValue() == index) {
                return reportType;
            }
        }
        return null;
    }

    // 根据name获取enum对象
    public static IdentityEnum valueByName(String name) {
        for (IdentityEnum reportType : IdentityEnum.values()) {
            if (reportType.getName().equals(name)) {
                return reportType;
            }
        }
        return null;
    }
}

