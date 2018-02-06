<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../easyUi/jquery.js"></script>
<script type="text/javascript" src="../editor/kindeditor-common.js"></script>
<script type="text/javascript" src="../editor/kindeditor.js"></script>
<script type="text/javascript" src="../editor/lang/zh_CN.js"></script> -->
<script type="text/javascript">

$(function(){
	
	//富文本编辑
	KindEditor /* .ready(function(K) {
				editor = K */ 
						.create(
								//textarea id
								"#content",
								{
									//指定主题风格可设置:default”、
									themeType : "simple",//修改主题
									height : "500px",
									//工具插件
									items : [ "source", "preview",
											"fullscreen", "clearhtml", "|",
											"undo", "redo", "|", "copy",
											"paste", "plainpaste",
											"wordpaste", "|",
											"justifycenter",
											"justifyright", "justifyfull",
											"insertorderedlist",
											"insertunorderedlist",
											"indent", "outdent", "|",
											"formatblock", "fontname",
											"fontsize", "forecolor",
											"hilitecolor", "bold",
											"italic", "underline",
											"strikethrough", "lineheight",
											"removeformat", "|", "image",
											"table", "hr", "emoticons",
											"baidumap", "pagebreak",
											"anchor", "link", "unlink" ],
									langType : 'zh_CN',
									//同步数据的方式，可设置""、"form"，值为form时提交form时自动同步，空时不会自动同步。
									syncType : "form",
									//true时根据 htmlTags 过滤HTML代码，false时允许输入任何代码。数据类型: Boolean 默认值: true
									filterMode : false,
									//可指定分页符HTML。
									pagebreakHtml : '<hr class="pageBreak" \/>',
									
									//true时显示浏览远程服务器按钮。
									allowFileManager : true,
									//相当于input file name
									filePostName : "artpic",
									//指定浏览远程图片的服务器端程序
									fileManagerJson : "${pageContext.request.contextPath }/imgs/browser",
									uploadJson : "${pageContext.request.contextPath }/imgs/uploadImg",
									//上传图片、Flash、视音频、文件时，支持添加别的参数一并传到服务器。 {item_id : 1000,category_id : 1}
									extraFileUploadParams : {
										token : getCookie("token")
									}, 
									/*  afterCreate : function() {
										  elocalStorage();
									 }, */
									//编辑器内容发生变化后执行的回调函数。
									afterChange : function() {
										this.sync();
										console.log(this.sync());
									}
								});
/* 			}); */
});
</script>


<form action="${pageContext.request.contextPath}/article/insertart" enctype="multipart/form-data">
	<div>
		<h1 style="color: red">文章信息</h1><br/>
		<hr style="border-color:blue ">
		<h3>请输入文章名称: <input id="name" name="artname"/></h3>
		<h3>请输入上师: <input id="mid" name="mid"/></h3>
		
		<h3>是否展示
			<input type="radio" id="status" name="status" value="是"/>是
			<input type="radio" id="status" name="status" value="否"/>否<br/>
		</h3>
	</div>
	<br/>
	<hr style="border-color: blue">
			<textarea id="content" name="artcontent" class="editor"
				style="width:100%;"></textarea>
				<input type="submit" />
</form>
