<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>发布任务</title>
</head>
<link rel="stylesheet" href="../layui/css/layui.css" />
<link rel="stylesheet" href="../css/release.css" />
<body>
	<div class="home">
		<p class="fa">发布任务</p>
	<p class="erro">${releaseerro}</p>
	<form action="${pageContext.request.contextPath}/release" method="post">
		<input type="hidden" name ="releasename" value="${Myhome}">
		<!-- 地点 -->
		<h5 class="si">地点：</h5><input class="site" type="text" name ="site" value="${releasesite}">
		<!-- 赏金 -->
		<h5 class="mo">赏金：</h5><input class="money" type="text" name ="money" value="${releasemoney}">
		<!-- 内容 -->
		
	<div class="home2">
		<div class="layui-form-item layui-form-text">
   			 <label class="layui-form-label">任务内容：</label>
   			 <div class="layui-input-block">
    		  <textarea placeholder="请输入内容" class="layui-textarea" name="message">${releasemessage}</textarea>
   		 	</div>
  		</div>
  		<div class="home3">
  		<div class="layui-form-item">
  		 	 <div class="layui-input-block">
  		 	 	<input class="layui-btn" lay-filter="demo1" type="submit" value="发布任务">
    		</div>
 		</div>
		<div>
		</div>
		
		
		
	</form>
	</div>
</body>	
<script src="../layui/layui.all.js"></script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  laydate.render({
    elem: '#test11'
    ,format: 'yyyy.MM.dd'
  });
  laydate.render({
    elem: '#test12'
    ,format: 'dd/MM/yyyy'
  });
  laydate.render({
    elem: '#test13'
    ,format: 'yyyyMMdd'
  });
  laydate.render({
    elem: '#test14'
    ,type: 'time'
    ,format: 'H.m'
  });
  laydate.render({
    elem: '#test15'
    ,type: 'month'
    ,range: '~'
    ,format: 'yyyy-MM'
  });
  laydate.render({
    elem: '#test16'
    ,type: 'datetime'
    ,range: '到'
    ,format: 'yyyy.M.d.H.m.s'
  });
});
</script>
</html>
</html>