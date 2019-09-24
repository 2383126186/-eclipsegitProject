<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<link rel="stylesheet" href="../css/register.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js">
</script>
<body>

	<div class="di">
		<img class="im" src="../img/2.png" width="70px" /><h1 class="biao">HELP</h1><a class="biao1" href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a>
	</div>

		<h1 class="biao2">用 户 注 册</h1>
		<hr class="hr"/>
		<h1 class="biao3">用户名:</h1>
		<h1 class="biao5">密码:</h1>
		<h1 class="biao4">手机号:</h1>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<input class="uname" type="text" name="uname" value="${registeruname}" id="uname" onblur="end()"><h2 id="mess">${registererro}</h2>
		<input class="phone" type="password" name="upass" value="${registerupass}">
		<input class="upass" onkeyup="value=value.replace(/[^1234567890-]+/g,'')" type="text" name="phone" value="${registerphone}" id="phone" onblur="en()"><h2 id="mes">${registerint}</h2>
		<div class="div2">
			<input type="text" value="${checkcode}" placeholder="验证码" name="checkcode" id="checkcodeId" size ="4"/>
       	 	<!-- 验证码 -->
       		 <a href="javascript:reloadCheckImg();"><img id="imgs" src="index.jsp"/></a>
  	 		 <span id="tip"><img class="ti" height='30px' width='30px'  />${checkcodeerro}</span>
		</div>
		<input class="sub" type="submit" value="注     册">
	</form>
	

	
</body>



  <script type="text/javascript">
  function reloadCheckImg(){
		$("#imgs").attr("src","index.jsp?t="+(new Date().getTime()));
		}
		 $(document).ready(function () {
			 $("#checkcodeId").blur(function () {
				 var checkcode = $("#checkcodeId").val();
				 $.ajax({
						//后台路径
						url:"http://localhost:8080/Helps/checkCodeServlect",
						//指定提交方式
						type:"post",
						//返回方式
						dataType:"json",
						data:{
							"checkcode":checkcode
						},
						error:function(){
							alert("请求失败");	
						},
						success:function(res){
							var resultTip = res.resultTip;
								//放入
								$(".ti").attr("src",resultTip);	
						}
						
				})
			 })
		
	})
</script>

	<!-- 判断用户名电话号码是否正确 -->
<script type="text/javascript">
	$(function(){
		$("#phone").blur(function(){
			var phone = $(this).val();
			if(phone != null && phone != ""){
				$.ajax({
					//后台路径
					url:"http://localhost:8080/Helps/ifPhone",
					//指定提交方式
					type:"get",
					//返回方式
					dataType:"json",
					//发送信息
					data:{
						"phone":phone
					},
					error:function(){
						alert("请求失败");	
					},
					success:function(avi){
							if(avi.avi == "true"){
								$("#mes").text("可用");
							}else{
								$("#mes").text("号码不正确或重复");
							}
					}
				})
			}
			
		})
//判断用户名是否重复
		$("#uname").blur(function(){
			var uname = $(this).val();
			if(uname != null && uname != ""){
				//ajax
				$.ajax({
					//后台路径
					url:"http://localhost:8080/Helps/ifUname",
					//指定提交方式
					type:"get",
					//返回方式
					dataType:"json",
					//发送信息
					data:{
						"uname":uname
					},
					error:function(){
						alert("请求失败");	
					},
					success:function(en){

						if("true"==en.en){
							//可用
							$("#mess").text("可用");
						}else{
							$("#mess").text("用户已存在");
						}
					}
				})
			}
		});
	})
</script>
</html>