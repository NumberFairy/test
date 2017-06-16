/**
 * 门户菜单管理--轮播图片管理
 *
 * zxguan@wisdombud.com
 * 20170413
 * */


var actionPath = contextPath + "/home-news-pic";
var $form = $('#baseInfoForm');
var options = {
    successCall: function(data, status) {
        $("#text").val(data.fileName);
        $("#file-id").val(data.f_id);
    }
}

$(function() {

    uploadFile(options);

    initValidator();
    $("#btn-submit").click(function() {
        var bv = $form.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            multiFormSubmit({
                url: actionPath + "!addOrUpdate",
                queryParam: $form.serialize()
            });
        }
    });


});

function initValidator() {
    $form.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.title": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写图片名称'
                    }
                }
            },
            "entity.picName": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请上传图片'
                    }
                }
            },
            "entity.linkUrl": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写指向链接'
                    }
                }
            },
        }
    });
}