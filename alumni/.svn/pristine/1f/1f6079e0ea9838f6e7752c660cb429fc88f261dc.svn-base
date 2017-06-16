/**
 * 校友活动管理--分会管理
 * pfhu@wisdombud.com
 * 20170329
 * */

 var actionPath = contextPath + "/alumni-activity";
 var $baseInfoForm;
 var $productInListForm;
 var cList = [];
 var editor;
 $(function () {
    validator();

    $("#create-btn").click(function () {
        addOrUpdate();
    });

    $("#specialSignUp").click(function () {
       $('#form-all').data('bootstrapValidator').destroy()
       validator();
       $("#isTimeHide").hide();
   });

    $("#ordinarySignUp").click(function () {
     $('#form-all').data('bootstrapValidator').destroy()
     validatorAll();
     $("#isTimeHide").show();
 })
    
    editor = buildUeditor('editor_id');

$("#btn-submit").click(function () {
    var bv = $baseInfoForm.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        var entity = $("form").serialize();
        $.post(actionPath + "!addOrUpdate", entity, function (data) {
            if (data.success) {
               alertify.alert("操作成功！",function(){
                 location.href = actionPath + "!hrefPage";
             });
           }
       }, "json");
    }
});
})


 function loadTable(cList) {
    var html = template("gridTpl", { 'results': cList });
    $("#gridBody").html(html);
}

function validator() {
    $baseInfoForm = $('#form-all');
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
            "entity.place": {
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

function validatorAll() {
    $baseInfoForm = $('#form-all');
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
            }
        }
    });
}