package com.wisdombud.alumni.actions.manage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisdombud.alumni.actions.base.AbstractCrudAction;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.dic.DicRegister;
import com.wisdombud.alumni.pojo.manage.BaseAlumniEnroll;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友登记表<br/>
 * date: 2017-3-29 15:55:33 <br/>
 * 
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/alumni-server-manage/alumni-check-in/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/alumni-server-manage/alumni-check-in/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-server-manage/alumni-check-in/page.jsp") })
public class AlumniEnrollAction extends AbstractCrudAction<BaseAlumniEnroll> {
	private static final long serialVersionUID = 1L;
	@Autowired
	public DicCommonSrv	dicCommonSrv;
	
	private List<DicRegister> registerList;
	private String			  enrollTypeContent;
	private String			  peopleContent;
	private String			  placeContent;
	private String			  contentContent;
	private Date			  startTimeContent;
	private Date			  endTimeContent;

	public AlumniEnrollAction(@Qualifier(value = "baseAlumniEnrollSrv") IBaseSrv<BaseAlumniEnroll> baseSrv) {
		super(baseSrv);
	}

	@Override
	protected List<Order> buildOrder() {
		List<Order> list = Lists.newArrayList();
		list.add(Order.desc("lastUpdate"));
		return list;
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params = Maps.newHashMap();
		if (!enrollTypeContent.equals("-999") && StringUtils.isNotBlank(enrollTypeContent)) {
			params.put("enrollType", Param.like(enrollTypeContent));
		}
		if (StringUtils.isNotBlank(peopleContent)) {
			params.put("people", Param.like(peopleContent));
		}
		if (StringUtils.isNotBlank(placeContent)) {
			params.put("place", Param.like(placeContent));
		}
		if (StringUtils.isNotBlank(contentContent)) {
			params.put("content", Param.like(contentContent));
		}
		if (startTimeContent != null) {
			params.put("startTime", Param.put(Param.EGT, startTimeContent));
			if (endTimeContent != null) {
				params.put("endTime", Param.put(Param.ELT, endTimeContent));
			} else {
				Date dt=this.addDayNum(startTimeContent,1);
				params.put("startTime", Param.put(Param.ELT, dt));
			}
		} else if (endTimeContent != null) {
			params.put("endTime", Param.put(Param.EGT, endTimeContent));
			Date dt=this.addDayNum(startTimeContent,1);
			params.put("endTime", Param.put(Param.ELT, dt));
		}

		return params;
	}

	/**
	 * 功能: 增加 天数.<br/>
	 * date: 2017年3月30日 下午4:43:01 <br/>
	 *
	 * @author czjia
	 * @param dt
	 * @param num
	 * @return
	 */
	private Date addDayNum(Date dt, int num) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, num);
		return calendar.getTime();
	}

	@Override
	public String hrefPage() {
		this.initData();
		return super.hrefPage();
	}

	@Override
	public String hrefAddOrUpdate() {
		this.initData();
		if (StringUtils.isNotBlank(this.id)) {
			this.entity = this.baseSrv.find(this.id);
		}
		return "toAddOrUpdate";
	}

	private void initData() {
		this.registerList=dicCommonSrv.findAll(DicRegister.class);
	}

	public List<DicRegister> getRegisterList() {
		return registerList;
	}

	public void setRegisterList(List<DicRegister> registerList) {
		this.registerList = registerList;
	}

	public String getEnrollTypeContent() {
		return enrollTypeContent;
	}

	public void setEnrollTypeContent(String enrollTypeContent) {
		this.enrollTypeContent = enrollTypeContent;
	}

	public String getPeopleContent() {
		return peopleContent;
	}

	public void setPeopleContent(String peopleContent) {
		this.peopleContent = peopleContent;
	}

	public String getPlaceContent() {
		return placeContent;
	}

	public void setPlaceContent(String placeContent) {
		this.placeContent = placeContent;
	}

	public String getContentContent() {
		return contentContent;
	}

	public void setContentContent(String contentContent) {
		this.contentContent = contentContent;
	}

	public Date getStartTimeContent() {
		return startTimeContent;
	}

	public void setStartTimeContent(Date startTimeContent) {
		this.startTimeContent = startTimeContent;
	}

	public Date getEndTimeContent() {
		return endTimeContent;
	}

	public void setEndTimeContent(Date endTimeContent) {
		this.endTimeContent = endTimeContent;
	}

}
