<!--

	校友管理中心--校友信息库查看
	czjia
	20170401
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
                                <h5>校友管理中心--学校重点校友--查看</h5>
                                <div class="ibox-tools">
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="baseInfoForm">
                                        <div class="clearfix">
                                            <div class="col-sm-6">
                                                <input type="hidden" id="entityId" value="${entity.alumni.id}">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        姓名:
                                                     </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.name}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        性别:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.genderName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        标签（空格分隔）:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.label}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    政治面貌：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.politicalStatusName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        微信昵称:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.wechatName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        手机:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.phone}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        邮箱:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.email}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        院系:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.collegeName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        专业:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.magorName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        班级名称:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.className}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        辅导员/导师:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.teacher}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        所在单位:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.company}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        单位地址:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.companyAddress}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        部门:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.department}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        职称:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.title}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        校友会任职身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.alumniClubIdentityName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.identityName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        学号/职工号:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.code}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        出生日期:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <s:date name="entity..alumni.birthDate" format="yyyy-MM-dd" />
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        籍贯：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <!--TODO:调控件-->
                                                        <p class="form-control-static">${entity.alumni.nativeStr}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        微信：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static " rows="4">${entity.alumni.wechatId}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        民族：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static " rows="4">${entity.alumni.reVarchar0}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        毕业年份：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static " rows="4">${entity.alumni.reVarchar1}</p>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        单位邮编：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static " rows="4">${entity.alumni.reVarchar2}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        家庭邮编：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static " rows="4">${entity.alumni.reVarchar3}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        QQ:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.qq}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        永久通讯地址:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.address}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        入学年份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.enrollYear}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        最高学历:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.highestEducationName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        行业:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.industryName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        单位所在省/市:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <!--TODO:调控件-->
                                                        <p class="form-control-static">${entity.alumni.companyCityStr}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        办公电话:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.officePhone}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        职务:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.post}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        校友身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.alumniIdentityName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        校友分会任职身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.branchClubIdentityName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注1:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark1}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注3:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark3}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注5:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark5}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注7:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark7}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注9:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark9}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注2:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark2}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注4:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark4}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注6:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark6}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注8:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark8}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注10:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${entity.alumni.remark10}</p>
                                                    </div>
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

            </html>