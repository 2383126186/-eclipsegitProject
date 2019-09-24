<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的接单</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js">
</script>
<body>
<div class="home">
	<p id ="myorderreceivingname">${Myhome}</p>
	<div id = "myorderreceiving">
		<p>${myorderreceivingerro}</p>
	</div>
		<p id="myordererro"></p>
</div>
	
</body>
<!-- ajax显示我的订单 -->
	<script type="text/javascript">
	$(function(){
		var myorderreceivingname = $("#myorderreceivingname").text();
			$.ajax({
				//后台路径
				url:"http://localhost:8080/Helps/myorderreceiving",
				//指定提交方式
				type:"get",
				//返回方式
				dataType:"json",
				data:{
					"myorderreceivingname":myorderreceivingname
				},
				error:function(){
					alert("请求失败");	
				},
				success:function(res){
					//接收
					var indaxli = res.myorderreceivingli;	
					//循环
					for(i=0;i<indaxli.length; i++){
						//创建节点
						var $node = $('<div><h3><table>'+
										'<tr>'+
										'<td>用户:'+indaxli[i].uname+'&nbsp;</td>'+
										'<td>时间:'+indaxli[i].time+'&nbsp;</td>'+
										'<td>地点:'+indaxli[i].site+'&nbsp;</td>'+
										'<td>赏金:'+indaxli[i].money+'&nbsp;</td>'+
										'<td>简介:'+indaxli[i].message+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/orderorderachieve?id='+indaxli[i].id+'>完成订单</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/giveorder?id='+indaxli[i].id+'>放弃订单</a>'+'&nbsp;</td>'+
										'</tr>'+	
										'</table>'+
										'</h3>'+
										'</div>'	
							);
						//放入
						$("#myorderreceiving").append($node);
						
						
					}
					
				}
			})
			
		

	})
	</script>	

</html>