<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-tip',
        text: "专辑详情",
        handler: function () {
           var row = $("#album").treegrid("getSelected");
           if(row == null ){
                alert("请选中行！！！！");
           }else{
               if(row.size == null){  //选中的是专辑
                   $("#album_dialog").dialog("open");

                   console.log(row)
                   /*填充内容*/
                   $("#album_ff").form("load",row);
                   $("#albumpath").prop("src",'${pageContext.request.contextPath}/'+row.albumpath);

               }else {
                   alert("请先选择专辑！！！");
               }
           }

        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加专辑",
        handler: function () {
            $("#album_addg").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-add',
        text: "添加章节",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row==null){
                alert("请选中行")
            }else {
                if(row.size == null){
                    $("#chapter_dialog").dialog("open");
                    $("#album_id").textbox("setValue",row.id);
                    $("#album_title").textbox("setValue",row.title);

                }else{
                    alert("请先选专辑");
                }
            }

        }
    }, '-', {
        iconCls: 'icon-undo',
        text: "下载音频",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            location.href = "${pageContext.request.contextPath}/chapter/download?fileName=" + row.downLoadPath + "&openStyle=attachment";
        }
    }]

    $(function () {
        $("#album").treegrid({
            url: "${pageContext.request.contextPath}/Album/showByPage",
            idField: 'id',
            treeField: 'title',
            onDblClickRow:function (row){
                if (row == null) {
                    alert("请先选中行！！！")
                } else {
                    if (row.downLoadPath != null) {
                        $("#album_paly").dialog("open");
                        $("#audio").prop("src", "${pageContext.request.contextPath}/"+row.downLoadPath)
                    } else {
                        alert("请先选妙音！！！")
                    }
                }

            },
            columns: [[
             /*   {field:'albumtitle',title:'名称',width:50,align:'center'},*/
              {field: 'title',title:'名称',width:50,align:'center'},
                {field:'size',title:'章节大小',width:50,align:'center'},
                {field:'duration',title:'章节时长',width:50,align:'center'},
                {field:'downLoadPath',title:'下载路径',width:50,align:'center'},
                {field:'upLoadDate',title:'上传路径',width:50,align:'center'},
                {field:'upLoadDate',title:'上传时间',width:50,align:'center'},
                {field:'status',title:'状态',width:50,align:'center'},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 10,
            toolbar: toolbar,


        })

    })


    function submit() {
        $('#album_add').form('submit', {
            url: "${pageContext.request.contextPath}/album/add",

        })
    }

</script>


<table id="album"></table>
<%--专辑详情--%>
<div id="album_dialog" class="easyui-dialog" title="专辑详情" style="width:400px;height:550px;"
     data-options="iconCls:'icon-tip',resizable:true,modal:true,closed:true">

    <form id="album_ff" method="post">
        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="title">专辑名称:</label>
            <input id="title" name="title" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="set_count">专辑集数:</label>
            <input id="set_count" name="set_count" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="score">专辑星级:</label>
            <input id="score" name="score" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="author">专辑作者:</label>
            <input id="author" name="author" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="broadcast">播音员:</label>
            <input id="broadcast" name="broadcast" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="brief">简介:</label>
            <input id="brief" name="brief" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>

        <div style="height:20px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="create_date">发布日期:</label>
            <input id="create_date" name="create_date" type="text"  class="easyui-validatebox"  style="width:100%;height: 100%">
        </div>



        <div style="margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="albumpath">封面:</label>
            <img id="albumpath" src="" style="width:60%;height: 60%">
        </div>

        <%--<div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input name="img" required="true"  class="easyui-filebox"  style="width:100%;height: 100%">
        </div>--%>
    </form>

</div>

<%--添加章节--%>
<div id="chapter_dialog" class="easyui-dialog" title="添加章节" style="width:400px;height:500px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#chapter_ff').form('submit',{
                      url:'${pageContext.request.contextPath}/chapter/add',
                      success:function(data){
                         $('#chapter_dialog').dialog('close');
                         $('#album').treegrid('reload')

                    }

                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#chapter_dialog').dialog('close');
				}
			}]">

    <form id="chapter_ff" method="post" enctype="multipart/form-data">
        <input class="easyui-textbox" value="0" name="album_id" id="album_id" type="hidden" />
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="album_title">所属专辑:</label>
            <input class="easyui-textbox" value="0" name="album_title" id="album_title" style="visibility: hidden;width:100%;height: 100%" readonly/>
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="title"  required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'章节名称'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
                <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;text-align: center;">
                    <span style="line-height: 40px;display: block;font-size: 14px">状&nbsp;&nbsp;态:</span>
                </span>
            <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;float: right">
                    <input class="easyui-switchbutton" name="status" data-options="onText:'yes',offText:'no',handleWidth:50,handleText:'状态'" style="width:100%;height: 100%">
                </span>
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <label for="file">上传章节:</label>
            <input class="easyui-filebox" id="file" name="file"/>
        </div>

    </form>


</div>


<%--双击播放--%>
<div id="album_paly" class="easyui-dialog" title="播放音频" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <audio id="audio" src="" controls="controls" autoplay="autoplay"></audio>

</div>



<%--添加专辑--%>
<div id="album_addg" class="easyui-dialog" title="添加专辑" style="width:400px;height:650px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                    $('#album_add').form('submit', {
                     url:'${pageContext.request.contextPath}/Album/add',
                    success:function(data){
                         $('#album_addg').dialog('close');
                         $('#album').treegrid('reload')

                    }


                 })
				}
			},{
				text:'关闭',
				handler:function(){
				$('#album_addg').dialog('close');
				}
			}]">

    <form id="album_add" method="post" enctype="multipart/form-data">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="title"  required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'专辑名称'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="set_count" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'集数'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="score" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'星级'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="author" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'作者'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="broadcast" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'播音员'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="brief" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'简介'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
                <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;text-align: center;">
                    <span style="line-height: 40px;display: block;font-size: 14px">状&nbsp;&nbsp;态:</span>
                </span>
            <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;float: right">
                    <input class="easyui-switchbutton" name="status" data-options="onText:'yes',offText:'no',handleWidth:50,handleText:'状态'" style="width:100%;height: 100%">
                </span>
        </div>
        <%--<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input id="pdate" required="true"   class="easyui-datebox" data-options="prompt:'最后修改时间'" style="width:100%;height: 100%">
        </div>--%><%--name="pdate"--%>
        <div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            专辑图片 <br/><input name="file" required="true"  class="easyui-filebox"  style="width:100%;height: 100%">
        </div>
    </form>

</div>




