/**
*  校友服务管理--校友通知
*  czjia
*  20170331
* */
var actionPath = contextPath + "/notice";

$(function () {
    loadData();
    $("#btn-search").click(function () {
        var aa = $('.btn-aaaa');
        loadData();
    });

    $(".table").on('click','.btn-disable', function () {
        var id = $(this).data('id');
        alertify.confirm("确定要停用吗？", function  (e) {
            if (e) {
                $.post(actionPath + "!oper", { 'id': id }, function  (data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("停用成功");
                    }
                }, "json");
                location.href = actionPath + "!hrefPage";
            }
            else {
                return;
            }
        }, "json");

    });
$(".table").on('click','.btn-enable', function () {
        var id = $(this).data('id');
        alertify.confirm("确定要启用吗？", function  (e) {
            if (e) {
                $.post(actionPath + "!oper", { 'id': id }, function  (data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("启用成功");
                    }
                }, "json");
                location.href = actionPath + "!hrefPage";
            }
            else {
                return;
            }
        }, "json");
    });

    $("#btn-detail").click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
    });

    $("#btn-update").click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefAddOrUpdate?id=" + getCheckedFirstId();
    });

    $("#btn-delete").click(function () {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？", function  (e) {
            if (e) {
                $.post(actionPath + "!delete?id=" + ids.join(','), function  (data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("删除成功");
                    }
                }, "json");
                location.href = actionPath + "!hrefPage";
            }
            else {
                return;
            }
        });
    });
    
    $("#reach").click(function () {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });
});

function loadData() {
    var options = {
        url: actionPath + "!page",
        queryParams: {
            enrollTypeContent: $("#enrollTypeContent").val(),
            peopleContent: $("#peopleContent").val(),
            placeContent: $("#placeContent").val(),
            contentContent: $("#contentContent").val(),
            startTimeContent: $("#startTimeContent").val(),
            endTimeContent: $("#endTimeContent").val()
        }
    };
    loadPaginationData(options);
}