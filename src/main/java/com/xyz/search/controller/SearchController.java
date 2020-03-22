package com.xyz.search.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.search.model.SkuBrand;
import com.xyz.search.model.Group;
import com.xyz.search.model.Products;
import com.xyz.search.model.Request;
import com.xyz.search.service.SearchService;

@RestController
@CrossOrigin()
public class SearchController {
	@Autowired
	SearchService service;

	@PostMapping(value = "/GetAllSkusOnGroups", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Set<SkuBrand>> groupAll(@RequestBody Group group) {
		return service.groupAll(group);
	}

	@PostMapping(value = "/GetSkusOnGroups", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Set<SkuBrand>> groupbByRequest(@RequestBody Request request) {
		return service.groupByRequest(request);
	}

	@GetMapping(value = "/GetbySKUs/{sku}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Set<Products> getSku(@PathVariable(name = "sku") String sku) {
		return service.getSku(sku);
	}

	@GetMapping(value = "/GetAllSKUs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Set<Products> getAllSku() {
		return service.getSku();
	}

	@GetMapping(value = "/{brand}/count", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Integer getAllSkuCount(@PathVariable(name = "brand") String brand) {
		return service.getBrandSkuCount(brand);
	}

}
