package com.ibm.customer.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.customer.model.Customer;
import com.ibm.customer.model.CustomerInput;
import com.ibm.customer.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	CustomerRepo customerrepo;
	
	public List<Customer> getCustomers() {
		List<Customer> customer = null;
		customer = this.customerrepo.findAll();
		return customer;
	}
	
	public Customer getCustomer(String customerid) {
		Customer customer = null;
		customer = this.customerrepo.findByCustomerNumber(customerid);
		return customer;
	}
	
	public Customer addCustomer(CustomerInput customer) {
		Customer customer_ = new Customer(customer.getCustomerNumber(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
		this.customerrepo.insert(customer_);
		return customer_ ;
		
	}
}
