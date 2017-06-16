/**
 * Copyright (c) 2017, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.pojo.dic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 功能: <br/>
 * date: 2017年3月2日 上午11:03:16 <br/>
 *
 * @author chzhao
 * @version
 * @since JDK 1.8
 */
@MappedSuperclass
public abstract class DicBasePo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	@Column(name = "VALUE")
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 功能:get '类型名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getValue() {
		return value;
	}

	/**
	 * 功能:set '类型名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
