package com.soa.flowershop.services;

import com.soa.flowershop.dtos.CreateOrderRequest;
import com.soa.flowershop.dtos.OrderDTO;
import com.soa.flowershop.models.OrderModel;
import com.soa.flowershop.models.OrderProductModel;
import com.soa.flowershop.models.ProductModel;
import com.soa.flowershop.repositories.IOrderProductRepository;
import com.soa.flowershop.repositories.IOrderRepository;
import com.soa.flowershop.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IOrderProductRepository orderProductRepository;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ProductService productService;

    public OrderDTO createOrder(CreateOrderRequest orderRequest){
        OrderModel order = new OrderModel();
        order.setCustomerName(orderRequest.getCustomerName());
        int total = 0;
        List<OrderProductModel> orderProducts = new ArrayList<>();
        for (CreateOrderRequest.CreateOrderProductRequest orderProductRequest : orderRequest.getOrderProducts()) {
            Optional<ProductModel> productOpt = productRepository.findById(orderProductRequest.getProductId());
            if (productOpt.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
            }

            ProductModel product = productOpt.get();
            if (product.getStock() < orderProductRequest.getQuantity()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock insuficiente para el producto: " + product.getName());
            }

            int newStock = product.getStock() - orderProductRequest.getQuantity();
            productService.updateProductStock(product.getId(), newStock);

            OrderProductModel orderProduct = new OrderProductModel();
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProduct.setQuantity(orderProductRequest.getQuantity());
            orderProduct.setPrice(product.getPrice());
            orderProducts.add(orderProduct);

            total += orderProduct.getPrice() * orderProduct.getQuantity();
        }

        order.setTotal(total);
        order.setStatus("PENDIENTE");
        order.setOrderProducts(orderProducts);
        OrderModel savedOrder = orderRepository.save(order);

        return OrderDTO.fromEntity(savedOrder);
    }

    public OrderDTO getOrderById(Long id){
        OrderModel order = orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return OrderDTO.fromEntity(order);
    }

    public ArrayList<OrderModel> getOrders(){
        return (ArrayList<OrderModel>) orderRepository.findAll();
    }

}
