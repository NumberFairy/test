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
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>校友活动</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">标题：</label>
                                        <input placeholder="标题" class="form-control input-reset" name="entity.title">
                                    </div>
                                    <div class="form-group marb hidden">
                                        <label class="label-reset">申请人：</label>
                                        <input placeholder="申请人" class="form-control input-reset" name="entity.person">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">是否启用：</label>
                                        <select class="form-control select-reset" name="entity.isQiYong">
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
                                    <button type="button" id="update" class="btn btn-sm btn-info marl">新 增</a>
                                    <button type="button" id="btn-detail" class="btn btn-sm btn-info marl">查 看</button>
                                    <button type="button" id="btn-update" class="btn btn-sm btn-info marl">编 辑</button>
                                    <button type="button" id="btn-remove" class="btn btn-sm btn-info marl">删 除</button>
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
                                            <!--<th>
                                                申请人
                                            </th>-->
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
                                                开始时间
                                            </th>
                                            <th>
                                                结束时间
                                            </th>
                                            <th>
                                                创建时间
                                            </th>
                                            <th>
                                                操作
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
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-activity-manage/page.js"></script>
            <script type="text/html" id="gridTpl">
                {{each results as value index}}
                <tr id="{{value.id}}">
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{value.id}}">
                    </td>
                    <td>{{value.title}}</td>
                    <td>{{value.personName}}</td>
                    <td>{{value.isQiYongName}}</td>
                    <td>{{value.isTopName}}</td>
                    <td>{{value.startTime}}</td>
                    <td>{{value.endTime}}</td>
                    <td>{{value.createTime}}</td>
                    <td>
                        <a href="javascript:;" data-id="{{value.id}}" class="btn btn-success btn-xs mar0 success  btn-apply">
                            <i class="fa fa-list"></i> 查看报名
                        </a>
                    </td>
                </tr>
                {{/each}}
            </script>

            </html>