<%-- <%@page import="com.htsoft.core.util.RequestUtil" isErrorPage="true" pageEncoding="UTF-8"%>
<%!private final static transient org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog("500_jsp");%>
<%
	String errorUrl = RequestUtil.getErrorUrl(request);
	//boolean isContent = (errorUrl.endsWith(".do") || errorUrl.endsWith(".jsp"));
	logger.warn("Error Occur, url: " + errorUrl+" Referrer: "+request.getHeader("REFERER"));
	logger.error(RequestUtil.getErrorInfoFromRequest(request, logger.isInfoEnabled()));

	response.addHeader("__500_error","true");
%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<html>
	<head>
		<title>500服务器发生一些问题</title>
<style type="text/css">
    body {
        font-family: 'Courgette', cursive;
    }

    body {
        background: #f3f3e1;
    }

    .wrap {
        margin: 0 auto;
        width: 1000px;
    }

    .logo {
        margin-top: 50px;
    }

    .logo h1 {
        font-size: 200px;
        color: #8F8E8C;
        text-align: center;
        margin-bottom: 1px;
        text-shadow: 1px 1px 6px #fff;
    }

    .logo p {
        color: rgb(228, 146, 162);
        font-size: 20px;
        margin-top: 1px;
        text-align: center;
    }

    .logo p span {
        color: lightgreen;
    }

    .sub a {
        color: white;
        background: #8F8E8C;
        text-decoration: none;
        padding: 7px 120px;
        font-size: 13px;
        font-family: arial, serif;
        font-weight: bold;
        -webkit-border-radius: 3em;
        -moz-border-radius: .1em;
        -border-radius: .1em;
    }

    .footer {
        color: #8F8E8C;
        position: absolute;
        right: 10px;
        bottom: 10px;
    }

    .footer a {
        color: rgb(228, 146, 162);
    }
    </style>
    <style id="style-1-cropbar-clipper">
    /* Copyright 2014 Evernote Corporation. All rights reserved. */

    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255, 255, 255, .38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style>
	</head>
<body>
    <div class="wrap">
        <div class="logo">
            <h1>500</h1>
            <p>Oop. 服务器发生一些问题</p>
            <div class="sub">
                <p><a href="/">返回</a></p>
            </div>
        </div>
    </div>
</body>

</html>