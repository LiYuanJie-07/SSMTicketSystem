$(document).ready(function () {


    // 定时消除提示框 方法
    function closeTips() {
        setTimeout(function () {
            $("#tips").fadeOut();
        }, 2000);
    }

    // 60秒后重试  方法
    var wait = 60;

    function reget(btn) {
        if (wait === 0) {
            btn.removeAttribute("disabled");
            btn.innerHTML = "获取验证码";
            wait = 60;
        } else {
            btn.setAttribute("disabled", true);
            btn.innerHTML = wait + "秒后重试";
            wait--;
            setTimeout(function () {
                reget(btn);
            }, 1000);
        }
    }

    var regChangePwdEmail = false; // 邮箱检验标志
    var regChangePwd_email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/; //邮箱正则
    //邮箱校验方法
    function checkemail() {
        //获取输入邮箱
        var email = $("#changepwd-email").val();
        //校验
        if (email === "" || email === null || email.length === 0) {
            $("#changepwd-email").parent().addClass('has-error');
            $("#changepwd-email-tips").text("邮箱不能为空");
            regChangePwdEmail = false;
        } else if (!regChangePwd_email.test(email)) {
            $("#changepwd-email").parent().addClass('has-error');
            $("#changepwd-email-tips").text("邮箱格式不正确");
            regChangePwdEmail = false;
        } else {
            $("#changepwd-email").parent().removeClass('has-error');
            $("#changepwd-email-tips").empty();
            $("#changepwd-email").parent().addClass('has-success');
            regChangePwdEmail = true;
        }
    }


    // 校验邮箱格式
    $("#changepwd-email").blur(function (e) {
        e.preventDefault();
        checkemail();
    });


    var vfycode_one //后台发送的验证码
    //获取验证码按钮点击事件
    $('#btn-getcode').click(function (e) {
        e.preventDefault();
        //校验邮箱格式
        checkemail();
        if (regChangePwdEmail) { //校验邮箱格式正确
            //获取输入的邮箱
            var toEmailAddress = $('#changepwd-email').val();
            //发送ajax请求发送验证码
            $.ajax({
                type: "POST",
                url: "/userController/sendVfyCode",
                data: {
                    "toEmailAddress": toEmailAddress
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        vfycode_one = response.data.vfycode;
                        //发送验证码成功
                        $("#tips").removeClass('alert-danger');
                        $("#tips").addClass('alert-success');
                        $("#tips-msg").text(response.msg);
                        $("#tips").fadeIn();
                        closeTips();
                    } else if (response.code == 100) {
                        //发送验证码失败
                        $("#tips").removeClass('alert-success');
                        $("#tips").addClass('alert-danger');
                        $("#tips-msg").text(response.msg);
                        $("#tips").fadeIn();
                        closeTips();
                    }
                }
            });
        } else { //校验邮箱格式错误
            //提示信息
            $("#tips").removeClass('alert-success');
            $("#tips").addClass('alert-danger');
            $("#tips-msg").text("请输入正确的邮箱地址！");
            $("#tips").fadeIn();
            closeTips();

        }

        // 60秒后重试
        reget(this)
    });


    //点击next按钮 校验验证码
    $("#btn-next").click(function (e) {
        e.preventDefault();
        var vfycode_two = $('#changepwd-code').val();

        if (vfycode_one == vfycode_two) {
            // 隐藏next字样
            $("#btn-next").children('strong').addClass('hide');
            $("#btn-next").children('span').addClass('hide');
            // 显示loading动画
            $(".sk-wave").removeClass('hide');
            setTimeout(function () {
                //2s后隐藏检验邮箱面板
                $('#checkemail-panel').addClass('hide');
                //显示修改密码面板
                $('#changepwd-panel').fadeIn();
                // 隐藏loading动画
                $(".sk-wave").addClass('hide');
            }, 1000);
        } else {
            // 隐藏next字样
            $("#btn-next").children('strong').addClass('hide');
            $("#btn-next").children('span').addClass('hide');
            // 显示loading动画
            $(".sk-wave").removeClass('hide');

            setTimeout(function () {
                // 隐藏loading动画
                $(".sk-wave").addClass('hide');
                // 显示next字样
                $("#btn-next").children('strong').removeClass('hide');
                $("#btn-next").children('span').removeClass('hide');
                //提示信息
                $("#tips").removeClass('alert-success');
                $("#tips").addClass('alert-danger');
                $("#tips-msg").text("验证码错误！");
                $("#tips").fadeIn();
                closeTips();
            }, 1000);

        }

    });

    // 校验修改密码输入密码格式
    var regChangePwd_password = /^[a-zA-Z0-9_-]{6,12}$/; //密码正则
    var regChangePwdPassword1 = false; // 修改密码校验标志
    $("#changepwd-password1").change(function (e) {
        e.preventDefault();
        //获取输入的密码
        var password = $('#changepwd-password1').val();
        //校验
        if (password === "" || password === null || password.length === 0) {
            $("#changepwd-password1").parent().removeClass('has-success');
            $("#changepwd-password1").parent().addClass('has-error');
            $("#changepwd-password1-tips").text("密码不能为空");
            regChangePwdPassword1 = false;
        } else if (!regChangePwd_password.test(password)) {
            $("#changepwd-password1").parent().removeClass('has-success');
            $("#changepwd-password1").parent().addClass('has-error');
            $("#changepwd-password1-tips").text("密码格式是6-12位数字或字母");
            regChangePwdPassword1 = false;
        } else {
            $("#changepwd-password1").parent().removeClass('has-error');
            $("#changepwd-password1-tips").empty();
            $("#changepwd-password1").parent().addClass('has-success');
            regChangePwdPassword1 = true;
        }

    });

    // 校验注册确认密码是否一致
    var regChangePwdPassword2 = false; // 确认密码校验标志
    $("#changepwd-password2").blur(function (e) {
        e.preventDefault();
        //获取密码
        var password = $('#changepwd-password2').val();
        //校验
        if (password != $("#changepwd-password1").val() || password === "" || password === null || password.length === 0) {
            $("#changepwd-password2").parent().removeClass('has-success');
            $("#changepwd-password2").parent().addClass('has-error');
            $("#changepwd-password2-tips").text("两次输入密码不一致");
            regChangePwdPassword2 = false;
        } else if (password == $("#changepwd-password1").val() && regChangePwdPassword1) {
            $("#changepwd-password2").parent().removeClass('has-error');
            $("#changepwd-password2-tips").empty();
            $("#changepwd-password2").parent().addClass('has-success');
            regChangePwdPassword2 = true;
        }
    });


    // 确定按钮点击事件
    $('#btn-changepwd').click(function (e) {
        e.preventDefault();
        // 隐藏'确定'字样
        $("#btn-changepwd").children('strong').addClass('hide');
        // 显示loading动画
        $(".sk-wave").removeClass('hide');
        if (regChangePwdPassword1 && regChangePwdPassword2) { //校验密码
            //校验通过
            var emailChangePwd = $('#changepwd-email').val(); // 获取邮箱（作为修改条件）
            var changePassword = $('#changepwd-password2').val() //修改后的密码
            //发送ajax修改密码
            $.ajax({
                type: "POST",
                url: "/userController/changePassword",
                data: {
                    "email": emailChangePwd,
                    "password": changePassword
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) { //成功
                        //提示信息，即将跳转到登录页
                        $("#tips").removeClass('alert-danger');
                        $("#tips").addClass('alert-success');
                        $("#tips-msg").text(response.msg);
                        $("#tips").fadeIn();
                        setTimeout(function () {
                            $("#tips").fadeOut();
                            //跳转到登录页
                            window.location.replace("/logout");
                        }, 3000);
                    } else if (response.code == 100) { //失败
                        //提示信息，即将刷新本页面
                        $("#tips").removeClass('alert-success');
                        $("#tips").addClass('alert-danger');
                        $("#tips-msg").text(response.msg);
                        $("#tips").fadeIn();
                        setTimeout(function () {
                            $("#tips").fadeOut();
                            //刷新页面
                            window.location.reload();
                        }, 3000);
                    }
                }
            });
        } else {
            // 隐藏loading动画
            $(".sk-wave").addClass('hide');
            // 显示'确定'字样
            $("#btn-changepwd").children('strong').removeClass('hide');
            //提示信息
            $("#tips").removeClass('alert-success');
            $("#tips").addClass('alert-danger');
            $("#tips-msg").text("请检查输入的密码！");
            $("#tips").fadeIn();
            closeTips();
        }
    });


});