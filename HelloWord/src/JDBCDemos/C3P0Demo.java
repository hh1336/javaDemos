package JDBCDemos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * ��Ҫ���� c3p0-0.9.5.2.jar
 * mchange-commons-java-0.2.11.jar
 *  ͬʱҲ��Ҫ�����Ӧ�����ݿ�����jar��
 */

public class C3P0Demo {
	public static void main(String[] args) throws SQLException {
		// �������ݿ����ӳض���
		// DataSource ds = new ComboPooledDataSource();//ʹ��Ĭ������
		DataSource ds = new ComboPooledDataSource("otherc3p0");// ��ȡ��Ӧ���Ƶ�����
		// ��ȡ���Ӷ���
		// Connection conn = ds.getConnection();

		// ���Ի�ȡ������Ӷ���
		for (int i = 1; i <= 9; i++) {
			Connection conn = ds.getConnection();
			System.out.println(i + ":" + conn);
			if (i == 5) {
				conn.close();// �黹���Ӷ���
			}
		}

	}
}
