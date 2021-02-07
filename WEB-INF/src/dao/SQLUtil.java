
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class SQLUtil {

	public static String driver;
	public static String url;
	public static String uName;
	public static String uPasswd;
	public static Connection mariadb;

	static {
		driver = "org.mariadb.jdbc.Driver";
		url = "jdbc:mariadb://localhost:3306/travel?characterEncoding=utf-8";
		uName = "root";
		uPasswd = "root";
		mariadb = null;
	}

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		mariadb = DriverManager.getConnection(url, uName, uPasswd);
		return mariadb;
	}
	
	public static void closeAll(Connection conn, Statement st, ResultSet rs) throws Exception {
		if(rs != null){
			rs.close();
		}
		if(st != null){
			st.close();
		}
		if(conn != null){
			conn.close();
		}
	}
	
	public static void closeAll(Connection conn, PreparedStatement ps) throws Exception {
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
	}

}