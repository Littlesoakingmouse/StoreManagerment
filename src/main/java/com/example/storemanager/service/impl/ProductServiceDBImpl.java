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



    }

    @Override
    public void deleteProductById(int id) {

    }

    @Override
    public void updateProduct(ProductRequestUpdateDTO product) {

    }

    @Override
    public void addProduct(ProductRequestCreateDTO product) {

    }
}


