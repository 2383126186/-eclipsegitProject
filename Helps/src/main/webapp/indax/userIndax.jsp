<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js">
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/indax.css" />
<body>
	<div class="home">
		<div class="home1">
			<img class="im" src="${pageContext.request.contextPath}/img/2.png" width="70px" /><h1 class="biao">HELP</h1>
			<p class="name">欢迎您：${indaxname}</p>
			
			<!-- 家 -->
		<form action="${pageContext.request.contextPath}/myhome" method="get">
					<input type="hidden" name ="uname" value="${indaxname}" id="indaxname">
					<input class="home2" type="submit" value="home">
		</form>
		<h3 id = "prompt"></h3>
				<!-- 标题 -->
				<h1 class="biao1">HELP</h1>
				<img class="img" alt="图片" src="${pageContext.request.contextPath}/img/${img}" width="50px">
		</div>
		
		<div class="home3">
		<h1 class="es">${ess}</h1>
		<h1 class="es">${error}</h1>
		
		
	<form action="${pageContext.request.contextPath}/seek" method="get">
		<input id ="bill" class="bill" type="text" name="bill" placeholder="输入内容地址或者名字查询">
		<input type="submit" value="搜 索" class="seek" id="seek">
		<input type="hidden" value="1" name="pageNo">	
		<input type="hidden" value="1${seeki}" id="seeki">
	</form>
	<!-- 显示订单 -->
		<div class="home4" id="order">
		<p>${userindaxerro}</p>
			<c:forEach items="${seekli}" var="li">
				<h3>
					<table>
						<tr>
						<td>用户:${li.uname}&nbsp;</td>
						<td>时间:${li.time}&nbsp;</td>
						<td>地点:${li.site}&nbsp;</td>
						<td>赏金:${li.money}&nbsp;</td>
						<td>简介:${li.message}&nbsp;</td>
						<td><a href="${pageContext.request.contextPath}/receiving?id=${li.id}&orderuname=${indaxname}">接取订单</a>&nbsp;</td>
						<td><a href="${pageContext.request.contextPath}/comment?id=${li.id}&orderuname=${indaxname}">发表评论</a>&nbsp;</td>
						<td><a href="${pageContext.request.contextPath}/lookcomment?id=${li.id}">查看评论</a>&nbsp;</td>
						<td><a href="${pageContext.request.contextPath}/collect?id=${li.id}&orderuname=${indaxname}">收藏订单</a>&nbsp;</td>
						</tr>
					</table>
				</h3>
			</c:forEach>
				<div class="vis" id ="vis">
					<a href="${pageContext.request.contextPath}/seek?pageNo=1&bill=${bill}">
						<button type="button" class="layui-btn">首页</button>
					</a>
					<c:forEach begin="1" end="${page.pageCount}" var="pageNo">
						<a  href="${pageContext.request.contextPath}/seek?pageNo=${pageNo}&bill=${bill}">${pageNo}</a>
					</c:forEach>
					<span>总页数：${page.pageCount}</span>
					<a href="${pageContext.request.contextPath}/seek?pageNo=${page.pageCount}&bill=${bill}">
						<button id="last" type="button" class="layui-btn">尾页</button>
					</a>
				</div>
		</div>
		
		</div>
		<!-- ajax显示订单 -->
	<script type="text/javascript">
	$(function(){
		var seeki = $("#seeki").val();
		if(seeki == 1){
			$("#vis").attr("style","display:none");
			var indaxname = $("#indaxname").val();
			$.ajax({
				//后台路径
				url:"http://localhost:8080/Helps/showorder",
				//指定提交方式
				type:"get",
				//返回方式
				dataType:"json",
				error:function(){
					alert("请求失败");	
				},
				success:function(res){
					//接收
					var indaxli = res.indaxli;	
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
										'<td><a href=Http://localhost:8080/Helps/receiving?id='+indaxli[i].id+'&'+'orderuname='+indaxname+'>接取订单</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/comment?id='+indaxli[i].id+'&'+'orderuname='+indaxname+'>发表评论</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/lookcomment?id='+indaxli[i].id+'>查看评论</a>'+'&nbsp;</td>'+
										'<td><a href=Http://localhost:8080/Helps/collect?id='+indaxli[i].id+'&'+'orderuname='+indaxname+'>收藏订单</a>'+'&nbsp;</td>'+
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
		}
	})
	</script>
	<!-- 提示订单更新 -->
	<script type="text/javascript">
	$(function(){
			var indaxname = $("#indaxname").val();
			$.ajax({
				//后台路径
				url:"http://localhost:8080/Helps/prompt",
				//指定提交方式
				type:"get",
				//返回方式
				dataType:"json",
				data:{
					"indaxname":indaxname
				},
				error:function(){
					alert("请求失败");	
				},
				success:function(res){
					//接收
					var indaxli = res.promptli;	
					if(indaxli == 1){
						$("#prompt").text("你有信息已更新点击home进行查看");
					}else{
						
					}
				}
			})
		
	})
	</script>
	
	<!-- <div class="home5">
	
	</div> -->
	</div>
	
	<!--<%-- <a href="${pageContext.request.contextPath}/home/wang.jsp">家</a> --%>
	<%-- <a href="${pageContext.request.contextPath}/home/task.jsp">帮帮</a> --%>	-->
	
		
		<!-- 搜索 -->
	<!-- <script type="text/javascript">
	$(function(){
			$("#seek").click(function(){
				var billname = $("#bill").val();
				$.ajax({
					//后台路径
					url:"http://localhost:8080/Help/seek",
					//指定提交方式
					type:"get",
					//返回方式
					dataType:"json",
					error:function(){
						alert("请求失败");	
					},
					data:{
						"billname":billname
					},
					success:function(res){
						//接收
						var indaxli = res.seekli;	
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
											'<td><a href=Http://localhost:8080/Help/receiving?id='+indaxli[i].id+'&'+'orderuname='+indaxname+'>接取订单</a>'+'&nbsp;</td>'+
											'<td><a href=Http://localhost:8080/Help/comment?id='+indaxli[i].id+'&'+'orderuname='+indaxname+'>发表评论</a>'+'&nbsp;</td>'+
											'<td><a href=Http://localhost:8080/Help/full?id='+indaxli[i].id+'&'+'orderuname='+indaxname+'>查看完整信息</a>'+'&nbsp;</td>'+
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
		
	})
	</script> -->
	
</body>
</html>