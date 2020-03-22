package com.xyz.search.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Products")
@Table(name = "Products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String sku;
	private String catagorie;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "sku", referencedColumnName = "sku") })
	private Set<SkuBrand> brandSet;

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

	public Set<SkuBrand> getBrandSet() {
		return brandSet;
	}

	public void setBrandSet(Set<SkuBrand> brandSet) {
		this.brandSet = brandSet;
	}

}
