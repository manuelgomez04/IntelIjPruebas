package com.example.demo.error;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long id) {
        super("No hay productos con ese ID: " + id);
    }

    public ProductNotFoundException() {
        super("No hay productos con esos requisitos de búsqueda");
    }
}
