$(function () {

    //选择框
    $("input[name='checkOne']").click(function () {
        calcTotal();
    });
    //全选
    $("input[name='allCheck']").click(function () {
        var $ret = $(this).prop("checked");
        $("input[name='checkOne']").each(function () {
            $(this).prop('checked', $ret);
        });
        calcTotal();
    });
})

function calcTotal() {
    var total = 0;
    var $checkBox = $("input[name='checkOne']");
    var $price = $(".price");
    $checkBox.each(function () {
        if ($(this).prop("checked")) {
            var i = $checkBox.index($(this));
            total += parseFloat($price.eq(i).text());
        }
    });
    $("#total").text(total);
}