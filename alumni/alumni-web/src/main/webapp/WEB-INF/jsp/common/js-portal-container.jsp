<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/metisMenu/jquery.metisMenu.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/slimscroll/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/alertify/js/alertify.js"></script>
<%-- 分页 --%>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrap-paginator.js"></script>
<%--模板填充--%>
<script type="text/javascript" src="${contextPath}/js-lib/template.js"></script>
<%--表单验证--%>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrapValidator/dist/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrapValidator/dist/language/zh_CN.js"></script>
<%--选择控件--%>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrap-select/bootstrap-select.min.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/chosen/chosen.jquery.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/district-picker/jquery.district.picker.js"></script>
<%--时间插件--%>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrap-datetimepicker-0.0.11/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${contextPath}/js-lib/bootstrap-datetimepicker-0.0.11/js/bootstrap-datetimepicker.zh-CN.js"></script>
<%--ajax上传文件插件--%>
<script type="text/javascript" src="${contextPath}/js-lib/ajaxfileupload.js"></script>
<%--公用方法/事件js--%>
<script type="text/javascript" src="${contextPath}/resources/js/jquery-wisdom-util.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/common-datetimepicker.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/common.js"></script>
<script>
	$(document).ready(function() {
		$('body').delegate('.menu-item', 'mouseover mouseout', function(e) {
			if (e.type == 'mouseover') {
				$(this).addClass("hover").find(".menu-inner").stop(true, true).show();
			} else {
				$(this).removeClass("hover").find(".menu-inner").stop(true, true).hide();
			}
		});
		
		if(isIE()){
			$('[placeholder]').focus(function() {
				var $input = $(this);
				$input.siblings('.placeholder').hide();
			}).blur(function() {
				var $input = $(this);
				var $placeholder = $input.siblings('.placeholder');
				if($placeholder.length == 0){
					var $ph = $('<span class="placeholder" style="position: absolute;color: #999;">'+$input.attr('placeholder')+'</span>');
					$ph.css({
						'padding-top': $input.css('padding-top'),
						'padding-right': $input.css('padding-right'),
						'padding-bottom': $input.css('padding-bottom'),
						'padding-left': $input.css('padding-left'),
						'border-width': $input.css('border-width'),
						'margin-top': $input.css('margin-top'),
						'margin-right': $input.css('margin-right'),
						'margin-bottom': $input.css('margin-bottom'),
						'margin-left': $input.css('margin-left')
					});
					$input.before($ph);
					$ph.click(function(){
						$input.focus();
					});
				}

				if ($input.val() == '') {
					$input.siblings('.placeholder').show();
				}
			}).blur();
		}    
	});

	function isIE(){
		var browser=navigator.appName 
		var b_version=navigator.appVersion 
		var version=b_version.split(";"); 
		var trim_Version;
		try{
			trim_Version=version[1].replace(/[ ]/g,"");
		}catch(err){
			return false;
		}
		
		var arr = ["MSIE6.0", "MSIE7.0", "MSIE8.0", "MSIE9.0"];
		if(browser=="Microsoft Internet Explorer") {
			for(var i=0;i<arr.length;i++){
				if(arr[i] == trim_Version){
					return true;
				}
			}
		}
		return false; 
	}
</script>