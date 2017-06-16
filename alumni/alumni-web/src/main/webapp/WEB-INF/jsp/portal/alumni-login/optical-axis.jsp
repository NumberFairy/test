<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        <link href="${contextPath}/resources/css/plugins/style.css" rel="stylesheet">
        <style>
            .main-form {
                padding: 0;
            }
            
            .btn-primary {
                background-color: #337ab7;
                border-color: #2e6da4;
            }
            
            .ibox-title {
                text-align: right;
            }
            
            .btn-primary:hover,
            .btn-primary:visited,
            .btn-primary:activ {
                background-color: #286090;
                border-color: #204d74;
            }
            
            .navy-bg {
                background: #74a9f7;
            }
            
            .modal-dialog {
                left: 50%;
                margin-left: -300px;
            }
        </style>
        </head>

        <body>
            <%@include file="menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <div class="ibox-title">
                        <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增</button>
                    </div>
                    <div id="vertical-timeline" class="vertical-container light-timeline">
                        <div id="gridBodyEvent">
                            <div class="vertical-timeline-block">
                                <div class="vertical-timeline-icon navy-bg">
                                    <i class="fa fa-dot-circle-o" style="margin-top:-7px;"></i>
                                </div>
                                <div class="vertical-timeline-content">
                                    <h2>王老师被评选为杰出校友</h2>
                                    <p>王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友</p>
                                    <button class="btn btn-info btn-xs marl" type="button"><i class="fa fa-check"></i>&nbsp;移除</button>
                                    <button class="btn btn-success btn-xs marl" type="button" style="margin-right:15px;"><i class="fa fa-paste"></i>&nbsp;编辑</button>
                                    <span class="vertical-date">
                                        <small>2017-04-24 16:01:37</small>
                                    </span>
                                </div>
                            </div>
                            <div class="vertical-timeline-block">
                                <div class="vertical-timeline-icon navy-bg">
                                    <i class="fa fa-dot-circle-o" style="margin-top:-7px;"></i>
                                </div>
                                <div class="vertical-timeline-content">
                                    <h2>王老师被评选为杰出校友</h2>
                                    <p>王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友王老师被评选为杰出校友</p>
                                    <button class="btn btn-info btn-xs marl" type="button"><i class="fa fa-check"></i>&nbsp;移除</button>
                                    <button class="btn btn-success btn-xs marl" type="button" style="margin-right:15px;"><i class="fa fa-paste"></i>&nbsp;编辑</button>
                                    <span class="vertical-date">
                                        <small>2017-04-24 16:01:37</small>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--内容部分end-->
                <!--新增modal-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width:600px;">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    校友成长时光轴
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form id="baseForm" class="form-horizontal bv-form">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                                <span class="star">*</span>标题：
                                            </label>
                                        <div class="col-sm-8">
                                            <input id="title" name="title" placeholder="请输入标题" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                                <span class="star">*</span>内容：
                                            </label>
                                        <div class="col-sm-8">
                                            <textarea id="emailContent" name="emailContent" placeholder="请输入内容" class="form-control" rows="7"></textarea>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">
                                    取消
                                </button>
                                <button id="emailSubmit" class="btn btn-primary">
                                    确定
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <!---->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>

        </html>