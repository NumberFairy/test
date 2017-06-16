<!--

	校友活动管理--校友活动报名查看情况
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
                                <h5>校友活动管理--报名查看</h5>
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
                                                <input type="hidden" id="alumniId" value="${alumni.id}">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            姓名:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.name}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star"></span>
                                             性别:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.genderName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            身份:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.identityName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            学号/职工号:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.code}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                              <span class="star">*</span>
                                              出生日期:
                                          </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.birthDate}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                              <span class="star">*</span>
                                              入学年级:
                                          </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.enrollYear}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                              <span class="star">*</span>
                                              院系:
                                          </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.collegeName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                              <span class="star">*</span>
                                              标签（空格分隔）:
                                          </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static" >${alumni.label}</p>
                                                    </div>
                                                </div>
                                                <div id="isTimeHide">
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            籍贯：
                                            </label>
                                                        <div class="col-sm-8">
                                                            <p class="form-control-static">${alumni.natives}</p>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            政治面貌：
                                            </label>
                                                        <div class="col-sm-8">
                                                            <p class="form-control-static">${alumni.politicalStatusName}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            微信：
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static " rows="4">${alumni.wechatId}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            微信昵称:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.wechatName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            QQ:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.qq}</p>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="col-sm-6">

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            手机:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.phone}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            邮箱:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.email}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            所在地:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.address}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            专业:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.magorName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                           最高学历:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.highestEducationName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            班级名称:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.className}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            辅导员/导师:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.teacher}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            行业:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.industryName}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            所在单位:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.company}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            部门:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.department}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            职务:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.post}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            职称:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.title}</p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                           备注 :
                                        </label>
                                                    <div class="col-sm-8">
                                                        <p class="form-control-static">${alumni.remark1}</p>
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
            </div>
        </body>
        <%@ include file="/WEB-INF/jsp/common/js-container.jsp"%>

            </html>