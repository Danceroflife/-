package com.software.Servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.UserDao;
import com.software.model.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		exectue(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		exectue(request, response);
	}
	
	private void exectue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取客户端提交的用户修改信息
		int id = Integer.parseInt(request.getParameter("userid"));
		String loginname =request.getParameter("loginname");
		String realname =request.getParameter("realname");
		String cardNumber =request.getParameter("cardnumber");
		String telephone =request.getParameter("telephone");
		String gender =request.getParameter("gender");
		String birthday = request.getParameter("year")+"-"+
		                  request.getParameter("month");
		
		//创建用户对象
		User user = new User();
		user.setUser_id(id);
		user.setUser_loginname(loginname);
		user.setUser_realname(realname);
		user.setUser_cardnumber(cardNumber);
		user.setUser_telephone(telephone);
		user.setUser_gender(gender);
		user.setUser_birthday(birthday);
		
		
		//2.创建数据库访问层对象
		UserDao userDao = new UserDao();
		//3.调用数据库访问层中的添加方法
	   userDao.updateUser(user);
	   response.sendRedirect(request.getContextPath() + "/QueryUserServlet");
	}

}
