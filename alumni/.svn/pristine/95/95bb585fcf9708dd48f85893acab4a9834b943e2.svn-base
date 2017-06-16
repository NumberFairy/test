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
                                <h5>校友管理中心--校友信息库</h5>
                                <div class="ibox-tools">
                                    <button class="btn  btn-sm btn-info" type="button" id="btn-submit">
                                <i class="fa fa-check"></i>&nbsp;提 交
                            </button>
                                    <a class="btn  btn-default marr  btn-sm" href="javascript:void(0);" onclick="window.history.back();">
                                        <i class="fa fa-reply"></i>&nbsp;返 回
                                    </a>

                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="m-t">
                                    <form class="form-horizontal" id="form-all">
                                        <div class="clearfix">
                                            <div class="col-sm-6">
                                                <input type="hidden" id="entityId" name="entity.id" value="${entity.id}">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                <span class="star">*</span>
                                                姓名:
                                            </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.name" value="${entity.name}" placeholder="请输入姓名" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                             <span class="star"></span>
                                             性别:
                                         </label>
                                                    <div class="col-sm-8" style="padding-left:0;">
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="man" name="entity.gender" value="1" <c:if test="${entity.gender==1}">checked</c:if>
                                                            >
                                                            <label for="man">女</label>
                                                        </div>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="woman" name="entity.gender" value="0" <c:if test="${entity==null||entity.gender==0}">checked</c:if>
                                                            >
                                                            <label for="woman">男</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            出生日期:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.birthDate" value="<s:date name='entity.birthDate' format='yyyy-MM-dd' />" placeholder="请输入出生日期" class="form-control form_date">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">政治面貌：</label>
                                                    <div class="col-sm-8">
                                                        <select id="politicalStatus-sel" name="entity.politicalStatus" class="form-control select-width">
                                            </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star"></span>毕业年份:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.reVarchar1" value="${entity.reVarchar1}" placeholder="请输入" class="form-control form_year">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>
                                            专业:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <select id="majorId" name="entity.major" class="form-control select-width">

                                            </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                         班级名称:
                                     </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.className" value="${entity.className}" placeholder="请输入班级名称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        辅导员/导师:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.teacher" value="${entity.teacher}" placeholder="请输入辅导员/导师" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">行业:</label>
                                                    <div class="col-sm-8">
                                                        <select id="industry-sel" name="entity.industry" class="form-control select-width">
                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        单位地址:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.companyAddress" value="${entity.companyAddress}" placeholder="请输入单位地址" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        部门:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.department" value="${entity.department}" placeholder="请输入部门" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        办公电话:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.officePhone" value="${entity.officePhone}" placeholder="请输入办公电话" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        职称:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.title" value="${entity.title}" placeholder="请输入职称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        家庭邮编:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.reVarchar3" value="${entity.reVarchar3}" placeholder="请输入" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        QQ:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.qq" value="${entity.qq}" placeholder="请输入QQ号码" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        微信昵称:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.wechatName" value="${entity.wechatName}" placeholder="请输入微信昵称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">校友身份:</label>
                                                    <div class="col-sm-8">
                                                        <select id="alumniIdentityName-sel" data-placeholder="请选择" name="entity.alumniIdentityName" class="form-control chosen-select" multiple="multiple">
                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        永久通讯地址:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.address" value="${entity.address}" placeholder="请输入通讯地址" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        备注1:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark1" placeholder="请输入备注" class="form-control">${entity.remark1}</textarea>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        备注3:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark3" placeholder="请输入备注" class="form-control">${entity.remark3}</textarea>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        备注5:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark5" placeholder="请输入备注" class="form-control">${entity.remark5}</textarea>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        备注7:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark7" placeholder="请输入备注" class="form-control">${entity.remark7}</textarea>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        备注9:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark9" placeholder="请输入备注" class="form-control">${entity.remark9}</textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>
                                        学号/职工号:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.code" value="${entity.code}" placeholder="请输入 学号/职工号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>
                                        身份:
                                    </label>
                                                    <div class="col-sm-8" style="padding-left:0;">
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="student" name="entity.identity" value="0" <c:if test="${entity==null||entity.identity==0}">checked</c:if>
                                                            >
                                                            <label for="student">在校生</label>
                                                        </div>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="alumni" name="entity.identity" value="1" <c:if test="${entity.identity==1}">checked</c:if>
                                                            >
                                                            <label for="alumni">校友</label>
                                                        </div>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="staff" name="entity.identity" value="2" <c:if test="${entity.identity==2}">checked</c:if>
                                                            >
                                                            <label for="staff">教职工</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>民族:</label>
                                                    <div class="col-sm-8">
                                                        <select id="reVarchar0-sel" name="entity.reVarchar0" class="form-control select-width">
                                            </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                            <span class="star">*</span>入学年份:
                                        </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.enrollYear" value="${entity.enrollYear}" placeholder="请输入" class="form-control form_year">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                         <span class="star">*</span>
                                         院系:
                                     </label>
                                                    <div class="col-sm-8">
                                                        <select id="collegeId" name="entity.college" class="form-control select-width">
                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>最高学历:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <select id="highestEducation-sel" name="entity.highestEducation" class="form-control select-width">
                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        标签（空格分隔）:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.label" value="${entity.label}" placeholder="请输入标签" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        所在单位:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.company" value="${entity.company}" placeholder="请输入所在单位" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>
                                        单位所在省/市:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <!--TODO:调控件-->
                                                        <input type="hidden" name="entity.companyCity" value="${entity.companyCity}">
                                                        <input type="text" name="entity.companyCityStr" value="${entity.companyCityStr}" placeholder="请输入" class="form-control companyAddress">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        单位邮编:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.reVarchar2" value="${entity.reVarchar2}" placeholder="请输入" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>
                                        手机:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.phone" value="${entity.phone}" placeholder="请输入手机号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star"></span>
                                        职务:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.post" value="${entity.post}" placeholder="请输入职务" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>
                                        籍贯：
                                    </label>
                                                    <div class="col-sm-8">
                                                        <!--TODO:调控件-->
                                                        <input type="hidden" name="entity.natives" value="${entity.natives}">
                                                        <input type="text" name="entity.nativeStr" value="${entity.nativeStr}" placeholder="请输入" class="form-control address">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                        <span class="star">*</span>
                                        邮箱:
                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.email" value="${entity.email}" placeholder="请输入邮箱" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        微信：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.wechatId" value="${entity.wechatId}" placeholder="请输入微信号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">校友会任职身份:</label>
                                                    <div class="col-sm-8">
                                                        <select id="alumniClubIdentityName-sel" data-placeholder="请选择" name="entity.alumniClubIdentityName" class="form-control chosen-select" multiple="multiple">
                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">校友分会任职身份:</label>
                                                    <div class="col-sm-8">
                                                        <select id="branchClubIdentityName-sel" data-placeholder="请选择" name="entity.branchClubIdentityName" class="form-control chosen-select" multiple="multiple">
                                     </select>
                                                    </div>
                                                </div>

                                                <br/><br/>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                    备注2:
                                </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark2" placeholder="请输入备注" class="form-control">${entity.remark2}</textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                    备注4:
                                </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark4" placeholder="请输入备注" class="form-control">${entity.remark4}</textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                    备注6:
                                </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark6" placeholder="请输入备注" class="form-control">${entity.remark6}</textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                    备注8:
                                </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark8" placeholder="请输入备注" class="form-control">${entity.remark8}</textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                    备注10:
                                </label>
                                                    <div class="col-sm-8">
                                                        <textarea rows="7" cols="30" name="entity.remark10" placeholder="请输入备注" class="form-control">${entity.remark10}</textarea>
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
            <script>
                var politicalStatus = '${entity.politicalStatus}'; //政治面貌
                var highestEducation = '${entity.highestEducation}'; //最高学历
                var majorId = '${entity.major}';
                var industry = '${entity.industry}';
                var reVarchar0 = '${entity.reVarchar0}';
                var collegeId = '${entity.college}';
                var alumniClubIdentityId = '${relation.alumniClubIdentityId}';
                var branchClubIdentityId = '${relation.branchClubIdentityId}';
                var alumniIdentityId = '${relation.alumniIdentityId}';
            </script>
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-manage-center/alumni-info-note/create.js"></script>

            </html>