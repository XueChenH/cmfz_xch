<%@page pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="saveGuruInputForm"     class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px;">
            上师图片: <input type="text" name="file" class="easyui-filebox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            上师名字: <input type="text" name="name"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            上师状态: <input type="text" name="status"  class="asyui-textbox">
        </div>
    </form>
</div>