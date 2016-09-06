package com.api.help;




import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;

import com.api.model.user;
import com.api.service.UserSrv;
import com.api.servlet.RegisterServlet;




public class zhixing {
	public zhixing(){
		
	}
	 
	public String  register() throws SQLException, JSONException{
		
		user us=new user();
		RegisterServlet r=new RegisterServlet();
		ResultSet rst=null;
		us=r.GetUser();
		UserSrv ser=new UserSrv();
		ser.add(us);
		System.out.println(us.getId());
		String sql="select * from user where id="+us.getId();
		
		rst=ser.find(sql);
		
		resultSetToJsonInfo n=new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);	
}
//	public String  loginin() throws SQLException, JSONException{
//		
//		user us=new user();
//		RegisterServlet r=new RegisterServlet();
//		ResultSet rst=null;
//		us=r.GetUser();
//		UserSrv ser=new UserSrv();
//	//	ser.add(us);
//		System.out.println(us.getId());
//		String sql="select * from user where id="+us.getId();
//		
//		rst=ser.find(sql);
//		
//		resultSetToJsonInfo n=new resultSetToJsonInfo();
//		return n.resultSetToJson2(rst);	
//}
public String  loginin() throws SQLException, JSONException{//根据用户名，密码登录
		
		user us=new user();
		RegisterServlet r=new RegisterServlet();
		ResultSet rst=null;
		us=r.GetUser();
		UserSrv ser=new UserSrv();
	//	ser.add(us);
		System.out.println(us.getId());
		String sql="select * from user where  user="+"'"+us.getUser()+"'"+" and "+"passwd="+us.getPassswd().toString();
		System.out.println(sql);
		rst=ser.find(sql);
		
		resultSetToJsonInfo n=new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);	
}
public String  modify() throws SQLException, JSONException{
		
		user us=new user();
		RegisterServlet r=new RegisterServlet();
		ResultSet rst=null;
		us=r.GetUser();
		UserSrv ser=new UserSrv();
	//	ser.add(us);
		System.out.println(us.getId());
		String sql="select * from user where id="+us.getId();
		
		ser.modify(us);
		rst=ser.find(sql);
		
		resultSetToJsonInfo n=new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);	
}
	
	public static void main(String[] args) throws SQLException, JSONException {
		System.out.println(new zhixing().loginin());	
	}
	
}


