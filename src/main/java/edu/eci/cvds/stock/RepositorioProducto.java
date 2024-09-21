package edu.eci.cvds.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Component
public class RepositorioProducto {
    private final Agente log;
    private final Agente advertencia;
    private HashMap<String, Producto> productos = new HashMap<>();
    public RepositorioProducto(@Qualifier("agenteLog") Agente aglog, @Qualifier("agenteAdvertencia") Agente agadvertencia){
        this.log = aglog;
        this.advertencia = agadvertencia;
    }

    /**
     * Método que agrega un producto al stock, si el precio o la cantidad es menor o igual a cero, no se agrega el producto y
     * se devuelve null, si el producto ya se encuentra solo se le suma uno mas a la cantidad, por ultimo se agrega y se retorna
     * el producto para saber que se agrego correctamente
     * @param producto es el producto que se va  a agregar al stock
     * @return Producto es el producto a agregar al stock
     */
    public Producto agregarProducto(Producto producto){
        if(producto.getPrecio() <= 0 || producto.getCantidad() <= 0){
            return null;
        }
        if(productos.containsKey(producto.getNombre())){
            int cantidad = producto.getCantidad() + 1;
            producto.setCantidad(cantidad);
        }
        productos.put(producto.getNombre(), producto);
        return producto;
    }
    /**
     * Método que modifica un producto en stock, si la cantidad es menor o igual a cero no se permite modificar y se retornar null,
     * ademas que si el nombre del producto no se encuentra en el stock tambien se debera retornar null, si se puede modificar se devuelve el
     * producto identificado con ese nombre, ademas se le debe informar a los agentes
     * @param nombre es el identificador del producto
     * @param cantidad es la cantidad en stock que hay del producto
     * @return Producto si se pudo lograr se devuelve el producto al que hace referencia el nombre.
     */
    public Producto modificarProducto(String nombre, int cantidad){
        if(cantidad < 0 || !productos.containsKey(nombre)){
            return null;
        }
        Producto producto = productos.get(nombre);
        producto.setCantidad(cantidad);
        informarAgentes(producto);
        return producto;
    }
    /**
     * Método que elimina un producto en stock, si el producto no estaba en stock se retorna null,
     * de lo contrario se eliminara con normalidad del stock
     * @param producto producto a eliminar
     * @return Producto si se pudo lograr se devuelve el producto al que hace referencia el nombre.
     */
    public Producto eliminarProducto(Producto producto){
        if(productos.containsKey(producto.getNombre())){
            productos.remove(producto.getNombre());
            return producto;
        }
        return null;

    }
    /**
     * Metodo que ayuda a implementar el patron de diseño, en donde se les pasara el producto a los diferntes agentes
     * para que puedan actuar segun sea lo requerido
     * @param producto el producto que fue modificado correctamente
     */
    private void informarAgentes(Producto producto){
        log.modificarProducto(producto);
        advertencia.modificarProducto(producto);
    }
}
