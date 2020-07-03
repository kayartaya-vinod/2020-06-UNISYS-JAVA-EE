package com.unisys.entity;

import com.unisys.annotations.Csv;
import com.unisys.annotations.Include;

@Csv
public class Product {

	@Include
	public int id;
	@Include
	public String name;
	@Include
	public double unitPrice;
	@Include
	public int unitsInStock;

	public Product() {
	}

	public Product(int id, String name, double unitPrice, int unitsInStock) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

}
