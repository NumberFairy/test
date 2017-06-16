<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="header">
        <h1 class="logo">
            <a href="/home" style="color:transparent;">
                <img src="${contextPath}/resources/images/portal/logo.png">
            </a>
        </h1>
    </div>
    <div class="nav">
        <div class="nav-con">
            <ul class="sub-nav floatL module" id="home-menu-key" style="width:960px;">
            </ul>
            <div class="search-wrap floatL">
                <div class="search-content">
                    <input id="J_searchStatus" class="search-bt">
                    <div class="search-title">
                        <input class="search-t" id="search-input" placeholder="请输入关键字查询">
                    </div>
                </div>
            </div>
            <ul class="login-msg floatR">
                <s:if test="#session.UserSession==null||#session.UserSession.isEmpty()">
                    <li class="bg1">
                        <a href="javascript:void(0);" class="login-btn">登录</a>
                    </li>
                </s:if>
                <s:else>
                    <li class="user-info">
                        <a href="${contextPath}/alumni-user" class="user-name">${sessionScope.UserSession.userName} </a>
                        <ul class="ul-info">
                            <li>
                                <a href="${contextPath}/login!userExit">退出</a>
                            </li>
                        </ul>
                    </li>
                </s:else>
            </ul>
        </div>
    </div>