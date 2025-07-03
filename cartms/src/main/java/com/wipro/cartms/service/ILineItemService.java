package com.wipro.cartms.service;

import com.wipro.cartms.entity.LineItem;
import com.wipro.cartms.exception.ItemNotFoundException;

public interface ILineItemService {

    void addItem(LineItem item);
    void deleteItem(int id) throws ItemNotFoundException;
    void updateItem(int id, LineItem item) throws ItemNotFoundException;
    LineItem searchItem(int id) throws ItemNotFoundException;

}
