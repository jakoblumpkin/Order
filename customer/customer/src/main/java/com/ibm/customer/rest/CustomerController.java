package com.ibm.customer.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.customer.service.CustomerService;
import com.ibm.customer.model.Customer;
import com.ibm.customer.model.CustomerInput;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomers() {
		logger.info("Entered get Customers");
		
		
		List<Customer> customers = null;
		customers = this.customerService.getCustomers();
		ResponseEntity<List<Customer>> responseEntity = new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		logger.info("Exited get Customers");
		return responseEntity;
	}
	
	@RequestMapping(value="/customer/{customerNumber}/", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable(value="customerNumber") String customerNumber) {
		Customer customer = null;
		customer = this.customerService.getCustomer(customerNumber);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody CustomerInput customer) {
		Customer customer_ = this.customerService.addCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customer_, HttpStatus.OK);
		return responseEntity;
		
	}
}
