package studentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import DBUtil.DBUtil;
import bean.Student;

public class StudentDaoImpl {

	public boolean login() {
		while (true) {
			System.out.println("请输入姓名");
			Scanner scan = new Scanner(System.in);
			String str1 = scan.nextLine();
			System.out.println("请输入密码");
			Scanner scan2 = new Scanner(System.in);
			String str2 = scan2.nextLine();
			if ("张三".equals(str1) && "123456".equals(str2)) {
				return true;
			} else {
				System.out.println("输入有误，请重新输入");
				continue;
			}
		}
	}

	public void query() {
		Connection c = DBUtil.getconn();
		String sql = "select * from student";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "   " + rs.getString("name") + "    " + rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeing(rs, pstmt, c);
		}

	}

	public void queryById(int a) {
		Connection c = DBUtil.getconn();
		String sql = "select * from student where id=" + a;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "   " + rs.getString("name") + "    " + rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeing(rs, pstmt, c);
		}
	}

	public void add(Student s) {
		Connection c = DBUtil.getconn();
		String sql = "insert into student(id,name,birthday) values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setDate(3, s.getBirthday());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeing(null, pstmt, c);
		}
	}

	public void change(Student s, int id) {
		Connection c = DBUtil.getconn();
		String sql = "update student set id=?, name=?, birthday=? where id=" + id;
		PreparedStatement pstmt = null;
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setDate(3, s.getBirthday());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeing(null, pstmt, c);
		}
	}

	public void delById(int id) {
		Connection c = DBUtil.getconn();
		String sql = "delete from student where id=" + id;
		PreparedStatement pstmt = null;
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeing(null, pstmt, c);
		}
	}
	public void charge(int a) {
		Connection c = DBUtil.getconn();
		String sql = "select * from student limit "+(a-1)*3+", 3";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = c.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "   " + rs.getString("name") + "    " + rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeing(rs, pstmt, c);
		}
	};
}
