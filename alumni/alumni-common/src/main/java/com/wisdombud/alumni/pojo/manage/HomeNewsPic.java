package com.wisdombud.alumni.pojo.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wisdombud.alumni.pojo.base.UUIDReservePo;

@Entity
@Table(name = "HOME_NEWS_PIC")
public class HomeNewsPic extends UUIDReservePo {
	private static final long serialVersionUID = 1L;

	public static final Integer PICSTATE_YES = 1;// 是否显示
	public static final Integer PICSTATE_NO = 0;

	public static final Integer isPc_YES = 1;// 门户
	public static final Integer isPc_NO = 0;// 微信

	@Column(name = "TITLE")
	private String title;

	@Column(name = "PIC_ID")
	private String picId;

	@Column(name = "LINK_URL")
	private String linkUrl;

	@Column(name = "SORT_FLAG")
	private Integer sortFlag;

	@Column(name = "PIC_STATE")
	private Integer picState;

	@Column(name = "INTRO")
	private String intro;

	@Column(name = "IS_PC")
	private String isPc;

	@Column(name = "PIC_NAME")
	private String picName;

	/**
	 * 功能:get 图片名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * 功能:set 图片名称'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 功能:get 图片ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getPicId() {
		return picId;
	}

	/**
	 * 功能:set 图片ID'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPicId(String picId) {
		this.picId = picId;
	}

	/**
	 * 功能:get 指向链接'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * 功能:set 指向链接'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	/**
	 * 功能:get 排序'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getSortFlag() {
		return sortFlag;
	}

	/**
	 * 功能:set 排序'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setSortFlag(Integer sortFlag) {
		this.sortFlag = sortFlag;
	}

	/**
	 * 功能:get 是否使用轮播图'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public Integer getPicState() {
		return picState;
	}

	/**
	 * 功能:set 是否使用轮播图'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setPicState(Integer picState) {
		this.picState = picState;
	}

	/**
	 * 功能:get 正文结束'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getIntro() {
		return intro;
	}

	/**
	 * 功能:set 正文结束'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * 功能:get 是否是PC端的图片'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */

	public String getIsPc() {
		return isPc;
	}

	/**
	 * 功能:set 是否是PC端的图片'<br/>
	 * date: <br/>
	 *
	 * @author
	 * @return
	 */
	public void setIsPc(String isPc) {
		this.isPc = isPc;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

}