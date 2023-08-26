package poly.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.estore.dao.ProductDAO;
import poly.estore.entity.Product;

@Controller
public class HomeController {
	
	@Autowired
	ProductDAO dao;
	
	@RequestMapping("/home/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", required = false) String keyword) {
		int pageSize = 8;
		Page<Product> productPage;
		
		if(keyword != null) {
			productPage = dao.findByNameContainingIgnoreCase(keyword, PageRequest.of(page, pageSize));
			
		}else {
			productPage= dao.findAll(PageRequest.of(page, pageSize));
		}
		model.addAttribute( "productPage", productPage);
		model.addAttribute("keyword" ,keyword);
		
		
		
	

		return "home/index";
	}

	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}
	@RequestMapping("/home/contact")
	public String contact() {
		return "home/contact";
	}
	@RequestMapping("/home/feedback")
	public String feedback() {
		return "home/feedback";
	}
	@RequestMapping("/home/faq")
	public String faq() {
		return "home/faq";
	}
}