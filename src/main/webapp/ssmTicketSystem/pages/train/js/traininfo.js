$(document).ready(function () {

    //分页
    var pager = $('#dg-traininfo').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageList: [10], // 可以设置每页记录条数的列表
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadTrainInfo(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadTrainInfo(pageNumber, pageSize);
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
    //获取所有列车信息
    function loadTrainInfo(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/trainController/getAllTrainInfo",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取列车信息成功并显示
                    $('#dg-traininfo').datagrid('loadData', response.data.allTrainInfo);
                    //最后一页
                    lastPage = Math.ceil(response.data.allTrainInfo.total / 10);
                } else if (response.code == 100) {
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });
    }

    loadTrainInfo(1, 10);


    // 新增按钮点击事件
    $("#btn-traininfo-add").click(function (e) {
        e.preventDefault();
        //如果启动行编辑则取消
        $('#dg-traininfo').datagrid('endEdit', index);
        // 取消行选中
        $('#dg-traininfo').datagrid('clearChecked');
        //清空新增输入框内容
        $('#add-traintype').textbox('clear');
        $('#add-trainname').textbox('clear');
        $('#add-trainlocation').textbox('clear');
        $('#add-trainprice').textbox('clear');
        // 打开新增模态框
        $('#dlg-traininfo-add').dialog('open');
    });

    // 新增列车确定按钮点击事件
    $('#btn-traininfo-add-ok').click(function (e) {
        e.preventDefault();
        if ($('#add-traintype').textbox('isValid') && $('#add-trainname').textbox('isValid') &&
            $('#add-trainlocation').textbox('isValid') && $('#add-trainprice').textbox('isValid')) { //校验输入
            //校验通过
            var add_traintype = $('#add-traintype').textbox('getValue'); //新增列车标题
            var add_trainname = $('#add-trainname').textbox('getValue'); //新增列车名
            var add_trainlocation = $('#add-trainlocation').textbox('getValue'); //新增列车初始站
            var add_trainprice = $('#add-trainprice').textbox('getValue'); //新增列车每公里价格
            // 发送ajax新增列车
            $.ajax({
                type: "POST",
                url: "/trainController/addTrainInfo",
                data: {
                    "trainname": add_trainname,
                    "traintype": add_traintype,
                    "trainlocation": add_trainlocation,
                    "trainprice": add_trainprice
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 关闭新增列车模态框
                        $('#dlg-traininfo-add').dialog('close');
                        //重新加载列车列表
                        loadTrainInfo(lastPage, 10);
                        // 新增成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        // 关闭新增模态框
                        $('#dlg-traininfo-add').dialog('close');
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
            $.messager.alert('消息提醒', "请把列车信息输入完整！", 'warning');
        }

    });


    //新增列车取消按钮点击事件
    $('#btn-traininfo-add-cancel').click(function (e) {
        e.preventDefault();
        // 关闭新增模态框
        $('#dlg-traininfo-add').dialog('close');
    });


    var row;
    var index = -1;
    //编辑按钮点击事件
    $('#btn-traininfo-edit').click(function (e) {
        e.preventDefault();
        row = $('#dg-traininfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要编辑的列车信息！', 'info');
        } else {
            $('#dg-traininfo').datagrid('endEdit', index);
            //获取当前行对应的index
            index = $('#dg-traininfo').datagrid('getRowIndex', row);
            //进入编辑状态
            $('#dg-traininfo').datagrid('beginEdit', index);
        }
    });


    //保存按钮点击事件
    var rowIndex; //点击保存时选中的行
    $('#btn-traininfo-save').click(function (e) {
        e.preventDefault();
        row = $('#dg-traininfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) {
            $.messager.alert('消息提醒', '列车信息未作修改！', 'info');
        } else {
            rowIndex = $('#dg-traininfo').datagrid('getRowIndex', row);
            if (rowIndex == index) { // 判断编辑的行与保存的行是否为同一行
                $('#dg-traininfo').datagrid('endEdit', index); //取消编辑状态
                var page = $('#dg-traininfo').datagrid('getPager').data("pagination").options.pageNumber; //获取修改的行所在页数
                //发送ajax更新列车信息
                $.ajax({
                    type: "POST",
                    url: "/trainController/changeTrainInfo",
                    data: {
                        "trainid": row.trainid,
                        "trainname": row.trainname,
                        "traintype": row.traintype,
                        "trainlocation": row.trainlocation,
                        "trainprice": row.trainprice
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            loadTrainInfo(page, 10);
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
                $.messager.alert('消息提醒', '列车信息未作修改！', 'info');
            }
        }

    });


    //撤销修改按钮点击事件
    $('#btn-traininfo-reject').click(function (e) {
        e.preventDefault();
        $('#dg-traininfo').datagrid('rejectChanges');
    });


    //删除按钮点击事件
    $('#btn-traininfo-remove').click(function (e) {
        e.preventDefault();
        row = $('#dg-traininfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的列车信息！', 'info');
        } else {
            var page = $('#dg-traininfo').datagrid('getPager').data("pagination").options.pageNumber; //获取删除行所在页数
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此列车吗？<br/>(删除后无法恢复)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/trainController/deleteTrainInfo",
                        data: {
                            "trainid": row.trainid
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载列车信息列表
                                loadTrainInfo(page, 10);
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
    $('#btn-traininfo-search').searchbox({
        searcher: function (value) {
            //判断输入是否为空
            if (value == null || value.replace(/(^\s*)|(\s*$)/g, "") == "" || value.length == 0) {
                return;
            } else {
                //执行搜索
                $.ajax({
                    type: "GET",
                    url: "/trainController/searchTrainInfo",
                    data: {
                        "value": value
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            //显示查询到的列车信息
                            $('#dg-traininfo').datagrid('loadData', response.data.searchTrainInfo);
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