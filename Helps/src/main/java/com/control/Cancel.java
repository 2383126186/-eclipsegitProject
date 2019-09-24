package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Collectors;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class Cancel
 */
@WebServlet("/cancel")
public class Cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
	
		// 获取Session
				HttpSession hs = request.getSession();
				// 获取用户名和id
				String id = request.getParameter("id");
					// 获取取消收藏用户id

					// 转为int
					int i = Integer.parseInt(id);
					Collectors c = new Collectors();
					c.setId(i);
					
					//取消收藏
					boolean temp = s.cancel(c);
					if (temp) {
						// 取消成功
						hs.setAttribute("cancelerro", "取消成功");

						response.sendRedirect("home/collectors.jsp");

					} else {
						// 取消成功
						hs.setAttribute("cancelerro", "取消失败");

						response.sendRedirect("home/collectors.jsp");

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
