/**
 * 备忘录
 * zhangyan@wisdombud.com
 * 20170408
 */
var actionPath = contextPath + "/memo";
$(function () {
    loadData();

    $("#addMemo").click(function () {
        nowDate = getNowFormatDate();
        data = { "memoTime": nowDate };
        memoAddOrCheck(data);
        initMemoValidator();
    });

    $("#detail").click(function () {
        detail();
    });

    $("#saveMemo").click(function () {
        saveMemo();
    });

    $("#alert").click(function () {
        alter();
    });

    $("#complete").click(function () {
        complete();
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
        deleteByIds();
    });

    $("#search").click(function () {
        var searchText = $("#seText").val();
        var options = {
            url: actionPath + "!page?searchText=" + searchText,
        };
        loadPaginationData(options);
    });
});

function alter() {
    if (!judgeCheckedOneId()) {
        return;
    }
    var id = getCheckedFirstId();
    $.post(actionPath + "!detail?id=" + id, function (data) {
        var object = JSON.parse(data);
        var objectMemo = {
            id: object.id,
            title: object.title,
            content: object.content,
            memoTime: object.memoTime,
        }
        memoAddOrCheck(objectMemo);
    })
}

/**
 * 根据id删除数据
 */
function deleteByIds() {
    if (!judgeCheckedIds()) {
        return;
    }
    alertify.alert("确认删除所选项？", function (e) {
        if (e) {
            var ids = getCheckedIds();
            $.post(actionPath + "!deleteByIds?ids=" + ids, function (data) {
                if (data.success) {
                    loadData();
                } else {
                    alertify.alert("操作失败");
                }
            }, "json");
        } else {
            return;
        }
    })
}

/**
 * 点击完成改变事件状态
 */
function complete() {
    if (!judgeCheckedIds()) {
        return;
    }
    alertify.confirm("确认标记为完成？", function (e) {
        if (e) {
            var ids = getCheckedIds();
            $.post(actionPath + "!changeStatus?ids=" + ids.join(','), function (data) {
                if (data.success) {
                    loadData();
                } else {
                    alertify.alert("操作失败");
                }
            }, "json")
        } else {
            return;
        }
    })
}
/**
 * 保存新增备忘录数据
 */
function saveMemo() {
    var bv = $memoForm.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        var entity = $("#memoForm").serialize();
        $.post(actionPath + "!addOrUpdate", entity, function (data) {
            if (data.success) {
                // location.href = actionPath + "!hrefPage";
                loadData();
            } else {
                alertify.alert("保存失败");
            }
        }, "json");
    }
    $("#memoModal").modal("hide");
}

/**
 * 点击查看弹出模态框
 */
function detail() {
    if (!judgeCheckedOneId()) {
        return;
    }
    var id = getCheckedFirstId();
    $.post(actionPath + "!detail?id=" + id, function (data) {
        var object = JSON.parse(data);
        var objectMemo = {
            isReadOnly: 1,
            id: object.id,
            title: object.title,
            content: object.content,
            memoTime: object.memoTime,
        }
        memoAddOrCheck(objectMemo);
    })
}

/**
 * 获取当前时间
 */
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate +
        " " + date.getHours() + seperator2 + date.getMinutes() +
        seperator2 + date.getSeconds();
    return currentdate;
}

/**
 * 引入时间插件
 */
function formTime() {
    $('.form_time').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:00',
        language: 'zh-CN',
        showMeridian: true,
        autoclose: true,
        use24hours: true,
        todayBtn: true
    }).on('changeDate', function (ev) {
        $(this).trigger("blur");
    });
}

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}

function memoAddOrCheck(data) {
    var html = template("tpl-memo", data);

    if (data.id) {
        $(".modal-title", "#memoModal").html("查看");
    } else {
        $(".modal-title", "#memoModal").html("新增");
    }
    $("#add-memo").html(html);
    formTime();
    $("#memoModal").modal();
    initMemoValidator();
}


function initMemoValidator() {
    $memoForm = $('#memoForm');
    $memoForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.title": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请输入标题'
                    }
                }
            },
            "entity.memoTime": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请选择录入时间'
                    },
                }
            },

        }
    });
}