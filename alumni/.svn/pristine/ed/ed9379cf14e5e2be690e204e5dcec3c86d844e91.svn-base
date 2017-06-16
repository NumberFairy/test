/**
 * 校友注册
 */
 var action = "/alumni-register";
 $(function () {
  loadData();

  $("#btn-search").click(function(event) {
    loadData();
  });
  $("#detail").click(function() {
    if (!judgeCheckedOneId()) {
      return;
    }
    location.href = action + "!hrefDetail?id=" + getCheckedFirstId();
  });
  $("#gridBody").on('click', '.pass', function() {
   var id= $(this).parent().data("id");
   location.href = action + "!hrefDetail?status=1&id=" + id;

 });
  $("#gridBody").on('click', '.no-pass', function() {
    var id= $(this).parent().data("id");
    aduit(id,2);
  });

});

 function loadData() {
  var options = {
    url: action + "!page",
    queryParams:{'key':$("#key").val()}
  };
  loadPaginationData(options);
}

function aduit(id,status){
  $.post(action+'!aduit', {'id': id,'status':status}, function(data) {
    if(data.success){
     alertify.alert("操作成功！");
     loadData();
   }else{
    alertify.alert("操作失败！");
  }
},"json");
}