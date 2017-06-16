var actionPath = contextPath + "/check";

$(function() {
    loadData();
    
    $("#search-btn").click(function () {
        loadData();
    });

    $("#detail").click(function () {
         if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!detail?id=" + getCheckedFirstId();
    });

    $("#update").click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!addOrUpdate?id=" + getCheckedFirstId();
    });

    $("#delete").click(function () {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        $.post(actionPath + "!delete?id=" + ids.join(','), function (data) {
            if (data.success) {
                loadData();
                alertify.alert("删除成功");
            }
        }, "json");
        location.href = actionPath + "!page";
    });
});

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}
