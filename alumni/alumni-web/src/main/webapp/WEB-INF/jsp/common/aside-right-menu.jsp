<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="javascript:;">
                    <i class="fa fa-bars"></i>
                </a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="javascript:;">
                        <i class="fa fa-user"></i> ${sessionScope.UserSession.userName}
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a id="loginOut" href="${contextPath }/login!userExit">
                                <i class="fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>