<!--

	校友服务管理--校友登记
	czjia
    20170329
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
    <title>校友管理及分析系统</title>
    </head>
    <body class="gray-bg">
        <div class="wrapper wrapper-content  animated fadeInRight">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1">
                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>校友登记管理</h5>
                            <div class="ibox-tools">
                                 <a class="btn  btn-sm btn-info" type="button" id="btn-submit">
                                    <i class="fa fa-check"></i>&nbsp;提 交 
                                 </a>
                                 <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                    <i class="fa fa-reply"></i>&nbsp;返 回
                                 </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="m-t">
                                <form class="form-horizontal" id="form-all">
                                    <input type="hidden" id="id" name="entity.id" value="${id}">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 登记类型:
                                        </label>
                                        <div class="col-sm-6">
                                            <select   name="entity.enrollType"  class="form-control select-width">
                                                <s:iterator value="registerList">
                                                    <s:if test = "entity.enrollType == id">
                                                        <option value="${id}" selected>${value}</option>
                                                    </s:if>
                                                    <s:else>
                                                        <option value="${id}">${value}</option>
                                                    </s:else>
                                                </s:iterator>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 开始时间:
                                        </label>
                                        <div class="col-sm-6">
                                           <input type="text" id="startTime" name="entity.startTime" value="<s:date name='entity.startTime' format='yyyy-MM-dd HH:mm:ss'/>" placeholder="请输入开始时间" class="form-control form_time">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 结束时间:
                                        </label>
                                        <div class="col-sm-6">
                                            <input type="text" id="endTime"  name="entity.endTime" value="<s:date name='entity.endTime' format='yyyy-MM-dd HH:mm:ss'/>" placeholder="请输入结束时间" class="form-control form_time">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 地点:
                                        </label>
                                        <div class="col-sm-6">
                                            <input type="text" id="place"  name="entity.place" value="${entity.place}" placeholder="请输入地点" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star">*</span> 参与人:
                                        </label>
                                        <div class="col-sm-6">
                                             <textarea name="entity.people" class="form-control" rows="4" placeholder="请输入参与人">${entity.people}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">
                                            <span class="star"></span>
                                            内容:
                                        </label>
                                        <!--TODO:内容富文本-->
                                        <div class="col-sm-6">
                                             <textarea name="entity.content" class="form-control" rows="6" placeholder="请输入内容">${entity.content}</textarea>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
<%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
<script type="text/javascript" src="${contentPath}/resources/js/alumni-server-manage/alumni-check-in/create.js"></script>

</html>