package com.wipro.orderms.service;

import com.wipro.orderms.entity.Order;
import com.wipro.orderms.exception.ItemNotFoundException;
import com.wipro.orderms.exception.OrderNotFoundException;

public interface IOrderService {

    void addOrder(Order order);
    void deleteOrder(int id) throws OrderNotFoundException;
    void updateOrder(int id, Order order) throws OrderNotFoundException;
    Order searchOrder(int id) throws OrderNotFoundException;

}
