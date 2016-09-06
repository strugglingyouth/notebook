package com.api.help;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;


import com.api.model.group;
import com.api.model.noteclass;
import com.api.service.GroupSrv;
import com.api.service.UserSrv;
import com.api.servlet.addNoteclassServlet;
import com.api.servlet.groupServlet;

public class groupservice {
	public String look() throws SQLException, JSONException {
		group us = new group();
		groupServlet r = new groupServlet();
		ResultSet rst = null;
		us = r.GetGroup();
		GroupSrv ser = new GroupSrv();
		// ser.add(us);
		System.out.println(us.getId());
		String sql = "select * from groups";
		rst = ser.find(sql);
		resultSetToJsonInfo n = new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);

	}

	public String lookallgroupnote() throws SQLException, JSONException {// 查找i群组对应的多个笔记
		group us = new group();
		groupServlet r = new groupServlet();
		ResultSet rst = null;
		us = r.GetGroup();
		GroupSrv ser = new GroupSrv();
		// ser.add(us);
		System.out.println(us.getId());
		String sql = "select * from notearticle where id in (select articleid from grouparticle where groupid= "
				+ us.getId() + ")";
		rst = ser.find(sql);
		resultSetToJsonInfo n = new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);

	}

	/*
	 * public String deleteallgroupnote() throws SQLException,
	 * JSONException{//从群组中删除笔记 <=>删除笔记与群租的链接的表中的群组所对应的笔记 group us=new group();
	 * groupServlet r=new groupServlet(); ResultSet rst=null; us=r.GetGroup();
	 * GroupSrv ser=new GroupSrv(); // ser.add(us);
	 * System.out.println(us.getId()); String sql=
	 * "select * from notearticle where id in (select articleid from grouparticle where groupid= "
	 * +us.getId()+")"; rst=ser.find(sql); resultSetToJsonInfo n=new
	 * resultSetToJsonInfo(); return n.resultSetToJson2(rst);
	 * 
	 * }
	 */
	public String add() throws SQLException, JSONException {
		group us = new group();
		groupServlet r = new groupServlet();
		ResultSet rst = null;
		us = r.GetGroup();
		GroupSrv ser = new GroupSrv();
		


	ser.add(us);
	System.out.println(us.getId());
	String sql = "select * from groups where id=" + us.getId();
	System.out.println(Integer.parseInt(us.getDate().substring(5,7)));
	  
		if((Integer.parseInt(us.getDate().substring(0,4))<=0 || Integer.parseInt(us.getDate().substring(0,4))>2016)||(Integer.parseInt(us.getDate().substring(5,7))<=0||Integer.parseInt(us.getDate().substring(5,7))>12)||(Integer.parseInt(us.getDate().substring(8,10))<=0||Integer.parseInt(us.getDate().substring(8,10))>31))
		{
		System.out.println(Integer.parseInt(us.getDate().substring(0,4)));
		rst = ser.find("select * from groups where id=0");
		
		}
		else{
		 rst = ser.find(sql);}
			resultSetToJsonInfo n = new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);
		}

	

	public String lookByUserId() throws SQLException, JSONException {
		group us = new group();
		groupServlet r = new groupServlet();
		ResultSet rst = null;
		us = r.GetGroup();
		GroupSrv ser = new GroupSrv();
		System.out.println(us.getId());
		String sql = "select * from groups where ownuserid="
				+ us.getOwnuserid();
		rst = ser.find(sql);
		resultSetToJsonInfo n = new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);

	}

	public String deleteGroup() throws SQLException, JSONException {
		group us = new group();
		groupServlet r = new groupServlet();
		ResultSet rst = null;
		us = r.GetGroup();
		GroupSrv ser = new GroupSrv();
		System.out.println(us.getId());
		String sql = "select * from groups where id= " + us.getId();

		ser.delete(us.getId());

		resultSetToJsonInfo n = new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);
	}

	public String modifyGroup() throws SQLException, JSONException {
		group us = new group();
		groupServlet r = new groupServlet();
		ResultSet rst = null;
		us = r.GetGroup();
		GroupSrv ser = new GroupSrv();
		System.out.println(us.getId());
		String sql = "select * from groups where id=" + us.getId();
		ser.update(us);
		rst = ser.find(sql);

		resultSetToJsonInfo n = new resultSetToJsonInfo();
		return n.resultSetToJson2(rst);
	}

	public static void main(String[] args) throws SQLException, JSONException {
		groupservice d = new groupservice();
		System.out.println(d.add());
	}
}
