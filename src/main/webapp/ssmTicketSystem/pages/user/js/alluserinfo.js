$(document).ready(function () {

    //分页
    var pager = $('#dg-alluserinfo').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageList: [10], // 可以设置每页记录条数的列表
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadUserInfo(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadUserInfo(pageNumber, pageSize);
        },
        onRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loaded');
            // 刷新成功提示信息
            $.messager.show({
                title: '消息提醒',
                msg: '数据已更新！',
                timeout: 2000,
                showType: 'slide'
            });
        }
    });


    //获取所有用户信息
    function loadUserInfo(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/userController/getAllUserInfo",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取用户信息并显示
                    $('#dg-alluserinfo').datagrid('loadData', response.data.allUserInfo);
                } else if (response.code == 100) {
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });
    }

    loadUserInfo(1, 10);


    var row;
    var index = -1;
    //编辑按钮点击事件
    $('#btn-alluserinfo-edit').click(function (e) {
        e.preventDefault();
        row = $('#dg-alluserinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要编辑的用户信息！', 'info');
        } else {
            $('#dg-alluserinfo').datagrid('endEdit', index);
            //获取当前行对应的index
            index = $('#dg-alluserinfo').datagrid('getRowIndex', row);
            //进入编辑状态
            $('#dg-alluserinfo').datagrid('beginEdit', index);
        }
    });


    //保存按钮点击事件
    var rowIndex;
    $('#btn-alluserinfo-save').click(function (e) {
        e.preventDefault();
        row = $('#dg-alluserinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) {
            $.messager.alert('消息提醒', '用户信息未作修改！', 'info');
        } else {
            rowIndex = $('#dg-alluserinfo').datagrid('getRowIndex', row);
            if (rowIndex == index) { // 判断编辑的行与保存的行是否为同一行
                $('#dg-alluserinfo').datagrid('endEdit', index); //取消编辑状态
                var page = $('#dg-alluserinfo').datagrid('getPager').data("pagination").options.pageNumber; //获取当前行所在页数
                //发送ajax更新用户信息
                $.ajax({
                    type: "POST",
                    url: "/userController/changeUserInfoByAdmin",
                    data: {
                        "userid": row.userid,
                        "username": row.username,
                        "password": row.password,
                        "email": row.email,
                        "idcardname": row.idcardname,
                        "idcardnumber": row.idcardnumber,
                        "phone": row.phone,
                        "type": row.type
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            loadUserInfo(page, 10);
                            // 刷新成功提示信息
                            $.messager.show({
                                title: '消息提醒',
                                msg: response.msg,
                                timeout: 2000,
                                showType: 'slide'
                            });
                        } else if (response.code == 100) {
                            $.messager.show({
                                title: '消息提醒',
                                msg: response.msg,
                                timeout: 2000,
                                showType: 'slide'
                            });
                        }
                    }
                });
            } else {
                $.messager.alert('消息提醒', '用户信息未作修改！', 'info');
            }
        }

    });


    //撤销修改按钮点击事件
    $('#btn-alluserinfo-reject').click(function (e) {
        e.preventDefault();
        $('#dg-alluserinfo').datagrid('rejectChanges');
    });


    //删除按钮点击事件
    $('#btn-alluserinfo-remove').click(function (e) {
        e.preventDefault();
        row = $('#dg-alluserinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的用户！', 'info');
        } else {
            var page = $('#dg-alluserinfo').datagrid('getPager').data("pagination").options.pageNumber; //获取当前行所在页数
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此用户吗？<br/>(删除后无法恢复)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/userController/deleteUserInfo",
                        data: {
                            "userid": row.userid
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载用户信息列表
                                loadUserInfo(page, 10);
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


    //搜索框
    $('#btn-alluserinfo-search').searchbox({
        searcher: function (value) {
            //判断输入是否为空
            if (value == null || value.replace(/(^\s*)|(\s*$)/g, "") == "" || value.length == 0) {
                return;
            } else {
                //执行搜索
                $.ajax({
                    type: "GET",
                    url: "/userController/searchUserInfo",
                    data: {
                        "value": value
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            //显示查询到的用户信息
                            $('#dg-alluserinfo').datagrid('loadData', response.data.searchUserInfo);
                            // 提示信息
                            $.messager.show({
                                title: '消息提醒',
                                msg: response.msg,
                                timeout: 1000,
                                showType: 'slide'
                            });
                        } else if (response.code == 100) {
                            // 提示信息
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
        }
    });


});