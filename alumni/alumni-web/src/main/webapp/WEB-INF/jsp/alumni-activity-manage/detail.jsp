<!--

	校友活动管理--校友活动
	pfhu
	201703029
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        <style>
            .activity-content img {
                max-width: 100%;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-lg-10 col-lg-offset-1">
                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>校友活动管理--详情</h5>
                                <div class="ibox-tools">
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="baseInfoForm">
                                        <input type="hidden" name="entity.id" value="${id}">
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                                标题:
                                            </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.title}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                                发布人:
                                            </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.applicyPerson}</p>
                                            </div>
                                        </div>
                                        <div class="form-group" style="display: none;">
                                            <label class="col-sm-4 control-label">
                                                来源:
                                            </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.laiYuan}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                            活动地点:
                                        </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.place}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                              是否启用:
                                          </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.isQiYongName}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                              是否置顶:
                                          </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.isTopName}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                                是否允许报名:
                                            </label>
                                            <div class="col-sm-8">
                                                <p class="form-control-static">${entity.isSignUpName}</p>
                                            </div>
                                        </div>
                                        <div id="isTimeHide">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">
                                                活动开始时间:
                                                </label>
                                                <div class="col-sm-8">
                                                    <p class="form-control-static">${entity.startTime}</p>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">
                                                   活动结束时间:
                                                </label>
                                                <div class="col-sm-8">
                                                    <p class="form-control-static">${entity.endTime}</p>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">
                                                   报名开始时间:
                                                </label>
                                                <div class="col-sm-8">
                                                    <p class="form-control-static">${entity.applyStartTime}</p>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">
                                                   报名结束时间:
                                                </label>
                                                <div class="col-sm-8">
                                                    <p class="form-control-static">${entity.applyEndTime}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 control-label">
                                                内容:
                                            </label>
                                            <div class="col-sm-8 activity-content">
                                                <p class="form-control-static">
                                                    ${entity.content}
                                                </p>
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
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-activity-manage/page.js"></script>
            <script>
                if ('${entity.isSignUp}' == '1') {
                    $('#isTimeHide').show();
                } else {
                    $('#isTimeHide').hide();
                }
            </script>

            </html>