package com.wisdombud.alumni.enums;

public enum AlumniBranchIdentityEnum {
    HUIZHANG(1, "会长"),
    CHANGWU_FUHUIZHANG(2, "常务副会长"),
	FUHUIZHANG(3, "副会长"),
    MISHUZHANG(4, "秘书长"),
    CHAGNWU_FUMISHUZHANG(5, "常务副秘书长"),
	FUMISHUZHANG(6, "副秘书长"),
    CHANGWU_LISHI(7, "常务理事"),
    LISHI(8, "理事");

    int    value;
    String name;

    private AlumniBranchIdentityEnum(int value, String name) {
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
    public static AlumniBranchIdentityEnum valueByIndex(int index) {
        for (AlumniBranchIdentityEnum reportType : AlumniBranchIdentityEnum.values()) {
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
