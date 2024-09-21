package edu.eci.cvds.stock;

import org.springframework.stereotype.Component;

@Component
public interface Agente {
    void modificarProducto(Producto producto);
}
