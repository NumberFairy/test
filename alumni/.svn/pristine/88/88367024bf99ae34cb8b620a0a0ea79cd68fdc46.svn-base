<!--

	门户菜单管理--信息发布管理
	zxguan
	20170408
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
                                <h5>信息发布管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">标题：</label>
                                        <input placeholder="标题" class="form-control input-reset" name="entity.title">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">发布人：</label>
                                        <input placeholder="发布人" class="form-control input-reset" name="entity.publisher">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">是否启用：</label>
                                        <select class="form-control select-reset" name="entity.isEnable">
                                            <option value="-1">全部</option>
                                            <option value="1">是</option>
                                            <option value="0">否</option>
                                        </select>
                                    </div>
                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="btn-search">查 询</button>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <div class="pull-left">
                                        <a href="/home-information-release!hrefAddOrUpdate" class="btn btn-sm btn-info marl">新 增</a>
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
                                                标题
                                            </th>
                                            <th>
                                                发布人
                                            </th>
                                            <th>
                                                是否启用
                                            </th>
                                            <th>
                                                是否置顶
                                            </th>
                                            <th>
                                                浏览次数
                                            </th>
                                            <th hidden>
                                                来源
                                            </th>
                                            <th>
                                                创建时间
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
                    <td>{{value.title}}</td>
                    <td>{{value.publisher}}</td>
                    <td>{{value.isEnableStr}}</td>
                    <td>{{value.isTopStr}}</td>
                    <td>{{value.viewCount}}</td>
                    <td hidden>{{value.source}}</td>
                    <td>{{value.createTime}}</td>
                </tr>
                {{/each}}
            </script>
            <script type="text/javascript" src="${contentPath}/resources/js/gateway-menu-manage/home-information-release/page.js"></script>

            </html>