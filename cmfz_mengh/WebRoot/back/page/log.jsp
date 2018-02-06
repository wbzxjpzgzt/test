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
		return "<a class='text'  onclick=\"delclick(\'"+row.rpicid+"\')\">删除</a>";
	}
	var load=function(){//加载成功后重新加载a标签
		$(".text").linkbutton({
		iconCls:'icon-edit'
		
		});
		/* $.parser.parse($('a').parent()); */
	};	

	//删除
	function delclick(){

	}

</script>

 	<table class="easyui-datagrid" style="width:300px;margin-top:20px" id="tb"
							
						  data-options="iconCls:'icon-save',
									 	fit:true,
										fitColumns:true,
										striped:true,
										singleSelect:true,
										url:'${pageContext.request.contextPath}/log/printlog',
										toolbar:tool90,
										pagination:true,
				   				 		pageSize:5,
				   				 		pageList:[5,10],
				   				 		remoteSort:false,
				   				 		onLoadSuccess:load,
				   				 		
					   			 		">
		
					<thead>
					<tr>
						<th data-options="field:'name',width:100">日志编号</th>
						
						<th data-options="field:'createtime',width:100,formatter:dateformate">创建时间</th>
						<th data-options="field:'detail',width:100">日志详情</th>
						<th data-options="field:'type',width:100">日志类型</th>		
					</tr>
				</thead>

	</table> 



					
			

