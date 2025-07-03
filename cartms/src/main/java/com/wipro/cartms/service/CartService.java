package com.wipro.cartms.service;

import com.wipro.cartms.entity.Cart;
import com.wipro.cartms.exception.CartNotFoundException;
import com.wipro.cartms.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepo orderRepo;

    @Override
    public void addCart(Cart cart) {
        orderRepo.save(cart);
    }

    @Override
    public void deleteCart(int id) throws CartNotFoundException {
        Cart cart = searchCart(id);
        orderRepo.delete(cart);
    }

    @Override
    public void updateCart(int id, Cart cart) throws CartNotFoundException {
        Cart currentCart = searchCart(id);
        currentCart.setItems(cart.getItems());
        orderRepo.save(currentCart);
    }

    @Override
    public Cart searchCart(int id) throws CartNotFoundException {
        Cart cart = orderRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException("Cart Not Found with Id : " + id));
        return cart;
    }
}
