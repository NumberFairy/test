package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_TIMELINE")
public class BaseTimeline extends UUIDReservePo {

	@Column(name = "ALUMNI_ID")
	private String alumniId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "STATUS")
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}