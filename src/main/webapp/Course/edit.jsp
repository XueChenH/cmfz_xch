<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editCourseInputForm").form('load','${pageContext.request.contextPath}/course/showOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editCourseInputForm"   class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            修改功课名字: <input type="text" name="title"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            修改功课状态: <input type="text" name="marking"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
    </form>
</div>