/**
 * 用户管理
 *
 * zxguan@wisdombud.com
 * 20170321
 *
 */

var actionPath = contextPath + "/user-manage";

$(function () {
    loadData();

    $("#search-btn").click(function () {
        loadData();
    });

    $("#reach").click(function () {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });
    $("#btn-update").click(function () {
        if (judgeCheckedOneId()) {
            location.href = actionPath + "!hrefAddOrUpdate?id=" + getCheckedFirstId();
        }
    });

    $("#btn-detail").click(function () {
        if (judgeCheckedOneId()) {
            location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
        }
    });

    $("#btn-delete").click(function () {
        if (judgeCheckedIds()) {
            var ids = getCheckedIds();
            alertify.confirm("确定要删除吗？", function (e) {
                if (e) {
                    $.post(actionPath + "!delete", { "id": ids.join(',') }, function (data) {
                        if (data.success) {
                            loadData();
                        } else {
                            alertify.alert("删除失败!");
                        }
                    }, "json");
                } else {
                    return;
                }
            });
        }
    });
    $("#saveRole").click(function () {
        var a = $('#formRole').serialize();
        $.post(actionPath+'!updateRole',a,function(data){
             $('#modifyModal').modal('hide');
        },'json');
    });


    $("#btn-reset").click(function () {
        if (judgeCheckedIds()) {
            var ids = getCheckedIds();
            alertify.confirm("确定重置密码？", function (e) {
                if (e) {
                    $.post(actionPath + "!resetPassword", { "id": ids.join(',') }, function (data) {
                        alertify.alert(data.message);
                    }, "json");
                } else {
                    return;
                }
            });
        }
    });

    $("#btn-role").click(function () {
        if (judgeCheckedOneId()) {
            var roleId = $('#roleId').val();
            var userId = getCheckedIds()[0];
            $.post(actionPath + "!findRelation", { "userId": userId }, function (data) {
                creatDicOption('roleId', actionPath + "!findUserRole", '', data.roleId);
                $('#user-name').text(data.name);
                $('#userId').val(data.id);
                $('#modifyModal').modal('show');
            }, "json");
        }
    })
});


function loadData() {

    var options = {
        url: actionPath + "!page",
        queryParams: $("form").serialize()
    };
    loadPaginationData(options);
}
