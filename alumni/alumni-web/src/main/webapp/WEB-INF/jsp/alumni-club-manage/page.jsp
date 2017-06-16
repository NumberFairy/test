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
                                <h5>${typeStr}管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="form-group marb">
                                        <label class="label-reset">校友分会 ：</label>
                                        <input placeholder="校友分会" class="form-control input-reset" name="name">
                                    </div>
                                    <div class="form-group marb hidden"> 
                                        <label class="label-reset">会长 ：</label>
                                        <input placeholder="会长" class="form-control input-reset" name="huizhang">
                                    </div>
                                    <div class="form-group marb">
                                        <label class="label-reset">所在地 ：</label>
                                        <input placeholder="所在地" class="form-control input-reset" name="address">
                                    </div>                                   
                                    <div class="form-group marb">
                                        <button class="btn btn-sm btn-info mar0" type="button" id="reach">查 询</button>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <a href="/alumni-club!hrefAddOrUpdate?type=${type }" class="btn btn-sm btn-info marl">新 增</a>
                                    <button type="button" id="btn-detail" class="btn btn-sm btn-info marl">查 看</button>
                                    <button type="button" id="btn-update" class="btn btn-sm btn-info marl">编 辑</button>
                                    <button type="button" id="btn-delete" class="btn btn-sm btn-info marl">删 除</button>
                                    <button type="button" id="btn-email" class="btn btn-sm btn-info marl">邮件通知</button>
                                    <input type="file" id="upload" name="upload" class="hidden">
                                    <button type="button" id="btn-import" class="btn btn-sm btn-info marl marb">批量导入</button>
                                    <button type="button" id="btn-download" class="btn btn-sm btn-info marl">下载导入模板</button>
                                </div>
                                <table class="table  table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>
                                                校友会名称
                                            </th>
                                            <th>
                                                会长
                                            </th>
                                            <th>
                                                成员数
                                            </th>
                                            <th>
                                                微信号
                                            </th>
                                            <th>
                                                邮箱
                                            </th>
                                            <th>
                                                所在地
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
        <%@ include file="/WEB-INF/jsp/alumni-manage-center/model.jsp"%>
            <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
                <script type="text/html" id="gridTpl">
                    {{each results as value index}}
                    <tr id="{{value.id}}">
                        <td class="bs-checkbox" style="width:36px;">
                            <input type="checkbox" class="child" value="{{value.id}}">
                        </td>
                        <td>{{value.name}}</td>
                        <td>{{value.huizhang}}</td>
                        <td>{{value.memberNum}}</td>
                        <td>{{value.wechat}}</td>
                        <td>{{value.email}}</td>
                        <td>{{value.address}}</td>
                        <td>
                            <a href="${contextPath} /alumni-club!hrefMember?type=${type }&id={{value.id}}">成员</a>
                        </td>
                    </tr>
                    {{/each}}
                </script>
                <script type="text/javascript" src="${contentPath}/resources/js/alumni-club-manage/page.js"></script>
                <script>
                    var type = '${type }';
                    var typeStr = '${typeStr }';
                </script>

                </html>