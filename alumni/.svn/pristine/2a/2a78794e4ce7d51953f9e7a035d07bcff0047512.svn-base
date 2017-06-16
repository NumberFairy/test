<!--

	校友会管理--分会管理
	zxguan
	201703028
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
                                <h5>${typeStr}管理</h5>
                                <div class="ibox-tools">
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:;" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="baseInfoForm">
                                        <div class="clearfix">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                           	校友会名称：
		                                        	</label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.name }</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
														所在地：
													</label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.address }</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
														简介：
													</label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.introduction }</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
													微信号：
													</label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.wechatId }</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
														邮箱：
													</label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.email }</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
														成立时间：
													</label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.establishedTime }</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <fieldset>分会领导</fieldset>
                                        <div class="hr-line-dashed"></div>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>
                                                            姓名
                                                        </th>
                                                        <th>
                                                            任职身份
                                                        </th>
                                                        <th>
                                                            联系电话
                                                        </th>
                                                        <th>
                                                            邮箱
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody id="gridBody">
                                                    <s:iterator value="staffList">
                                                        <tr>
                                                            <td>${name }</td>
                                                            <td>${staffStr }</td>
                                                            <td>${phone }</td>
                                                            <td>${email }</td>
                                                        </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
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
            <script>
                var id = '${id }';
                var type = '${type }';
                var typeStr = '${typeStr }';
            </script>

            </html>