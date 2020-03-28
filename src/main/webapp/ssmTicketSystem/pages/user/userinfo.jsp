<%--
  Created by IntelliJ IDEA.
  User: qin
  Date: 2020/3/26
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- 个人信息管理 -->
<div class="easyui-panel" title="个人信息" data-options="fit:true" id="userinfo-panle">
    <div style="margin: 20px 350px;">
        <table cellpadding="5" style="font-size: 15px;">
            <tr>
                <td style="text-align: right;">用户名 :</td>
                <td style="padding: 0 10px;">${sessionScope.user.username}</td>
            </tr>
            <tr>
                <td style="text-align: right;">邮箱 :</td>
                <td><input class="easyui-textbox" readonly="true" style="width:200px;height:30px;padding: 0 5px;"
                           value="${sessionScope.user.email}" id="userinfo-email">
                    <a id="userinfo-change-eamil" href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-edit'">修改</a>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">姓名 :</td>
                <td style="padding: 0 10px;">${sessionScope.user.idcardname}</td>
            </tr>
            <tr>
                <td style="text-align: right;">身份证号码 :</td>
                <td style="padding: 0 10px;">${sessionScope.user.idcardnumber}</td>
            </tr>
            <tr>
                <td style="text-align: right;">手机号码 :</td>
                <td><input class="easyui-textbox" readonly="true" style="width:200px;height:30px;padding: 0 5px;"
                           value="${sessionScope.user.phone}" id="userinfo-phone"
                           data-options="required:true,validType:'phoneNum',invalidMessage:'手机号码格式不正确',missingMessage:'手机号码不能为空'">
                    <a id="userinfo-change-phone" href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-edit'">修改</a>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">乘客类型 :</td>
                <td>
                    <select id="userinfo-type" readonly="true" class="easyui-combobox"
                            style="width:80px;height:30px;">
                        <option value="${sessionScope.user.type}" selected>${sessionScope.user.type}</option>
                        <option value="成人">成人</option>
                        <option value="儿童">儿童</option>
                        <option value="军人">军人</option>
                        <option value="残疾患者">残疾患者</option>
                    </select>
                    <a id="userinfo-change-type" href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-edit'">修改</a>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">最近一次登陆时间 :</td>
                <td style="padding: 0 10px;">${sessionScope.user.logintime}</td>
            </tr>
            <tr>
                <td></td>
                <td><a href="javascript:void(0)" class="easyui-linkbutton" id="userinfo-save" iconCls="icon-save"
                       style="width:150px;height:30px;display: none;">保存</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<!-- /个人信息管理 -->

<!-- 确认登陆密码模态框 -->
<div id="dlg-checkPwd" class="easyui-dialog" title="验证登陆密码" style="width:320px;height:130px;" data-options="
        iconCls: 'icon-lock',
        buttons: '#dlg-checkPwd-buttons',
        modal:true,
        closed:true
    ">
    <!-- 确认登录密码 -->
    <div style="margin-left: 20px;">
        <span style="font-size: 12px;">登陆密码 : </span>
        <input type="text" class="easyui-textbox" style="width: 200px" id="userinfo-checkPwd"
               data-options="prompt:'请输入登录密码',events:{focus: function(){ easyuitextfocus($(this)); },blur: function(){ easyuitextblur($(this)); }}">
    </div>
</div>

<!-- 模态框按钮 -->
<div id="dlg-checkPwd-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-checkPwd-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-checkPwd-cancel">取消</a>
</div>
<!-- /确认登陆密码模态框 -->

<!-- 修改邮箱模态框 -->
<div id="dlg-checkEmail" class="easyui-dialog" title="验证邮箱" style="width:320px;height:160px;" data-options="
        iconCls: 'icon-man',
        buttons: '#dlg-checkEmail-buttons',
        modal:true,
        closed:true
    ">
    <!-- 输入新邮箱 -->
    <div style="margin-left: 20px;">
        <span style="font-size: 12px;">新邮箱 : </span>
        <input type="text" class="easyui-textbox" style="width: 200px" id="userinfo-newEmail"
               data-options="prompt:'请输入新的邮箱地址',required:true,validType:'email',invalidMessage:'邮箱格式不正确',missingMessage:'邮箱不能为空'">
    </div>
    <!-- 输入验证码 -->
    <div style="margin: 5px 0 0 65px;">
        <input type="text" class="easyui-textbox" style="width: 110px" id="userinfo-vfyCode"
               data-options="prompt:'请输入6位验证码'">
        <a href="javascript:void(0)" class="easyui-linkbutton" id="userinfo-getVfycode"
           data-options="iconCls:'icon-back'">获取验证码</a>
    </div>
</div>

<!-- 模态框按钮 -->
<div id="dlg-checkEmail-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-ok' id="btn-checkEmail-ok">确定</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-cancel' id="btn-checkEmail-cancel">取消</a>
</div>
<!-- /修改邮箱模态框 -->

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
</script>

<script type="text/javascript" src="/ssmTicketSystem/pages/user/js/userinfo.js"></script>