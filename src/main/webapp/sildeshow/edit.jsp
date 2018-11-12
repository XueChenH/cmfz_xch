<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editSildeShowInputForm").form('load','${pageContext.request.contextPath}/sildeshow/showOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editSildeShowInputForm"   class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            修改轮播图描述: <input type="text" name="s_desc"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            修改轮播图状态: <input type="text" name="status"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
    </form>
</div>