<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>忘记密码</title>

</head>
<link rel="stylesheet" href="../css/register.css" />
<body>
	
		<div class="di">
		<img class="im" src="../img/2.png" width="70px" /><h1 class="biao">HELP</h1><a class="biao1" href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a>
	</div>

		<h1 class="biao2">用 户 找 回 用 户</h1>
		<hr class="hr"/>
		<h1 class="biao3">用户名:</h1>
		<h1 class="biao5">手机号:</h1>
	<form action="${pageContext.request.contextPath}/findUpass" method="get">
		<input class="uname" type="text" name="uname" placeholder="需要找回的用户名" value="${finduname}">
		<input class="phone" type="text" name ="phone" onkeyup="value=value.replace(/[^1234567890-]+/g,'')" onblur="end()" value="${findphone}"><h1>${finderro}</h1>		
		<input class="sub" type="submit" value="找    回">
	</form>




	<%-- <h1>${exceupss}</h1>
	<form action="${pageContext.request.contextPath}/findUpass" method="get">
		请输入需要找回的用户名	<input type="text" name ="uname" value="${nameupass}">
		<input type="text" name ="phone" onkeyup="value=value.replace(/[^1234567890-]+/g,'')" onblur="end()" value="${phone}">			
	<input type="submit" value="一键找回">
	</form> --%>
</body>

</html>