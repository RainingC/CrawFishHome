//获取cookie字符串
var strCookie=document.cookie;
//将多cookie切割为多个名/值对
var arrCookie=strCookie.split("; ");
var user_id;
//遍历cookie数组，处理每个cookie对
for(var i=0;i<arrCookie.length;i++){
    var arr=arrCookie[i].split("=");
    //找到名称为userId的cookie，并返回它的值
    if("user_id"==arr[0]){
        user_id=arr[1];
        break;
    }
}
// if ($("#weidenglu").text() == "登录/注册") {
//     $(this).attr("href","")
// }else {
//     $(this).attr("href","userMain.html")
// }
$(function () {
    righthide();
    backtotop();
    detailsshow();
    fenxiangshow();
    searchtishi();
    searchinfo();
    newscount();
    scrolls();
    shownewscount();
    searchbut();
    shownewsdialog();
    changenewsstatus();
    $("#header-search").focus(function () {
        $(this).val("")
    }).blur(function () {
        $(this).val("搜索课程...")
    })
function searchinfo(){
    $("#header-search").keyup(function () {
        $.ajax(
            {
                url:"/ShowSearchInfoServlet",
                type:"post",
                data:{"searchinfo":$("#header-search").val()},
                dataType:"json",
                success:function (result) {
                    for(var i=0;i<=5;i++){
                        $("#search-tishi").append('<a href="goods.html?booksId='+result[i].course_id+'" target="_blank" onclick="location.reload()">'+result[i].course_name+'</a>');
                    }
                }
            }
        )
        $("#search-tishi").html("");
        searchbut();
    })
}


})

function searchbut(){
    $.ajax(
        {
            url:"/SearchServlet",
            type:"post",
            data:{"searchinfo1":$("#header-search").val()},
            dataType:"json",
            success:function (result) {
                if (result[0].kind_name == "全部课程") {
                    $("#searchbutton").attr("href","allClass.html?name=全部课程&type=0");
                }else {
                    $("#searchbutton").attr("href","specificClass.html?name=办公效率&type=2&name2=办公软件#");
                }
            }
        }
    )
}

function shownewscount(){
    $.ajax(
        {
            url:"/ShowNewsCountsServlet",
            type:"post",
            data:{"userid":user_id},
            dataType:"text",
            success:function (result) {
                $("#news-count").text(result);
                newscount();
            }
        }
    )

    $.ajax({
        url:"/CartCourseNum",
        type: "post",
        data: {
            "user_id": user_id
        },
        dataType: "text",
        success: function (ret) {
            $("#cart-count").text(ret);
            newscount();
        }
    })
}

function righthide() {
    $("#right-gzh").hide();
    $("#erweima").hide();
    $(".right-float-div:eq(1)").hover(function () {
        $("#right-gzh").fadeIn();
        $(".right-icon:eq(0)").fadeOut();
        $("#erweima").fadeIn();
    })
    $("#right-gzh").mouseout(function () {
        $(this).fadeOut();
        $(".right-icon:eq(0)").fadeIn();
        $("#erweima").fadeOut();
    });

    $(".right-float-div:eq(0)").hover(function () {
        $("#right-jqr").fadeIn();
    })
    $("#right-jqr").mouseout(function () {
        $(this).fadeOut();
    })

    $("#right-hddb").hide();
    $(".right-float-div:eq(2)").hover(function () {
        $("#right-hddb").fadeIn();
        $(".right-icon:eq(1)").fadeOut();
    })
    $("#right-hddb").mouseout(function () {
        $(this).fadeOut();
        $(".right-icon:eq(1)").fadeIn();
    });
}
function backtotop() {
    $("#back_to_top").click(function () {
        $('html,body').animate({scrollTop:0},'middle');
    })
}

function detailsshow() {
    $("#touxiang-details").hide();
    $("#touxiang").hover(function () {
        $("#touxiang-details").fadeIn();
    },function () {
        $("#touxiang-details").hide();
    })

    $("#touxiang-details").hover(function () {
        $(this).show();
    },function () {
        $(this).hide();
    })
}

function fenxiangshow() {
    $("#header-fenxiang").hide();
    $("#header-guide a:eq(2)").hover(function () {
        $("#header-fenxiang").fadeIn();
    },function () {
        $("#header-fenxiang").hide();
    })

    $("#header-fenxiang").hover(function () {
        $(this).show();
    },function () {
        $(this).hide();
    })
}

function searchtishi() {
    $("#search-tishi").hide();
    $("#header-search").keypress(function () {
        $("#search-tishi").show();
    })

    $("#header-search").blur(function () {
        $("#search-tishi").hide();
    })

    $("#search-tishi").hover(function () {
        $(this).show();
    })
}

function newscount(){
    $("#news-count").hide();
    if ($("#news-count").text()!=0){
        $("#news-count").show();
    }

    $("#cart-count").hide();
    if ($("#cart-count").text()!=0){
        $("#cart-count").show();
    }
}
function  scrolls() {
    $("#right-float").hide();
    $(window).scroll(function () {
        $("#right-float").show();
        if ($(document).scrollTop()<=0) {
            $("#right-float").hide();
        }
    })
}
function shownewsdialog(){
    $.ajax(
        {
            url:"/ShowNewsDialogServlet",
            type:"post",
            data:{"userid":user_id},
            dataType:"json",
            success:function (result) {
                if (result[0].news_status==0){
                    layui.use('layer', function() {
                        var layer = layui.layer;
                        layer.open({
                            resize:false,
                            move:false,
                            type: 1,
                            title:'推送',
                            skin: 'layui-layer-demo', //样式类名
                            closeBtn: 1, //不显示关闭按钮
                            area: ['230px', '200px'],
                            offset:'rb',
                            anim: 2,
                            shade:0,
                            time:10000,
                            shadeClose: false, //开启遮罩关闭
                            content: '<div style="width: 160px;height: 120px"><a href="goods.html?booksId='+result[0].course_id+'" id="newsdialog" name="'+result[0].news_id+'" style="font-size: 13px;line-height: 25px;">'+result[0].news_info+'</a></div>'
                        });
                    })
                } 
            }
        }
    )
}

function changenewsstatus() {
    $("body").on("click","#newsdialog",function () {
        $.ajax(
            {
                url:"/ChangeNewsStatusServlet",
                type:"post",
                data:{"newsid":$(this).attr("name")},
                dataType:"text",
                success:function () {
                }
            }
        )

    })
}



layui.use('layer', function(){
    var layer = layui.layer;


    $("#right-jqr").click(function () {
        layer.open({
        type: 1,
        title: false,
        resize:false,
        area: ['450px', '550px'],
        closeBtn: 0,
        shadeClose: true,
        content: '<iframe src="http://wuxiaodong.cn/tuling/" style="width: 450px;height: 550px;"></iframe>',
    })
})

    $("#regedit-body").hide();
    $("#weidenglu").click(function () {
        layer.open({
            type:1,
            closeBtn:false,
            area:['441px','457px'],
            title:false,
            shadeClose:true,
            content:$("#regedit-body"),
        })
        return false;
    })


    // $("#weidenglu").click(function () {
    //     layer.open({
    //         type: 1,
    //         title: false,
    //         resize:false,
    //         area: ['500px', '500px'],
    //         shadeClose: true,
    //         content: '<div style="width: 500px;height: 500px;text-align: center;line-height: 500px">这里是登录界面</div>',
    //     })
    //     return false;
    // })


        // layer.open({
        //     resize:false,
        //     move:false,
        //     type: 1,
        //     title:'推送',
        //     skin: 'layui-layer-demo', //样式类名
        //     closeBtn: 1, //不显示关闭按钮
        //     area: ['200px', '150px'],
        //     offset:'rb',
        //     anim: 2,
        //     shade:0,
        //     time:10000,
        //     shadeClose: false, //开启遮罩关闭
        //     content: '这里是推送内容'
        // });
});

