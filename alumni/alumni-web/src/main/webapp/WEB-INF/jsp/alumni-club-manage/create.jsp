<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-lg-10 col-lg-offset-1">
                        <div class="ibox">
                            <div class="ibox-title">
                                <h5>${typeStr}管理</h5>
                                <div class="ibox-tools">
                                    <button class="btn  btn-sm btn-info" type="button" id="btn-submit"> <i class="fa fa-check"></i>&nbsp;提 交 </button>
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:;" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="baseInfoForm">
                                        <input type="hidden" name="entity.id" value="${entity.id}">
                                        <input type="hidden" name="entity.type" value="${type}">
                                        <div class="clearfix">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                            <span class="star">*</span> 校友会名称：
		                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.name" value="${entity.name}" placeholder="请输入校友会名称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                            <span class="star">*</span> 所在地：
		                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.address" value="${entity.address}" placeholder="请输入所在地" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                             <span class="star"></span>简介：
		                                        </label>
                                                    <div class="col-sm-8">
                                                        <textarea name="entity.introduction" class="form-control" placeholder="请输入简介" rows="3">${entity.introduction}</textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                            <span class="star">*</span> 微信号：
		                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.wechatId" value="${entity.wechatId}" placeholder="请输入微信号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                            <span class="star">*</span> 邮箱：
		                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.email" value="${entity.email}" placeholder="请输入邮箱" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">
		                                            <span class="star"></span>成立时间：
		                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.establishedTime" value="<s:date name='entity.establishedTime' format='yyyy-MM-dd HH:mm:ss'/>" placeholder="请选择成立时间" class="form-control form_datetime">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <fieldset>分会领导</fieldset>
                                        <div class="hr-line-dashed"></div>
                                        <div>
                                            <button type="button" id="btn-add" class="btn btn-sm btn-info marl marb">新 增</button>
                                            <button type="button" id="btn-update" class="btn btn-sm btn-info marl marb">编 辑</button>
                                            <button type="button" id="btn-delete" class="btn btn-sm btn-info marl marb">删 除</button>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th class="bs-checkbox" style="width:36px;">
                                                            <input type="checkbox" class="check-all">
                                                        </th>
                                                        <th>
                                                            姓名
                                                        </th>
                                                        <th>
                                                            任职身份
                                                        </th>
                                                        <th>
                                                            联系电话
                                                        </th>
                                                        <th>
                                                            邮箱
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody id="gridBody">
                                                    <!-- content -->
                                                </tbody>
                                            </table>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 弹窗 start -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel"></h4>
                        </div>
                        <div class="modal-body" id="modal-body">
                            <!--  content -->
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="btn-confirm" class="btn btn-info">确定</button>
                            <button type="button" id="btn-cancle" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 弹窗 end -->
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-club-manage/create.js"></script>
            <script id="tpl-modal" type="text/html">
                <form id="form-modal" class="form-horizontal bv-form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                	姓名：
            </label>
                        <div class="col-sm-8">
                            <input name="name" value="{{name}}" placeholder="请输入姓名" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                	任职身份：
            </label>
                        <div class="col-sm-8">
                            <input type="hidden" id="staffStr" name="staffStr" value="会长">
                            <select id="staff" name="staff" class="form-control"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
                	联系电话：
            </label>
                        <div class="col-sm-8">
                            <input name="phone" value="{{phone}}" placeholder="请输入联系电话" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">
					邮箱：
            </label>
                        <div class="col-sm-8">
                            <input name="email" value="{{email}}" placeholder="请输入邮箱" class="form-control">
                        </div>
                    </div>
                </form>
            </script>
            <script type="text/html" id="gridTpl">
                {{each results as value index}}
                <tr id="{{value.id}}">
                    <td class="bs-checkbox" style="width:36px;">
                        <input type="checkbox" class="child" value="{{value.id}}">
                    </td>
                    <td>{{value.name}}</td>
                    <td>{{value.staffStr}}</td>
                    <td>{{value.phone}}</td>
                    <td>{{value.email}}</td>
                </tr>
                {{/each}}
            </script>
            <script type="text/html" id="selTpl">
                {{each results as value index}}
                <option value="{{value.id}}">{{value.value}}</option>
                {{/each}}
            </script>
            <script>
                var id = '${id }';
                var type = '${type }';
                var typeStr = '${typeStr }';
            </script>

            </html>