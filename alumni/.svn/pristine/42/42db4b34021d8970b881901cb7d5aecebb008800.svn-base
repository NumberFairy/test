/**
 * 校友管理中心--校友信息库
 *
 * zxguan@wisdombud.com
 * 20170303
 * */

var actionPath = contextPath + "/alumni";

$(function() {
    loadData();

    //学院字典
    creatDicOption("collegeId", "/dic-common!findAllCollege", '', 'aa');
    //专业字典
    creatDicOption("major-sel", "/dic-common!findAllCollegeSpecialty", { 'id': 30100 });
    $('#college-sel').change(function(event) {
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
    creatDicOption("alumniIdentityId", "/dic-common!findAllDicAlumniIdentity", null, null, null, '-1');
    //校友分会身份
    creatDicOption("branchIdentityId", "/dic-common!findDicAlumniBranchIdentity", null, null, null, '-1');

    $(".companyAddress").districtpicker({
        url: contextPath + '/dic-common!findAllDistricts',
        level: 3,
        global: true, //是否有国家
        onchange: function(obj) {
            // var bv = $form.data('bootstrapValidator');
            // //手动触发验证
            // bv.revalidateField(obj);
        }
    });
    $("#btn-search").click(function() {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });

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
        location.href = actionPath + "!hrefAddOrUpdate?entity.id=" + getCheckedFirstId();
    });

    $("#btn-delete").click(function() {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？", function(e) {
            if (e) {
                $.post(actionPath + "!delete?id=" + ids.join(','), function(data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("删除成功");
                    }
                }, "json");
                location.href = actionPath + "!hrefPage";
            } else {
                return;
            }
        });
    });

    $("#btn-email").click(function() {
        var ids = getCheckedIds();
        $.post(actionPath + "!forEmail?id=" + ids, function(data) {
            if (data.success) {
                $("#emailAddress").val(data.message);
            }
        }, "json");

        $('#myModal').modal({
            keyboard: false
        });
    });

    /********************导出开始（jfzhai）************************/
    /**
     * 获取导出字段
     */
    function genExportFields() {
        var exportFields = [];
        var allCh = $("#exportFieldChecks").find(':checkbox');
        for (var i = 0; i < allCh.length; i++) {
            if (allCh[i].checked) {
                exportFields.push(allCh[i].value);
            }
        }
        return exportFields;
    }

    // 全选、取消全选
    $('#check-all').click(function(e) {
        var allCh = $("#exportFieldChecks").find(':checkbox');
        for (var i = 0; i < allCh.length; i++) {
            allCh[i].checked = e.target.checked;
        }
    });

    /**
     * 导出/导出全部
     * @param {*} isExportAll 
     * by jfzhai
     */
    function exportInfo(isExportAll) {
        var domId = isExportAll == true ? 'btn-export-all' : 'btn-export';
        var ids = [];
        $("#" + domId).click(function() {
            if (!isExportAll) {
                if (!judgeCheckedIds()) {
                    return;
                }
                ids = getCheckedIds();
            }

            $('#myModal-export').modal({
                keyboard: false
            });

            /*导出当前查询条件下的所有校友*/
            $('#exprot_btn').on('click', function() {
                location.href = "alumni!exportInfo?exportFields=" + genExportFields().join() + "&" + "id=" + ids.join() + "&" + $("#form").serialize();
            });
        });
    }
    exportInfo(true);
    exportInfo(false);
    /********************导出结束************************/

    $("#emailSubmit").click(function() {
        var flag = false;
        var title = $('#title').val();
        var email = $('#emailAddress').val();
        var replyContent = $('#emailContent').val();
        if (email != "" && replyContent != "") {
            $.post(actionPath + "!sendMail", {
                title: title,
                email: email,
                replyContent: replyContent
            }, function(data) {
                if (data.success) {
                    alertify.alert("发送成功");

                } else {
                    alertify.alert("发送失败");
                }
                setTimeout(function() {
                    location.href = actionPath + "!hrefPage";
                }, 500);
            }, "json");

        } else {
            alertify.alert('邮箱和回复内容不能为空');
        }
    });

    $("#btn-liaison").click(function() {
        if (!judgeCheckedIds()) {
            return;
        }
        var ids = getCheckedIds();
        alertify.confirm("确定要设为联络员吗？", function(e) {
            if (e) {
                $.post(actionPath + "!becomeLiaison?id=" + ids.join(','), function(data) {
                    if (data.success) {
                        loadData();
                        alertify.alert("设置联络员成功！");
                    }
                }, "json");

            } else {
                return;
            }
        });
    });
    $("#btn-timeline").click(function() {
        if (!judgeCheckedOneId()) {
            return;
        }
        location.href = contextPath + "/timeline" + "!hrefDisplayTimeline?alumniId=" + getCheckedFirstId();

    });

    openOrHidden("open-department");
    openOrHidden("open-jobnetwork");

    function openOrHidden(id) {
        var cObject = $("#" + id);
        cObject.click(function() {
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

});

function loadData() {
    var options = {
        url: actionPath + "!page"
    };
    loadPaginationData(options);
}