/**
 * Copyright (c) 2017, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.vo;

import java.io.Serializable;

/**
 * 功能: TODO.<br/>
 * date: 2017年2月24日 上午11:58:06 <br/>
 *
 * @author zlliu
 * @version
 * @since JDK 1.7
 */
public class Param implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * EQ	等于(=)
	 */
	public static final String EQ = "=";
	/**
	 * NEQ	不等于(!=)
	 */
	public static final String NEQ = "!=";
	/**
	 * GT	大于(>)
	 */
	public static final String GT = ">";
	/**
	 * EGT	大于等于(>=)
	 */
	public static final String EGT = ">=";
	/**
	 * LT	小于(<)
	 */
	public static final String LT = "<";
	/**
	 * ELT	小于等于(<=)
	 */
	public static final String ELT = "<=";
	/**
	 * LIKE	模糊查询(like)
	 */
	public static final String LIKE = "LIKE";
	/**
	 * IN	在(IN)
	 */
	public static final String IN = "IN";
	/**
	 * NIN	不在(NOT IN)
	 */
	public static final String NIN = "NOT IN";
	
	/**
	 * PERCENT 百分号(%)
	 */
	public static final String PCT = "%";

	private Object val;
	private String oper;
	
	protected Param() {
	}
	
	protected Param(String oper, Object val) {
		this.oper = oper;
		this.val = val;
	}
	
	/**
	 * 
	 * 功能: 等于条件查询.<br/>
	 * date: 2017年2月27日 下午5:42:42 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return
	 */
	public static Param eq(Object val){
		return new Param(EQ, val);
	}
	
	/**
	 * 
	 * 功能: 前后模糊条件查询.<br/>
	 * date: 2017年2月27日 下午5:42:36 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return 
	 */
	public static Param like(Object val){
		return new Param(LIKE, PCT + val + PCT);
	}
	
	/**
	 * 
	 * 功能: 前模糊条件查询.<br/>
	 * date: 2017年2月27日 下午5:45:34 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return
	 */
	public static Param likeFront(Object val){
		return new Param(LIKE, PCT + val);
	}
	
	/**
	 * 
	 * 功能: 后模糊条件查询.<br/>
	 * date: 2017年2月27日 下午5:45:47 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return
	 */
	public static Param likeBack(Object val){
		return new Param(LIKE, val + PCT);
	}
	
	/**
	 * 
	 * 功能: 按运算符条件查询.<br/>
	 * date: 2017年2月27日 下午5:46:02 <br/>
	 *
	 * @author zlliu
	 * @param oper
	 * @param val
	 * @return
	 */
	public static Param put(String oper, Object val){
		return new Param(oper, val);
	}
	
	/**
	 * 
	 * 功能: 字符串前后加百分号.<br/>
	 * date: 2017年2月27日 下午5:38:38 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return %val%
	 */
	public static String PCTAll(String val) {
		return PCT + val + PCT;
	}
	
	/**
	 * 
	 * 功能: 字符串前加百分号.<br/>
	 * date: 2017年2月27日 下午5:40:58 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return %val
	 */
	public static String PCTFront(String val) {
		return PCT + val;
	}
	
	/**
	 * 
	 * 功能: 字符串后加百分号.<br/>
	 * date: 2017年2月27日 下午5:41:31 <br/>
	 *
	 * @author zlliu
	 * @param val
	 * @return val%
	 */
	public static String PCTBack(String val) {
		return val + PCT;
	}

	/**
	 * 属性值.
	 * @return  the 属性值
	 * @since   JDK 1.7
	 */
	public Object getVal() {
		return val;
	}
	/**
	 * 属性值.
	 * @param   属性值    the 属性值 to set
	 * @since   JDK 1.7
	 */
	public void setVal(Object val) {
		this.val = val;
	}
	/**
	 * 运算符.
	 * @return  the 运算符
	 * @since   JDK 1.7
	 */
	public String getOper() {
		return oper;
	}
	/**
	 * 运算符.
	 * @param   运算符    the 运算符 to set
	 * @since   JDK 1.7
	 */
	public void setOper(String oper) {
		this.oper = oper;
	}
	
}
