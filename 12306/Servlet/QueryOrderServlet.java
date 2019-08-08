package com.software.Servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.OrderDao;
import com.software.dao.TrainDao;
import com.software.model.Train;
import com.software.model.User;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
	    Object obj = session.getAttribute("userobj");
	    if(obj == null) {
	    	//用户没有登录
			response.sendRedirect(request.getContextPath() + "/enter.jsp");
		}else {
			
				User user = (User)obj;
				int userId =user.getUser_id();
				//1.调用数据库访问层中的查询订单信息的方法
				OrderDao orderDao = new OrderDao();
				List<List> orders =  orderDao.findAllOrder(userId);
				//2.将查询到的订单信息显示到订单信息显示页面
				//  2.1 数据的封装
				request.setAttribute("data", orders);
				//  2.2 页面的跳转
				request.getRequestDispatcher("selectOrder.jsp").forward(request, response);
		}
			
	}

}
