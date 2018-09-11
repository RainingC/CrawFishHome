$(function () {
finput();
finput2();
finput3();
})
function finput() {
  $("input[name='userphone']").focus(function () {
      $(".login-users").css("border","1px solid #49AF4F");
  });
  $("input[name='userphone']").blur(function () {
      $(".login-users").css("border","1px solid lavender");
  })
}
function finput2() {
    $("input[name='node']").focus(function () {
        $(".login_yanzheng").css("border","1px solid #49AF4F");
    });
    $("input[name='node']").blur(function () {
        $(".login_yanzheng").css("border","1px solid lavender");
    })
}
function finput3() {
    $("input[name='userpwd']").focus(function () {
        $(".login-user1").css("border","1px solid #49AF4F");
    });
    $("input[name='userpwd']").blur(function () {
        $(".login-user1").css("border","1px solid lavender");
    })
}