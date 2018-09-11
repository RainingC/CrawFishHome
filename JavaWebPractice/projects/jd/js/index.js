
$(function () {
    setTimeout("changeImg()",3000);//轮播图
    menushow();//侧边栏展示
    showTime()
    setTimeout("showTimeFir()",1000);
    $("#search-show").hide();
    //搜索提示功能
    $("#search1").keyup(function () {
        $.ajax({
            url:"http://10.96.119.78:8888/ajax/KeyWordServlet?key="+$(this).val(),
            type:"get",
            dataType:"json",
            success:function (result){
                //alert(result)
                $("#search-show").html("");
                for(var i=0;i<result.length;i++){
                    $("#search-show").html($("#search-show").html()+result[i].keyword +"<br>");
                }
                $("#search-show").show();
            }
        })
    })
    $("#search1").blur(function () {
        $("#search-show").hide();
    })
});




//-中央轮播图函数
var i = 0;

function changeImg() {
    i++;
    $("#dazhaxie").attr("src","images/dazhaxie"+i+".jpg")
    if (i==4){
        i=0;
    }
    setTimeout("changeImg()",3000)
}


//-侧边栏展示函数
function menushow() {
    $("#a01 div").hide();
    $("#choice li").hover(function () {
        var index = $(this).index();
        $("#yincang"+index).show();
    },function(){
        var index = $(this).index();
        $("#yincang"+index).hide();
    });


    $("#a01 div").hover(function () {
        $(this).show();
    },function () {
        $(this).hide();
    })
}

//秒杀倒计时
function showTimeFir() {
    var now = new Date();
    var nowhour = now.getHours();
    var nowmin = now.getMinutes();
    var nowsec = now.getSeconds();
    if (nowhour%2==0){
        var h = "01";
        var m = 60-nowmin;
        var s = 60-nowsec;
    } else {
        var h = "00";
        var m = 60-nowmin;
        var s = 60-nowsec;
    }
    $("#shijiann").replaceWith('                <div id="shijiann">\n' +
        '                    <div class="sj" id="sj1">\n' +
        '                        <span class="sjj" id="sjj1">'+h+'</span>\n' +
        '                    </div>\n' +
        '                    <div class="sj" id="sj2">\n' +
        '                        <span class="sjj" id="sjj2">'+m+'</span>\n' +
        '                    </div>\n' +
        '                    <div class="sj" id="sj3">\n' +
        '                        <span class="sjj" id="sjj3">'+s+'</span>\n' +
        '                    </div>\n' +
        '                </div>')
    setTimeout("showTimeFir()",1000);
}
function showTime() {
    var now = new Date();
    var nowhour = now.getHours();
    var nowmin = now.getMinutes();
    var nowsec = now.getSeconds();
    if (nowhour%2==0){
        var h = "01";
        var m = 60-nowmin;
        var s = 60-nowsec;
    } else {
        var h = "00";
        var m = 60-nowmin;
        var s = 60-nowsec;
    }
    $("#shijiann").replaceWith('                <div id="shijiann">\n' +
        '                    <div class="sj" id="sj1">\n' +
        '                        <span class="sjj" id="sjj1">'+h+'</span>\n' +
        '                    </div>\n' +
        '                    <div class="sj" id="sj2">\n' +
        '                        <span class="sjj" id="sjj2">'+m+'</span>\n' +
        '                    </div>\n' +
        '                    <div class="sj" id="sj3">\n' +
        '                        <span class="sjj" id="sjj3">'+s+'</span>\n' +
        '                    </div>\n' +
        '                </div>')
}