package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;

@RestController
public class ProductController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired 
	private UserDao userDao;
	
    @PostMapping("/forAdmin-addproducts")
    @PreAuthorize("hasRole('Admin')")
    public User addproducts(@RequestBody Product product) {
    	
    	System.out.println(product.getProductName()+" "+ product.getProductId());
    	this.productDao.save(product);
    	System.out.println("*************************");
    	User adminDetails = userService.getDetails();
    	
    	System.out.println(adminDetails);
    	
    	List<Product> adminProducts = adminDetails.getProducts();
    	adminProducts.add(product);
    	adminDetails.setProducts(adminProducts);
    	
    	System.out.println("11111111111111111111111");
    	this.userDao.save(adminDetails);
    	
    	return adminDetails;
    }
    
}
