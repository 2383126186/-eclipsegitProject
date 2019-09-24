<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>发表评论</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/discuss" method="post">
		<input type="hidden" name = "orderuname" value="${orderuname}"/>
		<input type="hidden" name = "id" value="${id}"/>
		<div class="layui-form-item layui-form-text">
		  <label class="layui-form-label">发表评论</label>
		  <div class="layui-input-block">
		    <textarea placeholder="${orderuname}发表评论" name="discussmessage" class="layui-textarea"></textarea>
		  </div>
		</div>
		<div class="layui-form-item">
		  <div class="layui-input-block">
		    <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
		    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		  </div>
		</div>
	</form>
	<h5>${discusserro}</h5>
</body>
</html>