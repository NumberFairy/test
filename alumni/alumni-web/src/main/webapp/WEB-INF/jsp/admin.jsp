<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<title>校友管理及分析系统</title>
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
		<%@ include file="common/common-menu.jsp"%>
		<!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
		<%@ include file="common/aside-right-menu.jsp"%>
		<%--content start--%>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="/my-desk!hrefPage"
                 frameborder="0"  >
                </iframe>
            </div>
		<%--content end--%>
        </div>
        <!--右侧部分结束-->
	 </div>
</body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script type="text/javascript" src="${contextPath }/resources/js/admin.js"></script>
<script type="text/html" id="menuTpl">
	{{each results as value index}}
    <li class="menu-line dk"></li>
	<li>
		<a href="javascript:;">
			<i class="fa {{value.icon}}"></i>
			<span class="nav-label">{{value.name}}</span>
			<span class="fa arrow"></span>
		</a>
		<ul class="nav nav-second-level collapse">
			{{each value.children as val idx}}
			<li>
				<a class="J_menuItem" href="${contextPath}/{{val.url}}">{{val.name}}</a>
			</li>
			{{/each}}
		</ul>
	</li>
	{{/each}}
</script>
</html>
