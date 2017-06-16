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
                                <h5>校友入会审核</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal clearfix">
                                    <div class="input-group col-sm-4">
                                        <input placeholder="请输入关键字" type="text" class="form-control" name="entity.name">
                                        <span class="input-group-btn">
                                            <button type="button" id="btn-search" class="btn btn-info">查询</button>
                                        </span>
                                    </div>
                                </form>
                                 <div class="clearfix">
                                    <button type="button" id="btn-detail" class="btn btn-sm btn-info marl">查 看</button>
                                </div>
                                <table class="table  table-bordered table-hover content">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>姓名</th>
                                            <th>性别</th>
                                            <th>申请校友会</th>
                                            <th>入学年份</th>
                                            <th>院系</th>
                                            <th>专业</th>
                                            <th>公司</th>
                                            <th>职务</th>
                                            <th>申请结果</th>
                                            <th>申请时间</th>
                                            <th>操作</th>
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
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
		<script type="text/html" id="gridTpl">
			{{each results as value index}}
			<tr>
				<td class="bs-checkbox" style="width:36px;">
					<input type="checkbox" class="child" value="{{value.alumniId}}">
				</td>
				<td>{{value.name}}</td>
				<td>{{value.genderStr}}</td>
				<td>{{value.branchName}}</td>
				<td>{{value.enrollYear}}</td>
				<td>{{value.collegeStr}}</td>
				<td>{{value.magorStr}}</td>
				<td>{{value.company}}</td>
				<td>{{value.post}}</td>
				<td>{{value.auditStatus}}</td>
				<td>{{value.createTime}}</td>
				<td>
					<a href="javascript:;" class="btn  btn-success mar0 btn-xs {{if value.status != -1}}grayOperation{{/if}}" data-id="{{value.id}}" data-status="{{value.status}}">
						通过
					</a>
					<a href="javascript:;" class="btn  btn-danger mar0 btn-xs {{if value.status != -1}}grayOperation{{/if}}" data-id="{{value.id}}" data-status="{{value.status}}">
						不通过
					</a>
				</td>
			</tr>
			{{/each}}
		</script>
		<script type="text/javascript" src="${contentPath}/resources/js/flow-audit/alumni-club/page.js"></script>
		</html>