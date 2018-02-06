<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script
	src="${pageContext.request.contextPath }/back/script/echarts.min.js"></script>
<script src="${pageContext.request.contextPath }/back/easyUi/jquery.js"></script> 
	
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="width: 800px;height:400px;text-align: 'center' "></div>

	<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('main'));
		
		// 显示标题，图例和空的坐标轴
		myChart.setOption({
			title : {
				text : '文章点击量排行榜前5名'
			},
			tooltip : {},
			legend : {
				data : [ '点击量' ]
			},
			xAxis : {
				data : []
			},
			yAxis : {},
			series : [ {
				name : '点击量',
				type : 'bar',
				data : []
			} ]
		});

		// 异步加载数据
		$.get('${pageContext.request.contextPath}/article/rank').done(function(data) {
			// 填入数据
			console.log(data.categories)
			myChart.setOption({
				xAxis : {
					data : data.names
				},
				series : [ {
					// 根据名字对应到相应的系列
					name : '点击量',
					data : data.data
				} ]
			});
		});
		
	</script>
