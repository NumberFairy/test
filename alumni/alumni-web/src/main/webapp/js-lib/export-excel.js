(function($) {
	Export={};
	$.Export = {
		excel : function(o,options) {
			var defaults = {
				url : '',
				params : '',
				model:'body',
				intervalTime : 1000,
				timeout : 60 * 1000
			};
			var options = $.extend(defaults, options);
			$.Export.dom=o;
			var excelshadediv = "";//$.Export.create_shade_div($(options.model));
			$.Export.disable_button();
			var exceltimer = window.setInterval(function() {
						$.Export.getExcelRealTime(options, excelshadediv,
								exceltimer);
					}, options.intervalTime);
			$.Export.exportExcel(options);
			setTimeout(function() {
						window.clearInterval(exceltimer);
					}, options.timeout);
			
		},
		exportExcel : function(options) {
			window.open(options.url + "?" + options.params, "_top");
		},
		getExcelRealTime : function(options, excelshadediv, exceltimer) {
			var realtimeUrl = options.url.substring(0, options.url
							.lastIndexOf('!'));
			$.post(realtimeUrl + '!exportRealTime.action', {}, function(
							data) {
						$('.modal #plan > .ui-progressbar-value').css({
									'background' : '#A6DC00'
								});
						if (!data.success) {
							$('#plan').progressbar({
										value : parseInt(data.realtime)
									});
							if (data.realtime > 53) {
								$('#plan-text').css({
											'color' : '#3500dc'
										});
							} else {
								$('#plan-text').css({
											'color' : '#FFFFFF'
										});
							}
							$('#plan-text').html(data.realtime);
						} else {
							window.clearInterval(exceltimer);
//							$.Export.hiden_shade_div(excelshadediv);
							$.Export.enable_button();
						}
					}, 'json');
		},
		disable_button:function(){
			$($.Export.dom).addClass('disabled');
		},
		enable_button : function(_shade) {
			$($.Export.dom).removeClass('disabled');
		},
		/**
		 * 添加遮罩
		 * 不能用于jquery ui dialog
		 * @param {} dom
		 * @return {}
		 */
		create_shade_div : function(dom) {
			var parentdiv = $('<div></div>');
			parentdiv.addClass('modal-backdrop fade in');
			dom.append(parentdiv);
			var plan = $('<div id="plan" class="plan"></div>');
			plan.append($('<div id="plan-text" class="plannumberBar"></div>'));
			parentdiv.append(plan);
			parentdiv.height(dom.outerHeight(true));
			parentdiv.width(dom.outerWidth(true));
			dom.bind('DOMNodeInserted', function(e) {
						parentdiv.height(dom.outerHeight(true));
						parentdiv.width(dom.outerWidth(true));
					});
			console.info(dom.position());
			parentdiv.offset(dom.position());
			return parentdiv;
		},
		/**
		 * 清除遮罩
		 * @param {} _shade
		 */
		hiden_shade_div : function(_shade) {
			_shade.fadeOut(1000, function() {
						_shade.remove();
					});
		}
	};
	/**
	 * 导出方法
	 */
	Export.ExportExcel = function(o,options) {
		$.Export.excel(o,options);
	};
})(jQuery);