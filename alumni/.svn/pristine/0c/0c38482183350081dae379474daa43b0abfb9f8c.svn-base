package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_NOTICE_TEMPLATE")
public class BaseNoticeTemplate extends UUIDReservePo {
	private static final long serialVersionUID = 1L;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "PERSON")
	private String person;

	@Transient
	private String personName;

	/**
	 * 功能:get '主题'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * 功能:set '主题'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 功能:get '内容'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getContent() {
		return content;
	}

	/**
	 * 功能:set '内容'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 功能:get '创建人'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getPerson() {
		return person;
	}

	/**
	 * 功能:set '创建人'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPerson(String person) {
		this.person = person;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
}