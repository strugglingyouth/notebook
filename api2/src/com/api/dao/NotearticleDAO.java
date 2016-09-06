package com.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.api.idao.INotearticleDAO;
import com.api.idao.INoteclassDAO;
import com.api.model.notearticle;
import com.api.model.noteclass;
import com.api.util.DBUtil;
import com.api.util.DataSourceUtils;


public class NotearticleDAO implements INotearticleDAO  {

	public int insert(notearticle stu){//插入笔记
		ResultSet rst=null;
		try{
					String sql = "insert into notearticle(userid, classid, title,date,modified,descs,content )"
							+ " values('"
							+ stu.getUserid()
							+ "',' "
							+ stu.getClassid()
							+ "',' " + stu.getTitle()
							+ "',' " + stu.getDate()
							+ "',' " + stu.getModified()
							+ "',' " + stu.getDescs()
							
							+ "', '" + stu.getContent()
							+ "' )";
					DBUtil db = new DBUtil();
					db.openConnection();
					rst = db.getInsertObjectIDs(sql);
					if (rst!=null && rst.first()) {
						stu.setId(rst.getInt(1));
					}
					
					return 1;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return 0;
			}



	
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

	public int update(notearticle stu) {
		int rtn=0;
		try {
			String sql = "update notearticle set " + " userid= "
					+ stu.getUserid()+ ", " + " classid = "
					+ stu.getClassid() + ", " + " title ='"
					+ stu.getTitle() + "', " + " date = '"
					+ stu.getDate() + "', " + " modified = '"
					+ stu.getModified() + "', " + " descs = '"
					+ stu.getDescs() + "', " + " content = '"
							+ stu.getContent()+"' ";

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


	public int delete(int ID) {//删除笔记
		int rtn=0;		
		try{
			String sql = "delete from  notearticle ";
			sql += " where id = " + ID;
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn=db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;		
	}

	public static void main(String[] args) {
		NotearticleDAO no=new NotearticleDAO();
		notearticle stu=new notearticle();
		stu.setId(195);
		stu.setClassid(1);
		stu.setUserid(1);
		stu.setTitle("计算机组成原理");
		stu.setDate("2012-09-08 12:12:12");
		stu.setModified("2012-09-08 12:12:12");
		stu.setDescs("计算机类书籍");
		stu.setContent("计算：    ");
		System.out.println(stu.getUserid());
		no.delete(195);
	}
	

}
