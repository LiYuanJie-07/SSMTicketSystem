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

});