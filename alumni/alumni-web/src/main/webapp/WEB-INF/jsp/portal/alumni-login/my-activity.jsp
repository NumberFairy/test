<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        <style>
            .article-right,
            .title-4 {
                width: 100%;
            }
            
            .table {
                font-size: 14px;
            }
            
            .title-1,
            .title-4 {
                height: 39px;
                margin-top: 0;
            }
            
            .title-4 {
                background: none;
            }
        </style>
        </head>

        <body>
            <%@include file="menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <div class="article-right">
                        <div class="launch-event">
                            <h2 class="title-4">我报名的活动</h2>
                        </div>
                        <div class="column-list">
                            <div id="infoList">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>活动主题</th>
                                            <th>开始时间</th>
                                            <th>结束时间</th>
                                            <th>活动地点</th>
                                            <th>报名人数</th>
                                        </tr>
                                    </thead>
                                    <tbody id="list-body">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!--内容部分end-->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>

        <script type="text/javascript" src="${contentPath}\resources\js\portal\my-activity.js"></script>
        <script type="text/html" id="gridTpl">
            {{each results as value}}
            <tr>
                <td>
                    {{value.title}}
                </td>
                <td>
                    {{value.startTime}}
                </td>
                <td>
                    {{value.endTime}}
                </td>
                <td>
                    {{value.place}}
                </td>
                <td>
                    {{value.count}}
                </td>
            </tr>
            {{/each}}
        </script>

        </html>