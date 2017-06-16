<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <link href="${contextPath}/js-lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
        <title>地质大学</title>
        <style type="text/css">
            #rMenu {
                position: absolute;
                visibility: hidden;
                top: 0;
                background-color: #f9f9f9;
                text-align: left;
                padding: 2px;
            }
            
            #rMenu a {
                cursor: pointer;
                list-style: none outside none;
            }
            
            .modal-body {
                padding: 19px 37px 12px 13px;
            }
        </style>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>门户菜单管理</h5>
                            </div>
                            <div class="ibox-content clearfix">
                                <div class="col-sm-3">
                                    <ul id="tree" class="ztree"></ul>
                                </div>
                                <div class="col-sm-7" id="form">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="modal.jsp"%>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <script src="${contextPath}/js-lib/zTree/v3/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="${contentPath}/resources/js/gateway-menu-manage/home-menu.js"></script>

            </html>