<!--

	校友管理中心--校友信息库--时光轴
	zxguan
	201703028
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        </head>

        <body class="gray-bg">
            <div class="row">
                <div class="col-sm-12">
                    <div class="wrapper wrapper-content">
                        <div class="row animated fadeInRight">
                            <div class="col-sm-8">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>校友管理中心--校友信息库--时光轴</h5>
                                        <div class="ibox-tools">
                                            <button class="btn  btn-sm  btn-info" type="button" id="btn-add"> 新 增 </button>
                                            <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                                <i class="fa fa-reply"></i>&nbsp;返 回
                                            </a>
                                        </div>
                                    </div>
                                    <div class="" id="ibox-content">
                                        <div id="vertical-timeline" class="vertical-container light-timeline">
                                            <input type="hidden" id="alumniId" name="alumniId" value="${alumniId}">
                                            <!-- content -->
                                            <div id="gridBodyTimeline">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
                <%@ include file="/WEB-INF/jsp/alumni-manage-center/alumni-info-note/timeline-model.jsp"%>
                    <script type="text/javascript" src="${contentPath}/resources/js/alumni-manage-center/alumni-info-note/timeline.js"></script>

                    <script type="text/html" id="gridTplTimeline">
                        {{each list as value}}
                        <div class="vertical-timeline-block">
                            <div class="vertical-timeline-icon navy-bg">
                                <i class="fa fa-briefcase"></i>
                            </div>
                            <div class="vertical-timeline-content">
                                <h2>{{value.title}}</h2>
                                <p>{{value.content}}</p>
                                {{if value.status==1}}
                                <button class="btn btn-info btn-xs marl marb remove" data-id="{{value.id}}" type="button"><i class="fa fa-check"></i>&nbsp;移除</button>
                                <button class="btn btn-success btn-xs marl marb edit" data-id="{{value.id}}" type="button"><i class="fa fa-paste"></i>&nbsp;编辑</button>                                {{/if}}
                                <span class="vertical-date">
                                <small>{{value.lastUpdate}}</small>
                             </span>
                            </div>
                        </div>
                        {{/each}}
                    </script>
        </body>

        </html>