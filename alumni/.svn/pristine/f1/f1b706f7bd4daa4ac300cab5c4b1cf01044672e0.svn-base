<!--

	校友管理中心--校友信息库
    zxguan
    20170328
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
                                <h5>校友管理中心--学院重点校友--编辑</h5>
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
                                                <input type="hidden" id="entityId" name="entity.alumniId" value="${entity.alumniId}">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                            姓名:
                                                     </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.name" value="${entity.alumni.name}" placeholder="请输入姓名" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                         <span class="star"></span>
                                                          性别:
                                                    </label>
                                                    <div class="col-sm-8" style="padding-left:0;">
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="man" name="entity.alumni.gender" value="1" <c:if test="${entity.alumni.gender==1}">checked</c:if>
                                                            >
                                                            <label for="man">女</label>
                                                        </div>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="woman" name="entity.alumni.gender" value="0" <c:if test="${entity.alumni==null||entity.alumni.gender==0}">checked</c:if>
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
                                                        <input type="text" name="entity.alumni.birthDate" value="<s:date name='entity.birthDate' format='yyyy-MM-dd' />" placeholder="请输入出生日期" class="form-control form_date">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                            政治面貌：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <select name="entity.alumni.politicalStatus" class="form-control select-width">
                                                            <s:iterator value="dicPoliticalStatusList">
                                                                <s:if test = "entity.alumni.politicalStatus == id">
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
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        毕业年份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.reVarchar1" value="${entity.alumni.reVarchar1}" placeholder="请输入" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        专业:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <select id="majorId" name="entity.alumni.major" class="form-control select-width">
                                                            <s:iterator value="dicSpecialtyList">
                                                                <s:if test = "entity.alumni.major == id">
                                                                    <option value="${id}" selected>${cnName}</option>
                                                                </s:if>
                                                                <s:else>
                                                                    <option value="${id}">${cnName}</option>
                                                                </s:else>
                                                            </s:iterator>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                             班级名称:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.className" value="${entity.alumni.className}" placeholder="请输入班级名称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        辅导员/导师:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.teacher" value="${entity.alumni.teacher}" placeholder="请输入辅导员/导师" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        行业:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <select name="entity.alumni.industry" class="form-control select-width">
                                                            <s:iterator value="dicIndustryList">
                                                                <s:if test = "entity.alumni.industry == id">
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
                                                    <label class="col-sm-4 control-label">
                                                        单位地址:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.companyAddress" value="${entity.alumni.companyAddress}" placeholder="请输入单位地址" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        部门:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.department" value="${entity.alumni.department}" placeholder="请输入部门" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        办公电话:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.officePhone" value="${entity.alumni.officePhone}" placeholder="请输入办公电话" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        职称:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.title" value="${entity.alumni.title}" placeholder="请输入职称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        家庭邮编:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.reVarchar3" value="${entity.alumni.reVarchar3}" placeholder="请输入" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        QQ:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.qq" value="${entity.alumni.qq}" placeholder="请输入QQ号码" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        微信昵称:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.wechatName" value="${entity.alumni.wechatName}" placeholder="请输入微信昵称" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        校友身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="button" id="btn2" class="form-control" value="${entity.alumni.alumniIdentityName}">
                                                        <div id="div2" style="display: none;">
                                                            <select id="usertype2" value="${entity.alumniIdentityId}" class="selectpicker show-tick form-control" multiple data-live-search="false">
                                                            <s:iterator value="dicAlumniIdentityList">
                                                                    <option value="${id}">${value}</option>
                                                            </s:iterator>
                                                        </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        永久通讯地址:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.address" value="${entity.alumni.address}" placeholder="请输入通讯地址" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注1:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark1" value="${entity.alumni.remark1}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注3:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark3" value="${entity.alumni.remark3}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注5:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark5" value="${entity.alumni.remark5}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注7:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark7" value="${entity.alumni.remark7}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                    备注9:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark9" value="${entity.alumni.remark9}" placeholder="请输入备注" class="form-control">
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
                                                        <input type="text" name="entity.alumni.code" value="${entity.alumni.code}" placeholder="请输入 学号/职工号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        身份:
                                                    </label>
                                                    <div class="col-sm-8" style="padding-left:0;">
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="student" name="entity.alumni.identity" value="0" <c:if test="${entity.alumni==null||entity.alumni.identity==0}">checked</c:if>
                                                            >
                                                            <label for="student">在校生</label>
                                                        </div>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="alumni" name="entity.alumni.identity" value="1" <c:if test="${entity.alumni.identity==1}">checked</c:if>
                                                            >
                                                            <label for="alumni">校友</label>
                                                        </div>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input type="radio" id="staff" name="entity.alumni.identity" value="2" <c:if test="${entity.alumni.identity==2}">checked</c:if>
                                                            >
                                                            <label for="staff">教职工</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        民族:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.reVarchar0" value="${entity.alumni.reVarchar0}" placeholder="请输入" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        入学年份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.enrollYear" value="${entity.alumni.enrollYear}" placeholder="请输入" class="form-control form_year">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                         <span class="star">*</span>
                                                             院系:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <select id="collegeId" name="entity.alumni.college" class="form-control select-width">
                                                            <s:iterator value="dicCollegeList">
                                                                <s:if test = "entity.alumni.college == id">
                                                                    <option value="${id}" selected>${cnName}</option>
                                                                </s:if>
                                                                <s:else>
                                                                    <option value="${id}">${cnName}</option>
                                                                </s:else>
                                                            </s:iterator>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                    最高学历:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <select name="entity.alumni.highestEducation" class="form-control select-width">
                                                            <s:iterator value="dicDegreeList">
                                                                <s:if test = "entity.alumni.highestEducation == id">
                                                                    <option value="${id}" selected>${cnName}</option>
                                                                </s:if>
                                                                <s:else>
                                                                    <option value="${id}">${cnName}</option>
                                                                </s:else>
                                                            </s:iterator>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        标签（空格分隔）:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.label" value="${entity.alumni.label}" placeholder="请输入标签" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        所在单位:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.company" value="${entity.alumni.company}" placeholder="请输入所在单位" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        单位所在省/市:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <!--TODO:调控件-->
                                                        <input type="hidden" name="entity.alumni.companyCity" value="${entity.alumni.companyCity}">
                                                        <input type="text" name="entity.alumni.companyCityStr" value="${entity.alumni.companyCityStr}" placeholder="请输入" class="form-control companyAddress">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        单位邮编:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.reVarchar2" value="${entity.alumni.reVarchar2}" placeholder="请输入" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        手机:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.phone" value="${entity.alumni.phone}" placeholder="请输入手机号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        职务:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.post" value="${entity.alumni.post}" placeholder="请输入职务" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                         籍贯：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <!--TODO:调控件-->
                                                        <input type="hidden" name="entity.alumni.natives" value="${entity.alumni.natives}">
                                                        <input type="text" name="entity.alumni.nativeStr" value="${entity.alumni.nativeStr}" placeholder="请输入" class="form-control address">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        邮箱:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.email" value="${entity.alumni.email}" placeholder="请输入邮箱" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        微信：
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.wechatId" value="${entity.alumni.wechatId}" placeholder="请输入微信号" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        校友会任职身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="button" id="btn1" class="form-control" value="${entity.alumni.alumniClubIdentityName}">
                                                        <div id="div1" style="display: none;">
                                                            <select id="usertype1" value="${entity.alumniClubIdentityId}" class="selectpicker show-tick form-control" multiple data-live-search="false">
                                                            <s:iterator value="dicAlumniClubIdentityList">
                                                                
                                                                    <option value="${id}" >${value}</option>
                                                               
                                                            </s:iterator>
                                                        </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        <span class="star">*</span>
                                                        校友分会任职身份:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="button" id="btn3" class="form-control" value="${entity.alumni.branchClubIdentityName}">
                                                        <div id="div3" style="display: none;">
                                                            <select id="usertype3" value="${entity.branchClubIdentityId}" class="selectpicker show-tick form-control" multiple data-live-search="false">
                                                            <s:iterator value="dicAlumniBranchIdentityList">
                                                                    <option value="${id}">${value}</option>
                                                            </s:iterator>
                                                        </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注2:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark2" value="${entity.alumni.remark2}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注4:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark4" value="${entity.alumni.remark4}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注6:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark6" value="${entity.alumni.remark6}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注8:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark8" value="${entity.alumni.remark8}" placeholder="请输入备注" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">
                                                        备注10:
                                                    </label>
                                                    <div class="col-sm-8">
                                                        <input type="text" name="entity.alumni.remark10" value="${entity.alumni.remark10}" placeholder="请输入备注" class="form-control">
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
                var alumniClubIdentityId = '${entity.alumniClubIdentityId}';
                var branchClubIdentityId = '${entity.branchClubIdentityId}';
                var alumniIdentityId = '${entity.alumniIdentityId}';
            </script>
            <script type="text/javascript" src="${contentPath}/resources/js/alumni-manage-center/college-core-alumni/create.js"></script>

            </html>