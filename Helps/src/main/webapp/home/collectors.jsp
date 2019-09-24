<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我的收藏</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js">
</script>
<body>
	<p id ="collectorsname">${Myhome}</p>
	<div id = "collectors">
		<p>${cancelerro}</p>
	</div>
</body>
<!-- ajax显示我的订单 -->
	<script type="text/javascript">
	$(function(){
		var collectorsname = $("#collectorsname").text();
			$.ajax({
				//后台路径
				url:"http://localhost:8080/Helps/collectors",
				//指定提交方式
				type:"get",
				//返回方式
				dataType:"json",
				data:{
					"collectorsname":collectorsname
				},
				error:function(){
					alert("请求失败");	
				},
				success:function(res){
					//接收
					var indaxli = res.collectorsli;	
					//循环
					for(i=0;i<indaxli.length; i++){
						//创建节点
						alert(indaxli[i].cid);
						var $node = $('<div><h3><table>'+
										'<tr>'+
										'<td>用户:'+indaxli[i].uname+'&nbsp;</td>'+
										'<td>时间:'+indaxli[i].time+'&nbsp;</td>'+
										'<td>地点:'+indaxli[i].site+'&nbsp;</td>'+
										'<td>赏金:'+indaxli[i].money+'&nbsp;</td>'+
										'<td>简介:'+indaxli[i].message+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/receiving?id='+indaxli[i].id+'&'+'orderuname='+collectorsname+'>接取订单</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/comment?id='+indaxli[i].id+'&'+'orderuname='+collectorsname+'>发表评论</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/cancel?id='+indaxli[i].cid+'>取消收藏</a>'+'&nbsp;</td>'+
										'</tr>'+	
										'</table>'+
										'</h3>'+
										'</div>'	
							);
						//放入
						$("#collectors").append($node);
						
						
					}
					
				}
			})
			
		

	})
	</script>	
</html>