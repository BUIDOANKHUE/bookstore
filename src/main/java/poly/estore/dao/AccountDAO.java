package poly.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.estore.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

}
