package com.wisdombud.alumni.manage;

import com.wisdombud.alumni.common.IBaseSrv;
import com.wisdombud.alumni.pojo.manage.BaseMessageBoard;

/**
 * 留言表 ISrv. <br/>
 * 
 * @author cczhao
 * 
 */
public interface BaseMessageBoardSrv extends IBaseSrv<BaseMessageBoard> {
	void audit(String id, String flag);

	boolean updateReplyMessage(String id, String replyContent, String isShow);

	boolean sendEmail(String email, String replyContent);
}