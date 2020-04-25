<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/4/24
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!-- 座位管理 -->
<table id="dg-seatinfo" class="easyui-datagrid" title="座位管理" data-options="
                                    fit:true,
                                    iconCls: 'icon-seat',
                                    singleSelect: true,
                                    pagination: true,
                                    rownumbers:true,
                                    striped:true,
                                    scrollbarSize:0,
                                    toolbar:'#tb-seatinfo'">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th data-options="field:'seatid',align:'center'" width="10%">座位 ID</th>
        <th field="trainid" align="center" hidden="true">所属列车 ID</th>
        <th data-options="field:'trainname',align:'center'" width="15%">所属列车</th>
        <th data-options="field:'seattype',align:'center'" width="20%">座位类型</th>
        <th data-options="field:'carriage',align:'center'" width="15%">车厢</th>
        <th data-options="field:'seatlocation',align:'center'" width="20%">座位号</th>
        <th data-options="field:'status',align:'center',styler:cellStyler,
                    formatter:function(data){return data==0?'未售出':'已售出'}" width="15%">状态
        </th>
    </tr>
    </thead>
</table>

<div id="tb-seatinfo" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       id="btn-seatinfo-add">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       id="btn-seatinfo-remove">删除</a>
    <input class="easyui-searchbox" data-options="prompt:'所属列车名/座位类型/座位号'" style="width:200px"
           id="btn-seatinfo-search">
</div>
<!-- /座位管理 -->


<!-- 新增座位模态框 -->
<div id="dlg-seatinfo-add" class="easyui-dialog" title="新增座位" style="width:300px;height:230px;padding:2px;"
     data-options="
          iconCls: 'icon-train',
          buttons: '#dlg-seatinfo-buttons',
          modal:true,
          closed:true
      ">
    <table cellpadding="5">
        <tr>
            <td style="text-align: right;">所属列车 :</td>
            <td><input class="easyui-combobox" data-options="required:true,
                                                                    valueField:'id',
                                                                    textField:'text',
                                                                    method:'GET',
                                                                    url:'/seatController/getTrainOfSeat'"
                       id="add-trainid"/></td>
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
                                                                            value: '二等座'}]" id="add-seattype"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">数量 :</td>
            <td><input class="easyui-textbox" type="text" id="add-number" data-options="required:true"
                       style="width: 50%;"/>&nbsp;&nbsp;席
            </td>
        </tr>
        <tr>
            <td style="text-align: right;">车厢 :</td>
            <td><input class="easyui-textbox" type="text" id="add-carriage"
                       data-options="required:true"/>&nbsp;&nbsp;号
            </td>
        </tr>
    </table>
</div>
<!-- 模态框按钮 -->
<div id="dlg-seatinfo-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-seatinfo-add-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-seatinfo-add-cancel">取消</a>
</div>
<!-- /新增座位模态框 -->


<script type="text/javascript">
    function cellStyler(value, row, index) {
        if (value == 1) {
            return 'color:red;';
        }
    }
</script>
<script type="text/javascript" src="/ssmTicketSystem/pages/train/js/seatinfo.js"></script>