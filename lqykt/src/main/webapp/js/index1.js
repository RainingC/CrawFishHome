$(function () {
    chenginput();
    chenginput2();
    chenginput3();
    formopen();
    logins();
    form2();
    denglu();
    cancel();

    //获取cookie字符串
    var strCookie = document.cookie;
    //将多cookie切割为多个名/值对
    var arrCookie = strCookie.split("; ");
    var user_name;
    var user_pic;
    //遍历cookie数组，处理每个cookie对
    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        //找到名称为userId的cookie，并返回它的值
        if ("user_name" == arr[0]) {
            user_name = arr[1];
        }
        if ("user_pic" == arr[0]) {
            user_pic = arr[1];
        }
    }

    $("#yidenglu").hide();
    if (user_name!=null){
        $("#weidenglu").hide();
        $("#yidenglu").text(user_name);
        $("#yidenglu").attr("title",user_name);
        $("#yidenglu").show();
        $("#touxiang").children().attr("src",user_pic)
    }else {
        $("#news").attr("href","#")
        $("#news").click(function () {
            layer.msg("请先登录！！")
        });
        $("#wdxx").attr("href","#")
        $("#wdxx").click(function () {
            layer.msg("请先登录！！")
        });
        $("#gwc").attr("href","#")
        $("#gwc").click(function () {
            layer.msg("请先登录！！")
        })
    }
})
function chenginput() {
    $("input[name='phone']").focus(function () {
        $(".regedit-user").css("border","1px solid #49AF4F");
    });
    $("input[name='phone']").blur(function () {
        $(".regedit-user").css("border","1px solid lavender");
    })
}
function chenginput2() {
    $("input[name='pwd']").focus(function () {
        $(".regedit-user1").css("border","1px solid #49AF4F")
    });
    $("input[name='pwd']").blur(function () {
        $(".regedit-user1").css("border","1px solid lavender");
    })
}
function chenginput3() {
    $("input[name='yanzheng']").focus(function () {
        $(".regedit_yanzheng").css("border","1px solid #49AF4F");
    });
    $("input[name='yanzheng']").blur(function () {
        $(".regedit_yanzheng").css("border","1px solid lavender");
    })
}
//单击登录弹出表单
function formopen() {
    $("span[name='login']").click(function () {
        layer.open(
            {
                type:2,
                closeBtn:false,
                title:false,
                area:['441px','457px'],
                shadeClose:true,
                content:['login.html','no'],
            }
        )
    });
}
//单击小标题使用短信验证登录弹出短信验证表单
function form2() {
  $("span[name='ideas']").click(function () {
      layer.open(
          {
              type:2,
              closeBtn:false,
              title:false,
              area:['441px','620px'],
              shadeClose:true,
              content:['login1.html','no']
          }
      )
  })
}
//点击去登录返回登录界面
function logins() {
  $("span[name='regedits']").click(function () {
      layer.open(
          {
              type:2,
              closeBtn:false,
              title:false,
              area:['441px','457px'],
              shadeClose:true,
              content:['index.html','no'],
          }
      );
  })
}
//点击注销
function cancel() {
    $("#calcel").click(function () {
        var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
        if (keys) {
            for (var i=keys.length; i--;)
                document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString();
            layer.msg("注销成功！")
            $("#weidenglu").text('登录/注册');
            $("#weidenglu").attr("title",'登录/注册');
            setTimeout(function(){window.location.reload();},2000);
        }
    })
}
//登录状态设置
function denglu() {
    $("input[value='登录']").click(function () {
        $.ajax(
            {
                url:"/CheckUser",
                type:"post",
                data:{"phone":$("input[name='phone']").val(),"pwd":$("input[name='pwd']").val()},
                dataType:"json",
                success:function (result) {
                    if(result.length>0) {
                        layer.msg('欢迎进入蓝桥云课堂',{time:2000});
                        var pho=result[0].user_phone;
                        document.cookie="user_phone="+pho;
                        document.cookie="user_id="+result[0].user_id;
                        var name = result[0].user_name;
                        document.cookie="user_name="+result[0].user_name;
                        var time=new Date();
                        time.setTime(time.getDate()+1);
                        document.cookie="expires="+time.toGMTString();
                        var photo = result[0].user_picaddress;
                        document.cookie="user_pic="+photo;

                        setTimeout(function(){window.location.reload();},2000);
                    }
                    else{
                        layer.msg('登录失败',{time:1000});
                    }
                }
            }
        )
    })
}