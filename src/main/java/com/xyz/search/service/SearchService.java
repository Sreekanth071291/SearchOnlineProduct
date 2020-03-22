package com.xyz.search.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.search.model.SkuBrand;
import com.xyz.search.model.Group;
import com.xyz.search.model.Products;
import com.xyz.search.model.Request;
import com.xyz.search.repository.SearchDao;
import com.xyz.search.utility.SearchUtility;

@Service
public class SearchService {
	@Autowired
	SearchDao dao;
	@Autowired
	SearchUtility utility;

	public Set<Products> getSku(String sku) {
		return dao.findBySku(sku);
	}

	public Set<Products> getSku() {
		List<Products> listProducts = dao.findAll();
		return (listProducts != null) ? new HashSet<>(listProducts) : new HashSet<>();
	}

	public Map<String, Set<SkuBrand>> groupByRequest(Request request) {
		return utility.getByGrouping(getSku(request.getSkuName()), request.getGroupedBy());
	}

	public Map<String, Set<SkuBrand>> groupAll(Group group) {
		return utility.getByGrouping(getSku(), group.getGroupedBy());
	}

	public Integer getBrandSkuCount(String brand) {
		return utility.getBrandSkuCount(getSku(), brand);
	}
}
