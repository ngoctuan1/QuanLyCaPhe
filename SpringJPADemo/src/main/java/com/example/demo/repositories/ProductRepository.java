package com.example.demo.repositories;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query(value = "Select * from product p where p.id LIKE concat('%',:id,'%')", nativeQuery = true)
	public Product findOneById(@Param("id") String id);

	public Iterable<Product> findAll(Sort sort);
	

	@Modifying
	@Transactional
	@Query(value = "delete from product where product.id = :id", nativeQuery = true)
	public void delete(@Param("id") String id);

	@Modifying
	@Transactional
	@Query(value = "update product set " + " product.name = :name," + " product.price = :price,"
			+ " product.quantity = :quantity " + "where product.id = :id", nativeQuery = true)
	public void edit(@Param("id") String id, @Param("name") String name, @Param("price") BigDecimal price,
			@Param("quantity") int quan);
}
