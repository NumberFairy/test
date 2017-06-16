/**
*  管理员登录界面
*  zxguan
*  20170416
* */


var actionPath = contextPath + "/admin-user";

$(function() {
	findUserMenus();

	$('.sidebar-collapse').slimScroll({
        height: '100%',
        railOpacity: 0.9,
        alwaysVisible: false
    });

    $('.full-height-scroll').slimScroll({
        height: '100%'
    });

});

function findUserMenus() {
	$.ajax({
		url : actionPath + '!findUserMenus',
		type : 'POST',
		dataType : 'json',
	}).success(function(data){
		if (data.length > 0) {
			var html = template('menuTpl', {'results' : data});
			$('#side-menu').append(html).metisMenu();
		} else {
			alertify.alert("获取用户菜单失败！");
		}
	}).fail(function(data){
		alertify.alert("获取用户菜单失败！");
	});
}