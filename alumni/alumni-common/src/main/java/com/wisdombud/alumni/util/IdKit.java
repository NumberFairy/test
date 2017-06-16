package com.wisdombud.alumni.util;

import java.util.UUID;

public class IdKit {

	/**
	 * 
	 * 功能: 获得uuid(字符串长度32).<br/>
	 * date: 2016年9月30日 下午2:34:35 <br/>
	 *
	 * @author zlliu
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
}
