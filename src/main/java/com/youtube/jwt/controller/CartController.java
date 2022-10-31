package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;

@RestController
public class CartController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired 
	private UserDao userDao;

	@PostMapping("/forUser-addProductsCart")
    @PreAuthorize("hasRole('User')")
	public User addProductsToCart(@RequestBody User user) {
			
			this.productDao.saveAll(user.getProducts());
			
			User user1 = userDao.findByUserName(user.getUserName());
			List<Product> productsList = user1.getProducts();
			productsList.addAll(user.getProducts());
			
			this.userDao.save(user1);
			
			return user1;
		
	}
	
}
