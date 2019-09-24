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
 * Servlet implementation class Delectorder
 */
@WebServlet("/administratordelectorder")
public class AdministratorDelectOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorDelectOrder() {
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
				// 获取需要删除的订单号
				String id = request.getParameter("id");
				// 转形
				int i = Integer.parseInt(id);
				

				User u = new User();
				u.setId(i);
				// 删除订单
				//管理员删除订单
				boolean temp = s.administratordelectorder(u);
				
				if (temp) {
					// 订单删除成功
					hs.setAttribute("administratordelectordererro", "订单删除成功");
					response.sendRedirect("indax/administratorIndax.jsp");

				} else {
					// 订单删除失败
					hs.setAttribute("administratordelectordererro", "订单删除失败");
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
