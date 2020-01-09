$(document).ready(function () {

    //点击登录按钮发送请求
    $("#btn-login").click(function (e) {
        e.preventDefault();
        // 隐藏登录span
        $("#login-span").addClass('hide');
        // 显示loading动画
        $(".sk-wave").removeClass('hide');
        $.ajax({
            type: "POST",
            url: "/loginController/login",
            data: $("#login-form").serialize(),
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    // 登录成功
                    alert(response.msg);
                    window.location.replace("/index.jsp");
                } else if (response.code == 100) {
                    // 登陆失败
                    //显示登录span，隐藏loading动画
                    $("#login-span").removeClass('hide');
                    $(".sk-wave").addClass('hide');
                    // 显示提示信息
                    $("#tips").removeClass('hide').empty().append("<strong>" + response.msg + "</strong>");
                    closeTips();
                }
            }

        });

    });

    // 定时消除提示框
    function closeTips() {
        setTimeout(function () {
            $("#tips").addClass('hide');
        }, 2000);
    }

});