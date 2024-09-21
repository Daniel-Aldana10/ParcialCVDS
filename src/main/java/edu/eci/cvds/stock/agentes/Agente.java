package edu.eci.cvds.stock.agentes;

import edu.eci.cvds.stock.modelo.Producto;
import org.springframework.stereotype.Component;

@Component
public interface Agente {
    void modificarProducto(Producto producto);
}
