package com.api.service;

import java.sql.ResultSet;

import com.api.dao.NotclassDAO;
import com.api.idao.DAOFactory;
import com.api.idao.INoteclassDAO;
import com.api.idao.iUserDAO;
import com.api.model.noteclass;
import com.api.model.user;


public class NoteclassSrv {
private INoteclassDAO noteclassDAO=DAOFactory.creatNoteclassDAO();
	
public int add(noteclass stu){
		
		return noteclassDAO.insert(stu); 		
	}
public ResultSet find(String sql){
		
		return noteclassDAO.Query(sql); 		
	}

	
public int modify(noteclass stu){
		return noteclassDAO.update(stu); 		
	}
public int delete(int id){
	return noteclassDAO.delete(id); 		
}
	
	
}
