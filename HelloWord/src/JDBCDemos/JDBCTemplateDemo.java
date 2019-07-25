package JDBCDemos;

import java.beans.beancontext.BeanContextSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*
 * 需要导入5个jar包
 * 1.commons-logging-1.1.1.jar
 * 2.spring-beans-4.3.7.RELEASE.jar
 * 3.spring-core-4.3.7.RELEASE.jar
 * 4.spring-jdbc-4.3.7.RELEASE.jar
 * 5.spring-tx-4.3.7.RELEASE.jar
 */

public class JDBCTemplateDemo {
	@Test
	public void test1() {
		JdbcTemplate tmp = new JdbcTemplate(DruidUtils.getDataSource());
		System.out.println(tmp);
		String sql = "update users set age = ? where id = ?";
		int count = tmp.update(sql,58,8);
		System.out.println(count);
	}
	
	@Test
	public void test2() {
		JdbcTemplate tmp = new JdbcTemplate(DruidUtils.getDataSource());
		String sql = "insert into users values(null,?,?,?)";
		int count = tmp.update(sql,"张三",30,"北京");
		System.out.println(count);
	}
	@Test
	public void test3() {
		JdbcTemplate tmp = new JdbcTemplate(DruidUtils.getDataSource());
		String sql = "delete from users where id = ?";
		int count = tmp.update(sql,2);
		System.out.println(count);
	}
	
	@Test
	public void test4() {
		JdbcTemplate tmp = new JdbcTemplate(DruidUtils.getDataSource());
		String sql = "select * from users where id = ?";
		Map<String,Object> map = tmp.queryForMap(sql,1);
		System.out.println();
	}
	@Test
	public void test5() {
		JdbcTemplate tmp = new JdbcTemplate(DruidUtils.getDataSource());
		String sql = "select * from users";
		List<Map<String,Object>> result = tmp.queryForList(sql);
		System.out.println(result);
	}
	
	//查询映射
	@Test
	public void test6() {
		JdbcTemplate tmp = new JdbcTemplate(DruidUtils.getDataSource());
		String sql = "select * from users";
//		List<UsersEntity> result = tmp.query(sql,new RowMapper<UsersEntity>() {
//			@Override
//			public UsersEntity mapRow(ResultSet rs, int i) throws SQLException {
//				UsersEntity ue = new UsersEntity();
//				ue.setId(rs.getInt("Id"));
//				ue.setName(rs.getString("Name"));
//				ue.setAge(rs.getInt("Age"));
//				ue.setAddress(rs.getString("Address"));
//				
//				return ue;
//			}
//			
//			
//		});
		List<UsersEntity> result = tmp.query(sql, new BeanPropertyRowMapper<UsersEntity>(UsersEntity.class));
		for (UsersEntity ue : result) {
			System.out.println(ue);
		}
		String sql1 = "select count(id) from users";
		Long count = tmp.queryForObject(sql1, Long.class);
		System.out.println(count);
	}
}
