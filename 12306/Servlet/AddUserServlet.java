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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		//1.获取客户端提交的用户注册信息
		String loginname =request.getParameter("loginname");
		String loginpwd =request.getParameter("loginpwd");
		String realname =request.getParameter("realname");
		String cardNumber =request.getParameter("cardnumber");
		String telephone =request.getParameter("telephone");
		String gender =request.getParameter("gender");
		String birthday = request.getParameter("year")+"-"+
		                  request.getParameter("month");
		
		//创建用户对象
		User user = new User();
		user.setUser_loginname(loginname);
		user.setUser_loginpwd(loginpwd);
		user.setUser_realname(realname);
		user.setUser_cardnumber(cardNumber);
		user.setUser_telephone(telephone);
		user.setUser_gender(gender);
		user.setUser_birthday(birthday);
		
		
		//2.创建数据库访问层对象
		UserDao userDao = new UserDao();
		//3.调用数据库访问层中的添加方法
	   userDao.addUser(user);
	   request.getRequestDispatcher("enter.jsp").forward(request, response);
//	   PrintWriter out =response.getWriter();
//	   out.print("注册成功");
//	   out.flush();
//	   out.close();
		
	}
}
