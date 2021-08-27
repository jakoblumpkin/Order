package com.ibm.menu.model;

import java.util.Objects;

public class MenuInput {
	private String menuItemNumber;
	private String category;
	private String name;
	private String description;
	private int numAvailable;
	private double price;
	
	public MenuInput() {
		super();
	}

	public MenuInput(String menuItemNumber, String category, String name, String description, int numAvailable,
			double price) {
		super();
		this.menuItemNumber = menuItemNumber;
		this.category = category;
		this.name = name;
		this.description = description;
		this.numAvailable = numAvailable;
		this.price = price;
	}

	public String getMenuItemNumber() {
		return menuItemNumber;
	}

	public void setMenuItemNumber(String menuItemNumber) {
		this.menuItemNumber = menuItemNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumAvailable() {
		return numAvailable;
	}

	public void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, menuItemNumber, name, numAvailable, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuInput other = (MenuInput) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(menuItemNumber, other.menuItemNumber) && Objects.equals(name, other.name)
				&& numAvailable == other.numAvailable
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "MenuInput [menuItemNumber=" + menuItemNumber + ", category=" + category + ", name=" + name
				+ ", description=" + description + ", numAvailable=" + numAvailable + ", price=" + price + "]";
	}

}
