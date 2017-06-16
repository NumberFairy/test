package com.wisdombud.alumni.manage;

import java.util.ArrayList;
import java.util.List;

public enum AlumExcel {
	code(1, "学号/职工号"), 
	name(2, "姓名"), 
	gender(3, "性别"), 
	mobile(4, "联系电话"), 
	alumniIdentity(5, "校友类别"), 
	label(6,"标签（空格分隔）"),
	birthDate(7, "出生年月"), 
	natives(8, "籍贯"),
	politicalStatus(9, "政治面貌"), 
	wechatId(10,"微信号"), 
	wechatName(11, "微信昵称"), 
	qq(12, "QQ"), 
	email(13, "邮箱"),
	city(14, "所在地"), 
	gradeDate(15,"入学年级"), 
	college(16, "院系"), 
	major(17, "专业"), 
	className(18, "班级名称"), 
	business(19,"行业"), 
	company(20, "所在单位"),
	department(21, "部门"), 
	position(22, "职务"),
	identity(24, "身份"), 
	enrollYear(26, "入学年份"), 
	reVarchar1(27,"毕业年份"), 
	phone(28, "手机号"), 
	teacher(29, "辅导员/导师"), 
	reVarchar2(30,"单位邮编"), 
	reVarchar3(31, "家庭邮编"), 
	companyAddress(32,"单位地址"), 
	title(33, "职称"), address(34,"永久通讯地址"), 
	industry(35, "行业"), companyCity(36, "单位所在省市"), 
	officePhone(37,"办公电话"), 
	post(38,"职务"), 
	remark1(39,"备注1"),
	remark2(40,"备注2"), 
	remark3(41,"备注3"), 
	remark4(42,"备注4"), 
	remark5(43,"备注5"), 
	remark6(44,"备注6"), 
	remark7(45,"备注7"), 
	remark8(46,"备注8"), 
	remark9(49,"备注9"), 
	remark10(50,"备注10"),
	alumniClubIdentityName(51,"校友会任职身份（逗号分隔）"),
	alumniIdentityName(52,"校友身份（逗号分隔）"),
	branchClubIdentityName(53,"校友分会任职身份（逗号分隔）"),
	reVarchar0(54,"民族"),
	highestEducation(55,"最高学历");
	
	private Integer id;
	private String str;

	public static AlumExcel find(int id) {
		for (final AlumExcel v : AlumExcel.values()) {
			if (v.getId() == id) {
				return v;
			}
		}
		return null;
	}

	public static List<String> allFilds() {
		List<String> list = new ArrayList<>();
		for (final AlumExcel v : AlumExcel.values()) {
			list.add(v.toString());
		}
		list.add(24 + "");
		list.add(25 + "");
		list.add(26 + "");
		list.add(27 + "");
		list.add(28 + "");
		list.add(29 + "");
		list.add(30 + "");
		list.add(31 + "");
		list.add(32 + "");
		return list;
	}

	private AlumExcel(int id, String str) {
		this.setId(id);
		this.setStr(str);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}