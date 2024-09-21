package edu.eci.cvds.stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositorioProductoTest {
    private RepositorioProducto repositorioProducto;
    @Test
    void shouldAddProduct(){
        Producto producto = new Producto("Arroz",1,1,"Basico");
        assertEquals(producto, repositorioProducto.agregarProducto(producto));

    }
}
