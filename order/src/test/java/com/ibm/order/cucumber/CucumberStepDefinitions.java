package com.ibm.order.cucumber;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.springframework.web.client.RestTemplate;

import com.ibm.order.model.OrderInput;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefinitions {
	
	private RestTemplate restTemplate;
	private OrderInput order;
	
	public CucumberStepDefinitions() {
		this.restTemplate = new RestTemplate();
	}

	@Given("Order Server is running")
	public void ordersInDatabase() throws Exception {
	}
	
	@When("^order receives a request with the orderNumber (.*?)$")
	public void ordersRecieveRequest(String orderNumber) throws IOException {
		String orderUrl = "http://localhost:9000/order/order/" + orderNumber;
		this.order = this.restTemplate.getForObject(orderUrl, OrderInput.class);
	}
	
	@Then("that specific order should be returned")
	public void getReturnOrders() {
		System.out.println(this.order);
		assertNotNull("Order data shouldn't be null", this.order);
	}
}
