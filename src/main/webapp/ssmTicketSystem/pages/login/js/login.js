$(document).ready(function () {

    //点击登录按钮发送请求
    $("#btn-login").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/loginController/login",
            data: $("#login-form").serialize(),
            dataType: "json",
            success: function (response) {
                window.location.href = "/index.jsp"
            }
        });



    });

});