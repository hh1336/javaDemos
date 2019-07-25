package JDBCDemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��Ҫ���� mysql-connector-java-5.1.44-bin.jar
 */

public class Demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			
			// ע������
			// Class.forName("com.mysql.jdbc.Driver");ֻ��һ�����ݿ�����ʱ��ʡ��
			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
			// ��������ִ��sql�Ķ���
			st = conn.createStatement();
			
			conn.setAutoCommit(false);//��������
			
			// String sql = "select * from users";
			String sql1 = "update users set age = ? where id = ?";
			String sql2 = "update users set age = ? where id = ?";
			// ִ��sql
			// rs = st.executeQuery(sql);
			// System.out.println(rs.next());
//			while (rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//			}
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);
			ps1.setInt(1, 20);
			ps1.setInt(2, 1);
			
			ps2.setInt(1, 30);
			ps2.setInt(2, 2);
			
			ps1.executeUpdate();
			int a = 3 / 0;
			ps2.executeUpdate();
			conn.commit();//�ύ����
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//			}
			System.out.println("ִ�н���");
		} catch (Exception e) {
			try {
				if(conn != null) {
					conn.rollback();// ����ع�
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps1!= null) {
				try {
					ps1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
