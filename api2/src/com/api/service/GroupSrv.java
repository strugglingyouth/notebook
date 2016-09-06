package com.api.service;

import java.sql.ResultSet;

import com.api.dao.GroupDAO;
import com.api.idao.DAOFactory;
import com.api.idao.IGroupDAO;
import com.api.idao.iUserDAO;
import com.api.model.group;


public class GroupSrv {
public ResultSet find(String sql){
	IGroupDAO groupDAO=DAOFactory.creatGroupDAO();
	
		return groupDAO.Query(sql); 		
	}
public int add(group stu){
	IGroupDAO groupDAO=DAOFactory.creatGroupDAO();
	
		return groupDAO.insert(stu); 		
	}
public int update(group stu){
	IGroupDAO groupDAO=DAOFactory.creatGroupDAO();
	
		return groupDAO.update(stu); 		
	}
public int delete(int id){
	IGroupDAO groupDAO=DAOFactory.creatGroupDAO();
	
		return groupDAO.delete(id); 		
	}
}
