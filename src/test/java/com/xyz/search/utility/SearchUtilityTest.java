package com.xyz.search.utility;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.xyz.search.model.SkuBrand;
import com.xyz.search.model.Products;

public class SearchUtilityTest {

	@Test
	public void test() {
		SearchUtility util=new SearchUtility();
		Products p =new Products();
		SkuBrand b=new SkuBrand();
		b.setSku("SKU1");
		b.setSize(30L);
		b.setPrice(20.2);
		b.setColour("Red");
		b.setCatagorie("Shirt");
		b.setBrand("Nike");
		Set<SkuBrand> hashBrand = new HashSet<SkuBrand>();
		hashBrand.add(b);
		
		p.setSku("SKU1");
		p.setCatagorie("Shirt");
		p.setBrandSet(hashBrand);
		Set<Products> productSet = new HashSet<Products>(); 
		productSet.add(p); 
		assertNotNull(util.getByGrouping(productSet, "brand"));
		assertNotNull(util.getByGrouping(productSet, "price"));
		assertNotNull(util.getByGrouping(productSet, "color"));
		assertNotNull(util.getByGrouping(productSet, "size"));
	}

}
