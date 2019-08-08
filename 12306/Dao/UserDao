package com.software.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.User;
import com.software.util.DBHelp;

/**
 * 数据库访问层--实现用户操作
 * @author Administrator
 *
 */
public class UserDao {

	/**
	 * 作者：郑敏敏
	 *  实现用户添加操作
	 * @param user :添加的用户对象
	 * @return true:添加成功 false:添加失败
	 */
	public boolean addUser(User user) {
		boolean flag = false;
		String sql="insert into tbl_user(user_loginname,user_loginpwd,"
				+ "user_realname,user_cardnumber,"
				+ "user_telephone,user_gender,user_brithday,remark1) values " + 
				"('" + user.getUser_loginname() + 
				"','" + user.getUser_loginpwd() +
				"','" + user.getUser_realname() +
				"','" + user.getUser_cardnumber() +
				"','" + user.getUser_telephone() +
				"','" + user.getUser_gender() +
				"','" + user.getUser_birthday() + "','0')";
		
		int count =DBHelp.executeSql(sql);
		if (count >0) {
			flag =true;
		}
			
		return flag;
	}
	
	/**
	 * 作者：郑敏敏
	 * 修改用户个人信息
	 */
	public boolean updateUser(User user) {
		boolean flag = false;
		String sql="update tbl_user " + 
				"set  user_loginname='"+ user.getUser_loginname() +"'," +
				"user_realname='" + user.getUser_realname() +"'," + 
				"user_cardnumber='" + user.getUser_cardnumber() +"'," + 
				"user_telephone='"+user.getUser_telephone() + "'," + 
				"user_gender='" + user.getUser_gender() +"'," + 
				"user_brithday='"+user.getUser_birthday()+ "'" +
				"where user_id='"+ user.getUser_id()+ "'";
		
		int count =DBHelp.executeSql(sql);
		if (count >0) {
			flag =true;
		}
			
		return flag;
	}
	
	
	
	/**
	 * 作者：郑敏敏 李婷
	 * 按条件查询用户信息
	 * @param loginname
	 * @param realname
	 * @param cardno
	 * @return
	 */
	public  List<User> findAllUser(int id)  {
		List<User> useres = new ArrayList<User>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select user_id, user_loginname,user_realname,"
					+ "user_cardnumber,user_telephone,user_gender,"
					+ "user_brithday from tbl_user where user_id= "+ id;
		
			
			
			 
			rs =st.executeQuery(sql);
			User user =null;
			while(rs.next()) {
				//创建用户对象
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_loginname(rs.getString("user_loginname"));
				user.setUser_realname( rs.getString("user_realname"));
				user.setUser_cardnumber(rs.getString("user_cardnumber"));
				user.setUser_telephone(rs.getString("user_telephone"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_birthday(rs.getString("user_brithday"));
				useres.add(user);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return useres;
		
	}
	
	/**
	 * 作者：李婷
	 * 按用户id查看用户所有信息
	 * @return 
	 */
	public User findAllUserById(int userId)  {
		
		User user =new User();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = (Connection) DBHelp.getConnect();		
			st = (Statement) connection.createStatement();
			
			String sql = "select user_id, user_loginname,user_realname,user_cardnumber,"
					+ "user_telephone,user_gender,user_brithday from tbl_user "
					+ "where user_id=" +userId;
			 
			
			rs =(ResultSet) st.executeQuery(sql);
			
			
			while(rs.next()) {
				
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_loginname(rs.getString("user_loginname"));
				user.setUser_realname( rs.getString("user_realname"));
				user.setUser_cardnumber(rs.getString("user_cardnumber"));
				user.setUser_telephone(rs.getString("user_telephone"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_birthday(rs.getString("user_brithday"));
				
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return user;
	}


	
	/**
	 * 作者：郑敏敏
	 * 登录界面实现（查询）
	 */
	
	public User findUser(String loginname,String loginpwd)  {
	
        User user = null;
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select * from tbl_user where user_loginname = '"
					+ loginname +"'"+" and user_loginpwd = '"+ loginpwd +"' and remark1=0";
			 
			rs =(ResultSet) st.executeQuery(sql);
			
			if(rs.next()) {
				
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_loginname(rs.getString("user_loginname"));
				user.setUser_loginpwd(rs.getString("user_loginpwd"));
				user.setUser_realname( rs.getString("user_realname"));
				user.setUser_cardnumber(rs.getString("user_cardnumber"));
				user.setUser_telephone(rs.getString("user_telephone"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_birthday(rs.getString("user_brithday"));
			
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return user;
	}

}
