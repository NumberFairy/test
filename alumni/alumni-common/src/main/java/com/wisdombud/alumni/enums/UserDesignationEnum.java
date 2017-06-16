package com.wisdombud.alumni.enums;

public enum UserDesignationEnum {
    TEACHER(1, "teacher"),
    ALUMNI(2, "alumni");

    int    value;
    String name;

    private UserDesignationEnum(int value, String name) {
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
    public static UserDesignationEnum valueByIndex(int index) {
        for (UserDesignationEnum reportType : UserDesignationEnum.values()) {
            if (reportType.getValue() == index) {
                return reportType;
            }
        }
        return null;
    }

    // 根据name获取enum对象
    public static UserDesignationEnum valueByName(String name) {
        for (UserDesignationEnum reportType : UserDesignationEnum.values()) {
            if (reportType.getName().equals(name)) {
                return reportType;
            }
        }
        return null;
    }
}
