<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $.get("${pageContext.request.contextPath}/Guru/showAll",function (result) {
            $.each(result,function (idx,gurus) {
                var option=$("<option></option>").attr("value",gurus.id).text(gurus.name);
                $("#article").append(option);
            })
        },"JSON");
    })
    $(function () {
        console.log("${param.id}");
        $("#editArticleInputForm").form('load','${pageContext.request.contextPath}/article/showOne?id=${param.id}');
    })

</script>
<div style="text-align: center;">
    <form id="editArticleInputForm"   class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px;">
            修改文章姓名: <input type="text" name="title"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            修改文章内容: <input type="text" name="content"  class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;" >
            作者：<select   style="width:160px;height: 23px" id="article" name="guru_id">
            <option>请选择</option>
        </select>
        </div>
    </form>
</div>