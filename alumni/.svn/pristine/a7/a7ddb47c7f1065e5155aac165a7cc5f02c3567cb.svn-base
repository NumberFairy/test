<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>校友管理及分析系统</title>
        </head>

        <body>
            <!--导航栏-->
            <%@include file="menu.jsp"%>
                <!--内容部分-->
                <div class="main-form main-page">
                    <!--我发布的活动-->
                    <div class="row clearfix">
                        <div class="col-sm-6 percentage6">
                            <div class="cm_box_item">
                                <div class="ibox-title">
                                    <h5 style="color:#d9534f;"><i class="fa fa-paper-plane"></i> 我发布的活动</h5>
                                </div>
                                <div class="ibox-content pad10">
                                    <div>
                                        <table class="table first-table">
                                            <thead>
                                                <tr>
                                                    <th width="80">活动主题</th>
                                                    <th width="120">活动地点</th>
                                                    <th width="100">活动开始时间</th>
                                                    <th width="80">活动结束时间</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table-auto">
                                        <table class="table">
                                            <tbody id="gridBodyActivityApply">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--我报名的活动-->
                        <div class="col-sm-6 percentage6">
                            <div class="cm_box_item">
                                <div class="ibox-title">
                                    <h5 style="color:#23b7e5;"><i class="fa fa-bell"></i> 我报名的活动</h5>
                                </div>
                                <div class="ibox-content pad10">
                                    <div>
                                        <table class="table first-table">
                                            <thead>
                                                <tr>
                                                    <th width="80">活动主题</th>
                                                    <th width="120">活动地点</th>
                                                    <th width="100">活动开始时间</th>
                                                    <th width="80">活动结束时间</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table-auto">
                                        <table class="table">
                                            <tbody id="gridBodyAppliedActivity">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--我的校友会-->
                    <div class="row clearfix">
                        <div class="col-sm-4 percentage4">
                            <div class="cm_box_item">
                                <div class="ibox-title">
                                    <h5 style="color:cornflowerblue"><i class="fa fa-list"></i> 我的校友会</h5>
                                </div>
                                <div class="ibox-content pad10">
                                    <div>
                                        <table class="table first-table">
                                            <thead>
                                                <tr>
                                                    <th width="80">校友会名称</th>
                                                    <th width="120">会长</th>
                                                    <th width="100">成员数</th>
                                                    <th width="80">所在地</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table-auto">
                                        <table class="table">
                                            <tbody id="gridBodyMyBranch">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8 percentage8">
                            <div class="cm_box_item">
                                <div class="ibox-title clearfix">
                                    <h5 style="color:blueviolet;" class="pull-left"><i class="fa fa-pencil-square-o"></i> 我的校友</h5>
                                    <h5 class="pull-left btn-item" id="btn-item"><i class="fa fa-search"></i> 校友搜索</h5>
                                </div>
                                <div class="clearfix pad10 search-tiaojian" style="margin-top:15px;">
                                    <form class="form-horizontal form-reset" id="form">
                                        <div class="clearfix">
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">姓名：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control input-reset" name="entity.name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">入学年份：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control input-reset form_year" name="entity.enrollYear">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">院系：</label>
                                                <div class="col-sm-7">
                                                    <select id="collegeId" name="entity.college" class="form-control">
                                                </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">专业：</label>
                                                <div class="col-sm-7 clearfix">
                                                    <div class="col-sm-7 pull-left" style="width:75%;padding-left:0;">
                                                        <select id="majorId" name="entity.major" class="form-control">
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-2 pull-right" style="width:25%;">
                                                        <button class="btn btn-primary" type="button" id="btn-search">查 询</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                                <div class="ibox-content pad10">
                                    <div>
                                        <table class="table first-table">
                                            <thead>
                                                <tr>
                                                    <th width="80">姓名</th>
                                                    <th width="120">学院</th>
                                                    <th width="100">专业</th>
                                                    <th width="80">入学年份</th>
                                                    <th width="100">工作单位</th>
                                                    <th width="100">所在省市</th>
                                                    <th width="100">单位电话</th>
                                                    <th width="100">职务</th>
                                                    <th width="100">职称</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <!--tbody-->
                                    <div class="table-auto">
                                        <table class="table">
                                            <tbody id="gridBody">
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--我的校友-->
                </div>
                <!--内容部分end-->
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
        </body>

        <script type="text/javascript" src="${contentPath}\resources\js\portal\personHome.js"></script>
        <!--我发布的活动-->
        <script type="text/html" id="gridTplActivityApply">
            {{each activity as value}}
            <tr>
                <td width="80">{{value.title}}</td>
                <td width="120">{{value.place}}</td>
                <td width="100">{{value.startTime}} </td>
                <td width="80">{{value.endTime}}</td>
            </tr>
            {{/each}}
        </script>
        <!--我报名的活动-->
        <script type="text/html" id="gridTplAppliedActivity">
            {{each appliedActivity as value}}
            <tr>
                <td width="80">{{value.title}}</td>
                <td width="120">{{value.place}}</td>
                <td width="100">{{value.startTime}} </td>
                <td width="80"> {{value.endTime}}</td>
            </tr>
            {{/each}}
        </script>
        <!--我的校友会-->
        <script type="text/html" id="gridTplMyBranch">
            {{each myBranch as value index}}
            <tr id="{{value.id}}">
                <td width="80">{{value.name}}</td>
                <td width="120">{{value.huizhang}}</td>
                <td width="100">{{value.memberNum}}</td>
                <td width="80">{{value.address}}</td>
            </tr>
            {{/each}}
        </script>
        <!--我的校友-->
        <script type="text/html" id="gridTpl">
            {{each results as value index}}
            <tr id="{{value.id}}">
                <td width="80">{{value.name}}</td>
                <td width="120">{{value.collegeName}}</td>
                <td width="100">{{value.magorName}}</td>
                <td width="80">{{value.enrollYear}}</td>
                <td width="100">{{value.company}}</td>
                <td width="100">{{value.companyCity}}</td>
                <td width="100">{{value.officePhone}}</td>
                <td width="100">{{value.post}}</td>
                <td width="100">{{value.title}}</td>
            </tr>
            {{/each}}
        </script>

        </html>