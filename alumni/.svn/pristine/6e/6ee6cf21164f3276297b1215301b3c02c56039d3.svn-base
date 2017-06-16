/**
*  校友服务管理--校友登记
*  czjia
*  20170329
* */


var actionPath = contextPath + "/alumni-enroll";

var $baseInfoForm;
$(function() {
    validator();
    $("#btn-submit").click(function() {
        var bv = $baseInfoForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            var params = $("form").serialize();
            $.post(actionPath + "!addOrUpdate", params, function(data) {
                if (data.success) {
                    location.href = actionPath + "!hrefPage";
                } else {
                    alertify.alert("保存失败");
                }
            }, "json");
        }
    });
});

function validator() {
    $baseInfoForm = $('#form-all');
    $baseInfoForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.people": {
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
        }

    });
}