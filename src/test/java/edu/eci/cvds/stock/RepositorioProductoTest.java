package edu.eci.cvds.stock;

import edu.eci.cvds.stock.agentes.AgenteAdevertencia;
import edu.eci.cvds.stock.agentes.AgenteLog;
import edu.eci.cvds.stock.modelo.Producto;
import edu.eci.cvds.stock.persistencia.RepositorioProducto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RepositorioProductoTest {
    private RepositorioProducto repositorioProducto = new RepositorioProducto(new AgenteLog(), new AgenteAdevertencia());
    @Test
    void shouldAddProduct(){
        Producto producto = new Producto("Arroz",1,1,"Basico");
        assertEquals(producto, repositorioProducto.agregarProducto(producto));
    }
    @Test
    void shouldSumCantidadProduct(){
        Producto producto = new Producto("Arroz",1,1,"Basico");
        repositorioProducto.agregarProducto(producto);
        assertEquals(producto, repositorioProducto.agregarProducto(producto));
    }
    @Test
    void shouldNotProductByPrecioIncorrect(){
        Producto producto = new Producto("Xbox",-1,1,"Videojuegos");
        assertNull(repositorioProducto.agregarProducto(producto));
    }
    @Test
    void shouldNotProductByCantidadIncorrect() {
        Producto producto = new Producto("Celular",5,-1,"Electricos");
        assertNull(repositorioProducto.agregarProducto(producto));
    }
    @Test
    void shouldUpdateProduct(){
        Producto producto = new Producto("Relojes", 5, 4, "Moda");
        repositorioProducto.agregarProducto(producto);
        producto.setCantidad(1);
        assertEquals(producto, repositorioProducto.modificarProducto("Relojes", 1));
    }
    @Test
    void shouldNotUpdateProductByCantidadIncorrect(){
        Producto producto = new Producto("Relojes", 5, 4, "Moda");
        repositorioProducto.agregarProducto(producto);
        assertNull(repositorioProducto.modificarProducto("Relojes", -1));
    }
    @Test
    void shouldNotUpdateProductBecauseNotExist(){
        assertNull(repositorioProducto.modificarProducto("Zapatos", 5));
    }
    @Test
    void shouldDeleteProduct(){
        Producto producto = new Producto("Lapiz", 10, 4, "Escolar");
        repositorioProducto.agregarProducto(producto);
        assertEquals(producto, repositorioProducto.eliminarProducto(producto));
    }
    @Test
    void shouldNotDeleteProductBecauseNotExist(){
        Producto producto = new Producto("Portatil", 10, 4, "Electricos");
        assertNull(repositorioProducto.eliminarProducto(producto));
    }



}
