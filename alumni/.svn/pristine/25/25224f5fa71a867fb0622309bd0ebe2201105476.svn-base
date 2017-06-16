package com.wisdombud.alumni.pojo.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.google.gson.annotations.Expose;

/**
 * 功能: 操作菜单<br/>
 * date: 2017年4月11日 下午16:03:16 <br/>
 *
 * @author zxguan
 * @version
 * @since JDK 1.8
 */

@Entity
@Table(name = "SEC_OPER")
public class SecOper implements Serializable, Comparable<SecOper> {

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
	@Column(name = "DESC")
	private String desc;

	@Expose
	@Column(name = "PARENT_ID")
	private String parentId;

	@Expose
	@Column(name = "ICON")
	private String icon;

	@Expose
	@Column(name = "SORT_FLAG")
	private Integer sortFlag;

	@Expose
	@Column(name = "URL")
	private String url;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private SecOper parent;

	@ManyToMany
	@JoinTable(name = "SEC_ROLE_OPER", joinColumns = { @JoinColumn(name = "OPER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private List<SecRole> secRoles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(Integer sortFlag) {
		this.sortFlag = sortFlag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SecRole> getSecRoles() {
		return secRoles;
	}

	public void setSecRoles(List<SecRole> secRoles) {
		this.secRoles = secRoles;
	}

	public SecOper getParent() {
		return parent;
	}

	public void setParent(SecOper parent) {
		this.parent = parent;
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

	@Override
	public int compareTo(SecOper oper) {
		if (oper.getId().equalsIgnoreCase(this.getId())) {
			return 0;
		} else {
			if (oper.getSortFlag() > this.getSortFlag()) {
				return -1;
			} else if (oper.getSortFlag() < this.getSortFlag()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
