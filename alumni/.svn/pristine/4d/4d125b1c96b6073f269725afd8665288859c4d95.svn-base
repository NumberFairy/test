/**
*  门户列表
*   xiefei
* */
$(function() {
    initHeader();
    loadData();
    //留言
    $("#liuyan").click(function(){
        initLiuYanValidator();
        fillLiuyanField();
    })
    $("#msg-btn").click(function(){
     var bv = $("#msg-form").data('bootstrapValidator');
     bv.validate();
     if (!bv.isValid()) {
        return;
    }
    $.post('/home!saveMessageBoard', $("#msg-form").serialize(), function(data) {
        if(data){
            alertify.alert("操作成功！");
        }
        $("#liuyan-model").modal('hide');
    });
})
});

function loadData() {
    var appendElement='list';
    var templateId='list-tpl';
    var options = {
        'url': menuOption.url,
        'appendElement':appendElement,
        'templateId':templateId,
        'queryParams':{
            'menuId':menuOption.menuId
        }
    };
    //留言板
    if(menuOption.menuId==80){
        options.templateId='msg-tpl';
    }

    loadPaginationData(options);
}
function initHeader(){
   var h =  template("header-tpl", {'title':menuOption.title});
   $('#header').html(h);
}

template.helper("dateTitle", function(date){
    return parseInt(date.substring(5,7))+'月<span>'+date.substring(8,10)+'</span>'+date.substring(0,4);
});
function initLiuYanValidator() {
    $("#msg-form").bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "msg.title": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },

            "msg.name": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },

            "msg.email": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    },
                    emailAddress: {
                        message: '请输入正确的邮箱'
                    }
                }
            }

        }
    });
}

function fillLiuyanField() {
	if (userId) {
		$.post(contextPath + '/alumni!detail', {id : userId}, function(data) {
	        if(data){
	            $('#msgName').val(data.name);
	            $('#msgEmail').val(data.email);
	            $('#msgQQ').val(data.qq);
	        }
	        $("#liuyan-model").modal('show');
	    }, 'json');
	} else {
		$("#liuyan-model").modal('show');
	}
}