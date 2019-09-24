package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Servlet implementation class phone
 */
@WebServlet("/ifPhone")
public class IfPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IfPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
		
		// 获取器
			Matcher is = null;
			boolean i = false;
			PrintWriter pw = response.getWriter();
			String phone = request.getParameter("phone");
			JSONObject js = new JSONObject();
			Pattern p = Pattern.compile("^[1][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$");
			is = p.matcher(phone);
			i = is.matches();
			String str = null;
			User u = new User();
			u.setPhone(phone);
			//ajax判断手机号
			boolean temp =s.ifPhone(u);
			if (i && temp) {
				// 号码正确
				str = "true";
			} else {
				str = "false";
			}
			js.put("avi", str);
			pw.write(js.toJSONString());
			pw.flush();
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
