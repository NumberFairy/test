package com.wisdombud.alumni.actions.manage;

import java.util.Date;
import java.util.HashMap;
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
import com.wisdombud.alumni.common.EmailSrv;
import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.enums.AlumniIdentityEnum;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseIdentityRelationSrv;
import com.wisdombud.alumni.pojo.dic.DicAlumniBranchIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniClubIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniIdentity;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.dic.DicDegree;
import com.wisdombud.alumni.pojo.dic.DicIndustry;
import com.wisdombud.alumni.pojo.dic.DicPoliticalStatus;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.vo.CommonResult;
import com.wisdombud.alumni.vo.Param;

/**
 * 功能: 校友管理中心-联络员管理<br/>
 * date: 2017-3-28 19:28:27 <br/>
 *
 * @author robot
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/alumni-manage-center/liaison-manage/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/alumni-manage-center/liaison-manage/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-manage-center/liaison-manage/page.jsp") })
public class LiaisonManageAction extends AbstractCrudAction<BaseIdentityRelation> {
	private static final long			 serialVersionUID = 1L;
	@Autowired
	public BaseAlumniSrv				 alumniSrv;
	@Autowired
	public DicCommonSrv					 dicCommonSrv;
	@Autowired
	private EmailSrv					 emailSrv;
	@Autowired
	private BaseIdentityRelationSrv		 relationSrv;

	public List<DicPoliticalStatus>		 dicPoliticalStatusList;
	public List<DicCollege>				 dicCollegeList;
	public List<DicSpecialty>			 dicSpecialtyList;
	public List<DicDegree>				 dicDegreeList;
	public List<DicIndustry>			 dicIndustryList;
	public List<DicAlumniClubIdentity>	 dicAlumniClubIdentityList;
	public List<DicAlumniBranchIdentity> dicAlumniBranchIdentityList;
	public List<DicAlumniIdentity>		 dicAlumniIdentityList;
	public BaseAlumni					 alumni;
	public String						 title;
	public String						 email;
	public String						 replyContent;

	public LiaisonManageAction(@Qualifier(value = "baseIdentityRelationSrv") IBaseSrv<BaseIdentityRelation> baseSrv) {
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
		if (this.alumni == null) {
			return new HashMap<>();
		}
		if (StringUtils.isNotEmpty(this.alumni.getName())) {
			params.put("name", Param.like(this.alumni.getName()));
		}
		if (this.alumni.getCollege() != null) {
			params.put("college", Param.eq(this.alumni.getCollege()));
		}
		if (alumni.getMajor() != null) {
			params.put("major", Param.eq(alumni.getMajor()));
		}
		if (alumni.getGender() != null) {
			params.put("gender", Param.eq(this.alumni.getGender()));
		}
		if (alumni.getIdentity() != null) {
			params.put("identity", Param.eq(this.alumni.getIdentity()));
		}
		if (StringUtils.isNotEmpty(this.alumni.getCode())) {
			params.put("code", Param.eq(this.alumni.getCode()));
		}

		if (this.alumni.getBirthDate() != null) {
			params.put("birthDate", Param.eq(this.alumni.getBirthDate()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getNativeStr())) {
			params.put("nativeStr", Param.eq(this.alumni.getNativeStr()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getPoliticalStatusName())) {
			params.put("politicalStatus", Param.eq(Integer.valueOf(this.alumni.getPoliticalStatusName())));
		}

		if (this.alumni.getEnrollYear() != null) {
			params.put("enrollYear", Param.eq(this.alumni.getEnrollYear()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getReVarchar1())) {
			params.put("reVarchar1", Param.like(this.alumni.getReVarchar1()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getWechatId())) {
			params.put("wechatId", Param.like(this.alumni.getWechatId()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getWechatName())) {
			params.put("wechatName", Param.like(this.alumni.getWechatName()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getQq())) {
			params.put("qq", Param.like(this.alumni.getQq()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getPhone())) {
			params.put("phone", Param.like(this.alumni.getPhone()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getEmail())) {
			params.put("email", Param.like(this.alumni.getEmail()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getClassName())) {
			params.put("className", Param.like(this.alumni.getClassName()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getTeacher())) {
			params.put("teacher", Param.like(this.alumni.getTeacher()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getCompany())) {
			params.put("company", Param.like(this.alumni.getCompany()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getReVarchar2())) {
			params.put("reVarchar2", Param.like(this.alumni.getReVarchar2()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getReVarchar3())) {
			params.put("reVarchar3", Param.like(this.alumni.getReVarchar3()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getCompanyAddress())) {
			params.put("companyAddress", Param.like(this.alumni.getCompanyAddress()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getDepartment())) {
			params.put("department", Param.like(this.alumni.getDepartment()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getTitle())) {
			params.put("title", Param.like(this.alumni.getTitle()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getAddress())) {
			params.put("address", Param.like(this.alumni.getAddress()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getHighestEducationName())
			&& !this.alumni.getHighestEducationName().contains("-1")) {
			params.put("highestEducation", Param.eq(Integer.parseInt(this.alumni.getHighestEducationName())));
		}
		// 校友会任职身份
		if (StringUtils.isNotEmpty(this.alumni.getAlumniClubIdentityName())
			&& !this.alumni.getAlumniClubIdentityName().contains("-1")) {
			params.put("alumniClubIdentityId", Param.like(this.alumni.getAlumniClubIdentityName()));
		}
		// 校友身份
		if (StringUtils.isNotEmpty(this.alumni.getAlumniIdentityName())
			&& !this.alumni.getAlumniIdentityName().contains("-1")) {
			params.put("alumniIdentityId", Param.like(AlumniIdentityEnum.ALUMNI_LIAISON.getValue()));
		}

		// 校友身份
		if (StringUtils.isNotEmpty(this.alumni.getBranchClubIdentityName())
			&& !this.alumni.getBranchClubIdentityName().contains("-1")) {
			params.put("branchClubIdentityId", Param.like(this.alumni.getBranchClubIdentityName()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getIndustryName())) {
			params.put("industry", Param.eq(Integer.parseInt(this.alumni.getIndustryName())));
		}

		if (StringUtils.isNotEmpty(this.alumni.getCompanyCityStr())) {
			params.put("companyCityStr", Param.like(this.alumni.getCompanyCityStr()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getOfficePhone())) {
			params.put("officePhone", Param.like(this.alumni.getOfficePhone()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getPost())) {
			params.put("post", Param.like(this.alumni.getPost()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getRemark1())) {
			params.put("remark1", Param.like(this.alumni.getRemark1()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getRemark2())) {
			params.put("remark2", Param.like(this.alumni.getRemark2()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getRemark3())) {
			params.put("remark3", Param.like(this.alumni.getRemark3()));
		}
		if (StringUtils.isNotEmpty(this.alumni.getRemark4())) {
			params.put("remark4", Param.like(this.alumni.getRemark4()));
		}
		if (StringUtils.isNotEmpty(this.alumni.getRemark5())) {
			params.put("remark5", Param.like(this.alumni.getRemark5()));
		}
		if (StringUtils.isNotEmpty(this.alumni.getRemark6())) {
			params.put("remark6", Param.like(this.alumni.getRemark6()));
		}
		if (StringUtils.isNotEmpty(this.alumni.getRemark7())) {
			params.put("remark7", Param.like(this.alumni.getRemark7()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getRemark8())) {
			params.put("remark8", Param.like(this.alumni.getRemark8()));
		}

		if (StringUtils.isNotEmpty(this.alumni.getRemark9())) {
			params.put("remark9", Param.like(this.alumni.getRemark9()));
		}
		if (StringUtils.isNotEmpty(this.alumni.getRemark10())) {
			params.put("remark10", Param.like(this.alumni.getRemark10()));
		}

		return params;
	}

	@Override
	public void delete() {
		if (this.isAjaxRequest()) {
			this.relationSrv.updateALumniIdentity(id, AlumniIdentityEnum.ALUMNI_LIAISON.getValue());
			CommonResult result = new CommonResult(CommonResult.SUCCESS);
			this.sendResponseMsg(result);
		}
	}

	public void sendMail() {
		List<String> emailAddressList = relationSrv.string2List(email);
		if (emailAddressList != null && emailAddressList.size() > 0) {
			emailSrv.sendMail(title, emailAddressList, replyContent);
			this.sendSuccessMsg();
		} else {
			this.sendFailMsg(email, "sendMail failed!");
		}
	}

	public void forEmail() {
		if (StringUtils.isNotEmpty(id)) {
			String strEmail = relationSrv.getSelectedEmail(id);
			this.sendSuccessMsg(null, strEmail);
		}
	}

	@Override
	public String hrefAddOrUpdate() {
		this.initData();
		if (entity != null && StringUtils.isNotBlank(entity.getId())) {
			entity = baseSrv.find(entity.getId());
			if (StringUtils.isNotBlank(entity.getAlumniId())) {
				alumni = alumniSrv.find(entity.getAlumniId());
				if (alumni != null && alumni.getCollege() != null) {
					dicSpecialtyList = alumniSrv.findAllCollegeSpecialty(alumni.getCollege());
				}
				entity.setAlumni(alumni);
			}
		}
		return "toAddOrUpdate";
	}

	@Override
	public void update() {
		CommonResult result = new CommonResult(CommonResult.FAIL);
		if (entity.getAlumni() != null) {
			entity.getAlumni().setLastUpdate(new Date());

			BaseAlumni oldEntity = this.alumniSrv.find(entity.getAlumniId());
			if (oldEntity == null) {
				result.setInfo("所更新的对象不存在");
			} else {
				BeanUtils.copyProperties(entity.getAlumni(), oldEntity, "id", "createTime");
				this.alumniSrv.update(oldEntity);
				result.setInfo(CommonResult.SUCCESS_INFO);
				result.setSuccess(CommonResult.SUCCESS);
			}
		}
		this.sendResponseMsg(result);
	}

	private void initData() {
		dicPoliticalStatusList = dicCommonSrv.findAll(DicPoliticalStatus.class);
		dicCollegeList = dicCommonSrv.findAll(DicCollege.class);
		if (dicCollegeList != null && dicCollegeList.size() > 0) {
			dicSpecialtyList = alumniSrv.findAllCollegeSpecialty(dicCollegeList.get(0).getId());
		}
		dicDegreeList = dicCommonSrv.findAll(DicDegree.class);
		dicIndustryList = dicCommonSrv.findAll(DicIndustry.class);
		dicAlumniClubIdentityList = dicCommonSrv.findAll(DicAlumniClubIdentity.class);
		dicAlumniBranchIdentityList = dicCommonSrv.findAll(DicAlumniBranchIdentity.class);
		dicAlumniIdentityList = dicCommonSrv.findAll(DicAlumniIdentity.class);
	}

	public void findSepcialtyList() {
		dicSpecialtyList = alumniSrv.findAllCollegeSpecialty(Integer.parseInt(id));
		sendSuccessMsg(dicSpecialtyList, "");
	}

	public List<DicPoliticalStatus> getDicPoliticalStatusList() {
		return dicPoliticalStatusList;
	}

	public void setDicPoliticalStatusList(List<DicPoliticalStatus> dicPoliticalStatusList) {
		this.dicPoliticalStatusList = dicPoliticalStatusList;
	}

	public List<DicCollege> getDicCollegeList() {
		return dicCollegeList;
	}

	public void setDicCollegeList(List<DicCollege> dicCollegeList) {
		this.dicCollegeList = dicCollegeList;
	}

	public List<DicDegree> getDicDegreeList() {
		return dicDegreeList;
	}

	public void setDicDegreeList(List<DicDegree> dicDegreeList) {
		this.dicDegreeList = dicDegreeList;
	}

	public List<DicIndustry> getDicIndustryList() {
		return dicIndustryList;
	}

	public void setDicIndustryList(List<DicIndustry> dicIndustryList) {
		this.dicIndustryList = dicIndustryList;
	}

	public List<DicAlumniClubIdentity> getDicAlumniClubIdentityList() {
		return dicAlumniClubIdentityList;
	}

	public void setDicAlumniClubIdentityList(List<DicAlumniClubIdentity> dicAlumniClubIdentityList) {
		this.dicAlumniClubIdentityList = dicAlumniClubIdentityList;
	}

	public List<DicAlumniBranchIdentity> getDicAlumniBranchIdentityList() {
		return dicAlumniBranchIdentityList;
	}

	public void setDicAlumniBranchIdentityList(List<DicAlumniBranchIdentity> dicAlumniBranchIdentityList) {
		this.dicAlumniBranchIdentityList = dicAlumniBranchIdentityList;
	}

	public List<DicAlumniIdentity> getDicAlumniIdentityList() {
		return dicAlumniIdentityList;
	}

	public void setDicAlumniIdentityList(List<DicAlumniIdentity> dicAlumniIdentityList) {
		this.dicAlumniIdentityList = dicAlumniIdentityList;
	}

	public List<DicSpecialty> getDicSpecialtyList() {
		return dicSpecialtyList;
	}

	public void setDicSpecialtyList(List<DicSpecialty> dicSpecialtyList) {
		this.dicSpecialtyList = dicSpecialtyList;
	}

	public BaseAlumni getAlumni() {
		return alumni;
	}

	public void setAlumni(BaseAlumni alumni) {
		this.alumni = alumni;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}
