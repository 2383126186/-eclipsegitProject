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
 * Servlet implementation class Fullmessage
 */
@WebServlet("/fullmessage")
public class Fullmessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fullmessage() {
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
				String uname = request.getParameter("fullmessagename");
				String name = request.getParameter("name");
				String idCard = request.getParameter("idCard");
				String time = request.getParameter("time");
				String site = request.getParameter("site");
				String gender = request.getParameter("gender");
				// 内容回购
				hs.setAttribute("fullmessagename", name);
				hs.setAttribute("fullmessageidCard", idCard);
				hs.setAttribute("fullmessagetime", time);
				hs.setAttribute("fullmessagesite", site);
				hs.setAttribute("fullmessagegender", gender);

						// 调用dao

						User u = new User();
						u.setUname(uname);
						u.setName(name);
						u.setIdCard(idCard);
						u.setAge(time);
						u.setSite(site);
						u.setGender(gender);

						//完善信息
						boolean temp = s.fullmessage(u);
						
						if (temp) {
							// 填写成功
							hs.setAttribute("fullmessageerro", "填写成功");

							response.sendRedirect("home/fullmessage.jsp");

						} else {
							// 填写失败
							hs.setAttribute("fullmessageerro", "填写失败");

							response.sendRedirect("home/fullmessage.jsp");

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
