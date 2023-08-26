package poly.estore.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.estore.cart.CartItem;
import poly.estore.cart.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	
	@GetMapping("/cart/view")
	public String view(Model model) {
		Collection<CartItem> cartItems = cartService.getItems();
		model.addAttribute( "cartItems",cartItems);
		
		return "cart/view";
	}
	
	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cartService.add(id);
		return "cart/view";
	}
	
	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "cart/view";
	}
	
	@RequestMapping("/cart/clear")
	public String clear() {
		cartService.clear();
		return "cart/view";
	}
	
	@RequestMapping("/cart/update")
	public String update(HttpServletRequest request) {
		cartService.getItems().forEach(item -> {
			Integer id = item.getId();
			int qty = Integer.parseInt(request.getParameter("qty_" + id));
			cartService.update(id, qty);
		});
		return "cart/view";
	}
}
