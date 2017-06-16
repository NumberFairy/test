/**
 * Copyright (c) 2015, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能: Id转换类.<br/>
 * date: 2015年12月17日 下午2:00:05 <br/>
 *
 * @author Even.
 * @version
 * @since JDK 1.7
 */
public class NumberUtils {
    /**
     * 功能: 转换为整型List.<br/>
     * date: 2015年7月15日 上午10:36:55 <br/>
     *
     * @author Even.
     * @param str
     * @return
     */
    public static List<Integer> integerConvertList(String str) {
        String[] statusStr = str.split(",");
        List<Integer> ids = new ArrayList<>();
        for (String id : statusStr) {
            Integer num = Integer.parseInt(id);
            ids.add(num);
        }
        return ids;
    }

    public static List<String> stringConvertList(String str) {
        String[] statusStr = str.split(",");
        List<String> ids = new ArrayList<>();
        for (String id : statusStr) {
            ids.add(id);
        }
        return ids;
    }

    public static StringBuilder stringTrim(String str) {
        String[] statusStr = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < statusStr.length; i++) {
            if (i + 1 == statusStr.length) {
                sb.append(statusStr[i].trim());
            } else {
                sb.append(statusStr[i].trim() + ",");
            }
        }
        return sb;
    }

    /**
     * 功能: 计算百分比.<br/>
     * date: 2015年12月25日 下午12:00:31 <br/>
     *
     * @author Even.
     * @param divisor
     * @param dividend
     * @param scale
     * @return
     */
    public static String calcPercent(int divisor, int dividend, int scale) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(scale);
        String result = numberFormat.format((float) divisor / dividend * 100);
        return result;
    }
}
