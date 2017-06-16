package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "HOME_INFORMATION_RELEASE")
public class HomeInformationRelease extends UUIDReservePo {
	private static final long serialVersionUID = 1L;
	@Transient
	private Integer isSignUp;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "TYPESTR")
	private String typestr;

	@Column(name = "PUBLISHER")
	private String publisher;

	@Column(name = "SUMMARY")
	private String summary;

	@Column(name = "IS_ENABLE")
	private Integer isEnable;

	@Transient
	private String isEnableStr;

	@Column(name = "IS_TOP")
	private Integer isTop;

	@Transient
	private String isTopStr;

	@Column(name = "VIEW_COUNT")
	private Integer viewCount;

	@Column(name = "SOURCE")
	private String source;

	@Column(name = "IMG_ID")
	private String imgId;

	@Column(name = "IMG_NAME")
	private String imgName;

	@Column(name = "VIDEO_ID")
	private String videoId;

	@Column(name = "VIDEO_NAME")
	private String videoName;

	@Column(name = "FILE_ID")
	private String fileId;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "CONTENT")
	private String content;

	/**
	 * 功能:get 标题'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * 功能:set 标题'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 功能:get 类型'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getTypestr() {
		return typestr;
	}

	/**
	 * 功能:set 类型'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}

	/**
	 * 功能:get 发布人'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getPublisher() {
		return publisher;
	}

	/**
	 * 功能:set 发布人'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * 功能:get 是否启用'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getIsEnable() {
		return isEnable;
	}

	/**
	 * 功能:set 是否启用'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	/**
	 * 功能:get 是否置顶'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getIsTop() {
		return isTop;
	}

	/**
	 * 功能:set 是否置顶'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	/**
	 * 功能:get 浏览次数'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * 功能:set 浏览次数'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * 功能:get 来源'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getSource() {
		return source;
	}

	/**
	 * 功能:set 来源'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 功能:get 图片ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getImgId() {
		return imgId;
	}

	/**
	 * 功能:set 图片ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	/**
	 * 功能:get 影片ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getVideoId() {
		return videoId;
	}

	/**
	 * 功能:set 影片ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	/**
	 * 功能:get 内容'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getContent() {
		return content;
	}

	/**
	 * 功能:set 内容'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public String getIsEnableStr() {
		return isEnableStr;
	}

	public void setIsEnableStr(String isEnableStr) {
		this.isEnableStr = isEnableStr;
	}

	public String getIsTopStr() {
		return isTopStr;
	}

	public void setIsTopStr(String isTopStr) {
		this.isTopStr = isTopStr;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getIsSignUp() {
		return isSignUp;
	}

	public void setIsSignUp(Integer isSignUp) {
		this.isSignUp = isSignUp;
	}

}