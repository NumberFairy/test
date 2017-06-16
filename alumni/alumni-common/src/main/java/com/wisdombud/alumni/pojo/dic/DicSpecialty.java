package com.wisdombud.alumni.pojo.dic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 专业字典
 * 
 * @author xiefei
 */
@Entity
@Table(name = "DIC_SPECIALTY")
public class DicSpecialty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CN_NAME")
	private String cnName;

	@Column(name = "COLLEGE_ID")
	private Integer collegeId;

	@Column(name = "DEGREE_ID")
	private Integer degreeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public Integer getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public Integer getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(Integer degreeId) {
		this.degreeId = degreeId;
	}
}
