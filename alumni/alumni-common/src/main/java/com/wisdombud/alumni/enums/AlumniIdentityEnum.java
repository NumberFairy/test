package com.wisdombud.alumni.enums;

public enum AlumniIdentityEnum {
    ORDINARY_ALUMNI(1, "普通校友"),
    COLLEGE_KEY_ALUMNI(2, "学院重点校友"),
	SCHOOL_KEY_ALUMNI(3, "学校重点校友"),
    ALUMNI_LIAISON(4, "校友联络员");

    int    value;
    String name;

    private AlumniIdentityEnum(int value, String name) {
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
    public static AlumniIdentityEnum valueByIndex(int index) {
        for (AlumniIdentityEnum reportType : AlumniIdentityEnum.values()) {
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
