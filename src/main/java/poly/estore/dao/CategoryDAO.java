package poly.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.estore.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
