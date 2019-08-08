package com.software.dao;

import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.software.model.Order;
import com.software.model.Train;
import com.software.model.User;
import com.software.util.DBHelp;

public class OrderDao {
	
	/**   
	  * * 作者:李婷,刘金
	  * * 生成随机订单编号：当前年月日+六位随机数   *  
	  *  * @return  订单编号    */  
		public static String getRandomOrderNumber() {
	    SimpleDateFormat simpleDateFormat;
	    simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    String str = simpleDateFormat.format(date);
	    Random random = new Random();
	    int rannum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;// 获取5位随机数
	    return  str+rannum ;// 当前时间 
	  }
	
	/**
   * 作者:李婷
	 * 增加订单
	 */
	public boolean addOrder(Order order) {
		boolean flag = false;
		String sql="insert into tbl_order(order_number, order_creation_time,user_id,train_id,"
				+ "order_tiket_price,order_pay_type,order_seat_type) values " + 
				"('" + order.getOrder_number() + 
				"','" + order.getOrder_creation_time() +
				"','" + order.getUser_id() +
				"','" + order.getTrain_id() +
				"','" + order.getOrder_tiket_price() +
				"','" + order.getOrder_pay_type() +
				"','" + order.getOrder_seat_type() + "')";
		
		int count =DBHelp.executeSql(sql);
		if (count >0) {
			flag =true;
		}
			
		return flag;
	}
	
	/**
	 *
	 * 作者： 郑敏敏
	 * @param   按用户id多表之间联合查询 
	 * @return  查询到的订单
	 */

	public List<List> findAllOrder(int id){
		
		List<List> buffer = new ArrayList<List>();
		
		//连接数据库实现查询操作
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connection = (Connection) DBHelp.getConnect();
			st = (Statement) connection.createStatement();
			String sql = "select user_loginname,train_start,train_end,order_number,order_creation_time,order_tiket_price,order_pay_type,order_seat_type from tbl_order o,tbl_user u,tbl_train t  " + 
					"where o.user_id = u.user_id and o.train_id = t.train_id and u.user_id = " + id ;
			
			rs = (ResultSet) st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				data = new ArrayList();				
				data.add(rs.getString("user_loginname"));
				data.add(rs.getString("order_number"));
				data.add(rs.getString("order_creation_time"));
				data.add(rs.getString("train_start"));
				data.add(rs.getString("train_end"));
				data.add(rs.getString("order_tiket_price"));
				data.add(rs.getString("order_pay_type"));
				data.add(rs.getString("order_seat_type"));
				buffer.add(data);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		
		return buffer;
	}
		
		
}
