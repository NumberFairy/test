var actionPath = contextPath + "/check";
var $baseInfoForm;

$(function(){
    validator();

    $("#submit").click(function () {
         var bv = $baseInfoForm.data('bootstrapValidator');
         bv.validate();
        if (bv.isValid()) {
            var params = $("form").serialize();
            $.post(actionPath + "!addOrUpdate", params, function (data) {
                if (data.success) {
                    location.href = actionPath + "!page";   
                } else {                    
                    alertify.alert("保存失败");
                }
            }, "json");
        }        
    });
});

function validator(){
    $baseInfoForm = $('#baseInfoForm');
    $baseInfoForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.checkDepot": {
                validators: {
                    notEmpty: {
                        message: '请选择'
                    }
                }
            },
            "entity.checkTime": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请选择时间'
                    }
                }
            },
        }

    });
}