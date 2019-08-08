package com.software.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.UserDao;
import com.software.model.User;

/**
 * Servlet implementation class SelectEnter
 */
@WebServlet("/SelectEnter")
public class SelectEnter extends HttpServlet {
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
		 
		String loginname = request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		
		//2.调用数据库访问层中的查询用户信息的方法
		UserDao userDao = new UserDao();
		User user =userDao.findUser(loginname, loginpwd);
		
		if(user!=null) {
			//4.用户登录成功后将用户信息存储在Session对象中
			HttpSession session =request.getSession();
			session.setAttribute("userobj", user);
			//5.跳转到前端首页界面
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		    else {
			//6.重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/enter.jsp");
		}
	}


}
