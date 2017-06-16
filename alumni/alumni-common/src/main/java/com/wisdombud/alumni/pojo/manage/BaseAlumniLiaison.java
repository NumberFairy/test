package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_ALUMNI_LIAISON")
public class BaseAlumniLiaison extends UUIDReservePo {
	private static final long serialVersionUID = 1L;

	@Column(name = "BRANCH_ID")
	private String branchId;

	@Column(name = "ALUMNI_ID")
	private String alumniId;

	@Transient
	private BaseAlumni alumni;
	@Transient
	private BaseIdentityRelation relation;

	/**
	 * 功能:get 分会ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getBranchId() {
		return branchId;
	}

	/**
	 * 功能:set 分会ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * 功能:get 校友ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getAlumniId() {
		return alumniId;
	}

	/**
	 * 功能:set 校友ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAlumniId(String alumniId) {
		this.alumniId = alumniId;
	}

	public BaseAlumni getAlumni() {
		return alumni;
	}

	public void setAlumni(BaseAlumni alumni) {
		this.alumni = alumni;
	}

	public BaseIdentityRelation getRelation() {
		return relation;
	}

	public void setRelation(BaseIdentityRelation relation) {
		this.relation = relation;
	}

}