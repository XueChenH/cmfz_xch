<%@page pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="saveSildeshowInputForm"     class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px;">
            图片: <input type="text" name="file" class="easyui-filebox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            图片描述: <input type="text" name="s_desc"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            图片状态: <input type="text" name="status"  class="asyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            创建时间: <input type="text" name="updatetime"  class="easyui-datebox">
        </div>
    </form>
</div>