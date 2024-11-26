package com.excelr.MajorProjectCMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.MajorProjectCMS.entity.Customer;
import com.excelr.MajorProjectCMS.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//Get Http Method used to fetch the data of single Customer
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable("id") int cno)
	{
		Customer c1=customerService.getCustomer(cno);
		return c1;
	}
	
	//Get Http Method used to fetch the data of All Customers
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers()
	{
		List<Customer> customers=customerService.getAllCustomers();
		return customers;	
	}
	
	@RequestMapping("/mi")
	public String mi()
	{
		return "Rohit";
	}
	
	//Post Http Method used to add Customer
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer c1)
	{
		customerService.addCustomer(c1);
		return "Customer Record Inserted";
	}
	
	//Delete Http Method used to delete Customer
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int cno)
	{
		customerService.deleteCustomer(cno);
		return "Customer Record Deleted";
	}

}
