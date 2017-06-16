<!--

	校友服务管理--校友通知模板管理
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
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>校友通知模板管理</h5>
                            <div class="ibox-tools">
                                <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                    <i class="fa fa-reply"></i>&nbsp;返 回
                                </a>
                               
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="clearfix">
                                <a href="/notice-template!hrefAddOrUpdate" class="btn btn-sm btn-info marl">新 增</a>
                                <button type="button" id="btn-detail" class="btn btn-sm btn-info marl">查 看</button>
                                <button type="button" id="btn-update" class="btn btn-sm btn-info marl">编 辑</button>
                                <button type="button" id="btn-delete" class="btn btn-sm btn-info marl">删 除</button>
                            </div>
                            <table class="table  table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th class="bs-checkbox" style="width:36px;">
                                            <input type="checkbox" class="check-all">
                                        </th>
                                        <th>
                                            主题
                                        </th>
                                        <th>
                                            创建人
                                        </th>
                                        <th>
                                            内容
                                        </th>
                                    </tr>
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
<script type="text/html" id="gridTpl">
    {{each results as value index}}
    <tr id="{{value.id}}">
        <td class="bs-checkbox" style="width:36px;">
            <input type="checkbox" class="child" value="{{value.id}}">
        </td>
        <td>{{value.title}}</td>
        <td>{{value.person}}</td>
        <td>{{value.content}}</td>
    </tr>
    {{/each}}
</script>
<script type="text/javascript" src="${contentPath}/resources/js/alumni-server-manage/alumni-notice-manage/template.js"></script>
</html>
