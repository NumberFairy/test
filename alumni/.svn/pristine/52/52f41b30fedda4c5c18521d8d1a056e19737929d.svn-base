!(function($) {
    //此注释代码与下面方法作用相同
    // var queryParams = $("#searchForm").serializeArray();
    // var otherParams={};
    // //otherParams: queryParams无效 因为queryParams为list结构为 0:{name:11,value:22},1:{name:33,value:44}...
    // //for循环,把list变为array,结构为 11:22,33:44....
    // for(var i=0;i<queryParams.length;i++){
    //     otherParams[queryParams[i].name]=queryParams[i].value;
    // }
    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    //把array转为listName[i].key=value&listName[i].key=value形式字符串
    //array js array数组
    //listName 后台接收的list名称 如entity.list 或 userList
    $.serializeArray = function(array,listName) {
        var text="";
        for (var i = 0; i < array.length; i++) {
            for(key in array[i]){
                var subObj = array[i][key];
                if (typeof subObj=='object') {
                    for (o in subObj) {
                        text += listName + "[" + i + "]." + key + "." + o + "=" + subObj[o] + "&";
                    }
                } else {
                    text+=listName+"["+i+"]."+key+"="+array[i][key]+"&";
                }
            }
        }
        return text.substring(0,text.length - 1);
    }
    //序列化拼接多个gabTable的store
    // var tableObj={"table-box2":"entity.basePartyPeronnelFamilys",
    //               "table-box3":"entity.basePartyPersonnelResumes"};
    $.serializeGabTable = function(obj) {
        var reText='';
        for(t in obj){
            var store = $("#"+t).gabTable("getStore");
            // var text="";
            // for (var i = 0; i < store.data.length; i++) {
            //     for(key in store.data[i]){
            //         text+=obj[t]+"["+i+"]."+key+"="+store.data[i][key]+"&";
            //     }
            // }
            // text = text.substring(0,text.length - 1);
            var text=$.serializeArray(store.data,obj[t]);
            reText+=text+"&";
        }
        return reText.substring(0,reText.length - 1);

    }
})(window.jQuery);