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
 * Servlet implementation class Subscribe
 */
@WebServlet("/subscribe")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subscribe() {
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
				String name = request.getParameter("subscribename");
				String site = request.getParameter("site");
				String money = request.getParameter("money");
				String message = request.getParameter("message");
				String time = request.getParameter("time");
				// 内容回购
				hs.setAttribute("subscribesite", site);
				hs.setAttribute("subscribemoney", money);
				hs.setAttribute("subscribemessage", message);
				hs.setAttribute("subscribetime", time);
					// 判断非空
					if (site != null && site != "" && money != null && money != "" && message != null && message != ""
							&& time != null && time != "") {
						// 调用dao

						Task t = new Task();
						t.setUname(name);
						t.setSite(site);
						t.setMoney(money);
						t.setMessage(message);
						t.setTime(time);
						// 储存订单
						//预约订单
						boolean temp = s.subscribe(t);
						
						if (temp) {
							// 发布成功
							hs.setAttribute("subscribeerro", "发布成功");

							response.sendRedirect("home/subscribe.jsp");

						} else {
							// 发布失败
							hs.setAttribute("subscribeerro", "发布失败");

							response.sendRedirect("home/subscribe.jsp");

						}
					} else {
						hs.setAttribute("subscribeerro", "任务信息不为空");

						response.sendRedirect("home/subscribe.jsp");

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
