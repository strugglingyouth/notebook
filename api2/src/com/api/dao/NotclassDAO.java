package com.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.api.idao.INoteclassDAO;
import com.api.model.noteclass;
import com.api.model.user;
import com.api.util.DBUtil;
import com.api.util.DataSourceUtils;



public class NotclassDAO implements INoteclassDAO {
//	public int insert(noteclass stu){
//		
//		int count=2;
//		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		String sql = "insert into noteclass values(?,?,?,?,?)";
//		try {
//			if(
//			runner.update(sql, count,
//					stu.getClassname(), stu.getClassdesc(),stu.getArticlenum(),stu.getUserid())==1){
//			count++;
//			return 1;
//			
//			}
//				
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return -1;
//		
//			}
	public int insert(noteclass stu){
		try{
					String sql = "insert into noteclass(classname, classdesc, articlenum,userid )"
							+ " values('"
							+ stu.getClassname()
							+ "',' "
							+ stu.getClassdesc()
							+ "',' " + stu.getArticlenum()
							
							+ "', '" + stu.getUserid()
							+ "' )";
					DBUtil db = new DBUtil();
					db.openConnection();
					ResultSet rst = db.getInsertObjectIDs(sql);
					if (rst!=null && rst.first()) {
						stu.setId(rst.getInt(1));
					}
					
					return 1;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return 0;
			}



			
			public int update(noteclass stu) {
				int rtn=0;
				try { 
					String sql = "update noteclass set " + "classname ='"
							+ stu.getClassname()+ "', " + "  classdesc ='"
							+ stu.getClassdesc() + "', " + " articlenum ="
							+ stu.getArticlenum() + ", " + " userid = '"
									+ stu.getUserid() +"' ";

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
		


			//查找笔记结果
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
			public int delete(int ID) {
				int rtn=0;		
				try{
					String sql = "delete from  noteclass ";
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
				NotclassDAO no=new NotclassDAO();
				noteclass c=new noteclass();
				c.setId(2);
				c.setUserid(2);
				c.setClassname("huimn");
				c.setArticlenum(12);
				c.setClassdesc("dfg");
				no.insert(c);
				
				
			}


}
