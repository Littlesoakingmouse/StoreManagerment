package com.example.storemanager.controller;

import com.example.storemanager.dto.request.ProductRequestCreateDTO;
import com.example.storemanager.dto.request.ProductRequestUpdateDTO;
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
        productService.addProduct(dto);
        return ResponseEntity.ok("Create product successfully");
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody ProductRequestUpdateDTO dto) {
        productService.updateProduct(dto);
        return ResponseEntity.ok("Update product successfully");
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Delete product successfully");
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("find/{number}")
    public ResponseEntity<?> find(@PathVariable Integer number) {
        return ResponseEntity.ok(productService.FindxthLagestNumber(number));
    }

}
