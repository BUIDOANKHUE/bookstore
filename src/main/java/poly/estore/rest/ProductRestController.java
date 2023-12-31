package poly.estore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.estore.entity.Product;
import poly.estore.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
		@Autowired
			ProductService productService;
		@GetMapping("{id}")
		public Product getOne(@PathVariable("id")Integer id) {
			return productService.findById(id);
		}


}
