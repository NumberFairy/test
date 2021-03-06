<!--

	校友活动管理--校友活动
	pfhu
	201703029
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
                                <h5>校友活动管理</h5>
                                <div class="ibox-tools">
                                    <button class="btn  btn-sm btn-info" type="button" id="btn-submit">
                                <i class="fa fa-check"></i>&nbsp;提 交
                                    </button>
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>

                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="form-all">
                                        <input type="hidden" name="entity.id" value="${entity.id}">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 活动主题:
                                        </label>
                                            <div class="col-sm-6">
                                                <input type="text" name="entity.title" value="${entity.title}" placeholder="请输入" class="form-control">
                                            </div>
                                        </div>
                                    
                                        <div class="form-group" style="display: none;">
                                            <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 来源:
                                        </label>
                                            <div class="col-sm-6">
                                                <input type="text" name="entity.laiYuan" value="${entity.laiYuan}" placeholder="请输入" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 活动地点:
                                        </label>
                                            <div class="col-sm-6">
                                                <input type="text" name="entity.place" value="${entity.place}" placeholder="请输入" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                              <span class="star">*</span> 是否启用:
                                          </label>
                                            <div class="col-sm-8">
                                                <div class="checkbox checkbox-success checkbox-inline">
                                                    <input type="radio" id="ordinaryIsQiYong" name="entity.isQiYong" value="1" <c:if test="${entity.isQiYong==1}">checked</c:if> >
                                                    <label for="ordinaryIsQiYong">是</label>
                                                </div>
                                                <div class="checkbox checkbox-success checkbox-inline">
                                                    <input type="radio" id="specialIsQiYong" name="entity.isQiYong" value="0" <c:if test="${entity==null||entity.isQiYong==0}">checked</c:if>>
                                                    <label for="specialIsQiYong">否</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                              <span class="star">*</span> 是否置顶:
                                          </label>
                                            <div class="col-sm-8">
                                                <div class="checkbox checkbox-success checkbox-inline">
                                                    <input type="radio" id="ordinaryTop" name="entity.isTop" value="1" <c:if test="${entity.isTop==1}">checked</c:if>
                                                    >
                                                    <label for="ordinaryTop">是</label>
                                                </div>
                                                <div class="checkbox checkbox-success checkbox-inline">
                                                    <input type="radio" id="specialTop" name="entity.isTop" value="0" <c:if test="${entity==null||entity.isTop==0}">checked</c:if>
                                                    >
                                                    <label for="specialTop">否</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                              <span class="star">*</span> 是否允许报名:
                                          </label>
                                            <div class="col-sm-8">
                                                <div class="checkbox checkbox-success checkbox-inline">
                                                    <input type="radio" id="ordinarySignUp" name="entity.isSignUp" value="1" <c:if test="${entity.isSignUp==1}">checked</c:if>>
                                                    <label for="ordinarySignUp">是</label>
                                                </div>
                                                <div class="checkbox checkbox-success checkbox-inline">
                                                    <input type="radio" id="specialSignUp" name="entity.isSignUp" value="0" <c:if test="${entity==null||entity.isSignUp==0}">checked</c:if>>
                                                    <label for="specialSignUp">否</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="isTimeHide">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 活动开始时间:
                                        </label>
                                                <div class="col-sm-6 ">
                                                    <input name="entity.startTime" value="${entity.startTime}" placeholder="活动开始时间" class="form-control form_time">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 活动结束时间:
                                        </label>
                                                <div class="col-sm-6 ">
                                                    <input name="entity.endTime" value="${entity.endTime}" placeholder="活动结束时间" class="form-control form_time">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 报名开始时间:
                                        </label>
                                                <div class="col-sm-6 ">
                                                    <input name="entity.applyStartTime" value="${entity.applyStartTime}" placeholder="报名开始时间" class="form-control form_time">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 报名结束时间:
                                        </label>
                                                <div class="col-sm-6 ">
                                                    <input name="entity.applyEndTime" value="${entity.applyEndTime}" placeholder="报名结束时间" class="form-control form_time">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 内容:
                                        </label>
                                            <div class="col-sm-9">
                                                    <!--<textarea id="editor_id" name="entity.content">${entity.content}</textarea>-->
                                                    <script id="editor_id" name="entity.content" type="text/plain">${entity.content}</script>
                                            </div>
                                        </div>
                                        <div class="hr-line-dashed"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
        <!-- 配置文件 -->
        <script type="text/javascript" src="${contextPath}/js-lib/UEditor/ueditor.config.js"></script>
        <!-- 编辑器源码文件 -->
        <script type="text/javascript" src="${contextPath}/js-lib/UEditor/ueditor.all.js"></script>
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-activity-manage/create.js"></script>
            <!--<script type="text/javascript" src="${contextPath}/js-lib/kindeditor-4.1.10/kindeditor.js"></script>-->
            <script>
                if ('${entity.isSignUp}' == '1') {
                    $('#isTimeHide').show();
                } else {
                    $('#isTimeHide').hide();
                }
            </script>

            </html>