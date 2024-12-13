package com.example.ejerciciodto.producto;

import java.util.List;

public record GetProductDto(
        String nombre,
        double pvp,
        String imagen,
        String categoria
) {

    public static GetProductDto ofProducto(Producto producto) {
        return new GetProductDto(
                producto.getNombre(),
                producto.getPvp(),
                producto.getImagenes().get(0),
                producto.getCategoria().getNombre()
        );
    }
}

