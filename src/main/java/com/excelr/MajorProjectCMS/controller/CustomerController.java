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
import com.excelr.MajorProjectCMS.service.CustomerService;

//@RestController
@Controller
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
	@GetMapping("/customerHome")
	public String getAllCustomers(Model model)
	{
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "customer-list.html";	
	}
	
	@RequestMapping("/mi")
	public String mi()
	{
		return "Rohit";
	}
	
	//Post Http Method used to add Customer
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute Customer c1)
	{
		customerService.addCustomer(c1);
		return "redirect:/customerHome";
	}
	
	//Delete Http Method used to delete Customer
	@RequestMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int cno)
	{
		customerService.deleteCustomer(cno);
		return "redirect:/customerHome";
	}
	
	
	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int cno,@ModelAttribute Customer newValues)
	{
		customerService.updateCustomer(cno,newValues);
		return "redirect:/customerHome";
	}
	
	@RequestMapping("/newCustomer")
	public String newCustomer(Model model)
	{
		Customer c1=new Customer();
		model.addAttribute("customer",c1);
		return "add-new-customer-form";
	}

	@RequestMapping("/updatecustomerform/{id}")
	public String updateCustomerForm(@PathVariable("id") int cno,Model model)
	{
		Customer c1=customerService.getCustomer(cno);
		model.addAttribute("customer",c1);
		return "update-customer-form";
	}
}
