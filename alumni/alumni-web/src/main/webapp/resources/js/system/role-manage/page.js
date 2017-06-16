/**
 * 用户管理
 * zhangyan@wisdombud.com
 * 20170321
 */

var actionPath = contextPath + "/role-manage";
var data = {};
var testMessage;
$(function () {
    loadData();

    $("#search-btn").click(function () {
        loadData();
    });

    $("#reach").click(function () {
        var params = $("#form").serialize();
        var options = {
            url: actionPath + "!page",
            queryParams: params
        };
        loadPaginationData(options);
    });

    $("#btn-add").click(function () {
        addOrCheck(data);
    });

    $("#add-role").click(function () {

    });

    $("#addRole").click(function () {
        saveRole();
    })

    $("#btn-update").click(function () {
        updateRole();
    });

    $("#btn-limit").click(function () {
        descriptLimit();
    })

    $("#btn-detail").click(function () {
        if (judgeCheckedOneId()) {
            location.href = actionPath + "!hrefDetail?id=" + getCheckedFirstId();
        }
    });

    $("#btn-delete").click(function () {
        deleteRole();
    });

    $("#add-role").on("blur", "#nameVerify", function (data) {
        $("#textShow").empty();
        $("#nameLabel").removeAttr("style");
        $("#nameVerify").removeAttr("style");
        checkIsExist();
    })
});

function loadData() {
    // $().srli
    var options = {
        url: actionPath + "!page",
        queryParams: $("#search").serialize()
    };
    loadPaginationData(options);
}

function addOrCheck(data) {
    var html = template("tpl-role", data);
    if (data.id) {
        $(".modal-title", "#roleModal").html("编辑");
    } else {
        $(".modal-title", "#roleModal").html("添加");
    }
    $("#add-role").html(html);
    $("#roleModal").modal();
    initValidator();
}

function saveRole() {
    var bv = $roleForm.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        var entity = $("#roleForm").serialize();
        $.post(actionPath + "!addOrUpdate", entity, function (data) {
            if (data.success) {
                loadData();
            } else {
                alertify.alert(data.info);
            }
        }, "json");
    }
    $("#roleModal").modal("hide");
}

function updateRole() {
    if (judgeCheckedOneId()) {
        var id = getCheckedFirstId();
        $.post(actionPath + "!detail?id=" + id, function (data) {
            addOrCheck(data);
        }, "json");
    }
}

function deleteRole() {
    if (judgeCheckedIds()) {
        var ids = getCheckedIds();
        alertify.confirm("确定要删除吗？", function (e) {
            if (e) {
                $.post(actionPath + "!delete", { "id": ids.join(',') }, function (data) {
                    if (data.success) {
                        loadData();
                    } else {
                        alertify.alert("删除失败!");
                    }
                }, "json");
            } else {
                return;
            }
        });
    }
}

function checkIsExist() {
    var name = $("#nameVerify").val();
    if (name.length == 0) {
        testMessage = "请输入角色名称";
        $("#textShow").text(testMessage);
        $("#nameLabel").attr("style", "color:#ED5565;display:block;");
        $("#nameVerify").attr("style", "border: 1px solid #ED5565;")
    } else {
        $.post(actionPath + "!nameIsExist?name=" + name, function (data) {
            if (data.success) {
                testMessage = "角色名已存在";
                $("#textShow").text(testMessage);
                $("#nameLabel").attr("style", "color:#ED5565;display:block;");
                $("#nameVerify").attr("style", "border: 1px solid #ED5565;")
            }
        }, "json")
    }
}

function descriptLimit() {
    if (judgeCheckedOneId()) {
        var id = getCheckedFirstId();
        location.href = actionPath + "!hrefPermission?id=" + id;
    }
}

function initValidator(testMessage) {
    $roleForm = $("#roleForm");
    $roleForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.description": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请输入角色描述'
                    }
                }
            },

        }
    })
}