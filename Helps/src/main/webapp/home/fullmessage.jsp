<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>完善信息</title>
</head>
	<link rel="stylesheet" href="../layui/css/layui.css" />
	<link rel="stylesheet" href="../css/fullmessage.css" />
<body>
<div class= "home">
	<p class="tian">${fullmessageerro}填写完整信息</p>
	<form action="${pageContext.request.contextPath}/fullmessage">
		<input type ="hidden" name ="fullmessagename" value="${Myhome}">
		<h3 class="name">真实姓名：<input type="text" name="name" value="${fullmessagename}"></h3>
		<h3 class="idCard">身份证：<input type="text" name="idCard" value="${fullmessageidCard}"></h3>
		
		<h3 class="time"><div class="layui-form">
  			<div class="layui-form-item">
   		 		<div class="layui-inline">
     	 			<label class="layui-form-label">出生日期</label>
     			<div class="layui-input-inline">
     	  			 <input type="text" class="layui-input" id="test11" placeholder="yyyy.MM.dd" name="time" value="${fullmessagetime}">
     		 </div>
  		</div>
		</h3>
		<h3 class="site">家庭地址<input type="text" name="site" value=""></h3>
		
		<h3 class="gender"><input id="man" type="radio" checked="checked" name="gender" value ="男"/>男
		<input id="woman" type="radio"  name="gender" value ="女"/>女</h3>
		<h3 class="sub"><input type="submit" value="完善信息"></h3>
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