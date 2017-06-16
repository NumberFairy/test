<!--

	校友活动管理--报名情况
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
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>校友活动管理--报名情况</h5>
                                <div class="ibox-tools">
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal clearfix">
                                     <input id="signUpId" type="hidden" name="signUpId" value="${signUpId}">
                                </form>
                                <table class="table  table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>
                                                姓名
                                            </th>
                                            <th>
                                                性别
                                            </th>
                                            <th>
                                                身份
                                            </th>
                                            <th>
                                                入学年份/入职年份
                                            </th>
                                            <th>
                                                院系
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                    </thead>
                                    <tbody id="gridBody">
                                        <!-- content -->
                                    </tbody>
                                </table>
                                <div align="right">
                                    <ul class="pagination" id="pageUl">
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-activity-manage/sign-up-page.js"></script>
            <script type="text/html" id="gridTpl">
                {{each results as value index}}
                <tr id="{{value.id}}">
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{value.id}}">
                    </td>
                    <td>{{value.alumniName}}</td>
                    <td>{{value.genderName}}</td>
                    <td>{{value.identityName}}</td>
                    <td>{{value.enrollYear}}</td>
                    <td>{{value.collegeName}}</td>
                    <td>
                        <a href="javascript:;" data-id="{{value.id}}" class="btn btn-warning btn-xs mar0 btn-sign-up-detail">
                            <i class="fa fa-list"></i> 查看详情
                        </a>
                    </td>
                </tr>
                {{/each}}
            </script>

            </html>