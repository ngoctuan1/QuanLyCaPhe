package com.example.demo.repositories;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository
public interface TodoRepository extends BaseRepository<Product, Serializable> {

}
