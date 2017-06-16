package com.wisdombud.alumni.actions.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wisdombud.alumni.common.DicCommonSrv;
import com.wisdombud.alumni.pojo.dic.DicAlumniBranchIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniClubIdentity;
import com.wisdombud.alumni.pojo.dic.DicAlumniIdentity;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.dic.DicDegree;
import com.wisdombud.alumni.pojo.dic.DicIndustry;
import com.wisdombud.alumni.pojo.dic.DicNational;
import com.wisdombud.alumni.pojo.dic.DicPoliticalStatus;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.vo.DicCommonVo;
import com.wisdombud.alumni.vo.DistrictVo;

import common.toolkit.java.entity.DateFormat;
import common.toolkit.java.struts2.AbstractCommonAction;

/**
 * 功能: 字典<br/>
 */
@Scope("prototype")
@ParentPackage(value = "portal-default")
@Namespace(value = "/")
public class DicCommonAction extends AbstractCommonAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	private DicCommonSrv	  srv;

	private Integer			  id;

	/**
	 * @DES:校友会任职身份
	 * @autor:xiefei<br/>
	 */
	public void findAllAlumniClubIdentity() {
		List<DicAlumniClubIdentity> list = srv.findAll(DicAlumniClubIdentity.class);
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(list));
	}

	/**
	 * @DES:校友身份
	 * @autor:xiefei<br/>
	 */
	public void findAllDicAlumniIdentity() {
		List<DicAlumniIdentity> list = srv.findAll(DicAlumniIdentity.class);
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(list));
	}

	/**
	 * @DES:校友分会任职身份
	 * @autor:xiefei<br/>
	 */
	public void findDicAlumniBranchIdentity() {
		List<DicAlumniBranchIdentity> list = srv.findAll(DicAlumniBranchIdentity.class);
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(list));
	}

	/**
	 * @DES:学历字典
	 * @autor:xiefei<br/>
	 */
	public void findAllDicDegree() {
		List<DicDegree> list = srv.findAll(DicDegree.class);
		List<DicCommonVo> dic = new ArrayList<>();
		for (DicDegree d : list) {
			dic.add(new DicCommonVo(d.getId(), d.getCnName()));
		}
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(dic));
	}

	/**
	 * @DES:院系字典
	 * @autor:xiefei<br/>
	 */
	public void findAllCollege() {
		List<DicCollege> list = srv.findAll(DicCollege.class);
		List<DicCommonVo> dic = new ArrayList<>();
		for (DicCollege d : list) {
			dic.add(new DicCommonVo(d.getId(), d.getCnName()));
		}
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(dic));
	}

	/**
	 * @DES:专业字典
	 * @autor:xiefei<br/>
	 */
	public void findAllCollegeSpecialty() {
		List<DicSpecialty> list = srv.findAllSpecialty();
		if (id != null) {
			list = srv.findAllCollegeSpecialty(id);
		}
		List<DicCommonVo> dic = new ArrayList<>();
		for (DicSpecialty d : list) {
			dic.add(new DicCommonVo(d.getId(), d.getCnName()));
		}
		final Gson g = new GsonBuilder().setDateFormat(DateFormat.DateTime.getFormat()).create();
		this.sendResponseMsg(g.toJson(dic));
	}

	/**
	 * 功能: 查询全部国家.<br/>
	 * date: 2016年10月8日 下午5:53:42 <br/>
	 *
	 * @author zlliu
	 */
	public void findAllDistricts() {
		final List<DistrictVo> voList = srv.findAllDistricts();
		final Gson g = new GsonBuilder().create();
		this.sendResponseMsg(g.toJson(voList));
	}

	/**
	 * 功能: 查询中国省市.<br/>
	 * date: 2016年10月8日 下午5:48:04 <br/>
	 *
	 * @author zlliu
	 */
	public void findAllCNDistricts() {
		final List<DistrictVo> voList = srv.findAllCNDistricts();
		final Gson g = new GsonBuilder().create();
		this.sendResponseMsg(g.toJson(voList));
	}

	/**
	 * 功能:政治面貌 .<br/>
	 * 
	 * @author xiefei
	 */
	public void findPoliticalStatus() {
		final Gson g = new GsonBuilder().create();
		this.sendResponseMsg(g.toJson(srv.findAll(DicPoliticalStatus.class)));
	}

	/**
	 * 功能:行业 .<br/>
	 * 
	 * @author xiefei
	 */
	public void findDicIndustry() {
		final Gson g = new GsonBuilder().create();
		this.sendResponseMsg(g.toJson(srv.findAll(DicIndustry.class)));
	}

	/**
	 * 功能: 民族.<br/>
	 * date: 2017年4月18日 下午4:01:13 <br/>
	 *
	 * @author myzhai
	 */
	public void findAllNational() {
		final Gson g = new GsonBuilder().create();
		this.sendResponseMsg(g.toJson(srv.findAll(DicNational.class)));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
