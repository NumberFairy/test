var actionPath = contextPath + "/activity-sign-up";

$(function() {
    var activityId = $("#activity-id").val();
    var options = {
        'url': actionPath + "!alumniActivityPage",
        'queryParams': {
            'id': activityId
        }
    };
    loadPaginationData(options);
});