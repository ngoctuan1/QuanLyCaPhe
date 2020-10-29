package com.example.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SupRepository<T> extends TodoRepository<T> {

}
