package com.wisdombud.alumni.enums;

public enum YesOrNoEnum {
    NO(0, "否"),
    YES(1, "是");

    int    value;
    String name;

    private YesOrNoEnum(int value, String name) {
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
    public static YesOrNoEnum valueByIndex(int index) {
        for (YesOrNoEnum reportType : YesOrNoEnum.values()) {
            if (reportType.getValue() == index) {
                return reportType;
            }
        }
        return null;
    }

    // 根据name获取enum对象
    public static YesOrNoEnum valueByName(String name) {
        for (YesOrNoEnum reportType : YesOrNoEnum.values()) {
            if (reportType.getName().equals(name)) {
                return reportType;
            }
        }
        return null;
    }
}

