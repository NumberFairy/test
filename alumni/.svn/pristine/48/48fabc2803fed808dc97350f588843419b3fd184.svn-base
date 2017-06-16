package com.wisdombud.alumni.pojo.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class UUIDBasePo implements Serializable {

	/**
     * 主键ID
     * Hibernate3.6以后,UUIDHexGenerator(uuid)已不推荐使用，改用UUIDGenerator(org.hibernate
     * .id.UUIDGenerator)
     */
    @Id
    @Column(name = "ID", updatable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDHexGenerator")
    public String id;

	@Column(name= "CREATE_TIME")
	private Date createTime;
   
	@Column(name= "LAST_UPDATE")
	private Date lastUpdate;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
 	/**
 	 * 功能:get '创建时间'<br/>
 	 * date:  <br/>
 	 *
 	 * @author
 	 * @return
 	*/
    
 	public Date getCreateTime(){
 		return createTime;
 	}
    
 	/**
 	 * 功能:set '创建时间'<br/>
 	 * date:  <br/>
 	 *
 	 * @author
 	 * @return
 	 */
 	public void setCreateTime(Date createTime){
 		this.createTime = createTime;
 	}
    
 	/**
 	 * 功能:get '更新时间'<br/>
 	 * date:  <br/>
 	 *
 	 * @author
 	 * @return
 	*/
    
 	public Date getLastUpdate(){
 		return lastUpdate;
 	}
    
 	/**
 	 * 功能:set '更新时间'<br/>
 	 * date:  <br/>
 	 *
 	 * @author
 	 * @return
 	 */
 	public void setLastUpdate(Date lastUpdate){
 		this.lastUpdate = lastUpdate;
 	}

}
