package poly.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.estore.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, String> {

}
