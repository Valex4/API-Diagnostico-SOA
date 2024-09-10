package com.soa.flowershop.dtos;

import com.soa.flowershop.models.OrderProductModel;

public class OrderProductDTO {
    private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;

    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static OrderProductDTO fromEntity(OrderProductModel orderProduct) {
        OrderProductDTO dto = new OrderProductDTO();
        dto.setId(orderProduct.getId());
        dto.setProductId(orderProduct.getProduct().getId());
        dto.setProductName(orderProduct.getProduct().getName());
        dto.setQuantity(orderProduct.getQuantity());
        dto.setPrice(orderProduct.getPrice());
        return dto;
    }
}
