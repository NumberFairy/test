<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="footer-content">
        <div class="footer-con">
            <div class="footer-desc">
                <p>
                    中国地质大学校友会
                </p>
                <p>技术支持：北京慧萌信安软件技术有限公司</p>
            </div>
        </div>
    </div>
<<<<<<< .mine
</div>
<!-- 下面的js片段用来填充导航栏的一级菜单(具体样式显示) -->
<script type="text/html" id="menu-tpl">
    {{each data as v}}
    <li class="menu-item">
        <a class="menu-text isMenu" href="/home!load?menuId={{v.menuId}}">{{v.name}}</a>
        <ul class="menu-inner">
            {{each v.children as s}}
            <li class="menu-inner-item">
                <a class="menu-text isMenu" href="/home!load?menuId={{s.menuId}}">{{s.name}}</a>
            </li>
            {{/each}}
        </ul>
    </li>
    {{/each}}
</script>
=======
    <script type="text/html" id="menu-tpl">
        {{each data as v}}
        <li class="menu-item">
            <a class="menu-text isMenu" href="/home!load?menuId={{v.menuId}}">{{v.name}}</a>
            <ul class="menu-inner">
                {{each v.children as s}}
                <li class="menu-inner-item">
                    <a class="menu-text isMenu" href="/home!load?menuId={{s.menuId}}">{{s.name}}</a>
                </li>
                {{/each}}
            </ul>
        </li>
        {{/each}}
    </script>
>>>>>>> .r8122

    <script type="text/html" id="left-menu-tpl">
        {{each data as v}} {{if v.menuId=='${menuId}'}}
        <li><a class="isMenu" href="/home!load?menuId={{v.menuId}}">{{v.name}}</a></li>
        {{else}}
        <li><a href="/home!load?menuId={{v.menuId}}">{{v.name}}</a></li>
<<<<<<< .mine
    {{/if}} 
    {{/each}}
</script>

<!-- 下面的js片段用来填充导航栏的一级菜单（数据请求） -->
<script type="text/javascript">
    $(function(){
        var menuId='${menuId}';
        $.get('/home!homeMenus',function(data){
            if(data){
                var h =  template("menu-tpl", {'data':data});
                $('#home-menu-key').html(h);
                return;
            }
            location.href="/home";
        },"json")

        if(menuId){
            $.get('/home!leftMenus?menuId='+menuId,function(data){
                if(data){
                    var h =  template("left-menu-tpl", {'data':data});
                    $('#left-menu').html(h);
=======
        {{/if}} {{/each}}
    </script>
    <script type="text/javascript">
        $(function() {
            var menuId = '${menuId}';
            $.get('/home!homeMenus', function(data) {
                if (data) {
                    var h = template("menu-tpl", {
                        'data': data
                    });
                    $('#home-menu-key').html(h);
>>>>>>> .r8122
                    return;
                }
                location.href = "/home";
            }, "json")

            if (menuId) {
                $.get('/home!leftMenus?menuId=' + menuId, function(data) {
                    if (data) {
                        var h = template("left-menu-tpl", {
                            'data': data
                        });
                        $('#left-menu').html(h);
                        return;
                    }
                    location.href = "/home";
                }, "json")
            }
        })
    </script>