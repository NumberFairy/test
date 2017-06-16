package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

/**
 * @author zch 这个类定义了导入和导出的对象
 */
@Entity
@Table(name = "BASE_ALUMNI_IMPORT")
public class BaseAlumniImport extends UUIDReservePo {
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME")
	private String name;

	@Column(name = "IDENTITY")
	private String identity;

	@Column(name = "CODE")
	private String code;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "BIRTH_DATE")
	private String birthDate;

	@Column(name = "NATIVES")
	private String natives;

	@Column(name = "NATIVE_STR")
	private String nativeStr;

	@Column(name = "LABEL")
	private String label;

	@Column(name = "POLITICAL_STATUS")
	private String politicalStatus;

	@Column(name = "WECHAT_ID")
	private String wechatId;

	@Column(name = "WECHAT_NAME")
	private String wechatName;

	@Column(name = "QQ")
	private String qq;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ENROLL_YEAR")
	private String enrollYear;

	@Column(name = "COLLEGE")
	private String college;

	@Column(name = "MAJOR")
	private String major;

	@Column(name = "CLASS_NAME")
	private String className;

	@Column(name = "HIGHEST_EDUCATION")
	private String highestEducation;

	@Column(name = "TEACHER")
	private String teacher;

	@Column(name = "INDUSTRY")
	private String industry;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "COMPANY_CITY")
	private String companyCity;

	@Column(name = "COMPANY_CITY_STR")
	private String companyCityStr;

	@Column(name = "COMPANY_ADDRESS")
	private String companyAddress;

	@Column(name = "OFFICE_PHONE")
	private String officePhone;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "POST")
	private String post;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "ALUMNI_CLUB_IDENTITY_NAME")
	private String alumniClubIdentityName;

	@Column(name = "BRANCH_CLUB_IDENTITY_NAME")
	private String branchClubIdentityName;

	@Column(name = "ALUMNI_IDENTITY_NAME")
	private String alumniIdentityName;

	@Column(name = "REMARK1")
	private String remark1;

	@Column(name = "REMARK2")
	private String remark2;

	@Column(name = "REMARK3")
	private String remark3;

	@Column(name = "REMARK4")
	private String remark4;

	@Column(name = "REMARK5")
	private String remark5;

	@Column(name = "REMARK6")
	private String remark6;

	@Column(name = "REMARK7")
	private String remark7;

	@Column(name = "REMARK8")
	private String remark8;

	@Column(name = "REMARK9")
	private String remark9;

	@Column(name = "REMARK10")
	private String remark10;

	/**
	 * 功能:get 姓名'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getName() {
		return name;
	}

	/**
	 * 功能:set 姓名'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 功能:get 身份'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getIdentity() {
		return identity;
	}

	/**
	 * 功能:set 身份'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * 功能:get 学号/职工号'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getCode() {
		return code;
	}

	/**
	 * 功能:set 学号/职工号'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 功能:get 性别'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getGender() {
		return gender;
	}

	/**
	 * 功能:set 性别'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 功能:get 出生年月'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * 功能:set 出生年月'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * 功能:get 籍贯'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getNatives() {
		return natives;
	}

	/**
	 * 功能:set 籍贯'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setNatives(String natives) {
		this.natives = natives;
	}

	/**
	 * 功能:get 标签'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getLabel() {
		return label;
	}

	/**
	 * 功能:set 标签'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 功能:get 政治面貌'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	/**
	 * 功能:set 政治面貌'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	/**
	 * 功能:get 微信'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getWechatId() {
		return wechatId;
	}

	/**
	 * 功能:set 微信'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	/**
	 * 功能:get 微信昵称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getWechatName() {
		return wechatName;
	}

	/**
	 * 功能:set 微信昵称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	/**
	 * 功能:get QQ'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getQq() {
		return qq;
	}

	/**
	 * 功能:set QQ'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * 功能:get 手机号'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getPhone() {
		return phone;
	}

	/**
	 * 功能:set 手机号'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 功能:get 永久通讯地址'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * 功能:set 永久通讯地址'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 功能:get 邮箱'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * 功能:set 邮箱'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 功能:get 入学年份'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getEnrollYear() {
		return enrollYear;
	}

	/**
	 * 功能:set 入学年份'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEnrollYear(String enrollYear) {
		this.enrollYear = enrollYear;
	}

	/**
	 * 功能:get 院系'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getCollege() {
		return college;
	}

	/**
	 * 功能:set 院系'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * 功能:get 班级名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getClassName() {
		return className;
	}

	/**
	 * 功能:set 班级名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * 功能:get 最高学历'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getHighestEducation() {
		return highestEducation;
	}

	/**
	 * 功能:set 最高学历'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	/**
	 * 功能:get 辅导员/导师'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getTeacher() {
		return teacher;
	}

	/**
	 * 功能:set 辅导员/导师'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * 功能:get 行业'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getIndustry() {
		return industry;
	}

	/**
	 * 功能:set 行业'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * 功能:get 所在单位'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getCompany() {
		return company;
	}

	/**
	 * 功能:set 所在单位'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 功能:get 单位所在省/市'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getCompanyCity() {
		return companyCity;
	}

	/**
	 * 功能:set 单位所在省/市'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	/**
	 * 功能:get 单位地址'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * 功能:set 单位地址'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 功能:get 办公电话'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * 功能:set 办公电话'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	/**
	 * 功能:get 部门'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getDepartment() {
		return department;
	}

	/**
	 * 功能:set 部门'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 功能:get 职务'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getPost() {
		return post;
	}

	/**
	 * 功能:set 职务'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * 功能:get 职称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * 功能:set 职称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getAlumniClubIdentityName() {
		return alumniClubIdentityName;
	}

	public void setAlumniClubIdentityName(String alumniClubIdentityName) {
		this.alumniClubIdentityName = alumniClubIdentityName;
	}

	public String getBranchClubIdentityName() {
		return branchClubIdentityName;
	}

	public void setBranchClubIdentityName(String branchClubIdentityName) {
		this.branchClubIdentityName = branchClubIdentityName;
	}

	public String getAlumniIdentityName() {
		return alumniIdentityName;
	}

	public void setAlumniIdentityName(String alumniIdentityName) {
		this.alumniIdentityName = alumniIdentityName;
	}

	/**
	 * 功能:get 备注1'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark1() {
		return remark1;
	}

	/**
	 * 功能:set 备注1'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	/**
	 * 功能:get 备注2'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark2() {
		return remark2;
	}

	/**
	 * 功能:set 备注2'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * 功能:get 备注3'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark3() {
		return remark3;
	}

	/**
	 * 功能:set 备注3'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * 功能:get 备注4'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark4() {
		return remark4;
	}

	/**
	 * 功能:set 备注4'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * 功能:get 备注5'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark5() {
		return remark5;
	}

	/**
	 * 功能:set 备注5'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	/**
	 * 功能:get 备注6'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark6() {
		return remark6;
	}

	/**
	 * 功能:set 备注6'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	/**
	 * 功能:get 备注7'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark7() {
		return remark7;
	}

	/**
	 * 功能:set 备注7'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	/**
	 * 功能:get 备注8'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark8() {
		return remark8;
	}

	/**
	 * 功能:set 备注8'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	/**
	 * 功能:get 备注9'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark9() {
		return remark9;
	}

	/**
	 * 功能:set 备注9'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	/**
	 * 功能:get 备注10'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getRemark10() {
		return remark10;
	}

	/**
	 * 功能:set 备注10'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getNativeStr() {
		return nativeStr;
	}

	public void setNativeStr(String nativeStr) {
		this.nativeStr = nativeStr;
	}

	public String getCompanyCityStr() {
		return companyCityStr;
	}

	public void setCompanyCityStr(String companyCityStr) {
		this.companyCityStr = companyCityStr;
	}

	/**
	 * 功能:get 名族<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public String getReVarchar0() {
		// TODO Auto-generated method stub
		return super.getReVarchar0();
	}

	/**
	 * 功能:set 名族<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public void setReVarchar0(String reVarchar0) {
		// TODO Auto-generated method stub
		super.setReVarchar0(reVarchar0);
	}

	/**
	 * 功能:get 毕业年份<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public String getReVarchar1() {
		return super.getReVarchar1();
	}

	/**
	 * 功能:set 毕业年份<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public void setReVarchar1(String reVarchar1) {
		super.setReVarchar1(reVarchar1);
	}

	/**
	 * 功能:get 单位邮编<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public String getReVarchar2() {
		return super.getReVarchar2();
	}

	/**
	 * 功能:set 单位邮编<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public void setReVarchar2(String reVarchar2) {
		super.setReVarchar2(reVarchar2);
	}

	/**
	 * 功能:get 家庭邮编<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public String getReVarchar3() {
		// TODO Auto-generated method stub
		return super.getReVarchar3();
	}

	/**
	 * 功能:set 家庭邮编<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public void setReVarchar3(String reVarchar3) {
		// TODO Auto-generated method stub
		super.setReVarchar3(reVarchar3);
	}

	/**
	 * 功能:工作省区<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public String getReVarchar4() {
		return super.getReVarchar4();
	}

	/**
	 * 功能:set 工作省区<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public void setReVarchar4(String reVarchar4) {
		super.setReVarchar4(reVarchar4);
	}

	/**
	 * 功能:get 工作市区<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public String getReVarchar5() {
		return super.getReVarchar5();
	}

	/**
	 * 功能:set 工作市区<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	@Override
	public void setReVarchar5(String reVarchar5) {
		super.setReVarchar5(reVarchar5);
	}

}