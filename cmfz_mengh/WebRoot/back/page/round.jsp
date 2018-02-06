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
					{	iconCls:'icon-add',
						handler:function(){
						//console.log("edit");
						//获取当前选中行的数据
						//var tr=$("#tb").datagrid("getSelected");
						//alert(tr.pictime);
					
						
						//打开 对话框
						$("#dia").dialog("open");
						$("#tb").datagrid("reload");
						}
					},'-',
					{
						iconCls:'icon-cut',
						handler:function(){
							var tr=$("#tb").datagrid("getSelected");
							alert(tr.pictime);
							for ( var s in tr) {
								console.log(s);
							}
						}
					}
	
				];
	
	//添加
	var addimgbtn=[
		{
			text:'确认',
			iconCls:'icon-ok',
			handler:function(){
				$("#addimg").form("submit",
				{
					url:'${pageContext.request.contextPath}/roundpic/addpic',
					onSubmit:function () {
                        if($('#addimg').form("validate")){
                            $('#dia').dialog("close");
                            return true;
                        }else{
                            return false;
                        }
                    },
                    success:function(ret){
                    	if(ret==1){
                            $.messager.alert("Tip","添加成功!");
                            $('#tb').datagrid("reload");
                        }else{
                            $.messager.alert("Tip","添加失败!");
                        }
                        $('#addimg').form("clear");
                    }
				}				
				);
			}
		},
		{
			text:'取消',
			iconCls:'icon-cut',
			handler:function(){
				$('#dia').dialog("close");
				$('#addimg').form("clear");
			}
		}
	];
	
	//格式化展示图片
	function status(value,row,index){
		//alert(value);
		if(value=="展示中"){
			return "<font color='red'>"+"展示中"+"</font>";
		}else{
			return "未展示";
		}
	}
	function file(value,row,index){
		
		//var img=row.picname;
		var img="<img width='100'  height='56' src =http://"+row.picname+" />";
		return img;
		
	}
	//创建表格
	function operate(value,row,index){
		console.log(row.rpicid);
		return "<a class='text' href='#' onclick=\"upclick(\'"+row.rpicid+"\',\'"+row.picstatus+"\')\">修改状态</a><a class='text' href='#' onclick=\"delclick(\'"+row.rpicid+"\')\">删除</a>";
	}
	var load=function(){//加载成功后重新加载a标签
		$(".text").linkbutton({
		iconCls:'icon-edit'
		
		});
		/* $.parser.parse($('a').parent()); */
	};	
	//修改状态
	function upclick(id,picstatus){
		console.log(id+"_______"+picstatus);
        if(status=="展示中"){
            status="未展示";
           
        }else {
            status="展示中";
        }
        console.log(status);
   		$.ajax({
   				type:"post",
   				url:'${pageContext.request.contextPath}/roundpic/modifypic',
   				data:'rpicid='+id+'&picstatus='+status,
   				success:function(ret){
   					if(ret==1){
   						$.messager.show({
   							title:"Tip",
   							msg:"修改成功",
   							showType:"show",
   							timeout:5000
   							}	
   						);
   						$("#tb").datagrid("reload");
   						alert("刷新了");
   					}else{
   						$.messager.alert("网络错误");
   					}
   				}
   		});
    }

	//删除
	function delclick(rpicid){
		alert(rpicid);
		$.messager.confirm("Tip", "确认删除", function(flag){
			if(flag){
				$.ajax({
					type:'POST',
					url:'${pageContext.request.contextPath}/roundpic/delpic',
					data:'rpicid='+rpicid,
					success:function(f){
						if(f!=1){
							$.message.alert("Tip","网络错误~~~~删除失败");				
						}else{
							$("#tb").datagrid("load");
						}
					}
				});
			}
		});
	}

</script>

 	<table class="easyui-datagrid" style="width:300px;margin-top:20px" id="tb"
							
						  data-options="iconCls:'icon-save',
									 	fit:true,
										fitColumns:true,
										striped:true,
										singleSelect:false,
										url:'${pageContext.request.contextPath}/roundpic/querypic',
										toolbar:tool90,
										pagination:true,
				   				 		pageSize:5,
				   				 		pageList:[5,10],
				   				 		remoteSort:false,
				   				 		onLoadSuccess:load
				   				 		
					   			 		">
		
					<thead>
					<tr>
						<th data-options="field:'rpicid',width:100">标识编号</th>
						<th data-options="field:'picname',width:100,formatter:file">文件名</th>

						<th data-options="field:'picdiscribe',width:100">描述信息</th>
						<th data-options="field:'picstatus',width:100,formatter:status">轮播图状态</th>
						<th data-options="field:'pictime',width:100,formatter:dateformate">创建时间</th>
						<th data-options="field:'d',width:100,align:'center',formatter:operate">操作</th>
						
					</tr>
				</thead>

	</table> 
			<div class="easyui-dialog" style="width:300px;height:300px" id="dia"
			     data-options="closed:true,
			                   modal:true,
			                   title:'添加',
			                   buttons:addimgbtn,
			                   iconCls:'icon-edit'">
				<form class="easyui-form" id="addimg" enctype="multipart/form-data" method="post" >
					
					<!-- 文件名:<input class="easyui-textbox" data-options="required:true" name="picname"/><br/> -->
					描述信息:<input class="easyui-textbox" data-options="required:true" name="picdiscribe"/><br/>
					<!-- 轮播图状态:<input class="easyui-textbox" data-options="required:true" name="picstatus"/><br/> -->
					轮播图状态:<select name="picstatus" id="imgstu" class="easyui-combobox" data-options="editable:false,required:true,panelHeight:50" style="width:160px;">
								<option value="展示中">展示中</option>
								<option value=未展示>未展示</option>
							</select><br/><br/>
					上传轮播图：<input class="easyui-filebox" name="file" data-options="buttonText:'选择文件',required:true,accept:'.jpg' "/>
					<!-- <a class="easyui-linkbutton" onclick="update">提交</a>  -->
				</form>
			</div>
			<div class="easyui-dialog" style="width:300px;height:300px" id="diaupdate"
			     data-options="closed:true,
			                   modal:true,
			                   title:'修改',
			                   
			                   iconCls:'icon-edit'">
				<form class="easyui-form" id="updateimg" enctype="multipart/form-data" method="post" >
					
					文件编号:<input class="easyui-textbox" data-options="required:true" name="rpicid" readOnly "/><br/>
					描述信息:<input class="easyui-textbox" data-options="required:true" name="picdiscribe"/><br/>
					<!-- 轮播图状态:<input class="easyui-textbox" data-options="required:true" name="picstatus"/><br/> -->
					轮播图状态:<select name="picstatus" id="imgstu" class="easyui-combobox" data-options="editable:false,required:true,panelHeight:50" style="width:160px;">
								<option value="展示中">展示中</option>
								<option value=未展示>未展示</option>
							</select><br/><br/>
					上传轮播图：<input class="easyui-filebox" name="file" data-options="buttonText:'选择文件',required:true,accept:'.jpg' "/>
					
				</form>
			</div>		
			

