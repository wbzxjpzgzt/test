<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	function dateformate(time){
		//console.log(time);
		var value=new Date(time);
		return (value.getFullYear()+"-"+(value.getMonth()+1)+"-"+value.getDate());
	}
	
	var tool90=[//工具栏
					{iconCls:'icon-add',
					handler:function(){
						
										}
					}
	
				];
	

	//创建表格
	function operate(value,row,index){
		console.log(row.rpicid);
		return "<a id='text'  onclick=\"findclick(\'"+row.artid+"\')\">查看</a>";
		console.log("<a id='text' onclick='findclick("+row.artid+")'>查看</a>");
	}
	var load=function(){//加载成功后重新加载a标签
		$(".text").linkbutton({
		iconCls:'icon-edit'
		
		});
		/* $.parser.parse($('a').parent()); */
	};	

	//查看
	function findclick(data){
		console.log(data);
		location.href="${pageContext.request.contextPath}/html/"+data+".html";
	}
	
</script>

 	<table class="easyui-datagrid" style="width:300px;margin-top:20px" id="tb"
							
						  data-options="iconCls:'icon-save',
									 	fit:true,
										fitColumns:true,
										striped:true,
										url:'${pageContext.request.contextPath}/article/queryall',
										toolbar:tool90,
										pagination:true,
				   				 		pageSize:5,
				   				 		pageList:[5,10],
				   				 		remoteSort:false,
				   				 		onLoadSuccess:load,
				   				 		
					   			 		">
		
					<thead>
					<tr>
						<th data-options="field:'artname',width:100">文章名称</th>
						<th data-options="field:'artcontent',width:100">文章内容</th>
						<th data-options="field:'mid',width:100">上师</th>
						<th data-options="field:'arttime',width:100,formatter:dateformate">发布时间时间</th>
						<th data-options="field:'clicks',width:100">文章点击量</th>
						<th data-options="field:'status',width:100">文章状态</th>		
						<th data-options="field:'artpic',width:100">文章图片</th>
						<th data-options="field:'d',width:100,align:'center',formatter:operate">操作</th>		
					</tr>
				</thead>

	</table> 



					
			

