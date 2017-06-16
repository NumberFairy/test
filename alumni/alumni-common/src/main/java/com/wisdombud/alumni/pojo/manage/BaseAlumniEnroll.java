package com.wisdombud.alumni.pojo.manage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name= "BASE_ALUMNI_ENROLL")
public class BaseAlumniEnroll extends UUIDReservePo{
private static final long serialVersionUID = 1L;

	@Column(name= "ENROLL_TYPE")
	private String enrollType;
   
	@Column(name= "START_TIME")
	private Date startTime;
   
	@Column(name= "END_TIME")
	private Date endTime;
   
	@Column(name= "PLACE")
	private String place;
   
	@Column(name= "PEOPLE")
	private String people;
   
	@Column(name= "CONTENT")
	private String content;
	
	@Transient
	private String enrollTypeName;
   
   
	/**
	 * 功能:get '登记类型'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getEnrollType(){
		return enrollType;
	}
   
	/**
	 * 功能:set '登记类型'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEnrollType(String enrollType){
		this.enrollType = enrollType;
	}
   
	/**
	 * 功能:get '开始时间'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Date getStartTime(){
		return startTime;
	}
   
	/**
	 * 功能:set '开始时间'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
   
	/**
	 * 功能:get '结束时间'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Date getEndTime(){
		return endTime;
	}
   
	/**
	 * 功能:set '结束时间'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
   
	/**
	 * 功能:get '地点'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getPlace(){
		return place;
	}
   
	/**
	 * 功能:set '地点'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPlace(String place){
		this.place = place;
	}
   
	/**
	 * 功能:get '参与人'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getPeople(){
		return people;
	}
   
	/**
	 * 功能:set '参与人'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPeople(String people){
		this.people = people;
	}
   
	/**
	 * 功能:get '内容'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getContent(){
		return content;
	}
   
	/**
	 * 功能:set '内容'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setContent(String content){
		this.content = content;
	}

	public String getEnrollTypeName() {
		return enrollTypeName;
	}

	public void setEnrollTypeName(String enrollTypeName) {
		this.enrollTypeName = enrollTypeName;
	}
}