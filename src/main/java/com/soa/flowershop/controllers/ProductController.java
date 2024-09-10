package com.soa.flowershop.controllers;


import com.soa.flowershop.models.ProductModel;
import com.soa.flowershop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<ProductModel> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel request){
        return this.productService.createProduct(request);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getProductById(@PathVariable("id") Long id){
        return this.productService.getProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean result = this.productService.deleteProduct(id);
        if(result){
            return ("Product deleted successfully");
        }else{
            return ("Have a problem deleting product");
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel request, @PathVariable("id") Long id ){
        Optional<ProductModel> updateProduct = this.productService.updateProduct(request, id);
        return updateProduct.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }


    @PatchMapping(path = "/{id}/stock")
    public ResponseEntity<ProductModel> updateProductStock(@RequestBody Map<String, Integer> stockUpdate, @PathVariable("id") Long id){
        if(!stockUpdate.containsKey("stock")){
            return ResponseEntity.badRequest().build();
        }

        Optional<ProductModel> updatedProduct = this.productService.updateProductStock(id, stockUpdate.get("stock"));
        return updatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
