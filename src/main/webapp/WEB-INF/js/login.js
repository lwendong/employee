$(function () {
    var $username = $("#username");
    var $password = $("#password");
    $("#login").on("click",() =>{
        var username = $username.val();
        var password = $password.val();

        $.ajax({
            url:"/user/login",
            type:"post",
            dataType:"json",
            contentType: "application/json;charset=utf-8",
            data:JSON.stringify({
                username,password
            }),
            success:function (result){
                if(result.code === 200){
                    window.location.href = "/index";
                }else{
                    alert("密码错误")
                }

            }
        })
    });
})