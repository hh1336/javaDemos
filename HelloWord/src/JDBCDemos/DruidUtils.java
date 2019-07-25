package JDBCDemos;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtils {
	private static DataSource ds;

	static {
		try {
			// 加载配置文件
			Properties pro = new Properties();
			// 将配置文件载入文件流中
			InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			// 将配置文件的流载入
			pro.load(is);
			// 得到连接池对象
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void close(Statement stmt,Connection conn) {
		close(null,stmt,conn);
	}
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
}
