package poly.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.estore.dao.ProductDAO;
import poly.estore.entity.Category;
import poly.estore.entity.Product;
import poly.estore.service.CategoryService;
import poly.estore.service.ProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;

@Controller
public class AdminController {
	@Autowired
	ProductDAO dao;
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    private static String uploadDir = "C:\\Users\\ĐOÀN KHUÊ\\OneDrive\\Máy tính\\J6EStore3\\src\\main\\resources\\static\\images"; 

    
    
    @GetMapping("/admin/add-product")
    public String showAddProductForm(Model model) {
  
        Iterable<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "cart/add-product"; 
    }

    @PostMapping("/admin/add-product")
    public String addProduct(
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam("image") MultipartFile imageFile, 
            @RequestParam Integer category,
            Model model) {

     
        if (!imageFile.isEmpty()) {
            try {
             
                String imageName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
                byte[] imageBytes = imageFile.getBytes();
                Path imagePath = Paths.get(uploadDir, imageName);
                Files.write(imagePath, imageBytes);

       
                Product product = new Product();
                product.setName(name);
                product.setPrice(price);
                product.setImage(imageName);
                product.setAvailable(true); 
                product.setCategory(categoryService.findById(category));
                productService.save(product);
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý lỗi nếu cần
            }
        }
		model.addAttribute("message", "Thêm Sản Phẩm Thành Công, quá trình tải ảnh lên trang sản phẩm có thể mất vài phút!");

        return "cart/add-product";
    }
}
