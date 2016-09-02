package xupt.se.util;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;
public class c3p0Util {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	public static java.sql.Connection getconnection() throws SQLException{
		return ds.getConnection();
		
	}

}
