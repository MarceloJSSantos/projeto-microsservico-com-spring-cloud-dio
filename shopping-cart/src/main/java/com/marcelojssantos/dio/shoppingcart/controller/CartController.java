package com.marcelojssantos.dio.shoppingcart.controller;

import com.marcelojssantos.dio.shoppingcart.model.Cart;
import com.marcelojssantos.dio.shoppingcart.model.Item;
import com.marcelojssantos.dio.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id,@RequestBody Item item){
        Optional<Cart> savedCart =  cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable Integer id){return cartRepository.findById(id);}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable  Integer id){cartRepository.deleteById(id);}

}
