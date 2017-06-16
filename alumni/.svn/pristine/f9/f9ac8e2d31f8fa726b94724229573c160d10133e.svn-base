package com.wisdombud.alumni.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {

	/**
	 * 计算星期的间隔时间
	 * 
	 * @param strdate
	 *            初始日期
	 * @param isAfter
	 *            是否是前一周
	 * @return
	 */
	public static Date getWeekDate(Date strdate, Boolean isAfter) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(strdate);
		if (isAfter) {
			calendar.add(Calendar.DATE, -7);
		} else {
			calendar.add(Calendar.DATE, 7);
		}
		return calendar.getTime();
	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println("现在时间是：" + new Date());
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK) - 1);
		System.out.println("现在时间是：" + year + "年" + month + "月" + day + "日，星期" + week);
		CalendarUtils.getWeekDate(new Date(), true);
	}
}
