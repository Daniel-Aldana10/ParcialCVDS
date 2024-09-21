package edu.eci.cvds.stock;

import org.springframework.stereotype.Component;

@Component
public class AgenteLog implements Agente{
    @Override
    public void modificarProducto(Producto producto) {
        System.out.printf("\nProducto: %s --> %d unidades disponibles\n", producto.getNombre(), producto.getCantidad());
    }
}
