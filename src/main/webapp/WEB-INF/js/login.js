$(function () {
    var $username = $("#username");
    var $password = $("#password");
    $("#login").on("click",() =>{
        var username = $username.val();
        var password = $password.val();
        debugger
        $.ajax({
            url:"/user/login",
            type:"post",
            dataType:"json",
            contentType: "application/json;charset=utf-8",
            data:JSON.stringify({
                username,password
            }),
            success:function (result){
                window.location.href = "/index";
            }
        })
    });
})