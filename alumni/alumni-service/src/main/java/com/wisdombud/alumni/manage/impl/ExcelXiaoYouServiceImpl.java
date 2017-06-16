package com.wisdombud.alumni.manage.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.dao.manage.BaseAlumniDao;
import com.wisdombud.alumni.manage.AlumExcel;
import com.wisdombud.alumni.manage.BaseAlumniImportSrv;
import com.wisdombud.alumni.manage.BaseIdentityRelationSrv;
import com.wisdombud.alumni.manage.ExcelXiaoYouService;
import com.wisdombud.alumni.manage.ImportExportSrv;
import com.wisdombud.alumni.pojo.dic.DicAlumniBranchIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniClubIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniIdentity;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;
import com.wisdombud.alumni.pojo.manage.BaseIdentityRelation;
import com.wisdombud.alumni.util.ExcelImportUtil;
import com.wisdombud.alumni.util.IdKit;

import jxl.write.WritableWorkbook;

@Service
public class ExcelXiaoYouServiceImpl implements ExcelXiaoYouService {
	@Autowired
	private BaseAlumniDao baseAlumnidDao;

	@Autowired
	private BaseAlumniImportSrv baseAlumniImportSrv;

	@Autowired
	private BaseIdentityRelationSrv baseIdentityRelationSrv;

	@Autowired
	private ImportExportSrv importExportSrv;

	@Autowired
	private DicCommonSrv dicSrv;

	/**
	 * @param excelFile
	 *            从excel中读取数据，并存储到数据库临时表中
	 * @return
	 * @throws IOException
	 */
	@Override
	public int importExcel(File excelFile) throws IOException {
		List<List<Object>> datas = ExcelImportUtil.readExcel(excelFile);
		int count = 0;
		for (int i = 1; i < datas.size(); i++) {
			BaseAlumniImport entity = this.convert2Entity(datas.get(i));
			this.baseAlumniImportSrv.save(entity);
			count++;
		}
		return count;
	}

	/**
	 * 转换数据，根据excel的固定头转换。 </br>
	 * 学院 学历 入学年份 专业 班号 学号 姓名 性别 民族 政治面貌 毕业年份 工作省区 工作市区 工作单位 职务 职称 单位地址 单位邮编
	 * 家庭地址 家庭邮编 办公电话 手机号 电子邮箱 QQ号码 备注
	 * 
	 * @param d
	 * @return
	 */
	private BaseAlumniImport convert2Entity(List<Object> data) {
		int index = 0;
		BaseAlumniImport entity = new BaseAlumniImport();
		Object c1 = data.get(index++);
		if (c1 != null) {
			entity.setName(c1.toString());
		}
		Object c2 = data.get(index++);
		if (c2 != null) {
			entity.setCode(c2.toString());
		}
		Object c3 = data.get(index++);
		if (c3 != null) {
			entity.setGender(c3.toString());
		}
		Object c4 = data.get(index++);
		if (c4 != null) {
			entity.setIdentity(c4.toString());
		}
		Object c5 = data.get(index++);
		if (c5 != null) {
			entity.setBirthDate(c5.toString());
		}
		Object c6 = data.get(index++);
		if (c6 != null) {
			// 民族
			entity.setReVarchar0(c6.toString());
		}
		Object c7 = data.get(index++);
		if (c7 != null) {
			entity.setPoliticalStatus(c7.toString());
		}
		Object c8 = data.get(index++);
		if (c8 != null) {
			entity.setEnrollYear(c8.toString());
		}
		Object c9 = data.get(index++);
		if (c9 != null) {
			// 毕业年份
			entity.setReVarchar1(c9.toString());
		}
		Object c10 = data.get(index++);
		if (c10 != null) {
			entity.setCollege(c10.toString());
		}
		Object c11 = data.get(index++);
		if (c11 != null) {
			entity.setMajor(c11.toString());
		}
		Object c12 = data.get(index++);
		if (c12 != null) {
			entity.setHighestEducation(c12.toString());
		}
		Object c13 = data.get(index++);
		if (c13 != null) {
			entity.setClassName(c13.toString());
		}
		Object c14 = data.get(index++);
		if (c14 != null) {
			entity.setLabel(c14.toString());
		}
		Object c15 = data.get(index++);
		if (c15 != null) {
			entity.setTeacher(c15.toString());
		}
		Object c16 = data.get(index++);
		if (c16 != null) {
			entity.setCompany(c16.toString());
		}
		Object c17 = data.get(index++);
		if (c17 != null) {
			entity.setIndustry(c17.toString());
		}
		Object c18 = data.get(index++);
		if (c18 != null) {
			entity.setCompanyCity(c18.toString());
		}
		Object c19 = data.get(index++);
		if (c19 != null) {
			entity.setCompanyCityStr(c19.toString());
		}
		Object c20 = data.get(index++);
		if (c20 != null) {
			entity.setCompanyAddress(c20.toString());
		}
		Object c21 = data.get(index++);
		if (c21 != null) {
			entity.setReVarchar2(c21.toString());
		}
		Object c22 = data.get(index++);
		if (c22 != null) {
			entity.setDepartment(c22.toString());
		}
		Object c23 = data.get(index++);
		if (c23 != null) {
			entity.setPhone(c23.toString());
		}
		Object c24 = data.get(index++);
		if (c24 != null) {
			entity.setOfficePhone(c24.toString());
		}
		Object c25 = data.get(index++);
		if (c25 != null) {
			entity.setPost(c25.toString());
		}
		Object c26 = data.get(index++);
		if (c26 != null) {
			entity.setTitle(c26.toString());
		}
		Object c27 = data.get(index++);
		if (c27 != null) {
			entity.setNatives(c27.toString());
		}
		Object c28 = data.get(index++);
		if (c28 != null) {
			entity.setNativeStr(c28.toString());
		}
		Object c29 = data.get(index++);
		if (c29 != null) {
			entity.setReVarchar3(c29.toString());
		}
		Object c30 = data.get(index++);
		if (c30 != null) {
			entity.setEmail(c30.toString());
		}
		Object c31 = data.get(index++);
		if (c31 != null) {
			entity.setQq(c31.toString());
		}
		Object c32 = data.get(index++);
		if (c32 != null) {
			entity.setWechatId(c32.toString());
		}
		Object c33 = data.get(index++);
		if (c33 != null) {
			entity.setWechatName(c33.toString());
		}
		Object c34 = data.get(index++);
		if (c34 != null) {
			entity.setAlumniClubIdentityName(c34.toString());
		}
		Object c35 = data.get(index++);
		if (c35 != null) {
			entity.setAlumniIdentityName(c35.toString());
		}
		Object c36 = data.get(index++);
		if (c36 != null) {
			entity.setBranchClubIdentityName(c36.toString());
		}
		Object c37 = data.get(index++);
		if (c37 != null) {
			entity.setAddress(c37.toString());
		}
		Object c38 = data.get(index++);
		if (c38 != null) {
			entity.setRemark1(c38.toString());
		}
		Object c39 = data.get(index++);
		if (c39 != null) {
			entity.setRemark2(c39.toString());
		}
		Object c40 = data.get(index++);
		if (c40 != null) {
			entity.setRemark3(c40.toString());
		}
		Object c41 = data.get(index++);
		if (c41 != null) {
			entity.setRemark4(c41.toString());
		}
		Object c42 = data.get(index++);
		if (c42 != null) {
			entity.setRemark5(c42.toString());
		}
		Object c43 = data.get(index++);
		if (c43 != null) {
			entity.setRemark6(c43.toString());
		}
		Object c44 = data.get(index++);
		if (c44 != null) {
			entity.setRemark7(c44.toString());
		}
		Object c45 = data.get(index++);
		if (c45 != null) {
			entity.setRemark8(c45.toString());
		}
		Object c46 = data.get(index++);
		if (c46 != null) {
			entity.setRemark9(c46.toString());
		}
		Object c47 = data.get(index++);
		if (c47 != null) {
			entity.setRemark10(c47.toString());
		}
		return entity;

	}

	@Override
	public void export(String ids, String fields, WritableWorkbook wb) {
		String[] fildsList;
		if (StringUtils.isBlank(fields)) {
			fildsList = StringUtils.join(AlumExcel.allFilds().toArray(), ",").split(",");
		} else {
			fildsList = fields.split(",");
		}
	}

	/**
	 * @DES:导出excel
	 * @autor:xiefei<br/>
	 */
	@Override
	public void export(List<BaseAlumni> results, String fields, HSSFWorkbook wb) {
		String[] fildsList;
		if (StringUtils.isBlank(fields)) {
			fildsList = StringUtils.join(AlumExcel.allFilds().toArray(), ",").split(",");
		} else {
			fildsList = fields.split(",");
		}
		HSSFSheet sheet = wb.createSheet();
		for (int i = 0; i < fildsList.length; i++) {
			sheet.setColumnWidth(i, 5000);
		}
		this.fillHeader(wb, sheet, fildsList);
		List<BaseAlumniImport> infoExport = this.importExportSrv.convert2Export(results);
		this.fillBody(infoExport, sheet, wb, fildsList);
		//TODO:可改为调用export(List<T> results, Map<String, String> fildsMap, HSSFWorkbook wb) 
	}

	/**
	 * @param <T>
	 * @DES:导出excel,导出当前实体部分字段
	 * @autor:jfzhai<br/>
	 */
	@Override
	public <T> void export(List<T> results, Map<String, String> fildsMap, HSSFWorkbook wb) {
		HSSFSheet sheet = wb.createSheet();
		for (int i = 0; i < fildsMap.size(); i++) {
			sheet.setColumnWidth(i, 5000);
		}
		this.fillCommonHeader(wb, sheet, fildsMap);
		this.fillCommonBody(results, sheet, wb, fildsMap);
	}

	private <T> void fillCommonBody(List<T> results, HSSFSheet sheet, HSSFWorkbook wb, Map<String, String> fildsMap) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 16);
		style.setFont(font);
		int i = 1;
		for (T inst : results) {
			HSSFRow row = sheet.createRow(i++);
			row.setRowStyle(style);
			int j = 0;
			for (String key : fildsMap.keySet()) {
				HSSFCell cell = row.createCell(j++);
				String val = setCell(key, inst);
				cell.setCellValue(val);
			}
		}
	}

	private void fillCommonHeader(HSSFWorkbook wb, HSSFSheet sheet, Map<String, String> fildsMap) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 18);
		style.setFont(font);
		HSSFRow row = sheet.createRow(0);
		int i = 0;
		for (String key : fildsMap.keySet()) {
			HSSFCell cell = row.createCell(i++);
			String value = fildsMap.get(key);
			cell.setCellValue(value);
			cell.setCellStyle(style);
		}
	}

	/**
	 * @DES:创建表头
	 * @autor:xiefei<br/>
	 */
	private void fillHeader(HSSFWorkbook wb, HSSFSheet sheet, String[] fieldList) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 18);
		style.setFont(font);
		HSSFRow row = sheet.createRow(0);
		int i = 0;
		Map<String, String> map = this.findMap();
		for (String id : fieldList) {
			HSSFCell cell = row.createCell(i++);
			String value = map.get(id);
			cell.setCellValue(value);
			cell.setCellStyle(style);
		}
	}

	private Map<String, String> findMap() {
		Map<String, String> map = Maps.newHashMap();
		for (AlumExcel v : AlumExcel.values()) {
			map.put(v.toString(), v.getStr());
		}
		return map;
	}

	/**
	 * @DES:创建表单
	 * @autor:xiefei<br/>
	 */
	private void fillBody(List<BaseAlumniImport> dataList, HSSFSheet sheet, HSSFWorkbook wb, String[] fieldArray) {
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 16);
		style.setFont(font);
		int i = 1;
		for (BaseAlumniImport inst : dataList) {
			HSSFRow row = sheet.createRow(i++);
			row.setRowStyle(style);
			int j = 0;
			for (String field : fieldArray) {
				HSSFCell cell = row.createCell(j++);
				String val = setCell(field, inst);
				cell.setCellValue(val);
			}
		}
	}

	public String toGetter(String fieldname) {

		if (fieldname == null || fieldname.length() == 0) {
			return null;
		}

		if (fieldname.length() > 2) {
			String second = fieldname.substring(1, 2);
			if (second.equals(second.toUpperCase())) {
				return new StringBuffer("get").append(fieldname).toString();
			}
		}

		fieldname = new StringBuffer("get").append(fieldname.substring(0, 1).toUpperCase())
				.append(fieldname.substring(1)).toString();

		return fieldname;
	}

	public Object invokeMethod(Object owner, String fieldname, Object[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class ownerClass = owner.getClass();

		Method method = null;
		method = ownerClass.getMethod(this.toGetter(fieldname));

		Object object = null;
		object = method.invoke(owner);

		return object;
	}

	@SuppressWarnings("rawtypes")
	private <T> String setCell(String field, T data) {
		String val = "";

		Class clazz = data.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals(field)) {
				try {
					Object resultObject = invokeMethod(data, fields[i].getName(), null);
					if (resultObject == null) {
						resultObject = "";
					}
					val = resultObject.toString();
					break;
				} catch (SecurityException | NoSuchMethodException | IllegalArgumentException | IllegalAccessException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return val;
	}

	public Object getFieldValue(BaseAlumni now, String fieldName) {
		Set<Field> fields = new HashSet<Field>();
		Field[] tempFields = now.getClass().getDeclaredFields();
		for (Field field : tempFields) {
			field.setAccessible(true);
			fields.add(field);
		}
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				try {
					return field.get(now);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public int saveReal() {
		List<BaseAlumniImport> importList = this.baseAlumniImportSrv.findAll();
		int count = 0;
		for (BaseAlumniImport inst : importList) {
			BaseAlumni v = this.importExportSrv.convert(inst);
			v.setId(IdKit.uuid());
			v.setCreateTime(new Date());
			v.setLastUpdate(new Date());
			this.baseAlumnidDao.save(v);
			saveIdentityRelation(inst);
			this.baseAlumniImportSrv.deleteById(inst.getId());
			count++;
		}
		return count;
	}

	public void saveIdentityRelation(BaseAlumniImport inst) {
		List<DicAlumniClubIdentity> aci = dicSrv.findAll(DicAlumniClubIdentity.class);
		Map<String, Integer> aciMap = new HashMap<String, Integer>();
		for (DicAlumniClubIdentity dic : aci) {
			aciMap.put(dic.getValue(), dic.getId());
		}
		List<DicAlumniIdentity> ai = dicSrv.findAll(DicAlumniIdentity.class);
		Map<String, Integer> aiMap = new HashMap<String, Integer>();
		for (DicAlumniIdentity dic : ai) {
			aiMap.put(dic.getValue(), dic.getId());
		}
		List<DicAlumniBranchIdentity> abi = dicSrv.findAll(DicAlumniBranchIdentity.class);
		Map<String, Integer> abiMap = new HashMap<String, Integer>();
		for (DicAlumniBranchIdentity dic : abi) {
			abiMap.put(dic.getValue(), dic.getId());
		}

		BaseIdentityRelation ir = new BaseIdentityRelation();
		ir.setAlumniId(inst.getId());
		String alumniClubIdentityName = inst.getAlumniClubIdentityName();
		if (StringUtils.isNotBlank(alumniClubIdentityName)) {
			StringBuilder sb = new StringBuilder();
			alumniClubIdentityName = alumniClubIdentityName.replaceAll("，", ",");
			String[] aciNames = alumniClubIdentityName.split(",");
			for (int i = 0; i < aciNames.length; i++) {
				if (i >= aciNames.length - 1) {
					sb.append(aciMap.get(aciNames[i]));
				} else {
					sb.append(aciMap.get(aciNames[i]) + ",");
				}
			}
			ir.setAlumniClubIdentityId(sb.toString());
		}
		String alumniIdentityName = inst.getAlumniIdentityName();
		if (StringUtils.isNotBlank(alumniIdentityName)) {
			StringBuilder sb = new StringBuilder();
			alumniIdentityName = alumniIdentityName.replaceAll("，", ",");
			String[] aiNames = alumniIdentityName.split(",");
			for (int i = 0; i < aiNames.length; i++) {
				if (i >= aiNames.length - 1) {
					sb.append(aiMap.get(aiNames[i]));
				} else {
					sb.append(aiMap.get(aiNames[i]) + ",");
				}
			}
			ir.setAlumniIdentityId(sb.toString());
		}
		String branchClubIdentityName = inst.getBranchClubIdentityName();
		if (StringUtils.isNotBlank(branchClubIdentityName)) {
			StringBuilder sb = new StringBuilder();
			branchClubIdentityName = branchClubIdentityName.replaceAll("，", ",");
			String[] abiNames = branchClubIdentityName.split(",");
			for (int i = 0; i < abiNames.length; i++) {
				if (i >= abiNames.length - 1) {
					sb.append(abiMap.get(abiNames[i]));
				} else {
					sb.append(abiMap.get(abiNames[i]) + ",");
				}
			}
			ir.setBranchClubIdentityId(sb.toString());
		}
		ir.setCreateTime(new Date());
		ir.setLastUpdate(new Date());
		baseIdentityRelationSrv.saveOrUpdate(ir);
	}


}
