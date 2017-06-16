package com.wisdombud.alumni.util;

import java.util.HashMap;
import java.util.Map;

public class TimeScope {
	private static final TimeScope MORNING = new TimeScope("1");
	private static final TimeScope AFTERNOON = new TimeScope("2");
	private static final TimeScope NIGTH = new TimeScope("3");
	
	public static final Map<String, TimeScope> TIME_SCOPE_MAP = new HashMap<String, TimeScope>();
	
	static {
		TIME_SCOPE_MAP.put("1", MORNING);
		TIME_SCOPE_MAP.put("2", AFTERNOON);
		TIME_SCOPE_MAP.put("3", NIGTH);
	}
	
	private String value;
	
	private TimeScope(String scopeValue) {
		this.value = scopeValue;
	}
	
	public int getStartHour() {
		int startHour = 8;
		switch (this.value) {
		case "1":
			startHour = 8; 
			break;
		case "2":
			startHour = 14; 
			break;
		case "3":
			startHour = 19; 
			break;
		}
		return startHour;
	}
	
	public int getEndHour() {
		int endHour = 21;
		switch (this.value) {
		case "1":
			endHour = 12; 
			break;
		case "2":
			endHour = 17; 
			break;
		case "3":
			endHour = 21; 
			break;
		}
		return endHour;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
