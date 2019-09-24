<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改订单</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js">
</script>
<link rel="stylesheet" href="../layui/css/layui.css" />
<body>
	<form action="${pageContext.request.contextPath}/amendorder" method="post">
	<!-- 修改订单的id -->
		<p>${amendordererro}</p>
		<input type="hidden" name="id" value="${amendorderid}" id="amendorderid">
		<!-- 地点 -->
		地点：<input type="text" name ="site" id ="site">
		<!-- 赏金 -->
		赏金：<input type="text" name ="money" id ="money">
		<!-- 内容 -->
		

		 <div class="layui-form-item layui-form-text">
   			 <label class="layui-form-label">任务内容：</label>
   			 <div class="layui-input-block">
    		  <textarea placeholder="请输入内容" class="layui-textarea" name="message" id="message"></textarea>
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

<script type="text/javascript">
	$(function(){
		var amendorderid = $("#amendorderid").val();
			$.ajax({
				//后台路径
				url:"http://localhost:8080/Helps/lookmyorder",
				//指定提交方式
				type:"get",
				//返回方式
				dataType:"json",
				data:{
					"amendorderid":amendorderid
				},
				error:function(){
					alert("请求失败");	
				},
				success:function(res){
					//接收
					var lookmyorder = res.lookmyorder;	
						//放入
						  $("#site").attr("value",lookmyorder.site);
						  $("#money").attr("value",lookmyorder.money);
						  $("#message").val(lookmyorder.message);
						
					}
					
				
			})
	})
	</script>

<script src="../layui/layui.all.js"></script>

</html>