<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<title>管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="../back/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="../back/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="../back/css/login.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="../back/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../back/css/icon.css">
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){
				//点击更换验证码
				$("#captchaImage").prop("src",'${pageContext.request.contextPath}/admin/getcode?q='+new Date());
				//用户名验证
			});	
		
				//验证码验证
			$("#code").blur(function(){
				$.ajax(
					{type:"post",
					url:"${pageContext.request.contextPath}/admin/validatecode",
					data:"code="+code,
					dataType:"text",
					success:function(result){
						if(result=="Y"){
							
							return true;
						}else{
							$("#msg2").text("验证码错误");
							return false;
						}
					}
				});
			});
			$("#name").blur(function(){
			
				$.ajax(
					{type:"post",
					url:"${pageContext.request.contextPath}/admin/queryname",
					data:"adminname="+adminname,
					dataType:"text",
					success:function(result){
						if(result=="Y"){
							
							return true;
						}else{
							$("#msg1").text("用户名不存在");
							return false;
						}
					}
				});
			});
				
			
		
			
			//  form 表单提交
			$("#btn").click(function click90(){
				alert()
				$("#loginForm").form("submit",{
					url:"${pageContext.request.contextPath}/admin/querynamepassword",
					onSubmit:function(b){//请求发送之前执行
						console.log("submit~~~~~~"+b);
						//验证数据
						return $("#form90").form("validate");//调用内部的各个名字所有字段都合法则返回true
					},
					success:function(res){
					console.log(res);
					
					}
				});
			});
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm"   method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" alt="购物"/>
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="name" class="easyui-textbox" data-options="required:true"  name="adminname"   maxlength="20"/><span id="msg1"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="pwd" type="password" class="easyui-textbox" data-options="required:true" name="password" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input  class="easyui-textbox" data-options="required:true" id="code" name="code" class="text captcha" maxlength="4" autocomplete="off"/><span id="msg2"></span>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath }/admin/getcode" title="点击更换验证码"/>
							</td>
						</tr>					
			
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'">
							<input type="button" id="btn"  class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2005-2013.</div>
				<div class="link">
					<a href="">前台首页</a> |
					<a href="">官方网站</a> |
					<a href="">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body> 
</html>