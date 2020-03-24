$(document).ready(function () {
    //添加新的Tab页
    $("#navmenu").on("click", "a[data-url]", function (e) {
        e.preventDefault();
        var tabTitle = $(this).text(); //获取菜单标题
        var tabUrl = $(this).data("url"); //获取菜单url

        if ($("#tabs").tabs("exists", tabTitle)) { //判断该Tab页是否已经存在
            //tab页已存在，选中该tab页
            $("#tabs").tabs("select", tabTitle);
        } else {
            //tab页不存在，添加该tab页
            $("#tabs").tabs("add", {
                title: tabTitle,
                href: tabUrl,
                closable: true
            });
        }
        $("#navmenu .active").removeClass("active");
        $(this).parent().addClass("active");
    });

    //解决闪屏的问题
    window.setTimeout(function () {
        $("#layout").css("visibility", "visible");
    }, 800);


    // 获取公告并显示
    $.ajax({
        type: "GET",
        url: "/noticeController/getAllNotice",
        dataType: "json",
        success: function (response) {
            if (response.code == 200) {
                //显示公告
                $.each(response.data.notices, function (index, notice) {
                    $("#notices").accordion('add', {
                        title: notice.noticetitle,
                        iconCls: "icon-tip",
                        content: "<ul class='notice-list'><li><span class='date'>" +
                            notice.noticetime + "</span><span style='display:inline-block;'>" + notice.noticetext + "</span></li></ul>",
                        selected: true
                    });
                });
            }
        }
    });


    // 点击刷新更新公告内容
    $('#notice-refresh').panel({
        tools: [{
            iconCls: 'icon-reload',
            handler: function () {
                // 发送ajax获取所有公告
                $.ajax({
                    type: "GET",
                    url: "/noticeController/getAllNotice",
                    dataType: "json",
                    success: function (response) {
                        if (response.code == 200) {
                            // 清空公告
                            clearNotice();
                            //显示公告
                            $.each(response.data.notices, function (index, notice) {
                                $("#notices").accordion('add', {
                                    title: notice.noticetitle,
                                    iconCls: "icon-tip",
                                    content: "<ul class='notice-list'><li><span class='date'>" +
                                        notice.noticetime + "</span><span style='display:inline-block;'>" + notice.noticetext + "</span></li></ul>",
                                    selected: true
                                });
                            });
                            // 提示信息
                            $.messager.show({
                                title: '消息提醒',
                                msg: response.msg,
                                timeout: 2000,
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
        }]
    });

    //清空公告方法
    function clearNotice() {
        var noticeLength = $("#notices").accordion('panels').length
        for (var i = 0; i < noticeLength; i++) {
            $("#notices").accordion('remove', 0);
        }

    }


});