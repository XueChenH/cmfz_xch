<%@page pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="saveCourseInputForm"     class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 50px;">
            功课名字: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            功课状态: <input type="text" name="marking"  class="easyui-textbox">
        </div>
    </form>
</div>