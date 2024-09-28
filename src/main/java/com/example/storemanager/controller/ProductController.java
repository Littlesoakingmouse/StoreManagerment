package com.example.storemanager.controller;

import com.example.storemanager.dto.request.ProductRequestCreateDTO;
import com.example.storemanager.entity.Product;
import com.example.storemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("list")
        public ResponseEntity<?> list() {
            return ResponseEntity.ok(productService.getAllProducts());
        }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ProductRequestCreateDTO dto) {
        productService.addProduct();

    }


}
