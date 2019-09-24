<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${oess}</h1>
	<form action="${pageContext.request.contextPath}/alterUpass" method="get">
		<input type="hidden" name = "uname" value="${alteruname}"> 
		<input type="text" name ="upass">
		<input type="submit" value ="修改">
	</form>
</body>
</html>