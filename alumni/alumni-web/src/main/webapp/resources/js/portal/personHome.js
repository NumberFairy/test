/**
 *校友主页
 */

$(function() {
    creatDicOption("collegeId", "/dic-common!findAllCollege", '', '');
    creatDicOption("majorId", "/dic-common!findAllCollegeSpecialty", '', '');
    loadAppliedActivityData();
    loadActivityApplyData();
    loadAlumniData();
    loadMyBranchData();
    $("#btn-item").click(function() {
        var $searchTiaojian = $(".search-tiaojian");
        if ($searchTiaojian.css("display") == "none") {
            $searchTiaojian.css("display", "block");
        } else {
            $searchTiaojian.css("display", "none");
        }
    })
    $("#btn-search").click(function() {
        var params = $("#form").serialize();
        var options = {
            url: "alumni!page",
            queryParams: params
        };
        loadPaginationData(options);
    });

});

/**
 * 我报名的活动
 */
function loadAppliedActivityData() {
    var id = $("#alumni-id").val();
    $.post("home!myActivity", { 'id': id }, function(data) {
        var appliedActivity = [];
        for (var i = 0; i < data.length; i++) {
            appliedActivity.push(data[i]);
        }
        var html = template('gridTplAppliedActivity', { 'appliedActivity': appliedActivity });
        $("#gridBodyAppliedActivity").html(html);
    }, 'json');
}

/**
 * 我发布的活动
 */
function loadActivityApplyData() {
    var id = $("#alumni-id").val();
    $.post("alumni-activity-apply!myApplyActivity", { 'id': id }, function(data) {
        var activity = [];
        for (var i = 0; i < data.length; i++) {
            activity.push(data[i]);
        }
        var html = template('gridTplActivityApply', { 'activity': activity });
        $("#gridBodyActivityApply").html(html);
    }, 'json');
}

/**
 * 我的校友
 */
function loadAlumniData() {
    var options = {
        url: "alumni!page"
    };
    loadPaginationData(options);
}

/**
 * 我的校友会
 */
function loadMyBranchData() {
    $.post("alumni-user!pageMyBranch", function(data) {
        var myBranch = [];
        for (var i = 0; i < data.length; i++) {
            myBranch.push(data[i]);
        }
        var h = template('gridTplMyBranch', { 'myBranch': myBranch });
        $('#gridBodyMyBranch').html(h);
    }, 'json')
}