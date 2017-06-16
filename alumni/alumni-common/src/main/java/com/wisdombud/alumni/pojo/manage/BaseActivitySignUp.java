package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name= "BASE_ACTIVITY_SIGN_UP")
public class BaseActivitySignUp extends UUIDReservePo{
private static final long serialVersionUID = 1L;

	@Column(name= "ACTIVITY_ID")
	private String activityId;
   
	@Column(name= "ALUMNI_ID")
	private String alumniId;
   
	@Column(name= "ALUMNI_NAME")
	private String alumniName;
   
	@Column(name= "GENDER")
	private Integer gender;
   
	@Column(name= "COLLEGE")
	private Integer college;
   
	@Column(name= "ENROLL_YEAR")
	private Integer enrollYear;
	
	@Column(name= "IDENTITY")
	private Integer identity;
	
	@Transient
	private String genderName;
	
	@Transient
	private String collegeName;
	
	@Transient
	private String identityName;
   
	/**
	 * 功能:get '校友活动ID'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getActivityId(){
		return activityId;
	}
   
	/**
	 * 功能:set '校友活动ID'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setActivityId(String activityId){
		this.activityId = activityId;
	}
   
	/**
	 * 功能:get '校友ID'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getAlumniId(){
		return alumniId;
	}
   
	/**
	 * 功能:set '校友ID'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAlumniId(String alumniId){
		this.alumniId = alumniId;
	}
   
	/**
	 * 功能:get '校友姓名'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getAlumniName(){
		return alumniName;
	}
   
	/**
	 * 功能:set '校友姓名'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAlumniName(String alumniName){
		this.alumniName = alumniName;
	}
   
	/**
	 * 功能:get '性别'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Integer getGender(){
		return gender;
	}
   
	/**
	 * 功能:set '性别'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setGender(Integer gender){
		this.gender = gender;
	}
   
	/**
	 * 功能:get '学院'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Integer getCollege(){
		return college;
	}
   
	/**
	 * 功能:set '学院'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setCollege(Integer college){
		this.college = college;
	}
   
	/**
	 * 功能:get '入学年份'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Integer getIdentity() {
		return identity;
	}

	public Integer getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(Integer enrollYear) {
		this.enrollYear = enrollYear;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getIdentityName() {
		return identityName;
	}

	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}

}