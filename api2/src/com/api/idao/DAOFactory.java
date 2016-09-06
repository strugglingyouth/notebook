package com.api.idao;
import com.api.dao.*;

public class DAOFactory {
	public static iUserDAO creatStudioDAO(){
		return new UserDAO();
	}
	public static INoteclassDAO creatNoteclassDAO(){
		return new NotclassDAO();
	}
	public static IGroupDAO creatGroupDAO(){
		return new GroupDAO();
	}
	
	public static INotearticleDAO creatNotearticleDAO(){
		return new NotearticleDAO();
	}
	
}
