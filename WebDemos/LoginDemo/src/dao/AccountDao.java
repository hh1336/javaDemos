package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Account;
import util.JDBCUtil;

public class AccountDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
	
	public Account Login(Account account) {
		try {
			String sql = "select * from accounts where username = ? and password = ?";
			Account acc = template
					.queryForObject(sql,
							new BeanPropertyRowMapper<Account>(Account.class),
							account.getUsername(),
							account.getPassword());
			return acc;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
