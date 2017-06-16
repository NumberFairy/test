package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "BASE_NOTICE")
public class BaseNotice extends UUIDReservePo {
	private static final long serialVersionUID = 1L;

	@Column(name = "NOTICE_TITLE")
	private String noticeTitle;

	@Column(name = "NOTICE_TYPE")
	private String noticeType;

	@Column(name = "NOTICE_MODE")
	private String noticeMode;

	@Column(name = "NOTICE_TEMPLATE")
	private String noticeTemplate;

	@Column(name = "PERSON")
	private String person;

	@Column(name = "STATUS")
	private Integer status;

	@Transient
	private String noticeTypeName;
	@Transient
	private String noticeModeName;
	@Transient
	private String noticeTemplateName;
	@Transient
	private String statusName;
	@Transient
	private BaseNoticeTemplate template;
	@Transient
	private String personName;

	/**
	 * 功能:get '名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getNoticeTitle() {
		return noticeTitle;
	}

	/**
	 * 功能:set '名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	/**
	 * 功能:get '通知类型'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getNoticeType() {
		return noticeType;
	}

	/**
	 * 功能:set '通知类型'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	/**
	 * 功能:get '通知方式'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getNoticeMode() {
		return noticeMode;
	}

	/**
	 * 功能:set '通知方式'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setNoticeMode(String noticeMode) {
		this.noticeMode = noticeMode;
	}

	/**
	 * 功能:get '通知模板'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getNoticeTemplate() {
		return noticeTemplate;
	}

	/**
	 * 功能:set '通知模板'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setNoticeTemplate(String noticeTemplate) {
		this.noticeTemplate = noticeTemplate;
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

	/**
	 * 功能:get '状态0：停用1：启用'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getStatus() {
		return status;
	}

	/**
	 * 功能:set '状态0：停用1：启用'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNoticeTypeName() {
		return noticeTypeName;
	}

	public void setNoticeTypeName(String noticeTypeName) {
		this.noticeTypeName = noticeTypeName;
	}

	public String getNoticeModeName() {
		return noticeModeName;
	}

	public void setNoticeModeName(String noticeModeName) {
		this.noticeModeName = noticeModeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getNoticeTemplateName() {
		return noticeTemplateName;
	}

	public void setNoticeTemplateName(String noticeTemplateName) {
		this.noticeTemplateName = noticeTemplateName;
	}

	public BaseNoticeTemplate getTemplate() {
		return template;
	}

	public void setTemplate(BaseNoticeTemplate template) {
		this.template = template;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}