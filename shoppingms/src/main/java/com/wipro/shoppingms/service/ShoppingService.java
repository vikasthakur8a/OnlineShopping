package com.wipro.shoppingms.service;

import com.wipro.shoppingms.entity.*;
import com.wipro.shoppingms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    private int id;

    private int generateId(){
        id = ++id;
        return id;
    }
    private Cart cart;
    private Order order;

    public void createCustomer(Customer customer){
        int generatedId = generateId();
        customer.setCustomerId(generatedId);
        cart = new Cart();
        cart.setCartId(generatedId);
        order = new Order();
        order.setOrderId(generatedId);
        customerRepo.addCustomer(customer);
        cartRepo.addOrder(cart);
        orderRepo.addOrder(order);
    }

    public void addProduct(Product product){
        productRepo.addProduct(product);
    }

    public List<Product> viewProducts(){
        return productRepo.getAllProducts();
    }

    public void updateCart(LineItem item){
        Cart cart1 = cartRepo.getOrderById(id);
        List<LineItem> items = cart1.getItems();
        items.add(item);
        cartRepo.addOrder(cart1);
    }

    public void placeOrder(){
        Cart existingCart = cartRepo.getOrderById(id);
        Order order1 = orderRepo.getOrderById(id);
        order1.setItems(existingCart.getItems());
        orderRepo.addOrder(order1);
    }

    public int getOrderId(){
        return id;
    }

    public List<LineItem> getOrderItems(){
        Order existingOrder = orderRepo.getOrderById(id);
        return existingOrder.getItems();
    }

    public List<LineItem> getCartItems(){
        Cart existingCart = cartRepo.getOrderById(id);
        return existingCart.getItems();
    }

    public void removeCartItem(int itemId){
        Cart existingCart = cartRepo.getOrderById(id);
        List<LineItem> existingCartItems = existingCart.getItems();
        Cart newCart = new Cart();
        newCart.setCartId(existingCart.getCartId());
        List<LineItem> newItems = new ArrayList<>();
        for(LineItem item: existingCartItems){
            if(item.getItemId() != itemId){
                newItems.add(item);
            }
        }
        newCart.setItems(newItems);
        cartRepo.updateOrder(existingCart.getCartId(), newCart);
    }

}
