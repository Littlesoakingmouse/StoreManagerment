package com.example.storemanager.service.impl;


import com.example.storemanager.dto.request.ProductRequestCreateDTO;
import com.example.storemanager.dto.request.ProductRequestUpdateDTO;
import com.example.storemanager.dto.response.ProductResponse;
import com.example.storemanager.entity.Product;
import com.example.storemanager.responsitory.ProductReponsitory;
import com.example.storemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDBImpl implements ProductService {

    @Autowired
    private ProductReponsitory productReponsitory;


    @Override
    public List<ProductResponse> getAllProducts() {
        return productReponsitory.findAll().stream().map(product -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setAmount(product.getAmount());
            return productResponse;
        }).toList();
    }

    @Override
    public ProductResponse getProductById(int id) {
        Product product = productReponsitory.findById(id).orElse(null);
        if(product == null){
            throw new RuntimeException("Product Not Found!");
        }
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setAmount(product.getAmount());
        return productResponse;
    }

    @Override
    public void deleteProductById(int id) {
        Optional<Product> productOptional = productReponsitory.findById(id);
        productOptional.ifPresent(product -> productReponsitory.delete(product));
    }

    @Override
    public void updateProduct(ProductRequestUpdateDTO dto) {
        Product product = productReponsitory.findById(dto.getId()).orElse(null);
        if(product == null){
            throw new RuntimeException("Product Not Found!");
        }
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmount(product.getAmount());
        productReponsitory.save(product);
    }

    @Override
    public void addProduct(ProductRequestCreateDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmount(product.getAmount());
        productReponsitory.save(product);

    }

    @Override
    public Double FindxthLagestNumber(int number) {
        return productReponsitory.findNthLargestPrice(number - 1);
    }
}


