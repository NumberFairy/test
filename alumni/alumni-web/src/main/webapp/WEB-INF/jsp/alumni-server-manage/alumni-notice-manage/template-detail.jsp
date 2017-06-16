<!--

校友服务管理--校友通知模板管理
czjia
20170329
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<title>校友管理及分析系统</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1">
				<div class="ibox">
					<div class="ibox-title">
						<h5>校友登记管理</h5>
						<div class="form-group">
							<div align="right">
								<a class="btn btn-sm btn-default marr" type="button"
									href="javascript:void(0)" onclick="window.history.back();">
									<i class="fa fa-check"></i>&nbsp;返回
								</a>
							</div>
						</div>
					</div>
					<div class="ibox-content">
						<div class="m-t">
							<form class="form-horizontal" id="form-all">
								<div class="clearfix">
									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-sm-4 control-label">
												主题： </label>
											<div class="col-sm-8">
												<p class="form-control-static">${entity.title}</p>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-4 control-label">
												内容： </label>
											<div class="col-sm-8">
												<p class="form-control-static">${entity.content}</p>
											</div>
										</div>
									</div>
								</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
</html>
