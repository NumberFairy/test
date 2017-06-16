/**
 * 校友管理中心--校友信息库
 * zxguan@wisdombud.com
 * 20170328
 * */

var actionPath = contextPath + "/alumni";
var $baseInfoForm;
var cList = [];
var ids = "";
$(function() {
    validator();
    initPage();
    var a = alumniClubIdentityId.split(',');
    var b = alumniIdentityId.split(',');
    var c = branchClubIdentityId.split(',');

    $("#btn-submit").click(function() {
        var bv = $baseInfoForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            var entity = $("#form-all").serialize();
            $.post(actionPath + "!addOrUpdate", entity, function(data) {
                if (data.success) {
                    location.href = actionPath + "!hrefPage";
                }
            }, "json");
        }
    });


});

function initPage() {
    creatDicOption("collegeId", "/dic-common!findAllCollege", '', collegeId); //院系字典
    creatDicOption("majorId", "/dic-common!findAllCollegeSpecialty", { 'id': collegeId }, majorId); //专业院字典
    $('#collegeId').change(function() {
        creatDicOption("majorId", "/dic-common!findAllCollegeSpecialty", { 'id': $(this).val() }, majorId);
    });
    creatDicOption("reVarchar0-sel", "/dic-common!findAllNational", '', reVarchar0); //民族
    creatDicOption("industry-sel", "/dic-common!findDicIndustry", '', industry); //行业
    creatDicOption("politicalStatus-sel", "/dic-common!findPoliticalStatus", '', politicalStatus); //政治面貌
    creatDicOption("highestEducation-sel", "/dic-common!findAllDicDegree", '', highestEducation); //学历   
    multipleSel('alumniIdentityName-sel', '/dic-common!findAllDicAlumniIdentity', alumniIdentityId); //校友身份
    multipleSel('alumniClubIdentityName-sel', '/dic-common!findAllAlumniClubIdentity', alumniClubIdentityId); //校友会任职身份
    multipleSel('branchClubIdentityName-sel', '/dic-common!findDicAlumniBranchIdentity', branchClubIdentityId); //校友分会任职身份
    //绑定地区选择插件
    $(".address").districtpicker({
        url: contextPath + '/dic-common!findAllDistricts',
        level: 1,
        global: true, //是否有国家
        onchange: function(obj) {
            // var bv = $form.data('bootstrapValidator');
            // //手动触发验证
            // bv.revalidateField(obj);
        }
    });
    //绑定地区选择插件
    $(".companyAddress").districtpicker({
        url: contextPath + '/dic-common!findAllDistricts',
        level: 3,
        global: true, //是否有国家
        onchange: function(obj) {
            // var bv = $form.data('bootstrapValidator');
            // //手动触发验证
            // bv.revalidateField(obj);
        }
    });

    $("#codeId").blur(function() {
        if (!validateCode()) {
            alertify.alert("此学号/职工号已存在！");
            $("#codeId").empty();
        }
    });
}

function validator() {
    $baseInfoForm = $('#form-all');
    $baseInfoForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.name": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.enrollYear": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.phone": {
                validators: {
                    notEmpty: {
                        message: '请填写手机'
                    },
                    regexp: {
                        regexp: /^1\d{10}$/,
                        message: '请输入有效的手机'
                    }
                }
            },
            "entity.email": {
                validators: {
                    notEmpty: {
                        message: '请填写邮箱'
                    },
                    regexp: {
                        regexp: /^(?=\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$).{0,30}$/,
                        message: '输入的不是一个有效的邮箱'
                    }
                }
            },
            "entity.code": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.birthDate": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.nativeStr": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
            "entity.companyCityStr": {
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