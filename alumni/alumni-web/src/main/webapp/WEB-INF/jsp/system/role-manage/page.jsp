<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>天维讯达</title>
        <style type="text/css">
            .error {
                color: #A94442;
                display: inline-block;
                margin-top: 5px;
                font-size: 12px;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>角色管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">角色名称 ：</label>
                                        <input placeholder="角色名称" class="form-control input-reset" name="entity.name">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">描述 ：</label>
                                        <input placeholder="描述" class="form-control input-reset" name="entity.description">
                                    </div>
                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="reach">查 询</button>
                                    </div>
                                </form>

                                <div class="clearfix">
                                    <!--<a class="btn btn-sm btn-info marl" href="${contextPath}/user-manage!hrefAddOrUpdate">新增
							</a>--><button class="btn btn-sm btn-info marl" id="btn-add">新增</button>
                                    <button class="btn btn-sm btn-info marl" id="btn-update">编辑</button>
                                    <!--<button class="btn btn-sm btn-info marl" id="btn-detail">查看</button>-->
                                    <button class="btn btn-sm btn-info marl" id="btn-delete">删除</button>
                                    <button class="btn btn-sm btn-info marl" id="btn-limit">分配权限</button>
                                </div>
                                <table class="table  table-bordered table-hover">
                                    <thead>
                                        <tr class="text-c">
                                            <th width="40"><input name="" class="check-all" type="checkbox" value=""></th>
                                            <th>角色名称</th>
                                            <th>描述</th>
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
            <!--新增、修改角色模态框-->
            <div aria-hidden="true" aria-labelledby="myModal" role="dialog" tabindex="-1" id="roleModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body" id="add-role">

                        </div>
                        <div class="modal-footer">
                            <button id="addRole" type="button" class="btn btn-info">确定</button>
                            <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script type="text/javascript" src="${contentPath}/resources/js/system/role-manage/page.js"></script>
            <script type="text/html" id="gridTpl">
                {{if results.length==0}}
                <tr>
                    <td colspan="99">没有查询结果！</td>
                </tr>
                {{/if}} {{each results as value}}
                <tr>
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{value.id}}">
                    </td>
                    <td>{{value.name}}</td>
                    <td>{{value.description}}</td>
                </tr>
                {{/each}}
            </script>
            <script type="text/html" id="tpl-role">
                <form id="roleForm" class="form-horizontal bv-form">
                    <!--<input type="hidden" name="index" value="{{index}}">-->
                    <div class="form-group">
                        <input id="memoId" name="entity.id" value="{{id}}" type="hidden">
                        <label id="nameLabel" class="col-sm-3 control-label">
                            角色名称：
                        </label>
                        <div class="col-sm-8 lineFeed">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{name}}</p>
                            {{else}}
                            <input id="nameVerify" type="text" name="entity.name" value="{{name}}" placeholder="请输入角色名称" class="form-control"> {{/if}}
                            <p class="error" id="textShow"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                            角色描述：
                        </label>
                        <div class="col-sm-8">
                            {{if isReadOnly==1}}
                            <p class="form-control-static">{{description}}</p>
                            {{else}}
                            <input type="text" name="entity.description" value="{{description}}" placeholder="请输入角色描述" class="form-control form_time">{{/if}}
                        </div>
                    </div>
                </form>
            </script>

            </html>