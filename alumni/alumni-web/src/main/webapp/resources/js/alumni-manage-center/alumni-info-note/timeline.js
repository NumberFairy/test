/**
 * 校友管理中心--校友信息库--时光轴
 *
 * zxguan@wisdombud.com
 * 20170303
 * */

var actionPath = contextPath + "/timeline";
var alumniId = $("#alumniId").val();
$(function () {
    validator();
    loadTimelineData();


    $("#btn-add").click(function () {
        var h = template("timeline-tpl", {});
        $("#baseForm").html(h);
        $('#timelineModel').modal();
        $("#alumniId2").val($("#alumniId").val());
    });

    $("#timelineSubmit").click(function () {
        var bv = $baseInfoForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            var timelineEntity = $("#baseForm").serialize();
            $.post(actionPath + "!addOrUpdate", timelineEntity, function (data) {
                if (data.success) {
                    $('#timelineModel').modal("hide");
                    loadTimelineData();
                }
            }, "json");
        }
    });

    $("#gridBodyTimeline").on("click", '.edit', function () {
        var id = $(this).data('id');
        $.post(actionPath + "!detail", { "id": id }, function (data) {
            var h = template("timeline-tpl", data);
            $("#baseForm").html(h);
            $('#timelineModel').modal();
            loadTimelineData();
        }, "json");


    });

    $("#gridBodyTimeline").on("click", ".remove", function () {
        id = $(this).data('id');
        alertify.confirm("确认要移除吗？", function (e) {
            if (e) {
                $.post(actionPath + "!delete?id=" + id, function (data) {
                    if (data.success) {
                        loadTimelineData();
                    } else {
                        alertify.alert("操作失败");
                    }
                }, "json")
            } else {
                return;
            }
        })
    });


});


function loadTimelineData() {
    $.post(actionPath + "!findTimelineData", "id=" + alumniId, function (data) {

        var html = template("gridTplTimeline", { 'list': data });
        $("#gridBodyTimeline").html(html);
    }, "json");
}

function validator() {
    $baseInfoForm = $('#baseForm');
    $baseInfoForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.title": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.content": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },

        }

    });
}
