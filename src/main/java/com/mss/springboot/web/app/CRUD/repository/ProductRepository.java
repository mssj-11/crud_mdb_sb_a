package com.mss.springboot.web.app.CRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mss.springboot.web.app.CRUD.entity.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{
}