package com.wisdombud.alumni.manage.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.common.EmailSrv;
import com.wisdombud.alumni.dao.manage.BaseAlumniClubDao;
import com.wisdombud.alumni.dao.manage.BaseBranchRelationDao;
import com.wisdombud.alumni.enums.AlumniBranchIdentityEnum;
import com.wisdombud.alumni.manage.BaseAlumniBranchStaffSrv;
import com.wisdombud.alumni.manage.BaseAlumniClubSrv;
import com.wisdombud.alumni.pojo.base.DicAlumniBranchType;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranch;
import com.wisdombud.alumni.pojo.manage.BaseAlumniBranchStaff;
import com.wisdombud.alumni.pojo.manage.BaseBranchRelation;
import com.wisdombud.alumni.threadlocal.UserSession;
import com.wisdombud.alumni.util.BeanUtils;
import com.wisdombud.alumni.util.ExcelImportUtil;
import com.wisdombud.alumni.util.User;
import com.wisdombud.alumni.vo.AlumniBranchVo;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友分会表Srv. <br/>
 * 
 * @author zxguan
 */
@Service(value = "baseAlumniClubSrv")
public class BaseAlumniClubSrvImpl extends BaseSrvImpl<BaseAlumniBranch> implements BaseAlumniClubSrv {

	@Autowired
	private DicCommonSrv dicSrv;
	@Autowired
	private BaseAlumniBranchStaffSrv staffSrv;
	@Autowired
	private EmailSrv emailSrv;
	@Autowired
	private BaseAlumniClubDao dao;
	@Autowired
	private BaseBranchRelationDao memberDao;

	public BaseAlumniClubSrvImpl() {
	}

	@Autowired
	public BaseAlumniClubSrvImpl(
			@Qualifier(value = "baseAlumniClubDao") CommonDao<BaseAlumniBranch, String> commonDao) {
		super(commonDao);
	}

	@Override
	public String fillTypeStr(String type) {
		String typeStr = null;
		if (StringUtils.isNotBlank(type)) {
			List<DicAlumniBranchType> lists = dicSrv.findAll(DicAlumniBranchType.class);
			for (DicAlumniBranchType item : lists) {
				if ((item.id).equals(type)) {
					typeStr = item.getValue();
					break;
				}
			}
		}
		return typeStr;
	}

	@Override
	public void pageVo(PageEntity<AlumniBranchVo> pageBranchVo, Map<String, Param> params, List<Order> orders) {
		PageEntity<BaseAlumniBranch> pageEntity = new PageEntity<>(pageBranchVo.getStart(), pageBranchVo.getPageSize());
		super.page(pageEntity, params, orders);
		this.fillVo(pageBranchVo, pageEntity);
	}

	private void fillVo(PageEntity<AlumniBranchVo> pageVo, PageEntity<BaseAlumniBranch> pageEntity) {
		List<BaseAlumniBranch> branchList = pageEntity.getResults();
		List<AlumniBranchVo> voList = Lists.newArrayList();
		for (BaseAlumniBranch branch : branchList) {
			AlumniBranchVo vo = new AlumniBranchVo();
			vo.setId(branch.getId());
			vo.setName(branch.getName());
			vo.setWechat(branch.getWechatId());
			vo.setEmail(branch.getEmail());
			vo.setAddress(branch.getAddress());
			this.fillStaff(vo, branch.getStaffList());
			List<BaseBranchRelation> a=	branch.getMemberList();
			vo.setMemberNum(a.size());
			voList.add(vo);
		}
		pageVo.setResults(voList);
		pageVo.setCurrentPage(pageEntity.getCurrentPage());
		pageVo.setCurrentPageLength(pageEntity.getCurrentPageLength());
		pageVo.setPageSize(pageEntity.getPageSize());
		pageVo.setStart(pageEntity.getStart());
		pageVo.setTotalPages(pageEntity.getTotalPages());
		pageVo.setTotalResults(pageEntity.getTotalResults());
	}

	private void fillStaff(AlumniBranchVo vo, List<BaseAlumniBranchStaff> staffList) {
		for (BaseAlumniBranchStaff staff : staffList) {
			if (String.valueOf(AlumniBranchIdentityEnum.HUIZHANG.getValue()).equals(staff.getStaff())) {
				vo.setHuizhang(staff.getName());
				break;
			}
		}
	}

	@Override
	public void findMemberByBranch(PageEntity<BaseBranchRelation> pageMenber, Map<String, Param> params) {
		memberDao.pageByHql(pageMenber, params, new ArrayList<Order>());
		for (BaseBranchRelation relation : pageMenber.getResults()) {
			BaseAlumni alumni = relation.getAlumni();
			if (null != alumni) {
				DicCollege college = dicSrv.findById(DicCollege.class, alumni.getCollege());
				alumni.setCollegeName(college.getCnName());
			}
		}
	}

	@Override
	public void addOrUpdate(BaseAlumniBranch entity, List<BaseAlumniBranchStaff> staffList, String type) {
		if (null != entity && StringUtils.isBlank(entity.id)) {
			entity.setCreateTime(new Date());
			this.save(entity);
		} else {
			entity.setLastUpdate(new Date());
			BaseAlumniBranch oldEntity = this.find(entity.id);
			BeanUtils.copyProperties(entity, oldEntity, "id", "createTime");
			this.update(oldEntity);
			staffSrv.deleteBy("branchId", entity.getId());
		}
		for (BaseAlumniBranchStaff staff : staffList) {
			staff.setBranchId(entity.getId());
			staffSrv.save(staff);
		}
	}

	@Override
	public void deleteAllById(String id) {
		super.deleteById(id);
	}

	@Override
	public String getSelectedEmail(String ids) {
		String strEmail = "";
		if (StringUtils.isNotBlank(ids)) {
			for (String id : ids.split(",")) {
				if (StringUtils.isNotBlank(id)) {
					BaseAlumniBranch entity = super.find(id);
					if (null != entity && StringUtils.isNotBlank(entity.getEmail())) {
						strEmail += entity.getEmail() + ";";
					}
				}
			}
		}
		return strEmail;
	}

	@Override
	public void sendEmails(String title, String email, String replyContent) {
		List<String> emailAddress = Arrays.asList(email.split(";"));
		if (null != emailAddress && emailAddress.size() > 0) {
			emailSrv.sendMail(title, emailAddress, replyContent);
		}
	}

	@Override
	public void importExcel(File file, String extention) {
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			List<Map<String, Object>> excelData = null;
			if (extention.equals(".xls")) {
				HSSFWorkbook workbook = new HSSFWorkbook(in);
				excelData = ExcelImportUtil.read2007Excel(workbook);
			} else if (extention.equals(".xlsx")) {
				XSSFWorkbook workbook = new XSSFWorkbook(in);
				excelData = ExcelImportUtil.readExcel(workbook);
			}
			ExcelImportUtil.toObjectList(excelData, User.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pageMyBranchVo(PageEntity<AlumniBranchVo> pageBranchVo, UserSession session) {
		PageEntity<BaseBranchRelation> pageEntity = new PageEntity<>(pageBranchVo.getStart(),
				pageBranchVo.getPageSize());
		memberDao.pageByHql(pageEntity, this.buildParams(session.getId()), new ArrayList<Order>());
		List<BaseBranchRelation> relationList = pageEntity.getResults();
		List<AlumniBranchVo> voList = Lists.newArrayList();
		for (BaseBranchRelation relation : relationList) {
			BaseAlumniBranch branch = super.find(relation.getBranchId());
			AlumniBranchVo vo = new AlumniBranchVo();
			vo.setId(branch.getId());
			vo.setName(branch.getName());
			vo.setWechat(branch.getWechatId());
			vo.setEmail(branch.getEmail());
			vo.setAddress(branch.getAddress());
			this.fillStaff(vo, branch.getStaffList());
			vo.setMemberNum(branch.getMemberList().size());
			voList.add(vo);
		}
		pageBranchVo.setResults(voList);
		pageBranchVo.setCurrentPage(pageEntity.getCurrentPage());
		pageBranchVo.setCurrentPageLength(pageEntity.getCurrentPageLength());
		pageBranchVo.setPageSize(pageEntity.getPageSize());
		pageBranchVo.setStart(pageEntity.getStart());
		pageBranchVo.setTotalPages(pageEntity.getTotalPages());
		pageBranchVo.setTotalResults(pageEntity.getTotalResults());
	}

	private Map<String, Param> buildParams(String userId) {
		Map<String, Param> params = Maps.newHashMap();
		if (StringUtils.isNotBlank(userId)) {
			params.put("alumniId", Param.eq(userId));
		}
		return params;
	}

	@Override
	public List<BaseAlumniBranch> findIdListNotJoinBy(Map<String, Param> buildParams, UserSession userSession) {
		List<BaseAlumniBranch> branchList = Lists.newArrayList();
		List<String> idList = dao.findNotJoinBy(buildParams, new ArrayList<Order>(), userSession.getId());
		for (String id : idList) {
			branchList.add(this.find(id));
		}
		return branchList;
	}

}