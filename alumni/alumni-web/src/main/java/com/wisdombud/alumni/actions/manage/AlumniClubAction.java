package com.wisdombud.alumni.actions.manage;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
import com.wisdombud.alumni.constants.Constants;
import com.wisdombud.alumni.manage.BaseAlumniBranchStaffSrv;
import com.wisdombud.alumni.manage.BaseAlumniClubSrv;
import com.wisdombud.alumni.manage.BaseBranchRelationSrv;
import com.wisdombud.alumni.pojo.dic.DicAlumniBranchIdentity;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranch;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchStaff;
import com.wisdombud.alumni.pojo.manage.BaseBranchRelation;
import com.wisdombud.alumni.util.GsonUtil;
import com.wisdombud.alumni.vo.AlumniBranchVo;
import com.wisdombud.alumni.vo.CommonResult;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;

/**
 * 功能: 校友分会表<br/>
 * date: 2017-3-28 19:28:27 <br/>
 *
 * @author zxguan
 * @version
 * @since JDK 1.8
 */
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace(value = "/")
@Results({ @Result(name = "toAddOrUpdate", location = "/WEB-INF/jsp/alumni-club-manage/create.jsp"),
		   @Result(name = "toDetail", location = "/WEB-INF/jsp/alumni-club-manage/detail.jsp"),
		   @Result(name = "toPage", location = "/WEB-INF/jsp/alumni-club-manage/page.jsp"),
		   @Result(name = "toMember", location = "/WEB-INF/jsp/alumni-club-manage/member.jsp") })
public class AlumniClubAction extends AbstractCrudAction<BaseAlumniBranch> {

	private static final long			   serialVersionUID	= 1L;

	@Autowired
	private DicCommonSrv				   dicSrv;
	@Autowired
	private BaseAlumniClubSrv			   srv;
	@Autowired
	private BaseAlumniBranchStaffSrv	   staffSrv;
	@Autowired
	private BaseBranchRelationSrv		   memberSrv;

	private String						   type;
	private String						   typeStr;

	private PageEntity<AlumniBranchVo>	   pageBranchVo;
	private PageEntity<BaseBranchRelation> pageMenber;
	private List<DicAlumniBranchIdentity>  identityList;
	private List<BaseAlumniBranchStaff>	   staffList;
	public String						   title;
	public String						   email;
	public String						   replyContent;
	private List<File>					   upload;				 // 得到上传的文件
	private List<String>				   uploadFileName;		 // 得到文件的名称
	private List<BaseAlumniBranch>		   branchList;
	private String						   chapterStr;
	private String						   collegeStr;
	private String						   overseaStr;
	private String						   industryStr;
	private String						   name;
	private String						   huizhang;
	private String						   address;

	public AlumniClubAction(@Qualifier(value = "baseAlumniClubSrv") IBaseSrv<BaseAlumniBranch> baseSrv) {
		super(baseSrv);
	}

	@Override
	public String hrefPage() {
		this.setTypeStr(srv.fillTypeStr(type));
		return super.hrefPage();
	}

	@Override
	public void page() {
		if (this.isAjaxRequest()) {
			this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
			pageBranchVo = new PageEntity<>(start, limit);
			srv.pageVo(pageBranchVo, this.buildParams(), this.buildOrder());
			sendResponseMsg(pageBranchVo);
		}
	}
	
	@Override
	protected List<Order> buildOrder() {
		List<Order> oList=Lists.newArrayList();
		oList.add(Order.desc("createTime"));
		return oList;
	}

	@Override
	public String hrefAddOrUpdate() {
		this.setTypeStr(srv.fillTypeStr(type));
		if (StringUtils.isNotBlank(id)) {
			entity = srv.find(id);
		}
		return super.hrefAddOrUpdate();
	}

	public void findIdentity() {
		if (this.isAjaxRequest()) {
			identityList = dicSrv.findAll(DicAlumniBranchIdentity.class);
			sendResponseMsg(identityList);
		}
	}

	@Override
	public void addOrUpdate() {
		if (isAjaxRequest()) {
			List<BaseAlumniBranchStaff> list = GsonUtil.jsonToArrayList(jsonListEntity, BaseAlumniBranchStaff.class);
			srv.addOrUpdate(entity, list, type);
			sendSuccessMsg();
		}
	}

	@Override
	public String hrefDetail() {
		this.setTypeStr(srv.fillTypeStr(type));
		staffList = staffSrv.findLeaders(this.buildMemberOrDetailParams(), super.buildOrder());
		return super.hrefDetail();
	}

	public String hrefMember() {
		this.setTypeStr(srv.fillTypeStr(type));
		return "toMember";
	}

	public void pageMember() {
		if (isAjaxRequest() && StringUtils.isNotBlank(id)) {
			this.limit = this.limit == 0 ? Constants.DEFUALT_PAGESIZE : this.limit;
			pageMenber = new PageEntity<>(start, limit);
			srv.findMemberByBranch(pageMenber, this.buildMemberOrDetailParams());
			sendResponseMsg(pageMenber);
		}
	}

	@Override
	public void delete() {
		if (isAjaxRequest() && StringUtils.isNotBlank(this.id)) {
			srv.deleteAllById(this.id);
			CommonResult result = new CommonResult(CommonResult.SUCCESS);
			this.sendResponseMsg(result);
		}
	}

	public void forEmail() {
		if (StringUtils.isNotEmpty(id)) {
			String strEmail = srv.getSelectedEmail(id);
			this.sendSuccessMsg(null, strEmail);
		}
	}

	public void sendMail() {
		if (StringUtils.isNotBlank(email)) {
			srv.sendEmails(title, email, replyContent);
			this.sendSuccessMsg();
		} else {
			this.sendFailMsg(email, "sendMail failed!");
		}
	}

	public void importFile() {
		if (CollectionUtils.isNotEmpty(uploadFileName)) {
			String fileName = uploadFileName.get(0);
			String extention = fileName.substring(fileName.lastIndexOf("."));
			if (fileName.indexOf(extention) > -1 && (extention.equals(".xls") || extention.equals(".xlsx"))) {
				srv.importExcel(upload.get(0), extention);
				sendSuccessMsg("", "导入成功！");
			} else {
				this.sendFailMsg("", "不支持上传的文件类型");
			}
		} else {
			this.sendFailMsg("", "上传的文件为空");
		}
	}

	public void findBranchByType() {
		if (StringUtils.isNotBlank(type)) {
			branchList = srv.findIdListNotJoinBy(this.buildParams(), getUserSession());
			if (isAjaxRequest()) {
				sendResponseMsg(branchList);
			}
		}
	}

	public void joinInBranch() {
		if (StringUtils.isNotBlank(chapterStr) || StringUtils.isNotBlank(collegeStr)
			|| StringUtils.isNotBlank(overseaStr) || StringUtils.isNotBlank(industryStr)) {
			memberSrv.addJoinInBranchApply(chapterStr, collegeStr, overseaStr, industryStr, getUserSession());
			sendSuccessMsg();
		}
	}

	@Override
	protected Map<String, Param> buildParams() {
		Map<String, Param> params = Maps.newHashMap();
		if (StringUtils.isNotBlank(type)) {
			params.put("type", Param.eq(Integer.valueOf(type)));
		}
		if (StringUtils.isNotBlank(name)) {
			params.put("name", Param.like(name));
		}
		if (StringUtils.isNotBlank(address)) {
			params.put("address", Param.like(address));
		}

		return params;
	}

	private Map<String, Param> buildMemberOrDetailParams() {
		Map<String, Param> params = Maps.newHashMap();
		if (StringUtils.isNotBlank(id)) {
			params.put("branchId", Param.eq(id));
		}
		return params;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public PageEntity<AlumniBranchVo> getPageBranchVo() {
		return pageBranchVo;
	}

	public void setPageBranchVo(PageEntity<AlumniBranchVo> pageBranchVo) {
		this.pageBranchVo = pageBranchVo;
	}

	public PageEntity<BaseBranchRelation> getPageMenber() {
		return pageMenber;
	}

	public void setPageMenber(PageEntity<BaseBranchRelation> pageMenber) {
		this.pageMenber = pageMenber;
	}

	public List<DicAlumniBranchIdentity> getIdentityList() {
		return identityList;
	}

	public void setIdentityList(List<DicAlumniBranchIdentity> identityList) {
		this.identityList = identityList;
	}

	public List<BaseAlumniBranchStaff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<BaseAlumniBranchStaff> staffList) {
		this.staffList = staffList;
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

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<BaseAlumniBranch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<BaseAlumniBranch> branchList) {
		this.branchList = branchList;
	}

	public String getChapterStr() {
		return chapterStr;
	}

	public void setChapterStr(String chapterStr) {
		this.chapterStr = chapterStr;
	}

	public String getCollegeStr() {
		return collegeStr;
	}

	public void setCollegeStr(String collegeStr) {
		this.collegeStr = collegeStr;
	}

	public String getOverseaStr() {
		return overseaStr;
	}

	public void setOverseaStr(String overseaStr) {
		this.overseaStr = overseaStr;
	}

	public String getIndustryStr() {
		return industryStr;
	}

	public void setIndustryStr(String industryStr) {
		this.industryStr = industryStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHuizhang() {
		return huizhang;
	}

	public void setHuizhang(String huizhang) {
		this.huizhang = huizhang;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
