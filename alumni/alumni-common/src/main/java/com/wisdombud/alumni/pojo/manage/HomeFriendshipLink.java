package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name= "HOME_FRIENDSHIP_LINK")
public class HomeFriendshipLink extends UUIDReservePo{
private static final long serialVersionUID = 1L;

	@Column(name= "NAME")
	private String name;
   
	@Column(name= "PIC_ID")
	private String picId;
   
	@Column(name= "LINK_URL")
	private String linkUrl;
   
	@Column(name= "SORT_FLAG")
	private Integer sortFlag;
   
	@Column(name= "IS_ENABLE")
	private Integer isEnable;
   
   
	/**
	 * 功能:get 链接名称'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getName(){
		return name;
	}
   
	/**
	 * 功能:set 链接名称'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setName(String name){
		this.name = name;
	}
   
	/**
	 * 功能:get 图片ID'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getPicId(){
		return picId;
	}
   
	/**
	 * 功能:set 图片ID'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPicId(String picId){
		this.picId = picId;
	}
   
	/**
	 * 功能:get 链接地址'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public String getLinkUrl(){
		return linkUrl;
	}
   
	/**
	 * 功能:set 链接地址'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setLinkUrl(String linkUrl){
		this.linkUrl = linkUrl;
	}
   
	/**
	 * 功能:get 排序'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Integer getSortFlag(){
		return sortFlag;
	}
   
	/**
	 * 功能:set 排序'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setSortFlag(Integer sortFlag){
		this.sortFlag = sortFlag;
	}
   
	/**
	 * 功能:get 是否启用'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	*/
   
	public Integer getIsEnable(){
		return isEnable;
	}
   
	/**
	 * 功能:set 是否启用'<br/>
	 * date:  <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIsEnable(Integer isEnable){
		this.isEnable = isEnable;
	}
}