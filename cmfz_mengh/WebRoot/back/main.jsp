<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link><link
	rel="stylesheet" href="themes/icon.css" type="text/css" ></link>
<script type="text/javascript" src="easyUi/jquery.js"></script>
<script type="text/javascript" src="easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor-common.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript" src="editor/lang/zh_CN.js"></script>
<script type="text/javascript">
//选项卡
function selectTab(menuname,icons,url){
	//如果已经存在则选中
	if($("#tt").tabs("exists",menuname)){
		//选中
		//console.log(name);
		$("#tt").tabs("select",menuname);
	}else{
		alert(url);
	//如果不存在则创建
	$("#tt").tabs("add",{
		title:menuname,
		iconCls:icons,
		closable:true,
		href:"${pageContext.request.contextPath}/back/page/"+url
	});
	}
}

$(function(){
	//手风琴菜单选项卡
	$.post(
	"${pageContext.request.contextPath}/menu/queryall",
	function(data){
	//console.log(data);
	//遍历   data: 要遍历的集合  function  回调函数    index:下标   obj: 集合中元素
		$.each(data,function(index,obj){
			var content="";
			//遍历当前对象的list集合    i: 下标   o: 子菜单的对象      \":代表对双引号进行转义 
			$.each(obj.list,function(i,o){	
				//console.log(obj.list);
				content +="<a onclick='selectTab(\""+o.menuname+"\",\""+o.iconCls+"\",\""+o.url+"\")' style='width:100%' class ='easyui-linkbutton' data-options='iconCls:\""+o.iconCls+"\"'>"+o.menuname+"</a>";
			});
			
			$("#aa").accordion("add",{
				title:obj.menuname,
				content:content,
				iconCls:obj.iconCls
			});
			});
	},
	"JSON"
	);
});
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:licy &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
       
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;height:400px ">
    	<div id="aa" class="easyui-accordion" style="width:215px;height:500px;">     
		</div>
    </div>
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(../back/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>
    </div>   
</body> 
</html>