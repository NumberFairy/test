/**
 * 校友会申请
 *
 * zxguan@wisdombud.com
 * 20170416
 * */

var actionPath = contextPath + "/alumni-club-apply";
$(function() {
    loadData();

    $(document).on('click', '.btn-success', function(e){
    	var id = $(this).data('id');
    	var status = $(this).data('status');
    	if (status == -1) {
    		alertify.confirm("确定通过吗？", function (e) {
                if (e) {
                	passFlow(id);
                }
                else {
                    return;
                }
            });
    	}
    })

    $(document).on('click', '.btn-danger', function(e){
    	var id = $(this).data('id');
    	var status = $(this).data('status');
    	if (status == -1) {
	    	alertify.confirm("确定不通过吗？", function (e) {
	            if (e) {
	            	unPassFlow(id);
	            }
	            else {
	                return;
	            }
	        });
    	}
    })

    $('#btn-detail').click(function(e){
    	if (!judgeCheckedOneId()) {
    		return;
    	}
    	var id = getCheckedFirstId();
    	location.href = contextPath + '/alumni!hrefDetail?id=' + id;
    });
});

function passFlow(id) {
	$.ajax({
        url: actionPath + '!passFlow',
        dataType: "json",
        method: 'post',
        data: {id : id}
    }).then(function(data) {
    	window.location.reload();
    }).fail(function(data){
    });
}

function unPassFlow(id) {
	$.ajax({
        url: actionPath + '!unPassFlow',
        dataType: "json",
        method: 'post',
        data: {id : id}
    }).then(function(data) {
    	window.location.reload();
    }).fail(function(data){
    });
}

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}