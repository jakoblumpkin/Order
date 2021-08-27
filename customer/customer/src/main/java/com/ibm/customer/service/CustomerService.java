package com.ibm.customer.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.customer.model.Customer;
import com.ibm.customer.model.CustomerInput;


public interface CustomerService {
     public List<Customer> getCustomers();
     public Customer getCustomer(String customerid);
     public Customer addCustomer(CustomerInput customer);
}
