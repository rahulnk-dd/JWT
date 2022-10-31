package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

}
