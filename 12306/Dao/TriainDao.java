package com.software.dao;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.software.model.Train;
import com.software.model.User;
//import com.software.model.User;
import com.software.util.DBHelp;


	/**
	 * 作者:李婷
	 *分页查询 车票的所有信息
	 * @param ticket
	 * @return 对象
	 */
public class TrainDao{
	
	   /**
	    * 作者：郑敏敏
	    * 按条件查询所有车票信息
	    * @param train_start
	    * @param train_end
	    * @return
	    */
	   public  List<Train> findAllTrain(String train_start,String train_end)  {
	    List<Train> trains = new ArrayList<Train>();
	    
	    Connection connection = null;
	    Statement st = null;
	    ResultSet rs = null;
	    try {
	     connection = (Connection) DBHelp.getConnect();  
	     st = (Statement) connection.createStatement();
	     
	     String sql = "select train_id,train_number,train_start,train_end,train_start_time,train_end_time,train_runtime," + 
	       "soft_berth_number,hard_berth_number,hard_seat_number,stand_number," + 
	       "soft_berth_price,hard_berth_price,hard_seat_price,stand_price,admin_id " + 
	       "from tbl_train where 1=1";
	     if(train_start !=null && train_start.trim().length()>0) {
	      sql = sql + " and  train_start like '" + train_start +"'";
	     }
	     if(train_end !=null && train_end.trim().length()>0) {
	      sql = sql + " and train_end like '"+ train_end +"'";
	     }
	   
	      
	     rs =(ResultSet) st.executeQuery(sql);
	     Train train =null;
	     while(rs.next()) {
	      //创建用户对象
	      train = new Train();
	      train.setTrain_id(rs.getInt("train_id"));    
	      train.setTrain_number(rs.getString("train_number"));
	      train.setTrain_start(rs.getString("train_start"));
	      train.setTrain_end(rs.getString("train_end"));
	      train.setTrain_start_time(rs.getString("train_start_time"));
	      train.setTrain_end_time(rs.getString("train_end_time"));
	      train.setTrain_runtime(rs.getString("train_runtime"));
	      train.setSoft_berth_number(rs.getInt("soft_berth_number"));
	      train.setHard_berth_number( rs.getInt("hard_berth_number"));
	      train.setHard_seat_number( rs.getInt("hard_seat_number"));
	      train.setStand_number( rs.getInt("stand_number"));
	      train.setSoft_berth_price( rs.getDouble("soft_berth_price"));
	      train.setSoft_berth_price( rs.getDouble("soft_berth_price"));
	      train.setHard_berth_price( rs.getDouble("hard_berth_price"));
	      train.setHard_seat_price( rs.getDouble("hard_seat_price"));
	      train.setStand_price( rs.getDouble("stand_price"));
	      train.setAdmin_id( rs.getInt("admin_id"));
	      trains.add(train);
	     }
	     // 5.关闭数据库连接对象
	    } catch (Exception e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    } finally {
	     DBHelp.closeAll(rs, st, connection);
	    }
	    
	    return trains;
	    
	   }
	
	public List<Train> findAll(String train_start,String train_end,int currentPage,int pageSize)  {
		List<Train> train = new ArrayList<Train>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = (Connection) DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select train_id,train_number,train_start,train_end,train_start_time,train_end_time,train_runtime,"
					+ "soft_berth_number,hard_berth_number,hard_seat_number,stand_number,soft_berth_price,hard_berth_price,"
					+"hard_seat_price,stand_price,admin_id from tbl_train where 1=1 ";
			if(train_start !=null && train_start.trim().length()>0) {
				sql = sql + " and  train_start like '%" + train_start +"%'";
			}
			if(train_end !=null && train_end.trim().length()>0) {
				sql = sql + " and train_end like '%"+train_end +"%'";
			}
			
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			Train train1 = null;
			while(rs.next()) {
				//创建用户对象
				train1 = new Train();
				train1.setTrain_id(rs.getInt("train_id"));				
				train1.setTrain_number(rs.getString("train_number"));
				train1.setTrain_start(rs.getString("train_start"));
				train1.setTrain_end(rs.getString("train_end"));
				train1.setTrain_start_time(rs.getString("train_start_time"));
				train1.setTrain_end_time(rs.getString("train_end_time"));
				train1.setTrain_runtime(rs.getString("train_runtime"));
				train1.setSoft_berth_number(rs.getInt("soft_berth_number"));
				train1.setHard_berth_number( rs.getInt("hard_berth_number"));
				train1.setHard_seat_number( rs.getInt("hard_seat_number"));
				train1.setStand_number( rs.getInt("stand_number"));
				train1.setSoft_berth_price( rs.getInt("soft_berth_price"));
				train1.setHard_berth_number( rs.getInt("hard_berth_number"));
				train1.setHard_berth_price( rs.getInt("hard_berth_price"));
				train1.setHard_seat_price( rs.getInt("hard_seat_price"));
				train1.setStand_price( rs.getInt("stand_price"));
				train1.setAdmin_id( rs.getInt("admin_id"));
				train.add(train1);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return train;
	}
	
	
	
		/**
			 * 韩冬
			 * 确定车次，找到座位价格
			 */
			public double findPrice(int trainid, String seattype) {
				double price = 0.0;

				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					connection = (Connection) DBHelp.getConnect();
					st = connection.createStatement();
					seattype = seattype + "_price";
					String sql ="select "+seattype+" from tbl_train where train_id = '"+trainid+"'";
					
					rs =st.executeQuery(sql);
					if(rs.next()) {
						price = Double.parseDouble(rs.getString(1));
						//创建用户对象
						
					}
					// 5.关闭数据库连接对象
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DBHelp.closeAll(rs, st, connection);
				}
				
				return price;
			}

	/**
	 * 作者：郑敏敏
	 * 按用户id查看车次所有信息
	 * @return 
	 */
	public Train findAllTrainById(int trainId)  {
		
		Train train1 = new Train();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = (Connection) DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select train_id,train_number,train_start,train_end,train_start_time,train_end_time,train_runtime,"
					+ "soft_berth_number,hard_berth_number,hard_seat_number,stand_number,soft_berth_price,hard_berth_price,"
					+"hard_seat_price,stand_price,admin_id from tbl_train where train_id="+ trainId;
			rs =st.executeQuery(sql);
			
			while(rs.next()) {
				//创建用户对象
				train1 = new Train();
				train1.setTrain_id(rs.getInt("train_id"));				
				train1.setTrain_number(rs.getString("train_number"));
				train1.setTrain_start(rs.getString("train_start"));
				train1.setTrain_end(rs.getString("train_end"));
				train1.setTrain_start_time(rs.getString("train_start_time"));
				train1.setTrain_end_time(rs.getString("train_end_time"));
				train1.setTrain_runtime(rs.getString("train_runtime"));
				train1.setSoft_berth_number(rs.getInt("soft_berth_number"));
				train1.setHard_berth_number( rs.getInt("hard_berth_number"));
				train1.setHard_seat_number( rs.getInt("hard_seat_number"));
				train1.setStand_number( rs.getInt("stand_number"));
				train1.setSoft_berth_price( rs.getInt("soft_berth_price"));
				train1.setHard_berth_number( rs.getInt("hard_berth_number"));
				train1.setHard_berth_price( rs.getInt("hard_berth_price"));
				train1.setHard_seat_price( rs.getInt("hard_seat_price"));
				train1.setStand_price( rs.getInt("stand_price"));
				train1.setAdmin_id( rs.getInt("admin_id"));
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return train1;
	}


	/** 
	 * 作者：郑敏敏
	 * 2019.7.10
	 * 按条件获取表的行数
	 * @return
	 */
	public  int getCountTrains(String train_start,String train_end)  {
		int count = 0;	
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = (Connection) DBHelp.getConnect();		
			st = connection.createStatement();
			 String sql = "select count(*) from tbl_train where 1=1 ";
			 if(train_start !=null && train_start.trim().length()>0) {
			      sql = sql + " and  train_start like '" + train_start +"'";
			     }
			     if(train_end !=null && train_end.trim().length()>0) {
			      sql = sql + " and train_end like '"+ train_end +"'";
			     }
			rs =st.executeQuery(sql);			
			if(rs.next()) {			
				count = rs.getInt(1);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return count;
		
	}
}
