package com.wisdombud.alumni.pojo.manage.config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "${ValueObject.dbName}")
public class ${ValueObject.entityName} extends UUIDReserveConfPo{
private static final long serialVersionUID = 1L;

<#list systems as system>
	@Column(name= "${system.dbName}")
    private ${system.type} ${system.entityName};
   
</#list>
<#list systems as system>
   
	/**
	 * 功能:get ${system.comment}<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
    
	public ${system.type} get${system.getSetEntityName}(){
		return ${system.entityName};
	}
   
	/**
	 * 功能:set ${system.comment}<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void set${system.getSetEntityName}(${system.type} ${system.entityName}){
		this.${system.entityName} = ${system.entityName};
	}
</#list>
}