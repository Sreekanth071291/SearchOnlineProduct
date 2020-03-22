package com.xyz.search.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name = "Brand")
@Table(name = "Brand")
@IdClass(BrandID.class)
public class SkuBrand {
	@Id
	private String sku;
	private String catagorie;
	private String brand;
	private Double price;
	private String colour;
	private Long size;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCatagorie() {
		return catagorie;
	}

	public void setCatagorie(String catagorie) {
		this.catagorie = catagorie;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
