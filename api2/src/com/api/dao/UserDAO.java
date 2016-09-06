package com.api.dao;

import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.api.idao.iUserDAO;
import com.api.model.user;
import com.api.util.DBUtil;













public class UserDAO implements iUserDAO {
	
	
	
	public ResultSet insert(user stu){
try{
			String sql = "insert into user(user, passwd, tel, email,userimg )"
					+ " values('"
					+ stu.getUser()
					+ "', "
					+ stu.getPassswd()
					+ ", " + stu.getTel() 
					+ ", " + stu.getEmail() 
					+ ", '" + stu.getUserimg()
					+ "' )";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				stu.setId(rst.getInt(1));
			}
			
			return rst;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public int update(user stu) {
		int rtn=0;
		try {
			String sql = "update user set " + " user ='"
					+ stu.getUser() + "', " + " passwd ='"
					+ stu.getPassswd() + "', " + " tel ='"
					+ stu.getTel() + "', " + " email = '"
					+ stu.getEmail() + "', " + " userimg = '"
							+ stu.getUserimg() +"' ";

			sql += " where id = " + stu.getId();
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn =db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}

	
	
	
/*	public List<Studio> select(String condt) {
		List<Studio> stuList=null;
		stuList=new LinkedList<Studio>();
		try {
			String sql = "select studio_id, studio_name, studio_row_count, studio_col_count, studio_introduction from studio ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null) {
				while(rst.next()){
					user stu=new user();
					stu.setId(rst.getInt("id"));
					stu.setName(rst.getString("studio_name"));
					stu.setRowCount(rst.getInt("studio_row_count"));
					stu.setColCount(rst.getInt("studio_col_count"));
					stu.setIntroduction(rst.getString("studio_introduction"));
					stuList.add(stu);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return stuList;
	}
*/
	public ResultSet Query(String sql) {
		ResultSet rstSet = null;
		DBUtil db = new DBUtil();
		try {
			db.openConnection();
			rstSet=db.execQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rstSet;
	}

	public static void main(String[] args) throws SQLException {
		user us = new user();
		us.setId(15);
		us.setEmail("123");
		us.setPassswd("123");
		us.setTel("123");
		us.setUser("ser");
		us.setUserimg("fg");
		int s=(new UserDAO()).update(us);
		System.out.println(s);
		
		
	}
	
}
