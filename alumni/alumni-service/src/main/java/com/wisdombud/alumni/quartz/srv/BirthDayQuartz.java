package com.wisdombud.alumni.quartz.srv;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wisdombud.alumni.common.EmailSrv;
import com.wisdombud.alumni.enums.AlumniNoticeEnum;
import com.wisdombud.alumni.enums.TplTagEnum;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseNoticeSrv;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseNotice;
import com.wisdombud.alumni.pojo.manage.BaseNoticeTemplate;
import com.wisdombud.alumni.pojo.system.SecUser;
import com.wisdombud.alumni.system.SecUserSrv;
import com.wisdombud.alumni.vo.MailVo;
import com.wisdombud.alumni.vo.Param;

/**
 * 生日祝福祝福 quartz线程执行频率高时需要保证线程安全
 * 
 * @author xiefei
 */
@Component
public class BirthDayQuartz {
	private static final Logger LOGGER = Logger.getLogger(BirthDayQuartz.class);

	@Autowired
	private BaseNoticeSrv noticeSrv;
	@Autowired
	private BaseAlumniSrv alumniSrv;
	@Autowired
	private SecUserSrv userSrv;
	@Autowired
	private EmailSrv sEmailSrv;

	public void doJob() {
		LOGGER.info("***BirthDay Quartz Start***");
		sendMail();
	}

	/**
	 * @DES:发送邮件
	 * @autor:xiefei<br/>
	 */
	private void sendMail() {
		// 生日语队列
		Map<String, Param> params = new HashMap<>();
		params.put("status", Param.eq(AlumniNoticeEnum.ENABLE.getValue()));
		params.put("noticeTitle", Param.eq("生日祝福"));
		// TODO 生日祝福有多条么？
		List<BaseNotice> notices = noticeSrv.findBy(params, new ArrayList<>());
		List<BaseAlumni> alumnis = allAlumniList();
		try {
			for (BaseAlumni v : alumnis) {
				if (StringUtils.isNotBlank(v.getEmail())) {
					for (BaseNotice note : notices) {
						MailVo vo = buildMail(note, v);
						if (vo != null) {
							LOGGER.info("发送生日通知:"+" "+vo.toString());
							sEmailSrv.sendMail(vo);
						}
					}
				}
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	private List<BaseAlumni> allAlumniList() {
		Map<String, Param> params = new HashMap<>();
		params.put("birthDate", Param.eq(new Date()));
		return alumniSrv.findBy(params, new ArrayList<>());
	}

	private MailVo buildMail(BaseNotice note, BaseAlumni v) {
		BaseNoticeTemplate tpl = noticeSrv.find(note.getId()).getTemplate();
		if (tpl != null && StringUtils.isNotBlank(tpl.getContent())) {
			String con = tpl.getContent();
			MailVo vo = new MailVo();
			vo.setContent(buildDetail(con, v));
			List<String> mail = new ArrayList<>();
			mail.add(v.getEmail());
			vo.setRecipientList(mail);
			String title = tpl.getTitle();
			vo.setTitle(buildDetail(title, v));
			return vo;
		}
		return null;
	}

	// 标签提取，转换
	private String buildDetail(String con, BaseAlumni v) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat date= new SimpleDateFormat("MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (StringUtils.isNotBlank(con)) {
			// 发送人标签
			if (con.indexOf(TplTagEnum.AUTOR.getTag()) >= 0) {
				SecUser user = userSrv.find("1");
				con = con.replace(TplTagEnum.AUTOR.getTag(), user.getName());
			}
			// 姓名标签
			if (con.indexOf(TplTagEnum.NAME.getTag()) >= 0) {
				con = con.replace(TplTagEnum.NAME.getTag(), v.getName());
			}
			// 默认替换时间
			if (con.indexOf(TplTagEnum.TIME_DEFAULT.getTag()) >= 0 || con.indexOf(TplTagEnum.TIME_DATE.getTag()) >= 0) {
				con = con.replace(TplTagEnum.TIME_DEFAULT.getTag(), df.format(new Date()));
				con = con.replace(TplTagEnum.TIME_DATE.getTag(), df.format(new Date()));
			}
			// 时间戳
			if (con.indexOf(TplTagEnum.TIME_DATE_TIME.getTag()) >= 0) {
				con.replace(TplTagEnum.TIME_DATE_TIME.getTag(), time.format(new Date()));
			}
			// 年
			if (con.indexOf(TplTagEnum.TIME_YEAR.getTag()) >= 0) {
				con = con.replace(TplTagEnum.TIME_YEAR.getTag(), new Date().getTime() + "");
			}
			// 生日
			if (con.indexOf(TplTagEnum.BIRTHDAY.getTag()) >= 0) {
				con = con.replace(TplTagEnum.BIRTHDAY.getTag(), date.format(v.getBirthDate()));
			}
			return con;
		}
		return "";
	}
}
