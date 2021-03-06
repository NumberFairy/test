package com.wisdombud.alumni.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.util.PropKit;
import com.wisdombud.alumni.vo.MailVo;

@Service
public class EmailImpl implements EmailSrv {

	private static final Logger LOGGER = Logger.getLogger(EmailImpl.class);
	private String userName;
	private String pwd;
	private String sender;
	private String host;

	public void sendMail(String title, List<String> recipients, List<String> filePaths, String content) {
		initMail();
		// 邮件服务器
		Properties props = initProperties();
		// 认证
		Authenticator authenticator = initAuthenticator();
		Session session = Session.getInstance(props, authenticator);
		session.setDebug(false);
		Message message = initEmailBody(session, title, recipients);
		BodyPart part1 = new MimeBodyPart();
		BodyPart part2 = new MimeBodyPart();
		Multipart multipart = new MimeMultipart();
		Pattern p = Pattern.compile("<([^>]*)>");
		Matcher m = p.matcher(content);
		boolean rs = m.matches();
		try {
			if (rs) {
				part1.setContent(content, "text/html;charset=utf-8");
			} else {
				part1.setText(content);
			}
			multipart.addBodyPart(part1);
			// 文件
			if (CollectionUtils.isNotEmpty(filePaths)) {
				part2.setContent(initFile(filePaths));
				multipart.addBodyPart(part2);
			}
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("构造邮件异常!");
		}
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			LOGGER.error("发送失败!");
		}
	}

	// 认证
	private Authenticator initAuthenticator() {
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, pwd);
			}
		};
		return authenticator;
	}

	// header
	private Message initEmailBody(Session session, String title, List<String> recipientss) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			message.setSubject(title);
			String recipientStr = "";
			for (String recipient : recipientss) {
				recipientStr = recipientStr + "," + recipient;
			}
			if (recipientStr.length() > 1) {
				Address[] recipients = InternetAddress.parse(recipientStr.substring(1));
				message.setRecipients(RecipientType.TO, recipients);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("邮箱格式异常！");
		}
		return message;
	}

	// 文件
	private Multipart initFile(List<String> filePaths) throws MessagingException {
		Multipart attachments = new MimeMultipart();
		for (String filePath : filePaths) {
			BodyPart attach = new MimeBodyPart();
			// 设置附件的内容
			File file = new File(filePath);
			DataSource dataSource_attach = new FileDataSource(file);
			DataHandler dataHandler_attach = new DataHandler(dataSource_attach);
			attach.setDataHandler(dataHandler_attach);
			attach.setFileName(file.getName());
			attachments.addBodyPart(attach);
		}
		return attachments;
	}

	private void initMail() {
		PropKit.use("config/email.conf");
		userName = PropKit.get("username");
		pwd = PropKit.get("pwd");
		sender = PropKit.get("username");
		host = PropKit.get("host");
	}

	private Properties initProperties() {
		Properties props = new Properties();
		props.setProperty("mail.host", host);
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		return props;
	}

	/**
	 * @DES:发送 邮件
	 * @autor:xiefei<br/>
	 */
	public void sendMail(MailVo vo) {
		sendMail(vo.getTitle(), vo.getRecipientList(), vo.getAbsoluteFilePathList(), vo.getContent());
	}

	/**
	 * @throws Exception
	 * @DES:发送邮件
	 * @autor:xiefei<br/>
	 */
	public void sendMail(String title, List<String> recipients, String content) {
		sendMail(title, recipients, new ArrayList<String>(), content);
	}
}
