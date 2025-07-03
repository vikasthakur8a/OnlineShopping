package com.wipro.cartms.repository;

import com.wipro.cartms.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {
}
