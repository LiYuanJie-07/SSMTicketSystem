$(document).ready(function () {
    //刷新站台日期
    $.ajax({
        type: "GET",
        url: "/userTicketController/updateStationTime",
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                loadTicketInfoUser(1, 10);
            }
        }
    });

    //分页
    var pager = $('#dg-userTicket').datagrid('getPager');
    pager.pagination({
        pageNumber: 1,
        pageList: [10], // 可以设置每页记录条数的列表
        pageSize: 10,
        showPageList: false,
        onSelectPage: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadTicketInfoUser(pageNumber, pageSize);
            $(this).pagination('loaded');
        },
        onBeforeRefresh: function (pageNumber, pageSize) {
            $(this).pagination('loading');
            loadTicketInfoUser(pageNumber, pageSize);
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

    //获取所有车票信息
    function loadTicketInfoUser(pageNumber, pageSize) {
        $.ajax({
            type: "GET",
            url: "/userTicketController/getAllTicketInfoUser",
            data: {
                "page": pageNumber,
                "rows": pageSize
            },
            dataType: "json",
            success: function (response) {
                if (response.code == 200) {
                    //获取车票信息成功并显示
                    $('#dg-userTicket').datagrid('loadData', response.data.allTicketInfoUser);
                } else if (response.code == 100) {
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });
    }


    var row
    // 购买按钮点击事件
    $("#btn-userTicket-buy").click(function (e) {
        e.preventDefault();
        row = $('#dg-userTicket').datagrid('getSelected'); //获取当前选中的行
        if (row == null) { //判断当前是否选中行
            $.messager.alert('消息提醒', '请选中需要购买的车票！', 'info');
        } else {
            $("#order-startstation").text(row.ticketStartstation);
            $("#order-endstation").text(row.ticketEndstation);
            $("#order-starttime").text(row.ticketStarttime);
            $("#order-arrivetime").text(row.ticketArrivetime);
            $("#order-trainname").text(row.ticketTrainname);
            $("#order-traintype").text(row.ticketTraintype);
            //清空输入
            $("#order-seattype").textbox('clear');
            $("#order-seatlocation").textbox('clear');
            $("#order-price").text('');
            //打开模态框
            $('#dlg-userTicket-add').dialog('open');
        }
    });



    var ticket_seatid;
    var ticket_carriage;
    var ticket_price;
    //选择始发站触发方法
    $("#order-seattype").combobox({
        onSelect: function (rea) {
            var tickettype = $("#tickettype").text();
            if (rea.label === '商务座') {
                if (tickettype != '（成人票）') {
                    $("#order-price").text(((row.ticketprice + 200) * 0.8).toFixed(1) + ' 元');
                    ticket_price = ((row.ticketprice + 200) * 0.8).toFixed(1);
                } else {
                    $("#order-price").text((row.ticketprice + 200).toFixed(1) + ' 元');
                    ticket_price = (row.ticketprice + 200).toFixed(1);
                }
            } else if (rea.label === '一等座') {
                if (tickettype != '（成人票）') {
                    $("#order-price").text(((row.ticketprice + 100) * 0.8).toFixed(1) + ' 元');
                    ticket_price = ((row.ticketprice + 100) * 0.8).toFixed(1);
                } else {
                    $("#order-price").text((row.ticketprice + 100).toFixed(1) + ' 元');
                    ticket_price = (row.ticketprice + 100).toFixed(1);
                }
            } else {
                if (tickettype != '（成人票）') {
                    $("#order-price").text((row.ticketprice * 0.8).toFixed(1) + ' 元');
                    ticket_price = (row.ticketprice * 0.8).toFixed(1);
                } else {
                    $("#order-price").text((row.ticketprice).toFixed(1) + ' 元');
                    ticket_price = (row.ticketprice).toFixed(1);
                }
            }
            $("#order-seatlocation").combobox({
                disabled: false,
                valueField: 'id',
                textField: 'text',
                method: 'GET',
                url: '/userTicketController/getSeatLocationByTrainIdAndSeatType?trainid=' + row.trainid + '&seattype=' + rea.label,
                onSelect: function (reb) {
                    // 发送ajax获取座位信息
                    $.ajax({
                        type: "GET",
                        url: "/userTicketController/getSeatByTrainIdAndSeatTypeAndSeatLocation",
                        data: {
                            "trainid": row.trainid,
                            "seattype": rea.label,
                            "seatlocation": reb.id
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                ticket_seatid = response.data.seat.seatid;
                                ticket_carriage = response.data.seat.carriage;
                            }
                        }
                    });
                }
            })
        }
    })

    //验证登录密码模态框 确定按钮点击事件
    $('#btn-ticketCheckPwd-ok').click(function (e) {
        e.preventDefault();
        var page = $('#dg-userTicket').datagrid('getPager').data("pagination").options.pageNumber; //获取当前所在页数
        //获取输入的登陆密码
        var checkPwd = $('#userTicket-checkPwd').textbox('getValue');
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
                    // 校验通过 新增订单
                    var ticketid = row.ticketid; //订单列车id
                    var order_trainname = row.ticketTrainname; //订单车次
                    var order_startstation = row.ticketStartstation; //订单始发站
                    var order_endstation = row.ticketEndstation; //订单终点站
                    var order_starttime = row.ticketStarttime; //订单发车时间
                    var order_arrivetime = row.ticketArrivetime; //订单预计到达时间
                    var order_price = ticket_price; //订单价格
                    var seatid = ticket_seatid; //订单座位id
                    var order_carriage = ticket_carriage; //订单座位车厢
                    var order_seattype = $('#order-seattype').textbox('getValue'); //订单座位类型
                    var order_seatlocation = $('#order-seatlocation').textbox('getValue'); //订单座位号
                    // 发送ajax新增订单
                    $.ajax({
                        type: "POST",
                        url: "/orderController/addOrderInfo",
                        data: {
                            "ticketid": ticketid,
                            "orderTrainname": order_trainname,
                            "orderStartstation": order_startstation,
                            "orderEndstation": order_endstation,
                            "orderStarttime": order_starttime,
                            "orderArrivetime": order_arrivetime,
                            "orderPrice": order_price,
                            "seatid": seatid,
                            "orderCarriage": order_carriage,
                            "orderSeattype": order_seattype,
                            "orderSeatlocation": order_seatlocation
                        },
                        dataType: "json",
                        success: function (response) {
                            if (response.code == 200) {
                                //关闭验证登陆密码模态框
                                $('#dlg-ticketCheckPwd').dialog('close');
                                //关闭购票模态框
                                $('#dlg-userTicket-add').dialog('close');
                                //重新加载车票列表
                                loadTicketInfoUser(page, 10);
                                // 购票成功提示信息
                                $.messager.show({
                                    title: '消息提醒',
                                    msg: response.msg,
                                    timeout: 2000,
                                    showType: 'slide'
                                });
                            } else if (response.code == 100) {
                                //关闭验证登陆密码模态框
                                $('#dlg-ticketCheckPwd').dialog('close');
                                //关闭购票模态框
                                $('#dlg-userTicket-add').dialog('close');
                                //重新加载车票列表
                                loadTicketInfoUser(page, 10);
                                // 购票失败提示信息
                                $.messager.show({
                                    title: '消息提醒',
                                    msg: response.msg,
                                    timeout: 2000,
                                    showType: 'slide'
                                });
                            }
                        }
                    });
                } else if (response.code == 100) {
                    //登录密码错误，弹出提示信息
                    $.messager.alert('消息提醒', response.msg, 'error');
                }
            }
        });

    });


    //验证登陆密码模态框 取消按钮点击事件
    $('#btn-ticketCheckPwd-cancel').click(function (e) {
        e.preventDefault();
        //关闭验证登陆密码模态框
        $('#dlg-ticketCheckPwd').dialog('close');
    });

    // 车票购买确定按钮点击事件
    $('#btn-userTicket-add-ok').click(function (e) {
        e.preventDefault();
        if ($('#order-seattype').textbox('isValid') && $('#order-seatlocation').textbox('isValid')) { //校验输入
            //清空 验证登陆密码模态框 输入的登陆密码
            $('#userTicket-checkPwd').textbox({});
            $('#userTicket-checkPwd').textbox('clear');
            //打开验证登陆密码模态框
            $('#dlg-ticketCheckPwd').dialog('open');
        } else { //校验不通过
            $.messager.alert('消息提醒', "请选择座位信息！", 'warning');
        }

    });


    //购买车票取消按钮点击事件
    $('#btn-userTicket-add-cancel').click(function (e) {
        e.preventDefault();
        // 关闭购票模态框
        $('#dlg-userTicket-add').dialog('close');
    });


    //搜索框
    $('#btn-userTicket-search').click(function (e) {
        e.preventDefault();
        var search_startstation = $('#userTicket-search-startstation').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_endstation = $('#userTicket-search-endstation').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_starttime = $('#userTicket-search-starttime').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        var search_arrivetime = $('#userTicket-search-arrivetime').textbox('getValue').replace(/(^\s*)|(\s*$)/g, "");
        $.ajax({
            type: "GET",
            url: "/userTicketController/searchTicketInfo",
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
                    $('#dg-userTicket').datagrid('loadData', response.data.searchTicketInfo);
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