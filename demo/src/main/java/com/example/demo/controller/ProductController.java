package com.example.demo.controller;


import com.example.demo.dto.CreateProductDto;
import com.example.demo.dto.GetProductListDto;
import com.example.demo.model.Product;
import com.example.demo.model.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    private final ProductService productService;


    /*
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {

        List<Product> result = productRepository.getAll();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
*/

    @GetMapping
    public GetProductListDto getAll(
            @RequestParam(required = false, value = "maxPrice", defaultValue = "-1") double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection
    ) {
        return GetProductListDto.of(productService.query(max, sortDirection));
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.get(id);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProductDto product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.add(product.toProduct()));
    }

    @PutMapping("/{id}")
    public Product edit(
            @RequestBody Product product,
            @PathVariable("id") Long productId) {

        return productService.edit(productId, product);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
