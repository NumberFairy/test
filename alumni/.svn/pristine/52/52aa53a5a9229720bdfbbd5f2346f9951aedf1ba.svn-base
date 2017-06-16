$(function() {
    //年份
    $('.form_year').datetimepicker({
        format: 'yyyy',
        language: 'zh-CN',
        autoclose: true,
        startView: 4,
        minView: 4,
        forceParse: false
    }).on('changeDate', function(ev) {
        $(this).trigger("blur");
    });
    
    //年-月
    $('.form_month').datetimepicker({
        format: 'yyyy-mm',
        language: 'zh-CN',
        autoclose: true,
        startView: 3,
        minView: 3,
        forceParse: false,
        todayBtn: true
    }).on('changeDate', function(ev) {
        $(this).trigger("blur");
    });

    //年-月-日
    $('.form_date').datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        autoclose: true,
        startView: 2,
        minView: 2,
        forceParse: false,
        todayBtn: true
    }).on('changeDate', function(ev) {
        $(this).trigger("blur");
    });

    //年-月-日-时-分-秒
    $('.form_time').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:00',
        language: 'zh-CN',
        showMeridian: true,
        autoclose: true,
        use24hours: true,
        todayBtn: true
    }).on('changeDate', function(ev) {
        $(this).trigger("blur");
    });
});
