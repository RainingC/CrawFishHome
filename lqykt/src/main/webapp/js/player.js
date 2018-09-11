function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
//接收URL中的参数booksId
var id = getUrlParam('period_Id');
console.log('id:'+id);

$(function () {
    ajax({
        url:"/PlareyServlet",
        type:"post",
        data:{"id":id},
        dataType:"json",
        success:function (result) {
            var node = '        <source src="'+result[0].video_address+'" type="video/mp4">\n' +
                '    <source src="'+result[0].video_address+'" type="video/webm">\n' +
                '  <source src="'+result[0].video_address+'" type="video/ogg">';
            $("#my-video").append(node);
        }

    })
})