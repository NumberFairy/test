<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/common/portal-header.jsp"%>
        <title>地质大学校友管理系统</title>
        </head>

        <body>
            <%@include file="/WEB-INF/jsp/common/portal-menu.jsp"%>
                <!--内容部分-->
                <div class="main clearfix">
                    <!--左侧部分-->
                    <div class="h_left floatL">
                        <div style="padding: 15px;">
                            <div class="clearfix">
                                <div class="focus-pic floatL">
                                    <%@include file="slider.jsp"%>
                                </div>
                                <div class="news-information floatR">
                                    <h2 class="title-1">新闻动态</h2>
                                    <ul class="newlist2 home-info" data-id="1002">
                                    </ul>
                                </div>
                            </div>

                            <div class="clearfix">

                                <div class="new-content w-405 floatL">
                                    <h2 class="title-1">校友活动</h2>
                                    <ul class="newlist2 home-info" data-id="4001">
                                    </ul>
                                </div>

                                <div class="new-content  w-385 floatR">
                                    <h2 class="title-1">校友风采</h2>
                                    <ul class="newlist2 home-info" data-id="5001">
                                    </ul>
                                </div>

                            </div>
                            <div class="clearfix">
                                <div class="new-content w-405 floatL">
                                    <h2 class="title-1">校友服务</h2>
                                    <ul class="newlist2 home-info" data-id="9001">
                                    </ul>
                                </div>
                                <div class="new-content  w-385 floatR">
                                    <h2 class="title-1">校友捐赠</h2>
                                    <ul class="newlist2 home-info" data-id="6001">
                                    </ul>
                                </div>
                            </div>
                            <div class="w-1050">
                                <h2 class="title-2">校友刊物</h2>
                                <ul class="pic_list clearfix home-info" data-id="7001" data-size="4">
                                </ul>
                            </div>
                            <div class="clearfix">
                                <h2 class="title-1">相关链接</h2>
                                <div class="foot-link">
                                    <a href="http://www.cugb.edu.cn/index.action">母校要闻</a>
                                    <a href="http://xyh.cugb.edu.cn/xy/index/cugb/cugb_info.jsp?informationId=ff808081515b497c01516217e0340002">校友会微信公众号</a>
                                    <a href="http://jiuye.cugb.edu.cn/">就业信息网</a>
                                    <a href="http://jiuye.cugb.edu.cn/">招生信息网</a>
                                    <a href="http://xyh.cugb.edu.cn/xy/index/cugb/cugb_info.jsp?informationId=ff8080813ad70f76013ada3292510036">注册指南</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--右侧部分-->
                    <div class="h_right floatR">
                        <h2 class="title-3">通知公告</h2>
                        <div class="right-con">
                            <ul class="newlist2 home-info" data-id="1001" data-size="4">
                            </ul>
                        </div>
                        <h2 class="title-3">校友文苑</h2>
                        <div class="right-con home-info" data-id="5003" data-size="4">

                        </div>
                        <h2 class="title-3">图片视频</h2>
                        <div class="right-con home-info" data-id="1003" data-size="3">

                        </div>
                        <h2 class="title-3">校友留言</h2>
                        <div class="right-con">
                            <ul class="newlist2 home-info" data-id="80" data-size="4">

                            </ul>
                        </div>
                        <h2 class="title-3">联系我们</h2>
                        <div class="right-con">
                            <p>电 话 : 010-82321854</p>
                            <p>传 真 : 010-82322959</p>
                            <p>邮 箱 : xyh@cugb.edu.cn</p>
                            <p>地 址 : 北京市海淀区学院路29号体育馆202室</p>
                        </div>
                    </div>
                    <!---->
                </div>
                <%@include file="/WEB-INF/jsp/common/js-portal-container.jsp"%>
                    <%@include file="footer.jsp"%>
                        <script src="/resources/js/slider/pageSwitch.min.js"></script>
                        <%@include file="/WEB-INF/jsp/common/portal-footer.jsp"%>
                            <script src="/resources/js/portal/home.js" type="text/javascript"></script>

                            <script type="text/html" id="home-base-tpl">
                                {{each results as v}}
                                <li><a href="/home!load?id={{v.id}}&menuId={{menuId}}">{{v.title}}</a></li>
                                {{/each}}
                                <a class="more" href="/home!load?menuId={{menuId}}">+ 更多</a>
                            </script>
                            <!---->
                            <script type="text/html" id="home-activity-tpl">
                                {{each results as v}}
                                <li><a href="/home!load?id={{v.id}}&menuId={{menuId}}">{{v.title}}</a></li>
                                {{/each}}
                                <a class="more" href="/home!load?menuId={{menuId}}">+ 更多</a>
                            </script>
                            <!-- 图片视频 -->
                            <script type="text/html" id="home-img-tpl">
                                <div class="video_box">
                                    {{if results.length>0}}
                                    <img id="videoPic" src="/gridfs-download?f_id={{results[0].imgId}}"> {{/if}}
                                </div>
                                <ul class="newlist2">
                                    {{each results as v}}
                                    <li><a href="/home!load?id={{v.id}}&menuId={{menuId}}">{{v.title}}</a></li>
                                    {{/each}}
                                    <a class="more" href="/home!load?menuId={{menuId}}">+ 更多</a>
                                </ul>
                            </script>
                            <!-- 友情链接 -->
                            <script type="text/html" id="friendLink-tpl">
                                {{each data as v}}
                                <a href="{{v.linkUrl}}">{{v.name}}</a> {{/each}}
                            </script>
                            <!-- 校友刊物 -->
                            <script type="text/html" id="home-book-tpl">
                                {{each results as v index}}
                                <li>
                                    <a href="/home!load?id={{v.id}}&menuId={{menuId}}">
                                        <img style="width: 160px;height: 199px;" src="/gridfs-download?f_id={{v.imgId}}">
                                        <span>{{v.title}}</span>
                                    </a>
                                </li>
                                {{/each}}
                                <a class="more" href="/home!load?menuId={{menuId}}">+ 更多</a>
                            </script>
                            <!-- 基本消息模版 -->
                            <script type="text/html" id="home-msg-tpl">
                                {{each results as v index}}
                                <li><a href="/home!load?menuId={{menuId}}">{{v.title}}</a></li>
                                {{/each}}
                                <a class="more" href="/home!load?menuId={{menuId}}">+ 更多</a>
                            </script>
                            <!-- 轮播图 -->
                            <script type="text/html" id="slider-tpl">
                                {{each data as v}}
                                <div class="section" style="position: relative;">
                                    <h3 style="">
                                        <a href="{{v.linkUrl}}">{{v.title}}</a>
                                    </h3>
                                    <img src="/gridfs-download?f_id={{v.picId}}" style="width:100%;height:100%;" alt="">
                                </div>
                                {{/each}}
                            </script>
                            <script type="text/javascript">
                                $(function() {
                                    $.post("/home-api!slider?isPc=1", {}, function(data) {
                                        var h = template("slider-tpl", {
                                            "data": data
                                        });
                                        $(".sections").html(h);
                                        $("#container").PageSwitch({
                                            direction: 'horizontal',
                                            easing: 'ease-in',
                                            autoPlay: true,
                                            loop: 'false'
                                        });
                                    }, 'json')
                                    $.post("/home-api!homeFriendshipLink", {}, function(data) {
                                        var h = template("friendLink-tpl", {
                                            "data": data
                                        });
                                        $(".foot-link").html(h);
                                    }, 'json')
                                })
                            </script>
        </body>

        </html>