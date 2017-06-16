<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        <style>
            .grayOperation {
                border-color: transparent;
                cursor: Auto;
            }
            
            .grayOperation:hover {
                border-color: transparent;
            }
            
            .grayOperation:focus,
            .grayOperation:active,
            .grayOperation,
            .grayOperation:hover {
                background: #b9b9b9;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>校友活动审核</h5>
                            </div>
                            <div class="ibox-content">
                                <form id="form" class="form-horizontal clearfix">
                                    <div class="input-group col-sm-4">
                                        <input placeholder="请输入活动名称" type="text" class="form-control" name="entity.title">
                                        <span class="input-group-btn">
                                            <button type="button" id="btn-search" class="btn btn-info">查询</button>
                                        </span>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <button type="button" id="detail" class="btn btn-sm btn-info">查 看</button>
                                </div>
                                <table class="table  table-bordered table-hover content">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>标题</th>
                                            <th>申请人</th>
                                            <th>开始时间</th>
                                            <th>结束时间</th>
                                            <th>申请时间</th>
                                            <th>审核人</th>
                                            <th>审核状态</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="gridBody">
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
            <script type="text/javascript" src="${contentPath}\resources\js\flow-audit\activity-audit\page.js"></script>
            <script type="text/html" id="gridTpl">
                {{each results as value}}
                <tr>
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{value.id}}">
                    </td>
                    <td>
                        {{value.title}}
                    </td>
                    <td>
                        {{value.person}}
                    </td>
                    <td>
                        {{value.startTime}}
                    </td>
                    <td>
                        {{value.endTime}}
                    </td>
                    <td>
                        {{value.createTime}}
                    </td>
                    <td>
                        {{value.auditor}}
                    </td>
                    {{if !value.status||value.status==0}}
                    <td>待审核</td>
                    {{else if value.status==1}}
                    <td>审核通过</td>
                    {{else}}
                    <td>审核未通过</td>

                    {{/if}} {{if !value.status||value.status==0}}
                    <td>
                        <a href="javascript:;" id="auditId" class="btn  btn-success mar0 btn-xs" data-id="{{value.id}}" data-status="1">
						通过
					</a>
                        <a href="javascript:;" id="auditId" class="btn  btn-danger mar0 btn-xs" data-id="{{value.id}}" data-status="2">
						不通过
					</a>
                    </td>
                    {{else}}
                    <td id="grayOperation">
                        <b class="btn  btn-success mar0 btn-xs grayOperation"> 
                            通过
                        </b>
                        <b class="btn  btn-success mar0 btn-xs grayOperation"> 
                            不通过
                        </b>
                    </td>
                    {{/if}}
                </tr>
                {{/each}}
            </script>

            </html>