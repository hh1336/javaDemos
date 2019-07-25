package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	private static DataSource ds;
	
	static {
		try {
			Properties pt = new Properties();
			InputStream is= JDBCUtil
			.class
			.getClassLoader()
			.getResourceAsStream("druid.properties");
			pt.load(is);
			ds = DruidDataSourceFactory.createDataSource(pt);
		} catch(IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
}
