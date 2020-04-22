<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/4/18
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!-- 列车管理 -->
<table id="dg-traininfo" class="easyui-datagrid" title="列车管理" data-options="
                                fit:true,
                                iconCls: 'icon-train',
                                singleSelect: true,
                                pagination: true,
                                rownumbers:true,
                                striped:true,
                                scrollbarSize:0,
                                toolbar:'#tb-traininfo'">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th data-options="field:'trainid',align:'center'" width="10%">列车 ID</th>
        <th data-options="field:'trainname',align:'center',editor:'textbox'" width="11%">列车名</th>
        <th data-options="field:'traintype',align:'center',
                                        editor:{  type:'combobox',
                                                  options:{
                                                    valueField: 'label',
                                                    textField: 'value',
                                                    data: [{
                                                            label: '高铁',
                                                            value: '高铁'
                                                        },{
                                                            label: '动车',
                                                            value: '动车'}]
                                                        }
                                                }" width="15%">列车类型
        </th>
        <th data-options="field:'trainlocation',align:'center',
                                        editor:{  type:'combobox',
                                                  options:{
                                                    valueField:'id',
                                                    textField:'text',
                                                    method:'GET',
                                                    url:'/trainController/getTrainLocation'
                                                        }
                                                }" width="20%">初始站
        </th>
        <th data-options="field:'trainprice',align:'center',editor:'textbox'" width="10%">每公里价格(元)</th>
        <th data-options="field:'specialClassSeat',align:'center'" width="10%">商务座数量</th>
        <th data-options="field:'firstClassSeat',align:'center'" width="10%">一等座数量</th>
        <th data-options="field:'secondClassSeat',align:'center'" width="10%">二等座数量</th>
    </tr>
    </thead>
</table>

<div id="tb-traininfo" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       id="btn-traininfo-add">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       id="btn-traininfo-edit">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       id="btn-traininfo-remove">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
       id="btn-traininfo-save">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
       id="btn-traininfo-reject">撤销修改</a>
    <input class="easyui-searchbox" data-options="prompt:'列车名/列车类型/初始站'" style="width:200px" id="btn-traininfo-search">
</div>
<!-- /列车管理 -->


<!-- 新增列车模态框 -->
<div id="dlg-traininfo-add" class="easyui-dialog" title="新增列车" style="width:300px;height:230px;padding:2px;"
     data-options="
      iconCls: 'icon-train',
      buttons: '#dlg-traininfo-buttons',
      modal:true,
      closed:true
  ">
    <table cellpadding="5">
        <tr>
            <td style="text-align: right;">列车类型 :</td>
            <td><input class="easyui-combobox" data-options="required:true,
                                                                 valueField: 'label',
                                                                 textField: 'value',
                                                                 data: [{
                                                                       label: '高铁',
                                                                       value: '高铁'
                                                                    },{
                                                                        label: '动车',
                                                                        value: '动车'}]" style="width: 50%;"
                       id="add-traintype"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">列车名称 :</td>
            <td><input class="easyui-textbox" type="text" data-options="required:true" id="add-trainname"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">初始站 :</td>
            <td><input class="easyui-combobox" id="add-trainlocation"
                       data-options="required:true,valueField:'id',textField:'text',method:'GET',url:'/trainController/getTrainLocation'"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;">每公里价格 :</td>
            <td><input class="easyui-textbox" type="text" style="width: 50%;" id="add-trainprice"
                       data-options="required:true"/>&nbsp;&nbsp;元
            </td>
        </tr>
    </table>
</div>
<!-- 模态框按钮 -->
<div id="dlg-traininfo-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-traininfo-add-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel'
       id="btn-traininfo-add-cancel">取消</a>
</div>
<!-- /新增列车模态框 -->

<script type="text/javascript" src="/ssmTicketSystem/pages/train/js/traininfo.js"></script>