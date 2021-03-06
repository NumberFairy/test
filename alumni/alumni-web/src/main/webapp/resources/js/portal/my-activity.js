var actionPath = contextPath + "/alumni-activity-apply";
var $infoForm;
$(function() {
    var alumniId = $("#alumni-id").val();
    $.post(contextPath + "home!myActivity?id=" + alumniId, function(data) {
        var h = template("gridTpl", { 'results': data });
        $("#list-body").html(h);
    }, 'json')
    validator();
    $("#submit").click(function() {
        var bv = $("#infoForm").data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            var params = $("#infoForm").serialize();
            $.post(actionPath + "!addOrUpdate", params, function(data) {
                if (data.success) {
                    location.href = actionPath + "!hrefPage";
                } else {
                    alertify.alert("保存失败");
                }
            }, "json");
        }
    });

    $("#specialSignUp").click(function() {
        $("#timeIsHidden").hide();
    });

    $("#ordinarySignUp").click(function() {
        $("#timeIsHidden").show();
    });



    var options = {
        'url': contextPath + "/alumni-activity-apply!page",
        'queryParams': {
            'id': alumniId
        }
    };
    loadPaginationData(options);
});

function validator() {
    $infoForm = $("#infoForm");
    $infoForm.bootstrapValidator({
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
            "entity.place": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.startTime": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.endTime": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.applyStartTime": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.applyEndTime": {
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