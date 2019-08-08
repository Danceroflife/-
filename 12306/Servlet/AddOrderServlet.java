package com.software.Servlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.OrderDao;
import com.software.dao.TrainDao;
import com.software.model.Order;
import com.software.model.User;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
					

					String gender = request.getParameter("gender");
					String pay = request.getParameter("pay");
					int trainid = Integer.parseInt(request.getParameter("trainid"));
					String type = null;
					if(gender.equals("soft_berth")) {
						type = "软卧";
					} else if(gender.equals("hard_berth")){
						type = "硬卧";
					} else if(gender.equals("hard_seat")) {
						type = "硬座";
					} else {
						type = "无票";
					}
					
					
					TrainDao td = new TrainDao();
					double price = td.findPrice(trainid, gender);
					
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					//System.out.println("当前时间：" + sdf.format(d));
					
					//生成订单编号
					 String OrderNumber = OrderDao.getRandomOrderNumber();
					  // System.out.println(fileName);
					 
					//创建用户对象
					Order order = new Order();
					
					order.setOrder_number(OrderNumber);
					order.setOrder_creation_time(sdf.format(d));
					order.setUser_id(userId);
					order.setTrain_id(trainid);
					order.setOrder_tiket_price((float)price);
					order.setOrder_pay_type(pay);
					order.setOrder_seat_type(type);
					//2.创建数据库访问层对象
					OrderDao orderDao = new OrderDao();
					//3.调用数据库访问层中的添加方法
					orderDao.addOrder(order);
						
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	       }
}
