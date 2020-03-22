package com.xyz.search.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.search.model.Products;

@Repository
public interface SearchDao extends JpaRepository<Products, String> {
	
	Set<Products> findBySku(String name);

	List<Products> findAll();
}
