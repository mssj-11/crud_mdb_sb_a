package com.mss.springboot.web.app.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.mss.springboot.web.app.CRUD.global.dto.MessageDto;
import com.mss.springboot.web.app.CRUD.global.exceptions.AttributeException;
import com.mss.springboot.web.app.CRUD.global.exceptions.ResourceNotFoundException;
import com.mss.springboot.web.app.CRUD.service.ProductService;

import jakarta.validation.Valid;


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
	public ResponseEntity<Product> getById(@PathVariable("id") int id) throws ResourceNotFoundException{
		return ResponseEntity.ok(productService.getById(id));
	} 
	
	
	@PostMapping
	public ResponseEntity<MessageDto> save(@Valid @RequestBody ProductDto dto) throws AttributeException{
		Product product = productService.save(dto);
		String message = "Product "+ product.getName() +" have been saved";
		return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<MessageDto> update(@Valid @PathVariable("id") int id, @RequestBody ProductDto dto) throws ResourceNotFoundException, AttributeException{
		Product product = productService.update(id, dto);
		String message = "Product "+ product.getName() +" have been updated";
		return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageDto> delete(@PathVariable("id") int id) throws ResourceNotFoundException{
		Product product = productService.delete(id);
		String message = "Product "+ product.getName() +" have been deleted";
		return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
	}
	
	
	
}