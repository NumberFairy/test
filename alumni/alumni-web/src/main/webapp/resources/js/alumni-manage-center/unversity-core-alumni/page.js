


var actionPath = contextPath + "/school-key-alumni";
$(function () {
    loadData();

    //学院字典
    creatDicOption("collegeId", "/dic-common!findAllCollege", '', 'aa');
    //专业字典
    creatDicOption("major-sel", "/dic-common!findAllCollegeSpecialty", { 'id': 30100 });
    $('#college-sel').change(function (event) {
        creatDicOption("major-sel", "/dic-common!findAllCollegeSpecialty", { 'id': $(this).val() });
    });
    //学历字典
    creatDicOption("xueLiId", "/dic-common!findAllDicDegree", '', 'aa', null, '-1');
    //政治面貌字典
    creatDicOption("zhengZhiId", "/dic-common!findPoliticalStatus");
    //行业字典
    creatDicOption("industryId", "/dic-common!findDicIndustry");
    //校友会身份
    creatDicOption("clubIdentityId", "/dic-common!findAllAlumniClubIdentity", null, null, null, '-1');
    //校友身份
    creatDicOption("alumniIdentityId", "/dic-common!findAllDicAlumniIdentity", null, '3', null, '-1');
    $('#alumniIdentityId').attr("disabled", true);
    //校友分会身份
    creatDicOption("branchIdentityId", "/dic-common!findDicAlumniBranchIdentity", null, null, null, '-1');


    $(".companyAddress").districtpicker({
        url: contextPath + '/dic-common!findAllDistricts',
        level: 3,
        global: true, //是否有国家
        onchange: function (obj) {
            // var bv = $form.data('bootstrapValidator');
            // //手动触发验证
            // bv.revalidateField(obj);
        }
    });

    $(".table").on('click', '#removeId', function () {
        var id = $(this).data('id');
        alertify.confirm("确定要移除吗？", function (e) {
            if (e) {
                $.post(actionPath + "!delete", { 'id': id }, function (data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("移除成功");
                    }
                }, "json");
                location.href = actionPath + "!hrefPage";
            }
            else {
                return;
            }
        }, "json");
    });

    $("#btn-detail").click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
    });

    $("#btn-search").click(function () {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });

    $("#btn-update").click(function () {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = actionPath + "!hrefAddOrUpdate?entity.id=" + getCheckedFirstId();
    });

    $("#btn-email").click(function () {
        var ids = getCheckedIds();
        $.post(actionPath + "!forEmail?id=" + ids, function (data) {
            if (data.success) {
                $("#emailAddress").val(data.message);
            }
        }, "json");

        $('#myModal').modal({
            keyboard: false
        });
    });

    $("#emailSubmit").click(function () {
        var title = $('#title').val();
        var email = $('#emailAddress').val();
        var replyContent = $('#emailContent').val();
        if (email != "" && replyContent != "") {
            $.post(actionPath + "!sendMail", {
                title: title,
                email: email,
                replyContent: replyContent
            }, function (data) {
                if (data.success) {
                    alertify.alert("发送成功");

                } else {
                    alertify.alert("发送失败");
                }
                setTimeout(function () {
                    location.href = actionPath + "!hrefPage";
                }, 500);
            }, "json");

        } else {
            alertify.alert('邮箱和回复内容不能为空');
        }
    });

    openOrHidden("open-department");
    openOrHidden("open-jobnetwork");

});

function openOrHidden(id) {
    var cObject = $("#" + id);
    cObject.click(function () {
        cObject.find(".ow").toggleClass("hide");
        cObject.prev().toggleClass("fixed-height");
        if (cObject.hasClass("sl-item-option")) {
            cObject.removeClass("sl-item-option");
            cObject.addClass("sl-item-shouqi");
        } else {
            cObject.removeClass("sl-item-shouqi");
            cObject.addClass("sl-item-option");
        }
    });
}


function loadData() {
    var options = {
        url: actionPath + "!page?alumni.alumniIdentityName=3"
    };
    loadPaginationData(options);
}