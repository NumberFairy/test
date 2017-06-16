<!--

	校友服务管理--校友通知
	czjia
	20170331
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
    <title>校友管理及分析系统</title>
    </head>
    <body class="gray-bg">
        <div class="wrapper wrapper-content  animated fadeInRight">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>校友通知管理</h5>
                            <div class="ibox-tools">
                                 <a class="btn  btn-sm btn-info" type="button" id="btn-submit">
                                <i class="fa fa-check"></i>&nbsp;提 交
                                </a>
                                <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                    <i class="fa fa-reply"></i>&nbsp;返 回
                                </a>
                               
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="m-t">
                                <form class="form-horizontal" id="form-all">
                                    <div class="form-group">
                                        <input type="hidden" id="id" name="entity.id" value="${id}">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span>
                                            名称：
                                        </label>
                                        <div class="col-sm-6">
                                            <input type="text" name="entity.noticeTitle" value="${entity.noticeTitle}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 通知类型：
                                        </label>
                                        <div class="col-sm-6">
                                            <select name="entity.noticeType"  class="form-control">
                                                <s:iterator value="noticeTypeList">
                                                    <s:if test = "entity.noticeType == id">
                                                        <option value="${id}" selected>${value}</option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${id}">${value}</option>
                                                    </s:else>
                                                </s:iterator>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 通知方式：
                                        </label>
                                        <div class="col-sm-6">
                                            <select name="entity.noticeMode"  class="form-control">
                                                <s:iterator value="noticePatternList">
                                                    <s:if test = "entity.noticeMode == id">
                                                        <option value="${id}" selected>${value}</option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${id}">${value}</option>
                                                    </s:else>
                                                </s:iterator>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 通知模板：
                                        </label>
                                        <div class="col-sm-6">
                                            <select name="entity.noticeTemplate"  class="form-control">
                                                <s:iterator value="noticeTemplateList">
                                                    <s:if test = "entity.noticeTemplate == id">
                                                        <option value="${id}" selected>${title}</option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${id}">${title}</option>
                                                    </s:else>
                                                </s:iterator>
                                            </select>
                                        </div>
                                    </div>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script type="text/javascript" src="${contentPath}/resources/js/alumni-server-manage/alumni-notice-manage/create.js"></script>
</html>