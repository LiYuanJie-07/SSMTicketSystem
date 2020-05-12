$(document).ready(function () {

    //分页
    var pager = $('#dg-seatinfo').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageSize: 10,
        pageList: [10], // 可以设置每页记录条数的列表
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadSeatInfo(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadSeatInfo(pageNumber, pageSize);
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

    var lastPage; //最后一页，用于新增后跳转
    //获取所有座位信息
    function loadSeatInfo(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/seatController/getAllSeatInfo",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取座位信息成功并显示
                    $('#dg-seatinfo').datagrid('loadData', response.data.allSeatInfo);
                    //最后一页
                    lastPage = Math.ceil(response.data.allSeatInfo.total / 10);
                } else if (response.code == 100) {
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });
    }

    loadSeatInfo(1, 10);

    // 新增按钮点击事件
    $("#btn-seatinfo-add").click(function (e) {
        e.preventDefault();
        // 取消行选中
        $('#dg-seatinfo').datagrid('clearChecked');
        //清空新增输入框内容
        $('#add-trainid').textbox('clear');
        $('#add-seattype').textbox('clear');
        $('#add-number').textbox('clear');
        $('#add-carriage').textbox('clear');
        // 打开新增模态框
        $('#dlg-seatinfo-add').dialog('open');
    });


    // 新增座位确定按钮点击事件
    $('#btn-seatinfo-add-ok').click(function (e) {
        e.preventDefault();
        if ($('#add-trainid').textbox('isValid') && $('#add-seattype').textbox('isValid') &&
            $('#add-number').textbox('isValid') && $('#add-carriage').textbox('isValid')) { //校验输入
            //校验通过
            var add_trainid = $('#add-trainid').textbox('getValue'); //新增座位所属列车
            var add_seattype = $('#add-seattype').textbox('getValue'); //新增座位类型
            var add_number = $('#add-number').textbox('getValue'); //新增座位数量
            var add_carriage = $('#add-carriage').textbox('getValue'); //新增座位所属车厢
            // 发送ajax新增座位
            $.ajax({
                type: "POST",
                url: "/seatController/addSeatInfo",
                data: {
                    "trainid": add_trainid,
                    "seattype": add_seattype,
                    "number": add_number,
                    "carriage": add_carriage
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 关闭新增座位模态框
                        $('#dlg-seatinfo-add').dialog('close');
                        //重新加载座位列表
                        loadSeatInfo(lastPage, 10);
                        // 新增成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        // 关闭新增模态框
                        $('#dlg-seatinfo-add').dialog('close');
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
        } else { //校验不通过
            $.messager.alert('消息提醒', "请把座位信息输入完整！", 'warning');
        }

    });


    //新增座位取消按钮点击事件
    $('#btn-seatinfo-add-cancel').click(function (e) {
        e.preventDefault();
        // 关闭新增模态框
        $('#dlg-seatinfo-add').dialog('close');
    });


    //删除按钮点击事件
    $('#btn-seatinfo-remove').click(function (e) {
        e.preventDefault();
        var row = $('#dg-seatinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的座位信息！', 'info');
        } else {
            var page = $('#dg-seatinfo').datagrid('getPager').data("pagination").options.pageNumber; //获取删除行所在页数
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此座位吗？<br/>(删除后无法恢复)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/seatController/deleteSeatInfo",
                        data: {
                            "seatid": row.seatid,
                            "trainid": row.trainid,
                            "seattype": row.seattype
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载座位信息列表
                                loadSeatInfo(page, 10);
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
    $('#btn-seatinfo-search').searchbox({
        searcher: function (value) {
            //判断输入是否为空
            if (value == null || value.replace(/(^\s*)|(\s*$)/g, "") == "" || value.length == 0) {
                return;
            } else {
                //执行搜索
                $.ajax({
                    type: "GET",
                    url: "/seatController/searchSeatInfo",
                    data: {
                        "value": value
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            //显示查询到的座位信息
                            $('#dg-seatinfo').datagrid('loadData', response.data.searchSeatInfo);
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