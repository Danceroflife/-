package com.software.Servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.UserDao;
import com.software.model.User;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
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
				

					//2.创建数据库访问层对象
					UserDao userDao = new UserDao();
					//3.调用数据库访问层中的查询方法
					List<User> users =userDao.findAllUser(userId);
					//4.跳转到修改页面
					request.setAttribute("data", users);
					request.getRequestDispatcher("personcenter.jsp").forward(request, response);
			}
			
	}

}
