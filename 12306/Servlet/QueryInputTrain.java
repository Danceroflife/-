package com.software.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.TrainDao;
import com.software.dao.UserDao;
import com.software.model.Train;
import com.software.model.User;

/**
 * Servlet implementation class QueryInputTrain
 */
@WebServlet("/QueryInputTrain")
public class QueryInputTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryInputTrain() {
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
   		
   		int trainId =Integer.parseInt(request.getParameter("trainid"));
		
		
		//1.调用数据库访问层中的查询用户信息的方法
		TrainDao trainDao = new TrainDao();
		Train train = trainDao.findAllTrainById(trainId);
   		
   		
   		//4.跳转到修改页面
   		request.setAttribute("obj", train);
   		request.getRequestDispatcher("order.jsp").forward(request, response);
   	}

}
