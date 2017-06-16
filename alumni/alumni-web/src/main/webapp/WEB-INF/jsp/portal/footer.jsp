<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div class="login-box">
        <div class="cd-popup-container3">
            <a href="javascript:;" class="cd-popup-close">
                <i class="fa fa-times"></i>
            </a>
            <div class="login-form" id="login-form">
                <div id="login-tab" class="login-tab">
                    <div data-type="2" class="alumni-tab active" id="student-btn">校友登录</div>
                    <div data-type="1" class="alumni-tab" id="admin-btn">管理员登录</div>
                </div>
                <ul>
                    <li>
                        <input type="text" class="login-text uname" placeholder="请输入邮箱" name="loginName" />
                    </li>
                    <li>
                        <input type="password" class="login-text upassword" placeholder="请输入密码" name="password" />
                    </li>
                    <li style="margin-top:0;">
                        <div id="errMsg" style="color:#ff0000;height:22px;padding:3px;"></div>
                    </li>
                    <li style="margin-top: 0;">
                        <input type="button" data-type="1" class="login-button" value="登录" id="login-btn" />
                    </li>
                    <li>
                        <div class="login-bottom">
                            <a href="/user-register" class="go-reg">没有账号？立即注册</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <script>
        var actionPath = contextPath + "/";
        var Login = {
            init: function() {
                var me = this;
                me.setEvents();
            },
            setEvents: function() {
                var me = this;
                $('#login-btn').on('click', function() {
                    me.login();
                });
                $('body').keydown(function(e) {
                    if (e.keyCode == 13) { //回车键的键值为13
                        if ("search-input" == document.activeElement.id) { //获取当前焦点dom元素
                            $("#J_searchStatus").click();
                            return;
                        } else if ($(".login-box").hasClass("is-visible3")) {
                            me.login();
                        }
                    }
                })
            },
            login: function() {
                var loginName = $("[name=loginName]").val();
                var password = $("[name=password]").val();
                var $errMsg = $("#errMsg");
                var valid = this.valid(loginName, password, $errMsg);
                if (!valid) {
                    return;
                }
                var type = $(".alumni-tab.active").data("type");
                $.ajax({
                    url: actionPath + "login!login",
                    type: 'post',
                    data: {
                        'loginName': loginName,
                        'password': password,
                        'type': type
                    },
                    dataType: 'json',
                    traditional: true,
                    success: function(text) {
                        if (!text.success) { //失败
                            $errMsg.text(text.message);
                        } else { //成功
                            location.href = text.data.url;
                        }
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        $errMsg.text("登录错误！请刷新...");
                    }
                });
            },
            valid: function(name, pwd, $errMsg) {
                if (name == '') {
                    $errMsg.text('用户名不能为空');
                    return false;
                } else if (pwd == '') {
                    $errMsg.text('密码不能为空');
                    return false;
                }
                return true;
            }
        }
        $(function() {
            //打开窗口
            $('.login-btn').on('click', function(event) {
                event.preventDefault();
                $('.login-box').addClass('is-visible3');
                //$(".dialog-addquxiao").hide()
            });
            //关闭窗口
            $('.login-box').on('click', function(event) {
                if ($(event.target).is('.cd-popup-close i') || $(event.target).is('.login-box')) {
                    event.preventDefault();
                    $(this).removeClass('is-visible3');
                }
            });
            //ESC关闭
            $(document).keyup(function(event) {
                if (event.which == '27') {
                    $('.login-box').removeClass('is-visible3');
                }
            });

            $("#login-tab div").click(function() {
                var $this = $(this);
                $this.addClass("active").siblings().removeClass("active");
            });
            $("#admin-btn").click(function() {
                $('.uname').attr('placeholder', '请输入用户名')
            });
            $("#student-btn").click(function() {
                $('.uname').attr('placeholder', '请输入邮箱')
            });
            Login.init();
        })
    </script>