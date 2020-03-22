package com.xyz.search;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ServletInitializerTest {

	@MockBean
	@InjectMocks
	private ServletInitializer ser=new ServletInitializer();
	
	@Mock
	SpringApplicationBuilder app;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void servletInitializerTest() {
		ser.configure(app);
		assertTrue(true);
	}

}
