package com.software.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.UserDao;
import com.software.model.User;

/**
 * Servlet implementation class QueryInputUser
 */
@WebServlet("/QueryInputUser")
public class QueryInputUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryInputUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取修改的用户编号
		int userId =Integer.parseInt(request.getParameter("userid"));
		//2.创建数据库访问层对象
		UserDao userDao = new UserDao();
		//3.调用数据库访问层中的查询方法
		User user =userDao.findAllUserById(userId);
		
		//4.跳转到修改页面
		request.setAttribute("obj", user);
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
	}


}
