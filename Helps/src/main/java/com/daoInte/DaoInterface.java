package com.daoInte;

import java.util.List;

import com.entity.Collectors;
import com.entity.Comments;
import com.entity.Task;
import com.entity.User;

public interface DaoInterface {
	//判断是否是管理员
	public User Login(User u);
	//判断用户名是否存在
	public User ifUser(User u);
	//判断用户手机号是否存在
	public User ifPhone(User u);
	//添加用户
	public boolean addUser(User u);
	//判断是有此用户
	public User findUpass(User u);
	//找回密码，修改
	public boolean alterUpass(User u);
	//显示订单
	public List<Task> showorder();
	//获取接单用户id
	public User acquire(User u);
	//调用dao储存接取并转换为以接取
	public boolean receiving(User u, Task t);
	//储存订单
	public boolean release(Task t);
	//填写完整信息
	public boolean fullmessage(User u);
	//判断是否为自己的订单
	public Task iforder(Task t);
	//显示我的订单
	public List<Task> showmyorder(User u);
	//删除订单
	public boolean delectorder(User u);
	//查找订单
	public Task lookmyorder(Task t);
	//修改订单
	public boolean amendorder(Task t);
	//预约订单
	public boolean subscribe(Task t);
	//ajax查询我的接单
	public List<Task> myorderreceiving(User u);
	//ajax订单搜索
	public List<Task> seek(Task t);
	//修改订单为已完成
	public boolean orderorderachieve(Task t);
	//收藏订单
	public boolean collector(Collectors t);
	//查询我的收藏
	public List<Collectors> collectors(User u);
	//取消收藏
	public boolean cancel(Collectors c);
	//判断是否是管理员
	public User ifadministrator(User u);
	//管理员查看我的订单
	public List<Task> lookorder();
	//管理员查看我的用户
	public List<User> lookuser();
	//查询该单的状态
	public Task lookstate(Task t);
	//查看
	public int Prompt(Task t);
	//修改提示状态
	public boolean modifyprompt(Task t);
	//修改提示状态(完成订单)
	public boolean ermodifyprompt(Task t);
	//储存评论
	public boolean discuss(Comments comment);
	//显示信息
	public List<Comments> lookcomment(Task t);
	//放弃订单
	public boolean giveorder(Task t);
	//查询所有分页
	public List<Task> queryAll5();
}
