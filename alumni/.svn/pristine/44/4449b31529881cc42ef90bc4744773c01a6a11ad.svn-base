package com.wisdombud.alumni.pojo.system;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDBasePo;

@Entity
@Table(name = "HOME_MENU")
public class HomeMenu extends UUIDBasePo {
	private static final long serialVersionUID = 1L;

	public final static int ROOT = 0;

	// 是否启用菜单
	public final static int TO_USE_YES = 1;
	public final static int TO_USE_NO = 0;

	// 跳转类型
	public final static int TYPE_LIST = 1; // 列表
	public final static int TYPE_DETAIL = 0;

	// 是否为内置对象
	public final static int BUILD_IN_YES = 1;
	public final static int BUILD_IN_NO = 0;

	// 是否允许上传
	public final static int UPLOAD_YES = 1;
	public final static int UPLOAD_NO = 0;

	@Column(name = "MENUE_ID")
	private Integer menuId;// 菜单编号

	@Column(name = "NAME")
	private String name;// 菜单名

	@Column(name = "TO_USE")
	private Integer toUse;// 是否启用 0启用 1不启用

	@Column(name = "PARENT_ID")
	private Integer parentId;// 父菜单

	@Column(name = "SORT")
	private Integer sort;// 排序

	@Column(name = "TYPE")
	private Integer type;// 跳转类型

	// 是否为内置菜单
	@Column(name = "BUILD_IN")
	private Integer buildIn;

	@Column(name = "URL")
	private String url;

	@Column(name = "UPLOAD_IMG")
	private Integer uploadImg;// 是否允许上传图片

	@Column(name = "UPLOAD_FILE")
	private Integer uploadFile;// 是否允上传附件

	@Column(name = "UPLOAD_VIDEO")
	private Integer uploadVideo;// 是否允许上传视频

	@Transient
	private List<HomeMenu> children;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getToUse() {
		return toUse;
	}

	public void setToUse(Integer toUse) {
		this.toUse = toUse;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getBuildIn() {
		return buildIn;
	}

	public void setBuildIn(Integer buildIn) {
		this.buildIn = buildIn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUploadImg() {
		return uploadImg;
	}

	public void setUploadImg(Integer uploadImg) {
		this.uploadImg = uploadImg;
	}

	public Integer getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(Integer uploadFile) {
		this.uploadFile = uploadFile;
	}

	public Integer getUploadVideo() {
		return uploadVideo;
	}

	public void setUploadVideo(Integer uploadVideo) {
		this.uploadVideo = uploadVideo;
	}

	public List<HomeMenu> getChildren() {
		return children;
	}

	public void setChildren(List<HomeMenu> children) {
		this.children = children;
	}
}