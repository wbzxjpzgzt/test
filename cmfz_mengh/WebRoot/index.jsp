<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css;">
    	
    </style>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="background-color: pink">
  	<div align="right">
  	<span><a href="../back/main.jsp"><input type="button" value="返回主界面"/></a></span>
    </div>
    This is my JSP page. <br>
    <img id="haha" >
    <div>
		<img alt="" src="">
	</div>
    <script type="text/javascript">
    	$("#haha").Attr("src","");
    </script>
  </body>
</html>
