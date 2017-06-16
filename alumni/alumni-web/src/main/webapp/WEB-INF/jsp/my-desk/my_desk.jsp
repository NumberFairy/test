<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        <style type="text/css">
            .lineFeed {
                word-wrap: break-word;
                word-break: break-all;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <!--提醒-->
                <div class="row">
                    <div class="col-sm-7">
                        <div class=" ibox float-e-margins ">
                            <div class="ibox-title ">
                                <h5 style="color:#d9534f; "><i class="fa fa-bell "></i> 提醒</h5>
                                <button id="remindMore" class="btn btn-sm btn-info marl marb  pull-right" type="button">
                            更多
                        </button>
                            </div>
                            <div class="ibox-content ">
                                <table class="table ">
                                    <thead>
                                        <tr>
                                            <th>提醒类型</th>
                                            <th>提醒时间</th>
                                            <th>提醒事项</th>
                                        </tr>
                                    </thead>
                                    <tbody id="remind">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="ibox float-e-margins ">
                            <div class="ibox-title ">
                                <h5 style="color:#23b7e5; "><i class="fa fa-pencil-square-o "></i> 备忘录</h5>
                                <button id="memoMore" class="btn btn-sm btn-info marl marb  pull-right" type="button">
                            更多
                        </button>
                                <button id="btn-memo-add" class="btn btn-sm btn-info marl marb pull-right" type="button">
                            新增
                        </button>
                            </div>
                            <div class="ibox-content">
                                <table class="table" style="table-layout: fixed;">
                                    <thead>
                                        <tr>
                                            <th width="35%">事件标题</th>
                                            <th>时间</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="gridBodyMemo">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--校友工作大事记-->
                    <div class="col-sm-5 ">
                        <div class="ibox float-e-margins ">
                            <div class="ibox-title ">
                                <h5 style="color:#d58512; "><i class="fa fa-list "></i> 校友工作大事记</h5>
                                <button id="eventMore" class="btn btn-sm btn-info marl marb  pull-right" type="button">
                            更多
                        </button>
                                <button id="btn-ev-add" class="btn btn-sm btn-info marl marb pull-right" type="button">
                            新增
                        </button>
                            </div>
                            <div id="vertical-timeline" class="vertical-container light-timeline">
                                <div id="gridBodyEvent">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--备忘录modal-->
            <div aria-hidden="true" aria-labelledby="myModal" role="dialog" tabindex="-1" id="memoModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body" id="add-memo">

                        </div>
                        <div class="modal-footer">
                            <button id="addMemo" type="button" class="btn btn-info">确定</button>
                            <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--校友大事件modal-->
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
                            <button id="addEvent" type="button" class="btn btn-info">确定</button>
                            <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script type="text/javascript" src="${contextPath}/resources/js/my-desk/my_desk.js">
            </script>
            <script type="text/html" id="tpl-memo">
                <form id="memoForm" class="form-horizontal bv-form">
                    <!--<input type="hidden" name="index" value="{{index}}">-->
                    <div class="form-group">
                        <input id="memoId" name="id" value="{{id}}" type="hidden">
                        <label class="col-sm-3 control-label">
                标题：
            </label>
                        <div class="col-sm-8 lineFeed">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{title}}</p>
                            {{else}}
                            <input type="text" name="entity.title" value="{{title}}" placeholder="请输入标题" class="form-control"> {{/if}}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                录入时间：
            </label>
                        <div class="col-sm-8">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{memoTime}}</p>
                            {{else}}
                            <input type="text" name="entity.memoTime" value="{{memoTime}}" placeholder="请选择录入时间" class="form-control form_time">{{/if}}
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                备忘内容：
            </label>
                        <div class="col-sm-8 lineFeed">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{content}}</p>
                            {{else}}
                            <textarea rows="7" cols="30" name="entity.content" placeholder="请输入备忘内容" class="form-control">{{content}}</textarea>{{/if}}
                        </div>
                    </div>
                </form>
            </script>
            <script type="text/html" id="tpl-event">
                <form id="eventForm" class="form-horizontal bv-form">
                    <!--<input type="hidden" name="index" value="{{index}}">-->
                    <div class="form-group">
                        <input id="memoId" name="entity.id" value="{{id}}" type="hidden">
                        <label class="col-sm-3 control-label">
                标题：
            </label>
                        <div class="col-sm-8">
                            <input type="text" name="entity.eventTitle" value="{{eventTitle}}" placeholder="请输入标题" class="form-control" {{if isReadOnly==1}}readonly{{/if}}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                录入时间：
            </label>
                        <div class="col-sm-8">
                            <input type="text" name="entity.eventTime" value="{{eventTime}}" placeholder="请选择录入时间" class="form-control form_time" {{if isReadOnly==1}}readonly{{/if}}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                事件内容：
            </label>
                        <div class="col-sm-8">
                            <textarea rows="7" cols="30" name="entity.eventContent" placeholder="请输入备忘内容" class="form-control" {{if isReadOnly==1}}readonly{{/if}}>{{eventContent}}</textarea>
                        </div>
                    </div>
                </form>
            </script>
            <script type="text/html" id="gridTplMemo">
                {{each memoList as value}} {{if value.status==0}}
                <tr>
                    <input type="hidden" name="id" value="{{value.id}}">
                    <td style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">{{value.title}}</td>
                    <td>{{value.memoTime}}</td>
                    <td>
                        <button class="btn btn-info btn-xs marl marb detail" data-id="{{value.id}}" type="button"><i class="fa fa-paste"></i>&nbsp;查看</button>
                        <button class="btn btn-success btn-xs marl marb success" data-id="{{value.id}}" type="button"><i class="fa fa-check"></i>&nbsp;标记为完成</button>
                    </td>
                </tr>
                {{/if}} {{/each}}
            </script>
            <script type="text/html" id="gridTplEvent">
                {{each eventList as value}} {{if value.status==0}}
                <div class="vertical-timeline-block">
                    <div class="vertical-timeline-icon navy-bg">
                        <i class="fa fa-dot-circle-o" style="margin-top:-7px;"></i>
                    </div>
                    <div class="vertical-timeline-content">
                        <h2>{{value.eventTitle}}</h2>
                        <p>{{value.eventContent}}</p>
                        <button class="btn btn-info btn-xs marl marb remove" data-id="{{value.id}}" type="button"><i class="fa fa-check"></i>&nbsp;移除</button>
                        <button class="btn btn-success btn-xs marl marb edit" data-id="{{value.id}}" type="button"><i class="fa fa-paste"></i>&nbsp;编辑</button>
                        <span class="vertical-date">
                            <small>{{value.eventTime}}</small>
                        </span>
                    </div>
                </div>
                {{/if}} {{/each}}
            </script>
            <!-- 提醒事件 -->
            <script type="text/html" id="remind-tpl">
                <tr>
                    {{each results as v}}
                    <td>{{if v.type==1}} 活动提醒{{else}}生日提醒{{/if}}</td>
                    <td>{{v.time | dateFormat:'yyyy-MM-dd'}}</td>
                    <td>{{v.title}}</td>
                </tr>
                {{/each}}
            </script>

            </html>