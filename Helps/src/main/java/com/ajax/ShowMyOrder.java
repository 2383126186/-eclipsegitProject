package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.entity.Task;
import com.entity.User;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class Showmyorder
 */
@WebServlet("/showmyorder")
public class ShowMyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
	
		// 获取写

				PrintWriter pw = response.getWriter();
				// 获取ajax值
				String uname = request.getParameter("bangname");
				// 调dao

				User u = new User();
				u.setUname(uname);
				// 获取我的订单集合
				//ajax显示我的订单
				List<Task> li = s.showmyorder(u);
				
				// 获取json工具类对象
				JSONObject json = new JSONObject();
				// 放入json
				json.put("showmyorderli", li);
				// 写出去
				pw.write(json.toJSONString());
				// 刷新流
				pw.flush();
				// 关闭流
				pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
