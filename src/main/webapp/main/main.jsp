<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/treegrid-dnd.js"></script>
<script type="text/javascript"></script>
    <script>

        if("${sessionScope.login}"==""){
            location.href="${pageContext.request.contextPath}/Admin/login.jsp"
        }

        <!--菜单处理-->
        $(function () {
            //页面加载完成之后显示菜单数据
            $.post("${pageContext.request.contextPath}/menu/showAll",function (menu) {
                //通过accordion的添加方法追加菜单
                console.log(menu);
                //遍历一级菜单
                $.each(menu,function (index,m) {
                    //遍历二级菜单
                    var content = "<div style='text-align: center;'>";
                    $.each(m.children,function(idx,child){
                        content += "<a onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 2px #00ee00 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a><br>";
                    });
                    content += "</div>"
                    //添加菜单
                    $("#menu").accordion('add',{
                        title:m.name,
                        iconCls:m.iconCls,
                        content:content,
                    })
                });

            });
        });

        //点击菜单追加选项卡
        function addTabs(title,iconCls,href){
            //添加以前先判断tabs中是否存在这个选项卡
            if(!$("#tabs").tabs('exists',title)){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    fit:true,
                    href:"${pageContext.request.contextPath}/"+href,
                });
            }else{
                $("#tabs").tabs('select',title);
            }

        };

    function openEditAdminDialog(id) {
        $("#updateAdminDialog").dialog({
            href:'${pageContext.request.contextPath}/Admin/edit.jsp?',
            buttons:[
                {
                    iconCls:'icon-edit',
                    text:"修改",
                    handler:function(){
                        $("#editAdminInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/Admin/update",
                            success:function (result) {
                                var resultObj = $.parseJSON(result);
                                if(resultObj.success){
                                    $.messager.show({title:'提示',msg:"密码已修改，请重新登录！"})

                                }else{
                                    $.messager.show({title:'提示',msg:resultObj.message})
                                }
                                location.href="${pageContext.request.contextPath}/Admin/login.jsp"
                            }
                        });
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:"取消",
                    handler:function(){
                        $("#updateAdminDialog").dialog('close');
                    }
                }
            ]
        })
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:<span>${sessionScope.login.name}</span>
            <a href="javascript:;" class="easyui-linkbutton"  onclick="openEditAdminDialog()" data-options="iconCls:'icon-edit'">修改密码</a>
            <a href="${pageContext.request.contextPath}/Admin/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',selected:-1"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>

    <div id="updateAdminDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'修改密码'"></div>
</body> 
</html>