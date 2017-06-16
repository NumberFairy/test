package com.wisdombud.alumni.codegen;

public class PojoValueObject {
	private String dbName;
	private String entityName;
	private String getSetEntityName;
	private String comment;
	private String type;
	private String lowerEntityName;

	public PojoValueObject(String dbName, String entityName, String getSetEntityName, String comment, String type,
			String lowerEntityName) {
		this.dbName = dbName;
		this.entityName = entityName;
		this.getSetEntityName = getSetEntityName;
		this.comment = comment;
		this.lowerEntityName = lowerEntityName;

		if (type != null) {
			if (type.toLowerCase().contains("varchar")) {
				this.type = "String";
			} else if (type.toLowerCase().contains("date")) {
				this.type = "Date";
			}
			if (type.toLowerCase().contains("double")) {
				this.type = "Double";
			}
			if (type.toLowerCase().contains("int")) {
				this.type = "Integer";
			}
			if (type.toLowerCase().contains("datetime")) {
				this.type = "Date";
			}
			if (type.toLowerCase().contains("longtext")) {
				this.type = "String";
			}
		}
	}

	public String getGetSetEntityName() {
		return getSetEntityName;
	}

	public String getdbName() {
		return dbName;
	}

	public String getEntityName() {
		return entityName;
	}

	public String getType() {
		return type;
	}

	public String getComment() {
		return comment;
	}

	public String getLowerEntityName() {
		return lowerEntityName;
	}

	public void setType(String type) {
		this.type = type;
	}
}
