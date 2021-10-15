package com.niit.springsmartaccessories.repositories;

import com.niit.springsmartaccessories.models.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}
