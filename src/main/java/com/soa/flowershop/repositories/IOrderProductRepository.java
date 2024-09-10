package com.soa.flowershop.repositories;

import com.soa.flowershop.models.OrderProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProductModel, Long> {
}
