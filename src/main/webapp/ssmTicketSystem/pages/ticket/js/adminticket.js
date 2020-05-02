$(document).ready(function () {

    //刷新站台日期
    $.ajax({
        type: "GET",
        url: "/stationController/updateStationTime",
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                loadTicketInfo(1, 10);
            }
        }
    });

    //分页
    var pager = $('#dg-adminTicket').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageSize: 10,
        pageList: [10], // 可以设置每页记录条数的列表
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadTicketInfo(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadTicketInfo(pageNumber, pageSize);
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
    function loadTicketInfo(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/ticketController/getAllTicketInfo",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取车票信息成功并显示
                    $('#dg-adminTicket').datagrid('loadData', response.data.allTicketInfo);
                    //最后一页
                    lastPage = Math.ceil(response.data.allTicketInfo.total / 10);
                } else if (response.code == 100) {
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });
    }

    var distance //保存站台距离
    //选择始发站触发方法
    $("#adminTicket-add-ticketstartstation").combobox({
        onSelect: function (rea) {
            //根据始发站以及列车类型获取车次选项
            if ($('#adminTicket-add-tickettraintype').textbox('getValue') == "高铁" || $('#adminTicket-add-tickettraintype').textbox('getValue') == "动车") {
                var tickettraintype = $('#adminTicket-add-tickettraintype').textbox('getValue')
                $("#adminTicket-add-tickettrainname").combobox({
                    disabled: false,
                    valueField: 'id',
                    textField: 'text',
                    method: 'GET',
                    url: '/trainController/getTrainNameByLocationAndTrainType?trainlocation=' + rea.id + '&traintype=' + tickettraintype
                })
            }
            //终点站变为可编辑
            $("#adminTicket-add-ticketendstation").combobox({
                disabled: false,
                valueField: 'id',
                textField: 'text',
                method: 'GET',
                url: '/stationController/getEndStation?startstation=' + rea.id,
                onSelect: function (reb) {
                    //发车时间变为可编辑
                    $("#adminTicket-add-starttime").combobox({
                        disabled: false,
                        valueField: 'id',
                        textField: 'text',
                        method: 'GET',
                        url: '/stationController/getStartTime?startstation=' + rea.id + '&endstation=' + reb.id,
                        onSelect: function (rec) {
                            //列车类型变为可编辑
                            $("#adminTicket-add-tickettraintype").combobox({
                                disabled: false
                            })
                            //发送ajax获取该始终站所有信息
                            $.ajax({
                                type: "GET",
                                url: "/stationController/getStationBySelect",
                                data: {
                                    startstation: rea.id,
                                    endstation: reb.id,
                                    starttime: rec.id
                                },
                                dataType: "json",
                                success: function (response) {
                                    if (response.code == 200) {
                                        //把数据放入各个input
                                        $('#adminTicket-add-stationid').textbox('setValue', response.data.station.stationid);
                                        $('#adminTicket-add-ticketarrivetime').textbox('setValue', response.data.station.arrivetime);
                                        //历时变为只读
                                        $("#adminTicket-add-usetime").textbox({
                                            disabled: false,
                                            readonly: true,
                                            value: response.data.station.usetime
                                        })
                                        //站台距离（用来计算基础票价）
                                        distance = response.data.station.distance
                                    } else if (response.code == 100) {
                                        $.messager.alert('消息提醒', response.msg, 'error');
                                    }
                                }
                            });
                        }
                    })
                }
            })
        }
    })


    //根据始发站以及列车类型获取车次选项
    $("#adminTicket-add-tickettraintype").combobox({
        onSelect: function (rea) {
            if ($('#adminTicket-add-ticketstartstation').textbox('isValid')) {
                var ticketstartstation = $('#adminTicket-add-ticketstartstation').textbox('getValue')
                $("#adminTicket-add-tickettrainname").combobox({
                    disabled: false,
                    valueField: 'id',
                    textField: 'text',
                    method: 'GET',
                    url: '/trainController/getTrainNameByLocationAndTrainType?trainlocation=' + ticketstartstation + '&traintype=' + rea.label,
                    onSelect: function (reb) {
                        //发送ajax获取列车信息
                        $.ajax({
                            type: "GET",
                            url: "/trainController/getTrainByLocationAndNameAndType",
                            data: {
                                trainlocation: ticketstartstation,
                                traintype: rea.label,
                                trainname: reb.id
                            },
                            dataType: "json",
                            success: function (response) {
                                if (response.code == 200) {
                                    //把数据放入各个input
                                    $('#adminTicket-add-trainid').textbox('setValue', response.data.train.trainid);
                                    $('#adminTicket-add-specialseat').textbox('setValue', response.data.train.specialClassSeat);
                                    $('#adminTicket-add-firstseat').textbox('setValue', response.data.train.firstClassSeat);
                                    $('#adminTicket-add-secondseat').textbox('setValue', response.data.train.secondClassSeat);
                                    //基础票价可编辑
                                    $("#adminTicket-add-ticketprice").textbox({
                                        disabled: false,
                                        value: distance * response.data.train.trainprice
                                    })
                                } else if (response.code = 100) {
                                    $.messager.alert('消息提醒', response.msg, 'error');
                                }

                            }
                        });
                    }
                })
            }
        }
    })


    // 新增按钮点击事件
    $("#btn-adminTicket-add").click(function (e) {
        e.preventDefault();
        // 取消行选中
        $('#dg-adminTicket').datagrid('clearChecked');
        //清空输入框内容
        $("#adminTicket-add-stationid").textbox('clear');
        $("#adminTicket-add-trainid").textbox('clear');
        $("#adminTicket-add-ticketstartstation").textbox('clear');
        $("#adminTicket-add-ticketendstation").textbox('clear');
        $("#adminTicket-add-ticketendstation").combobox({
            disabled: true
        });
        $("#adminTicket-add-starttime").textbox('clear');
        $("#adminTicket-add-starttime").combobox({
            disabled: true
        });
        $("#adminTicket-add-usetime").textbox('clear');
        $("#adminTicket-add-usetime").textbox({
            disabled: true
        });
        $("#adminTicket-add-ticketarrivetime").textbox('clear');
        $("#adminTicket-add-tickettraintype").textbox('clear');
        $("#adminTicket-add-tickettraintype").combobox({
            disabled: true
        });
        $("#adminTicket-add-tickettrainname").textbox('clear');
        $("#adminTicket-add-tickettrainname").combobox({
            disabled: true
        });
        $("#adminTicket-add-specialseat").textbox('clear');
        $("#adminTicket-add-firstseat").textbox('clear');
        $("#adminTicket-add-secondseat").textbox('clear');
        $("#adminTicket-add-ticketprice").textbox('clear');
        $("#adminTicket-add-ticketprice").textbox({
            disabled: true
        });
        // 打开新增模态框
        $('#dlg-adminTicket-add').dialog('open');
    });

    // 新增车票确定按钮点击事件
    $('#btn-adminTicket-add-ok').click(function (e) {
        e.preventDefault();
        if ($('#ticket-form').form('validate')) { //校验输入
            //校验通过
            // 发送ajax新增车票
            $.ajax({
                type: "POST",
                url: "/ticketController/addTicketInfo",
                data: $("#ticket-form").serialize(),
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 关闭新增车票模态框
                        $('#dlg-adminTicket-add').dialog('close');
                        //重新加载车票列表
                        loadTicketInfo(lastPage, 10);
                        // 新增成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        // 关闭新增模态框
                        $('#dlg-adminTicket-add').dialog('close');
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
            $.messager.alert('消息提醒', "请把车票信息输入完整！", 'warning');
        }

    });


    //新增车票取消按钮点击事件
    $('#btn-adminTicket-add-cancel').click(function (e) {
        e.preventDefault();
        // 关闭新增模态框
        $('#dlg-adminTicket-add').dialog('close');
    });


    //删除按钮点击事件
    $('#btn-adminTicket-remove').click(function (e) {
        e.preventDefault();
        var row = $('#dg-adminTicket').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的车票信息！', 'info');
        } else {
            var page = $('#dg-adminTicket').datagrid('getPager').data("pagination").options.pageNumber; //获取删除行所在页数
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此车票吗？<br/>(删除车票将会影响用户订单信息)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/ticketController/deleteTicketInfo",
                        data: {
                            "ticketid": row.ticketid
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载车票信息列表
                                loadTicketInfo(page, 10);
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
    $('#btn-adminTicket-search').click(function (e) {
        e.preventDefault();
        var search_startstation = $('#adminTicket-search-startstation').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_endstation = $('#adminTicket-search-endstation').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_starttime = $('#adminTicket-search-starttime').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_arrivetime = $('#adminTicket-search-arrivetime').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        $.ajax({
            type: "GET",
            url: "/ticketController/searchTicketInfo",
            data: {
                "query_startstation": search_startstation,
                "query_endstation": search_endstation,
                "query_starttime": search_starttime,
                "query_arrivetime": search_arrivetime
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //显示查询到的车票信息
                    $('#dg-adminTicket').datagrid('loadData', response.data.searchTicketInfo);
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