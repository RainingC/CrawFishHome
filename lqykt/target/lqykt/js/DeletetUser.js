$(function () {
    selectAll();
    $("body").delegate(".delBtn1", "click", function () {
        var id = $(this).parent().parent().children("td").eq(0).text();
        console.log(id);
        $.ajax(
            {
                url:"/DelServlet",
                type:"post",
                data:{
                    "user_id": id
                },
                dataType:"text",
                success:function (result) {
                    if (result == 1){
                        layer.msg("删除成功！",{time:1000})
                        setTimeout(function(){window.location.reload();},1000);
                    } else {
                        layer.msg("删除失败！！")
                    }
                }
            }
        )
    })

})
function selectAll() {
        $.ajax(
            {
                url:"/ShowAllServlet",
                type:"post",
                dataType:"json",
                success:function (result) {
                    console.log(result);
                    if(result.length>0)
                    {
                        for(var i=0;i<result.length;i++)
                        {
                            var $s = $('<tr>\n' +
                                '                     <td class="tr_id">'+result[i].user_id+'</td>\n' +
                                '                     <td>'+result[i].user_name+'</td>\n' +
                                '                     <td>'+result[i].user_phone+'</td>\n' +
                                '                     <td>'+result[i].user_picaddress+'</td>\n' +
                                '                     <td>'+result[i].user_pwd+'</td>\n' +
                                '                     <td>'+result[i].user_qq+'</td>\n' +
                                '                     <td>'+result[i].user_sex+'</td>\n' +
                                '                     <td>'+result[i].user_signature+'</td>\n' +
                                '                     <td><a href="#" class="delBtn1">删除</a></td>\n' +
                                '                 </tr>');
                            $("#tab").after($s);
                        }
                    }

                }
            }
        )
}
