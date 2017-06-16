
var $baseInfoForm;
$(function () {

    var alumniId = $("#alumni-id").val();
    $.post(contextPath + "person-info!findEntity?id=" + alumniId, function (data) {
        var h = template("modelTpl", data);
        $("#modelBody").html(h);
        validator();
        creatDicOption("collegeId", contextPath + "/person-info!findCollege", '', data.college);
        creatDicOption("majorId", contextPath + "/person-info!findSpecialty", { id: data.college }, data.major);
        creatDicOption2("politicalStatus", contextPath + "/person-info!findPoliticalStatus", '', data.politicalStatus);
        creatDicOption("educationId", contextPath + "/person-info!findDegree", '', data.highestEducation);
        creatDicOption2("industryId", contextPath + "/person-info!findIndustry", '', data.industry);

        $("#modelBody").on('click', '#collegeId', function () {
            var id = $("#collegeId option:selected").val();

            creatDicOption("majorId", contextPath + "/person-info!findSpecialty", { id: id }, '', data.major);

        });


        //年-月-日
        $('.form_date').datetimepicker({
            format: 'yyyy-mm-dd',
            language: 'zh-CN',
            autoclose: true,
            startView: 2,
            minView: 2,
            forceParse: false,
            todayBtn: true
        }).on('changeDate', function (ev) {
            $(this).trigger("blur");
        });

        //年份
        $('.form_year').datetimepicker({
            format: 'yyyy',
            language: 'zh-CN',
            autoclose: true,
            startView: 4,
            minView: 4,
            forceParse: false
        }).on('changeDate', function (ev) {
            $(this).trigger("blur");
        });

        //绑定地区选择插件
        $(".address").districtpicker({
            url: contextPath + '/dic-common!findAllDistricts',
            level: 1,
            global: true,//是否有国家
            onchange: function (obj) {
                // var bv = $form.data('bootstrapValidator');
                // //手动触发验证
                // bv.revalidateField(obj);
            }
        });
        //绑定地区选择插件
        $(".companyAddress").districtpicker({
            url: contextPath + '/dic-common!findAllDistricts',
            level: 3,
            global: true,//是否有国家
            onchange: function (obj) {
                // var bv = $form.data('bootstrapValidator');
                // //手动触发验证
                // bv.revalidateField(obj);
            }
        });

    }, 'json');

    $("#btn-submit").click(function () {
        var bv = $("#modelBody").data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            var entity = $("#modelBody").serialize();
            $.post(contextPath + "/person-info!addOrUpdate", entity, function (data) {
                if (data.success) {
                    alertify.alert("保存成功！");
                }
            }, "json");
        }
    });

});

function creatOption(data, divID, selected) {
    if (data !== null && data.length > 0) {
        var html = "";
        $.each(data, function (i, value) {
            if (value.id == selected) {
                html += "<option value='" + value.id + "' selected='true'>" +
                    value.cnName + "</option>";
            } else {
                html += "<option value='" + value.id + "'>" + value.cnName +
                    "</option>";
            }
        });
        $("#modelBody #" + divID).html(html);
    }
}

function creatOption2(data, divID, selected) {
    if (data !== null && data.length > 0) {
        var html = "";
        $.each(data, function (i, value) {
            if (value.id == selected) {
                html += "<option value='" + value.id + "' selected='true'>" +
                    value.value + "</option>";
            } else {
                html += "<option value='" + value.id + "'>" + value.value +
                    "</option>";
            }
        });
        $("#modelBody #" + divID).html(html);
    }
}

/**
 * 创建查库下拉
 */
function creatDicOption(divID, url, params, selected, callback) {
    $.post(url, params, function (data) {
        creatOption(data, divID, selected)

        if (callback && typeof callback == "function") {
            callback(data, selected);
        }
    }, "json");
}

function creatDicOption2(divID, url, params, selected, callback) {
    $.post(url, params, function (data) {
        creatOption2(data, divID, selected)

        if (callback && typeof callback == "function") {
            callback(data, selected);
        }
    }, "json");
}

function validator() {
    $baseInfoForm = $('#modelBody');
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
            }
        }
    });
}