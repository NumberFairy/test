/**
 * 留言板
 * cczhao@wisdombud.com
 * 2017/04/06
 * */
var actionPath = contextPath + "/message-board";

$(function () {
    loadData();


    $("#search-btn").click(function () {
        loadData();
    });

    $("#detail").click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        
        location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
    });

    $("#reach").click(function () {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });


    $("#delete").click(function () {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？",  function  (e)  {            
            if  (e)  {                
                $.post(actionPath  +  "!delete?id="  +  ids.join(','),  function  (data)  {                    
                    if  (data.success)  {                        
                        loadData();                        
                        alertify.alert("删除成功");                    
                    }                
                },  "json");                
                location.href  =  actionPath  +  "!hrefPage";            
            } 
            else  {
                return; 
            }    
        });
    });

    $('#replyFromSelect').click(function () {        
        var id = $('#entityId').val();
        $('#modifyModal').modal({
            keyboard: false
        });
        $.post(actionPath + "!forEmail", {
            id: id
        }, function (data) {
            if (data.success) {
                $("#email").val(data.message);
            }
        }, "json");
    })

    $('#reply').click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        $('#modifyModal').modal({
            keyboard: false
        });

        $.post(actionPath + "!forEmail", {
            id: getCheckedFirstId()
        }, function (data) {
            if (data.success) {
                $("#email").val(data.message);
            }
        }, "json");

    });
    $('#send').click(function () {
        var email = $('#email').val();
        var replyContent = $('#txtCode').val();
        var isShow = 0;
        if($('#checkbox').is(":checked")){
            isShow = $('#checkbox').val();
        }
        if (email != "" && replyContent != "") {
            $.post(actionPath + "!replyMessage", {
                isShow:isShow,
                email: email,
                replyContent: replyContent,
                id: getCheckedFirstId()
            }, function (data) {
                if (data.success) {
                    alertify.alert(data.msg);
                } else {
                    alertify.alert(data.msg);
                }
            }, "json");

            $.post(actionPath + "!sendEmail", {
                email: email,
                replyContent: replyContent
            }, function (data) {
                if (data.success) {
                    alertify.alert("发送成功");
                } else {
                    alertify.alert("发送失败");
                }
            });

            location.href = actionPath + "!hrefPage";
        } else {
            alertify.alert('邮箱和回复内容不能为空');
        }


        $('#modifyModal').modal('hide');

    });


$('#sendDetail').click(function () {
        var email = $('#email').val();
        var replyContent = $('#txtCode').val();
        var isShow = 0;
        var id=$('#entityId').val();
        if($('#checkbox').is(":checked")){
            isShow = $('#checkbox').val();
        }
        if (email != "" && replyContent != "") {
            $.post(actionPath + "!replyMessage", {
                isShow:isShow,
                email: email,
                replyContent: replyContent,
                id: id
            }, function (data) {
                if (data.success) {
                    alertify.alert(data.msg);
                } else {
                    alertify.alert(data.msg);
                }
            }, "json");

            $.post(actionPath + "!sendEmail", {
                email: email,
                replyContent: replyContent
            }, function (data) {
                if (data.success) {
                    alertify.alert("发送成功");
                } else {
                    alertify.alert("发送失败");
                }
            });

            location.href = actionPath + "!hrefPage";
        } else {
            alertify.alert('邮箱和回复内容不能为空');
        }


        $('#modifyModal').modal('hide');

    });


});

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}