package com.wisdombud.alumni.manage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.vo.RemindVo;

import common.toolkit.java.entity.PageEntity;

/**
 * 校友信息表 ISrv. <br/>
 * 
 * @author Administrator
 * 
 */
public interface BaseAlumniSrv extends IBaseSrv<BaseAlumni> {
	/**
	 * 功能: 获得选中的所有email邮箱.<br/>
	 * date: 2017年4月10日 上午10:01:39 <br/>
	 *
	 * @author czjia
	 * @param ids
	 * @return
	 */
	String getSelectedEmail(String ids);

	List<String> string2List(String strs);

	/**
	 * 功能: 设置选中项为联络员.<br/>
	 * date: 2017年4月10日 下午4:44:02 <br/>
	 *
	 * @author czjia
	 * @param ids
	 */
	void updateBecomeLiaison(String ids);

	void fillName(List<BaseAlumni> list);

	void fillName(BaseAlumni entity);

	List<DicSpecialty> findAllCollegeSpecialty(Integer collegeId);

	/**
	 * @DES:我的办工桌提醒事件
	 * @param :beforeDay
	 *            提前提醒时间默认2天
	 * @autor:xiefei<br/>
	 */
	void pageRemind(PageEntity<RemindVo> page, Integer beforeDay, String key);

	public void createExcelWorkBookInfo(HttpServletResponse response, List<BaseAlumni> results, String exportFields);

	/**
	 * @DES:比较校友信息的改动情况
	 */
	Map<String, String> getFieldValue(BaseAlumni now, BaseAlumni old);

	/**
	 * @DES:生成比较后字符串
	 */
	String GetVal(Map<String, String> map);

	/**
	 * @DES:校友时光轴
	 */
	void saveTimeLine(BaseAlumni now, BaseAlumni old);

}