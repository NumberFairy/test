/**
 * 门户菜单管理--友情连接管理
 *
 * xushuai@wisdombud.com
 * 20170416
 * */


var actionPath = contextPath + "/home-friendship-link";
var $form = $('#baseInfoForm');

$(function() {

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

    uploadFile({
        btnId: "btnImgUpLoad",
        fileId: "imgUpload",
        successCall: function(data, status, a) {
            $('#imgId').val(data.f_id);
            $('#imgName').val(data.fileName);
        }
    });

});

function initValidator() {
    $form.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.name": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写链接名称'
                    }
                }
            },
            "entity.sortFlag": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写排序字段'
                    }
                }
            },
            "entity.linkUrl": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写链接地址'
                    }
                }
            },
        }
    });
}