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
            
            .title-4 {
                height: inherit;
            }
            
            .launch-event {
                position: relative;
            }
            
            .btn-detail {
                color: #115095;
                cursor: pointer;
            }
        </style>
        </head>

        <body>
            <%@include file="../menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <div class="article-right">
                        <div class="launch-event">
                            <h2 class="title-4 bag-none">发布活动</h2>
                            <a href="/home!mylaunchEvent" class="launch-event-btn" id="liuyan">
                                <i class="fa fa-paper-plane"></i> 我要发布
                            </a>
                        </div>
                        <div class="column-list">
                            <div id="infoList">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>活动主题</th>
                                            <th>开始时间</th>
                                            <th>结束时间</th>
                                            <th>审核状态</th>
                                            <th>创建时间</th>
                                            <th>操作</th>
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
        <script type="text/javascript" src="${contentPath}\resources\js\portal\my-activity-page.js"></script>
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
                {{if !value.status||value.status==0}}
                <td style="color:#efbd08;">待审核</td>
                {{else if value.status==1}}
                <td style="color:#40c30c;">审核通过</td>
                {{else}}
                <td style="color:#f90101;">审核未通过</td>
                {{/if}}
                <td>
                    {{value.createTime}}
                </td>
                {{if !value.status||value.status==0||value.status==2}}
                <td><span style="color:#c7c6c2;">暂不可操作</span></td>
                {{else}}
                <td>
                    <a onClick='toAlumniActivity("{{value.id}}")' class="btn-detail">查看报名情况</a>
                </td>
                {{/if}}
            </tr>
            {{/each}}
        </script>

        </html>