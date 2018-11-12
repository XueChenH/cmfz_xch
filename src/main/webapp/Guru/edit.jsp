<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editGuruInputForm").form('load','${pageContext.request.contextPath}/Guru/showOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editGuruInputForm"   class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            修改上师姓名: <input type="text" name="name"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            修改上师状态: <input type="text" name="status"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
    </form>
</div>