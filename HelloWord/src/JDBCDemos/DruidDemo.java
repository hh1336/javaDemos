package JDBCDemos;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * ���� druid-1.0.9.jar
 */

public class DruidDemo {

	public static void main(String[] args) throws Exception {
		//���������ļ�
		Properties pro = new Properties();
		//�������ļ������ļ�����
		InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
		//�������ļ���������
		pro.load(is);
		//�õ����ӳض���
		DataSource ds = DruidDataSourceFactory.createDataSource(pro);
		
		//�����ӳ��л�ȡ���Ӷ���
		Connection conn = ds.getConnection();
		
		System.out.println(conn);

	}

}
