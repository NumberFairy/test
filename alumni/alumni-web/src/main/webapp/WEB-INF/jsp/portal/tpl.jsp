<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <script type="text/html" id="header-tpl">
        <h2 class="title-4 bag-none">{{title}}</h2>
        <s:if test="menuId==80">
            <button type="button" id="liuyan">留言</button>
        </s:if>
    </script>
    <script type="text/html" id="detail-header-tpl">
        <h2 class="title-4  bag-none">{{title}}</h2>
            {{if isSignUp}}
    			{{# isSignUp==1?"<button type='button' class='baoming' id='baoming'>报名</button>":"<button class='baoming' type='button'>已报名</button>"}}
    		{{/if}}
    </script>
    <!-- 留言板模版 -->
    <script type="text/html" id="msg-tpl">
        {{each results as v}}
        <div class="liuyan-content clearfix">
            <div class="floatL student-info">
                <div class="student-infos">
                    {{v.name}}
                </div>
            </div>
            <div class="reply">
                <div class="threadlist_lz clearfix">
                    <div class="threadlist_title floatL">
                        <a href="javascript:;">{{v.title}}</a>
                    </div>
                    <div class="floatR">
                        <span class="liuyan-time">
                        {{v.createTime | dateFormat:'yyyy-MM-dd'}}
                    </span>
                    </div>
                </div>
                <p class="answer-content">{{v.message}}</p>
                {{if v.isShow==1}}
                <div class="threadlist_detail">
                    <h4><span>管理员</span>回复:</h4>
                    <span class="time">{{v.replyTime | dateFormat:'yyyy-MM-dd'}}</span>
                    <p class="replay-content">{{v.replyContent}}</p>
                </div>
                {{/if}}
            </div>
        </div>
        {{/each}}
    </script>
    <!-- 基本列表模版 -->
    <script type="text/html" id="list-tpl">
        {{if results.length
        <1}} <div class="no-data">暂无数据</div>{{/if}} {{each results as v}}
            <dl class="clearfix">
                <dt>{{#v.createTime | dateTitle}}</dt>
                <dd class="content">
                    <a href="/home!load?id={{v.id}}&menuId=${menuId}">
                {{if v.isTop==1}}<font color="red">【置顶】</font>{{/if}}{{v.title}}</a>
                    <p class="abstract">{{v.summary}}</p>
                </dd>
            </dl>
            {{/each}}
    </script>

    <script type="text/html" id="detail-tpl">
        <h3 class="articel-title">{{title}}</h3>
        <input hidden="hidden" id="d-id" value="{{id}}">
        <div class="sub-tit">
            发布人：{{publisher}}&nbsp;&nbsp;&nbsp;&nbsp;发布日期：{{createTime}}
        </div>
        <div class="article-content">
            <!--{{if imgId}}
            <div align="center">
                <img style="width:900px" src="/gridfs-download?f_id={{imgId}}" alt="">
            </div>
            <br> {{/if}}-->{{#content}} {{if videoId}}
            <div align="center">
                <video id="really-cool-video" class="video-js vjs-default-skin" controls preload="auto" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup='{}'>
                    <source src="http://localhost:8080/gridfs-download?f_id={{videoId}}" type='video/webm'>
                        <source src="http://localhost:8080/gridfs-download?f_id={{videoId}}" type='video/mp4'>
                        </video>
            </div>
            {{/if}} {{if fileId}}
            <div>
                <a href="/gridfs-download?f_id={{fileId}}">下载附件</a>
            </div>
            {{/if}}
        </div>
    </script>

    <div class="modal fade" id="liuyan-model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" style="width: 630px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                    <h4 class="modal-title">留言</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal bv-form clearfix" id="msg-form">

                        <div class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>标题：</label>
                            <div class="col-sm-7">
                                <input name="msg.title" placeholder="请输入标题" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>姓名：</label>
                            <div class="col-sm-7">
                                <input id="msgName" name="msg.name" placeholder="请输入姓名" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3"><span class="star">*</span>邮箱：</label>
                            <div class="col-sm-7">
                                <input id="msgEmail" name="msg.email" placeholder="请输入邮箱" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3">QQ：</label>
                            <div class="col-sm-7">
                                <input id="msgQQ" name="msg.qq" placeholder="请输入QQ" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3">内容：</label>
                            <div class="col-sm-7">
                                <textarea class="form-control" rows="5" name="msg.message" placeholder="请输入内容"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="msg-btn">确定
                     </button>
                </div>
            </div>
        </div>
    </div>