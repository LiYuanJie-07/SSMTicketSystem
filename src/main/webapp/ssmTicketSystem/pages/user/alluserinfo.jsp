<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/4/2
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .datagrid-btable tr {
        height: 46px;
    }
</style>
<!-- 用户管理 -->
<table id="dg-alluserinfo" class="easyui-datagrid" title="用户管理" data-options="
                        fit:true,
                        iconCls:'icon-alluserinfo',
                        singleSelect: true,
                        pagination: true,
                        rownumbers:true,
                        striped:true,
                        scrollbarSize:0,
                        toolbar:'#tb-alluserinfo'
        ">
    <thead>
    <tr>
        <th field="" checkbox="true" align="center"></th>
        <th data-options="field:'userid',align:'center'" width="5%">用户 ID</th>
        <th data-options="field:'username',align:'center',editor:'textbox'" width="6%">用户名</th>
        <th data-options="field:'password',align:'center',editor:'textbox'" width="20%">密码</th>
        <th data-options="field:'email',align:'center',editor:'textbox'" width="15%">邮箱</th>
        <th data-options="field:'idcardname',align:'center',editor:'textbox'" width="7%">姓名</th>
        <th data-options="field:'idcardnumber',align:'center',editor:'textbox'" width="15%">身份证号码</th>
        <th data-options="field:'phone',align:'center',editor:'textbox'" width="10%">手机号码</th>
        <th data-options="field:'type',align:'center',
                editor:{
                    type:'combobox',
                    options:{
                        valueField: 'label',
		                textField: 'value',
                        data: [{
                            label: '成人',
                            value: '成人'
                        },{
                            label: '儿童',
                            value: '儿童'
                        },{
                            label: '军人',
                            value: '军人'
                        },{
                            label: '残疾患者',
                            value: '残疾患者'}]
                        }
                    }" width="5%">乘客类型
        </th>
        <th data-options="field:'logintime',align:'center'" width="13%">最近一次登陆时间</th>
    </tr>
    </thead>
</table>

<div id="tb-alluserinfo" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"
       id="btn-alluserinfo-edit">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       id="btn-alluserinfo-remove">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
       id="btn-alluserinfo-save">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
       id="btn-alluserinfo-reject">撤销修改</a>
    <input class="easyui-searchbox" data-options="prompt:'用户名/邮箱/姓名/身份证/手机号'" style="width:200px"
           id="btn-alluserinfo-search">
</div>
<!-- /用户管理 -->

<script type="text/javascript" src="/ssmTicketSystem/pages/user/js/alluserinfo.js"></script>

</body>

</html>