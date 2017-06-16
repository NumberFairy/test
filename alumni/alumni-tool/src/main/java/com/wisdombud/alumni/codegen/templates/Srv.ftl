package com.wisdombud.alumni.manage.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.wisdombud.alumni.pojo.manage.${entityName};
import com.wisdombud.alumni.common.BaseSrvImpl;
import common.toolkit.java.orm.hibernate.CommonDao;
import com.wisdombud.alumni.manage.${entityName}Srv;

	/**
     * ${comment}Srv. <br/>
     * @author Administrator
     
     */
@Service(value= "${lowerEntityName}Srv")
public class ${entityName}SrvImpl extends BaseSrvImpl<${entityName}> implements ${entityName}Srv {

    private static final Logger LOGGER = Logger.getLogger(${entityName}SrvImpl.class);
    
    public ${entityName}SrvImpl(){}
    
	@Autowired
	public ${entityName}SrvImpl(@Qualifier(value = "${lowerEntityName}Dao") CommonDao<${entityName}, String> commonDao) {
		super(commonDao);
	}
}
