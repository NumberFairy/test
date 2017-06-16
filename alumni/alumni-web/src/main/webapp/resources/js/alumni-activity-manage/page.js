/**
 * 校友活动管理--校友活动
 *
 * pfhu@wisdombud.com
 * 20170329
 * */

var actionPath = contextPath + "/alumni-activity";

$(function() {
    loadData();
    $("#btn-search").click(function() {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });

    $("#btn-detail").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();

    });

    $(".table").on('click', '.btn-apply', function() {
        var id = $(this).data('id');
        location.href = actionPath + "!hrefSignUpPage?signUpId=" + id;
    });

    $("#btn-update").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefAddOrUpdate?entity.id=" + getCheckedFirstId();
    });
    $("#update").click(function() {
        location.href = actionPath + "!hrefAddOrUpdate";
    });

    $("#btn-remove").click(function() {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？", function(e) {
            if (e) {
                $.post(actionPath + "!delete?id=" + ids.join(','), function(data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("删除成功");
                    }
                }, "json");
                location.href = actionPath + "!hrefPage";
            } else {
                return;
            }
        });
    });
});

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}