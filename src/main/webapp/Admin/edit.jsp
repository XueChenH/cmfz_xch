<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="editAdminInputForm"   class="easyui-form" method="post">
        <input type="hidden" name="id" value="${sessionScope.login.id}">
        <div style="margin-top: 50px;">
            姓名: <input type="text" value="${sessionScope.login.name}" class="easyui-textbox" data-options="required:true,validType:'uname'" readonly>
        </div>
        <div style="margin-top: 20px;">
            账号: <input type="text" value="${sessionScope.login.glname}"  class="easyui-textbox" readonly>
        </div>
        <div style="margin-top: 20px;">
            性别: <input type="text" value="${sessionScope.login.sex}"  class="easyui-textbox" readonly>
        </div>
        <div style="margin-top: 20px;">
            新密码: <input type="password" name="password"  class="easyui-textbox" data-options="required:true">
        </div>
    </form>
</div>