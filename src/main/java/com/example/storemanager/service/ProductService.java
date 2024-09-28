package com.example.storemanager.service;

import com.example.storemanager.dto.request.ProductRequestCreateDTO;
import com.example.storemanager.dto.request.ProductRequestUpdateDTO;
import com.example.storemanager.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(int id);
    void deleteProductById(int id);
    void updateProduct(ProductRequestUpdateDTO product);
    void addProduct(ProductRequestCreateDTO product);
    Double FindxthLagestNumber(int number);
}
