package com.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.api.idao.IGroupDAO;
import com.api.model.group;
import com.api.model.noteclass;
import com.api.util.DBUtil;
import com.api.util.DataSourceUtils;


//群组信息表
public class GroupDAO implements IGroupDAO {
	public ResultSet Query(String sql) {//群组信息搜索
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
public int insert(group stu){//创建群组
	
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into groups values(?,?,?,?,?)";
		try {
			if(
			runner.update(sql,stu.getId(),stu.getOwnuserid(),stu.getTitle(),stu.getDate(),stu.getDesc())==1){
			return 1;
			
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
			}
public int update(group stu) {//根据修改群组信息
	int rtn=0;
	try { 
		String sql = "update groups set " + "ownuserid ="
				+ stu.getOwnuserid()+ ", " + "  title ='"
				+ stu.getTitle() + "', " + " date ='"
				+ stu.getDate() + "', " + " descs = '"
						+ stu.getDesc() +"' ";

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
public int delete(int ID) {//删除群组信息
	int rtn=0;		
	try{
		String sql = "delete from  groups ";
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
	GroupDAO d=new GroupDAO();
	group stu=new group();
	stu.setId(2);
	stu.setDesc("数据");
	stu.setOwnuserid(2);
	stu.setTitle("数据库");
	stu.setDate("1992-8-9 9:23:01");
	// DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// u.setRegTime(df.format(rs.getTimestamp("regTime")));
	d.insert(stu);
}

}
