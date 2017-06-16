package com.wisdombud.alumni.pojo.dic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 功能: 行业字典表.<br/>
 * date: 2017年4月5日 下午1:50:12 <br/>
 *
 * @author czjia
 * @version
 * @since JDK 1.8
 */
@Entity
@Table(name = "DIC_INDUSTRY")
public class DicIndustry implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "VALUE")
	private String value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}