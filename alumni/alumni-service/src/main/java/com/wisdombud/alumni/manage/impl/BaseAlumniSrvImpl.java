package com.wisdombud.alumni.manage.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.dao.manage.BaseAlumniDao;
import com.wisdombud.alumni.dao.manage.BaseRemindDao;
import com.wisdombud.alumni.enums.AlumniIdentityEnum;
import com.wisdombud.alumni.enums.GenderEnum;
import com.wisdombud.alumni.enums.IdentityEnum;
import com.wisdombud.alumni.enums.PoliticalStatusEnum;
import com.wisdombud.alumni.manage.BaseAlumniSrv;
import com.wisdombud.alumni.manage.BaseBranchRelationSrv;
import com.wisdombud.alumni.manage.BaseIdentityRelationSrv;
import com.wisdombud.alumni.manage.BaseTimelineSrv;
import com.wisdombud.alumni.manage.ExcelXiaoYouService;
import com.wisdombud.alumni.pojo.dic.DicAlumniBranchIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniClubIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniIdentity;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.dic.DicDegree;
import com.wisdombud.alumni.pojo.dic.DicIndustry;
import com.wisdombud.alumni.pojo.dic.DicNational;
import com.wisdombud.alumni.pojo.dic.DicPoliticalStatus;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;
import com.wisdombud.alumni.vo.Param;
import com.wisdombud.alumni.vo.RemindVo;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

/**
 * 校友信息表Srv. <br/>
 *
 * @author Administrator
 *
 */
@Service(value = "baseAlumniSrv")
public class BaseAlumniSrvImpl extends BaseSrvImpl<BaseAlumni> implements BaseAlumniSrv {

	private static final Logger LOGGER = Logger.getLogger(BaseAlumniSrvImpl.class);

	@Autowired
	public DicCommonSrv dicCommonSrv;
	@Autowired
	public BaseIdentityRelationSrv identityRelationSrv;
	@Autowired
	private BaseRemindDao baseRemindDao;
	@Autowired
	private BaseAlumniDao baseAlumniDao;
	@Autowired
	private BaseTimelineSrv timelineSrv;
	@Autowired
	private ExcelXiaoYouService excelSrv;
	@Autowired
	private BaseBranchRelationSrv branchRelationSrv;

	public BaseAlumniSrvImpl() {
	}

	@Autowired
	public BaseAlumniSrvImpl(@Qualifier(value = "baseAlumniDao") CommonDao<BaseAlumni, String> commonDao) {
		super(commonDao);
	}



	public void fillName(List<BaseAlumni> list) {
		for (BaseAlumni inst : list) {
			fillName(inst);
		}
	}

	public void fillName(BaseAlumni entity) {

		if (StringUtils.isNotBlank(entity.getReVarchar1())) {
			entity.setReVarchar1(entity.getReVarchar1().replace(".0", ""));
		}
		if (StringUtils.isNotBlank(entity.getClassName())) {
			entity.setClassName(entity.getClassName().replace(".0", ""));
		}
		if (StringUtils.isNotBlank(entity.getReVarchar2())) {
			entity.setReVarchar2(entity.getReVarchar2().replace(".0", ""));
		}
		if (entity.getCollege() != null) {
			entity.setCollegeName(dicCommonSrv.findById(DicCollege.class, entity.getCollege()).getCnName());
		}
		if (entity.getIdentity() != null) {
			entity.setIdentityName(IdentityEnum.valueByIndex(entity.getIdentity()).getName());
		}
		if (entity.getGender() != null) {
			entity.setGenderName(GenderEnum.valueByIndex(entity.getGender()).getName());
		}
		if (entity.getPoliticalStatus() != null) {
			String name = "群众";
			if (entity.getPoliticalStatus() == 1 || entity.getPoliticalStatus() == 2
					|| entity.getPoliticalStatus() == 3) {
				name = PoliticalStatusEnum.valueByIndex(entity.getPoliticalStatus()).getName();
			}
			entity.setPoliticalStatusName(name);
		}
		if (entity.getMajor() != null) {
			DicSpecialty dic = dicCommonSrv.findById(DicSpecialty.class, entity.getMajor());
			entity.setMagorName(dic.getCnName());
		}
		if (entity.getHighestEducation() != null) {
			entity.setHighestEducationName(
					dicCommonSrv.findById(DicDegree.class, entity.getHighestEducation()).getCnName());
		}
		if (entity.getIndustry() != null) {
			entity.setIndustryName(dicCommonSrv.findById(DicIndustry.class, entity.getIndustry()).getValue());
		}
		// 民族
		if (StringUtils.isNotBlank(entity.getReVarchar0())) {
			if (StringUtils.isNumeric(entity.getReVarchar0())) {
				String val = dicCommonSrv.findById(DicNational.class, new Integer(entity.getReVarchar0())).getValue();
				entity.setNationalStr(val);
			}
		}
		//毕业年份：格式化YYYY
		if (StringUtils.isNotBlank(entity.getReVarchar1())) {
			String year = entity.getReVarchar1();
			if (year.contains(".")) {
				entity.setReVarchar1(year.substring(0, year.indexOf(".")));
			}
		}
	}

	private void fillName(BaseAlumni entity, BaseIdentityRelation relationEntity) {
		if (relationEntity.getAlumniClubIdentityId() != null) {
			String val = "";
			String[] strs = relationEntity.getAlumniClubIdentityId().split(",");
			for (String str : strs) {
				if (StringUtils.isNotBlank(str)) {
					DicAlumniClubIdentity dic = dicCommonSrv.findById(DicAlumniClubIdentity.class, new Integer(str.trim()));
					if (dic != null) {
						val = val + dic.getValue() + ",";
					}
				}
			}
			entity.setAlumniClubIdentityName(val);
		}
		if (relationEntity.getBranchClubIdentityId() != null) {
			String val = "";
			String[] strs = relationEntity.getBranchClubIdentityId().split(",");
			for (String str : strs) {
				if (StringUtils.isNotBlank(str)) {
					DicAlumniBranchIdentity dic = dicCommonSrv.findById(DicAlumniBranchIdentity.class, new Integer(str.trim()));
					if (dic != null) {
						val = val + dic.getValue() + ",";
					}
				}
			}
			entity.setBranchClubIdentityName(val);
		}
		if (relationEntity.getAlumniIdentityId() != null) {
			String val = "";
			String[] strs = relationEntity.getAlumniIdentityId().split(",");
			for (String str : strs) {
				if (StringUtils.isNumeric(str)) {
					DicAlumniIdentity dic = dicCommonSrv.findById(DicAlumniIdentity.class, new Integer(str.trim()));
					val = val + (dic != null ? dic.getValue() : "") + ",";
				}
			}
			entity.setAlumniIdentityName(val);
		}
	}

	@Override
	public void page(PageEntity<BaseAlumni> pageEntity, Map<String, Param> params, List<Order> orders) {
		baseAlumniDao.page(pageEntity, params, orders);
		List<BaseAlumni> list = pageEntity.getResults();
		this.fillName(list);
	}

	@Override
	public BaseAlumni find(String id) {
		BaseAlumni entity = super.find(id);
		if (entity == null) {
			entity = new BaseAlumni();
			return entity;
		}
		this.fillName(entity);
		List<BaseIdentityRelation> relationEntity = identityRelationSrv.findBy("alumniId", id);
		if (relationEntity != null && relationEntity.size() > 0) {
			this.fillName(entity, relationEntity.get(0));
		}
		return entity;
	}

	private BaseIdentityRelation data2Entity(BaseAlumni entity) {
		BaseIdentityRelation relation = new BaseIdentityRelation();
		if (StringUtils.isNotBlank(entity.getId())) {
			relation.setAlumniId(entity.getId());
		}
		if (StringUtils.isNotBlank(entity.getAlumniClubIdentityName())) {
			relation.setAlumniClubIdentityId(entity.getAlumniClubIdentityName().replace(" ", ""));
		}
		if (StringUtils.isNotBlank(entity.getAlumniIdentityName())) {
			relation.setAlumniIdentityId(entity.getAlumniIdentityName().replace(" ", ""));
		}
		if (StringUtils.isNotBlank(entity.getBranchClubIdentityName())) {
			relation.setBranchClubIdentityId(entity.getBranchClubIdentityName().replace(" ", ""));
		}
		return relation;
	}

	@Override
	public String save(BaseAlumni entity) {
		String str = super.save(entity);
		if (StringUtils.isNotBlank(entity.getId())) {
			BaseIdentityRelation relation = this.data2Entity(entity);
			relation.setCreateTime(new Date());
			relation.setLastUpdate(new Date());
			str = identityRelationSrv.save(relation);
		}

		return str;
	}

	@Override
	public void update(BaseAlumni entity) {
		super.update(entity);
		if (StringUtils.isNotBlank(entity.getId())) {
			BaseIdentityRelation relation = this.data2Entity(entity);
			relation.setLastUpdate(new Date());
			identityRelationSrv.deleteBy("alumniId", entity.getId());
			identityRelationSrv.save(relation);
		}
	}

	@Override
	public void deleteByIds(String ids) {
		super.deleteByIds(ids);
		String[] strs = ids.split(",");
		for (int i = 0; i < strs.length; i++) {
			if (StringUtils.isNotBlank(strs[i])) {
				identityRelationSrv.deleteBy("alumniId", strs[i]);
				branchRelationSrv.deleteBy("alumniId", strs[i]);
			}
		}
	}

	@Override
	public String getSelectedEmail(String ids) {
		String strEmail = "";
		if (StringUtils.isNotBlank(ids)) {
			for (String str : ids.split(",")) {
				if (StringUtils.isNotBlank(str)) {
					BaseAlumni entity = this.find(str);
					if (entity != null && StringUtils.isNotBlank(entity.getEmail())) {
						strEmail += entity.getEmail() + ";";
					}
				}
			}
		}
		return strEmail;
	}

	@Override
	public List<String> string2List(String strs) {
		List<String> strList = Lists.newArrayList();
		if (StringUtils.isNotBlank(strs)) {
			for (String str : strs.split(";")) {
				if (StringUtils.isNotBlank(str)) {
					strList.add(str);
				}
			}
		}
		return strList;
	}

	@Override
	public void updateBecomeLiaison(String ids) {
		for (String id : ids.split(";")) {
			if (StringUtils.isNotBlank(id)) {
				List<BaseIdentityRelation> relation = identityRelationSrv.findBy("alumniId", id);
				if (relation != null && relation.size() > 0) {
					if (StringUtils.isNotBlank(relation.get(0).getAlumniIdentityId())) {
						if (!relation.get(0).getAlumniIdentityId()
								.contains(String.valueOf(AlumniIdentityEnum.ALUMNI_LIAISON.getValue()))) {
							String str = relation.get(0).getAlumniIdentityId()
									+ AlumniIdentityEnum.ALUMNI_LIAISON.getValue() + ",";
							relation.get(0).setAlumniIdentityId(str);
						}
					}
				}

			}
		}

	}

	@Override
	public List<DicSpecialty> findAllCollegeSpecialty(Integer collegeId) {
		List<DicSpecialty> speialtyList = Lists.newArrayList();
		speialtyList = dicCommonSrv.findAllCollegeSpecialty(collegeId);
		return speialtyList;
	}

	@Override
	public void pageRemind(PageEntity<RemindVo> page, Integer beforeDay, String key) {
		baseRemindDao.page(page, beforeDay, key);
	}

	@Override
	public void createExcelWorkBookInfo(HttpServletResponse response, List<BaseAlumni> results, String exportFields) {
		String nowStr = new Date().getTime() + "";
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			response.reset();
			response.setHeader("content-disposition",
					"attachment;filename=" + new String(("校友信息" + nowStr).getBytes("gb2312"), "ISO8859-1") + ".xls");
			response.setContentType("APPLICATION/msexcel");
			HSSFWorkbook workbook = new HSSFWorkbook();
			excelSrv.export(results, exportFields, workbook);
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 强行将响应缓存中的内容发送到目的地
				response.flushBuffer();
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}

	public Map<String, String> getFieldValue(BaseAlumni now, BaseAlumni old) {
		Map<String, String> params = Maps.newHashMap();
		Field[] nowFields = now.getClass().getDeclaredFields();
		Field[] oldFields = old.getClass().getDeclaredFields();
		try {
			for (int i = 1; i < nowFields.length; i++) {
				if (nowFields[i].getName().equals(oldFields[i].getName())) {
					String type = nowFields[i].getGenericType().toString();
					Method nowMethod = getMethod(now, nowFields[i]);
					Method oldMethod = getMethod(old, oldFields[i]);
					if (nowFields[i].getName().equals("label")) {
					}
					if (nowMethod == null && oldMethod == null) {
						continue;
					}
					if (type.equals("class java.lang.String")) {
						String newVal = (String) nowMethod.invoke(now);
						String oldVal = (String) oldMethod.invoke(old);
						if (StringUtils.isNotBlank(newVal) && (!newVal.equals(oldVal))) {
							params.put(nowFields[i].getName(), newVal);
						}
					} else if (type.equals("class java.lang.Integer")) {
						Integer newVal = (Integer) nowMethod.invoke(now);
						Integer oldVal = (Integer) oldMethod.invoke(old);
						if (newVal != null && (!newVal.equals(oldVal))) {
							params.put(nowFields[i].getName(), newVal.toString());
						}
					} else if (type.equals("class java.lang.Boolean")) {
						Boolean newVal = (Boolean) nowMethod.invoke(now);
						Boolean oldVal = (Boolean) oldMethod.invoke(old);
						if (newVal != null && (!newVal.equals(oldVal))) {
							params.put(nowFields[i].getName(), newVal.toString());
						}
					} else if (type.equals("class java.util.Date")) {
						Date newVal = (Date) nowMethod.invoke(now);
						Date oldVal = (Date) oldMethod.invoke(old);
						if (newVal != null && (!newVal.equals(oldVal))) {
							params.put(nowFields[i].getName(), (new SimpleDateFormat("yyyy-MM-dd")).format(newVal));
						}
					} else if (type.equals("class java.lang.Double")) {
						Double newVal = (Double) nowMethod.invoke(now);
						Double oldVal = (Double) oldMethod.invoke(old);
						if (newVal != null && (!newVal.equals(oldVal))) {
							params.put(nowFields[i].getName(), newVal.toString());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

	public String GetVal(Map<String, String> map) {
		List<String> list = Lists.newArrayList();
		for (Entry<String, String> entry : map.entrySet()) {
			switch (entry.getKey()) {
			case "name":
				list.add("姓名修改为" + entry.getValue());
				break;
			case "gender":
				String str = GenderEnum.valueByIndex(Integer.parseInt(entry.getValue())).getName();
				list.add("性别修改为" + str);
				break;
			case "identity":
				String str2 = IdentityEnum.valueByIndex(Integer.parseInt(entry.getValue())).getName();
				list.add("身份修改为" + str2);
				break;
			case "code":
				list.add("学号/职工号修改为" + entry.getValue());
				break;
			case "birthDate":
				list.add("出生日期修改为" + entry.getValue());
				break;
			case "enrollYear":
				list.add("入学年份/入职年份修改为" + entry.getValue());
				break;
			case "college":
				DicCollege college = dicCommonSrv.findById(DicCollege.class, Integer.parseInt(entry.getValue()));
				if (college != null) {
					list.add("院系修改为" + college.getCnName());
				}
				break;
			case "major":
				DicSpecialty specialty = dicCommonSrv.findById(DicSpecialty.class, Integer.parseInt(entry.getValue()));
				if (specialty != null) {
					list.add("专业修改为" + specialty.getCnName());
				}
				break;
			case "nativeStr":
				list.add("籍贯修改为" + entry.getValue());
				break;
			case "politicalStatus":
				DicPoliticalStatus politicalStatus = dicCommonSrv.findById(DicPoliticalStatus.class,
						Integer.parseInt(entry.getValue()));
				if (politicalStatus != null) {
					list.add("政治面貌修改为" + politicalStatus.getValue());
				}
				break;
			case "wechatId":
				list.add("微信修改为" + entry.getValue());
				break;
			case "wechatName":
				list.add("微信昵称修改为" + entry.getValue());
				break;
			case "qq":
				list.add("QQ修改为" + entry.getValue());
				break;
			case "phone":
				list.add("手机修改为" + entry.getValue());
				break;
			case "address":
				list.add("永久通讯地址修改为" + entry.getValue());
				break;
			case "email":
				list.add("邮箱修改为" + entry.getValue());
				break;
			case "highestEducation":
				DicDegree degree = dicCommonSrv.findById(DicDegree.class, Integer.parseInt(entry.getValue()));
				if (degree != null) {
					list.add("最高学历修改为" + degree.getCnName());
				}
				break;
			case "className":
				list.add("班级名称修改为" + entry.getValue());
				break;
			case "teacher":
				list.add("辅导员/导师修改为" + entry.getValue());
				break;
			case "industry":
				DicIndustry entity = dicCommonSrv.findById(DicIndustry.class, Integer.parseInt(entry.getValue()));
				if (entity != null) {
					list.add("行业修改为" + entity.getValue());
				}
				break;
			case "company":
				list.add("所在单位修改为" + entry.getValue());
				break;
			case "companyCityStr":
				list.add("单位所在省/市修改为" + entry.getValue());
				break;
			case "companyAddress":
				list.add("单位地址修改为" + entry.getValue());
				break;
			case "officePhone":
				list.add("办公电话修改为" + entry.getValue());
				break;
			case "department":
				list.add("部门修改为" + entry.getValue());
				break;
			case "post":
				list.add("职务修改为" + entry.getValue());
				break;
			case "title":
				list.add("职称修改为" + entry.getValue());
				break;
			case "remark1":
				list.add("备注1修改为" + entry.getValue());
				break;
			case "remark2":
				list.add("备注2修改为" + entry.getValue());
				break;
			}
		}
		String str = String.join(" ; ", list);
		return str;
	}

	private Method getMethod(BaseAlumni baseAlumni, Field field) {
		Method m = null;
		String name = field.getName();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		try {
			m = baseAlumni.getClass().getMethod("get" + name);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void saveTimeLine(BaseAlumni now, BaseAlumni old) {
		Map<String, String> params = getFieldValue(now, old);
		String content = GetVal(params);
		timelineSrv.saveOrUpdate(content, old.getId());
	}
}
