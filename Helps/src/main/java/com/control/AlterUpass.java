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

/**
 * Servlet implementation class AlterUpass
 */
@WebServlet("/alterUpass")
public class AlterUpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterUpass() {
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
				String alteruname = request.getParameter("uname");
				String alterupass = request.getParameter("upass");
				// 内容回购
				hs.setAttribute("finduname", alteruname);
				// 非空判断
				if (alterupass != null && alterupass != "") {
					// 修改密码
					User u = new User();
					// md5加密
					String upass = MD5Util.MD5(alterupass);
					u.setUname(alteruname);
					u.setUpass(upass);
					//找回的修改密码
					boolean temp = s.alterUpass(u);
					if (temp) {// 修改成功
						response.sendRedirect("jsp/login.jsp");

					} else {// 修改失败

						response.sendRedirect("jsp/upass.jsp");

					}

				} else {

					response.sendRedirect("jsp/alterUpass");

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
