<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<link rel="stylesheet" href="../css/login.css" />
<body background="../img/login.jpg">
	<div class="indax">
		<p class="bang">HELP</p>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<input class="uname" type="text" placeholder="用户名" name="uname" value="${loguname}"><h1 class="ti">${loghint}</h1>	
			<input class="upass" type="password" placeholder="密码" name="upass">
			<input class="sub" type="submit" value="登    录">
			<a class="zhu" href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a>
			<a class="wang" href="${pageContext.request.contextPath}/jsp/upass.jsp">？忘记密码</a>
		</form>
	</div>
</body>
</html>