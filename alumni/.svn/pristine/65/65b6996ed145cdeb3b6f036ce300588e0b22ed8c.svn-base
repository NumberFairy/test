/**
 * 校友会管理--分会管理--成员
 *
 * zxguan@wisdombud.com
 * 20170328
 * */

var actionPath = contextPath + "/alumni-club";
var alumniPath = contextPath + "/alumni";
$(function() {
    loadData();
    $("#search-btn").click(function() {
        loadData();
    });

    $(document).on('click', '#btn-remove', function(e){
    	var id = $(this).data("id");
    	$.ajax({
            url: contextPath + "/branch-relation!delete",
            dataType: "json",
            method: 'post',
            data: {id: id}
        }).then(function(data) {
        	window.location.reload();
        });
    });

    $("#btn-detail").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        var alumniid = $('.child:checked').data("alumniid");
        location.href = alumniPath + "!hrefDetail?id=" + alumniid;
    });

    $("#btn-email").click(function () {
		if (!judgeCheckedIds()) {
		    return;
		}
	    var ids = [];
		var $checkedItems = $('.child:checked');
		$.each($checkedItems, function(i, obj){
			ids.push($(obj).data("alumniid"));
		});
        $.post(alumniPath + "!forEmail?id=" + ids, function (data) {
            if (data.success) {
                $("#emailAddress").val(data.message);
            }
        }, "json");

        $('#myModal').modal({
            keyboard: false
        });
    });

    $("#emailSubmit").click(function () {
        var flag = false;
        var title = $('#title').val();
        var email = $('#emailAddress').val();
        var replyContent = $('#emailContent').val();
        if (email != "" && replyContent != "") {
            $.post(alumniPath + "!sendMail", {
                title: title,
                email: email,
                replyContent: replyContent
            }, function (data) {
                if (data.success) {
                    alertify.alert("发送成功");

                } else {
                    alertify.alert("发送失败");
                }
                setTimeout(function () {
                    window.location.reload();
                }, 500);
            }, "json");

        } else {
            alertify.alert('邮箱和回复内容不能为空');
        }
    });

});

function loadData() {
    var options = {
        url: actionPath + "!pageMember?id=" + id
    };
    loadPaginationData(options);
}