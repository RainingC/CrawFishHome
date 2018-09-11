

var num=1;
var max=0;
//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
//接收URL中的参数booksId
var id = getUrlParam('booksId');
console.log('id:'+id);

$(function(){
    //获取cookie字符串
    var strCookie=document.cookie;
    //将多cookie切割为多个名/值对
    var arrCookie=strCookie.split("; ");
    var user_id;
    var user_name;
    //遍历cookie数组，处理每个cookie对
    for(var i=0;i<arrCookie.length;i++){
        var arr=arrCookie[i].split("=");
        //找到名称为userId的cookie，并返回它的值
        if("user_id"==arr[0]){
            user_id=arr[1];
        }
        if("user_name"==arr[0]){
            user_name=arr[1];
        }
    }

$("#1").click(function () {
    Show();
})
    Show();
    Show_newContent()

// 详情展示
    $.ajax({
        url:'/ShowCourseServlet',
        type:'post',
        data:{"course_id":id},
        dataType:'json',
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                var node = $('<div class="col-lg-12" id="introduce" style="background-color: white;height: 290px; margin-top: 30px">\n' +
                    '                <div id="introduce1"><img src="'+result[i].cover+'" alt="" style="position: relative; left: 5px;top: 20px"></div>\n' +
                    '                <div id="introduce2"><h2 id="coursename">'+result[i].course_name+'</h2></div>\n' +
                    '                <div>\n' +
                    // '                    <a class="glyphicon glyphicon-star-empty" style="float: right;margin-top: 30px;font-size: 20px"></a>\n' +
                    // '                    <a class="glyphicon glyphicon-share" style="float: right;margin-top: 30px; margin-right: 10px;font-size: 20px"></a>\n' +
                    '                </div>\n' +
                    '                <div style="left: -295px" id="introduce3"><p>⭐️⭐️⭐️⭐️⭐️授课：'+result[i].company+'</p></div>\n' +
                    '                <div style="left: -295px" id="introduce4"><h3>￥&nbsp'+result[i].price+'</h3></div>\n' +
                    '                <a href="player.html" onclick="return false"><span id="introduce5">立即播放</span></a>\n' +
                    '                <a href="" onclick="return false"><div id="introduce6"><img  id="shopping" src="images/shopping.png" alt=""></div></a>\n' +
                    '            </div>')
                var node1 = $('<div class="photo">\n' +
                    '                <div id="img" style="margin-left: 35px"><div class="coursedeid" id="'+result[i].course_id+'"></div>\n' +
                    '                <img style="margin-top: 15px" src="'+result[i].synopsis+'">\n' +
                    '                </div>\n' +
                    '                </div>')
                $("#qwe").append(node);
                $("#ios").append(node1);
                if(result[i].price==0){
                    $("#shopping").remove();
                }
            }
        }
    });

    //加入购物车
    $("body").on("click","#shopping",function () {
        $.ajax({
            url: "/InsertUserCrouseId",
            type: "post",
            data:{
                //商品id
                "courseId":$(".coursedeid").attr("id"),
                //用户id
                "userId":user_id,
            },
            dataType: "text",
            success: function (ret) {
                if (ret == "0"){
                    layui.use('layer', function() {
                        var layer = layui.layer;
                        layer.msg('存在此课程', {time: 2000});
                    })
                }else {
                    layui.use('layer', function() {
                        var layer = layui.layer;
                        layer.msg('添加课程成功', {time: 2000});
                    })
                }
            }
        })
    })
//课时展示
    $.ajax({
        type:'post',
        url:'/ShowPeriodServlet',
        data:{course_id:id},
        dataType:'json',
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                var node = $('<div id="section">\n' +
                    '                        <span id="f-fl f-thide ks">'+result[i].period_id+'</span>\n' +
                    '                        <a href="player.html?period_Id='+result[i].id+'" target="_blank"><span id="f-fl f-thide ksname">'+result[i].period_name+'</span></a>\n' +
                    '                        </div>')
                $("#section_list").append(node);
            }
            $("#section").hover(function(){$(this).fadeOut(100);$(this).fadeIn(50);});

        }

    });

    $('input[value="下一页"]').click(function () {
        num<Math.ceil(max/7)?++num:num;
        Show();
    })
    $('input[value="上一页"]').click(function () {
        num>1?--num:num;
        Show();
    })
//发表评论
    $("#submitcomment").click(function () {
        $.ajax({
            url:'/InsertCommentsServlet',
            type:'post',
            dataType : 'text',
            data:{
                "user_name":user_name,
                // $("#username").text(),
                "course_id":id,
                // $("#courseid").text(),
                "content":$("textarea[name='msg']").val(),
            },
            success:function (ret) {
                if (ret == "1") {
                    layer.msg("发表成功",{time:1000});
                    Show();
                    Show_newContent();
                    $("textarea[name='msg']").val("");
                }else {
                    alert("评论失败")
                }
            }
        })
    })

});
//评论展示
function Show() {
    $.ajax({
        type:'post',
        url:'/ShowCommentsServlet',
        data:{course_id:id,'num':num},
        dataType:'json',
        success:function (result) {
            $('.comment').remove();
            for (var i = 0; i< result.length-1; i++){
                var node='                        <div class="comment">\n' +
                    '                            <div class="imgdiv"><img class="imgcss"  src="images/small.jpg"/></div>\n' +
                    '                            <div class="conmment_details">\n' +
                    '                                <span class="comment_name">'+result[i].user_name+'</span>  &nbsp&nbsp&nbsp&nbsp<span>'+result[i].content_time+'</span>\n' +
                    '                                <div class="comment_content" > '+result[i].content+'</div>\n' +
                    '                            </div>\n' +
                    '                            <hr>\n' +
                    '                        </div>';
                $("#comment_list").append(node);
            }
            $(".comment").hover(function(){$(this).fadeOut(100);$(this).fadeIn(50);});
            max = result[result.length-1];
        }
    });
}
//右侧评论展示
function Show_newContent() {
    $.ajax({
        type:'post',
        url:'/ShowCommentsServlet',
        data:{course_id:id,'num':1},
        dataType:'json',
        success:function (result) {
            $('.new').remove();
            max = 1;
            for (var i = 0; i< 5; i++){
                var node1='                        <div class="new">\n' +
                    '                            <div class="imgdiv"><img class="imgcss"  src="images/aaa.jpg"/></div>\n' +
                    '                            <div class="conmment_details">\n' +
                    '                                <span class="comment_name">'+result[i].user_name+'</span>  &nbsp&nbsp&nbsp&nbsp<span>'+result[i].content_time+'</span>\n' +
                    '                                <div class="comment_content" > '+result[i].content+'</div>\n' +
                    '                            </div>\n' +
                    '                            <hr>\n' +
                    '                        </div>';
                $("#new_comment_list").append(node1);

            }
        }
    });
    $(".comment").hover()
}








