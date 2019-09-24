<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" href="../css/adm.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jq.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 后台布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="javascript:order();" id="order">订单管理</a></li>
      <li class="layui-nav-item"><a href="javaScript:user();">用户管理</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          <h5 id ="us">${indaxname}</h5>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">所有商品</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="">发布商品</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;" id = "allorder">${delectusererro}${administratordelectordererro}</div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script src="../layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
</script>
<script type="text/jscript">
	function order(){	
		$(document).ready(function () {
			$.ajax({	
				//后台路径
						url:"http://localhost:8080/Helps/lookorder",
						//指定提交方式
						type:"post",
						//返回方式
						dataType:"json",
						
						error:function(){
							alert("请求失败");	
						},
						success:function(res){
						//接收
						var indaxli = res.lookorderli;	
						//循环
						for(i=0;i<indaxli.length; i++){
							//创建节点
							if(indaxli[i].state == 1){
								var state = "订单已接收";
							}else if(indaxli[i].state == 0){
								var state = "订单未接收";
							}else{
								var state = "订单已完成";
							}
							var $node = $('<div><h3><table>'+
											'<tr>'+
											'<td>用户:'+indaxli[i].uname+'&nbsp;</td>'+
											'<td>时间:'+indaxli[i].time+'&nbsp;</td>'+
											'<td>地点:'+indaxli[i].site+'&nbsp;</td>'+
											'<td>赏金:'+indaxli[i].money+'&nbsp;</td>'+
											'<td>简介:'+indaxli[i].message+'&nbsp;</td>'+
											'<td>状态:'+state+'&nbsp;</td>'+
											'<td><a href=Http://localhost:8080/Helps/administratordelectorder?id='+indaxli[i].id+'>删除订单</a>'+'&nbsp;</td>'+
											'</tr>'+	
											'</table>'+
											'</h3>'+
											'</div>'	
								);
							//放入
							$("#allorder").append($node);
						}
					}
						
				})
			 
		
		})
	}
</script>
	
<script type="text/jscript">
	function user(){	
		$(document).ready(function () {
			$.ajax({
				//后台路径
						url:"http://localhost:8080/Helps/lookuser",
						//指定提交方式
						type:"post",
						//返回方式
						dataType:"json",
						
						error:function(){
							alert("请求失败");	
						},
						success:function(res){
						//接收
						var indaxli = res.lookuserli;	
						//循环
						for(i=0;i<indaxli.length; i++){
							//创建节点
							var $node = $('<div><h3><table>'+
											'<tr>'+
											'<td>用户:'+indaxli[i].uname+'&nbsp;</td>'+
											'<td>身份证:'+indaxli[i].idCard+'&nbsp;</td>'+
											'<td>真实姓名:'+indaxli[i].name+'&nbsp;</td>'+
											'<td>电话:'+indaxli[i].phone+'&nbsp;</td>'+
											'<td>地点:'+indaxli[i].site+'&nbsp;</td>'+
											'<td>性别:'+indaxli[i].gender+'&nbsp;</td>'+
											'<td>出生日期:'+indaxli[i].age+'&nbsp;</td>'+
											'<td><a href=Http://localhost:8080/Helps/delectuser?id='+indaxli[i].id+'>删除用户</a>'+'&nbsp;</td>'+
											'</tr>'+	
											'</table>'+
											'</h3>'+
											'</div>'	
								);
							//放入
							$("#allorder").append($node);
						}
					}
						
				})

		})
	}
</script>

</body>
</html>