/**
*  校友服务管理--校友通知
*  czjia
*  20170331
* */
var actionPath = contextPath + "/notice-template";

$(function() {
    loadData();

    $("#btn-detail").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
    });

    $("#btn-update").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefAddOrUpdate?id=" + getCheckedFirstId();
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
                        loadData();                        
                        alertify.alert("删除成功");                    
                    }                
                },  "json");                
                location.href  =  actionPath  +  "!hrefPage";            
            } 
            else  {
                return; 
            }    
        });
    });
});

function loadData() {
    var options = {
        url: actionPath + "!page",
    };
    loadPaginationData(options);
}