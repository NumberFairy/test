package com.wisdombud.alumni.enums;

public enum PoliticalStatusEnum {
	COMMUNIST(1, "共产党员"),
	PROBATIONARY_PARTY_MEMBER(2, "预备党员"),
    LEAGUE_MEMBER(3, "共青团员"),
	CROWD(4, "群众");

    int    value;
    String name;

    private PoliticalStatusEnum(int value, String name) {
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
    public static PoliticalStatusEnum valueByIndex(int index) {
        for (PoliticalStatusEnum reportType : PoliticalStatusEnum.values()) {
            if (reportType.getValue() == index) {
                return reportType;
            }
        }
        return null;
    }

    // 根据name获取enum对象
    public static PoliticalStatusEnum valueByName(String name) {
        for (PoliticalStatusEnum reportType : PoliticalStatusEnum.values()) {
            if (reportType.getName().equals(name)) {
                return reportType;
            }
        }
        return null;
    }
}

