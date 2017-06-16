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
                                <h5>校友工作大事记</h5>
                                <div class="ibox-tools">
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">标题 ：</label>
                                        <input placeholder="标题" class="form-control input-reset" name="entity.eventTitle">
                                    </div>

                                    <div class="form-group marb">
                                        <label class="label-reset">内容 ：</label>
                                        <input placeholder="内容" class="form-control input-reset" name="entity.eventContent">
                                    </div>

                                    <div class="form-group marb">
                                        <label class="label-reset">时间 ：</label>
                                        <input placeholder="时间" class="form-control form_date input-reset marl" name="entity.eventTime">
                                    </div>

                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="search">查 询</button>
                                    </div>
                                </form>


                                <div class="clearfix">
                                    <button id="addEvent" type="button" class="btn btn-sm btn-info marl">新 增</button>
                                    <button id="detail" type="button" class="btn btn-sm btn-info marl">查 看</button>
                                    <button id="alert" type="button" class="btn btn-sm btn-info marl">编 辑</button>
                                    <button id="delete" type="button" class="btn btn-sm btn-info marl">删 除</button>
                                    <button id="export" type="button" class="btn btn-sm btn-info marl">导出全部</button>
                                </div>
                                <table class="table  table-bordered table-hover content">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th width="20%">
                                                标题
                                            </th>
                                            <th>
                                                时间
                                            </th>
                                            <th width="50%">
                                                内容
                                            </th>
                                            <!--<th>
                                                状态
                                            </th>-->
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
            <!--备忘录modal-->
            <div aria-hidden="true" aria-labelledby="myModal" role="dialog" tabindex="-1" id="eventModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body" id="add-event">

                        </div>
                        <div class="modal-footer">
                            <button id="saveEvent" type="button" class="btn btn-info">确定</button>
                            <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
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
                    <td>{{value.eventTitle}}</td>
                    <td>{{value.eventTime}}</td>
                    <td>{{value.eventContent}}</td>
                </tr>
                {{/each}}
            </script>
            <script type="text/javascript" src="${contentPath}/resources/js/event/page.js"></script>
            <script type="text/html" id="tpl-event">
                <form id="eventForm" class="form-horizontal bv-form">
                    <!--<input type="hidden" name="index" value="{{index}}">-->
                    <div class="form-group">
                        <input id="eventId" name="entity.id" value="{{id}}" type="hidden">
                        <label class="col-sm-3 control-label">
                            标题：
                        </label>
                        <div class="col-sm-8 lineFeed">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{eventTitle}}</p>
                            {{else}}
                            <input type="text" name="entity.eventTitle" value="{{eventTitle}}" placeholder="请输入标题" class="form-control"> {{/if}}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            录入时间：
                        </label>
                        <div class="col-sm-8">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{eventTime}}</p>
                            {{else}}
                            <input type="text" name="entity.eventTime" value="{{eventTime}}" placeholder="请选择录入时间" class="form-control form_time"> {{/if}}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            大事件内容：
                        </label>
                        <div class="col-sm-8 lineFeed">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{eventContent}}</p>
                            {{else}}
                            <textarea rows="7" cols="30" name="entity.eventContent" placeholder="请输入备忘内容" class="form-control">{{eventContent}}</textarea>{{/if}}
                            <!--<input type="text" name="entity.eventContent" value="{{eventContent}}" placeholder="请输入备忘内容" class="form-control">-->
                        </div>
                    </div>
                </form>
            </script>

            </html>