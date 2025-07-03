package com.wipro.orderms.service;

import com.wipro.orderms.entity.LineItem;
import com.wipro.orderms.exception.ItemNotFoundException;

public interface ILineItemService {

    void addItem(LineItem item);
    void deleteItem(int id) throws ItemNotFoundException;
    void updateItem(int id, LineItem item) throws ItemNotFoundException;
    LineItem searchItem(int id) throws ItemNotFoundException;

}
