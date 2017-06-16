/**
 * Date:2015年2月4日 下午5:27:23
 * Copyright (c) 2015, www.wisdombud.com All Rights Reserved.
 */

package com.wisdombud.alumni.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.wisdombud.alumni.dao.common.DicCommonDao;
import com.wisdombud.common.forward.pojo.EmailForwardPojo;

import common.toolkit.java.spring.SpringContextHolder;

/**
 * 功能: TODO <br/>
 * date: 2015年2月4日 下午5:27:23 <br/>
 * 
 * @author guohuilin
 * @version
 * @since JDK 1.6
 */
public class EmailUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	private static final JavaMailSenderImpl mailSender;
	private static final ExecutorService clienExecutor = Executors.newFixedThreadPool(5);
	private static final String FROM_ADDRESS;
	private static final String NICK_NAME;

	static {
		DicCommonDao dicCommonDao = SpringContextHolder.getBean(DicCommonDao.class);
		// final SysConfig outBoxFrom =
		// dicCommonDao.findSysConfigByName("OUT_BOX_FROM");
		// final SysConfig outBoxUser =
		// dicCommonDao.findSysConfigByName("OUT_BOX_USER");
		// final SysConfig outBoxPassword =
		// dicCommonDao.findSysConfigByName("OUT_BOX_PASSWORD");
		// final SysConfig outBoxHost =
		// dicCommonDao.findSysConfigByName("OUT_BOX_HOST");
		// NICK_NAME = outBoxUser.getValue();
		// FROM_ADDRESS = outBoxFrom.getValue();
		NICK_NAME = null;
		FROM_ADDRESS = null;

		mailSender = new JavaMailSenderImpl();
		// mailSender.setHost(outBoxHost.getValue());
		// mailSender.setUsername(outBoxFrom.getValue());
		// mailSender.setPassword(outBoxPassword.getValue());
		mailSender.setPort(25);

		Properties mailProperties = new Properties();
		mailProperties.put("mail.transport.protocol", "smtp");
		mailProperties.put("mail.smtp.auth", "false");
		mailProperties.put("mail.smtp.starttls.enable", "false");
		mailProperties.put("mail.debug", "false");
		mailSender.setJavaMailProperties(mailProperties);
	}

	public static String readTemplate(String tplPath) throws IOException {
		final String passTpl = ServletActionContext.getServletContext().getRealPath("/") + tplPath;
		return FileUtils.readFileToString(new File(passTpl), "utf-8");
	}

	/**
	 * @see com.wisdombud.wisdomhr.common.srv.MailSenderSrv#sendEmail(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */

	public static void sendEmail(String[] toAddress, String fromAddress, String subject, String msgBody) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage
				.setFrom(NICK_NAME + "<" + (StringUtils.isEmpty(fromAddress) ? FROM_ADDRESS : fromAddress) + ">");
		simpleMailMessage.setTo(toAddress);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(msgBody);
		mailSender.send(simpleMailMessage);
	}

	/**
	 * @throws MessagingException
	 * @see com.wisdombud.wisdomhr.common.srv.MailSenderSrv#sendHtmlEmail(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */

	public static void sendHtmlEmail(String[] toAddress, String fromAddress, String subject, String htmlBody)
			throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
		helper.setTo(toAddress);
		helper.setFrom(NICK_NAME + "<" + (StringUtils.isEmpty(fromAddress) ? FROM_ADDRESS : fromAddress) + ">");
		helper.setText(htmlBody, true);
		helper.setSubject(subject);
		try {
			mailSender.send(message);
		} catch (Exception e) {
			throw new MessagingException("", e);
		}
	}

	/**
	 * @throws MessagingException
	 * @throws FileNotFoundException
	 * @see com.wisdombud.wisdomhr.common.srv.MailSenderSrv#sendHtmlEmail(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */

	public static void sendHtmlEmail(String[] toAddress, String fromAddress, String subject, String htmlBody,
			String filePath, String fileName) throws MessagingException, FileNotFoundException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setTo(toAddress);
		helper.setFrom(NICK_NAME + "<" + (StringUtils.isEmpty(fromAddress) ? FROM_ADDRESS : fromAddress) + ">");
		helper.setText(htmlBody, true);
		helper.setSubject(subject);
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("找不到附件：" + filePath);
		}
		helper.addAttachment(fileName, file);
		mailSender.send(message);
	}

	public static void sendHtmlEmail(String[] toAddress, String fromAddress, String subject, String htmlBody,
			Map<String, InputStreamSource> attaches) throws MessagingException, FileNotFoundException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setTo(toAddress);
		helper.setFrom(StringUtils.isEmpty(fromAddress) ? FROM_ADDRESS : fromAddress);
		helper.setText(htmlBody, true);
		helper.setSubject(subject);
		for (String fileName : attaches.keySet()) {
			helper.addAttachment(fileName, attaches.get(fileName));
		}

		mailSender.send(message);
	}

	public static void sendHtmlEmail(String toAddress, String fromAddress, String subject, String htmlBody,
			Map<String, InputStreamSource> attaches, Map<String, InputStreamSource> anotherAttaches)
			throws MessagingException, FileNotFoundException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setTo(toAddress);
		helper.setFrom(NICK_NAME + "<" + (StringUtils.isEmpty(fromAddress) ? FROM_ADDRESS : fromAddress) + ">");
		helper.setText(htmlBody, true);
		helper.setSubject(subject);
		for (String fileName : attaches.keySet()) {
			helper.addAttachment(fileName, attaches.get(fileName));
		}
		if (anotherAttaches != null) {
			for (String fileName : anotherAttaches.keySet()) {
				helper.addAttachment(fileName, anotherAttaches.get(fileName));
			}
		}

		mailSender.send(message);
	}

	/**
	 * @see com.wisdombud.wisdomhr.common.srv.MailSenderSrv#sendHtmlEmailAsyns(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */

	public static void sendHtmlEmailAsyns(final String toAddress, final String fromAddress, final String subject,
			final String htmlBody, final Map<String, InputStreamSource> attaches) {
		clienExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					EmailUtil.sendHtmlEmail(toAddress, fromAddress, subject, htmlBody, attaches, null);
				} catch (MessagingException | FileNotFoundException e) {
					LOGGER.error("异步发送HTML邮件失败。[subject=" + subject + ", email=" + toAddress + "]", e);
				}
			}
		});
	}

	/**
	 * @see com.wisdombud.wisdomhr.common.srv.MailSenderSrv#sendHtmlEmailAsyns(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */

	public static void sendHtmlEmailAsyns(final String[] toAddress, final String fromAddress, final String subject,
			final String htmlBody) {
		clienExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					EmailUtil.sendHtmlEmail(toAddress, fromAddress, subject, htmlBody);
				} catch (MessagingException e) {
					LOGGER.error("异步发送HTML邮件失败，邮件主题为" + subject, e);
				}
			}
		});
	}

	public static void sendEmail(EmailForwardPojo email, boolean isAsync) {
		String[] toAddress = new String[email.getDestinations().size()];
		EmailUtil.sendHtmlEmailAsyns(email.getDestinations().toArray(toAddress), FROM_ADDRESS, email.getSubject(),
				email.getMessage());
	}
}
