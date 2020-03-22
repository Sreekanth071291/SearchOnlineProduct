package com.xyz.search.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestTest {

	@Test
	public void test() {
		Request r=new Request();
		r.setSkuName("SKU1");
		assertNotNull(r.getSkuName());
	}

}
