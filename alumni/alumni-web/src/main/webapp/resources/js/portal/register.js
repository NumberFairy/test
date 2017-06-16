/**
*  注册
*  xiefei
* */
$(function() {
    init();
    validator();

    $("#user-btn").click(function() {
        var alumniId=   getCheckedIds("#user-model");
        if(alumniId.length!=1){
            alertify.alert("选择一条记录！");
            return;
        }
        var userId=  $("#id").val();
        $.post("/login!updateRegister",{'alumnid':alumniId[0],'id':userId},function(data){
            if(data){
                alertify.alert("提交成功,请等待管理员审核！",function(){
                    top.location.href="/home";
                });
            }
        },'json')
    });
    $("#user-btn-no").click(function() {
        alertify.alert("请等待管理员审核！",function(){
         top.location.href="/home";
     });
    });

    $('#submt').click(function() {
      var bv = $("#info-form").data('bootstrapValidator');
      bv.validate();
      if (!bv.isValid()) {
        return;
    }
    //检察账号
    $.post("/login!findEmailIsUse",{"loginName":$('.email').val()},function(data){
        if(data.success){
           alertify.alert(data.message);
       }else{
        submit();
    }
},'json')
});

});

function submit(){
    var parm=$("#info-form").serialize();
    $.post("/login!saveRegister",parm,function(data){
        if(data.success ){
            if(data.data.length>0){
                $("#id").val(data.message);
                $("#title").empty().text("查询到校友信息库存在"+data.data.length+"条相似校友信息，请选择哪条是您的记录？");
                var h= template("gridTpl", data);
                $("#gridBody").html(h);
                $("#user-model").modal();
                return;
            }
            alertify.alert("未找到匹配信息,正在审核...",function(){
                top.location.href="/home";
            });
            $('#submt').unbind("click");
            return;
        }
        alertify.alert("提交失败!");
    },'json')
}

function init(){
    //院系字典
    creatDicOption("college-sel","/dic-common!findAllCollege");
    //专业院字典
    creatDicOption("major-sel","/dic-common!findAllCollegeSpecialty",{'id':30100});
    $('#college-sel').change(function(event) {
     creatDicOption("major-sel","/dic-common!findAllCollegeSpecialty",{'id':$(this).val()});
 });
    creatDicOption2("politicalStatus", "/dic-common!findPoliticalStatus", '', false);
    creatDicOption("industryId","/dic-common!findDicIndustry");    //行业
    creatDicOption("educationId","/dic-common!findAllDicDegree");//学历    
    creatDicOption2("nationalId", "/dic-common!findAllNational", '', false);//民族
    //绑定地区选择插件
    $(".address").districtpicker({
        url: contextPath + '/dic-common!findAllDistricts',
        level: 3,
        global: true//是否有国家
    });

    $(".address2").districtpicker({
        url: contextPath + '/dic-common!findAllDistricts',
        level: 2,
        global: true//是否有国家
    });
}

function creatDicOption2(divID, url, params, selected, callback) {
    $.post(url, params, function (data) {
        creatOption2(data, divID, selected)
        if (callback && typeof callback == "function") {
            callback(data, selected);
        }
    }, "json");
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
        $("#"+divID+"#" + divID).html(html);        
    }
}

function validator() {
    $('#info-form').bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "register.name": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },

            "register.password": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    },
                    stringLength: {
                     min: 6,
                     max: 30,
                     message: '密码过于简单'
                 }
             }
         },
         "passwordRe": {
            trigger: "blur",
            validators: {
                notEmpty: {
                    message: '请填写'
                },
                identical: {
                 field: 'register.password',
                 message: '密码不一致！'
             }
         }
     },

     "register.code": {
        trigger: "blur",
        validators: {
            notEmpty: {
                message: '请填写'
            }
        }
    },
    "register.enrollYear": {
        trigger: "blur",
        validators: {
            notEmpty: {
                message: '请填写'
            }
        }
    },
    "register.reVarchar2": {
        trigger: "blur",
        validators: {
        	numeric: {
                message: '邮编必须是数字'
            }
        }
    },
    "register.email": {
        trigger: "blur",
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
    "register.officePhone": {
        trigger: "blur",
        validators: {
        	numeric: {
                message: '电话号码必须是数字'
            }
        }
    },
    "register.phone": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写手机号'
            },
            numeric: {
                message: '手机号必须是数字'
            },
            stringLength: {
                min: 11,
                max: 11,
                message: '请输入11位手机号码'
            },
            regexp: {
                regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                message: '请输入正确的手机号码'
            }
        }
    },
    "register.qq": {
        trigger: "blur",
        validators: {
        	numeric: {
                message: 'QQ号必须是数字'
            }
        }
    },
    "register.address": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写永久通讯地址'
            },
        }
    },
    "register.highestEducation": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写最高学历'
            },
        }
    },
    "register.teacher": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写辅导员/导师'
            },
        }
    },
    "register.company": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写所在单位'
            },
        }
    },
    "register.companyCityStr": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写所在省市'
            },
        }
    },
    "register.post": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写职务'
            },
        }
    },
    "register.title": {
        trigger: "blur",
        validators: {
        	notEmpty: {
                message: '请填写职称'
            },
        }
    },
   }
});
}
