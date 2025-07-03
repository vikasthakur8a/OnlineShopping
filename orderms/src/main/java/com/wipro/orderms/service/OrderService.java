package com.wipro.orderms.service;

import com.wipro.orderms.entity.Order;
import com.wipro.orderms.exception.OrderNotFoundException;
import com.wipro.orderms.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void addOrder(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(int id) throws OrderNotFoundException {
        Order order = searchOrder(id);
        orderRepo.delete(order);
    }

    @Override
    public void updateOrder(int id, Order order) throws OrderNotFoundException{
        Order currentOrder = searchOrder(id);
        currentOrder.setItems(order.getItems());
        orderRepo.save(currentOrder);
    }

    @Override
    public Order searchOrder(int id) throws OrderNotFoundException {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found with Id : " + id));
        return order;
    }
}
