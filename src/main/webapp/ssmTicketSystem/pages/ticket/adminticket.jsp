<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/4/26
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!-- 车票管理 -->
<table id="dg-adminTicket" class="easyui-datagrid" title="车票管理" data-options="
                                    fit:true,
                                    iconCls: 'icon-ticket',
                                    singleSelect: true,
                                    pagination: true,
                                    rownumbers:true,
                                    striped:true,
                                    scrollbarSize:0,
                                    toolbar:'#tb-adminTicket'">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th field="stationid" align="center" hidden="true">所属站台 ID</th>
        <th field="trainid" align="center" hidden="true">所属列车 ID</th>
        <th data-options="field:'ticketid',align:'center'" width="5%">车票 ID</th>
        <th data-options="field:'ticketStartstation',align:'center'" width="8%">始发站</th>
        <th data-options="field:'ticketEndstation',align:'center'" width="8%">终点站</th>
        <th data-options="field:'ticketStarttime',align:'center'" width="11%">发车时间</th>
        <th data-options="field:'ticketUsetime',align:'center',formatter:function(data){return parseInt(data/60)+'小时'+data%60+'分钟'},
                    editor:{type:'textbox',options:{prompt:'请输入历时分钟数'}}" width="8%">历时
        </th>
        <th data-options="field:'ticketArrivetime',align:'center'" width="11%">预计到达时间</th>
        <th data-options="field:'ticketTrainname',align:'center'" width="8%">车次</th>
        <th data-options="field:'ticketTraintype',align:'center'" width="8%">列车类型</th>
        <th data-options="field:'ticketprice',align:'center',formatter:function(data){return data+'元'}"
            width="8%">基础票价
        </th>
        <th data-options="field:'specialSeatNumber',align:'center'" width="7%">商务座数量</th>
        <th data-options="field:'firstSeatNumber',align:'center'" width="7%">一等座数量</th>
        <th data-options="field:'secondSeatNumber',align:'center'" width="7%">二等座数量</th>
    </tr>
    </thead>
</table>

<div id="tb-adminTicket" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       id="btn-adminTicket-add">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       id="btn-adminTicket-remove">删除</a>
    <!-- 搜索 -->
    <span>始发站 :</span>
    <input class="easyui-textbox" style="width:100px" id="adminTicket-search-startstation"/>
    <span style="margin-left: 5px;">终点站 :</span>
    <input class="easyui-textbox" style="width:100px" id="adminTicket-search-endstation"/>
    <span style="margin-left: 5px;">发车时间 :</span>
    <input class="easyui-datetimebox" style="width:150px" id="adminTicket-search-starttime"/>
    <span style="margin-left: 5px;">到达时间 :</span>
    <input class="easyui-datetimebox" style="width:150px" id="adminTicket-search-arrivetime"/>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       id="btn-adminTicket-search" style="width: 70px;height: 25px;margin-left: 5px;">搜索</a>
    <!-- /搜索 -->
</div>
<!-- /车票管理 -->


<!-- 新增车票模态框 -->
<div id="dlg-adminTicket-add" class="easyui-dialog" title="新增车票" style="width:300px;height:330px;padding:2px;"
     data-options="
          iconCls: 'icon-ticket',
          buttons: '#dlg-adminTicket-add-buttons',
          modal:true,
          closed:true
      ">
    <form id="ticket-form">
        <table cellpadding="5">
            <tr style="display: none;">
                <td style="text-align: right;">站台 ID :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-stationid" name="stationid"
                           data-options="required:true"/></td>
            </tr>
            <tr style="display: none;">
                <td style="text-align: right;">列车 ID :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-trainid" name="trainid"
                           data-options="required:true"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">始发站 :</td>
                <td><input class="easyui-combobox"
                           data-options="required:true,valueField:'id',textField:'text',method:'GET',url:'/stationController/getAllStartStation'"
                           style="width: 80%;" id="adminTicket-add-ticketstartstation" name="ticketStartstation"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">终点站 :</td>
                <td><input class="easyui-combobox"
                           data-options="disabled:true,required:true,valueField:'id',textField:'text'"
                           style="width: 80%;" id="adminTicket-add-ticketendstation" name="ticketEndstation"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">发车时间 :</td>
                <td><input class="easyui-combobox"
                           data-options="disabled:true,required:true,valueField:'id',textField:'text'"
                           id="adminTicket-add-starttime" name="ticketStarttime"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">历时 :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-usetime" style="width: 50%;"
                           name="ticketUsetime" data-options="disabled:true,required:true"/>&nbsp;&nbsp;分钟
                </td>
            </tr>
            <tr style="display: none;">
                <td style="text-align: right;">预计到达时间 :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-ticketarrivetime" name="ticketArrivetime"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">列车类型 :</td>
                <td><input class="easyui-combobox" data-options="required:true,disabled:true,
                                                                     valueField: 'label',
                                                                     textField: 'value',
                                                                     data: [{
                                                                           label: '高铁',
                                                                           value: '高铁'
                                                                        },{
                                                                            label: '动车',
                                                                            value: '动车'}]" style="width: 50%;"
                           id="adminTicket-add-tickettraintype" name="ticketTraintype"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">车次 :</td>
                <td><input class="easyui-combobox"
                           data-options="disabled:true,required:true,valueField:'id',textField:'text'"
                           style="width: 80%;" id="adminTicket-add-tickettrainname" name="ticketTrainname"/></td>
            </tr>
            <tr style="display: none;">
                <td style="text-align: right;">商务座数量 :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-specialseat" name="specialSeatNumber"
                           data-options="required:true"/>
                </td>
            </tr>
            <tr style="display: none;">
                <td style="text-align: right;">一等座数量 :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-firstseat" name="firstSeatNumber"
                           data-options="required:true"/></td>
            </tr>
            <tr style="display: none;">
                <td style="text-align: right;">二等座数量 :</td>
                <td><input class="easyui-textbox" id="adminTicket-add-secondseat" name="secondSeatNumber"
                           data-options="required:true"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">基础票价 :</td>
                <td><input class="easyui-textbox" type="text" style="width: 50%;" id="adminTicket-add-ticketprice"
                           name="ticketprice" data-options="disabled:true,required:true"/>&nbsp;&nbsp;元
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- 模态框按钮 -->
<div id="dlg-adminTicket-add-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-adminTicket-add-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel'
       id="btn-adminTicket-add-cancel">取消</a>
</div>
<!-- /新增车票模态框 -->

<script type="text/javascript" src="/ssmTicketSystem/pages/ticket/js/adminticket.js"></script>
