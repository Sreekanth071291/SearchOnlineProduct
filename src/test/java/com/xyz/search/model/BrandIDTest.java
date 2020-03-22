package com.xyz.search.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BrandIDTest {

	BrandID b1;
	
	@Before
	public void run() {
		b1=new BrandID();
	}
	@Test
	public void test() {
		BrandID b=new BrandID("SKU1", "Nike");
		BrandID b2=new BrandID("SKU2", "Nike11");
		BrandID b3=new BrandID(null, "Nike1");
		BrandID b4=new BrandID(null, null);
		BrandID b5=new BrandID(null, null);
		assertNotNull(b);
		assertNotNull(b.toString());
		assertNotNull(b.hashCode());
		assertNotNull(b1.equals(b));
		assertNotNull(b1.hashCode());
		assertNotNull(b.equals(b));
		assertNotNull(b.equals(b2));
		assertNotNull(b.equals(null));
		assertNotNull(b.equals(b3));
		assertNotNull(b3.equals(b));
		assertNotNull(b4.equals(b5));
		assertNotNull(b.equals(b5));
	}

}
