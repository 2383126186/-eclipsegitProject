package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class CheckCodeServlect
 */
@WebServlet("/checkCodeServlect")
public class CheckCodeServlect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultTip = "../img/cuo.png";
		// 获取用户输入人验证码
		String checkcodeClient = request.getParameter("checkcode");
		// 获取Session
		HttpSession hs = request.getSession();
		// 真实验证码值
		String checkcodeServer = (String) hs.getAttribute("CKECKCODE");
		if (checkcodeClient.equals(checkcodeServer)) {
			resultTip = "../img/dui.png";
		}
		PrintWriter pw;

		pw = response.getWriter();
		JSONObject json = new JSONObject();
		json.put("resultTip", resultTip);
		pw.write(json.toJSONString());
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
