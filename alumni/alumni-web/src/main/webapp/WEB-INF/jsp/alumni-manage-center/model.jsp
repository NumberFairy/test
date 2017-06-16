<!--

	校友管理中心--邮件通知
	czjia
	201704010
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                    <h4 class="modal-title" id="myModalLabel">
                        邮件通知
                    </h4>
                </div>
                <div class="modal-body">
                    <%--  --%>
                        <form id="baseForm" class="form-horizontal bv-form">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                            <span class="star">*</span>主题：
                        </label>
                                <div class="col-sm-8">
                                    <input id="title" name="title" placeholder="主题信息" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                            <span class="star">*</span>邮箱：
                        </label>
                                <div class="col-sm-8">
                                    <input id="emailAddress" name="emailAddress" placeholder="例如：xxx@163.com" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">
                            <span class="star">*</span>内容：
                        </label>
                                <div class="col-sm-8">
                                    <textarea id="emailContent" name="emailContent" placeholder="请输入通知内容" class="form-control" rows="7"></textarea>
                                </div>
                            </div>
                        </form>
                        <%--  --%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                    取消
                </button>
                    <button id="emailSubmit" class="btn btn-primary">
                    发送
                </button>
                </div>
            </div>
        </div>
    </div>