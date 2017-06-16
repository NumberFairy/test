/**
 * 我的办公桌
 * zhangyan@wisdombud.com
 * 20170407
 */
 var actionPath = contextPath + "/my-desk";
 var eventActionPath = contextPath + "/event";
 var memoActionPath = contextPath + "/memo";
 var memoList = [];
 var eventList = [];
 var data = [];
 var tplname;
 var modalName;
 var addBodyName;
 $(function() {
    loadData();
    loadEventData();
    initRemind();
    $("#btn-memo-add").click(function() {
        nowDate = getNowFormatDate();
        data = { "memoTime": nowDate };
        addOrCheck("memo", data);
        initMemoValidator();
    });

    $("#btn-ev-add").click(function() {
        nowDate = getNowFormatDate();
        data = { "eventTime": nowDate };
        evAddOrCheck(data);
        initEventValidator();
    });

    $('#remindMore').click(function(){
        location.href=actionPath+"!toRemind";
    });

    $("#addMemo").click(function() {
        saveMemo();
    });

    $("#addEvent").click(function() {
        saveEvent();
    });

    $("#gridBodyMemo").on("click", '.detail', function() {
        id = $(this).data('id');
        detailMemo();
    });

    $("#gridBodyMemo").on("click", '.success', function() {
        ids = $(this).data('id');
        alertify.confirm("确认标记为完成？", function(e) {
            if (e) {
                completeMemo();
            } else {
                return;
            }
        })
    });

    $("#gridBodyEvent").on("click", '.edit', function() {
        id = $(this).data('id');
        editEvent();
    });

    $("#gridBodyEvent").on("click", ".remove", function() {
        ids = $(this).data('id');
        alertify.confirm("确认标记为完成？", function(e) {
            if (e) {
                removeEvent();
            } else {
                return;
            }
        })
    });

    $("#memoMore").click(function() {
        location.href = memoActionPath + "!hrefPage";
    })

    $("#eventMore").click(function() {
        location.href = eventActionPath + "!hrefPage";
    });
});
/**
 * callType:event(校友大事件相关模态框)、memo(备忘录相关模态框)
 */
 function addOrCheck(callType, data) {
    // getNameByParam(callType);
    if (callType = "memo") {
        tplname = "tpl-memo";
        modalName = "#memoModal";
        addBodyName = "#add-memo";
    } else if (callType = "event") {
        tplname = "tpl-event";
        modalName = "#eventModal";
        addBodyName = "#add-event";
    }
    var html = template(tplname, data);
    if (data.id) {
        $(".modal-title", modalName).html("查看");
    } else {
        $(".modal-title", modalName).html("新增");
    }
    $(addBodyName).html(html);
    formTime();
    $(modalName).modal();
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
    }).on('changeDate', function(ev) {
        $(this).trigger("blur");
    });
}

/**
 * 移除校友工作大事记
 */
 function removeEvent() {
    $.post(eventActionPath + "!changeStatus?ids=" + ids, function(data) {
        if (data.success) {
            location.href = actionPath + "!hrefPage";
        } else {
            alertify.alert("操作失败");
        }
    }, "json")
}

/**
 * 待处理方法
 * 通过传参得到变量值
 */
 function getNameByParam(callType) {
    if (callType = "1") {
        tplname = "tpl-event";
        modalName = "#eventModal";
        addBodyName = "#add-event";
    }
    if (callType = "0") {
        tplname = "tpl-memo";
        modalName = "#memoModal";
        addBodyName = "#add-memo";
    }
}

/**
 * 编辑校友工作大事记
 */
 function editEvent() {
    $.post(eventActionPath + "!detail?id=" + id, function(data) {
        var objectEvent = {
            id: data.id,
            eventTitle: data.eventTitle,
            eventContent: data.eventContent,
            eventTime: data.eventTime
        }
        evAddOrCheck(objectEvent);
    }, "json")
}

/**
 * 已完成
 */
 function completeMemo() {
    $.post(memoActionPath + "!changeStatus?ids=" + ids, function(data) {
        // var data = JSON.parse(data);
        if (data.success) {
            location.href = actionPath + "!hrefPage";
        } else {
            alertify.alert("修改失败");
        }
    }, "json")
}

/**
 * 查看备忘录信息
 */
 function detailMemo() {
    $.post(memoActionPath + "!detail?id=" + id, function(data) {
        var object = JSON.parse(data);
        var objectMemo = {
            isReadOnly: 1,
            id: object.id,
            title: object.title,
            content: object.content,
            memoTime: object.memoTime,
        }
        memoAddOrCheck(objectMemo);
    });
}

/**
 * 保存校友工作大事记
 */
 function saveEvent() {
    var bv = $eventForm.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        var entity = $("#eventForm").serialize();
        $.post(eventActionPath + "!addOrUpdate", entity, function(data) {
            if (data.success) {
                location.href = actionPath + "!hrefPage";
            } else {
                alertify.alert("保存失败");
            }
        }, "json");
    }
}

/**
 * 保存备忘录信息 
 */
 function saveMemo() {
    var bv = $memoForm.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        var entity = $("#memoForm").serialize();
        $.post(memoActionPath + "!addOrUpdate", entity, function(data) {
            if (data.success) {
                location.href = actionPath + "!hrefPage";
            } else {
                alertify.alert("保存失败");
            }
        }, "json");
    }
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

function evAddOrCheck(data) {
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

function eventAddOrUpdate(data) {
    var html = template("tpl-event", data);
    if (data) {
        $(".modal-title", "#eventModal").html("新增");
    } else {
        $(".modal-title", "#eventModal").html("修改");
    }
    $("#add-event").html(html);
    formTime();
    $("#eventModal").modal();
}

function loadData() {
    $.post(actionPath + "!findAllData", function(data) {
        for (var i = 0; i < data.length; i++) {
            memoList.push(data[i]);
        }
        var html = template("gridTplMemo", { 'memoList': memoList });
        $("#gridBodyMemo").html(html);
    }, 'json');
}

function loadEventData() {
    $.post(actionPath + "!findEventData", function(data) {
        var date = new Date();
        var year = date.getFullYear();
        var i = 0;
        for (i; i < data.length; i++) {
            if (data[i].eventTime >= year + "-00-00 00:00:00" && data[i].eventTime <= year + "-12-31 23:59:59") {
                eventList.push(data[i]);
            }
        }
        var html = template("gridTplEvent", { 'eventList': eventList });
        $("#gridBodyEvent").html(html);
    }, "json");
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

function initEventValidator() {
    $eventForm = $('#eventForm');
    $eventForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.eventTitle": {
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

function initRemind(){
    $.post(actionPath+'!pageRemind',{limit:5},function(data){
       var h = template('remind-tpl', data);
       $('#remind').html(h);
   },'json')
}