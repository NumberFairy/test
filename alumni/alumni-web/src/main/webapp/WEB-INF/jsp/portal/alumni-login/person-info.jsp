<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        <style>
            span.star {
                color: red;
                padding: 0 10px;
                vertical-align: middle;
            }
            
            .form-horizontal .control-label {
                text-align: right;
                margin-bottom: 0;
                padding-top: 7px;
            }
            
            .col-sm-3 {
                width: 25%;
                float: left;
            }
            
            .col-sm-7 {
                width: 58.33333333%;
                float: left;
            }
        </style>
        </head>

        <body>
            <%@include file="menu.jsp"%>
                <!--内容部分-->
                <div class="main-form clearfix">
                    <form class="form-horizontal bv-form" id="modelBody">

                    </form>
                    <div align="center">
                        <button id="btn-submit" type="submit" class="btn btn-primary">保存</button>
                    </div>
                </div>
                <!--内容部分end-->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>
        <script type="text/javascript" src="${contentPath}\resources\js\portal\personInfo.js"></script>
        <script type="text/html" id="modelTpl">
            <input type="hidden" class="form-control" name="entity.id" value="{{id}}">
            <div class="form-group">
                <label class="col-sm-3 control-label">
                    <span class="star" >*</span>姓名：
                        </label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="entity.name" value="{{name}}" placeholder="请输入姓名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">
                                        <span class="star" >*</span>
            性别：
                            </label>
                <div class="col-sm-7" style="padding-left:0;">
                    <div class="col-sm-3">
                        <div class="radio radio-info">

                            <input type="radio" id="woman" name="entity.gender" value="0" {{ if !gender}}checked{{/if}}>
                            <label> 男</label>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" id="man" name="entity.gender" value="1" {{ if gender==1}}checked{{/if}}>
                            <label> 女</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">
                                <span class="star">*</span>
                                身份：
                            </label>
                <div class="col-sm-7" style="padding-left:0;">
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" id="student" name="entity.identity" value="0" {{ if !identity}}checked{{/if}}>
                            <label for="radio9">在校生 </label>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" id="alumni" name="entity.identity" value="1" {{ if identity==1}}checked{{/if}}>
                            <label for="radio10">校友</label>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" id="staff" name="entity.identity" value="2" {{ if identity==2}}checked{{/if}}>
                            <label for="radio10">教职工 </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">
                                <span class="star">*</span>
                                学号/职工号：
                            </label>
                <div class="col-sm-7">
                    <input type="text" name="entity.code" value="{{code}}" placeholder="请输入 学号/职工号" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">
                                <span class="star">*</span>出生日期：
                            </label>
                <div class="col-sm-7">
                    <input type="text" name="entity.birthDate" value="{{birthDate | dateFormat:'yyyy-MM-dd'}}" placeholder="请输入出生日期 " class="form-control form_date">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">
                                <span class="star">*</span>
                                入学年份/入职年份：
                            </label>
                <div class="col-sm-7">
                    <input type="text" name="entity.enrollYear" value="{{enrollYear}}" placeholder="请输入" class="form-control form_year">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3">
					            <span class="star ">*</span>院系：
                            </label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="collegeId" name="entity.college" class="form-control select-reset">
                                            
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star">*</span>专业：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="majorId" name="entity.major" class="form-control select-reset">
                                         
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3">籍贯：</label>
                <div class="col-sm-7">
                    <input type="hidden" name="entity.natives" value="{{natives}}">
                    <input type="text" name="entity.nativeStr" value="{{nativeStr}}" placeholder="请输入" class="form-control address">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">政治面貌：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="politicalStatus" name="entity.politicalStatus" class="form-control select-reset">
                                           
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">微信：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.wechatId" value="{{wechatId}}" placeholder="请输入微信号" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">微信昵称：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.wechatName" value="{{wechatName}}" placeholder="请输入微信昵称" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">QQ：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.qq" value="{{qq}}" placeholder="请输入QQ号码" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3 ">手机：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.phone" value="{{phone}}" placeholder="请输入手机号" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">永久通讯地址：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.address" value="{{address}}" placeholder="请输入通讯地址" class="form-control">
                </div>
            </div>
            <div class="form-group ">
                <label class="control-label col-sm-3 "> 邮箱：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.email" value="{{email}}" placeholder="请输入邮箱" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">最高学历：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="educationId" name="entity.highestEducation" class="form-control select-reset">
                         </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">班级名称：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.className" value="{{className}}" placeholder="请输入班级名称" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3 ">辅导员/导师：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.teacher" value="{{teacher}}" placeholder="请输入辅导员/导师" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3">行业：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="industryId" name="entity.industry" class="form-control select-reset">
                                          
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">所在单位：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.company" value="{{company}}" placeholder="请输入所在单位" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star">*</span>单位所在省/市：</label>
                <div class="col-sm-7">
                    <input type="hidden" name="entity.companyCity" value="{{companyCity}}">
                    <input type="text" name="entity.companyCityStr" value="{{companyCityStr}}" placeholder="请输入" class="form-control companyAddress">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star"></span>单位地址：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.companyAddress" value="{{companyAddress}}" placeholder="请输入单位地址" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star"></span>办公电话：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.officePhone" value="{{officePhone}}" placeholder="请输入办公电话" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">部门：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.department" value="{{department}}" placeholder="请输入部门" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">
                                <span class="star">*</span>职务：
                            </label>
                <div class="col-sm-7">
                    <input type="text" name="entity.post" value="{{post}}" placeholder="请输入职务" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star">*</span>职称：</label>
                <div class="col-sm-7">
                    <input type="text" name="entity.title" value="{{title}}" placeholder="请输入职称" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">备注1：</label>
                <div class="col-sm-7">
                    <textarea class="form-control" rows="3" name="entity.remark1" placeholder="请输入备注">{{remark1}}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">备注2：</label>
                <div class="col-sm-7">
                    <textarea class="form-control" rows="3" name="entity.remark2" placeholder="请输入备注2">{{remark2}}</textarea>
                </div>
            </div>
        </script>

        </html>