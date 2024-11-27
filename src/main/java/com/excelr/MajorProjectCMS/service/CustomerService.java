package com.excelr.MajorProjectCMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.MajorProjectCMS.entity.Customer;
import com.excelr.MajorProjectCMS.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public void addCustomer(Customer c1) {
		customerRepo.save(c1);
		
	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Customer getCustomer(int cno) {
		return customerRepo.findById(cno).get();
	}

	public void deleteCustomer(int cno) {
		customerRepo.deleteById(cno);
		
	}

	public void updateCustomer(int cno, Customer newValues) {
		Customer dbcustomer=getCustomer(cno);
		dbcustomer.setEmail(newValues.getEmail());
		dbcustomer.setFirstname(newValues.getFirstname());
		dbcustomer.setLastname(newValues.getLastname());
		dbcustomer.setMobileno(newValues.getMobileno());
		customerRepo.save(dbcustomer);
	}
}
