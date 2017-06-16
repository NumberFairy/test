package com.wisdombud.alumni.pojo.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDAlumniPo;

@Entity
@Table(name = "PUBLIC_USER")
public class PublicUser extends UUIDAlumniPo {

	private static final long serialVersionUID = 1L;

	@Column(name = "LOGIN_NAME")
    private String loginName;

    @Column(name = "PWD_HASH")
    private String pwdHash;

    @Column(name = "SALT")
    private String salt;

    @Column(name = "DESIGNATION")
    private int designation;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}

}
