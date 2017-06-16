<!--

分配权限
cczhao
2017/04/13

-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<link  href="${contextPath}/js-lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="ibox">
                    <div class="ibox-title">
                        <h5>分配权限</h5>
                        <div class="form-group">
                            <div align="right">
                                <a type="button" id="subForm" class="btn btn-sm btn-info" class="btn btn-primary btn-xs"> <i class="fa fa-check"></i>&nbsp;保存并发布
                                </a>
                                <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                    <i class="fa fa-reply"></i>&nbsp;返 回
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <input type="hidden" id="roleId" value="${id}"></input>
                        <div class="content_wrap">
                            <div class="zTreeDemoBackground left">
                                <ul id="operTree" class="ztree"></ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script src="${contextPath}/js-lib/zTree/v3/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<script type="text/javascript">
    var id='${id}';
</script>
<script type="text/javascript" src="/resources/js/system/role-manage/permission.js"></script>
</html>