<!--

用户管理
zxguan
20170321

-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<title>天维讯达</title>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>用户管理</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-inline clearfix" id="form" role="form">
                            <div class="form-group marb">
                                <label class="label-reset">姓名 ：</label>
                                <input placeholder="姓名" class="form-control input-reset" name="entity.name">
                            </div>
                            <div class="form-group marb">
                                <label class="label-reset">用户名 ：</label>
                                <input placeholder="用户名" class="form-control input-reset" name="entity.loginName">
                            </div>
                            <div class="form-group marb">
                                <button class="btn btn-sm btn-info mar0" type="button" id="reach">查 询</button>
                            </div>
                        </form>
                        <div class="clearfix">
                            <a class="btn btn-sm btn-info marl" href="${contextPath}/user-manage!hrefAddOrUpdate">新增
                            </a>
                            <button class="btn btn-sm btn-info marl" id="btn-update">修改</button>
                            <button class="btn btn-sm btn-info marl" id="btn-detail">查看</button>
                            <button class="btn btn-sm btn-info marl" id="btn-delete">删除</button>
                            <button class="btn btn-sm btn-info marl" id="btn-reset">重置密码</button>
                            <button class="btn btn-sm btn-info marl" id="btn-role">配置角色</button>
                        </div>
                        <table class="table  table-bordered table-hover">
                            <thead>
                                <tr class="text-c">
                                    <th width="40"><input name="" class="check-all" type="checkbox" value=""></th>
                                    <th>姓名</th>
                                    <th>用户名</th>
                                    <th>手机</th>
                                    <th>固定电话</th>
                                    <th>邮箱</th>
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
    <!--modal 分配权限-->
    <div aria-hidden="true" aria-labelledby="modifyModal" role="dialog" tabindex="-1" id="modifyModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">分配角色</h4>
                </div>
                <div class="modal-body">
                    <!---->
                    <form id="formRole" class="form-horizontal">
                        <fieldset>
                            <div class="clearfix">
                                <input id="userId" name="userId" type="hidden">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"> 
                                        姓名：
                                    </label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static" id="user-name" value=""></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                <label class="col-sm-3 control-label">角色：</label>
                                    <div class="col-sm-6">
                                        <select id="roleId" name="roleId" class="form-control input-reset">                         
                                        </select>     
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                    <!---->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="saveRole" type="button" class="btn btn-primary">确定</button>
                </div>
            </div>
        </div>
    </div>
</body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script type="text/javascript" src="${contentPath}/resources/js/system/user-manage/page.js"></script>
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
        <td>{{value.loginName}}</td>
        <td>{{value.mobile}}</td>
        <td>{{value.tel}}</td>
        <td>{{value.email}}</td>
    </tr>
    {{/each}}
</script>

</html>