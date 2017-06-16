<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<title>校友管理及分析系统</title>
<style media="screen">
	.hide{
		display:none;
	}
	.form-inline .label-reset {
		min-width: 90px;
	}
</style>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1">
				<div class="ibox">
					<div class="ibox-title">
						<h5>校友管理中心--校友注册审核--查看</h5>
						<div class="ibox-tools">
							<s:if test="status==1">
							<button class="btn  btn-sm btn-info" id="hebing">
								<i class="fa fa-check"></i>&nbsp;合并通过
							</button>
							<button class="btn  btn-sm btn-info" id="nohebing">
								<i class="fa fa-check"></i>&nbsp;不合并通过
							</button>
						</s:if>
						<a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
							<i class="fa fa-reply"></i>&nbsp;返 回
						</a>
					</div>
				</div>
				<!-- 当前选中的需要被覆盖的校友信息 -->
				<input hidden="hidden" id="alumnid" value="${entity.alumnid}">

				<div class="ibox-content">
					<ul class="nav nav-tabs nav_content" id="myTab">
						<li class="active">
							<a href="javascript:void(0);"  data-id="zhuce-tb" class="tab">注册信息</a>
						</li>
						<s:if test="alumni!=null">
						<li>
							<a href="javascript:void(0);"  data-id="xuanze-tb"  class="tab">校友选择信息</a>
						</li>
					</s:if>
					<s:if test="status==1">
					<li>
						<a href="javascript:void(0);" data-id="pipei-tb"  class="tab">校友库匹配信息</a>
					</li>
				</s:if>
			</ul>
			<div class="zhuce-tb">
				<%@ include file="zhuce.jsp"%>
			</div>
			<s:if test="alumni!=null">
			<div class="xuanze-tb hide">
				<%@ include file="xuanze.jsp"%>
			</div>
		</s:if>
		<s:if test="status==1">
		<div class="pipei-tb hide">
			<%@ include file="pipei.jsp"%>
		</div>
	</s:if>
</div>
</div>
</div>
</div>
</div>
</body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script type="text/javascript">
	var status='${status}';
	var id='${entity.id}';
</script>
<script src="/resources/js/flow-audit/register/register-detail.js" type="text/javascript"></script>
</html>