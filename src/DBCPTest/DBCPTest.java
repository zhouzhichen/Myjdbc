package DBCPTest;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPTest {
	private String URL = "jdbc:mysql://localhost:3306/test1?useSSL=false";
	private String USER = "root";
	private String PASSWORD = "1234";
	private String classDriver = "com.mysql.jdbc.Driver";

	public void Test1() {
		// ����jdbc���ӳض���
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
		ds.setDriverClassName(classDriver);
		// �������ӳص�һЩ����
		ds.setInitialSize(5);// ԭʼ���Ӹ���
		ds.setMaxTotal(8);// ������Ӹ���
		ds.setMaxWaitMillis(3000);// �������ȴ�ʱ������λ����

		// �����ӳ��л�ȡ����
		for (int i = 0; i < 8; i++) {
			Connection conn = null;
			try {
				conn = ds.getConnection();
				System.out.println(conn.hashCode());

				// if(i==5) {
				// conn.close();
				//
				// }
				//
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DBCPTest d = new DBCPTest();
		d.Test2();
	}

	// ����Test1�ĸĽ����ù���ģʽ
	public void Test2() {
		try {
			// �������ö���
			Properties pr = new Properties();
			InputStream in = DBCPTest.class.getClassLoader().getResourceAsStream("config/dbcp.properties");

			pr.load(in);

			// �������ӳض��󣬲����������ӹ������������ö������Ϣ
			BasicDataSource ds = (BasicDataSource) BasicDataSourceFactory.createDataSource(pr);
			// �����ӳػ�ȡ����
			for (int i = 0; i < 8; i++) {
				Connection conn = null;
				conn = ds.getConnection();
				System.out.println(conn.hashCode());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
