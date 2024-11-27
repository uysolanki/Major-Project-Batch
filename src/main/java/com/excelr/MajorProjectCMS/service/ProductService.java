package com.excelr.MajorProjectCMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.MajorProjectCMS.entity.Customer;
import com.excelr.MajorProjectCMS.entity.Product;
import com.excelr.MajorProjectCMS.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;

	public Product getProduct(int pno) {
		return productRepo.findById(pno).get();
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public void addProduct(Product p1) {
		productRepo.save(p1);
		
	}

	public void deleteProduct(int pno) {
		productRepo.deleteById(pno);
		
	}

	public void updateProduct(int pno, Product newValues) {
		Product dbproduct=getProduct(pno);
		dbproduct.setProductcategory(newValues.getProductcategory());
		dbproduct.setProductcolor(newValues.getProductcolor());
		dbproduct.setProductprice(newValues.getProductprice());
		dbproduct.setProducttname(newValues.getProducttname());
		productRepo.save(dbproduct);
		
	}

}
