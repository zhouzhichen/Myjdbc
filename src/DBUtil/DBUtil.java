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

	// ���ùرշ�����ResultSet��statement����Connection������Ҫ�رյģ��ǳ�ռ����Դ
	public static void closeing(ResultSet s, Statement s1, Connection c) {
		if (s != null) {
			try {
				s.close();
				s = null;
				// ��ֵΪ�յ�ԭ����Ϊ���ͷŵ�׼ȷ�Ժ���Դ�ܹ��õ���ʱ���ͷš�
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
