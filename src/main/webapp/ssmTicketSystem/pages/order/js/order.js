$(document).ready(function () {

    //分页
    var pager = $('#dg-order').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageList: [10], // 可以设置每页记录条数的列表
        pageSize: 10,
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadOrderInfo(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadOrderInfo(pageNumber, pageSize);
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


    //获取所有始终站信息
    function loadOrderInfo(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/orderController/getAllOrderInfo",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取始终站台信息成功并显示
                    $('#dg-order').datagrid('loadData', response.data.allOrderInfo);
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
    }

    loadOrderInfo(1, 10);

    var row; //选中行
    var newTicketId; //改签后的新车票信息
    // 改签按钮点击事件
    $("#btn-order-exchange").click(function (e) {
        e.preventDefault();
        row = $('#dg-order').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //没有选中行
            $.messager.alert('消息提醒', '请选中需要改签的订单！', 'info');
        } else {
            if (row.status === '已过期') { //已过期订单无法改签
                $.messager.alert('消息提醒', '已过期订单无法办理改签！', 'error');
            } else if (row.status === '已退票') { //已退票订单无法改签
                $.messager.alert('消息提醒', '已退票订单无法办理改签！', 'error');
            } else { //普通已支付订单可办理改签
                $("#exchange-orderid").text(row.orderid);
                $("#exchange-trainname").text(row.orderTrainname);
                $("#exchange-startstation").text(row.orderStartstation);
                $("#exchange-endstation").text(row.orderEndstation);
                $("#exchange-starttime").combobox({
                    valueField: 'id',
                    textField: 'text',
                    method: 'GET',
                    url: '/ticketController/getStartTimeByStation?startstation=' + row.orderStartstation + '&endstation=' + row.orderEndstation,
                    onSelect: function (rea) {
                        // 发送ajax获取 预计到达时间
                        $.ajax({
                            type: "GET",
                            url: "/ticketController/getNewTicket",
                            data: {
                                "startstation": row.orderStartstation,
                                "endstation": row.orderEndstation,
                                "starttime": rea.id
                            },
                            dataType: "json",
                            success: function (response) {
                                if (response.code == 200) {
                                    $("#exchange-arrivetime").text(response.data.ticket.ticketArrivetime);
                                    newTicketId = response.data.ticket.ticketid;
                                }
                            }
                        });
                    }
                })
                //清空改签输入框内容
                $('#exchange-starttime').textbox('clear');
                $("#exchange-arrivetime").text("");
                // 打开新增模态框
                $('#dlg-order-exchange').dialog('open');
            }
        }
    });


    // 改签确定按钮点击事件
    $('#btn-exchange-ok').click(function (e) {
        e.preventDefault();
        var page = $('#dg-order').datagrid('getPager').data("pagination").options.pageNumber; //获取改签行所在页数
        if ($('#exchange-starttime').textbox('isValid')) { //校验输入
            row = $('#dg-order').datagrid('getSelected'); //获取当前选中的行
            // 发送ajax新增始终站台
            $.ajax({
                type: "POST",
                url: "/orderController/exchangeOrderInfo",
                data: {
                    "orderid": row.orderid,
                    "newTicketId": newTicketId
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        // 关闭新改签模态框
                        $('#dlg-order-exchange').dialog('close');
                        //重新加载订单列表
                        loadOrderInfo(page, 10);
                        // 改签成功提示信息
                        $.messager.show({
                            title: '消息提醒',
                            msg: response.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });
                    } else if (response.code == 100) {
                        // 关闭新增模态框
                        $('#dlg-order-exchange').dialog('close');
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
            $.messager.alert('消息提醒', "请选择改签时间！", 'warning');
        }

    });


    //改签取消按钮点击事件
    $('#btn-exchange-cancel').click(function (e) {
        e.preventDefault();
        // 关闭改签模态框
        $('#dlg-order-exchange').dialog('close');
    });

    //删除按钮点击事件
    $('#btn-order-remove').click(function (e) {
        e.preventDefault();
        row = $('#dg-order').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要删除的订单记录！', 'info');
        } else {
            var page = $('#dg-order').datagrid('getPager').data("pagination").options.pageNumber; //获取删除行所在页数
            //是否确定删除
            $.messager.confirm('警告', '你确定要删除此订单记录吗？<br/>(删除后无法恢复)', function (r) {
                if (r) { //点击确定的回调函数
                    // 发送删除ajax
                    $.ajax({
                        type: "GET",
                        url: "/orderController/deleteOrderInfo",
                        data: {
                            "orderid": row.orderid,
                            "status": row.status
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //重新加载订单列表
                                loadOrderInfo(page, 10);
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


    //退票按钮点击事件
    $('#btn-order-return').click(function (e) {
        e.preventDefault();
        row = $('#dg-order').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //没有选中行
            $.messager.alert('消息提醒', '请选择需要办理退票的订单！', 'info');
        } else {
            if (row.status === '已过期') { //已过期订单无法退票
                $.messager.alert('消息提醒', '已过期订单无法办理退票！', 'error');
            } else if (row.status === '已退票') { //已退票订单无法再次退票
                $.messager.alert('消息提醒', '此订单已办理退票！', 'warning');
            } else { //普通已支付订单可办理退票
                //是否确定退票
                $.messager.confirm('警告', '你确定要为此订单办理退票吗？<br/>(退票后需重新购买)', function (r) {
                    if (r) { //点击确定的回调函数
                        var page = $('#dg-order').datagrid('getPager').data("pagination").options.pageNumber; //获取退票行所在页数
                        $.ajax({
                            type: "POST",
                            url: "/orderController/returnOrder",
                            data: {
                                "orderid": row.orderid
                            },
                            dataType: "json",
                            success: function (response) {
                                if (response.code == 200) {
                                    //重新加载订单列表
                                    loadOrderInfo(page, 10);
                                    // 退票成功提示信息
                                    $.messager.show({
                                        title: '消息提醒',
                                        msg: response.msg,
                                        timeout: 2000,
                                        showType: 'slide'
                                    });
                                } else if (response.code == 100) {
                                    // 退票失败提示信息
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
        }

    });

    //查看详细按钮点击事件
    $('#btn-order-details').click(function (e) {
        e.preventDefault();
        row = $('#dg-order').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要查看订单记录！', 'info');
        } else {
            $.ajax({
                type: "GET",
                url: "/orderController/getOrderDetails",
                data: {
                    "orderid": row.orderid
                },
                dataType: "json",
                success: function (response) {
                    if (response.code == 200) {
                        $("#details-orderid").text(response.data.orderDetails.orderid);
                        $("#details-status").text(response.data.orderDetails.status);
                        $("#details-userid").text(response.data.orderDetails.userid);
                        $("#details-order_username").text(response.data.orderDetails.orderUsername);
                        $("#details-order_idcardname").text(response.data.orderDetails.orderIdcardname);
                        $("#details-order_idcardnumber").text(response.data.orderDetails.orderIdcardnumber);
                        $("#details-order_startstation").text(response.data.orderDetails.orderStartstation);
                        $("#details-order_endstation").text(response.data.orderDetails.orderEndstation);
                        $("#details-ticketid").text(response.data.orderDetails.ticketid);
                        $("#details-order_trainname").text(response.data.orderDetails.orderTrainname);
                        $("#details-order_starttime").text(response.data.orderDetails.orderStarttime);
                        $("#details-order_arrivetime").text(response.data.orderDetails.orderArrivetime);
                        $("#details-order_price").text(response.data.orderDetails.orderPrice);
                        $("#details-ordertime").text(response.data.orderDetails.ordertime);
                        $("#details-seatid").text(response.data.orderDetails.seatid);
                        $("#details-order_seattype").text(response.data.orderDetails.orderSeattype);
                        $("#details-order_carriage").text(response.data.orderDetails.orderCarriage);
                        $("#details-order_seatlocation").text(response.data.orderDetails.orderSeatlocation);
                        //设置二维码图片
                        $("#details-qrcode").attr("src", "/ssmTicketSystem/static/images/qrcode/" +
                            response.data.orderDetails.orderUsername + "/" + response.data.orderDetails.orderid + ".jpg");
                        // 打开详细模态框
                        $('#dlg-order-details').dialog('open');

                    }
                }
            });
        }
    });


    //查看详细 取消按钮点击事件
    $('#btn-details-cancel').click(function (e) {
        e.preventDefault();
        // 关闭详细模态框
        $('#dlg-order-details').dialog('close');
    });


    //打印车票按钮点击事件
    $('#btn-details-download').click(function (e) {
        e.preventDefault();
        // 下载文件不能用ajax
        window.location.href = "/orderController/downLoadOrder?orderid=" + $("#details-orderid").text();
    });


});