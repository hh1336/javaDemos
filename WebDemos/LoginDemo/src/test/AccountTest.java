package test;

import org.junit.Test;

import dao.AccountDao;
import domain.Account;

public class AccountTest {

	@Test
	public void test1() {
		Account acc = new Account();
		acc.setUsername("admin");
		acc.setPassword("123");
		
		AccountDao acd = new AccountDao();
		Account result = acd.Login(acc);
		System.out.println(result);
	}
}
