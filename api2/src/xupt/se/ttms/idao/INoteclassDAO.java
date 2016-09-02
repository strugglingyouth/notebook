package xupt.se.ttms.idao;

import java.sql.ResultSet;

import xupt.se.ttms.model.noteclass;
import xupt.se.ttms.model.user;
public interface INoteclassDAO {

		public int insert(noteclass stu);
		public ResultSet Query(String sql);
		public int update(noteclass stu);
		public int delete(int ID);
		//public List<user> select(String condt); 
	}


