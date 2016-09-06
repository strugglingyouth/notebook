package com.api.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;

import com.api.help.resultSetToJsonInfo;
import com.api.idao.DAOFactory;
import com.api.idao.iUserDAO;
import com.api.model.user;


public class UserSrv {
	private iUserDAO userDAO=DAOFactory.creatStudioDAO();
	
	public ResultSet add(user stu){
		
		return userDAO.insert(stu); 		
	}
public ResultSet find(String sql){
		
		return userDAO.Query(sql); 		
	}

	
	public int modify(user stu){
		return userDAO.update(stu); 		
	}
	
	
	
}
