package com.mss.springboot.web.app.CRUD.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.springboot.web.app.CRUD.dto.ProductDto;
import com.mss.springboot.web.app.CRUD.entity.Product;
import com.mss.springboot.web.app.CRUD.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	
	
	public Product getById(int id) {
		return productRepository.findById(id).get();
	}
	
	
	public Product delete(int id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		return product;
	}
	
	
	
	//	Method ID Auto-Increment
	private int autoIncrement() {
		List<Product> products = productRepository.findAll();
		return products.isEmpty() ? 1 : 
			products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
	}
	public Product save(ProductDto dto) {
		//	Id Auto-Increment
		int id = autoIncrement();
		
		Product product = new Product(id, dto.getName(), dto.getPrice());
		return productRepository.save(product);
	}
	
	
	
	public Product update(int id, ProductDto dto) {
		Product product = productRepository.findById(id).get();
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		return productRepository.save(product);
	}
	
	
	
}