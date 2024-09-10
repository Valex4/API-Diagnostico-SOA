package com.soa.flowershop.repositories;

import com.soa.flowershop.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Long> {
}
