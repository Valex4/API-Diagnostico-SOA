package com.soa.flowershop.services;

import com.soa.flowershop.models.ProductModel;
import com.soa.flowershop.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;

    public ArrayList<ProductModel> getProducts(){
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel createProduct(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public Boolean deleteProduct(Long id){
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }

    public Optional<ProductModel> updateProduct(ProductModel request, Long id){
        Optional<ProductModel> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductModel product = optionalProduct.get();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setStock(request.getStock());

            // Guardar los cambios en la base de datos
            ProductModel updatedProduct = productRepository.save(product);
            return Optional.of(updatedProduct);
        } else {
            return Optional.empty();
        }
    }


    public Optional<ProductModel> updateProductStock(Long id, Integer newStock){
        Optional<ProductModel> productOpt = productRepository.findById(id);
        if(productOpt.isPresent()){
            ProductModel product = productOpt.get();
            product.setStock(newStock);
            return Optional.of(productRepository.save(product));
        }
        return Optional.empty();
    }

    public Optional<ProductModel> getProductById(Long id){
        return productRepository.findById(id);
    }

}
