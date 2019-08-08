package com.software.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.TrainDao;
import com.software.model.Train;

/**
 * Servlet implementation class QueryTrainServlet
 */
@WebServlet("/QueryTrainServlet")
public class QueryTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//每页显示的记录总数
	private static final int PAGEROWS = 4;

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
		
		TrainDao trainDao = new TrainDao();
		String train_start = request.getParameter("train_start");
		String train_end = request.getParameter("train_end");
		
		int rows =trainDao.getCountTrains(train_start, train_end);
		int totalPages = rows / PAGEROWS;
		if(rows % PAGEROWS !=0) {
			totalPages ++;
		}
		//2.获取当前页
		int currentpage= 1; //默认值
		
		String getCurrentPage=request.getParameter("setcurrentpage");
		if(getCurrentPage!=null && getCurrentPage.trim().length()>0) {
			currentpage = Integer.parseInt(getCurrentPage);
		}
		//1.调用数据库访问层中的查询用户信息的方法
		List<Train> orders =  trainDao.findAll(train_start, train_end, currentpage, PAGEROWS);
		
		//2.将查询到的用户信息显示到用户信息显示页面
		//  2.1 数据的封装
		request.setAttribute("data", orders);
		request.setAttribute("totalpage", totalPages);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("train_start", train_start);
		request.setAttribute("train_end", train_end);
		//  2.2 页面的跳转
		request.getRequestDispatcher("selectTiket.jsp").forward(request, response);
	}

}
