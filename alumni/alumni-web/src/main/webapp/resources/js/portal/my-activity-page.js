var actionPath = contextPath + "/alumni-activity-apply";

$(function() {
    var alumniId = $("#alumni-id").val();
    var options = {
        'url': actionPath + "!page",
        'queryParams': {
            'id': alumniId
        }
    };
    loadPaginationData(options);
});

function toAlumniActivity(activityId) {
    location.href = contextPath + "activity-sign-up!hrefAlumniActivityPage?activityId=" + activityId;
}