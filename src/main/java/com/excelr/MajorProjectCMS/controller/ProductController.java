package com.excelr.MajorProjectCMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.MajorProjectCMS.entity.Customer;
import com.excelr.MajorProjectCMS.entity.Product;
import com.excelr.MajorProjectCMS.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	
		@GetMapping("/getProduct/{id}")
		public Product getProduct(@PathVariable("id") int pno)
		{
			Product p1=productService.getProduct(pno);
			return p1;
		}
		
		
		@GetMapping("/productHome")
		public String getAllProducts(Model model)
		{
			List<Product> products=productService.getAllProducts();
			model.addAttribute("prods",products);
			return "product-list.html";	
		}
		
		
		@PostMapping("/addProduct")
		public String addProduct(@ModelAttribute Product p1)
		{
			productService.addProduct(p1);
			return "redirect:/productHome";
		}
		
		@DeleteMapping("/deleteProduct/{id}")
		public String deleteProduct(@PathVariable("id") int pno)
		{
			productService.deleteProduct(pno);
			return "Product Record Deleted";
		}
		
		
		@PutMapping("/updateProduct/{id}")
		public String updateProduct(@PathVariable("id") int pno,@RequestBody Product newValues)
		{
			productService.updateProduct(pno,newValues);
			return "Product Record Updated";
		}
		
		@RequestMapping("/newProduct")
		public String newProduct(Model model)
		{
			Product p1=new Product();
			model.addAttribute("product",p1);
			return "add-new-product-form";
		}
}
