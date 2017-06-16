<!--

	校友会管理--分会管理--成员
	zxguan
	201703028
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
                            <h5>${typeStr }管理--成员</h5>
                        </div>
                        <div class="ibox-content">
                            <form class="form-horizontal clearfix">
                                <div class="input-group col-sm-4">
                                    <input placeholder="请输入关键字" type="text" class="form-control">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-info">查询</button>
                                    </span>
                                </div>
                            </form>
                            <div class="clearfix">
                                <button type="button" id="btn-detail" class="btn btn-sm btn-info marl">查 看</button>
                                <button type="button" id="btn-email" class="btn btn-sm btn-info marl">邮件通知</button>
                            </div>
                            <table class="table  table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th class="bs-checkbox" style="width:36px;">
                                            <input type="checkbox" class="check-all">
                                        </th>
                                        <th>
                                            	姓名
                                        </th>
                                        <th>
                                          		标签
                                        </th>
                                        <th>
                                           	        院系
                                        </th>
                                        <th>
                                            	单位
                                        </th>
                                        <th>
                                        		职务
                                        </th>
                                        <th>
                                           	       联系电话
                                        </th>
                                        <th>
                                            	邮箱
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
            <input type="checkbox" class="child" data-alumniid="{{value.alumniId}}" value="{{value.id}}">
        </td>
        <td>{{value.alumni.name}}</td>
        <td>{{value.alumni.label}}</td>
        <td>{{value.alumni.collegeName}}</td>
        <td>{{value.alumni.company}}</td>
		<td>{{value.alumni.post}}</td>
        <td>{{value.alumni.phone}}</td>
        <td>{{value.alumni.email}}</td>
		<td>
			<a href="javascript:;" data-id="{{value.id}}" id="btn-remove">移除</a>
		</td>
    </tr>
    {{/each}}
</script>
<script type="text/javascript" src="${contentPath}/resources/js/alumni-club-manage/member.js"></script>
<script type="text/javascript">
	var id="${id }";
</script>
</html>
