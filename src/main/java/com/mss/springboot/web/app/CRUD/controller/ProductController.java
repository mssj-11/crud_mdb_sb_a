package com.mss.springboot.web.app.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.springboot.web.app.CRUD.dto.ProductDto;
import com.mss.springboot.web.app.CRUD.entity.Product;
import com.mss.springboot.web.app.CRUD.global.exceptions.AttributeException;
import com.mss.springboot.web.app.CRUD.global.exceptions.ResourcesNotFoundEx;
import com.mss.springboot.web.app.CRUD.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.ok(productService.getAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") int id) throws ResourcesNotFoundEx{
		return ResponseEntity.ok(productService.getById(id));
	} 
	
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody ProductDto dto) throws AttributeException{
		return ResponseEntity.ok(productService.save(dto));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody ProductDto dto) throws ResourcesNotFoundEx, AttributeException{
		return ResponseEntity.ok(productService.update(id, dto));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable("id") int id) throws ResourcesNotFoundEx{
		return ResponseEntity.ok(productService.delete(id));
	}
	
	
}