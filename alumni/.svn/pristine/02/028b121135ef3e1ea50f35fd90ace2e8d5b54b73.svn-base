/**
 * 校友活动管理--校友活动报名情况
 *
 * czjia
 * 20170329
 * */

var actionPath = contextPath + "/alumni-activity";

$(function () {
    loadData();

    $(".table").on('click', '.btn-sign-up-detail', function () {
        var id = $(this).data('id');
        location.href = actionPath + "!hrefSignUpDetail?alumniId=" + id;
    });

    function loadData() {
        var options = {
            url: actionPath + "!signUpPage?signUpId=" + $('#signUpId').val()
        };
        loadPaginationData(options);
    }
});