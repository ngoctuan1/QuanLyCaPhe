package com.example.demo.repositories;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

//	@Modifying
//	@Transactional
//	@Query(value = "delete from :tableName where :tableName" + ".id = :id", nativeQuery = true)
//	void delete(@Param("tableName") String tableName, @Param("id") String id);

	List<T> findAll();

	List<T> findAll(Sort sort);

	@Modifying
	@Transactional
	@Query(value = "select * from :tableName where :tableName.id = :id", nativeQuery = true)
	Optional<T> findOne(@Param("tableName") String tableName, @Param("id") String id);

	T save(T saveObj);

	void delete(ID id);
}
