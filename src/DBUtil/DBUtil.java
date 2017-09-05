package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/test1?useSSL=false";
	private static final String user = "root";
	private static final String password = "1234";
	private static final String Drivername = "com.mysql.jdbc.Driver";

	public static Connection getconn() {
		try {
			Class.forName(Drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 设置关闭方法。ResultSet和statement还有Connection都是需要关闭的，非常占用资源
	public static void closeing(ResultSet s, Statement s1, Connection c) {
		if (s != null) {
			try {
				s.close();
				s = null;
				// 赋值为空的原因是为了释放的准确性和资源能够得到及时的释放。
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if (s1 != null) {
			try {
				s1.close();
				s1 = null;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if (c != null) {
			try {
				c.close();
				c = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
