/*
 * 发布活动*/

var actionPath = contextPath + "/alumni-activity-apply";

$(function() {
    // $.post(actionPath + "!activityAuditPage", function(data) {
    //     var h = template("gridTpl", { 'results': data });
    //     $("#gridBody").html(h);
    // }, 'json')

    loadData();
    $("#detail").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefActivityAuditDetail?id=" + getCheckedFirstId();
    });

    $("#btn-search").click(function() {
        var params = $("#form").serialize();
        loadData(params);
    });

    $(".table").on('click', '#auditId', function() {
        var id = $(this).data('id');
        var status = $(this).data('status');
        var info;
        if (status == 1) {
            info = "通过";
        }
        if (status != 1) {
            info = "不通过";
        }
        alertify.confirm("确定要" + info + "吗？", function(e) {
            if (e) {
                $.post(actionPath + "!doAudit", { 'id': id, 'auditStatus': status }, function(data) {
                    if (data.success) {
                        alertify.alert(info + "成功");
                    }
                }, "json");
                loadData();
                window.location.reload();
            } else {
                return;
            }
        }, "json");
    });
});


function loadData(params) {
    var options;
    if (params) {
        options = {
            url: actionPath + "!activityAuditPage",
            queryParams: params
        };
    } else {
        options = {
            url: actionPath + "!activityAuditPage",
        };
    }
    loadPaginationData(options);
}