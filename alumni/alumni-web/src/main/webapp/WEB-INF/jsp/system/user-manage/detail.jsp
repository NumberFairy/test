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
			<div class="col-lg-10 col-lg-offset-1">
				<div class="ibox">
					<div class="ibox-title">
						<h5>用户管理</h5>
						<div class="form-group">
							<div align="right">
								<a class="btn btn-sm btn-default marr" onclick="window.history.back();"><i class="fa fa-times"></i> &nbsp;返回</a>
							</div>
						</div>
					</div>
					<div class="ibox-content">
						<div class="m-t">
							<form class="form-horizontal" id="baseInfoForm">
								<input type="hidden" name="entity.id" value="${entity.id}">
								<div class="form-group">
									<label class="col-sm-3 control-label"> <span
										class="star">*</span>登录名：
									</label>
									<div class="col-sm-6">
										<p class="form-control-static" id="useriidd">${entity.loginName}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"> <span
										class="star">*</span>姓名：
									</label>
									<div class="col-sm-6">
										<p class="form-control-static" id="name">${entity.name}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"> <span
										class="star">*</span>性别：
									</label>
									<div class="col-sm-6">
										<s:if test="entity.gender == 0"><span>男</span></s:if>
										<s:if test="entity.gender == 1"><span>女</span></s:if>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"> <span
										class="star">*</span>电子邮件：
									</label>
									<div class="col-sm-6">
										<p class="form-control-static" id="email">${entity.email}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"> <span
										class="star">*</span>办公室电话：
									</label>
									<div class="col-sm-6">
										<p class="form-control-static" id="officeTel">${entity.tel}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"> <span
										class="star"></span>手机：
									</label>
									<div class="col-sm-6">
										<p class="form-control-static" id="telephone">${entity.mobile}</p>
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
<script type="text/javascript" src="${contentPath}/resources/js/system/user-manage/create.js"></script>
</html>