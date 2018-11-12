<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
            $(function () {
            $.get("${pageContext.request.contextPath}/Guru/showAll",function (result) {
            $.each(result,function (idx,gurus) {
            var option=$("<option></option>").attr("value",gurus.id).text(gurus.name);
            $("#article1").append(option);
            })
            },"JSON");
            })
</script>
<div style="text-align: center;">
    <form id="saveArticleInputForm"     class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px;">
            文章图片: <input type="text" name="file" class="easyui-filebox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            文章名字: <input type="text" name="title"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            文章内容: <input type="text" name="content"  class="asyui-textbox">
        </div>

        <div style="margin-top: 20px;" >
            作者：<select   style="width:160px;height: 23px" id="article1" name="guru_id">
            <option>请选择</option>
        </select>
        </div>
    </form>
</div>