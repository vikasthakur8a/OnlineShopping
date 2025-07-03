package com.wipro.cartms.service;

import com.wipro.cartms.entity.Cart;
import com.wipro.cartms.exception.CartNotFoundException;

public interface ICartService {

    void addCart(Cart order);
    void deleteCart(int id) throws CartNotFoundException;
    void updateCart(int id, Cart cart) throws CartNotFoundException;
    Cart searchCart(int id) throws CartNotFoundException;

}
