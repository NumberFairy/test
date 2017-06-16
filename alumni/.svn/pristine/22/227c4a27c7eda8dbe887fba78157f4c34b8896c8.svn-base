package com.wisdombud.alumni.manage;

import java.util.List;

import com.wisdombud.alumni.pojo.dic.DicCollege;
import com.wisdombud.alumni.pojo.dic.DicSpecialty;
import com.wisdombud.alumni.vo.ZTreeVo;

/**
 * @DES:学院字典管理
 * @author xiefei
 *
 */
public interface CollgeManageSrv {

	/**
	 * @DES:构造学院字典树
	 * @autor:xiefei<br/>
	 */
	List<ZTreeVo> buildCollegeTree();

	void saveOrUpdate(DicCollege college);

	void saveOrUpdate(DicSpecialty specialty);

	void delete(Integer id, Integer pid);
}
