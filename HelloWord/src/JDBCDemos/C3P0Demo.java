package JDBCDemos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 需要导入 c3p0-0.9.5.2.jar
 * mchange-commons-java-0.2.11.jar
 *  同时也需要导入对应的数据库驱动jar包
 */

public class C3P0Demo {
	public static void main(String[] args) throws SQLException {
		// 创建数据库连接池对象
		// DataSource ds = new ComboPooledDataSource();//使用默认配置
		DataSource ds = new ComboPooledDataSource("otherc3p0");// 获取对应名称的配置
		// 获取连接对象
		// Connection conn = ds.getConnection();

		// 测试获取多个连接对象
		for (int i = 1; i <= 9; i++) {
			Connection conn = ds.getConnection();
			System.out.println(i + ":" + conn);
			if (i == 5) {
				conn.close();// 归还连接对象
			}
		}

	}
}
