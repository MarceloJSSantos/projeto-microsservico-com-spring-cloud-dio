package com.marcelojssantos.dio.shoppingcart.repository;

import com.marcelojssantos.dio.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
