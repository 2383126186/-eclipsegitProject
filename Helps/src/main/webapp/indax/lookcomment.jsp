<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>显示消息</title>
</head>
<body>
	<c:forEach items="${lookcommentli}" var="li">
				<h3>
					<table>
						<tr>
						<td>用户:${li.uname}&nbsp;</td>
						<td>评论:${li.comment}&nbsp;</td>
						</tr>
					</table>
				</h3>
	</c:forEach>
</body>
</html>