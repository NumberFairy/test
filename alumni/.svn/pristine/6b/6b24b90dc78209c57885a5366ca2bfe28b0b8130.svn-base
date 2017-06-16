package com.wisdombud.alumni.dao.system;

import java.util.List;

import com.wisdombud.alumni.pojo.system.SecOper;
import com.wisdombud.alumni.pojo.system.SecRole;

import common.toolkit.java.orm.hibernate.CommonDao;

public interface SecRoleDao extends CommonDao<SecRole, String> {

    List<SecRole> findBy(List<String> roleIds);

    List<SecOper> findByOperIds(List<String> operIdList);

    boolean checkRoleIsExistByName(String roleName, String oldRoleName);
}