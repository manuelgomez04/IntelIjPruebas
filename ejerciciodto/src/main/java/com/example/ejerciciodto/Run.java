package com.example.ejerciciodto;

import com.example.ejerciciodto.alumno.Alumno;
import com.example.ejerciciodto.alumno.Curso;
import com.example.ejerciciodto.alumno.Direccion;
import com.example.ejerciciodto.alumno.GetAlumnoDto;
import com.example.ejerciciodto.producto.Categoria;
import com.example.ejerciciodto.producto.GetProductDto;
import com.example.ejerciciodto.producto.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Run {
    @PostConstruct
    public static void main(String[] args) {
        //PRODUCTO
        Categoria categoria = new Categoria(1L, "Electrónica");
        Producto producto = Producto.builder()
                .id(1L)
                .nombre("Smartphone")
                .descripcion("Un smartphone de última generación")
                .pvp(699.99)
                .imagenes(Arrays.asList("imagen1.jpg", "imagen2.jpg"))
                .categoria(categoria)
                .build();

        GetProductDto productoDTO = GetProductDto.ofProducto(producto);

        //ALUMNO
        Direccion direccion = Direccion.builder()
                .id(1L)
                .tipoVia("Calle")
                .linea1("123 Main St")
                .linea2("Apt 4B")
                .cp("12345")
                .poblacion("Ciudad")
                .provincia("Provincia")
                .build();

        Curso curso = Curso.builder()
                .id(1L)
                .nombre("Matemáticas")
                .tipo("Ciencias")
                .tutor("Dr. Smith")
                .aula("Aula 101")
                .build();

        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("Juan")
                .apellido1("Pérez")
                .apellido2("García")
                .email("juan.perez@example.com")
                .curso(curso)
                .direccion(direccion)
                .build();


        GetAlumnoDto alumnoDTO = GetAlumnoDto.ofAlumno(alumno);

        System.out.println(productoDTO);
        System.out.println(alumnoDTO);


    }
}
