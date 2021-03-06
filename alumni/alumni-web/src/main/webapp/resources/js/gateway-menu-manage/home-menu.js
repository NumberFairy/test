/**
 * 门户菜单管理
 */
 var rMenu=$("#rMenu");
 var actionPath = "/home-menu-manage";
 var addBtn="<a href='javascript:;' class='list-group-item add' >新增</a>";
 var delBtn="<a href='javascript:;' class='list-group-item delete'>删除</a>";
 $(function () {
 	buildTree();
 	$('#form').on('click', '#btn-confirm', function(event) {
 		var bv = $('#info-form').data('bootstrapValidator');
 		bv.validate();
 		if(!bv.isValid()){
 			return;
 		}
 		$.post(actionPath+'!saveOrUpdate', $("#info-form").serialize(), function(data) {
 			if(data.success){
 				buildTree();
 				alertify.alert("操作成功");
 				return;
 			}
 			alertify.alert("操作失败");
 		},'json');
 	});

 	$("#rMenu").on('click', '.delete', function(event) {
 		hideRMenu();
 		del();
 	});

 	$("#rMenu").on('click', '.add', function(event) {
 		hideRMenu();
 		var node=findSel();
 		node.pid=node.id;
 		node.id=null;
 		node.name=null;
 		node.sort=node.childrenLength+1;
 		var h =  template("node-tpl", node);
 		$('#form').html(h);
 		validator();
 	});
 });

 function buildTree() {
 	var setting = { 
 		data: {
 			simpleData: { 
 				enable: true,
 			}
 		},
 		callback: {
 			onMouseDown: onBodyMouseDown,
 			onRightClick: OnRightClick,
 			onClick: zTreeOnClick
 		}
 	};
 	$.post(actionPath+"!tree", {}, function(data) {
 		$.fn.zTree.init($("#tree"), setting, data);
 	},"json");
 }

 function OnRightClick(event, treeId, treeNode) {  
 	var zTree = $.fn.zTree.getZTreeObj("tree");
 	zTree.selectNode(treeNode);
 	showRMenu(event.clientX, event.clientY);  
 }  

 function showRMenu(x, y) { 
 	var node= findSel();
 	if(!node){
 		return;
 	}
 	buildRigth(node);
 	$("#rMenu").show();  
    	rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"}); //设置右键菜单的位置、可见  
    	$("#tree").bind("mousedown", onBodyMouseDown);  
    }  

    function hideRMenu() {  
    if (rMenu) rMenu.css({"visibility": "hidden"}); //设置右键菜单不可见  
    $("#tree").unbind("mousedown", onBodyMouseDown);  
}  

function onBodyMouseDown(event){  
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {  
		rMenu.css({"visibility" : "hidden"});  
	}  
}

function del(){
	var node= findSel();
	if(!node){
		alertify.alert("请选中要删除的菜单");
		return;
	}
	alertify.confirm("确定要删除吗？",  function (e){
		if(!e){
			return;
		}        
		$.post(actionPath+'!del', {menuId:node.id}, function(data) {
			if(data.success){
				buildTree();
				alertify.alert("操作成功");
			}else{
				alertify.alert("操作失败");
			}
		},'json');
	})
}


function validator() {
	$('#info-form').bootstrapValidator({
		excluded: [':disabled', ':hidden', ':not(:visible)'],
		live: 'enabled',
		fields: {
			"entity.name": {
				trigger: "blur",
				validators: {
					notEmpty: {
						message: '请填写'
					}
				}
			},
			"entity.sort": {
				trigger: "blur",
				validators: {
					notEmpty: {
						message: '请填写'
					},
					regexp: { 
						regexp: /^[0-9]*$/, 
						message: '请填写数字' 
					}          
				}
			}
		}
	});
}

function findSel(){
	var zTree = $.fn.zTree.getZTreeObj("tree");
	var parent= zTree.getSelectedNodes();
	if(parent.length!=1){
		return;
	}
	return {
		id:parent[0].id,
		pid:(parent[0].pId?parent[0].pId:0),
		name:parent[0].name,
		buildIn:parent[0].buildIn,
		isParent:parent[0].isParent,
		toUse:parent[0].toUse,
		sort:parent[0].sort,
		type:parent[0].type,
		uploadFile:parent[0].uploadFile,
		uploadImg:parent[0].uploadImg,
		uploadVideo:parent[0].uploadVideo,
		childrenLength:parent[0].children.length
	}
}

function rigthTpl(add,del){
	var str='';
	if(add){
		str+=addBtn;
	}
	if(del){
		str+=delBtn;
	}
	$("#rMenu").html(str);
}

function buildRigth(node){
	//buildIn==1	内置对象禁止删除	
	//isParent ==false  子节点禁止新增	允许删除
	$("#rMenu").empty();
	if(node.isParent){
		rigthTpl(true,false);
	}else if(node.buildIn==0){
		rigthTpl(false,true);
	}
}

function zTreeOnClick(event, treeId, treeNode) {
	var node=findSel();
	var h =  template("node-tpl", node);
	$('#form').html(h);
	validator();
};
