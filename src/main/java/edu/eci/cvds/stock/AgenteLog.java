package edu.eci.cvds.stock;

import org.springframework.stereotype.Component;

@Component
public class AgenteLog implements Agente{
    @Override
    public void modificarProducto(Producto producto) {
        System.out.printf("Producto: %s --> %d unidades disponibles", producto.getNombre(), producto.getCantidad());
    }
}
