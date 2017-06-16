<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div id="rMenu">

    </div>

    <script type="text/html" id="node-tpl">
        <form class="form-horizontal" id="info-form">
            <input name="entity.menuId" hidden="hidden" value="{{id}}">
            <input name="entity.parentId" hidden="hidden" value="{{pid}}">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜单名 :</label>
                <div class="col-sm-6">
                    <input name="entity.name" value="{{name}}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">排序 :</label>
                <div class="col-sm-6">
                    <input name="entity.sort" value="{{sort}}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">是否启用 :</label>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="toUse-yes" name="entity.toUse" {{if toUse==1}}checked{{/if}} value="1">
                    <label for="toUse-yes">是</label>
                </div>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="toUse-no" name="entity.toUse" {{if toUse==0}}checked{{/if}} value="0">
                    <label for="toUse-no">否</label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">菜单类型 :</label>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="type-yes" name="entity.type" {{if type==1}}checked{{/if}} value="1">
                    <label for="type-yes">列表</label>
                </div>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="type-no" name="entity.type" {{if type==0}}checked{{/if}} value="0">
                    <label for="type-no">详情</label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">允许上传图片 :</label>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="uploadImg-yes" name="entity.uploadImg" {{if uploadImg==1}}checked{{/if}} value="1">
                    <label for="uploadImg-yes">是</label>
                </div>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="uploadImg-no" name="entity.uploadImg" {{if uploadImg==0}}checked{{/if}} value="0">
                    <label for="uploadImg-no">否</label>
                </div>
            </div>
            <!--
            <div class="form-group">
                <label class="col-sm-3 control-label">允许上传文件 :</label>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="uploadFile-yes" name="entity.uploadFile" {{if uploadFile==1}}checked{{/if}} value="1">
                    <label for="uploadFile-yes">是</label>
                </div>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="uploadFile-no" name="entity.uploadFile" {{if uploadFile==0}}checked{{/if}} value="0">
                    <label for="uploadFile-no">否</label>
                </div>
            </div>-->

            <!--<div class="form-group">
                <label class="col-sm-3 control-label">允许上传视频 :</label>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="type-uploadVideo" name="entity.uploadVideo" {{if uploadVideo==1}}checked{{/if}} value="1">
                    <label for="type-uploadVideo">是</label>
                </div>
                <div class="checkbox checkbox-success checkbox-inline">
                    <input type="radio" id="uploadVideo-no" name="entity.uploadVideo" {{if uploadVideo==0}}checked{{/if}} value="0">
                    <label for="uploadVideo-no">否</label>
                </div>
            </div>-->

            <div class="form-group" style="text-align:center;">
                <button type="button" id="btn-confirm" class="btn btn-primary">确定</button>
            </div>
        </form>
    </script>