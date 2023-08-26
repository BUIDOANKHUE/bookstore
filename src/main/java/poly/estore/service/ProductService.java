package poly.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.estore.dao.ProductDAO;
import poly.estore.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDAO dao;

	public List<Product> findAll() {
		List<Product> list = dao.findAll();
		return list;
	}

	public Product findById(Integer id) {
		Product product = dao.findById(id).get();
		return product;
	}

	public List<Product> findByCategoryId(Integer id) {
		List<Product> list = dao.findByCategoryId(id);
		return list;
	}

	public void save(Product product) {
		dao.save(product);
		
	}
	public Product create(Product product) {
		return dao.save(product);
	}

	public boolean existedById(Integer id) {
		return dao.existsById(id);
	}

	public Product update(Product product) {
		return dao.save(product);
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}
