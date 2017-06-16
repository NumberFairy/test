<!--

	校友管理中心--联络员管理
	zxguan
	201703028
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/header.jsp"%>
        <title>校友管理及分析系统</title>
        </head>

        <body class="gray-bg">
            <div class="wrapper wrapper-content  animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>联络员管理</h5>
                            </div>
                            <div class="ibox-content">
                                <form class="form-inline clearfix" id="form" role="form">
                                    <div class="sl-item marb">
                                        <div class="advanced-query fixed-height" id="jobNetwork-div">
                                            <div class="form-group marb">
                                                <label class="label-reset">姓名：</label>
                                                <input placeholder="姓名" class="form-control input-reset" name="alumni.name">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">院系：</label>
                                                <select id="collegeId" name="alumni.college" class="form-control input-reset">
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">专业：</label>
                                                <select id="major-sel" name="alumni.major" class="form-control input-reset">
                                                </select>
                                            </div>
                                            <!--/**-->
                                            <div class="form-group marb">
                                                <label class="label-reset">性别：</label>
                                                <select name="alumni.gender" class="form-control input-reset">
                                                    <option>全部</option>
                                                    <option value="0">男</option>
                                                    <option value="1">女</option>
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">身份：</label>
                                                <input placeholder="身份" class="form-control input-reset" name="alumni.identityName">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">学号/职工号：</label>
                                                <input placeholder="学号/职工号" class="form-control input-reset" name="alumni.code">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">出生日期：</label>
                                                <input placeholder="出生日期" class="form-control input-reset form_date" name="alumni.birthDate">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">籍贯：</label>
                                                <input placeholder="籍贯" class="form-control input-reset" name="alumni.nativeStr">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">政治面貌：</label>
                                                <select id="zhengZhiId" name="alumni.politicalStatusName" class="form-control input-reset">
                                                 </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">入学年份：</label>
                                                <input placeholder="入学年份" class="form-control input-reset form_year" name="alumni.enrollYear">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">毕业年份：</label>
                                                <input placeholder="毕业年份" class="form-control input-reset form_year" name="alumni.reVarchar1">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">微信：</label>
                                                <input placeholder="微信" class="form-control input-reset" name="alumni.wechatId">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">微信昵称：</label>
                                                <input placeholder="微信昵称" class="form-control input-reset" name="alumni.wechatName">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">QQ：</label>
                                                <input placeholder="QQ" class="form-control input-reset" name="alumni.qq">
                                            </div>
                                            <!---->
                                            <div class="form-group marb">
                                                <label class="label-reset">手机：</label>
                                                <input placeholder="手机" class="form-control input-reset" name="alumni.phone">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">邮箱：</label>
                                                <input placeholder="邮箱" class="form-control input-reset" name="alumni.email">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">班级名称：</label>
                                                <input placeholder="班级名称" class="form-control input-reset" name="alumni.className">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">辅导员/导师：</label>
                                                <input placeholder="辅导员/导师" class="form-control input-reset" name="alumni.teacher">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">所在单位：</label>
                                                <input placeholder="所在单位" class="form-control input-reset" name="alumni.company">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">单位邮编：</label>
                                                <input placeholder="单位邮编" class="form-control input-reset" name="alumni.reVarchar2">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">家庭邮编：</label>
                                                <input placeholder="家庭邮编" class="form-control input-reset" name="alumni.reVarchar3">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">单位地址：</label>
                                                <input placeholder="单位地址" class="form-control input-reset" name="alumni.companyAddress">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">部门：</label>
                                                <input placeholder="部门" class="form-control input-reset" name="alumni.department">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">职称：</label>
                                                <input placeholder="职称" class="form-control input-reset" name="alumni.title">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">永久通讯地址：</label>
                                                <input placeholder="永久通讯地址" class="form-control input-reset" name="alumni.address">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">最高学历：</label>
                                                <select id="xueLiId" name="alumni.highestEducationName" class="form-control select-reset">
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">校友会任职身份：</label>
                                                <select id="clubIdentityId" name="alumni.alumniClubIdentityName" class="form-control select-reset">
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">校友身份：</label>
                                                <select id="alumniIdentityId" name="alumni.alumniIdentityName" class="form-control select-reset">
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">校友分会任职身份：</label>
                                                <select id="branchIdentityId" name="alumni.branchClubIdentityName" class="form-control select-reset">
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">行业：</label>
                                                <select id="industryId" name="alumni.industryName" class="form-control input-reset">
                                                </select>
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">单位所在省/市：</label>
                                                <!--<input type="hidden" name="alumni.companyCityStr">-->
                                                <input type="text" name="alumni.companyCityStr" placeholder="单位所在省/市" class="form-control companyAddress input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">办公电话：</label>
                                                <input type="text" name="alumni.officePhone" placeholder="办公电话" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">职务：</label>
                                                <input type="text" name="alumni.post" placeholder="职务" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注1：</label>
                                                <input type="text" name="alumni.remark1" placeholder="备注1" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注2：</label>
                                                <input type="text" name="alumni.remark2" placeholder="备注2" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注3：</label>
                                                <input type="text" name="alumni.remark3" placeholder="备注3" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注4：</label>
                                                <input type="text" name="alumni.remark4" placeholder="备注4" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注5：</label>
                                                <input type="text" name="alumni.remark5" placeholder="备注5" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注6：</label>
                                                <input type="text" name="alumni.remark6" placeholder="备注6" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注7：</label>
                                                <input type="text" name="alumni.remark7" placeholder="备注7" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注8：</label>
                                                <input type="text" name="alumni.remark8" placeholder="备注8" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注9：</label>
                                                <input type="text" name="alumni.remark9" placeholder="备注9" class="form-control input-reset">
                                            </div>
                                            <div class="form-group marb">
                                                <label class="label-reset">备注10：</label>
                                                <input type="text" name="alumni.remark10" placeholder="备注10" class="form-control input-reset">
                                            </div>
                                            <!---->
                                            <div class="btn-search-parent">
                                                <button class="btn btn-sm btn-info mar0" type="button" id="btn-search">查 询</button>
                                            </div>
                                        </div>
                                        <div class="sl-item-option" id="open-jobnetwork">
                                            <div class="ow">
                                                <span>展开</span>
                                                <i class="fa fa-caret-down"></i>
                                            </div>
                                            <div class="ow hide">
                                                <span>收起</span>
                                                <i class="fa fa-caret-up"></i>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <div class="clearfix">
                                    <button type="button" id="btn-detail" class="btn btn-sm btn-info marl">查 看</button>
                                    <button type="button" id="btn-update" class="btn btn-sm btn-info marl">编 辑</button>
                                    <button type="button" id="btn-email" class="btn btn-sm btn-info marl">邮件通知</button>
                                </div>
                                <table class="table  table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th class="bs-checkbox" style="width:36px;">
                                                <input type="checkbox" class="check-all">
                                            </th>
                                            <th>
                                                姓名
                                            </th>
                                            <th>
                                                标签
                                            </th>
                                            <th>
                                                院系
                                            </th>
                                            <th>
                                                单位
                                            </th>
                                            <th>
                                                职务
                                            </th>
                                            <th>
                                                联系电话
                                            </th>
                                            <th>
                                                邮箱
                                            </th>
                                            <th>
                                                备注
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody id="gridBody">
                                        <!-- content -->
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
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>
            <%@ include file="/WEB-INF/jsp/alumni-manage-center/model.jsp"%>
                <script type="text/html" id="gridTpl">
                    {{each results as value index}}
                    <tr id="{{value.id}}">
                        <td class="bs-checkbox" style="width:36px;">
                            <input type="checkbox" class="child" value="{{value.id}}">
                        </td>
                        <td>{{value.alumni.name}}</td>
                        <td>{{value.alumni.label}}</td>
                        <td>{{value.alumni.collegeName}}</td>
                        <td>{{value.alumni.company}}</td>
                        <td>{{value.alumni.post}}</td>
                        <td>{{value.alumni.phone}}</td>
                        <td>{{value.alumni.email}}</td>
                        <td>{{value.alumni.remark1}}</td>
                        <td><button id="removeId" data-id={{value.id}} class="btn btn-warning btn-xs mar0">移 除</button></td>
                    </tr>
                    {{/each}}
                </script>
                <script type="text/javascript" src="${contentPath}/resources/js/alumni-manage-center/liaison-manage/page.js"></script>

                </html>