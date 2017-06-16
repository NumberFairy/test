package com.wisdombud.alumni.pojo.manage;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name= "BASE_BRANCH_RELATION")
public class BaseBranchRelation extends UUIDReservePo{
private static final long serialVersionUID = 1L;

	@Column(name= "ALUMNI_ID")
	private String alumniId;

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(updatable=false, insertable=false)
	private BaseAlumni alumni;

	@Column(name= "BRANCH_ID")
	private String branchId;


	/**
	 * 功能:get 校友信息<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getAlumniId(){
		return alumniId;
	}

	/**
	 * 功能:set 校友信息<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setAlumniId(String alumniId){
		this.alumniId = alumniId;
	}

	/**
	 * 功能:get 分会<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/

	public String getBranchId(){
		return branchId;
	}

	/**
	 * 功能:set 分会<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setBranchId(String branchId){
		this.branchId = branchId;
	}

	public BaseAlumni getAlumni() {
		return alumni;
	}

	public void setAlumni(BaseAlumni alumni) {
		this.alumni = alumni;
	}

}