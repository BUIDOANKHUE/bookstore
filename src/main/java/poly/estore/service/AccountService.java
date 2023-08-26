package poly.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import poly.estore.dao.AccountDAO;
import poly.estore.entity.Account;

@Service
public class AccountService {
	@Autowired
	AccountDAO dao;


	public void create(Account account) {
		dao.save(account);
	}

	public Account findByUsername(String username) {
		return dao.findById(username).get();
	}
	
	public void update(Account account) {
		dao.save(account);
	}
}
