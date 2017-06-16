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
                        <h5>校友注册审核</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal clearfix">
                            <div class="input-group col-sm-4">
                                <input placeholder="请输入关键字" id="key" class="form-control">
                                <span class="input-group-btn">
                                    <button type="button" id="btn-search" class="btn btn-info">查询</button>
                                </span>
                            </div>
                        </form>
                        <div class="clearfix">
                           <button type="button" id="detail" class="btn btn-sm btn-info">查 看</button>
                       </div>
                       <table class="table  table-bordered table-hover content">
                        <thead>
                            <tr>
                                <th class="bs-checkbox" style="width:36px;">
                                    <input type="checkbox" class="check-all">
                                </th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>身份</th>
                                <th>院系</th>
                                <th style="width: 15%">注册时间</th>  
                                <th>审核人</th>
                                <th>审核状态</th>
                                <th>操作</th>
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
<script src="/resources/js/flow-audit/register/register.js" type="text/javascript"></script>
<script type="text/html" id="gridTpl">
    {{each results as v}}
    <tr>
        <td class="bs-checkbox" style="width:36px;">
            <input type="checkbox" class="child" value="{{v.id}}">
        </td>
        <td>{{v.name}}</td>
        <td>{{v.gender==1?"女":"男"}}</td>
        <td>{{v.identityName}}</td>
        <td>{{v.collegeName}}</td>
        <td>{{v.createTime}}</td>
        <td>{{v.auditor}}</td>
        <td>
         {{if v.status}}
         {{#v.status==1?"审核通过":"审核未通过"}}
         {{else}}
         待审核
         {{/if}} 
     </td>
     <td data-id="{{v.id}}">
        {{if !v.status}}
        <a class="btn  btn-success mar0 btn-xs pass">通过</a>
        <a class="btn  btn-danger mar0 btn-xs no-pass">不通过</a>
        {{else}}
        <b class="btn  btn-success mar0 btn-xs grayOperation"> 
            通过
        </b>
        <b class="btn  btn-success mar0 btn-xs grayOperation"> 
            不通过
        </b>
        {{/if}}
    </td>

</tr>
{{/each}}
</script>
</html>