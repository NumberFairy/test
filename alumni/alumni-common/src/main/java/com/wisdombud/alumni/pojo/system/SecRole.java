package com.wisdombud.alumni.pojo.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "SEC_ROLE")
public class SecRole implements Serializable {

	private static final long serialVersionUID = 1L;
	@Expose
	@Id
	@Column(name = "ID", updatable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDHexGenerator")
	public String id;

	@Expose
	@Column(name = "CREATE_TIME")
	private Date createTime;

	@Expose
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;

	@Expose
	@Column(name = "NAME")
	private String name;

	@Expose
	@Column(name = "DESCRIPTION")
	private String description;

	@Expose
	@Column(name = "IS_ADMIN")
	private Integer isAdmin;

	@OrderBy("sortFlag ASC")
	@ManyToMany(targetEntity = SecOper.class, fetch = FetchType.LAZY)
	@JoinTable(name = "SEC_ROLE_OPER", joinColumns = @JoinColumn(name = "ROLE_ID"), inverseJoinColumns = @JoinColumn(name = "OPER_ID"))
	private Set<SecOper> secOpers = Sets.newHashSet();

	// 多对多映射
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	// 中间表定义,表名采用默认命名规则
	@JoinTable(name = "SEC_USER_ROLE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID") })
	private List<SecUser> secUsers = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<SecOper> getSecOpers() {
		return secOpers;
	}

	public void setSecOpers(Set<SecOper> secOpers) {
		this.secOpers = secOpers;
	}

	public List<SecUser> getSecUsers() {
		return secUsers;
	}

	public void setSecUsers(List<SecUser> secUsers) {
		this.secUsers = secUsers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}