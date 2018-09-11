$(function () {
    // 每页展示课程数
    var pageSize = 5;
    $.addCookie("pageBegin", 1);
    
    // 首页后的一级节点
    var li_name = UrlParm.parm('name');
    var type = UrlParm.parm('type');
    var name2= UrlParm.parm('name2')
    var name3 = UrlParm.parm('name3')
    console.log(type);
    console.log(li_name);

    $(".arrow_next").text(li_name);

    // 设置二级节点
    $.ajax({
        url: "/ShowKind",
        method: "post",
        data: {
            "name": li_name
        },
        dataType: "json",
        success: function (list) {
            $.each(list, function (key, value) {
                var $li = createFuLi(value.kind_name);
                $(".nav_flow").append($li);

                // 设置三级标题
                ajax_three(value.kind_name);
                
                // 获取课程信息
                ajax_ShowCourse(value.kind_name, "/ShowCourse", 1, 1);
            })
        },
        error: function (xml) {
            console.log(xml);
        }
    })

    // 转跳首页
    $(".head_home").click(function () {
        window.location.href="allClass.html";
    })

    // 设置二级节点
    $("ul").on("click",".flow_li",  function () {
        console.log("fdf");
        var $nav_li = $(this).text();
        $(".arrow_next").text($nav_li);
        // 设置节点颜色
        // 移除所有类名
        $(this).parent().children("li").removeClass("nav_flow_li");
        // 添加类名
        $(this).addClass("nav_flow_li");

        // 设置动态三级标签
        // 移除所有三级节点
        $(".nav_li_all").siblings("li").remove();
        // 设置三级节点
        ajax_three($nav_li);

        // 删除所有课程信息
        $(".classAll").children().remove();
        // 获取课程信息
        ajax_ShowCourse($nav_li, "/ShowCourse", 1, 1);

    })
    // 设置三级节点 点击动画
    $("ul").on("click",".specific_li", function () {
        // 移除所有类名
        $(this).parent().children("li").removeClass("nav_li");
        // 添加类名
        $(this).addClass("nav_li");
        // 获取名字
        var name = $(this).text();

        // 保存课程名
        $.addCookie("courseName", name);
        // 保存网址
        $.addCookie("str_url", "/ShowSignleCourse");
        
        // 删除所有课程信息
        $(".classAll").children().remove();
        // 获取课程信息
        ajax_ShowCourse(name, "/ShowSignleCourse",
            $.getCookie("pageBegin"), pageSize);

    })

    if(type == 2){
        $("ul .flow_li").triggerHandler("click");
        console.log(name2);
    }else if(type == 3){
        $(".name2").trigger("click");
        $(".name3").trigger("click");
    }

    // 分页
    // 点击上一页
    $(".page_up").click(function () {
        // 取页码
        var num = $.getCookie("pageBegin");
        if(num>1){
            --num;
        }
        // 存页码
        $.addCookie("pageBegin", num);

        // 删除所有课程信息
        $(".classAll").children().remove();
        // 获取课程信息
        ajax_ShowCourse($.getCookie("courseName"), $.getCookie("str_url"),
            $.getCookie("pageBegin"), pageSize);
    })
    // 点击下一页
    $(".page_down").click(function () {
        // 取页码
        var num = $.getCookie("pageBegin");
        ++num;
        // 存页码
        $.addCookie("pageBegin", num);

        // 删除所有课程信息
        $(".classAll").children().remove();
        // 获取课程信息
        ajax_ShowCourse($.getCookie("courseName"), $.getCookie("str_url"),
            $.getCookie("pageBegin"), pageSize);
    })

    // 设置三级节点
    function ajax_three(name) {
        $.ajax({
            url: "/ShowKind",
            method: "post",
            data: {
                "name": name
            },
            dataType: "json",
            success: function (list) {
                $.each(list, function (key, value) {
                    var $li = createLi(value.kind_name);
                    $(".nav_specific").append($li);
                })
            },
            error: function (xml) {
                console.log(xml);
            }
        })
    }

    // 创建二级节点
    function createFuLi(obj) {
        var $li = $('<li class="flow_li"><a href="#" target="_self">'+obj+'</a></li>');
        return $li;
    }

    // 创建三级节点 -- 导航栏属性
    function createLi(obj) {
        var $li = $('<li class="nav_xie">/</li>\n' +
            '        <li class="specific_li"><a href="#" target="_self">'+obj+'</a></li>');
        return $li;
    }

    // 显示课程
    function ajax_ShowCourse(name, str_url, pageBegin, pageSize) {
        $.ajax({
            url: str_url,
            method: "post",
            data: {
                "two_name": name,
                "pageBegin": pageBegin,
                "pageSize": pageSize
            },
            dataType: "json",
            success: function (list) {
                $.each(list, function (key, value) {
                    var $course = createCourse(value);
                    $(".classAll").append($course);
                })
            },
            error: function (xml) {
                console.log(xml);
            }
        })
    }

    // 创建节点 -- 课程块
    function createCourse(obj) {
        var $course = $('<a href="/goods.html?booksId='+obj.course_id+'" target="_self">\n' +
            '            <div class="class">\n' +
            '                <div class="classImg"><img src="'+obj.cover+'" width="223"></div>\n' +
            '                <div class="classTit">'+obj.course_name+'</div>\n' +
            '                <div class="classTea">'+obj.company+'</div>\n' +
            '                <div class="classEval">'+obj.page_view+'人学习</div>\n' +
            '                <div class="classPrice">￥'+obj.price+'</div>\n' +
            '                <div id="'+obj.course_id+'"></div>\n' +
            '            </div>\n' +
            '        </a>');
        return $course;
    }
})