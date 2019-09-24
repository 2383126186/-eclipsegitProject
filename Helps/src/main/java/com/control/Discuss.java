package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entity.Comments;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class Discuss
 */
@WebServlet("/discuss")
public class Discuss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Discuss() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
		
		
		HttpSession hs = request.getSession();
		String id = request.getParameter("id");
		String orderuname = request.getParameter("orderuname");
		String discussmessage = request.getParameter("discussmessage");
		if (discussmessage != null && discussmessage != "") {
			Comments comment = new Comments();
			comment.setTid(Integer.parseInt(id));
			comment.setUname(orderuname);
			comment.setComment(discussmessage);
			boolean temp = s.discuss(comment);
		
			if (temp) {
				// 成功
				hs.setAttribute("discusserro", "发表成功");

				response.sendRedirect("indax/discuss.jsp");

			} else {
				// 失败
				hs.setAttribute("discusserro", "发表失败");

				response.sendRedirect("indax/discuss.jsp");

			}
		} else {
			hs.setAttribute("discusserro", "输入内容为空");

			response.sendRedirect("indax/discuss.jsp");

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
