package com.mss.springboot.web.app.CRUD.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.springboot.web.app.CRUD.dto.ProductDto;
import com.mss.springboot.web.app.CRUD.entity.Product;
import com.mss.springboot.web.app.CRUD.global.exceptions.AttributeException;
import com.mss.springboot.web.app.CRUD.global.exceptions.ResourceNotFoundException;
import com.mss.springboot.web.app.CRUD.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	
	
	public Product getById(int id) throws ResourceNotFoundException{
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found :("));
	}
	
	
	public Product delete(int id) throws ResourceNotFoundException{
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found :("));
		productRepository.delete(product);
		return product;
	}
	
	
	
	//	Method ID Auto-Increment
	private int autoIncrement() {
		List<Product> products = productRepository.findAll();
		return products.isEmpty() ? 1 : 
			products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
	}
	public Product save(ProductDto dto) throws AttributeException {
		//	Unique Name
		if(productRepository.existByName(dto.getName()))
			throw new AttributeException("name already in use");
		
		//	Id Auto-Increment
		int id = autoIncrement();
		
		Product product = new Product(id, dto.getName(), dto.getPrice());
		return productRepository.save(product);
	}
	
	
	
	public Product update(int id, ProductDto dto) throws ResourceNotFoundException, AttributeException{
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found :("));
		//	If name exist
		if(productRepository.existByName(dto.getName()) && productRepository.findByName(dto.getName()).get().getId() != id)
			throw new AttributeException("name already in use");
		
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		return productRepository.save(product);
	}
	
	
	
	
}