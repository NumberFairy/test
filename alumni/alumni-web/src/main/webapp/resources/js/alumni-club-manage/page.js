/**
 * 校友会管理--分会管理
 *
 * zxguan@wisdombud.com
 * 20170329
 * */

var actionPath = contextPath + "/alumni-club";

$(function() {
    loadData();

    $("#btn-search").click(function() {
        loadData();
    });

    $("#btn-update").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefAddOrUpdate?type=" + type + "&id=" + getCheckedFirstId();
    });

    $("#btn-detail").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId() + "&type=" + type;
    });

    $("#btn-delete").click(function() {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？",  function (e)  {            
            if  (e)  {                
                $.post(actionPath  +  "!delete?id="  +  ids.join(',') + "&type=" + type,  function (data)  {                    
                    if  (data.success)  {
                        alertify.alert("删除成功");
                        window.location.reload();                 
                    }                
                },  "json");
            } 
            else  {
                return;
            }    
        });
    });

    $("#btn-email").click(function () {
		if (!judgeCheckedIds()) {
		    return;
		}
        var ids = getCheckedIds();
        $.post(actionPath + "!forEmail?id=" + ids, function (data) {
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
            $.post(actionPath + "!sendMail", {
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

    $("#btn-download").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!downloadFile?f_id=" + getCheckedFirstId();
    });

    $(document).on('click', "#btn-import", function() {
    	$('#upload').click();
    });

    $(document).on('change', '#upload', function(e){
		var file = this.files[0];
		if (file) {
			upload(file);
		}
	});

    $("#reach").click(function () {
        var params = $("#form").serialize();
        var options = {
            url:  actionPath + "!page?type=" + type,
            queryParams: params
        };
        loadPaginationData(options);
    });
});

var ALLOW_EXTENTION = ".xls,.xlsx";
function upload(file) {
	var fileName = file.name;
	var extention = fileName.substring(fileName.lastIndexOf('.'));
	if (ALLOW_EXTENTION.indexOf(extention) > -1) {
		_doUpload();
	} else {
		alertify.alert("不支持该文件格式");
	}
}

function _doUpload(options){
	$.ajaxFileUpload({
		 url: actionPath + '!importFile',
		 secureuri: false,
		 fileElementId: 'upload',
		 dataType: 'json',
		 success: function(data, status) {
		 },
		 error: function(data, status, e) {
			 alertify.alert(e + "");
		 }
	});

}

function loadData() {
    var options = {
        url: actionPath + "!page?type=" + type
    };
    loadPaginationData(options);
}