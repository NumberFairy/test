/**
 * 校友工作大事记
 * zhangyan@wisdombud.com
 * 20170408
 */
var actionPath = contextPath + "/event";
$(function() {
    loadData();

    $("#addEvent").click(function() {
        nowDate = getNowFormatDate();
        data = { "eventTime": nowDate };
        eventAddOrCheck(data);
        initEventValidator();
    });

    $("#detail").click(function() {
        detail();
    });

    $("#saveEvent").click(function() {
        saveEvent();
    });

    $("#alert").click(function() {
        alter();
    });

    $("#search").click(function() {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });

    $("#complete").click(function() {
        complete();
    });

    $("#delete").click(function() {
        deleteByIds();
    });

    $("#export").click(function() {
        location.href = "event!exportEvents?" + $("#form").serialize();
    });

});

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
 * 根据id删除数据
 */
function deleteByIds() {
    if (!judgeCheckedIds()) {
        return;
    }
    alertify.confirm("确认删除所选项？", function(e) {
        if (e) {
            var ids = getCheckedIds();
            $.post(actionPath + "!deleteByIds?ids=" + ids, function(data) {
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
    alertify.confirm("确认标记为完成？", function(e) {
        if (e) {
            var ids = getCheckedIds();
            $.post(actionPath + "!changeStatus?ids=" + ids.join(','), function(data) {
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
 * 保存新增备忘录数据
 */
function saveEvent() {
    var bv = $eventForm.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        var entity = $("#eventForm").serialize();
        $.post(actionPath + "!addOrUpdate", entity, function(data) {
            if (data.success) {
                loadData();
            } else {
                alertify.alert("保存失败");
            }
        }, "json");
    }
    $("#eventModal").modal("hide");
}

/**
 * 点击查看弹出模态框
 */
function detail() {
    if (!judgeCheckedOneId()) {
        return;
    }
    var id = getCheckedFirstId();
    $.post(actionPath + "!detail?id=" + id, function(data) {
        var object = JSON.parse(data);
        var objectEvent = {
            isReadOnly: 1,
            id: object.id,
            eventTitle: object.eventTitle,
            eventContent: object.eventContent,
            eventTime: object.eventTime,
        }
        eventAddOrCheck(objectEvent);
    })
}

/**
 * 点击修改弹出模态框
 */
function alter() {
    if (!judgeCheckedOneId()) {
        return;
    }
    var id = getCheckedFirstId();
    $.post(actionPath + "!detail?id=" + id, function(data) {
        var object = JSON.parse(data);
        var objectEvent = {
            id: object.id,
            eventTitle: object.eventTitle,
            eventContent: object.eventContent,
            eventTime: object.eventTime,
        }
        eventAddOrCheck(objectEvent);
    })
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
    }).on('changeDate', function(ev) {
        $(this).trigger("blur");
    });
}

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}

function eventAddOrCheck(data) {
    var html = template("tpl-event", data);

    if (data.id) {
        $(".modal-title", "#eventModal").html("查看");
    } else {
        $(".modal-title", "#eventModal").html("新增");
    }
    $("#add-event").html(html);
    formTime();
    $("#eventModal").modal();
    initEventValidator();
}


function initEventValidator() {
    $eventForm = $('#eventForm');
    $eventForm.bootstrapValidator({
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
            "entity.eventTime": {
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