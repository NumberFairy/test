<!--

	校友成长时光轴--新增
	czjia
	20170413
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <div class="modal fade" id="timelineModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                    <h4 class="modal-title" id="myModalLabel">
                        校友成长时光轴--添加
                    </h4>
                </div>
                <div class="modal-body">
                    <%--  --%>
                        <form id="baseForm" class="form-horizontal bv-form">
                           
                        </form>
                        <%--  --%>
                </div>
                <div class="modal-footer">
                    <button id="timelineSubmit" class="btn btn-primary">
                    提 交
                </button>
                </div>
            </div>
        </div>
    </div>




    <script type="text/html" id="timeline-tpl">

        <input type="hidden" id="entityId" name="timelineEntity.id" value="{{id}}">
        <input type="hidden" id="alumniId2" name="timelineEntity.alumniId" value="{{alumniId}}">
        <div class="form-group">
            <label class="col-sm-3 control-label">
                            <span class="star">*</span>标题：
                        </label>
            <div class="col-sm-8">
                <input id="title" name="timelineEntity.title" value="{{title}}" placeholder="主题信息" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">
                            <span class="star">*</span>内容：
                        </label>
            <div class="col-sm-8">
                <textarea id="content" name="timelineEntity.content"  placeholder="请输入通知内容" class="form-control"
                    rows="7">{{content}}</textarea>
            </div>
        </div>


    </script>