package poly.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.estore.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
