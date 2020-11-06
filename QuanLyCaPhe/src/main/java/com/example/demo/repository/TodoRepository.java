package com.example.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TodoRepository<T> extends BaseRepository<T> {

}
