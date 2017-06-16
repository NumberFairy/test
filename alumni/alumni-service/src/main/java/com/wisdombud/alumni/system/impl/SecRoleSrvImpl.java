package com.wisdombud.alumni.system.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wisdombud.alumni.common.BaseSrvImpl;
import com.wisdombud.alumni.pojo.system.SecRole;
import com.wisdombud.alumni.system.SecRoleSrv;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.CommonDao;

@Service(value = "secRoleSrv")
public class SecRoleSrvImpl extends BaseSrvImpl<SecRole> implements SecRoleSrv {

    public SecRoleSrvImpl() {
    }

    @Autowired
    public SecRoleSrvImpl(@Qualifier(value = "secRoleDao") CommonDao<SecRole, String> commonDao) {
        super(commonDao);
    }

    @Override
    public void page(PageEntity<SecRole> pageEntity, Map<String, Param> params, List<Order> orders) {
        super.page(pageEntity, params, orders);
    }

    @Override
    public String save(SecRole entity) {
        return super.save(entity);
    }

    @Override
    public SecRole find(String id) {
        SecRole user = super.find(id);
        return user;
    }

    @Override
    public void deleteByIds(String ids) {
        super.deleteByIds(ids);
    }

    @Override
    public SecRole findUniqueBy(String key, Object value) {
        return super.findUniqueBy(key, value);
    }
}
