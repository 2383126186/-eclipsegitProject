package com.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.daoImpl.DaoImplements;
import com.daoInte.DaoInterface;
import com.entity.Collectors;
import com.entity.Comments;

import com.entity.Task;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.serviceInte.ServiceInterface;
import com.util.MD5Util;

public class ServiceImplements implements ServiceInterface {
	//dao
	DaoInterface d = new DaoImplements();
	// 登录
	@Override
	public User login(User u)  {
		u  = d.Login(u);//用户
		return u;
	}

	// 注册
	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		// 获取session
		HttpSession hs = request.getSession();
		// 获取表单内容
		String registeruname = request.getParameter("uname");
		String registerupass = request.getParameter("upass");
		String registerphone = request.getParameter("phone");
		String checkcode = request.getParameter("checkcode");
		// 真实验证码
		String checkcodeServer = (String) hs.getAttribute("CKECKCODE");

		// 内容回显
		hs.setAttribute("registeruname", registeruname);
		hs.setAttribute("registerupass", registerupass);
		hs.setAttribute("registerphone", registerphone);
		hs.setAttribute("checkcode", checkcode);
		// 获取电话号码规则
		Pattern p = Pattern.compile("^[1][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$");
		Matcher m = p.matcher(registerphone);
		boolean b = m.matches();// 匹配
		if (registeruname != null && registeruname != "" && registerupass != null && registerupass != ""
				&& registerphone != null && registerphone != "" && checkcode != null && checkcode != "") {
			// 判断验证码是否正确
			if (checkcodeServer.equals(checkcode)) {
				// Md5加密
				String upass = MD5Util.MD5(registerupass);
				if (b) {
					// 调用dao判断用户名是否存在

					User u = new User();
					u.setUname(registeruname);
					u.setUpass(upass);
					u.setPhone(registerphone);
					// 调用dao判断手机号是否存在
					u = d.ifUser(u);
					if (u.getUname() == null) {
						// 调用dao判断手机号是否存在
						u = d.ifPhone(u);

						if (u.getPhone() == null) {
							// 调用dao储存用户
							u.setUname(registeruname);
							u.setUpass(upass);
							u.setPhone(registerphone);
							if (d.addUser(u)) {
								// 储存成功
								response.sendRedirect("jsp/login.jsp");
							} else {
								// 储存失败
								response.sendRedirect("jsp/register.jsp");
							}

						} else {
							hs.setAttribute("registerint", "手机号码已存在");
							response.sendRedirect("jsp/register.jsp");
						}
						// 用户名重复
					} else {
						hs.setAttribute("registererro", "用户名重复");
						response.sendRedirect("jsp/register.jsp");
					}
					// 手机号不正确
				} else {
					hs.setAttribute("registerint", "手机号不正确");
					response.sendRedirect("jsp/register.jsp");
				}
				// 判断非空
			} else {
				hs.setAttribute("registerint", "内容为空");
				response.sendRedirect("jsp/register.jsp");
			}
		} else {
			hs.setAttribute("registerint", "验证码不正确");
			response.sendRedirect("jsp/register.jsp");
		}

	}

	// ajax判断用户名
	@Override
	public boolean ifUname(User u)  {
		u = d.ifUser(u);
		return u == null?true:false;
	}

	// ajax判断手机号
	@Override
	public boolean ifPhone(User u)  {
		u = d.ifPhone(u);
		return u == null?true:false;
	}

	// 找回密码（忘记密码）
	@Override
	public boolean findUpass(User u)  {
		u = d.findUpass(u);
		return u == null?true:false;
	}

	// 修改密码
	@Override
	public boolean alterUpass(User u)  {
		return d.alterUpass(u);
	}

	// 家
	@Override
	public boolean Myhome(Task t)  {
		if(d.modifyprompt(t) && d.ermodifyprompt(t)) {
			return true;
		}else {
			return false;
		}
	}

	// ajax显示订单
	@Override
	public List<Task> showorder()  {
		return d.showorder();
	}

	// 接取订单
	@Override
	public void receiving(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		// 获取Session
		HttpSession hs = request.getSession();
		// 获取表单内容
		String receivingname = request.getParameter("orderuname");// 接取人名字
		// 单号id
		String id = request.getParameter("id");
			// 创建对象
			User u = new User();
			u.setUname(receivingname);
			// 获取接单用户id
			u = d.acquire(u);
			// 用户id
			// 转换int
			int oddid = Integer.parseInt(id);
			// 创建订单对象
			Task t = new Task();
			t.setId(oddid);
			Task ta = d.iforder(t);
			if (ta.getUname().equals(receivingname)) {
				hs.setAttribute("userindaxerro", "不能接取自己的订单");
				response.sendRedirect("indax/userIndax.jsp");
			} else {
				// 调用dao储存接取并转换为以接取
				boolean temp = d.receiving(u, t);
				if (temp) {
					hs.setAttribute("userindaxerro", "接取成功");
					response.sendRedirect("indax/userIndax.jsp");
				} else {
					response.sendRedirect("indax/userIndax.jsp");
				}
			}

	}
	// 发布任务
	@Override
	public boolean release(Task t)  {
		return d.release(t);
	}

	// 完善信息
	@Override
	public boolean fullmessage(User u)  {
		return d.fullmessage(u);
	}

	// ajax显示我的订单
	@Override
	public List<Task> showmyorder(User u)  {
		return d.showmyorder(u);
	}

	// 删除订单
	@Override
	public void delectorder(HttpServletRequest request, HttpServletResponse response)throws IOException  {
		// 获取session
		HttpSession hs = request.getSession();
		// 获取需要删除的订单号
		String id = request.getParameter("id");
		// 转形
		int i = Integer.parseInt(id);
		

		User u = new User();
		u.setId(i);
		Task t = new Task();
		t.setId(i);
		t = d.lookstate(t);
		int state = Integer.parseInt(t.getState());
		if (state == 0) {
			// 删除订单
			boolean temp = d.delectorder(u);
			if (temp) {
				// 订单删除成功
				hs.setAttribute("delectordererro", "订单删除成功");

				response.sendRedirect("home/indax.jsp");

			} else {
				// 订单删除失败
				hs.setAttribute("delectordererro", "订单删除失败");

				response.sendRedirect("home/indax.jsp");

			}
		} else {
			hs.setAttribute("delectordererro", "该订单已被接取，不能删除");

			response.sendRedirect("home/indax.jsp");

		}
	}


	// ajax查找我的订单并填充
	@Override
	public Task lookmyorder(Task t)  {
		return d.lookmyorder(t);
	}

	// 修改订单
	@Override
	public void amendorder(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		// 获取session
		HttpSession hs = request.getSession();
		// 获取表单内容
		String id = request.getParameter("id");
		int i = Integer.parseInt(id);
		String site = request.getParameter("site");
		String money = request.getParameter("money");
		String message = request.getParameter("message");
		hs.setAttribute("amendorderid", id);
		if (id != null && id != "" && site != null && site != "" && money != null && money != "" && message != null
				&& message != "") {
			

			Task t = new Task();
			t.setId(i);
			t.setSite(site);
			t.setMoney(money);
			t.setMessage(message);
			// 查询该单的状态
			t = d.lookstate(t);
			int state = Integer.parseInt(t.getState());
			if (state == 0) {
				// 修改订单
				boolean temp = d.amendorder(t);
				if (temp) {// 修改成功
					hs.setAttribute("amendordererro", "修改成功");

					response.sendRedirect("home/amendorder.jsp");

				} else {
					// 修改失败
					hs.setAttribute("amendordererro", "修改失败");

					response.sendRedirect("home/amendorder.jsp");

				}
			} else {
				hs.setAttribute("amendordererro", "该订单已被接取，不能更改");

				response.sendRedirect("home/amendorder.jsp");

			}
		} else {
			hs.setAttribute("amendordererro", "信息为空");

			response.sendRedirect("home/amendorder.jsp");

		}
	}

	// 预约订单
	@Override
	public boolean subscribe(Task t)  {
		return d.subscribe(t);
	}

	//搜索订单
		@Override
		public List<Task> seek(Task t) {
			return d.seek(t);	
		}

	// ajax查询我的接单
	@Override
	public void myorderreceiving(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		// 获取写

		PrintWriter pw = response.getWriter();
		// 获取用户名
		String uname = request.getParameter("myorderreceivingname");
			
			User u = new User();
			u.setUname(uname);
			// 找到该用户id
			u = d.acquire(u);
			// ajax查询我的接单
			List<Task> li = d.myorderreceiving(u);
			// 创建jsonObject对象
			JSONObject json = new JSONObject();
			// 将集合放入json
			json.put("myorderreceivingli", li);
			json.put("myordererro", "你还没有接的订单");
			// 写出去
			pw.write(json.toJSONString());
			// 刷新流
			pw.flush();
			// 关闭流
			pw.close();


	}

	// 完成订单
	@Override
	public boolean orderorderachieve(Task t)  {
				return d.orderorderachieve(t);
	}

	// 收藏订单
	@Override
	public void collect(HttpServletRequest request, HttpServletResponse response)throws IOException  {
		// 获取session
		HttpSession hs = request.getSession();
		// 获取订单id和用户名
		String uname = request.getParameter("orderuname");
		String id = request.getParameter("id");
			// 转为整形
			int i = Integer.parseInt(id);
			

			Task t = new Task();
			t.setId(i);
			Task ta = d.iforder(t);
			if (ta.getUname().equals(uname)) {
				hs.setAttribute("userindaxerro", "不能收藏自己的订单");

				response.sendRedirect("indax/userIndax.jsp");

			} else {
				User u = new User();
				u.setUname(uname);
				// 获取收藏用户id
				u = d.acquire(u);
				Collectors c = new Collectors();
				c.setTid(i);
				c.setUid(u.getId());
				// 收藏
				boolean temp = d.collector(c);
				if (temp) {
					// 成功
					hs.setAttribute("userindaxerro", "收藏成功");

					response.sendRedirect("indax/userIndax.jsp");

				} else {
					// 失败
					hs.setAttribute("userindaxerro", "收藏失败");

					response.sendRedirect("indax/userIndax.jsp");

				}
			}

	}

	// 我的收藏
	@Override
	public void Collectors(HttpServletRequest request, HttpServletResponse response)throws IOException  {
		// 获取写
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("collectorsname");
			// 获取用户id

			User u = new User();
			u.setUname(uname);
			u = d.acquire(u);
			// 获取用户收藏
			List<Collectors> li = d.collectors(u);
			// 获取JSONObject
			JSONObject json = new JSONObject();
			// 存入json
			json.put("collectorsli", li);
			// 写出json
			pw.write(json.toJSONString());
			// 刷新流
			pw.flush();
			// 关闭流
			pw.close();

	}

	// 取消收藏
	@Override
	public boolean cancel(Collectors c)  {
		return d.cancel(c);
	}


	// 管理员查看我的订单
	@Override
	public List<Task> lookorder()  {
		return d.lookorder();
	}

	// 查询所有用户
	@Override
	public List<User> lookuser()  {
		return d.lookuser();
	}

	// 管理员删除用户
	@Override
	public boolean delectuser(User u)  {
		return d.delectorder(u);
	}

	@Override
	public boolean administratordelectorder(User u)  {
		return d.delectorder(u);
	}

	// 提示
	@Override
	public int Prompt(Task t)  {
		return d.Prompt(t);
	}


	// 发表评论
	@Override
	public boolean discuss(Comments c)  {
		return d.discuss(c);
	}

	// 查看评论
	@Override
	public List<Comments> lookcomment(Task t)  {
		return d.lookcomment(t);
	}

	// 放弃订单
	@Override
	public boolean giveorder(Task t)  {
		return d.giveorder(t);
	}

	// 分页
	public void queryAll5() {

		PageHelper.startPage(1, 4);
		List<Task> li = d.queryAll5();
		PageInfo<Task> info = new PageInfo<Task>(li);
		info.setList(li);
		for (Task nt : info.getList()) {
			System.out.println(nt);
		}
	}

	





}
