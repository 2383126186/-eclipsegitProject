package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Task;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class Orderorderachieve
 */
@WebServlet("/orderorderachieve")
public class Orderorderachieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orderorderachieve() {
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
				// 获取订单号
				String orderorderachieveid = request.getParameter("id");
				if (orderorderachieveid != null && orderorderachieveid != "") {
					// 转换整形
					int id = Integer.parseInt(orderorderachieveid);
					

					Task t = new Task();
					t.setId(id);
					//完成订单
					boolean temp = s.orderorderachieve(t);
					
					if (temp) {
						// 成功
						hs.setAttribute("myorderreceivingerro", "成功");

						response.sendRedirect("home/myorderreceiving.jsp");

					} else {
						// 失败
						hs.setAttribute("myorderreceivingerro", "失败");

						response.sendRedirect("home/myorderreceiving.jsp");

					}
				} else {

					response.sendRedirect("home/myorderreceiving.jsp");

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
