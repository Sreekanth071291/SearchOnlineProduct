package com.xyz.search.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class ProductsTest {

	@Test
	public void test() {
		Products p =new Products();
		
		SkuBrand b=new SkuBrand();
		b.setSku("SKU1");
		b.setSize(30L);
		b.setPrice(20.2);
		b.setColour("Red");
		b.setCatagorie("Shirt");
		b.setBrand("Nike");
		List<SkuBrand> l=new ArrayList<SkuBrand>();
		l.add(b);
		p.setSku("SKU1");
		p.setCatagorie("Shirt");
		p.setBrandSet(new HashSet<SkuBrand>(l));
		assertNotNull(b.getSku());
		assertNotNull(b.getSize());
		assertNotNull(b.getBrand());
		assertNotNull(b.getPrice());
		assertNotNull(b.getColour());
		assertNotNull(b.getCatagorie());
		assertNotNull(b.getBrand());
		assertNotNull(p.getSku());
		assertNotNull(p.getCatagorie());
		assertNotNull(p.getBrandSet());
		
	}

}
