<!--

	门户菜单管理--友情链接信息管理
	zxguan
	20170413
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
                                <h5>友情链接信息管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form id="form" class="form-horizontal clearfix">
                                    <div class="input-group col-sm-4">
                                        <input name="entity.name" placeholder="请输入链接名称" type="text" class="form-control">
                                        <span class="input-group-btn">
                                        <button type="button" id="btn-search" class="btn btn-info">查询</button>
                                    </span>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <div class="pull-left">
                                        <a href="/home-friendship-link!hrefAddOrUpdate" class="btn btn-sm btn-info marl">新 增</a>
                                        <button type="button" id="btn-update" class="btn btn-sm btn-info marl">编 辑</button>
                                        <button type="button" id="btn-delete" class="btn btn-sm btn-info marl">删 除</button>
                                    </div>
                                </div>
                                <table class="table  table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>
                                                链接名称
                                            </th>
                                            <th>
                                                链接地址
                                            </th>
                                            <th>
                                                排序字段
                                            </th>
                                            <th>
                                                是否启用
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
                        <input type="checkbox" class="child" value="{{value.id}}" data-id="{{value.branchId}}">
                    </td>
                    <td>{{value.name}}</td>
                    <td>{{value.linkUrl}}</td>
                    <td>{{value.sortFlag}}</td>
                    <td>{{value.isEnable}}</td>
                </tr>
                {{/each}}
            </script>
            <script type="text/javascript" src="${contentPath}/resources/js/gateway-menu-manage/friendship-link-information/page.js"></script>

            </html>