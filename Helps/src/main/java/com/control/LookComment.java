package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Comments;
import com.entity.Task;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class LookComment
 */
@WebServlet("/lookcomment")
public class LookComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookComment() {
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
				if (id != null && id != "") {
					

					// 显示符合的评论
					Task t = new Task();
					t.setId(Integer.parseInt(id));
					//查看评论
					List<Comments> li = s.lookcomment(t);
					
					hs.setAttribute("lookcommentli", li);

					response.sendRedirect("indax/lookcomment.jsp");

				} else {
					hs.setAttribute("userindaxerro", "该单已被接取或删除");

					response.sendRedirect("indax/userIndax.jsp");

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
