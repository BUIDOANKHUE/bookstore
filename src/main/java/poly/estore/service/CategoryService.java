package poly.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.estore.dao.CategoryDAO;
import poly.estore.entity.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDAO dao;

	public List<Category> findAll() {
		return dao.findAll();
	}

	public Category findById(Integer categoryId) {
		return dao.findById(categoryId).orElse(null);
		
	}

	
}
