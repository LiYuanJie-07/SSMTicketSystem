<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/5/2
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!-- 售票大厅 -->
<table id="dg-userTicket" class="easyui-datagrid" title="售票大厅" data-options="
                                    fit:true,
                                    iconCls: 'icon-buyticket',
                                    singleSelect: true,
                                    pagination: true,
                                    rownumbers:true,
                                    striped:true,
                                    scrollbarSize:0,
                                    toolbar:'#tb-userTicket'">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th field="stationid" align="center" hidden="true">所属站台 ID</th>
        <th field="trainid" align="center" hidden="true">所属列车 ID</th>
        <th data-options="field:'ticketid',align:'center'" width="5%">车票 ID</th>
        <th data-options="field:'ticketStartstation',align:'center'" width="8%">始发站</th>
        <th data-options="field:'ticketEndstation',align:'center'" width="8%">终点站</th>
        <th data-options="field:'ticketStarttime',align:'center'" width="11%">发车时间</th>
        <th data-options="field:'ticketUsetime',align:'center',formatter:function(data){return parseInt(data/60)+'小时'+data%60+'分钟'}"
            width="8%">历时
        </th>
        <th data-options="field:'ticketArrivetime',align:'center'" width="11%">预计到达时间</th>
        <th data-options="field:'ticketTrainname',align:'center'" width="8%">车次</th>
        <th data-options="field:'ticketTraintype',align:'center'" width="8%">列车类型</th>
        <th data-options="field:'ticketprice',align:'center',formatter:function(data){return data+'元'}"
            width="8%">基础票价
        </th>
        <th data-options="field:'specialSeatNumber',align:'center',styler:cellStyler,
                formatter:function(data){return data==0?'售罄':data}" width="7%">商务座数量
        </th>
        <th data-options="field:'firstSeatNumber',align:'center',styler:cellStyler,
                formatter:function(data){return data==0?'售罄':data}" width="7%">一等座数量
        </th>
        <th data-options="field:'secondSeatNumber',align:'center',styler:cellStyler,
                formatter:function(data){return data==0?'售罄':data}" width="7%">二等座数量
        </th>
    </tr>
    </thead>
</table>

<div id="tb-userTicket" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-buy',plain:true"
       id="btn-userTicket-buy">购买</a>
    <!-- 搜索 -->
    <span>始发站 :</span>
    <input class="easyui-textbox" style="width:100px" id="userTicket-search-startstation"/>
    <span style="margin-left: 5px;">终点站 :</span>
    <input class="easyui-textbox" style="width:100px" id="userTicket-search-endstation"/>
    <span style="margin-left: 5px;">发车时间 :</span>
    <input class="easyui-datetimebox" style="width:150px" id="userTicket-search-starttime"/>
    <span style="margin-left: 5px;">到达时间 :</span>
    <input class="easyui-datetimebox" style="width:150px" id="userTicket-search-arrivetime"/>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       id="btn-userTicket-search" style="width: 70px;height: 25px;margin-left: 5px;">搜索</a>
    <!-- /搜索 -->
</div>
<!-- /售票大厅 -->


<!-- 购买车票模态框 -->
<div id="dlg-userTicket-add" class="easyui-dialog" title="车票购买" style="width:450px;height:345px;padding:2px;"
     data-options="
          iconCls: 'icon-buy',
          buttons: '#dlg-userTicket-add-buttons',
          modal:true,
          closed:true
      ">
    <table cellpadding="5">
        <tr>
            <td style="text-align: right;">用户名 :</td>
            <td>${sessionScope.user.username}</td>
        </tr>
        <tr>
            <td style="text-align: right;">姓名 :</td>
            <td>${sessionScope.user.idcardname}</td>
            <td style="text-align: right;">身份证号 :</td>
            <td>${sessionScope.user.idcardnumber}</td>
        </tr>
        <tr>
            <td style="text-align: right;">始发站 :</td>
            <td><span id="order-startstation"></span></td>
            <td style="text-align: right;">终点站 :</td>
            <td><span id="order-endstation"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">发车时间 :</td>
            <td><span id="order-starttime"></span></td>
            <td style="text-align: right;">预计到达时间 :</td>
            <td><span id="order-arrivetime"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">车次 :</td>
            <td><span id="order-trainname"></span></td>

        </tr>
        <tr>
            <td style="text-align: right;">列车类型 :</td>
            <td><span id="order-traintype"></span></td>
        </tr>
        <tr>
            <td style="text-align: right;">座位类型 :</td>
            <td><input class="easyui-combobox" data-options="required:true,
                                                                     valueField: 'label',
                                                                     textField: 'value',
                                                                     data: [{
                                                                           label: '商务座',
                                                                           value: '商务座'
                                                                        },{
                                                                            label: '一等座',
                                                                            value: '一等座'
                                                                        },{
                                                                            label: '二等座',
                                                                            value: '二等座'}]" style="width: 80%;"
                       id="order-seattype"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">座位号 :</td>
            <td><input class="easyui-combobox"
                       data-options="required:true,disabled:true,valueField:'id',textField:'text'" style="width: 80%;"
                       id="order-seatlocation"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">票价 :</td>
            <td><span id="order-price"></span><span id="tickettype">（${sessionScope.user.type}票）</span>
            </td>
        </tr>
    </table>
</div>
<!-- 模态框按钮 -->
<div id="dlg-userTicket-add-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-userTicket-add-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel'
       id="btn-userTicket-add-cancel">取消</a>
</div>
<!-- /购买车票模态框 -->


<!-- 确认登陆密码模态框 -->
<div id="dlg-ticketCheckPwd" class="easyui-dialog" title="验证登陆密码" style="width:320px;height:130px;" data-options="
        iconCls: 'icon-lock',
        buttons: '#dlg-ticketCheckPwd-buttons',
        modal:true,
        closed:true
    ">
    <!-- 确认登录密码 -->
    <div style="margin-left: 20px;">
        <span style="font-size: 12px;">登陆密码 : </span>
        <input type="text" class="easyui-textbox" style="width: 200px" id="userTicket-checkPwd"
               data-options="prompt:'请输入登录密码',events:{focus: function(){ easyuitextfocus($(this)); },blur: function(){ easyuitextblur($(this)); }}">
    </div>
</div>

<!-- 模态框按钮 -->
<div id="dlg-ticketCheckPwd-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-ticketCheckPwd-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel'
       id="btn-ticketCheckPwd-cancel">取消</a>
</div>
<!-- /确认登陆密码模态框 -->

<script>
    //密码框显示bug
    function easyuitextfocus(obj) {
        obj[0].type = 'password';
    }

    function easyuitextblur(obj) {
        if (obj[0].value == "") {
            obj[0].type = 'text';
        }
    }

    //单元格字体颜色
    function cellStyler(value, row, index) {
        if (value == 0) {
            return 'color:red;';
        }
    }
</script>
<script type="text/javascript" src="/ssmTicketSystem/pages/ticket/js/userticket.js"></script>
