package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    /*
    Este código
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Es equivalente a la anotación @RequiredArgsConstructor y al private final de aquí abajo
    */

    private final ProductRepository productRepository;


    @GetMapping
    public ResponseEntity<List<Product>> getAll() {

        List<Product> result = productRepository.getAll();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.add(product));
    }
}
