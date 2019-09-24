package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.entity.Task;
import com.serviceImpl.ServiceImplements;
import com.serviceInte.ServiceInterface;

/**
 * Servlet implementation class LookMyOrder
 */
@WebServlet("/lookmyorder")
public class LookMyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookMyOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceInterface s = new ServiceImplements();
		
		
		// 获取写

				PrintWriter pw = response.getWriter();
				// 获取ajax内容
				String id = request.getParameter("amendorderid");
				// 转形
				int i = Integer.parseInt(id);
				

				Task t = new Task();
				t.setId(i);
				//ajax查找我的订单并填充
				t = s.lookmyorder(t);
				// 创建JSON工具对象
				JSONObject json = new JSONObject();
				// 放入json
				json.put("lookmyorder", t);
				// 写出去
				pw.write(json.toJSONString());
				// 刷新
				pw.flush();
				// 关闭
				pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
