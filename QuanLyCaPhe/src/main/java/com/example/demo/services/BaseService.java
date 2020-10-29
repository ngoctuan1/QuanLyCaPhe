package com.example.demo.services;

import java.util.Optional;

public interface BaseService<T> {
	public Iterable<T> findAll();

	public Optional<T> find(String id);

	public void save(T p);

	public void delete(String id);

}
