package com.wisdombud.alumni.pojo.manage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_ALUMNI_BRANCH_APPLY")
public class BaseAlumniBranchApply extends UUIDReservePo {
	private static final long serialVersionUID = 1L;

	@Column(name = "BRANCH_ID")
	private String 	branchId;

	@Column(name = "ALUMNI_ID")
	private String alumniId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;

	@Column(name = "COLLEGE")
	private Integer college;

	@Column(name = "MAGOR")
	private Integer magor;

	@Column(name = "ENROLL_YEAR")
	private Integer enrollYear;

	@Column(name = "STATUS")
	private Integer status;

	@Transient
	private String genderStr;

	@Transient
	private String branchName;

	@Transient
	private String collegeStr;

	@Transient
	private String magorStr;

	@Transient
	private String company;

	@Transient
	private String post;

	@Transient
	private String auditStatus;

	@Column(name = "AUDITIOR")
	private String auditior;

	@Column(name = "AUDIT_TIME")
	private Date auditTime;

	@Column(name = "AUDIT_OPITION")
	private String auditOpition;

	/**
	 * 功能:get 校友会ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getBranchId() {
		return branchId;
	}

	/**
	 * 功能:set 校友会ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * 功能:get 校友ID<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getAlumniId() {
		return alumniId;
	}

	/**
	 * 功能:set 校友ID<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAlumniId(String alumniId) {
		this.alumniId = alumniId;
	}

	/**
	 * 功能:get '校友名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getName() {
		return name;
	}

	/**
	 * 功能:set '校友名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 功能:get '学号/职工号'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getCode() {
		return code;
	}

	/**
	 * 功能:set '学号/职工号'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 功能:get '学院'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getCollege() {
		return college;
	}

	/**
	 * 功能:set '学院'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCollege(Integer college) {
		this.college = college;
	}

	/**
	 * 功能:get '专业'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getMagor() {
		return magor;
	}

	/**
	 * 功能:set '专业'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setMagor(Integer magor) {
		this.magor = magor;
	}

	/**
	 * 功能:get '入学年份'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getEnrollYear() {
		return enrollYear;
	}

	/**
	 * 功能:set '入学年份'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEnrollYear(Integer enrollYear) {
		this.enrollYear = enrollYear;
	}

	/**
	 * 功能:get '状态'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getStatus() {
		return status;
	}

	/**
	 * 功能:set '状态'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 功能:get '审核人'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getAuditior() {
		return auditior;
	}

	/**
	 * 功能:set '审核人'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAuditior(String auditior) {
		this.auditior = auditior;
	}

	/**
	 * 功能:get '审核时间'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * 功能:set '审核时间'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * 功能:get '审核意见''<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getAuditOpition() {
		return auditOpition;
	}

	/**
	 * 功能:set '审核意见''<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAuditOpition(String auditOpition) {
		this.auditOpition = auditOpition;
	}

	public String getGenderStr() {
		return genderStr;
	}

	public void setGenderStr(String genderStr) {
		this.genderStr = genderStr;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCollegeStr() {
		return collegeStr;
	}

	public void setCollegeStr(String collegeStr) {
		this.collegeStr = collegeStr;
	}

	public String getMagorStr() {
		return magorStr;
	}

	public void setMagorStr(String magorStr) {
		this.magorStr = magorStr;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

}