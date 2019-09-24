package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;
import com.util.MD5Util;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ServiceInterface s = new ServiceImplements();
			// 获取session
			HttpSession hs = request.getSession();

			String loginuname = request.getParameter("uname");

			String loginupass = request.getParameter("upass");
			hs.setAttribute("loguname", loginuname);// 用户名回显
			// 判断非空
			if (loginuname != null && loginuname != "" && loginupass != null && loginupass != "") {
			// md5加密
			loginupass = MD5Util.MD5(loginupass);
			// 创建一个用户
			User u = new User();
			u.setUname(loginuname);
			u.setUpass(loginupass);
			//登录
			u = s.login(u);	
			if (u != null) {// 登录成功
				hs.setAttribute("img", u.getImg());// 头像
				System.out.println("你的头像路径是:"+u.getImg());
				hs.setAttribute("indaxname", u.getUname());
				hs.setAttribute("user", u);// 设置权限
				if (u.getState() == 0) {
					response.sendRedirect("indax/userIndax.jsp");
				} else if(u.getState() == 1) {
	
					hs.setAttribute("user", u);
					response.sendRedirect("indax/administratorIndax.jsp");
				}
			} else {
				hs.setAttribute("loghint", "用户名或密码错误");// 提示
				response.sendRedirect("jsp/login.jsp");
			}
		}else {
			hs.setAttribute("loghint", "用户名或密码错误");//提示
			response.sendRedirect("jsp/login.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
