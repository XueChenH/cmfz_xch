<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>

    <script>
        $(function () {

            //通过js创建datagrid
            $("#coursedg").datagrid({
                url:'${pageContext.request.contextPath}/course/showByPage',//用来请求远程数据
                pagination:true,//显示分页工具栏
                pageNumber:1,//当前页
                pageSize: 10,
                pageList:[1,2,10,15,30 ,500],
                striped:true,
                rownumbers:true,
                singleSelect:false,
                ctrlSelect:true,
                //checkOnSelect:false,
                //selectOnCheck:false,

                remoteSort:false,
                multiSort:true,
                columns:[[
                    {title:'cks',field:"cks",checkbox:true},
                    {title:'id',field:'id',width:120,},
                    {title:'功课名字',field:'title',width:120,},
                    {title:'功课状态',field:'marking',width:120,},
                    {title:'功课日期',field:'date',width:120,sortable:true},
                    {title:'options',field:'options',width:200,
                        formatter:function(value,row,index){
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;" +
                                "<a href='javascript:;' class='options' onclick=\"openUpdateCourseDialog('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">更新</a>";
                        }
                    }
                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                toolbar:'#coursegj',
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.headPic +' " style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Attribute: ' + rowData.headPic + '</p>' +
                        '<p>Status: ' + rowData.status + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
        });
   /*     //删除
        function delRow(id) {
            $.post("${pageContext.request.contextPath}/course/removeAll",{"id":id},function (result) {
                $("#coursedg").datagrid('reload');
            })
        }*/
        //删除一行的事件
        function delRow(id){
            $.messager.confirm("确认对话框","确定删除么？？",function(b){
                if(b){

                    //获取当前点击id发送ajax请求删除id这个人的信息
                    $.post("${pageContext.request.contextPath}/course/removeAll",{"id":id},function (result) {//响应成功之后回调
                        //刷新datagrid数据
                        $("#coursedg").datagrid('reload');//刷新当前datagrid\
                        $.messager.show({title:'提示',msg:"删除成功!!!"});
                    });
                }
            })

        }

        //打开保存用户对话框函数
        function openSaveCourseDialog(){
            $("#saveCourse").dialog({
                href:'${pageContext.request.contextPath}/Course/save.jsp',
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        //保存用户信息
                        $("#saveCourseInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/course/add',
                            success:function(result){//响应的一定是json格式字符串   使用应该先转为js对象
                                //提示信息
                                $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                                //关闭对话框
                                $("#saveCourse").dialog('close');
                                //刷新datagrid
                                $("#coursedg").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#saveCourse").dialog('close');
                    }
                }]
            });
        }

        //批量删除
        function delBatchRows() {
            var rows=$("#coursedg").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:'至少选择一行...'});
            }else{
                var ids=[];
                for (var i = 0; i <rows.length ; i++) {
                    ids.push(rows[i].id)
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/course/removeAll",
                    type:"POST",
                    traditional:true,
                    data:{id:ids},
                    success:function(){
                        $.messager.show({title:'提示',msg:"删除成功!!!"});
                        $("#coursedg").datagrid('reload');
                    },
                    error:function(){
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败!!!"});
                        //刷新datagrid
                        $("#coursedg").datagrid('reload');
                    }
                })
            }
        }

        //修改
        function openUpdateCourseDialog(id) {
            $("#updateCourseDialog").dialog({
                href:'${pageContext.request.contextPath}/Course/edit.jsp?id='+id,
                buttons:[
                    {
                        iconCls:'icon-edit',
                        text:"修改",
                        handler:function(){
                            $("#editCourseInputForm").form('submit',{
                                url:"${pageContext.request.contextPath}/course/update",
                                success:function (result) {
                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success){
                                        $.messager.show({title:'提示',msg:"用户信息修改成功"})
                                    }else{
                                        $.messager.show({title:'提示',msg:resultObj.message})
                                    }
                                    $("#updateCourseDialog").dialog('close');
                                    $("#coursedg").datagrid('reload');
                                }
                            })
                        }
                    },
                    {
                        iconCls:'icon-cancel',
                        text:"取消",
                        handler:function(){
                            $("#updateCourseDialog").dialog('close');
                        }
                    }
                ]
            })
        }
    </script>


    <table id="coursedg"></table>
    <div id="coursegj">
        <a href="#" class="easyui-linkbutton" onclick="openSaveCourseDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a href="#" class="easyui-linkbutton" onclick="delBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
    </div>

    <div id="saveCourse" data-options=
            "draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存功课信息'">
    </div>
    <div id="updateCourseDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改功课信息'">

    </div>


