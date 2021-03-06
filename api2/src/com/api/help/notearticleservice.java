package com.api.help;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;


import com.api.model.notearticle;
import com.api.model.noteclass;
import com.api.service.NotearticleSrv;
import com.api.service.NoteclassSrv;
import com.api.service.UserSrv;
import com.api.servlet.addNoteclassServlet;
import com.api.servlet.notearticleServlet;

public class notearticleservice {
public  notearticleservice(){
		
	}
public String  add() throws SQLException, JSONException{//添加
		
		notearticle us=new notearticle();
		notearticleServlet r=new notearticleServlet();
		ResultSet rst=null;
		us=r.GetNotearticle();
		NotearticleSrv ser=new NotearticleSrv ();
		ser.add(us);
		System.out.println(us.getId());
		String sql="select * from notearticle where id="+us.getId();
		
		rst=ser.find(sql);
		
		resultSetToJsonInfo n=new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);	
}

	public String  look() throws SQLException, JSONException{//查找
		
		notearticle us=new notearticle();
		notearticleServlet r=new notearticleServlet();
		ResultSet rst=null;
		us=r.GetNotearticle();
		UserSrv ser=new UserSrv();
	//	ser.add(us);
		System.out.println(us.getId());
		String sql="select * from notearticle where id="+us.getId();
		rst=ser.find(sql);
		resultSetToJsonInfo n=new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);	
}
//public String  lookall() throws SQLException, JSONException{//查找
//		
//		noteclass us=new noteclass();
//		addNoteclassServlet r=new addNoteclassServlet();
//		ResultSet rst=null;
//		us=r.GetNoteclass();
//		UserSrv ser=new UserSrv();
//	//	ser.add(us);
//		System.out.println(us.getId());
//		String sql="select * from noteclass";
//		rst=ser.find(sql);
//		resultSetToJsonInfo n=new resultSetToJsonInfo();
//		return n.resultSetToJson2(rst);	
//}
public String  modify() throws SQLException, JSONException{//修改
		
		notearticle us=new notearticle();
		notearticleServlet r=new notearticleServlet();
		ResultSet rst=null;
		us=r.GetNotearticle();
		NotearticleSrv ser=new NotearticleSrv();
	//	ser.add(us);
		System.out.println(us.getId());
		String sql="select * from notearticle where id="+us.getId();
		ser.modify(us);
		
		rst=ser.find(sql);
		
		resultSetToJsonInfo n=new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);	
}
public String  delete() throws SQLException, JSONException{//修改
	
	notearticle us=new notearticle();
	notearticleServlet r=new notearticleServlet();
	ResultSet rst=null;
	us=r.GetNotearticle();
	NotearticleSrv ser=new NotearticleSrv();
//	ser.add(us);
	System.out.println(us.getId());
	String sql="select * from notearticle where id="+us.getId();
	rst=ser.find(sql);
	ser.delete(us.getId());
	resultSetToJsonInfo n=new resultSetToJsonInfo();
	return n.resultSetToJson2(rst);	
}
public static void main(String[] args) throws SQLException, JSONException {
	System.out.println(new notearticleservice().look());
}
}
