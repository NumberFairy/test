package com.wisdombud.alumni.vo;

import java.util.List;

public class MailVo {

	private String title; // 标题
	private List<String> recipientList; // 接收邮箱地址
	private String content;
	private List<String> absoluteFilePathList; // 附件地址

	public List<String> getRecipientList() {
		return recipientList;
	}

	public void setRecipientList(List<String> recipientList) {
		this.recipientList = recipientList;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAbsoluteFilePathList() {
		return absoluteFilePathList;
	}

	public void setAbsoluteFilePathList(List<String> absoluteFilePathList) {
		this.absoluteFilePathList = absoluteFilePathList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MailVo [title=" + title + ", recipientList=" + recipientList + ", content=" + content
				+ ", absoluteFilePathList=" + absoluteFilePathList + "]";
	}
}
