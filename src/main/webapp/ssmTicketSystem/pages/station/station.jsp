<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/4/20
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!-- 始终站台管理 -->
<table id="dg-stationinfo" class="easyui-datagrid" title="始终站台管理" data-options="
                                    fit:true,
                                    iconCls: 'icon-station',
                                    singleSelect: true,
                                    pagination: true,
                                    rownumbers:true,
                                    striped:true,
                                    scrollbarSize:0,
                                    toolbar:'#tb-stationinfo'">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th data-options="field:'stationid',align:'center'" width="10%">始终站台 ID</th>
        <th data-options="field:'startstation',align:'center',editor:'textbox'" width="15%">始发站</th>
        <th data-options="field:'endstation',align:'center',editor:'textbox'" width="15%">终点站</th>
        <th data-options="field:'starttime',align:'center',editor:'datetimebox'" width="18%">发车时间</th>
        <th data-options="field:'usetime',align:'center',formatter:function(data){return parseInt(data/60)+'小时'+data%60+'分钟'},
                                    editor:{type:'textbox',options:{prompt:'请输入历时分钟数'}}" width="10%">历时
        </th>
        <th data-options="field:'arrivetime',align:'center'" width="18%">预计到达时间</th>
        <th data-options="field:'distance',align:'center',formatter:function(data){return data+'公里'},
                                    editor:{type:'textbox',options:{prompt:'请输入距离公里数'}}" width="10%">距离
        </th>
    </tr>
    </thead>
</table>

<div id="tb-stationinfo" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       id="btn-stationinfo-add">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       id="btn-stationinfo-edit">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       id="btn-stationinfo-remove">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
       id="btn-stationinfo-save">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
       id="btn-stationinfo-reject">撤销修改</a>
    <!-- 搜索 -->
    <span style="margin-left: 10px;">始发站 :</span>
    <input class="easyui-textbox" style="width:100px" id="stationinfo-search-startstation"/>
    <span style="margin-left: 5px;">终点站 :</span>
    <input class="easyui-textbox" style="width:100px" id="stationinfo-search-endstation"/>
    <span style="margin-left: 5px;">发车时间 :</span>
    <input class="easyui-datetimebox" style="width:150px" id="stationinfo-search-starttime"/>
    <span style="margin-left: 5px;">到达时间 :</span>
    <input class="easyui-datetimebox" style="width:150px" id="stationinfo-search-arrivetime"/>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
       id="btn-stationinfo-search" style="width: 70px;height: 25px;margin-left: 5px;">搜索</a>
    <!-- /搜索 -->
</div>
<!-- /始终站台管理 -->


<!-- 新增始终站台模态框 -->
<div id="dlg-stationinfo-add" class="easyui-dialog" title="新增始终站台" style="width:300px;height:260px;padding:2px;"
     data-options="
          iconCls: 'icon-station',
          buttons: '#dlg-stationinfo-buttons',
          modal:true,
          closed:true
      ">
    <table cellpadding="5">
        <tr>
            <td style="text-align: right;">始发站 :</td>
            <td><input class="easyui-textbox" type="text" data-options="required:true" id="add-startstation"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">终点站 :</td>
            <td><input class="easyui-textbox" type="text" data-options="required:true" id="add-endstation"/></td>
        </tr>
        <tr>
            <td style="text-align: right;">发车时间 :</td>
            <td><input class="easyui-datetimebox" data-options="required:true" id="add-starttime"/>
            </td>
        </tr>
        <tr>
            <td style="text-align: right;">历时 :</td>
            <td><input class="easyui-textbox" type="text" style="width: 50%;" id="add-usetime"
                       data-options="required:true"/>&nbsp;&nbsp;分钟
            </td>
        </tr>
        <tr>
            <td style="text-align: right;">距离 :</td>
            <td><input class="easyui-textbox" type="text" style="width: 50%;" id="add-distance"
                       data-options="required:true"/>&nbsp;&nbsp;公里
            </td>
        </tr>
    </table>
</div>
<!-- 模态框按钮 -->
<div id="dlg-stationinfo-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-stationinfo-add-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel'
       id="btn-stationinfo-add-cancel">取消</a>
</div>
<!-- /新增始终站台模态框 -->

<script type="text/javascript" src="/ssmTicketSystem/pages/station/js/station.js"></script>