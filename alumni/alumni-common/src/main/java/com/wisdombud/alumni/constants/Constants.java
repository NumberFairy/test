package com.wisdombud.alumni.constants;

import java.util.Map;
import java.util.TreeMap;

/**
 * ClassName: Constants. <br/>
 * date: 2014年7月2日 上午9:38:56 <br/>
 *
 * @author Ghlin
 * @version
 * @since JDK 1.6
 */
public final class Constants {
	public static final String OPTION_TEMPLATE = "<option value='%s'>%s</option>";
	public static final String LICENSE_ERROR = "LINCENSE_ERROR";
	public static final String NOT_EXIST = "NOTEXIST";
	public static final String PASS = "PASS";
	public static final String DENY = "DENY";
	public static final String STUDENT_TRANSFER_PASS = "通过报名";

	public static final Integer ADMIN_LOGIN_URL = 1;
	public static final Integer ALUMNI_LOGIN_URL = 2;

	public static final Integer STU_TO_USER = 0; // 学生发送到用户
	public static final Integer USER_TO_STU = 1; // 用户发送到学生

	public static final Integer STU_LETTER = 0; // 学生站内信
	public static final Integer USER_LETTER = 1; // 用户站内信

	public static final Integer PARENT_NODE_TYPE = 0;
	public static final Integer CHILD_NODE_TYPE = 1;

	public static final int FAIL_CODE = 0; // false
	public static final int SUCCESS_CODE = 1; // true
	public static final Integer MAX_RANDOM_NUMBER = 225;
	public static final int CAPTCHA_WIDTH = 200;
	public static final int CAPTCHA_HEIGHT = 72;
	public static final int RANDOM_NUMBER = 5;
	public static final int RANDOM_COLOR_NUMBER_MIN = 220;
	public static final int RANDOM_COLOR_NUMBER_MAX = 250;
	public static final Map<String, Object> WORKING_PLACE_MAP = new TreeMap<String, Object>();

	public static final int DEFUALT_PAGESIZE = 15;
	public static final int DEFUALT_FLOW_PAGESIZE = 10;

	public static final String NOT_REMENBER = "0";
	public static final String REMENBER_ME = "1";

	/********************** 是否静态化 **********************/
	public static final int NOT_STATIC = 0;
	public static final int IS_STATIC = 1;

	/********************** 是否置顶 **********************/
	public static final int NOT_TOP = 0;
	public static final int IS_TOP = 1;

	/********************** 新闻公告信息 **********************/
	public static final int NEWS_CATEGORY = 12;
	public static final int NOTICE_CATEGORY = 13;
	public static final int VIDEO_CATEGORY = 50;
	public static final int PIC_ENABLE = 1;
	public static final int PIC_DISABLE = 0;
	public static final int STARTUP_CATEGORY = 11; // 创业

	/********************** 就业信息 **********************/
	// 招聘信息类型
	public static final int CATEGORY_RECRUIT_TYPE = 1;
	public static final int CATEGORY_INTERN_TYPE = 2;

	/************************** 静态页跳转参数 *************************/
	public static final int NEWS_STATIC_TYPE = 1;
	public static final int EMPLOYMENT_STATIC_TYPE = 2;
	public static final int BIGFAIR_STATIC_TYPE = 3;
	public static final int JOBFAIR_STATIC_TYPE = 4;
	public static final int POSITION_STATIC_TYPE = 5;
	public static final int CULTURE_STATIC_TYPE = 8;

	/************************ 流程状态 ******************************/
	public static final Integer NO_SUBMIT = null;
	public static final int FLOW_START = 0; // 待审核
	public static final int PASS_TYPE = 1; // 审核通过
	public static final int NO_PASS_TYPE = 2; // 审核不通过
	public static final int REJECTED_TYPE = 3; // 驳回
	public static final int ONCE_PASS_TYPE = 4; // 第一次审核通过
	public static final int ONCE_NO_PASS_TYPE = 5; // 第一次审核不通过
	public static final int ONCE_REJECTED_TYPE = 6; // 第一次驳回
	public static final int FLOW_END = 99; // 流程结束

	/************************ 流程结果 ******************************/
	public static final int AUDIT_RESULT_NOPASS = 0; // 未通过
	public static final int AUDIT_RESULT_PASS = 1; // 通过

	public static final String GOING_TO_URL_KEY = "going_to_url_key";
	/************************ Banner分类 ******************************/
	public static final int BANNER_TYPE = 1;

	/************************ homePic分类 ******************************/
	public static final int HOMEPIC_TYPE = 0;

	public static final int NO = 0;
	public static final int YES = 1;

	public static final int REG_APPLY = 0; // 注册企业申请
	public static final int UNREG_APPLY = 1; // 未注册企业申请

	/************************ PAY TYPE分类 ******************************/
	public static final Integer PAY_REMITANCE = 0;
	public static final Integer PAY_CASH = 1;
	public static final Integer PAY_PRE = 2;

	/************************ file path ******************************/
	public static final String EMAIL_ATTACHMENT_PATH = "/email-attachment"; // 邮件附件路径
	public static final String TEMP_CONFIRM_FILE_PAHT = "/email-attachment/temp"; // 确认函临时存放路径

	public static final Double RESUME_PRICE = 5.00;

	/************************ target分类 ******************************/
	public static final Integer TARGET_UNIT = 1;
	public static final Integer TARGET_STUDENT = 2;

	/************************ category分类 ******************************/
	public static final Integer CATEGORY_NOTICE = 13;

	private Constants() {
	}

}
