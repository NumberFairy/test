/**
 * 门户菜单管理--微信轮播图片管理
 *
 * zxguan@wisdombud.com
 * 20170413
 * */


var actionPath = contextPath + "/home-information-release";
var $form = $('#baseInfoForm');
var editor;
var divArray = [];
var $divImg = $('#div-img');
var $divVideo = $('#div-video');
var $divFile = $('#div-file');
$(function(){
	divArray.push($divImg, $divVideo, $divFile);

	findAllMenus();

    editor = buildUeditor('editor_id');

    initValidator();
    $("#btn-submit").click(function() {
        var bv = $form.data('bootstrapValidator');
        bv.validate();
        if (bv.isValid()) {
           multiFormSubmit({
        	   url : actionPath + "!addOrUpdate",
        	   queryParam : $form.serialize()
           });
        }
    });

    uploadFile({
		btnId : "btnImgUpLoad",
		fileId : "imgUpload",
		successCall : function(data, status, a) {
			$('#imgId').val(data.f_id);
    		$('#imgName').val(data.fileName);
		}
    });

    uploadFile({
		btnId : "btnVideoUpLoad",
		fileId : "videoUpload",
		successCall : function(data, status, a) {
			$('#videoId').val(data.f_id);
    		$('#videoName').val(data.fileName);
		}
    });

    uploadFile({
		btnId : "btnFileUpLoad",
		fileId : "fileUpload",
		successCall : function(data, status, a) {
			$('#fileId').val(data.f_id);
    		$('#fileName').val(data.fileName);
		}
    });
});

var menus;
var childMenus = [];
var selectMenus = [];
function findAllMenus() {
	$.ajax({
		url : actionPath + '!findAllMenus',
		type : 'POST',
		dataType : 'JSON',
		data : {id : id}
	}).success(function(data){
		if (data.length > 0) {
			menus = data;
			var h = '';//此处初始化‘’， 是因为会拼到h中，显示在页面上
			$.each(data, function(i, obj) {
				$.each(obj.children, function(j, child) {
					var selected;
					$.each($('#typestr').val().split(','), function(m, checkId){
						if (child.menuId == checkId) {
							h += '<option value="' + child.menuId + '" selected>' + child.name + '</option>';
							selectMenus.push(child);
							selected = true;
						}
					});
					if (!selected) {
						h += '<option value="' + child.menuId + '">' + child.name + '</option>';
					}
					childMenus.push(child);
				});
			});

			$('#select-type').html(h).chosen().change(function(){
				var $selects = $('#div-type .chosen-results .result-selected');
				$.each($selects, function(i, obj) {
					var index = $(obj).data("option-array-index");
					selectMenus.push(childMenus[index]);
				});

				fillDivShowArray();
			});
			fillDivShowArray();
		}
	}).fail(function(data){
	});
}

/**
 * 根据选取的菜单重置showArray数组的值
 * */
function fillDivShowArray() {
	$.each(selectMenus, function(i, obj) {
		showArray[0] = obj.uploadImg == 0 ? showArray[0] : 1;
		showArray[1] = obj.uploadVideo == 0 ? showArray[1] : 1;
		showArray[2] = obj.uploadFile == 0 ? showArray[2] : 1;
	});
	if (selectMenus.length > 0) {
		divShow();
	}
};

/**
 * 根据showArray数组的值，显示div(0:不显示，1:显示)
 * */
var showArray = [0, 0, 0];//imgShow、videoShow、fileShow
function divShow() {
	$.each(showArray, function(o, obj) {
		var $obj = divArray[o];
		return showArray[o] == 0 ? $obj.prop("hidden", true) : $obj.prop("hidden", false);
	});
}

function initValidator() {
    $form.bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        live: 'enabled',
        fields: {
        	"entity.title": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
        	"entity.publisher": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
        	"entity.summary": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
             "entity.isEnable": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            },
             "entity.isTop": {
                trigger: "blur",
                validators: {
                    notEmpty: {
                        message: '请填写'
                    }
                }
            }
        }
    });
}
