package com.wisdombud.alumni.manage.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.enums.AlumniIdentityEnum;
import com.wisdombud.alumni.enums.IdentityEnum;
import com.wisdombud.alumni.manage.BaseIdentityRelationSrv;
import com.wisdombud.alumni.manage.ImportExportSrv;
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
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;
import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;
import com.wisdombud.alumni.util.BeanUtils;

import common.toolkit.java.entity.DateFormat;

@Service
public class ImportExportSrvImpl implements ImportExportSrv {

	@Autowired
	private DicCommonSrv dicSrv;
	@Autowired
	private BaseIdentityRelationSrv relationSrv;

	private Map<Integer, String> degree;
	private Map<Integer, String> industry;
	private Map<Integer, String> alumniClubIdentity;
	private Map<Integer, String> alumniBranchIdentitie;
	private Map<Integer, String> alumniIdentitie;

	List<DicPoliticalStatus> dicPoliticalStatusList = null;
	List<DicCollege> dicColleges = null;
	List<DicSpecialty> dicSpecialties = null;
	List<DicNational> dicNationals = null;
	List<DicDegree> dicDegrees = null;
	List<DicIndustry> dicIndustries = null;

	private SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormat.Date.getFormat());

	public void initList() {
		dicPoliticalStatusList = this.dicSrv.findAll(DicPoliticalStatus.class);
		dicColleges = this.dicSrv.findAll(DicCollege.class);
		dicSpecialties = this.dicSrv.findAll(DicSpecialty.class);
		dicNationals = this.dicSrv.findAll(DicNational.class);
		dicDegrees = this.dicSrv.findAll(DicDegree.class);
		dicIndustries = this.dicSrv.findAll(DicIndustry.class);
	}

	public int convertGender(String gender) {
		if (null == gender) {
			return 0;
		}
		if (gender.equals("女")) {
			return 1;
		}
		return 0;
	}

	public String convertGender(int gender) {
		return gender == 0 ? "男" : "女";
	}

	public int convertPoliticalStatus(String ps) {
		String value = "";
		if (null == ps) {
			value = "群众";
		} else if (ps.contains("预备")) {
			value = "预备党员";
		} else if (ps.contains("团")) {
			value = "共青团员";
		} else if (ps.contains("群众")) {
			value = "群众";
		} else if (ps.contains("党")) {
			value = "党员";
		} else {
			value = "群众";
		}
		List<DicPoliticalStatus> list = this.dicSrv.findAll(DicPoliticalStatus.class);
		for (DicPoliticalStatus inst : list) {
			if (inst.getValue().equals(value)) {
				return inst.getId();
			}
		}
		return 4;// 群众
	}

	private void initDic() {
		List<DicDegree> degrees = dicSrv.findAll(DicDegree.class);
		List<DicIndustry> industrys = dicSrv.findAll(DicIndustry.class);
		List<DicAlumniClubIdentity> clubIdentities = dicSrv.findAll(DicAlumniClubIdentity.class);
		List<DicAlumniBranchIdentity> branchIdentities = dicSrv.findAll(DicAlumniBranchIdentity.class);
		List<DicAlumniIdentity> identities = dicSrv.findAll(DicAlumniIdentity.class);
		degree = new HashMap<>();
		industry = new HashMap<>();
		alumniClubIdentity = new HashMap<>();
		alumniBranchIdentitie = new HashMap<>();
		alumniIdentitie = new HashMap<>();

		for (DicDegree v : degrees) {
			degree.put(v.getId(), v.getCnName());
		}
		for (DicIndustry v : industrys) {
			industry.put(v.getId(), v.getValue());
		}
		for (DicAlumniClubIdentity v : clubIdentities) {
			alumniClubIdentity.put(v.getId(), v.getValue());
		}

		for (DicAlumniBranchIdentity v : branchIdentities) {
			alumniBranchIdentitie.put(v.getId(), v.getValue());
		}

		for (DicAlumniIdentity v : identities) {
			alumniIdentitie.put(v.getId(), v.getValue());
		}

	}

	public String convertPoliticalStatus(int id) {
		DicPoliticalStatus ret = this.dicSrv.findById(DicPoliticalStatus.class, id);
		if (null == ret) {
			return "群众";
		} else {
			return ret.getValue();
		}
	}

	public int convertCollege(String college) {

		for (DicCollege inst : dicColleges) {
			if (inst.getCnName().equals(college)) {
				return inst.getId();
			}
		}
		return dicColleges.get(0).getId();// 找不到默认返回第一个
	}

	public String convertCollege(Integer college) {
		DicCollege ret = this.dicSrv.findById(DicCollege.class, college);
		if (null == ret) {
			return "地球科学与资源学院";
		} else {
			return ret.getCnName();
		}
	}

	public int convertMajor(String major) {

		for (DicSpecialty inst : dicSpecialties) {
			if (inst.getCnName().equals(major)) {
				return inst.getId();
			}
		}
		return dicSpecialties.get(0).getId();// 找不到默认返回第一个
	}

	public String convertMajor(int major) {
		DicSpecialty ret = this.dicSrv.findById(DicSpecialty.class, major);
		if (null == ret) {
			return "地质学";
		} else {
			return ret.getCnName();
		}
	}

	public int convertNational(String national) {

		for (DicNational inst : dicNationals) {
			if (inst.getValue().equals(national)) {
				return inst.getId();
			}
		}
		return dicNationals.get(0).getId();// 找不到默认返回第一个
	}

	public int convertDegree(String degree) {

		for (DicDegree inst : dicDegrees) {
			if (inst.getCnName().equals(degree)) {
				return inst.getId();
			}
		}
		return dicDegrees.get(0).getId();// 找不到默认返回第一个
	}

	public int convertIndustry(String industry) {

		for (DicIndustry inst : dicIndustries) {
			if (inst.getValue().equals(industry)) {
				return inst.getId();
			}
		}
		return dicIndustries.get(0).getId();// 找不到默认返回第一个
	}

	private void getShenFen(BaseAlumni entity) {
		List<BaseIdentityRelation> list = relationSrv.findBy("alumniId", entity.getId());
		if (CollectionUtils.isNotEmpty(list)) {
			BaseIdentityRelation e = list.get(0);
			String clu = e.getAlumniClubIdentityId();
			String ide = e.getAlumniIdentityId();
			String bra = e.getBranchClubIdentityId();
			if (StringUtils.isNotBlank(clu)) {
				String str = "";
				for (String v : clu.replace(" ", "").split(",")) {
					str += alumniClubIdentity.get(new Integer(v)) + ",";
				}
				entity.setAlumniClubIdentityName(str.substring(0, str.length() - 1));
			}
			if (StringUtils.isNotBlank(ide)) {
				String str = "";
				for (String v : ide.replace(" ", "").split(",")) {
					str += alumniIdentitie.get(new Integer(v)) + ",";
				}
				entity.setAlumniIdentityName(str.substring(0, str.length() - 1));
			}
			if (StringUtils.isNotBlank(bra)) {
				String str = "";
				for (String v : bra.replace(" ", "").split(",")) {
					str += alumniBranchIdentitie.get(new Integer(v)) + ",";
				}
				entity.setBranchClubIdentityName(str.substring(0, str.length() - 1));
			}
		}
	}

	public BaseAlumniImport convert(BaseAlumni entity) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		BaseAlumniImport ret = new BaseAlumniImport();
		getShenFen(entity);
		BeanUtils.copyProperties(entity, ret, "gender", "politicalStatus", "remark1", "college", "major", "companyCity",
				"companyCityStr", "identity", "birthDate", "enrollYear", "highestEducation");

		ret.setCompanyCity(entity.getCompanyCityStr());
		ret.setNatives(entity.getNativeStr());
		if (entity.getHighestEducation() != null) {
			ret.setHighestEducation(degree.get(entity.getHighestEducation()));
		}
		if (entity.getIndustry() != null) {
			ret.setIndustry(industry.get(entity.getIndustry()));
		}

		if (entity.getGender() != null) {
			ret.setGender(this.convertGender(entity.getGender()));
		}
		if (entity.getPoliticalStatus() != null) {
			ret.setPoliticalStatus(this.convertPoliticalStatus(entity.getPoliticalStatus()));
		}
		if (entity.getCollege() != null) {
			ret.setCollege(this.convertCollege(entity.getCollege()));
		}
		if (entity.getMajor() != null) {
			ret.setMajor(this.convertMajor(entity.getMajor()));
		}
		if (StringUtils.isNotBlank(entity.getReVarchar0())) {
			if (StringUtils.isNumeric(entity.getReVarchar0())) {
				String val = dicSrv.findById(DicNational.class, new Integer(entity.getReVarchar0())).getValue();
				ret.setReVarchar0(val);
			}
		}

		// 身份
		if (entity.getIdentity() != null) {
			String val = AlumniIdentityEnum.valueByIndex(entity.getIdentity()) == null ? ""
					: AlumniIdentityEnum.valueByIndex(entity.getIdentity()).getName();
			ret.setIdentity(val);
		}
		// 生日
		if (entity.getBirthDate() != null) {
			ret.setBirthDate(df.format(entity.getBirthDate()));
		}
		if (entity.getEnrollYear() != null) {
			ret.setEnrollYear(entity.getEnrollYear() + "");
		}
		return ret;
	}

	public BaseAlumni convert(BaseAlumniImport entity) {
		initList();
		BaseAlumni ret = new BaseAlumni();

		BeanUtils.copyProperties(entity, ret, "id", "gender", "identity", "birthDate", "politicalStatus", "enrollYear",
				"college", "major", "highestEducation", "industry");

		if (StringUtils.isNotBlank(entity.getGender())) {
			ret.setGender(this.convertGender(entity.getGender()));
		}
		if (StringUtils.isNotBlank(entity.getIdentity())) {
			ret.setIdentity(IdentityEnum.valueByName(entity.getIdentity()).getValue());
		}
		if (StringUtils.isNotBlank(entity.getBirthDate())) {
			ret.setBirthDate(dateFmt(entity.getBirthDate()));
		}
		if (StringUtils.isNotBlank(entity.getEnrollYear())) {
			ret.setEnrollYear(Integer.parseInt(entity.getEnrollYear()));
		}
		// 民族
		if (StringUtils.isNotBlank(entity.getReVarchar0())) {
			ret.setReVarchar0(convertNational(entity.getReVarchar0()) + "");
		}
		if (StringUtils.isNotBlank(entity.getPoliticalStatus())) {
			ret.setPoliticalStatus(this.convertPoliticalStatus(entity.getPoliticalStatus()));
		}
		if (StringUtils.isNotBlank(entity.getCollege())) {
			ret.setCollege(this.convertCollege(entity.getCollege()));
		}
		if (StringUtils.isNotBlank(entity.getMajor())) {
			ret.setMajor(this.convertMajor(entity.getMajor()));
		}
		if (StringUtils.isNotBlank(entity.getHighestEducation())) {
			ret.setHighestEducation(convertDegree(entity.getHighestEducation()));
		}
		if (StringUtils.isNotBlank(entity.getIndustry())) {
			ret.setIndustry(convertIndustry(entity.getIndustry()));
		}
		if (StringUtils.isNotBlank(entity.getCompanyCity())) {
			ret.setCompanyCity("CN$" + entity.getCompanyCity());
		}
		if (StringUtils.isNotBlank(entity.getNatives())) {
			ret.setNatives("CN$" + entity.getNatives());
		}
		return ret;
	}

	public List<BaseAlumniImport> convert2Export(List<BaseAlumni> entityList) {
		List<BaseAlumniImport> retList = Lists.newArrayList();
		initDic();
		for (BaseAlumni entity : entityList) {
			retList.add(this.convert(entity));
		}
		return retList;
	}

	public List<BaseAlumni> convert2Base(List<BaseAlumniImport> entityList) {
		List<BaseAlumni> retList = Lists.newArrayList();
		for (BaseAlumniImport entity : entityList) {
			retList.add(this.convert(entity));
		}
		return retList;
	}

	private Date dateFmt(String text) {
		ParsePosition pos = new ParsePosition(0);
		return dateFormat.parse(text, pos);
	}
}
