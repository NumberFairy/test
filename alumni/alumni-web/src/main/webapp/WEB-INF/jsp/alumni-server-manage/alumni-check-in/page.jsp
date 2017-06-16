<!--

	校友服务管理--校友登记
	czjia
    20170329
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
                                <h5>校友登记管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix">
                                    <div class="form-group marb">
                                        <label class="label-reset">登记类型：</label>
                                        <select id="enrollTypeContent" class="form-control select-reset">
                                            <s:iterator value="registerList">
                                                  <option value="">全部登记类型</option>
                                                <option value="${id}">${value}</option>
                                            </s:iterator>
                                        </select>
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">参与人：</label>
                                        <input id="peopleContent" class="form-control input-reset" placeholder="参与人关键字" type="text">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">地点：</label>
                                        <input id="placeContent" class="form-control input-reset" placeholder="地点关键字" type="text">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">内容：</label>
                                        <input id="contentContent" placeholder="内容关键字" type="text" class="form-control input-reset">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">开始时间：</label>
                                        <input id="startTimeContent" placeholder="开始时间" type="text" class="form-control form_date input-reset">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">结束时间：</label>
                                        <input id="endTimeContent" placeholder="结束时间" type="text" class="form-control form_date input-reset">
                                    </div>
                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="btn-search">查 询</button>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <a href="/alumni-enroll!hrefAddOrUpdate" class="btn btn-sm btn-info marl">新 增</a>
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
                                                登记类型
                                            </th>
                                            <th>
                                                参与人
                                            </th>
                                            <th>
                                                开始时间
                                            </th>
                                            <th>
                                                结束时间
                                            </th>
                                            <th>
                                                地点
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
                    <td>{{value.enrollTypeName}}</td>
                    <td>
                        <div class="ellipsis">{{value.people}}</div>
                    </td>
                    <td>{{value.startTime}}</td>
                    <td>{{value.endTime}}</td>
                    <td>{{value.place}}</td>
                </tr>
                {{/each}}
            </script>
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-server-manage/alumni-check-in/page.js"></script>

            </html>