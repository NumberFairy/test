package com.wisdombud.alumni.enums;

public enum AlumniBranchTypeEnum {
    CHAPTER(1, "地方分会", "DicChapterBranch"),
    COLLEGE(2, "学院分会", "DicCollegeBranch"),
    OVERSEA(3, "海外分会", "DicOverseaBranch"),
    INDUSTRY(4, "行业分会", "DicIndustryBranch");

    int    key;
    String name;
    String table;

    private AlumniBranchTypeEnum(int key, String name, String table) {
        this.key = key;
        this.name = name;
        this.table = table;
    }

    public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	// 根据key获取enum对象
    public static AlumniBranchTypeEnum valueByKey(int key) {
        for (AlumniBranchTypeEnum branchType : AlumniBranchTypeEnum.values()) {
            if (branchType.getKey() == key) {
                return branchType;
            }
        }
        return null;
    }

}
