/**
 * 门户菜单管理--友情链接管理
 *
 * zxguan@wisdombud.com
 * 20170408
 * */

var actionPath = contextPath + "/home-friendship-link";

$(function() {
    loadData();

    $("#btn-search").click(function() {
        var params = $("#form").serialize();
        loadData(params);
    });

    $("#btn-update").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefAddOrUpdate?entity.id=" + getCheckedFirstId();
    });

    $("#btn-delete").click(function() {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？",  function (e)  {            
            if  (e)  {                
                $.post(actionPath  +  "!delete?id="  +  ids.join(','),  function (data)  {                    
                    if  (data.success)  {
                        alertify.alert("删除成功");
                        window.location.reload();              
                    }                
                },  "json");
            } 
            else  {
                return;
            }    
        });
    });
});

function loadData(params) {
    var options;
    if (params) {
        options = {
            url: actionPath + "!page",
            queryParams: params
        };
    } else {
        options = {
            url: actionPath + "!page",
        };
    }
    loadPaginationData(options);
}