<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        <style type="text/css">
            .content {
                table-layout: fixed;
            }
            
            .content td {
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }
            
            .lineFeed {
                word-wrap: break-word;
                word-break: break-all;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5 class="pull-left">提醒事件</h5>
                                <a class="btn  btn-default marr  btn-sm pull-right" href="javascript:void(0);" onclick="window.history.back();">
                                    <i class="fa fa-reply"></i>&nbsp;返 回
                                </a>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">提醒事项 ：</label>
                                        <input placeholder="提醒事项" class="form-control" name="entity.title">
                                    </div>
                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="reach">查 询</button>
                                    </div>
                                </form>
                                <table class="table  table-bordered table-hover content">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>提醒类型</th>
                                            <th>提醒时间</th>
                                            <th>提醒事项</th>
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
            <script type="text/javascript">
                loadData();
                $('#search').click(function() {
                    loadData();
                })

                function loadData() {
                    var options = {
                        url: "/my-desk!pageRemind",
                        queryParams: {
                            'key': $('#seText').val()
                        }
                    };
                    loadPaginationData(options);
                }
            </script>
            <!-- 提醒事件 -->
            <script type="text/html" id="gridTpl">
                <tr>
                    {{each results as v}}
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{v.id}}">
                    </td>
                    <td>{{if v.type==1}} 活动提醒{{else}}生日提醒{{/if}}</td>
                    <td>{{v.title}}</td>
                    <td>{{v.time | dateFormat:'yyyy-MM-dd'}}</td>
                </tr>
                {{/each}}
            </script>

            </html>