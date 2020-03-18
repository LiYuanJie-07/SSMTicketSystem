$(document).ready(function () {

    //获取公告方法
    function loadNotice() {
        $.ajax({
            type: "GET",
            url: "/noticeController/getAllNotice",
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    $('#dg-notice').datagrid('loadData', response.data.notices);
                }
            }
        });
    }

    //获取公告并显示
    loadNotice();

    // 点击新增按钮事件
    $("#btn-add").click(function (e) {
        e.preventDefault();
        // 取消行选中
        $('#dg-notice').datagrid('clearChecked');
        //清空新增输入框内容
        $('#add-noticetitle').textbox('clear');
        $('#add-noticetext').textbox('clear');
        // 打开新增模态框
        $('#dlg-add').dialog('open');
    });

    // 新增公告点击确定按钮事件
    $('#btn-add-ok').click(function (e) {
        e.preventDefault();
        var add_noticetitle = $('#add-noticetitle').textbox('getValue'); //新增告标题
        var add_noticetext = $('#add-noticetext').textbox('getValue'); //新增公告内容
        //判断输入内容是否为空
        if (add_noticetitle == "") {
            // 提示输入公告标题
            $.messager.alert('消息提醒', '请输入公告标题！', 'info');
        } else if (add_noticetext == "") {
            // 提示输入公告内容
            $.messager.alert('消息提醒', '请输入公告内容！', 'info');
        } else {
            // 发送ajax新增公告
            $.ajax({
                type: "POST",
                url: "/noticeController/addNotice",
                data: {
                    "noticetitle": add_noticetitle,
                    "noticetext": add_noticetext
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 关闭新增模态框
                        $('#dlg-add').dialog('close');
                        //重新加载公告
                        loadNotice();
                        // 新增成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        // 关闭新增模态框
                        $('#dlg-add').dialog('close');
                        // 新增失败提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    }
                }
            });
        }
    });

    //新增公告点击取消按钮事件
    $('#btn-add-cancel').click(function (e) {
        e.preventDefault();
        // 关闭新增模态框
        $('#dlg-add').dialog('close');
    });


    var row
    // 点击编辑按钮事件
    $("#btn-edit").click(function (e) {
        e.preventDefault();
        row = $('#dg-notice').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要修改的公告！', 'info');
        } else {
            // 将html转换为富文本
            var noticetext = row.noticetext.replace(/   /g, "&nbsp;").replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/<br\/>/g, "\n").replace(/&nbsp;&nbsp;&nbsp;/g, "\t").replace(/&quot;/g, "\"");

            //在文本框中显示公告
            $('#edit-noticetitle').textbox('setValue', row.noticetitle);
            $('#edit-noticetext').textbox('setValue', noticetext);
            // 打开编辑模态框
            $('#dlg-edit').dialog('open');
        }

    });

    //编辑公告点击确定按钮事件
    $('#btn-edit-ok').click(function (e) {
        e.preventDefault();
        //获取文本框输入的值
        var edit_noticetitle = $('#edit-noticetitle').textbox('getValue');
        var edit_noticetext = $('#edit-noticetext').textbox('getValue');
        //发送ajax修改公告
        $.ajax({
            type: "POST",
            url: "/noticeController/editNotice",
            data: {
                "noticeid": row.noticeid,
                "noticetitle": edit_noticetitle,
                "noticetext": edit_noticetext
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //重新加载公告
                    loadNotice();
                    // 关闭编辑模态框
                    $('#dlg-edit').dialog('close');
                    // 修改成功提示信息
                    $.messager.show({
                        title: '消息提醒',
                        msg: response.msg,
                        timeout: 2000,
                        showType: 'slide'
                    });
                } else if (response.code == 100) {
                    // 关闭编辑模态框
                    $('#dlg-edit').dialog('close');
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
    });

    //修改公告点击取消按钮事件
    $('#btn-edit-cancel').click(function (e) {
        e.preventDefault();
        // 关闭编辑模态框
        $('#dlg-edit').dialog('close');
    });


    //点击删除按钮事件
    $('#btn-remove').click(function (e) {
        e.preventDefault();
        row = $('#dg-notice').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的公告！', 'info');
        } else {
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此公告吗？<br/>(删除后无法恢复)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/noticeController/deleteNotice",
                        data: {
                            "noticeid": row.noticeid
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载公告
                                loadNotice();
                                // 删除成功提示信息
                                $.messager.show({
                                    title: '消息提醒',
                                    msg: response.msg,
                                    timeout: 2000,
                                    showType: 'slide'
                                });
                            } else if (response.code == 100) {
                                // 删除失败提示信息
                                $.messager.show({
                                    title: '消息提醒',
                                    msg: response.msg,
                                    timeout: 2000,
                                    showType: 'slide'
                                });
                            }
                        }
                    });
                }
            });
        }
    });


});