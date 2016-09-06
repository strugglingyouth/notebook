package com.api.service;

import java.sql.ResultSet;

import com.api.dao.NotearticleDAO;
import com.api.idao.DAOFactory;
import com.api.idao.INotearticleDAO;
import com.api.idao.INoteclassDAO;
import com.api.model.notearticle;
import com.api.model.noteclass;


public class NotearticleSrv {
	private INotearticleDAO notearticleDAO=DAOFactory.creatNotearticleDAO();
	
	public int add(notearticle stu){
			
			return notearticleDAO.insert(stu); 		
		}
	public ResultSet find(String sql){
			
			return notearticleDAO.Query(sql); 		
		}

		
	public int modify(notearticle stu){
			return notearticleDAO.update(stu); 		
		}
	public int delete(int id){
		return notearticleDAO.delete(id); 		
	}
		
}
