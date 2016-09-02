package xupt.se.ttms.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;

import com.api.service.resultSetToJsonInfo;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iUserDAO;
import xupt.se.ttms.model.user;

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
