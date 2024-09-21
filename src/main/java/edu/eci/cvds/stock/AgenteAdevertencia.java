package edu.eci.cvds.stock;

import org.springframework.stereotype.Component;

@Component
public class AgenteAdevertencia implements Agente{
    @Override
    public void modificarProducto(Producto producto) {

        System.out.printf("\nALERTA!!! El stock del producto: %s es muy bajo, solo quedan %d unidades\n", producto.getNombre(), producto.getCantidad());
    }
}
