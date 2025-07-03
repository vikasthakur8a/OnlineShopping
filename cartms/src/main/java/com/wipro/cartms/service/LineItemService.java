package com.wipro.cartms.service;

import com.wipro.cartms.entity.LineItem;
import com.wipro.cartms.exception.ItemNotFoundException;
import com.wipro.cartms.repository.LineItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemService implements ILineItemService{

    @Autowired
    private LineItemRepo itemRepo;

    @Override
    public void addItem(LineItem item) {
        itemRepo.save(item);
    }

    @Override
    public void deleteItem(int id) throws ItemNotFoundException {
        LineItem item = searchItem(id);
        itemRepo.delete(item);
    }

    @Override
    public void updateItem(int id, LineItem item) throws ItemNotFoundException {
        LineItem currentItem = searchItem(id);
        currentItem.setProductId(item.getProductId());
        currentItem.setProductName(item.getProductName());
        currentItem.setQuantity(item.getQuantity());
        currentItem.setPrice(item.getPrice());
        itemRepo.save(currentItem);
    }

    @Override
    public LineItem searchItem(int id) throws ItemNotFoundException {
        return itemRepo.findById(id)
                .orElseThrow(()-> new ItemNotFoundException("Item Not Found With Id : " + id));
    }
}
