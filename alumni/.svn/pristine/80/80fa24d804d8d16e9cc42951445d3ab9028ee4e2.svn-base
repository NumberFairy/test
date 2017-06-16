/**
 * 校友注册
 */
 var action = "/alumni-register";
 $(function () {
  init();
  if(status){
    loadData();
  }
  $("#btn-search").click(function() {
   loadData();
 });
  $("#nohebing").click(function() {
    alertify.confirm("确定通过吗？", function (e) {if(e){ aduit(1);}})
  });
  $("#hebing").click(function() {
    var alumnid=$('#alumnid').val();
    var sel= getCheckedIds();
    var str="确定合并<font style='color: red;font-size: large;'>校友选中的信息</font>并通过吗？";
    if(sel.length>1){
     alertify.alert("请选择一条校友信息！");
     return;
   }
   if(sel.length==1){
    alumnid=sel[0];
    str="确定要合并<font style='color: red;font-size: large;'>您选择的校友信息</font>并通过吗？";
  }
  alertify.confirm(str, function (e) {if(e){ aduit(1,alumnid);}})
});
});

 function init(){
  $(".tab").click(function(event) {
    $(this).parent().addClass('active');
    $(this).parent().siblings().removeClass('active')
    $('.'+$(this).data("id")).removeClass('hide');
    $('.'+$(this).data("id")).siblings('div').addClass('hide');
  });
   //院系字典
   creatDicOption("collegeId","/dic-common!findAllCollege");
    //专业院字典
    creatDicOption("major-sel","/dic-common!findAllCollegeSpecialty",{'id':30100});
    $('#collegeId').change(function(event) {
     creatDicOption("major-sel","/dic-common!findAllCollegeSpecialty",{'id':$(this).val()});
   });
  }
  function loadData() {
    var options = {
      url:   "/alumni!page",
      queryParams:$('#sech-form').serialize()
    };
    loadPaginationData(options);
  }

  function aduit(status,alumnid){
    $.post(action+'!aduit', {'id': id,'status':status,'alumnid':alumnid}, function(data) {
      if(data.success){
       alertify.alert("操作成功！",function(){
        location.href="/alumni-register!hrefPage";
      });
     }else{
      alertify.alert("操作失败！");
    }
  },"json");
  }