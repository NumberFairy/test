<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
<title>地质大学校友管理系统</title>
<style>
    span.star {
        color: red;
        padding: 0 10px;
        vertical-align: middle;
    }
    
    .form-horizontal .control-label {
        text-align: right;
        margin-bottom: 0;
        padding-top: 7px;
    }
    
    .col-sm-3 {
        width: 25%;
        float: left;
    }
    
    .col-sm-7 {
        width: 58.33333333%;
        float: left;
    }
</style>
</head>

<body>
    <%@include file="menu.jsp"%>
    <!--内容部分-->
    <div class="main-form clearfix">
        <form id="infoForm" class="form-horizontal bv-form"  method="post" novalidate="novalidate">                        
            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star">*</span>旧密码：</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="oldPwd" value="" placeholder="请输入旧密码">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star">*</span>新密码：</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="newPwd" value=""  placeholder="请输入新密码">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star">*</span>确认密码：</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="repeatNewPwd" value="" placeholder="请确认密码">
                </div>
            </div>
            <div align="center">
                <button id="save" type="button" class="btn btn-primary">确认修改</button>
            </div>
        </form>
    </div>
    <!--内容部分end-->
    <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
</body>

<script>                     
    $(function () { 
        initValidator();                       
    });  
    $('#save').click(function(){
        var bv = $("#infoForm").data('bootstrapValidator');
        bv.validate();                                            
        if(bv.isValid()){    
           var params = $("#infoForm").serializeObject();                                                                               
           $.post(contextPath + "/alumnus-change-password!changePwd", params, function(data) {
            if (data.success) {
                alertify.alert("密码已修改，请重新登录",function(e){
                    if(e){location.href="/home";}
                });
            } else {
                alertify.alert("原始密码错误");
            }}, "json");
       }else {
        alertify.alert('两次密码，输入不一致');
    } 
});              
</script>

<script>
    function initValidator() {
        $("#infoForm").bootstrapValidator({
            excluded: [':disabled', ':hidden', ':not(:visible)'],
            live: 'enabled',
            fields: {
                "oldPwd": {
                    trigger: "blur",
                    validators: {
                        notEmpty: {
                            message: '请填写'
                        }
                    }
                },
                "newPwd": {
                    trigger: "blur",
                    validators: {
                        notEmpty: {
                            message: '请填写'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: '密码由数字字母下划线和.组成'
                        }
                    }
                },
                
                "repeatNewPwd": {
                    trigger: "blur",
                    validators: {
                        notEmpty: {
                            message: '请填写'
                        },
                        identical: { //相同
                            field: 'newPwd',
                            message: '两次密码不一致'
                        },
                    }
                },
            }
        });
    }
</script>
</html>