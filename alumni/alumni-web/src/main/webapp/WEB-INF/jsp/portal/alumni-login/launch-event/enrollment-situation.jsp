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
            
            .launch-event {
                position: relative;
            }
        </style>
        </head>

        <body>
            <%@include file="../menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <div class="article-right">
                        <div class="launch-event">
                            <h2 class="title-4">${activityName}</h2>
                            <a href="javascript:void(0);" onclick="window.history.back();" class="launch-event-btn" id="liuyan">
                                <i class="fa fa-reply"></i> 返回
                            </a>
                        </div>
                        <div class="column-list">
                            <input id="activity-id" value="${activityId}" class="hidden"></input>
                            <div id="infoList">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>姓名</th>
                                            <th>性别</th>
                                            <th>身份</th>
                                            <th>入学年份/入职年份</th>
                                            <th>院系</th>
                                        </tr>
                                    </thead>
                                    <tbody id="gridBody">

                                    </tbody>
                                </table>
                            </div>
                            <div class="page">
                                <ul class="pagination" id="pageUl">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!--内容部分end-->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>
        <script type="text/javascript" src="${contentPath}\resources\js\portal\enrollment-situation.js"></script>
        <script type="text/html" id="gridTpl">
            {{if results.length==0}}
            <td colspan="99">
                <div class="no-data">暂无报名信息</div>
            </td>
            {{/if}} {{each results as value}}
            <tr>
                <td>
                    {{value.alumniName}}
                </td>
                <td>
                    {{value.gender}}
                </td>
                <td>
                    {{value.identityName}}
                </td>
                <td>
                    {{value.enrollYear}}
                </td>
                <td>
                    {{value.collegeName}}
                </td>
            </tr>
            {{/each}}
        </script>

        </html>