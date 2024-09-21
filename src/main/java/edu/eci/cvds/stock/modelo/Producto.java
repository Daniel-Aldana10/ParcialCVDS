package edu.eci.cvds.stock.modelo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Producto {
    private String nombre;
    private int precio;
    private int cantidad;
    private String categoria;
    public Producto(String nombre, int precio, int cantidad, String categoria){
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
        this.categoria=categoria;
    }

}
