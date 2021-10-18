package com.niit.springsmartaccessories.repositories;

import com.niit.springsmartaccessories.models.ShipOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<ShipOrder, Long> {
}
