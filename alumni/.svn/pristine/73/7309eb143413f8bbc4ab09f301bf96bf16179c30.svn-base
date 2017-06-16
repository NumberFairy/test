var actionPath = contextPath + "/alumni-import";

$(function () {
    loadData();
    uploadFile({
        subfix: ['xlsx'],
        subfixTip: "请选择Excel的xlsx文件！",
        successCall: function (data, status, a) {
            $('[name=attachementPath]').val(data.fileName);
            $.post(actionPath + "!importExcel", { "f_id": data.f_id }, function (data) {
                if (data.success) {
                    alertify.alert(data.message);
                    $("#myModal-import").modal("hide");
                    loadData();
                } else {
                    alertify.alert(data.message);
                }

            }, "json");
        }
    });

    $("#btn-import").click(function () {
        var html = template("importTpl");
        $("#import-body").html(html);
        $("#myModal-import").modal();
    });

    $("#btn-sure").click(function () {
        alertify.confirm("确定要全部导入吗？", function (e) {
            if (e) {
                $.post(actionPath + "!saveReal", function (data) {
                    if (data.success) {
                        alertify.alert("导入成功");
                    }
                }, "json");
                location.href = contextPath + "/alumni!hrefPage";
            } else {
                return;
            }
        });
    });

    $("#btn-detail").click(function () {
        if (judgeCheckedOneId()) {
            location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
        }
    });
});

function loadData() {
    $().srli
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}
