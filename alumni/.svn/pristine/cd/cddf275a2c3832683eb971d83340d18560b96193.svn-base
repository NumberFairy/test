package com.wisdombud.alumni.vo;

public class CommonResult {
	public static final boolean FAIL = false;
	public static final String FAIL_INFO = "操作失败";
	public static final boolean SUCCESS = true;
	public static final String SUCCESS_INFO = "操作成功";
	protected boolean success;
	protected String info;
	protected String extraMsg;
	protected String redirectUrl;

	public CommonResult() {
	}

	public CommonResult(boolean success) {
		this.success = success;
		this.info = success == SUCCESS ? SUCCESS_INFO : FAIL_INFO;
	}

	public CommonResult(boolean success, String info) {
		this.success = success;
		this.info = info;
	}

	public CommonResult(boolean success, String info, String extraMsg) {
		this.success = success;
		this.info = info;
		this.extraMsg = extraMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getExtraMsg() {
		return extraMsg;
	}

	public void setExtraMsg(String extraMsg) {
		this.extraMsg = extraMsg;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	@Override
	public String toString() {
		return "CommonResult [success=" + success + ", info=" + info + ", extraMsg=" + extraMsg + "]";
	}
}
