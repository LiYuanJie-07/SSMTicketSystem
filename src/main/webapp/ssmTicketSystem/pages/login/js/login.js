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
                    //隐藏loading动画，显示登录span
                    $(".sk-wave").addClass('hide');
                    $("#login-span").removeClass('hide');
                    // 显示提示信息
                    $("#tips-msg").empty().append(response.msg);
                    $("#tips").fadeIn();
                    // 定时消除提示框
                    closeTips();
                }
            }
        });

    });


    //校验登录用户名为空提示
    $("#login-username").change(function (e) {
        e.preventDefault();
        if ($("#login-username").val() == '') {
            $("#login-username").parent().addClass('has-error');
            $("#login-username-tips").text("用户名不能为空");
        } else {
            $("#login-username").parent().removeClass('has-error');
            $("#login-username-tips").empty();
            $("#login-username").parent().addClass('has-success');
        }
    });


    //校验登录密码提示
    var login_password = /^[a-zA-Z0-9_-]{6,12}$/;
    $("#login-password").change(function (e) {
        e.preventDefault();
        if (!login_password.test($("#login-password").val())) {
            $("#login-password").parent().addClass('has-error');
            $("#login-password-tips").text("密码是6-12位数字或字母");
        } else {
            $("#login-password").parent().removeClass('has-error');
            $("#login-password-tips").empty();
            $("#login-password").parent().addClass('has-success');
        }

    });


    // 定时消除用户名或密码错误提示框
    function closeTips() {
        setTimeout(function () {
            $("#tips").fadeOut();
        }, 2000);
    }

    // 点击注册按钮
    $("#btn-goregister").click(function (e) {
        e.preventDefault();
        // 隐藏登录面板
        $(".form-signin").addClass("hide");
        // 显示注册面板
        $(".reg-form-box").fadeIn();
    });

    // 校验注册用户名为空或用户名已存在提示
    var regRegisterUsername = false; // 注册用户名检验标志
    $("#register-username").change(function (e) {
        e.preventDefault();
        // 校验注册用户名是否为空
        if ($("#register-username").val() == '') {
            $("#register-username").parent().addClass('has-error');
            $("#register-username-tips").text("用户名不能为空");
            regRegisterUsername = false;
        } else {
            // 发送ajax请求校验用户名是否已经存在
            $.ajax({
                type: "POST",
                url: "/loginController/checkUsername",
                data: {
                    "username": this.value
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 用户名可用
                        $("#register-username").parent().removeClass('has-error');
                        $("#register-username").parent().addClass('has-success');
                        $("#register-username-tips").empty();
                        $("#register-username-tips").css("color", "green");
                        $("#register-username-tips").text(response.msg);
                        regRegisterUsername = true;
                    } else if (response.code == 100) {
                        // 用户名已存在
                        $("#register-username").parent().addClass('has-error');
                        $("#register-username-tips").empty();
                        $("#register-username-tips").text(response.msg);
                        regRegisterUsername = false;
                    }
                }
            });
        }
    });

    // 校验注册输入密码格式
    var regRsgisterPassword = false; // 注册密码校验标志
    $("#register-password1").change(function (e) {
        e.preventDefault();
        if (!login_password.test($("#register-password1").val())) {
            $("#register-password1").parent().addClass('has-error');
            $("#register-password1-tips").text("密码格式不正确");
            regRsgisterPassword = false;
        } else {
            $("#register-password1").parent().removeClass('has-error');
            $("#register-password1-tips").empty();
            $("#register-password1").parent().addClass('has-success');
            regRsgisterPassword = true;
        }

    });

    // 校验注册确认密码是否一致
    $("#register-password2").blur(function (e) {
        e.preventDefault();
        if ($("#register-password2").val() != $("#register-password1").val()) {
            $("#register-password2").parent().addClass('has-error');
            $("#register-password2-tips").text("两次输入密码不一致");
            regRsgisterPassword = false;
        } else if ($("#register-password2").val() == $("#register-password1").val()) {
            $("#register-password2").parent().removeClass('has-error');
            $("#register-password2-tips").empty();
            $("#register-password2").parent().addClass('has-success');
            regRsgisterPassword = true;
        }
    });

    // 校验注册邮箱格式
    var regRegisterEmail = false; // 注册邮箱检验标志
    var register_email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    $("#register-email").change(function (e) {
        e.preventDefault();
        if (!register_email.test($("#register-email").val())) {
            $("#register-email").parent().addClass('has-error');
            $("#register-email-tips").text("邮箱格式不正确");
            regRegisterEmail = false;
        } else {
            $("#register-email").parent().removeClass('has-error');
            $("#register-email-tips").empty();
            $("#register-email").parent().addClass('has-success');
            regRegisterEmail = true;
        }

    });

    // 校验注册身份证号码
    var regRegisterIdcardnumber = false; // 注册身份证号码校验标志
    var register_idcardnumber = /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
    $("#register-idcardnumber").change(function (e) {
        e.preventDefault();
        if (!register_idcardnumber.test($("#register-idcardnumber").val())) {
            $("#register-idcardnumber").parent().addClass('has-error');
            $("#register-idcardnumber-tips").text("请输入正确身份证号");
            regRegisterIdcardnumber = false;
        } else {
            $("#register-idcardnumber").parent().removeClass('has-error');
            $("#register-idcardnumber-tips").empty();
            $("#register-idcardnumber").parent().addClass('has-success');
            regRegisterIdcardnumber = true;
        }

    });

    // 校验注册姓名
    var regRegisterIdcardname = false; // 注册姓名校验标志
    $("#register-idcardname").change(function (e) {
        e.preventDefault();
        if ($("#register-idcardname").val() == '') {
            $("#register-idcardname").parent().addClass('has-error');
            $("#register-idcardname-tips").text("姓名不能为空");
            regRegisterIdcardname = false;
        } else {
            $("#register-idcardname").parent().removeClass('has-error');
            $("#register-idcardname-tips").empty();
            $("#register-idcardname").parent().addClass('has-success');
            regRegisterIdcardname = true;
        }

    });

    // 校验注册手机号码
    var regRegisterPhone = false; // 注册手机号校验标志
    var register_phone = /^[1]([3-9])[0-9]{9}$/;
    $("#register-phone").change(function (e) {
        e.preventDefault();
        if (!register_phone.test($("#register-phone").val())) {
            $("#register-phone").parent().addClass('has-error');
            $("#register-phone-tips").text("手机号码格式不正确");
            regRegisterPhone = false;
        } else {
            $("#register-phone").parent().removeClass('has-error');
            $("#register-phone-tips").empty();
            $("#register-phone").parent().addClass('has-success');
            regRegisterPhone = true;
        }

    });

    // 校验旅客类型是否为空
    var regRegisterType = false; // 注册旅客类型校验标志
    $($("#register-type")).change(function (e) {
        e.preventDefault();
        if (this.value != "") {
            regRegisterType = true;
        }
    });


    // 点击确定完成注册
    $("#btn-register").click(function (e) {
        e.preventDefault();
        // 判断信息是否填写完整
        if (regRsgisterPassword && regRegisterEmail && regRegisterIdcardnumber &&
            regRegisterIdcardname && regRegisterPhone && regRegisterType) {
            // 信息填写完整，进行注册
            $.ajax({
                type: "POST",
                url: "/loginController/register",
                data: $("#register-form").serialize(),
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        alert(response.msg);
                        window.location.reload();
                    }else if (response.code == 100) {
                        alert(response.msg);
                    }
                }
            });
        } else {
            // 信息未填写完整，弹出提示
            $("#tips-msg").empty().append("请把信息填写完整");
            $("#tips").fadeIn();
            // 定时消除提示框
            closeTips();
        }


    });

});