<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">

	
	var tool90=[//工具栏
					{iconCls:'icon-edit',
					text:'全部导出',
					handler:function(){
						$.messager.confirm("Tip","确认导出所有",function (flag) {
                    		if(flag){
                        	location.href="${pageContext.request.contextPath}/excel/exportall";
                    		}
                		});
					}
					},
					'-',
						
					{iconCls:'icon-edit',
					text:'自定义导出',
					handler:function(){
						var data=$("#tb").datagrid("getSelections");
						if(data.length==0){
							$.messager.alert("Tip","至少选择一行~~");
						}else{
							$.messager.confirm("Tip", "确定导出么", function(flag){
								if(flag){
									var users='';
									$(data).each(function(){
										users+=this.userid+",";
										alert(users);
									});
								location.href="${pageContext.request.contextPath}/excel/exportSelUsers?users="+users;
								}
							});		
						}
						}
					},
					'-',
					
					/* {iconCls:'icon-edit',
					text:'导入',
					handler:function(){
					
										}
					},'-', */
					{iconCls:'icon-edit',
					text:'导入模板下载',
					handler:function(){
						location.href="${pageContext.request.contextPath}/excel/downModel";
										}
					}
					
				];
		
	function pic(value,row,index){
		//console.log(row);
		var img="${pageContext.request.contextPath}/back/roundpic/"+row.userhead;
		return "<img width='100'  height='56' src ="+img+" />";
	}



</script>

 	<table class="easyui-datagrid" style="width:300px;margin-top:20px" id="tb"
							
						  data-options="iconCls:'icon-save',
									 	fit:true,
										fitColumns:true,
										striped:true,
										url:'${pageContext.request.contextPath}/user/queryuser',
										toolbar:tool90,
										pagination:true,
				   				 		pageSize:2,
				   				 		pageList:[2,5],
				   				 		remoteSort:false,
					   			 		">
		
					<thead>
					<tr>
						<th data-options="field:'userid',width:100">用户id</th>
						<th data-options="field:'password',width:100">密码</th>
						<th data-options="field:'phone',width:100">电话</th>
						<th data-options="field:'userhead',width:100,formatter:pic">头像</th>
						<th data-options="field:'faname',width:100">法名</th>
						<th data-options="field:'username',width:100,align:'center'">用户名</th>
						<th data-options="field:'sex',width:100,align:'center'">性别</th>
						<th data-options="field:'location',width:100,align:'center'">所在地</th>
						<th data-options="field:'sign',width:100,align:'center'">签名</th>
						<th data-options="field:'mid',width:100,align:'center'">上师id</th>
						<th data-options="field:'status',width:100,align:'center'">状态</th>
					</tr>
				</thead>

	</table> 

					
			

