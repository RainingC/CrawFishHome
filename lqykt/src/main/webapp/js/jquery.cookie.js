;(function ($, window) {
    // 添加工具方法
    $.extend({
        addCookie: function (key, value, day, path, domain) {
            // 获取当前网页路径最后一个斜杠位置
            var index = window.location.pathname.lastIndexOf("/");
            // 截取路径
            var currentPath = window.location.pathname.slice(0, index);
            // 1. 设置默认保存路径 -- 如果传入path则使用传入，否则使用默认
            path = path || currentPath;
            // 2. 设置默认保存domain
            // 获取当前网页的domain
            var currentDomain = document.domain;
            domain =domain || currentDomain;
            // 3. 设置过期时间
            if(!day){
                document.cookie = key+"="+value+";path="+path+";domain="+domain+";";
            }else{
                var date = new Date();
                date.setDate(date.getDate() + day);
                document.cookie = key+"="+value+";path="+path+";domain="+domain+";" +
                    "expires="+date.toGMTString()+";";
            }
        },

        getCookie: function (key) {
            var res = document.cookie.split(";");
            for(var i=0; i<res.length; i++){
                var temp = res[i].split("=");
                if(temp[0].trim() === key){
                    return temp[1];
                }
            }
        },

        delCookie: function (key, path) {
            addCookie(key, getCookie(key), -1, path);
        }
    });
})(jQuery, window);