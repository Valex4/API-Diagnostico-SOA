package com.soa.flowershop.dtos;

import java.util.List;

public class CreateOrderRequest {
    private String customerName;
    private List<CreateOrderProductRequest> orderProducts;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CreateOrderProductRequest> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<CreateOrderProductRequest> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public static class CreateOrderProductRequest{
        private int quantity;
        private Long productId;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }
    }
}
