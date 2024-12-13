package com.example.ejerciciodto.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private double pvp;
    private List<String> imagenes;
    private Categoria categoria;
}
