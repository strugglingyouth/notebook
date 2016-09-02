package xupt.se.ttms.service;

import java.sql.ResultSet;

import xupt.se.ttms.dao.NotclassDAO;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.INoteclassDAO;
import xupt.se.ttms.idao.iUserDAO;
import xupt.se.ttms.model.noteclass;
import xupt.se.ttms.model.user;

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
