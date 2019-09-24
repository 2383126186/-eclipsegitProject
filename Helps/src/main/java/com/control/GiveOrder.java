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
 * Servlet implementation class GiveOrder
 */
@WebServlet("/giveorder")
public class GiveOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveOrder() {
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
				String id = request.getParameter("id");
				// 转为整形
				int i = Integer.parseInt(id);
				

				Task t = new Task();
				t.setId(i);
				//放弃订单
				boolean temp = s.giveorder(t);
				
				
				if (temp) {
					// 放弃成功
					hs.setAttribute("myorderreceivingerro", "订单已放弃");

					response.sendRedirect("home/myorderreceiving.jsp");

				} else {
					// 放弃失败
					hs.setAttribute("myorderreceivingerro", "订单放弃失败");

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
