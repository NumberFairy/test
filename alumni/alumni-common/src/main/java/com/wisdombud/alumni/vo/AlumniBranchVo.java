package com.wisdombud.alumni.vo;

import java.io.Serializable;

public class AlumniBranchVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String huizhang;
	private Integer memberNum;
	private String wechat;
	private String email;
	private String address;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHuizhang() {
		return huizhang;
	}
	public void setHuizhang(String huizhang) {
		this.huizhang = huizhang;
	}
	public Integer getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
