<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/5/3
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!--订单管理 -->
<table id="dg-order" class="easyui-datagrid" title="我的订单" data-options="
                                        fit:true,
                                        iconCls: 'icon-order',
                                        singleSelect: true,
                                        pagination: true,
                                        rownumbers:true,
                                        striped:true,
                                        scrollbarSize:0,
                                        toolbar:'#tb-order'">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th data-options="field:'orderid',align:'center'" width="11%">订单号</th>
        <th data-options="field:'orderTrainname',align:'center'" width="7%">车次</th>
        <th data-options="field:'orderStartstation',align:'center'" width="8%">始发站</th>
        <th data-options="field:'orderEndstation',align:'center'" width="8%">终点站</th>
        <th data-options="field:'orderStarttime',align:'center'" width="11%">发车时间</th>
        <th data-options="field:'orderArrivetime',align:'center'" width="11%">预计到达时间</th>
        <th data-options="field:'orderSeattype',align:'center'" width="8%">座位类型</th>
        <th data-options="field:'orderCarriage',align:'center'" width="7%">车厢</th>
        <th data-options="field:'orderSeatlocation',align:'center',
                    formatter:function(data){return data+'号'}" width="8%">座位号
        </th>
        <th data-options="field:'ordertime',align:'center'" width="11%">下单时间</th>
        <th data-options="field:'status',align:'center',styler:cellStatus" width="6%">状态</th>
    </tr>
    </thead>
</table>

<div id="tb-order" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       id="btn-order-details">查看详细</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       id="btn-order-remove">删除记录</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-returnticket',plain:true"
       id="btn-order-return">退票</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-exchange',plain:true"
       id="btn-order-exchange">改签</a>
</div>
<!-- /订单管理 -->


<!-- 改签模态框 -->
<div id="dlg-order-exchange" class="easyui-dialog" title="车票改签" style="width:450px;height:240px;padding:2px;"
     data-options="
          iconCls: 'icon-exchange',
          buttons: '#dlg-exchange-buttons',
          modal:true,
          closed:true
      ">
    <table cellpadding="5">
        <tr>
            <td style="text-align: right;">订单号 :</td>
            <td><span id="exchange-orderid"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">车次 :</td>
            <td><span id="exchange-trainname"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">始发站 :</td>
            <td><span id="exchange-startstation"></span></td>
            <td style="text-align: right;">终点站 :</td>
            <td><span id="exchange-endstation"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">改签时间 :</td>
            <td><input class="easyui-combobox" data-options="required:true,valueField: 'id',textField: 'text'"
                       id="exchange-starttime"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">预计到达时间 :</td>
            <td><span id="exchange-arrivetime"></span></td>
        </tr>
    </table>
</div>
<!-- 模态框按钮 -->
<div id="dlg-exchange-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-exchange-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-exchange-cancel">取消</a>
</div>
<!-- /改签模态框 -->


<!-- 订单详细 模态框 -->
<div id="dlg-order-details" class="easyui-dialog" title="订单详细" style="width:490px;height:500px;padding:2px;"
     data-options="
          iconCls: 'icon-order',
          buttons: '#dlg-details-buttons',
          modal:true,
          closed:true
      ">
    <table cellpadding="5">
        <tr>
            <td style="text-align: right;">订单号 :</td>
            <td><span id="details-orderid"></span></td>
            <td style="text-align: right;">订单状态 :</td>
            <td><span id="details-status"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">用户ID :</td>
            <td><span id="details-userid"></span></td>
            <td style="text-align: right;">用户名 :</td>
            <td><span id="details-order_username"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">姓名 :</td>
            <td><span id="details-order_idcardname"></span></td>
            <td style="text-align: right;">身份证号 :</td>
            <td><span id="details-order_idcardnumber"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">始发站 :</td>
            <td><span id="details-order_startstation"></span></td>
            <td style="text-align: right;">终点站 :</td>
            <td><span id="details-order_endstation"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">车票ID :</td>
            <td><span id="details-ticketid"></span></td>
            <td style="text-align: right;">车次 :</td>
            <td><span id="details-order_trainname"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">发车时间 :</td>
            <td><span id="details-order_starttime"></span></td>
            <td style="text-align: right;" noWrap="noWrap">预计到达时间 :</td>
            <td><span id="details-order_arrivetime"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">订单金额 :</td>
            <td><span id="details-order_price"></span>元</td>
            <td style="text-align: right;">下单时间 :</td>
            <td><span id="details-ordertime"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">座位ID :</td>
            <td><span id="details-seatid"></span></td>
            <td style="text-align: right;">座位类型 :</td>
            <td><span id="details-order_seattype"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">所属车厢 :</td>
            <td><span id="details-order_carriage"></span>号</td>
            <td style="text-align: right;">座位号 :</td>
            <td><span id="details-order_seatlocation"></span></td>
        </tr>
        <tr>
            <td noWrap="noWrap">车票二维码 :</td>
            <td><img alt="车票二维码" width="150" height="150" id="details-qrcode">
            </td>
        </tr>
    </table>
</div>
<!-- 模态框按钮 -->
<div id="dlg-details-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-print' id="btn-details-download">打印车票</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-details-cancel">取消</a>
</div>
<!-- /订单详细 模态框 -->

<script>
    //单元格字体颜色
    function cellStatus(value, row, index) {
        if (value === '已支付') {
            return 'color:green;';
        } else {
            return 'color:red;';
        }
    }
</script>
<script type="text/javascript" src="/ssmTicketSystem/pages/order/js/order.js"></script>
