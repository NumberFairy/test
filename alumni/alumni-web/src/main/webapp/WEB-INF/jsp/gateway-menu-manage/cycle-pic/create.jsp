<!--

	门户菜单管理--微信轮播图片管理
	zxguan
	20170413
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        <link href="${contentPath}/js-lib/kindeditor-4.1.10/themes/default/default.css" rel="stylesheet">
        <link href="${contextPath}/js-lib/chosen/chosen.css" type="text/css" rel="stylesheet" />
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-lg-10 col-lg-offset-1">
                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>轮播图片管理</h5>
                                <div class="ibox-tools">
                                    <button class="btn  btn-sm b   tn-info" type="button" id="btn-submit"> <i class="fa fa-check"></i>&nbsp;提 交 </button>
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:;" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="baseInfoForm">
                                        <input type="hidden" name="entity.id" value="${entity.id}">
                                        <input type="hidden" name="entity.type" value="${type}">
                                        <div class="clearfix">
                                            <div id="div-type" class="form-group">
                                                <label class="col-sm-3 control-label">
                                           <span class="star">*</span> 图片名称:
                                       </label>
                                                <div class="col-sm-6">
                                                    <input type="text" name="entity.title" value="${entity.title}" placeholder="请输入图片名称" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
                                       <span class="star">*</span> 附件名称:
                                   </label>
                                                <div class="col-sm-6">
                                                    <input id="file-id" name="entity.picId" type="hidden" value="${entity.picId}" class="form-control">
                                                    <input id="upload" name="upload" type="file" class="hidden">
                                                    <input id="text" type="text" name="entity.picName" value="${entity.picName}" class="form-control" readonly>
                                                    <input id="btnUpLoad" value="上传图片" class="btn btn-sm btn-info mart marb" type="button">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
													<span class="star">*</span> 指向链接:
												</label>
                                                <div class="col-sm-6">
                                                    <input type="text" name="entity.linkUrl" value="${entity.linkUrl}" placeholder="请输入指向链接" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
													<span class="star">*</span> 显示位置:
												</label>
                                                <div class="col-sm-6" style="padding-left:0;">
                                                    <div class="checkbox checkbox-success checkbox-inline">
                                                        <input type="radio" id="isPCYes" name="entity.isPc" value="1" <s:if test="null == entity || entity.isPc == null || entity.isPc == 1">checked</s:if>
                                                        >
                                                        <label for="isPCYes">门户</label>
                                                    </div>
                                                    <div class="checkbox checkbox-success checkbox-inline">
                                                        <input type="radio" id="isPCNo" name="entity.isPc" value="0" <s:if test="entity.isPc == 0">checked</s:if>
                                                        >
                                                        <label for="isPCNo">微信</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
	                                            <span class="star">*</span> 是否显示:
	                                       </label>
                                                <div class="col-sm-6" style="padding-left:0;">
                                                    <div class="checkbox checkbox-success checkbox-inline">
                                                        <input type="radio" id="isEnableYes" name="entity.picState" value="1" <s:if test="null == entity || entity.picState == null || entity.picState == 1">checked</s:if>
                                                        >
                                                        <label for="isEnableYes">是</label>
                                                    </div>
                                                    <div class="checkbox checkbox-success checkbox-inline">
                                                        <input type="radio" id="isEnableNo" name="entity.picState" value="0" <s:if test="entity.picState == 0">checked</s:if>
                                                        >
                                                        <label for="isEnableNo">否</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
	                                         <span class="star"></span> 排序字段:
	                                     </label>
                                                <div class="col-sm-6">
                                                    <input type="text" name="entity.sortFlag" value="${entity.sortFlag}" placeholder="请输入排序字段" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
                                                    <span class="star"></span> 正文介绍:
                                                </label>
                                                <div class="col-sm-6">
                                                    <textarea class="form-control" name="entity.intro" rows="5">${entity.intro}</textarea>
                                                </div>
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
            <script type="text/javascript" src="${contextPath}/js-lib/kindeditor-4.1.10/kindeditor.js"></script>
            <script type="text/javascript" src="${contextPath}/js-lib/chosen/chosen.jquery.js"></script>
            <script type="text/javascript" src="${contentPath}/resources/js/gateway-menu-manage/cycle-pic/create.js"></script>
            <script>
                var id = '${id }';
            </script>

            </html>