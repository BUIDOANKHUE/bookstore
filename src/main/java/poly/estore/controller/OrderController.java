package poly.estore.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.estore.cart.CartService;
import poly.estore.entity.Account;
import poly.estore.entity.Order;
import poly.estore.entity.OrderDetail;
import poly.estore.entity.Product;
import poly.estore.service.AccountService;
import poly.estore.service.OrderDetailService;
import poly.estore.service.OrderService;
import poly.estore.service.ProductService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	AccountService accountService;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("/order/checkout")
	public String checkout(@ModelAttribute("order") Order order, Authentication auth) {
		String username = auth.getName();
		Account account = accountService.findByUsername(username);
		order.setCreateDate(new Date());
		order.setAccount(account);
		return "order/checkout";
	}
	@PostMapping("/order/checkout")
	public String checkout(Model model, 
			@ModelAttribute("order") Order order) {
		// insert order
		orderService.create(order);
		
		cartService.getItems().forEach(item -> {
			// create order detail object
			OrderDetail detail = new OrderDetail();
			detail.setPrice(item.getPrice());
			detail.setQuantity(item.getQuantity());
			detail.setOrder(order);
			Product product = productService.findById(item.getId());
			detail.setProduct(product);
			// insert order detail
			orderDetailService.create(detail);
		});
		
		return "redirect:/order/list";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model, Authentication auth) {
		String username = auth.getName();
		Account account = accountService.findByUsername(username);
		model.addAttribute("user", account);
		return "order/list";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		Order order = orderService.findById(id);
		model.addAttribute("order", order);
		return "order/detail";
	}
}