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
import com.entity.User;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class LookUser
 */
@WebServlet("/lookuser")
public class LookUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
		
		// 获取写
				PrintWriter pw;

				pw = response.getWriter();
				// 获取用户名是否是管理员

				List<User> li = s.lookuser();;
				// jsonOject对象
				JSONObject json = new JSONObject();
				// 放入json
				json.put("lookuserli", li);
				// 写出json
				pw.write(json.toJSONString());
				// 刷新
				pw.flush();
				// 关闭
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
