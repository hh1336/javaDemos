package JDBCDemos;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 导入 druid-1.0.9.jar
 */

public class DruidDemo {

	public static void main(String[] args) throws Exception {
		//加载配置文件
		Properties pro = new Properties();
		//将配置文件载入文件流中
		InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
		//将配置文件的流载入
		pro.load(is);
		//得到连接池对象
		DataSource ds = DruidDataSourceFactory.createDataSource(pro);
		
		//从连接池中获取连接对象
		Connection conn = ds.getConnection();
		
		System.out.println(conn);

	}

}
