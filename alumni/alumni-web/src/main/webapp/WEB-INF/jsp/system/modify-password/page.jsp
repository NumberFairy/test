<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>地质大学</title>
        <style type="text/css">
            .error {
                color: #A94442;
                display: inline-block;
                margin-top: 5px;
                font-size: 12px;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>系统管理</h5>
                            </div>
                            <div class="ibox-content">
                               
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
                        </div>
                    </div>
                </div>
            </div>
            
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script>                     
                $(function () { 
                    initValidator();                       
                    });  
                    $('#save').click(function(){
                        var bv = $("#infoForm").data('bootstrapValidator');
                        bv.validate();                                            
                        if(bv.isValid()){    
                             var params = $("#infoForm").serializeObject();                                                                               
                             $.post(contextPath + "/system-modify-password!changePwd", params, function(data) {
                            if (data.success) {
                                alertify.alert("密码已修改,请重新登录!",function(e){
                                    if(e){
                                    $.post(contextPath + "/system-modify-password!userExit",function(data){
                                        if(data){                                        
                                         if (window != top)
                                         top.location.href = location.href="/home";
                                        }                                       
                                    },'json');
                                    }
                                });
                            } else {
                                alertify.alert("原始密码错误，请重新输入");
                            }}, "json");
                        }else {
                            alertify.alert('两次密码，输入不一致');
                        } 
                    });              
           </script>

   <!--$("#btn-reset").click(function () {
        if (judgeCheckedIds()) {
            var ids = getCheckedIds();
            alertify.confirm("确定重置密码？", function (e) {
                if (e) {
                    $.post(actionPath + "!resetPassword",{"id": ids.join(',')}, function (data) {
                        alertify.alert(data.message);
                    }, "json");
                } else {
                    return;
                }
            });
        }
    });-->
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