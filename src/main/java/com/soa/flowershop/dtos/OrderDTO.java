package com.soa.flowershop.dtos;

import com.soa.flowershop.models.OrderModel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {
    private long id;
    private String customerName;
    private Integer total;
    private String status;
    private Date createdAt;
    private List<OrderProductDTO> orderProducts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public static OrderDTO fromEntity(OrderModel order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setTotal(order.getTotal());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setOrderProducts(order.getOrderProducts().stream()
                .map(OrderProductDTO::fromEntity)
                .collect(Collectors.toList()));
        return dto;
    }
}
