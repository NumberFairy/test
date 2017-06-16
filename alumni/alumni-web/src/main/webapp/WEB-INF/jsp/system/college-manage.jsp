<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<link  href="${contextPath}/js-lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
<title>天维讯达</title>
<style type="text/css">  
	#rMenu {position:absolute; visibility:hidden; top:0; background-color:#f9f9f9;text-align: left;padding: 2px;}  
	#rMenu a{  
		cursor: pointer;  
		list-style: none outside none;  
	}  
	.modal-body {
		padding: 19px 37px 12px 13px;
	}
</style> 
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>学院/专业字典维护</h5>
					</div>
					<div class="ibox-content">
						<ul id="tree" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="rMenu">  
		<a href="#" class="list-group-item add-college" >新增学院</a>  
		<a href="#" class="list-group-item add-spelity" >新增专业</a>  
		<a href="#" class="list-group-item modify">修改</a>  
		<a href="#" class="list-group-item delete" >删除</a>  
	</div>

	<div class="modal fade" id="collegeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="college-title"></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal bv-form clearfix" id="college-form">
						<input hidden="hidden" name="college.id">
						<div class="form-group">
							<label class="col-sm-3 control-label">中文名</label>
							<div class="col-sm-6" style="width:75%" >
								<input name="college.cnName" value="" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">英文名</label>
							<div class="col-sm-6" style="width:75%">
								<input name="college.enName" value="" class="form-control">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="college-btn">提交
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="specialtyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="specialty-title"></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal bv-form clearfix" id="specialty-form">
						<input hidden="hidden" name="specialty.id">
						<input hidden="hidden" name="specialty.collegeId">
						<div class="form-group">
							<label class="col-sm-3 control-label">名称</label>
							<div class="col-sm-6" style="width:75%">
								<input  name="specialty.cnName" value="" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">学位</label>
							<div class="col-sm-6" style="width:75%">
								   <select id="degreeId" name="specialty.degreeId"  class="form-control select-width"></select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="specialty-btn">提交
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div>
		</div>
	</div>


</body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script src="${contextPath}/js-lib/zTree/v3/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${contentPath}/resources/js/system/college-manage.js"></script>
</html>
