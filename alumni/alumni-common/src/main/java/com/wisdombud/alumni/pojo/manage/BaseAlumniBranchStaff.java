package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name= "BASE_ALUMNI_BRANCH_STAFF")
public class BaseAlumniBranchStaff extends UUIDReservePo{
private static final long serialVersionUID = 1L;

	@Column(name= "NAME")
	private String name;

	@Column(name= "STAFF")
	private String staff;

	@Transient
	private String staffStr;

	@Column(name= "PHONE")
	private String phone;

	@Column(name= "EMAIL")
	private String email;

	@Column(name="BRANCH_ID")
	private String branchId;


	/**
	 * 功能:get 校友姓名'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getName(){
		return name;
	}

	/**
	 * 功能:set 校友姓名'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * 功能:get 任职身份'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getStaff(){
		return staff;
	}

	/**
	 * 功能:set 任职身份'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setStaff(String staff){
		this.staff = staff;
	}

	public String getStaffStr() {
		return staffStr;
	}

	public void setStaffStr(String staffStr) {
		this.staffStr = staffStr;
	}

	/**
	 * 功能:get 联系电话'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getPhone(){
		return phone;
	}

	/**
	 * 功能:set 联系电话'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}

	/**
	 * 功能:get 邮箱'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getEmail(){
		return email;
	}

	/**
	 * 功能:set 邮箱'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEmail(String email){
		this.email = email;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

}