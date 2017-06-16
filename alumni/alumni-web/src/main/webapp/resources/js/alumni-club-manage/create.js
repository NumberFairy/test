/**
 * 校友会管理--分会管理
 * hmguo@wisdombud.com
 * 20170308
 * */

var actionPath = contextPath + "/alumni-club";
var staffPath = contextPath + "/alumni-branch-staff";
var $baseInfoForm = $('#baseInfoForm');
var $modalForm;
var $modal = $('#myModal');
var objList = [];
$(function() {
    validator();

    if (id) {
    	initList();
    }

    // 日历
    $('.form_datetime').datetimepicker({
        minView: "month", //选择日期后，不会再跳转去选择时分秒
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        todayBtn:  1,
        autoclose: 1,
    });

    $("#btn-submit").click(function() {
        var bv = $baseInfoForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            var entity = $("#baseInfoForm").serialize();
            var options = {
            	url	: actionPath + "!addOrUpdate",
            	queryParam : entity + "&jsonListEntity=" + JSON.stringify(objList) + '&type=' + type
            };
            multiFormSubmit(options);
        }
    });

    $("#btn-add").click(function() {
        toAddOrUpdateModal({});
    });

    var updateIndex;
    $("#btn-update").click(function() {
        if (judgeCheckedOneId()) {
            var index = getCheckedIndexs()[0];
        	//用于模态窗中点击确定按钮时，区分是新增还是修改
        	updateIndex = index;
            toAddOrUpdateModal(objList[index]);
        }
    });

    $("#btn-delete").click(function() {
        if (judgeCheckedIds()) {
            var indexArray = getCheckedIndexs();
            for (var i = indexArray.length - 1; i >= 0; i--) {
                objList.splice(indexArray[i], 1);
            }
        }
        loadTable(objList);
    });

    $('#btn-confirm').click(function() {
        var bv = $modalForm.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
            $modal.modal("hide");
            var object = $modalForm.serializeObject();
            if (object.name != '') {
            	objList.push(object);
            }
            if (typeof updateIndex != 'undefined' && updateIndex != 999) {
                objList.splice(updateIndex, 1);
            }
            loadTable(objList);
            updateIndex = 999;
        }
    });

    $(document).on('change', '#staff', function(e){
    	var id = $(this).attr("id");
    	var value = $('#staff option:selected').text();
    	$('#' + id + "Str").val(value);
    });
})

function validator() {
    $baseInfoForm = $('#baseInfoForm');
    $baseInfoForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
            "entity.email": {
            	validators: {
                    notEmpty: {
                        message: '请填写邮箱'
                    },
                    regexp: {
                        regexp: /^(?=\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$).{0,30}$/,
                        message: '输入的不是一个有效的邮箱'
                    }
                }
            }
        }
    });
}

function initList() {
	$.post(staffPath + "!initList", {
		"id": id
	}, function(data) {
        if (data) {
            objList = data;
            loadTable(objList);
        }
    }, "json");
}

function getCheckedIndexs(selector) {
    var $childChecks = $('.child', selector || document);
    var indexs = [];
    $.each($childChecks, function(i, dom) {
        if ($(dom).prop("checked")) {
            indexs.push(i);
        }
    });
    return indexs;
}

function toAddOrUpdateModal(data) {
    var html = template("tpl-modal", data);
    if (data) {
        $(".modal-title", "#myModal").html("修改校友分会领导");
    } else {
        $(".modal-title", "#myModal").html("新增校友分会领导");
    }
    $("#modal-body").html(html);
    findBranchIdentity();
    $modalForm = $('#form-modal')
    modalValidator();
}

function findBranchIdentity() {
	$.post(contextPath + "/alumni-club!findIdentity", {}, function(data) {
        if (data && data.length > 0) {
        	var html = template('selTpl', {'results' : data});
        	$('#staff').html(html);
            $modal.modal("show");
        }
    }, "json");
}

function loadTable(objList){
    var html = template("gridTpl", { 'results': objList });
    $("#gridBody").html(html);
}

function modalValidator() {
	$modalForm.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
        	"phone": {
                validators: {
                    notEmpty: {
                        message: '请填写手机'
                    },
                    regexp: {
                        regexp: /^1\d{10}$/,
                        message: '请输入有效的手机'
                    }
                }
            },
	    	  "email": {
	          	validators: {
	                  notEmpty: {
	                      message: '请填写邮箱'
	                  },
	                  regexp: {
	                      regexp: /^(?=\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$).{0,30}$/,
	                      message: '输入的不是一个有效的邮箱'
	                  }
	              }
	          }
        }
    });
}