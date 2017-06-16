/*
分配权限
cczhao
2017/04/13
*/		

var setting = {
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};


$(function(){
	init();
	//保存
	$('#subForm').click(function(){
		var ids = getSelected();
		var id = $('#roleId').val();
		$.post("sec-oper!saveRoleOper",{ roleId:id,operIdArray: ids },function(data){
			alertify.alert("权限分配完成！" ,function(){
				location.href="/role-manage!hrefPage";
			});
		},"json");
	});
});

//获取勾选的节点id
function getSelected(){
	var ids = "";
	var operTree = $.fn.zTree.getZTreeObj("operTree");
	var nodes = operTree.getCheckedNodes(true);
	if(nodes.length > 0){
		for(var i = 0 , j = nodes.length ; i < j ; i++){
			if(nodes[i].id=="0"){
				continue;
			}
			ids +=(nodes[i].id + ",");
		}
	}
	if(ids!=""){
		ids = ids.substring(0,ids.length -1 );
	}

	return ids;
}

function init(){
	$.post("/sec-oper!findAllMenus", {'userId':id}, function(data){
		$.fn.zTree.init($("#operTree"), setting, data);
	},'json')	
}