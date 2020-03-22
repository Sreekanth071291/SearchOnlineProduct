package com.xyz.search.utility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.xyz.search.model.SkuBrand;
import com.xyz.search.model.Products;

@Component
@Lazy
public class SearchUtility {
	public Map<String, Set<SkuBrand>> getByGrouping(Set<Products> products, String groupedBy) {
		Map<String, Set<SkuBrand>> map = new HashMap<>();
		if (groupedBy!=null) {
			if ("brand".equalsIgnoreCase(groupedBy))
				products.stream().filter(Objects::nonNull)
						.forEach(product1 -> product1.getBrandSet().stream().filter(Objects::nonNull).forEach(brand -> {
							Set<SkuBrand> prodSet = map.getOrDefault(brand.getBrand(), new HashSet<>());
							prodSet.add(brand);
							map.put(brand.getBrand(), prodSet);
						}));
			else if ("price".equalsIgnoreCase(groupedBy))
				products.stream().filter(Objects::nonNull)
						.forEach(product1 -> product1.getBrandSet().stream().filter(Objects::nonNull).forEach(brand -> {
							Set<SkuBrand> prodSet = map.getOrDefault(String.valueOf(brand.getPrice()), new HashSet<>());
							prodSet.add(brand);
							map.put(String.valueOf(brand.getPrice()), prodSet);
						}));
			else if ("color".equalsIgnoreCase(groupedBy))
				products.stream().filter(Objects::nonNull)
						.forEach(product1 -> product1.getBrandSet().stream().filter(Objects::nonNull).forEach(brand -> {
							Set<SkuBrand> prodSet = map.getOrDefault(brand.getColour(), new HashSet<>());
							prodSet.add(brand);
							map.put(brand.getColour(), prodSet);
						}));
			else if ("size".equalsIgnoreCase(groupedBy))
				products.stream().filter(Objects::nonNull)
						.forEach(product1 -> product1.getBrandSet().stream().filter(Objects::nonNull).forEach(brand -> {
							Set<SkuBrand> prodSet = map.getOrDefault(String.valueOf(brand.getSize()), new HashSet<>());
							prodSet.add(brand);
							map.put(String.valueOf(brand.getSize()), prodSet);
						}));
		}
		return map;
	}

	public Integer getBrandSkuCount(Set<Products> productSet, String brand) {
		AtomicInteger count = new AtomicInteger(0);
		productSet.stream().filter(Objects::nonNull).map(Products::getBrandSet).filter(Objects::nonNull)
				.forEach(catagories -> catagories.stream().filter(Objects::nonNull)
						.filter(cat -> cat.getBrand().equalsIgnoreCase(brand)).forEach(c -> count.getAndAdd(1)));
		return count.get();
	}
}
