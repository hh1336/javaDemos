package JDBCDemos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//得到连接对象
			conn = DruidUtils.getConnection();
			//定义sql
			String sql = "insert into users values(null,?,?,?)";
			//给sql语句的参数进行赋值
			ps = conn.prepareStatement(sql);
			ps.setString(1, "王五");
			ps.setInt(2, 88);
			ps.setString(3, "北京");
			
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("操作成功");
			}
			System.out.println("操作结束");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtils.close(ps, conn);
		}
	}
}
