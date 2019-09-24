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

/**
 * Servlet implementation class FindUpass
 */
@WebServlet("/findUpass")
public class FindUpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
		
		// 获取session
				HttpSession hs = request.getSession();
				// 获取表单内容
				String finduname = request.getParameter("uname");
				String findphone = request.getParameter("phone");
				// 内容回购
				hs.setAttribute("finduname", finduname);
				hs.setAttribute("findphone", findphone);
				// 非空判断
				if (finduname != null && finduname != "" && findphone != null && findphone != "") {

					// 调用dao判断是否存在此用户
					User u = new User();
					u.setUname(finduname);
					u.setPhone(findphone);
					//找回密码
					boolean temp = s.findUpass(u);
					if (temp) {
						response.sendRedirect("jsp/alterUpass.jsp");

					} else {
						hs.setAttribute("finderro", "没有该用户");

						response.sendRedirect("jsp/upass.jsp");

					}

				} else {
					hs.setAttribute("finderro", "用户名或手机号为空");

					response.sendRedirect("hsp/upass.jsp");

				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
