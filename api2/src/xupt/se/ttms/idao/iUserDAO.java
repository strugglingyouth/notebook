/**
 * 
 */
package xupt.se.ttms.idao;


import java.sql.ResultSet;
import java.util.List;

import xupt.se.ttms.model.user;

/**
 * @author Administrator
 *
 */
public interface iUserDAO {
	public ResultSet insert(user stu);
	public ResultSet Query(String sql);
	public int update(user stu);
	//public int delete(int ID);
	//public List<user> select(String condt); 
}
