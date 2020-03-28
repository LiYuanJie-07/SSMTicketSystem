$(document).ready(function () {
    //更改输入框字体大小
    $("#userinfo-type").textbox('textbox').css("font-size", "15px");
    $("#userinfo-email").textbox('textbox').css("font-size", "15px");
    $("#userinfo-phone").textbox('textbox').css("font-size", "15px");

    //重写easyui校验方法
    $.extend($.fn.validatebox.defaults.rules, {
        phoneNum: { //校验手机号
            validator: function (value, param) {
                return /^[1]([3-9])[0-9]{9}$/.test(value);
            }
        }
    });

    //刷新tab方法
    function refreshTabs() {
        //获取当前选中的 tab
        var tab = $('#tabs').tabs('getSelected');
        //获取当前选中的 tab 的 href
        var url = $(tab.panel('options')).attr('href');
        //刷新
        tab.panel('refresh', url);
    }


    // 60秒后重试  方法
    var wait = 60;

    function reget() {
        if (wait === 0) {
            $('#userinfo-getVfycode').linkbutton({
                text: "获取验证码",
                iconCls: 'icon-back',
                disabled: false
            })
            $('#userinfo-getVfycode').bind('click', function (e) {
                e.preventDefault();
                getVfycode();
            });
            wait = 60;
        } else {
            $('#userinfo-getVfycode').linkbutton({
                text: wait + "秒后重试",
                iconCls: 'icon-reload',
                disabled: true
            })
            $('#userinfo-getVfycode').unbind('click');
            wait--;
            setTimeout(function () {
                reget();
            }, 1000);
        }
    }


    //修改手机号按钮点击事件
    $('#userinfo-change-phone').click(function (e) {
        e.preventDefault();
        //隐藏编辑按钮
        $('#userinfo-change-phone').fadeOut();
        //输入框可编辑
        $('#userinfo-phone').textbox('readonly', false);
        //显示保存按钮
        $('#userinfo-save').fadeIn();
    });


    //修改乘客类型按钮点击事件
    $('#userinfo-change-type').click(function (e) {
        e.preventDefault();
        //隐藏编辑按钮
        $('#userinfo-change-type').fadeOut();
        //输入框可编辑
        $('#userinfo-type').textbox('readonly', false);
        //显示保存按钮
        $('#userinfo-save').fadeIn();
    });


    //修改邮箱按钮点击事件
    $('#userinfo-change-eamil').click(function (e) {
        e.preventDefault();
        //清空输入的登陆密码
        $('#userinfo-checkPwd').textbox({});
        $('#userinfo-checkPwd').textbox('clear');
        //打开验证登陆密码模态框
        $('#dlg-checkPwd').dialog('open');
        //显示保存按钮
        $('#userinfo-save').fadeIn();
    });


    //验证登录密码模态框 确定按钮点击事件
    $('#btn-checkPwd-ok').click(function (e) {
        e.preventDefault();
        //获取输入的登陆密码
        var checkPwd = $('#userinfo-checkPwd').textbox('getValue');
        //发送ajax后台校验
        $.ajax({
            type: "POST",
            url: "/userController/checkPassword",
            data: {
                "password": checkPwd
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //关闭验证登陆密码模态框
                    $('#dlg-checkPwd').dialog('close');
                    //清空输入框
                    $('#userinfo-newEmail').textbox('clear');
                    $('#userinfo-vfyCode').textbox('clear');
                    //打开修改邮箱模态框
                    $('#dlg-checkEmail').dialog('open');

                } else if (response.code == 100) {
                    //登录密码错误，弹出提示信息
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });

    });


    //验证登陆密码模态框 取消按钮点击事件
    $('#btn-checkPwd-cancel').click(function (e) {
        e.preventDefault();
        //关闭验证登陆密码模态框
        $('#dlg-checkPwd').dialog('close');
    });


    //获取验证码 按钮点击事件
    $('#userinfo-getVfycode').click(function (e) {
        e.preventDefault();
        getVfycode(this);
    });


    var vfyCode1 //后台发送的验证码
    function getVfycode() {
        //校验输入的邮箱格式
        if ($('#userinfo-newEmail').textbox('isValid')) { //校验通过
            reget(this);
            //获取输入的新邮箱
            var newEmail = $('#userinfo-newEmail').textbox('getValue');
            //发送ajax 发送验证码
            $.ajax({
                type: "POST",
                url: "/userController/sendVfyCode",
                data: {
                    "toEmailAddress": newEmail
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        //验证码发送成功提示消息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                        vfyCode1 = response.data.vfycode
                    } else if (response.code == 100) {
                        //验证码发送失败提示消息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                }
            });
        } else { //校验不通过
            $.messager.alert('消息提醒', "邮箱格式不正确！", 'warning');
        }

    }

    //验证邮箱模态框 取消按钮点击事件
    $('#btn-checkEmail-cancel').click(function (e) {
        e.preventDefault();
        //关闭验证邮箱模态框
        $('#dlg-checkEmail').dialog('close');
    });

    //验证邮箱模态框 确定按钮点击事件
    $('#btn-checkEmail-ok').click(function (e) {
        e.preventDefault();
        var vfycode2 = $('#userinfo-vfyCode').textbox('getValue'); //获取输入的验证码
        if (vfyCode1 === vfycode2) { // 验证码一致
            var newEmail = $('#userinfo-newEmail').textbox('getValue'); //获取输入的新邮箱地址
            //修改显示的邮箱
            $('#userinfo-email').textbox('setValue', newEmail);
            //解除禁用
            $('#userinfo-email').textbox('enable');
            //设置只读
            $('#userinfo-email').textbox('readonly', true);
            //关闭验证邮箱模态框
            $('#dlg-checkEmail').dialog('close');
        } else { // 验证码不一致
            $.messager.alert('消息提醒', "输入的验证码错误！", 'error');
        }
    });


    //保存按钮点击事件
    $('#userinfo-save').click(function (e) {
        e.preventDefault();
        //校验邮箱、手机号的是否输入正确
        if ($('#userinfo-email').textbox('isValid') && $('#userinfo-phone').textbox('isValid')) { //校验通过
            //获取用户信息
            var email = $('#userinfo-email').textbox('getValue');
            var phone = $('#userinfo-phone').textbox('getValue');
            var type = $('#userinfo-type').textbox('getValue');
            //发送ajax更新用户信息
            $.ajax({
                type: "POST",
                url: "/userController/changeUserInfo",
                data: {
                    "email": email,
                    "phone": phone,
                    "type": type
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        //刷新页面
                        refreshTabs();
                        // 修改成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        //刷新页面
                        refreshTabs();
                        // 修改失败提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                }
            });
        } else { //校验不通过
            $.messager.alert('消息提醒', "请把信息填写完整！", 'warning');
        }

    });


});