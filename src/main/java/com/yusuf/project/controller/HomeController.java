package com.yusuf.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yusuf.project.service.CategoryService;
import com.yusuf.project.service.ProductService;

public class HomeController {
@Autowired
CategoryService categoryService;

@Autowired
ProductService productService;

@GetMapping({"/", "/home"})
public String home (Model model) {
	return"index";
}
@GetMapping("/shop")
public String shop(Model model) {
	model.addAttribute("categories", categoryService.getAllCategory());
	model.addAttribute("products", productService.getAllProduct());
	return"index";
}
@GetMapping("/shop/category/{id}")
public String shopByCategory(Model model, @PathVariable int id) {
	model.addAttribute("categories", categoryService.getAllCategory());
	model.addAttribute("products", productService.getAllProductsByCategoryId(id));
	return"shop";
	}
@GetMapping("/shop/viewProduct/{id}")
public String viewProduct(Model model, @PathVariable int id) {
	model.addAttribute("product", productService.getProductById(id).get());
	return"viewProduct";
	}

}
