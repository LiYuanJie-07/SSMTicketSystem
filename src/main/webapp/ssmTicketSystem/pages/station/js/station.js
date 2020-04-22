$(document).ready(function () {

    //分页
    var pager = $('#dg-stationinfo').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageList: [10], // 可以设置每页记录条数的列表
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadStationInfo(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadStationInfo(pageNumber, pageSize);
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
    //获取所有始终站信息
    function loadStationInfo(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/stationController/getAllStationInfo",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取始终站台信息成功并显示
                    $('#dg-stationinfo').datagrid('loadData', response.data.allStationInfo);
                    //最后一页
                    lastPage = Math.ceil(response.data.allStationInfo.total / 10);
                } else if (response.code == 100) {
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });
    }

    loadStationInfo(1, 10);


    // 新增按钮点击事件
    $("#btn-stationinfo-add").click(function (e) {
        e.preventDefault();
        //如果启动行编辑则取消
        $('#dg-stationinfo').datagrid('endEdit', index);
        // 取消行选中
        $('#dg-stationinfo').datagrid('clearChecked');
        //清空新增输入框内容
        $('#add-startstation').textbox('clear');
        $('#add-endstation').textbox('clear');
        $('#add-starttime').textbox('clear');
        $('#add-usetime').textbox('clear');
        $('#add-distance').textbox('clear');
        // 打开新增模态框
        $('#dlg-stationinfo-add').dialog('open');
    });

    // 新增始终站台确定按钮点击事件
    $('#btn-stationinfo-add-ok').click(function (e) {
        e.preventDefault();
        if ($('#add-startstation').textbox('isValid') && $('#add-endstation').textbox('isValid') &&
            $('#add-starttime').textbox('isValid') && $('#add-usetime').textbox('isValid') &&
            $('#add-distance').textbox('isValid')) { //校验输入
            //校验通过
            var add_startstation = $('#add-startstation').textbox('getValue'); //始发站
            var add_endstation = $('#add-endstation').textbox('getValue'); //终点站
            var add_starttime = $('#add-starttime').textbox('getValue'); //发车时间
            var add_usetime = $('#add-usetime').textbox('getValue'); //历时
            var add_distance = $('#add-distance').textbox('getValue'); //距离
            // 发送ajax新增始终站台
            $.ajax({
                type: "POST",
                url: "/stationController/addStationInfo",
                data: {
                    "startstation": add_startstation,
                    "endstation": add_endstation,
                    "starttime": add_starttime,
                    "usetime": add_usetime,
                    "distance": add_distance
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 关闭新增始终站台模态框
                        $('#dlg-stationinfo-add').dialog('close');
                        //重新加载列车列表
                        loadStationInfo(lastPage, 10);
                        // 新增成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        // 关闭新增模态框
                        $('#dlg-stationinfo-add').dialog('close');
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
            $.messager.alert('消息提醒', "请把站台信息输入完整！", 'warning');
        }

    });


    //新增始终站取消按钮点击事件
    $('#btn-stationinfo-add-cancel').click(function (e) {
        e.preventDefault();
        // 关闭新增模态框
        $('#dlg-stationinfo-add').dialog('close');
    });


    var row;
    var index = -1;
    //编辑按钮点击事件
    $('#btn-stationinfo-edit').click(function (e) {
        e.preventDefault();
        row = $('#dg-stationinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要编辑的站台信息！', 'info');
        } else {
            $('#dg-stationinfo').datagrid('endEdit', index);
            //获取当前行对应的index
            index = $('#dg-stationinfo').datagrid('getRowIndex', row);
            //进入编辑状态
            $('#dg-stationinfo').datagrid('beginEdit', index);
        }
    });


    //保存按钮点击事件
    var rowIndex; //点击保存按钮时选中的行
    $('#btn-stationinfo-save').click(function (e) {
        e.preventDefault();
        row = $('#dg-stationinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) {
            $.messager.alert('消息提醒', '站台信息未作修改！', 'info');
        } else {
            rowIndex = $('#dg-stationinfo').datagrid('getRowIndex', row);
            if (rowIndex == index) { // 判断编辑的行与保存的行是否为同一行
                $('#dg-stationinfo').datagrid('endEdit', index); //取消编辑状态
                var page = $('#dg-stationinfo').datagrid('getPager').data("pagination").options.pageNumber; //获取修改的行所在页数
                //发送ajax更新列车信息
                $.ajax({
                    type: "POST",
                    url: "/stationController/changeStationInfo",
                    data: {
                        "stationid": row.stationid,
                        "startstation": row.startstation,
                        "endstation": row.endstation,
                        "starttime": row.starttime,
                        "usetime": row.usetime,
                        "distance": row.distance
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            loadStationInfo(page, 10);
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
                $.messager.alert('消息提醒', '站台信息未作修改！', 'info');
            }
        }

    });


    //撤销修改按钮点击事件
    $('#btn-stationinfo-reject').click(function (e) {
        e.preventDefault();
        $('#dg-stationinfo').datagrid('rejectChanges');
    });


    //删除按钮点击事件
    $('#btn-stationinfo-remove').click(function (e) {
        e.preventDefault();
        row = $('#dg-stationinfo').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的站台信息！', 'info');
        } else {
            var page = $('#dg-stationinfo').datagrid('getPager').data("pagination").options.pageNumber; //获取删除行所在页数
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此始终站台吗？<br/>(删除后无法恢复)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/stationController/deleteStationInfo",
                        data: {
                            "stationid": row.stationid
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载始终站台信息列表
                                loadStationInfo(page, 10);
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
    $('#btn-stationinfo-search').click(function (e) {
        e.preventDefault();
        var search_startstation = $('#stationinfo-search-startstation').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_endstation = $('#stationinfo-search-endstation').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_starttime = $('#stationinfo-search-starttime').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_arrivetime = $('#stationinfo-search-arrivetime').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        $.ajax({
            type: "GET",
            url: "/stationController/searchStationInfo",
            data: {
                "query_startstation": search_startstation,
                "query_endstation": search_endstation,
                "query_starttime": search_starttime,
                "query_arrivetime": search_arrivetime
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //显示查询到的始终站台信息
                    $('#dg-stationinfo').datagrid('loadData', response.data.searchStationInfo);
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

    });


});