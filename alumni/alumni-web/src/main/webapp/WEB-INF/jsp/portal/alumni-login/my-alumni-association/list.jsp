<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        <style>
            .article-right,
            .title-4 {
                width: 100%;
            }
            
            .launch-event {
                position: relative;
            }
            
            .table {
                font-size: 14px;
            }
            
            .title-4 {
                height: inherit;
            }
        </style>
        </head>

        <body>
            <%@include file="../menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <div class="article-right">
                        <div class="launch-event">
                            <h2 class="title-4 bag-none">我的校友会</h2>
                            <a href="/home!myAlumniCreate" class="launch-event-btn" id="liuyan">
                                <i class="fa fa-paper-plane"></i> 申请入会
                            </a>
                        </div>
                        <div class="column-list">
                            <div id="infoList">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>
                                                校友会名称
                                            </th>
                                            <th>
                                                会长
                                            </th>
                                            <th>
                                                成员数
                                            </th>
                                            <th>
                                                微信号
                                            </th>
                                            <th>
                                                邮箱
                                            </th>
                                            <th>
                                                所在地
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="gridBody">
                                    </tbody>
                                </table>
                                <div align="right">
                                    <ul class="pagination" id="pageUl">
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--内容部分end-->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>
        <script type="text/html" id="gridTpl">
            {{each results as value index}}
            <tr id="{{value.id}}">
                <td>{{value.name}}</td>
                <td>{{value.huizhang}}</td>
                <td>{{value.memberNum}}</td>
                <td>{{value.wechat}}</td>
                <td>{{value.email}}</td>
                <td>{{value.address}}</td>
            </tr>
            {{/each}}
        </script>
        <script>
            var actionPath = contextPath + "/alumni-user";

            $(function() {
                loadData();
            });

            function loadData() {
                var options = {
                    url: actionPath + "!pageMyBranch"
                };
                loadPaginationData(options);
            }
        </script>

        </html>