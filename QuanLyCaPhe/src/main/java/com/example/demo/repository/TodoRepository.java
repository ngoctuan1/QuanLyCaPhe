package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.example.demo.entities.CaLam;

@NoRepositoryBean
public interface TodoRepository<T> extends Repository<T, String> {

	Iterable<T> findAll();

	Optional<T> findById(String id);

	void save(T p);

	void deleteById(String id);

}
