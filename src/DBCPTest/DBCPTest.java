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
		// 创建jdbc连接池对象
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
		ds.setDriverClassName(classDriver);
		// 设置连接池的一些属性
		ds.setInitialSize(5);// 原始连接个数
		ds.setMaxTotal(8);// 最大连接个数
		ds.setMaxWaitMillis(3000);// 设置最大等待时长。单位毫秒

		// 从连接池中获取对象
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

	// 方法Test1的改进，用工厂模式
	public void Test2() {
		try {
			// 创建配置对象
			Properties pr = new Properties();
			InputStream in = DBCPTest.class.getClassLoader().getResourceAsStream("config/dbcp.properties");

			pr.load(in);

			// 创建连接池对象，并且用于连接工厂来加载配置对象的信息
			BasicDataSource ds = (BasicDataSource) BasicDataSourceFactory.createDataSource(pr);
			// 从连接池获取对象
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
