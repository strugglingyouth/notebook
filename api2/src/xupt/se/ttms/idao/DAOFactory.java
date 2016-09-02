package xupt.se.ttms.idao;
import xupt.se.ttms.dao.*;

public class DAOFactory {
	public static iUserDAO creatStudioDAO(){
		return new UserDAO();
	}
	public static INoteclassDAO creatNoteclassDAO(){
		return new NotclassDAO();
	}
	
}
