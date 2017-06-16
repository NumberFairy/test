package com.wisdombud.alumni.dao.dic.impl;

import org.springframework.stereotype.Repository;
import com.wisdombud.alumni.dao.dic.DicCollegeDao;
import com.wisdombud.alumni.pojo.dic.DicCollege;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

@Repository
public class DicCollegeDaoImpl extends SimpleHibernateDao<DicCollege, Integer> implements DicCollegeDao {

}