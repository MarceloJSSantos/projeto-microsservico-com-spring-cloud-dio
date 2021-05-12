package com.marcelojssantos.dio.productcatalog.repository;


import com.marcelojssantos.dio.productcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
