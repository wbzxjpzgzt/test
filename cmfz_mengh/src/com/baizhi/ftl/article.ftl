<html>
<head> 
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
</head>
  <body style="background-color: pink">
  	<br/>
	<div>
		<h1 style="color: red;font-weight: 55px;text-align: center;font-style: italic;">文章详情</h1>
	</div><br/>
	<div align="right">
  	<span><a href="http://localhost:8989/cmfz_mengh/back/main.jsp"><input type="button" value="返回主界面"/></a></span>
    </div>
	<div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
					<td rowspan="9" width="20%" valign="top"><img id="picture" src="${article.artpic}"/></td>
					<td colspan="2">上师:${article.mid}</td>
			</tr>
			<tr>
					<td colspan="2">文章名：${article.artname}</td>
			</tr>  
			<tr>
					<td colspan="2">文章发布时间： ${article.arttime?date}</td>
			</tr>  
		
		</table>
	</div><br/>
	<div>
		
		${article.artcontent}
		
	</div>
	 
  </body>
</html>