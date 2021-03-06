package com.wisdombud.alumni.pojo.manage;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

/**
 * 功能: 校友会信息表<br/>
 * date: 2017年3月2日 上午11:03:16 <br/>
 *
 * @author zxguan
 * @version
 * @since JDK 1.8
 */
@Entity
@Table(name= "BASE_ALUMNI_BRANCH")
public class BaseAlumniBranch extends UUIDReservePo{
private static final long serialVersionUID = 1L;

	@Column(name= "NAME")
	private String name;

	/**
	 * 此字段冗余，但易引起bug <br/>
	 */
	@Deprecated
	@Column(name= "MEMBER_NUM")
	private Integer memberNum;

	@Column(name= "TYPE")
	private Integer type;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="BRANCH_ID")
	private List<BaseAlumniBranchStaff> staffList;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="BRANCH_ID", insertable=false, updatable=false)
	private List<BaseBranchRelation> memberList;

	@Column(name= "WECHAT_ID")
	private String wechatId;

	@Column(name= "EMAIL")
	private String email;

	@Column(name= "ADDRESS")
	private String address;

	@Column(name= "ESTABLISHED_TIME")
	private Date establishedTime;

	@Column(name= "INTRODUCTION ")
	private String introduction ;

	/**
	 * 功能:get 校友会名称'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getName(){
		return name;
	}

	/**
	 * 功能:set 校友会名称'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * 功能:get '分会类型'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
	public Integer getType() {
		return type;
	}

	/**
	 * 功能:set '分会类型'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 功能:get '成员数'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	@Deprecated
	public Integer getMemberNum(){
		return memberNum;
	}

	/**
	 * 功能:set '成员数'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	@Deprecated
	public void setMemberNum(Integer memberNum){
		this.memberNum = memberNum;
	}

	/**
	 * 功能:get '微信号'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getWechatId(){
		return wechatId;
	}

	/**
	 * 功能:set '微信号'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setWechatId(String wechatId){
		this.wechatId = wechatId;
	}

	/**
	 * 功能:get '成立时间'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public Date getEstablishedTime(){
		return establishedTime;
	}

	/**
	 * 功能:set '成立时间'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEstablishedTime(Date establishedTime){
		this.establishedTime = establishedTime;
	}

	/**
	 * 功能:get '邮件'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 功能:set '邮件'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 功能:get '地址'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 功能:set '地址'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 功能:get '简介'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getIntroduction (){
		return introduction ;
	}

	/**
	 * 功能:set '简介'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIntroduction (String introduction ){
		this.introduction  = introduction ;
	}

	/**
	 * 功能:get '校友分会领导'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public List<BaseAlumniBranchStaff> getStaffList() {
		return staffList;
	}

	/**
	 * 功能:set '校友分会领导'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setStaffList(List<BaseAlumniBranchStaff> staffList) {
		this.staffList = staffList;
	}

	/**
	 * 功能:get '成员'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public List<BaseBranchRelation> getMemberList() {
		return memberList;
	}

	/**
	 * 功能:set '成员'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setMemberList(List<BaseBranchRelation> memberList) {
		this.memberList = memberList;
	}

}