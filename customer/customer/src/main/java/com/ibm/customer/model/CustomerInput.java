package com.ibm.customer.model;

import java.util.Objects;


public class CustomerInput {

	private String customerNumber;
	private String firstName;
	private String lastName;
	private String email;
	
	public CustomerInput() {
		super();
	}

	public CustomerInput(String customerNumber, String firstName, String lastName, String email) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerNumber, email, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerInput other = (CustomerInput) obj;
		return Objects.equals(customerNumber, other.customerNumber) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "CustomerInput [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}
}
