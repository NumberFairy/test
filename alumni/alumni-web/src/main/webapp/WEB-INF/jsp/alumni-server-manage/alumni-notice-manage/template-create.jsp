<!--

	校友服务管理--校友通知模板管理
	czjia
	201703031
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
                            <h5>校友通知模板管理</h5>
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
                                        <input type="hidden" name="entity.id" value="${id}">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span>
                                            主题：
                                        </label>
                                        <div class="col-sm-6">
                                            <input type="text" name="entity.title" value="${entity.title}" placeholder="请输入主题" class="form-control">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span>
                                            内容：
                                        </label>
                                        <div class="col-sm-6">
                                            <!--TODO:改为富文本框-->
                                            <input type="text" name="entity.content" value="${entity.content}" placeholder="请输入内容" class="form-control">
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
<script type="text/javascript" src="${contentPath}/resources/js/alumni-server-manage/alumni-notice-manage/template-create.js"></script>
</html>