<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>家</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js">
</script>
<link rel="stylesheet" href="../css/wanghome.css" />
<body>
<div class="home">
	<div class="home1">
	<h2 class="biao">HELP</h2>
	<img class="biaoimg" class="img" alt="图片" src="${pageContext.request.contextPath}/img/${img}" width="50px">
	
	<!-- 修改头像 未开始 -->
	
	<!-- 主页 完成 -->
	<a class="indax" href="${pageContext.request.contextPath}/indax/userIndax.jsp">主页</a>
	
	<!-- 发布订单 完成 -->
	<a class="re" href="${pageContext.request.contextPath}/home/release.jsp">发布订单</a>
	
	<!-- 预约订单-->
	<a class="su" href="${pageContext.request.contextPath}/home/subscribe.jsp">预约订单</a>
	
	<!-- 我的收藏-->
	<a class="co" href="${pageContext.request.contextPath}/home/collectors.jsp">我的收藏</a>
	
	<!-- 修改密码 完成 -->
	<form action="${pageContext.request.contextPath}/useralterupass" method="get">
		<input type="hidden" name="alterupassname" value="${Myhome}" id="bang">
		<input class="sub" type="submit" value="修改密码">
	</form>
	
	<!-- 完善信息 完成 -->
	<a class="fu" href="${pageContext.request.contextPath}/home/fullmessage.jsp">完善信息</a>
	
	
	<!-- 我的接单 完成 -->
	<a class="my" href="${pageContext.request.contextPath}/home/myorderreceiving.jsp">我的接单</a>
	<!-- 切换账号  完成 -->
	<a class="lo" href="${pageContext.request.contextPath}/jsp/login.jsp">切换账号</a>
	</div>
	
	
	<div>
			<!-- 我的订单 完成 -->
			<p class="wo">我的订单</p>
			<div class="myrelease" id ="order">
				<p class="myerro">${delectordererro}</p>
			</div>					
			<h3 id="">首页</h3>
			
			
	</div>
</div>	
</body>
<!-- ajax显示我的订单 -->
	<script type="text/javascript">
	$(function(){
		var bangname = $("#bang").val();
			$.ajax({
				//后台路径
				url:"http://localhost:8080/Helps/showmyorder",
				//指定提交方式
				type:"get",
				//返回方式
				dataType:"json",
				data:{
					"bangname":bangname
				},
				error:function(){
					alert("请求失败");	
				},
				success:function(res){
					//接收
					var indaxli = res.showmyorderli;	
					//循环
					for(i=0;i<indaxli.length; i++){
						if(indaxli[i].state == 1){
							var state = "订单已接收";
						}else if(indaxli[i].state == 0){
							var state = "订单未接收";
						}else{
							var state = "订单已完成";
						}
						//创建节点
						var $node = $('<div><h3><table>'+
										'<tr>'+
										'<td>用户:'+indaxli[i].uname+'&nbsp;</td>'+
										'<td>时间:'+indaxli[i].time+'&nbsp;</td>'+
										'<td>地点:'+indaxli[i].site+'&nbsp;</td>'+
										'<td>赏金:'+indaxli[i].money+'&nbsp;</td>'+
										'<td>简介:'+indaxli[i].message+'&nbsp;</td>'+
										'<td>状态:'+state+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/delectorder?id='+indaxli[i].id+'>删除订单</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/skipamendorder?id='+indaxli[i].id+'>修改订单</a>'+'&nbsp;</td>'+
										'</tr>'+	
										'</table>'+
										'</h3>'+
										'</div>'	
							);
						//放入
						$("#order").append($node);
						
						
					}
					
				}
			})
			
		

	})
	</script>
</html>