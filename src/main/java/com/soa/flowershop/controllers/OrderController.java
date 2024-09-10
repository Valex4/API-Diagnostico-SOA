package com.soa.flowershop.controllers;

import com.soa.flowershop.dtos.CreateOrderRequest;
import com.soa.flowershop.dtos.OrderDTO;
import com.soa.flowershop.models.OrderModel;
import com.soa.flowershop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody @Validated CreateOrderRequest orderRequest){
       OrderDTO createOrder = orderService.createOrder(orderRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Long id){
        OrderDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ArrayList<OrderModel> getOrders(){
        return this.orderService.getOrders();
    }
}
