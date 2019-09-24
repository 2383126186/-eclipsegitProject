package com.serviceInte;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Task;
import com.entity.User;
import com.entity.Collectors;
import com.entity.Comments;
public interface ServiceInterface {
	//登录
	User login(User u);
	//注册
	void register(HttpServletRequest request, HttpServletResponse response)throws IOException ;
	//ajax判断用户名
	boolean ifUname(User u);
	//ajax判断手机号
	boolean ifPhone(User u);
	//找回密码
	boolean findUpass(User u);
	//找回的修改密码
	boolean alterUpass(User u);
	//家
	boolean Myhome(Task t);
	//显示订单
	List<Task> showorder();
	//接取订单
	void receiving(HttpServletRequest request, HttpServletResponse response)throws IOException;
	//发布任务
	boolean release(Task t);
	//完善信息
	boolean fullmessage(User u);
	//ajax显示我的订单
	List<Task> showmyorder(User u);
	//删除订单
	void delectorder(HttpServletRequest request, HttpServletResponse response)throws IOException;
	//ajax查找我的订单并填充
	Task lookmyorder(Task t);
	//修改订单
	void amendorder(HttpServletRequest request, HttpServletResponse response)throws IOException;
	//预约订单
	boolean subscribe(Task t);
	//ajax搜索订单
	List<Task> seek(Task t);
	//ajax查询我的接单
	void myorderreceiving(HttpServletRequest request, HttpServletResponse response)throws IOException;
	//完成订单
	boolean orderorderachieve(Task t);
	//收藏订单
	void collect(HttpServletRequest request, HttpServletResponse response)throws IOException;
	//我的收藏
	void Collectors(HttpServletRequest request, HttpServletResponse response)throws IOException;
	//取消收藏
	boolean cancel(Collectors c);
	//管理员查看我的订单
	List<Task> lookorder();
	//查询所有用户
	List<User> lookuser();
	//管理员删除用户
	boolean delectuser(User u);
	//管理员删除订单
	boolean administratordelectorder(User u);
	//提示
	int Prompt(Task t);
	//发表评论
	boolean discuss(Comments c);
	//查看评论
	List<Comments> lookcomment(Task t);
	//放弃订单
	boolean giveorder(Task t);

	


}
