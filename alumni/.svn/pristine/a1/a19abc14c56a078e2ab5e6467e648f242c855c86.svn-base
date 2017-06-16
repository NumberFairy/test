<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        <style>
            span.star {
                color: red;
                padding: 0 10px;
                vertical-align: middle;
            }
            .form-horizontal .control-label {
                text-align: right;
                margin-bottom: 0;
                padding-top: 7px;
            }
            .col-sm-3 {
                width: 25%;
                float: left;
            }
            .col-sm-7 {
                width: 58.33333333%;
                float: left;
            }
        </style>
		<link href="${contextPath}/js-lib/chosen/chosen.css" type="text/css" rel="stylesheet" />
        </head>

        <body>
            <%@include file="../menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <form id="infoForm" class="form-horizontal bv-form" method="post">
                   		<div id="div-branch-chapter" class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>地方分会：</label>
							<div class="col-sm-6">
								<select id="select-chapter" name="chapterStr" class="form-control select-width chosen-select" multiple="multiple" data-placeholder="请选择地方分会类型">
								</select>
							</div>
						</div>
                   		<div id="div-branch-college" class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>院系分会：</label>
							<div class="col-sm-6">
								<select id="select-college" name="collegeStr" class="form-control select-width chosen-select" multiple="multiple" data-placeholder="请选择学院分会类型">
								</select>
							</div>
						</div>
                   		<div id="div-branch-oversea" class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>海外分会：</label>
							<div class="col-sm-6">
								<select id="select-oversea" name="overseaStr" class="form-control select-width chosen-select" multiple="multiple" data-placeholder="请选择海外分会类型">
								</select>
							</div>
						</div>
                   		<div id="div-branch-industry" class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>专业分会：</label>
							<div class="col-sm-6">
								<select id="select-industry" name="industryStr" class="form-control select-width chosen-select" multiple="multiple" data-placeholder="请选择专业分会类型">
								</select>
							</div>
						</div>
                        <div align="center">
                            <button type="button" id="btn-submit" class="btn btn-primary">提交申请</button>
                        </div>
                    </form>
                </div>
                <!--内容部分end-->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
				<%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>
	<script type="text/javascript" src="${contextPath}/js-lib/chosen/chosen.jquery.js"></script>
	<script>
	var actionPath = contextPath + "/alumni-club";
	var branchTypes = [];
	$(function(){
		branchTypes.push($('#select-chapter'), $('#select-college'), $('#select-oversea'), $('#select-industry'));
		findBranchByType(1);
		findBranchByType(2);
		findBranchByType(3);
		findBranchByType(4);

		$('#btn-submit').click(function(e){
			var $obj = $('#infoForm').serialize();
			$.ajax({
				url : actionPath + '!joinInBranch',
				type : 'POST',
				dataType : 'JSON',
				data : $obj
			}).success(function(data){
				if (data.success) {
					window.history.back();
				}
			}).fail(function(data){
			});
		});
	});

	function findBranchByType(type) {
		$.ajax({
			url : actionPath + '!findBranchByType',
			type : 'POST',
			dataType : 'JSON',
			data : {type : type}
		}).success(function(data){
			if (data.length > 0) {
				var h = '';
				$.each(data, function(i, obj) {
					h += '<option value="' + obj.id + '">' + obj.name + '</option>';
				});
				branchTypes[type-1].append(h).chosen();
			}
		}).fail(function(data){
		});
	}
	</script>
    </html>