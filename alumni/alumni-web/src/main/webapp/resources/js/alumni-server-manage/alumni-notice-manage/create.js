/**
*  校友服务管理--校友通知
*  czjia
*  20170331
* */


var actionPath = contextPath + "/notice";

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
            "entity.noticeTitle": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.noticeType": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.noticeMode": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
           /*
           TODO:验证有问题
            "entity.noticeTemplate": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            */
            
        }

    });
}