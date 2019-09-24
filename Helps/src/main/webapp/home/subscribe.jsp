<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>预约订单</title>
</head>
<link rel="stylesheet" href="../layui/css/layui.css" />
<body>
	<p>${subscribeerro}</p>
	<form action="${pageContext.request.contextPath}/subscribe" method="post">
		<input type="hidden" name ="subscribename" value="${Myhome}">
		<!-- 地点 -->
		地点：<input type="text" name ="site" value="${subscribesite}">
		<!-- 赏金 -->
		赏金：<input type="text" name ="money" value="${subscribemoney}">
		<!-- 内容 -->
		
		
		<div class="layui-form">
  			<div class="layui-form-item">
   		 		<div class="layui-inline">
     	 			<label class="layui-form-label">请选择出生日期</label>
     			<div class="layui-input-inline">
     	  			 <input type="text" class="layui-input" id="test11" placeholder="yyyy.MM.dd" name="time" value="${subscribetime}">
     		 </div>
  		</div>
		

		 <div class="layui-form-item layui-form-text">
   			 <label class="layui-form-label">任务内容：</label>
   			 <div class="layui-input-block">
    		  <textarea placeholder="请输入内容" class="layui-textarea" name="message">${subscribemessage}</textarea>
   		 	</div>
  		</div>
  		
  		<div class="layui-form-item">
  		 	 <div class="layui-input-block">
  		 	 		<input class="layui-btn" lay-filter="demo1" type="submit" value="发布任务">
     			 <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    		</div>
 		 </div>
		
	</form>
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