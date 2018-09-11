layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test2'
        ,width: '100%' //设置容器宽度
        ,height:'55px'//高度
        ,arrow: 'none' //始终显示箭头
        ,anim: 'fade' //切换动画方式
        ,interval:'5000'//切换时间
        ,indicator:'none'//指示器
    });
});

layui.use('carousel', function(){
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test1'
        ,width: '975px' //设置容器宽度
        ,height:'345px'
        ,anim: 'fade'
        ,arrow: 'hover' //箭头
        ,interval:'3000'//切换时间
    });
});

$(function () {
    $.ajax(
        {
            url:"/ShowBestServlet",
            type:"post",
            dataType:"json",
            success:function (result) {
                $(".body-showinfo-jxhk:eq(0)").children().eq(0).children().attr("src",result[0].cover);
                $(".body-showinfo-jxhk:eq(0)").attr("title",result[0].course_name);
                $(".body-showinfo-jxhk:eq(0)").children("p").text(result[0].course_name);
                $(".body-showinfo-jxhk:eq(0)").children("span").text(result[0].company);
                $(".body-showinfo-jxhk:eq(0)").children("ul").children().eq(0).text(result[0].page_view);
                $(".body-showinfo-jxhk:eq(0)").parent().attr("href","goods.html?booksId="+result[0].course_id);
                $(".body-showinfo-jxhk:eq(1)").children().eq(0).children().attr("src",result[1].cover);
                $(".body-showinfo-jxhk:eq(1)").attr("title",result[1].course_name);
                $(".body-showinfo-jxhk:eq(1)").children("p").text(result[1].course_name);
                $(".body-showinfo-jxhk:eq(1)").children("span").text(result[1].company);
                $(".body-showinfo-jxhk:eq(1)").children("ul").children().eq(0).text(result[1].page_view);
                $(".body-showinfo-jxhk:eq(1)").parent().attr("href","goods.html?booksId="+result[1].course_id);
                $(".body-showinfo-jxhk:eq(2)").children().eq(0).children().attr("src",result[2].cover);
                $(".body-showinfo-jxhk:eq(2)").attr("title",result[2].course_name);
                $(".body-showinfo-jxhk:eq(2)").children("p").text(result[2].course_name);
                $(".body-showinfo-jxhk:eq(2)").children("span").text(result[2].company);
                $(".body-showinfo-jxhk:eq(2)").children("ul").children().eq(0).text(result[2].page_view);
                $(".body-showinfo-jxhk:eq(2)").parent().attr("href","goods.html?booksId="+result[2].course_id);
                $(".body-showinfo-jxhk:eq(3)").children().eq(0).children().attr("src",result[3].cover);
                $(".body-showinfo-jxhk:eq(3)").attr("title",result[3].course_name);
                $(".body-showinfo-jxhk:eq(3)").children("p").text(result[3].course_name);
                $(".body-showinfo-jxhk:eq(3)").children("span").text(result[3].company);
                $(".body-showinfo-jxhk:eq(3)").children("ul").children().eq(0).text(result[3].page_view);
                $(".body-showinfo-jxhk:eq(3)").parent().attr("href","goods.html?booksId="+result[3].course_id);
                $(".body-showinfo-jxhk:eq(4)").children().eq(0).children().attr("src",result[4].cover);
                $(".body-showinfo-jxhk:eq(4)").attr("title",result[4].course_name);
                $(".body-showinfo-jxhk:eq(4)").children("p").text(result[4].course_name);
                $(".body-showinfo-jxhk:eq(4)").children("span").text(result[4].company);
                $(".body-showinfo-jxhk:eq(4)").children("ul").children().eq(0).text(result[4].page_view);
                $(".body-showinfo-jxhk:eq(4)").parent().attr("href","goods.html?booksId="+result[4].course_id);
            }
        }
    )

    $.ajax(
        {
            url: "/ShowFreeServlet",
            type: "post",
            dataType: "json",
            success: function (result) {
                $(".body-showinfo-mfkc:eq(0)").children().eq(0).children().attr("src",result[0].cover);
                $(".body-showinfo-mfkc:eq(0)").attr("title",result[0].course_name);
                $(".body-showinfo-mfkc:eq(0)").children("p").text(result[0].course_name);
                $(".body-showinfo-mfkc:eq(0)").children("span").text(result[0].company);
                $(".body-showinfo-mfkc:eq(0)").children("ul").children().eq(0).text(result[0].page_view);
                $(".body-showinfo-mfkc:eq(0)").parent().attr("href","goods.html?booksId="+result[0].course_id);
                $(".body-showinfo-mfkc:eq(1)").children().eq(0).children().attr("src",result[1].cover);
                $(".body-showinfo-mfkc:eq(1)").attr("title",result[1].course_name);
                $(".body-showinfo-mfkc:eq(1)").children("p").text(result[1].course_name);
                $(".body-showinfo-mfkc:eq(1)").children("span").text(result[1].company);
                $(".body-showinfo-mfkc:eq(1)").children("ul").children().eq(0).text(result[1].page_view);
                $(".body-showinfo-mfkc:eq(1)").parent().attr("href","goods.html?booksId="+result[1].course_id);
                $(".body-showinfo-mfkc:eq(2)").children().eq(0).children().attr("src",result[2].cover);
                $(".body-showinfo-mfkc:eq(2)").attr("title",result[2].course_name);
                $(".body-showinfo-mfkc:eq(2)").children("p").text(result[2].course_name);
                $(".body-showinfo-mfkc:eq(2)").children("span").text(result[2].company);
                $(".body-showinfo-mfkc:eq(2)").children("ul").children().eq(0).text(result[2].page_view);
                $(".body-showinfo-mfkc:eq(2)").parent().attr("href","goods.html?booksId="+result[2].course_id);
                $(".body-showinfo-mfkc:eq(3)").children().eq(0).children().attr("src",result[3].cover);
                $(".body-showinfo-mfkc:eq(3)").attr("title",result[3].course_name);
                $(".body-showinfo-mfkc:eq(3)").children("p").text(result[3].course_name);
                $(".body-showinfo-mfkc:eq(3)").children("span").text(result[3].company);
                $(".body-showinfo-mfkc:eq(3)").children("ul").children().eq(0).text(result[3].page_view);
                $(".body-showinfo-mfkc:eq(3)").parent().attr("href","goods.html?booksId="+result[3].course_id);
                $(".body-showinfo-mfkc:eq(4)").children().eq(0).children().attr("src",result[4].cover);
                $(".body-showinfo-mfkc:eq(4)").attr("title",result[4].course_name);
                $(".body-showinfo-mfkc:eq(4)").children("p").text(result[4].course_name);
                $(".body-showinfo-mfkc:eq(4)").children("span").text(result[4].company);
                $(".body-showinfo-mfkc:eq(4)").children("ul").children().eq(0).text(result[4].page_view);
                $(".body-showinfo-mfkc:eq(4)").parent().attr("href","goods.html?booksId="+result[4].course_id);
            }
        }
    )

    $.ajax(
        {
            url: "/ShowNewServlet",
            type: "post",
            dataType: "json",
            success: function (result) {
                $(".body-showinfo-zxkc:eq(0)").children().eq(0).children().attr("src",result[0].cover);
                $(".body-showinfo-zxkc:eq(0)").attr("title",result[0].course_name);
                $(".body-showinfo-zxkc:eq(0)").children("p").text(result[0].course_name);
                $(".body-showinfo-zxkc:eq(0)").children("span").text(result[0].company);
                $(".body-showinfo-zxkc:eq(0)").children("ul").children().eq(0).text(result[0].page_view);
                $(".body-showinfo-zxkc:eq(0)").parent().attr("href","goods.html?booksId="+result[0].course_id);
                $(".body-showinfo-zxkc:eq(1)").children().eq(0).children().attr("src",result[1].cover);
                $(".body-showinfo-zxkc:eq(1)").attr("title",result[1].course_name);
                $(".body-showinfo-zxkc:eq(1)").children("p").text(result[1].course_name);
                $(".body-showinfo-zxkc:eq(1)").children("span").text(result[1].company);
                $(".body-showinfo-zxkc:eq(1)").children("ul").children().eq(0).text(result[1].page_view);
                $(".body-showinfo-zxkc:eq(1)").parent().attr("href","goods.html?booksId="+result[1].course_id);
                $(".body-showinfo-zxkc:eq(2)").children().eq(0).children().attr("src",result[2].cover);
                $(".body-showinfo-zxkc:eq(2)").attr("title",result[2].course_name);
                $(".body-showinfo-zxkc:eq(2)").children("p").text(result[2].course_name);
                $(".body-showinfo-zxkc:eq(2)").children("span").text(result[2].company);
                $(".body-showinfo-zxkc:eq(2)").children("ul").children().eq(0).text(result[2].page_view);
                $(".body-showinfo-zxkc:eq(2)").parent().attr("href","goods.html?booksId="+result[2].course_id);
                $(".body-showinfo-zxkc:eq(3)").children().eq(0).children().attr("src",result[3].cover);
                $(".body-showinfo-zxkc:eq(3)").attr("title",result[3].course_name);
                $(".body-showinfo-zxkc:eq(3)").children("p").text(result[3].course_name);
                $(".body-showinfo-zxkc:eq(3)").children("span").text(result[3].company);
                $(".body-showinfo-zxkc:eq(3)").children("ul").children().eq(0).text(result[3].page_view);
                $(".body-showinfo-zxkc:eq(3)").parent().attr("href","goods.html?booksId="+result[3].course_id);
                $(".body-showinfo-zxkc:eq(4)").children().eq(0).children().attr("src",result[4].cover);
                $(".body-showinfo-zxkc:eq(4)").attr("title",result[4].course_name);
                $(".body-showinfo-zxkc:eq(4)").children("p").text(result[4].course_name);
                $(".body-showinfo-zxkc:eq(4)").children("span").text(result[4].company);
                $(".body-showinfo-zxkc:eq(4)").children("ul").children().eq(0).text(result[4].page_view);
                $(".body-showinfo-zxkc:eq(4)").parent().attr("href","goods.html?booksId="+result[4].course_id);
            }
        }
    )
    menuhide();
    imgfd();
    menushow1();
    menushow2();
    menushow3();
    menushow5();
    menushow4();
    menushow6();
    menushow7();
    menuhove();
})

function menuhide() {
    $(".menu").hover(function () {
        $(this).css("background-color","white")
        $(this).children().children().css("color","black")
    },function () {
        $(this).css("background-color","rgba(18,21,44,0.9)")
        $(this).children().children().css("color","white")
    })
}

function imgfd() {
    $(".body-show-details a").hover(function () {
        $(this).children().children("div:eq(0)").children().animate({width:"110%",height:"110%",marginTop:"-5%",marginLeft:"-5%"},"fast")
    },function () {
        $(this).children().children("div:eq(0)").children().animate({width:"100%",height:"100%",marginTop:0,marginLeft:0},"fast")
    })
}

function menushow1() {
    $("#menuhidden1").hide();
    $(".menu:eq(0)").hover(function () {
        $("#menuhidden1").fadeIn();
    },function () {
        $("#menuhidden1").hide();
    })
}
function menushow2() {
    $("#menuhidden2").hide();
    $(".menu:eq(1)").hover(function () {
        $("#menuhidden2").fadeIn();
    },function () {
        $("#menuhidden2").hide();
    })
}
function menushow3() {
    $("#menuhidden3").hide();
    $(".menu:eq(2)").hover(function () {
        $("#menuhidden3").fadeIn();
    },function () {
        $("#menuhidden3").hide();
    })
}
function menushow4() {
    $("#menuhidden4").hide();
    $(".menu:eq(3)").hover(function () {
        $("#menuhidden4").fadeIn();
    },function () {
        $("#menuhidden4").hide();
    })
}
function menushow5() {
    $("#menuhidden5").hide();
    $(".menu:eq(4)").hover(function () {
        $("#menuhidden5").fadeIn();
    },function () {
        $("#menuhidden5").hide();
    })
}
function menushow6() {
    $("#menuhidden6").hide();
    $(".menu:eq(5)").hover(function () {
        $("#menuhidden6").fadeIn();
    },function () {
        $("#menuhidden6").hide();
    })
}
function menushow7() {
    $("#menuhidden7").hide();
    $(".menu:eq(6)").hover(function () {
        $("#menuhidden7").fadeIn();
    },function () {
        $("#menuhidden7").hide();
    })
}

function menuhove() {
    $(".menuhidden").hover(function () {
        $(this).show();
    },function () {
        $(this).hide();
    })
}


