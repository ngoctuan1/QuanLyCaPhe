package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T> extends Repository<T, String> {

	Iterable<T> findAll();

	Optional<T> findById(String id);

	void save(T p);

	void deleteById(String id);

//	void deleteAllByIds(List<String> ids);
}
