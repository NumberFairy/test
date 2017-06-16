package com.wisdombud.alumni.common;

import java.util.List;

import com.wisdombud.alumni.vo.MailVo;

public interface EmailSrv {

	/**
	 * @DES:发送邮件
	 * @param title:标题<br/>
	 * @param toUsers:收件人邮箱列表<br/>
	 * @param filePaths:邮件附件路径<br/>
	 * @param content:邮件内容<br/>
	 * @autor:xiefei<br/>
	 */
	void sendMail(String title, List<String> toUsers, List<String> filePaths, String content);

	/**
	 * @DES:发送 邮件
	 * @autor:xiefei<br/>
	 */
	void sendMail(MailVo vo);

	/**
	 * @DES:发送 邮件
	 * @autor:xiefei<br/>
	 */
	void sendMail(String title, List<String> toUsers, String content);
}
