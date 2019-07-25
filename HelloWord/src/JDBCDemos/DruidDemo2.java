package JDBCDemos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//�õ����Ӷ���
			conn = DruidUtils.getConnection();
			//����sql
			String sql = "insert into users values(null,?,?,?)";
			//��sql���Ĳ������и�ֵ
			ps = conn.prepareStatement(sql);
			ps.setString(1, "����");
			ps.setInt(2, 88);
			ps.setString(3, "����");
			
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("�����ɹ�");
			}
			System.out.println("��������");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtils.close(ps, conn);
		}
	}
}
