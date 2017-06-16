/**
 *  首页
 *   xiefei 
 * */
$(function() {
    $(".home-info").each(function() {
        var menuId = $(this).data('id');
        var size = $(this).data('size');
        var url = '/home-api!pageHomeInfo';
        if (menuId) {
            init(url, menuId, $(this), '', (size ? size : 6));
        }
    });
});

function init(url, menuId, $s, templateId, limit) {
    //图片视频
    if (menuId == 1003 || menuId == 5003) {
        templateId = 'home-img-tpl';
    }
    if (menuId == 7001) {
        templateId = 'home-book-tpl';
    }
    if (menuId == 80) {
        url = "/home-api!pageMessageBoard";
        templateId = 'home-msg-tpl';
    }
    if (menuId == 4001) {
        url = "/home-api!pageActiveInfo";
        templateId = 'home-activity-tpl';
    }
    var templateId = (templateId ? templateId : 'home-base-tpl');
    var options = {
        'url': url,
        'templateId': templateId,
        'queryParams': {
            'menuId': menuId,
            'limit': limit
        }
    };

    loadData(options, $s);
}


function loadData(options, $s) {
    var appendElement = options.appendElement;
    $.ajax({
        url: options.url,
        dataType: "json",
        method: 'post',
        data: options.queryParams
    }).then(function(data) {
        data.menuId = options.queryParams.menuId;
        var h = template(options.templateId, data);
        $s.html(h);
    });
}