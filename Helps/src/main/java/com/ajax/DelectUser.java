package com.ajax;

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
 * Servlet implementation class DelectUser
 */
@WebServlet("/delectuser")
public class DelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelectUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
		
		
		// 获取写

				HttpSession hs = request.getSession();
				// 需要删除的id
				String id = request.getParameter("id");
				if (id != null && id != "") {
					// 转为整形
					int userid = Integer.parseInt(id);

					User u = new User();
					u.setId(userid);
					// 删除该用户
					//管理员删除用户
					boolean temp = s.delectuser(u);
					if (temp) {
						hs.setAttribute("delectusererro", "该用户已删除");
						response.sendRedirect("indax/administratorIndax.jsp");
					} else {
						hs.setAttribute("delectusererro", "该用户未删除");
						response.sendRedirect("indax/administratorIndax.jsp");
					}
				} else {
					response.sendRedirect("indax/administratorIndax.jsp");
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
