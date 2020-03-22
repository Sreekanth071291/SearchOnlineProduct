package com.xyz.search.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.xyz.search.SearchApplicationTest;
import com.xyz.search.service.SearchService;

@RestController
public class SearchControllerTest extends SearchApplicationTest{

	private MockMvc mockmvc;
	
	@Autowired
	SearchService service;
	
	@Autowired
	private WebApplicationContext webcon;
	
	@Before
	public void setUp() throws Exception
	{
		mockmvc= MockMvcBuilders.webAppContextSetup(this.webcon).build();
		service= Mockito.mock(SearchService.class);
	}
	
	@Test
	public void testGetAllSKUs() throws Exception {
		mockmvc.perform(get("/GetAllSKUs")).andExpect(status().isOk());
	}
	
	@Test
	public void testInvalidGetAllSKUs() throws Exception {
		mockmvc.perform(get("/GetAllSKUs12")).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testGetSKUs() throws Exception {
		mockmvc.perform(get("/GetbySKUs/{sku}", "SKU1"))
        .andExpect(status().isOk());
		
	}
	
	@Test
	public void testInvalidtestGetSKUs() throws Exception {
		mockmvc.perform(get("/GetbySKUs/{sasku1}", 1))
        .andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllbanner() throws Exception {
		mockmvc.perform(get("/{brand}/count","Nike")).andExpect(status().isOk());
	}
	
	@Test
	public void testInvalidGetbanner() throws Exception {
		mockmvc.perform(get("/{brand}/count1",1)).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void testGetSkusOnGroups() throws Exception {
		String request="{\r\n" + 
				"        \"groupedBy\": \"size\"\r\n" + 
				" }";
		ResultMatcher ok =MockMvcResultMatchers.status().isOk();
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/GetSkusOnGroups")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request);
		mockmvc.perform(builder).andExpect(ok);
	}
	
	@Test
	public void testGetSkusOnGroupsInvalid() throws Exception {
		String request="";
		ResultMatcher ok =MockMvcResultMatchers.status().is4xxClientError();
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/GetSkusOnGroups")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request);
		mockmvc.perform(builder).andExpect(ok);
	}
	
	@Test
	public void testGetSkusOnGroupsInvalidstring() throws Exception {
		String request="testa";
		ResultMatcher ok =MockMvcResultMatchers.status().is4xxClientError();
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/GetSkusOnGroups")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request);
		mockmvc.perform(builder).andExpect(ok);
	}
	
	@Test
	public void testGetAllSkusOnGroups() throws Exception {
		String request=" {\r\n" + 
				" 	\"skuName\":\"SKU1\",\r\n" + 
				"    \"groupedBy\": \"size\"\r\n" + 
				" }";
		ResultMatcher ok =MockMvcResultMatchers.status().isOk();
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/GetAllSkusOnGroups")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request);
		mockmvc.perform(builder).andExpect(ok);
	}
	
	@Test
	public void testGetAllSkusOnGroupsInvalid() throws Exception {
		String request="";
		ResultMatcher ok =MockMvcResultMatchers.status().is4xxClientError();
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/GetAllSkusOnGroups")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request);
		mockmvc.perform(builder).andExpect(ok);
	}
	
	@Test
	public void testGetAllSkusOnGroupsInvalidstring() throws Exception {
		String request="testa";
		ResultMatcher ok =MockMvcResultMatchers.status().is4xxClientError();
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/GetAllSkusOnGroups")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request);
		mockmvc.perform(builder).andExpect(ok);
	}
	

}
