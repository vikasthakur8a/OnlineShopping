package com.wipro.orderms.repository;

import com.wipro.orderms.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {
}
