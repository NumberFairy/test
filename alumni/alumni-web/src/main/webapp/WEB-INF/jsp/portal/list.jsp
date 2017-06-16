<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        <style>
            .title-4 {
                height: inherit;
            }
        </style>
        </head>

        <body>
            <%@include file="/WEB-INF/jsp/common/portal-menu.jsp"%>
                <!--内容部分-->
                <div class="main clearfix">
                    <div class="article-main">
                        <%@include file="/WEB-INF/jsp/common/list-menu-left.jsp"%>
                            <div class="article-right floatR">
                                <div id="header">
                                </div>

                                <div class="column-list">
                                    <div id="list">

                                    </div>
                                    <div align="center">
                                        <ul class="pagination" id="pageUl">
                                        </ul>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
                        <%@include file="footer.jsp"%>
                            <%@include file="tpl.jsp"%>
                                <script type="text/javascript">
                                    var menuOption = {
                                        url: '${menu.url}',
                                        type: '${menu.type}',
                                        uploadImg: '${menu.uploadImg}',
                                        uploadFile: '${menu.uploadFile}',
                                        uploadVideo: '${menu.uploadVideo}',
                                        title: '${menu.name}',
                                        menuId: '${menu.menuId}'
                                    }
                                </script>
                                <script src="/resources/js/portal/page.js" type="text/javascript"></script>
                                <script>
                                	var userId = '${sessionScope.UserSession.id}';
                                </script>
        </body>

        </html>