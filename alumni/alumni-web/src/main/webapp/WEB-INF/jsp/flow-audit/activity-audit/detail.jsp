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
                                <h5>查看</h5>
                                <div class="ibox-tools">
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:;" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal bv-form">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                                活动主题：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">${entity.title}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                                申请人：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">${entity.person}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                                活动地点：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">${entity.place}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">
                                                内容：
                                            </label>
                                            <div class="col-sm-7 activity-content">
                                                <p class="form-control-static">${entity.content}</p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-3">
                                                活动开始时间：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">
                                                    <s:date name="entity.startTime" format="yyyy-MM-dd HH:mm:ss" />
                                                </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-3">
                                                活动结束时间：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">
                                                    <s:date name="entity.endTime" format="yyyy-MM-dd HH:mm:ss" />
                                                </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-3">
                                               报名开始时间：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">
                                                    <s:date name="entity.applyStartTime" format="yyyy-MM-dd HH:mm:ss" />
                                                </p>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-3">
                                                报名结束时间：
                                            </label>
                                            <div class="col-sm-7">
                                                <p class="form-control-static">
                                                    <s:date name="entity.applyEndTime" format="yyyy-MM-dd HH:mm:ss" />
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

            </html>