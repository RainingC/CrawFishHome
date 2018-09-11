$(function () {
    var arr = ["办公效率", "职场发展", "职业岗位", "人工智能", "IT&互联网", "语言留学", "职场之外"];
    for(var i=0; i<arr.length; i++){
        // 课程显示
        $.ajax({
            url: "/ShowAllCourse",
            method: "post",
            data: {
                "two_name": arr[i]
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

    // 动态替换“首页”后的导航标识
    $(".nav_flow>li").click(function () {
        var $nav_li = $(this).text();
        $(".head_a").text($nav_li);
    })
    
    // 点击课程块 跳转详情页面
    $("body").delegate(".class", "click", function () {
        console.log($(this).children("div").eq(5).attr('id'));
    })

    // 创建节点 -- 课程块
    function createCourse(obj) {
        var $course = $('<a href="/goods.html?booksId='+obj.course_id+'" target="_self">\n' +
            '            <div class="class">\n' +
            '                <div class="classImg"><img src="'+obj.cover+'" width="223"></div>\n' +
            '                <div class="classTit">'+obj.course_name+'</div>\n' +
            '                <div class="classTea">'+obj.company+'</div>\n' +
            '                <div class="classEval">'+obj.page_view+'人观看</div>\n' +
            '                <div class="classPrice">￥'+obj.price+'</div>\n' +
            '                <div id="'+obj.course_id+'"></div>\n' +
            '            </div>\n' +
            '        </a>');
        return $course;
    }

})
