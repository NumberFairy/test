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
    <%@include file="/WEB-INF/jsp/common/portal-menu.jsp"%>
    <div class="main-form clearfix">
        <form class="form-horizontal bv-form" id="info-form">

            <div class="form-group">
                <label class="col-sm-3 control-label">
                    <span class="star" >*</span>姓名：
                </label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="register.name" placeholder="请输入姓名">
                </div>
            </div>

            <div class="form-group ">
                <label class="control-label col-sm-3 "><span class="star" >*</span>帐号：</label>
                <div class="col-sm-7">
                    <input name="register.email" placeholder="请输入您的邮箱" class="form-control email">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">
                    <span class="star" >*</span>密码：
                </label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="register.password" placeholder="请输入密码">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">
                    <span class="star" >*</span>确认密码：
                </label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="passwordRe" placeholder="请输入姓名密码">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label">性别：</label>
                <div class="col-sm-7" style="padding-left:0;">
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" name="register.gender" value="0" checked>
                            <label> 男</label>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" name="register.gender" value="1">
                            <label> 女</label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label"><span class="star" >*</span>身份：
                </label>
                <div class="col-sm-7" style="padding-left:0;">
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" name="register.identity" value="0" checked>
                            <label for="radio9">在校生 </label>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" name="register.identity" value="1">
                            <label for="radio10">校友</label>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="radio radio-info">
                            <input type="radio" name="register.identity" value="2">
                            <label for="radio10">教职工 </label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">
                    <span class="star">*</span>学号/职工号：
                </label>
                <div class="col-sm-7">
                    <input name="register.code" placeholder="请输入 学号/职工号" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">
                    <span class="star">*</span>入学年份/入职年份：
                </label>
                <div class="col-sm-7">
                    <input name="register.enrollYear" placeholder="请输入" class="form-control form_year">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">出生日期：</label>
                <div class="col-sm-7">
                    <input name="register.birthDate" placeholder="请输入出生日期 " class="form-control form_date">
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-3">
                    	毕业年份/离职年份：
                </label>
                <div class="col-sm-7">
                    <input name="register.reVarchar1" placeholder="请输入" class="form-control form_year">
                </div>
            </div>

            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3">
                    	院系：
                </label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="college-sel" name="register.college" class="form-control select-reset">
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">专业：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="major-sel" name="register.major" class="form-control select-reset">
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3">籍贯：</label>
                <div class="col-sm-7">
                    <input type="hidden" name="register.natives">
                    <input name="register.nativeStr" placeholder="请输入" class="form-control address2">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">民族：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="nationalId" name="register.reVarchar0" class="form-control select-reset">
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">政治面貌：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="politicalStatus" name="register.politicalStatus" class="form-control select-reset">
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">微信：</label>
                <div class="col-sm-7">
                    <input type="text" name="register.wechatId" placeholder="请输入微信号" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">微信昵称：</label>
                <div class="col-sm-7">
                    <input name="register.wechatName" placeholder="请输入微信昵称" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">QQ：</label>
                <div class="col-sm-7">
                    <input name="register.qq" placeholder="请输入QQ号码" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3 "><span class="star" >*</span>手机：</label>
                <div class="col-sm-7">
                    <input name="register.phone" placeholder="请输入手机号" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star" >*</span>永久通讯地址：</label>
                <div class="col-sm-7">
                    <input name="register.address" placeholder="请输入通讯地址" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star"></span>家庭邮编：</label>
                <div class="col-sm-7">
                    <input name="register.reVarchar3" placeholder="家庭邮编" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star" >*</span>最高学历：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="educationId" name="register.highestEducation" class="form-control select-reset">
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">班级名称：</label>
                <div class="col-sm-7">
                    <input name="register.className" placeholder="请输入班级名称" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3 "><span class="star" >*</span>辅导员/导师：</label>
                <div class="col-sm-7">
                    <input name="register.teacher" placeholder="请输入辅导员/导师" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3">行业：</label>
                <div class="col-sm-7">
                    <div class="parent">
                        <select id="industryId" name="register.industry" class="form-control select-reset">
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star" >*</span>所在单位：</label>
                <div class="col-sm-7">
                    <input name="register.company" placeholder="请输入所在单位" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star" >*</span>单位所在省/市：</label>
                <div class="col-sm-7">
                    <input type="hidden" name="register.companyCity">
                    <input name="register.companyCityStr" placeholder="请输入" class="form-control address">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star"></span>单位地址：</label>
                <div class="col-sm-7">
                    <input name="register.companyAddress" placeholder="请输入单位地址" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star"></span>单位邮编：</label>
                <div class="col-sm-7">
                    <input name="register.reVarchar2" placeholder="单位邮编" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star"></span>办公电话：</label>
                <div class="col-sm-7">
                    <input name="register.officePhone" placeholder="请输入办公电话" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-3">部门：</label>
                <div class="col-sm-7">
                    <input name="register.department" placeholder="请输入部门" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3"><span class="star" >*</span>职务：</label>
                <div class="col-sm-7">
                    <input name="register.post" placeholder="请输入职务" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label for="birthday" class="control-label col-sm-3"><span class="star" >*</span>职称：</label>
                <div class="col-sm-7">
                    <input name="register.title" placeholder="请输入职称" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">备注1：</label>
                <div class="col-sm-7">
                    <textarea class="form-control" rows="3" name="register.remark1" placeholder="请输入备注"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-3">备注2：</label>
                <div class="col-sm-7">
                    <textarea class="form-control" rows="3" name="register.remark2" placeholder="请输入备注2"></textarea>
                </div>
            </div>

            <div align="center">
                <button class="btn btn-primary" id="submt">注册</button>
            </div>

        </form>
    </div>
    <!--内容部分end-->
    <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
    <%@include file="/WEB-INF/jsp/portal/footer.jsp"%>
    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
    <script src="/resources/js/portal/register.js"></script>
    <div class="modal fade" id="user-model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" style="width: 690px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="title"></h4>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="id">
                    <form class="form-horizontal bv-form clearfix" id="specialty-form">
                        <table class="table  table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th class="bs-checkbox" style="width:36px;">
                                        <input type="checkbox" class="check-all">
                                    </th>
                                    <th>校友姓名</th>
                                    <th>学号/工号</th>
                                    <th>学院</th>
                                    <th>专业</th>
                                    <th>邮箱</th>
                                    <th>入学年份</th>
                                </tr>
                            </thead>
                            <tbody id="gridBody">
                            </tbody>
                        </table>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" id="user-btn">确定
                    </button>
                    <button type="button" class="btn btn-default" id="user-btn-no">都不是
                    </button>
                </div>
            </div>
        </div>
    </div>

    <script type="text/html" id="gridTpl">
        {{each data as v}}
        <tr>
            <td class="bs-checkbox" style="width:36px;">
                <input type="checkbox" class="child" value="{{v.id}}">
            </td>
            <td>{{v.name}}</td>
            <td>{{v.code}}</td>
            <td>{{v.collegeName}}</td>
            <td>{{v.majorName}}</td>
            <td>{{v.email}}</td>
            <td>{{v.enrollYear}}</td>
        </tr>
        {{/each}}
    </script>
</body>

</html>