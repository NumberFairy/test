<!--
  留言板
  cczhao@wisdombud.com
  2017/04/06-->
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
                                <h5>留言板管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">标题 ：</label>
                                        <input placeholder="标题" class="form-control input-reset" name="entity.title">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">留言人 ：</label>
                                        <input placeholder="留言人" class="form-control input-reset" name="entity.name">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">留言内容 ：</label>
                                        <input placeholder="留言内容" class="form-control input-reset" name="entity.message">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">留言时间 ：</label>
                                        <input placeholder="留言时间" class="form-control  form_date input-reset" name="entity.createTime">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">回复时间 ：</label>
                                        <input placeholder="回复时间" class="form-control form_date input-reset" name="entity.replyTime">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">审核状态 ：</label>
                                        <select class="form-control select-reset" name="entity.statusName">
                                            <option value="">全部</option>
                                            <option value="1">通过</option>
                                            <option value="0">不通过</option>
                                        </select>
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">回复状态  ：</label>
                                        <select class="form-control select-reset marl" name="entity.isReplyName">
                                            <option value="" >全部</option>
                                            <option value="1" >已回复</option>
                                            <option value="0">未回复</option>
                                        </select>
                                    </div>
                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="reach">查 询</button>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <button type="button" id="detail" class="btn btn-sm btn-info marl">查 看</button>
                                    <button type="button" id="delete" class="btn btn-sm btn-info marl">删除</button>
                                    <button type="button" id="reply" class="btn btn-sm btn-info marl">回复</button>
                                </div>
                                <table class="table  table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>标题</th>
                                            <th>留言人</th>
                                            <th>留言内容</th>
                                            <th>留言时间</th>
                                            <th>审核状态</th>
                                            <th>回复状态</th>
                                            <th>回复时间</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="gridBody">
                                        <tr id="{{value.id}}">
                                            <td class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="child" value="{{value.id}}">
                                            </td>
                                        </tr>
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
            <!-- Modal -->
            <div aria-hidden="true" aria-labelledby="modifyModal" role="dialog" tabindex="-1" id="modifyModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">邮件通知</h4>
                        </div>
                        <div class="modal-body">
                            <!---->
                            <form id="formInfo" class="form-horizontal">
                                <fieldset>
                                    <div class="clearfix">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><span class="star">*</span>邮箱：
										    </label>
                                            <div class="col-sm-7">
                                                <input id="email" type="text" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label"><span class="star">*</span>内容：
										    </label>
                                            <div class="col-sm-7">
                                                <div class="col-sm-7" style="padding-left:0;margin:6px 0;">
                                                    在首页显示：
                                                    <div class="checkbox checkbox-success checkbox-inline" style="margin-top:-6px;">
                                                        <input type="checkbox" id="checkbox" value="1">
                                                        <label for="checkbox"></label>
                                                    </div>
                                                </div>
                                                <textarea id="txtCode" rows="5" style="width:100%" placeholder="请输入回复内容"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                            <!---->
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button id="send" type="button" class="btn btn-primary">发送</button>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script type="text/javascript" src="${contentPath}/resources/js/message-board/page.js"></script>
            <script type="text/html" id="gridTpl">
                {{each results as value index}}
                <tr id="{{value.id}}">
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{value.id}}">
                    </td>
                    <td>{{value.title}}</td>
                    <td>{{value.name}}</td>
                    {{if value.message.length>10}}
                    <td>{{value.message.substring(0,10)}}...</td>
                    {{else}}
                    <td width="20%">
                        <div class="ellipsis">
                            {{value.message}}
                        </div>
                    </td>
                    {{/if}}
                    <td>{{value.createTime}}</td>
                    <td>
                        {{value.statusName}}
                    </td>
                    <td>{{value.isReplyName}}</td>
                    <td>{{value.replyTime}}</td>
                    {{if value.status==-1}}
                    <td>
                        <a href="${contextPath}/message-board!audit?id={{value.id}}&flag=1" class="btn  btn-success mar0 btn-xs"> 
                            通过
                        </a>
                        <a href="${contextPath}/message-board!audit?id={{value.id}}&flag=0" class="btn  btn-danger mar0 btn-xs">
                            不通过
                        </a>
                    </td>
                    {{else if value.status==1}}
                    <td>
                        <b class="btn  btn-success mar0 btn-xs grayOperation"> 
                            通过
                        </b>
                        <a href="${contextPath}/message-board!audit?id={{value.id}}&flag=0" class="btn  btn-danger mar0 btn-xs">
                            不通过
                        </a>
                    </td>
                    {{else}}
                    <td id="grayOperation">
                        <a href="${contextPath}/message-board!audit?id={{value.id}}&flag=1" class="btn  btn-success mar0 btn-xs"> 
                            通过
                        </a>
                        <b class="btn  btn-success mar0 btn-xs grayOperation"> 
                            不通过
                        </b>
                    </td>
                    {{/if}}
                </tr>
                {{/each}}
            </script>

            </html>