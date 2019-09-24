package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Page;
import com.entity.Task;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class Seek
 */
@WebServlet("/seek")
public class Seek extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Seek() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();

		// 获取内容
		String bill = request.getParameter("bill");
		if (bill != null && bill != "") {
			// 获取分页的页码
			String numpage = request.getParameter("pageNo");
			if (numpage == null) {
				numpage = "1";
			}
			// 转为整形
			int pageNo = Integer.parseInt(numpage);

			// 创建page对象
			Page p = new Page();
			PageHelper.startPage(pageNo, 5);
			// 搜索订单
			Task t = new Task();
			t.setMessage(bill);
			List<Task> li = s.seek(t);

			PageInfo<Task> pageInfo = new PageInfo<Task>(li);
			pageInfo.setList(li);
			// 查询的结果
			p.setData(pageInfo.getList());
			// 总记录数
			p.setRows(pageInfo.getTotal());
			// ajax查询
			p.setPageCount(pageInfo.getPages());

			// 回购输入值
			request.setAttribute("bill", bill);
			// 放入session(会话)
			request.setAttribute("seekli", li);
			// 让ajax不在运行
			request.setAttribute("seeki", 2);
			// page值
			request.setAttribute("page", p);
			// 重定向回去

			request.getRequestDispatcher("indax/userIndax.jsp").forward(request, response);

		} else {

			request.getRequestDispatcher("indax/userIndax.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
