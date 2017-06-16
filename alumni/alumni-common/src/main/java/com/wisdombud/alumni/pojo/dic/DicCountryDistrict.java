package com.wisdombud.alumni.pojo.dic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * ClassName: DicCountryDistrict. <br/>
 * date: 2016年10月8日 下午5:10:56 <br/>
 *
 * @author zlliu
 * @version
 * @since JDK 1.7
 */
@Entity
@Table(name = "DIC_COUNTRY_DISTRICT")
@NamedQueries({
		@NamedQuery(name = "DicCountryDistrict.findAll", query = "SELECT d FROM DicCountryDistrict d order by id asc"),
		@NamedQuery(name = "DicCountryDistrict.findAllCN", query = "SELECT d FROM DicCountryDistrict d where pcode !='0' order by id asc") })

public class DicCountryDistrict implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "P_CODE")
	private String pcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
}